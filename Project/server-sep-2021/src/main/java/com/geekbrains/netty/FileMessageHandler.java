package com.geekbrains.netty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.geekbrains.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileMessageHandler extends SimpleChannelInboundHandler<Command> {

   private static Path currentPath;
   public FileMessageHandler() throws IOException {
       currentPath = Paths.get("server-sep-2021","root");
       if(!Files.exists(currentPath)){
           Files.createDirectory(currentPath);
       }
   }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       ctx.writeAndFlush(new ListResponse(currentPath));
       ctx.writeAndFlush(new PathInResponse(currentPath.toString()));
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Command cmd) throws Exception {

       log.debug("received: {}", cmd.getType());
       switch (cmd.getType()) {
           case FILE_REQUEST:
               FileRequest fileRequest = (FileRequest) cmd;
               FileMessage msg = new FileMessage(currentPath.resolve(fileRequest.getName()));
               ctx.writeAndFlush(new ListResponse(currentPath));
               break;

           case FILE_MESSAGE:
               FileMessage message = (FileMessage) cmd;
               Files.write(currentPath.resolve(message.getName()), message.getBytes());
               ctx.writeAndFlush(new ListResponse(currentPath));
               break;
           case LIST_REQUEST:
               ctx.writeAndFlush(new ListResponse(currentPath));
               break;
           case PATH_UP_REQUEST:
               if (currentPath.getParent() != null)
               {
                   currentPath = currentPath.getParent();
               }
               ctx.writeAndFlush(new PathInResponse(currentPath.toString()));
               ctx.writeAndFlush(new ListResponse(currentPath));
               break;
           case PATH_REQUEST:
               PathInRequest request = (PathInRequest) cmd;
               Path newPath=currentPath.resolve(request.getDir());
               if (Files.isDirectory(newPath))
               {
                   currentPath = newPath;
                   ctx.writeAndFlush(new PathInResponse(currentPath.toString()));
                   ctx.writeAndFlush(new ListResponse(currentPath));
               }
               break;

        }

    }
}
