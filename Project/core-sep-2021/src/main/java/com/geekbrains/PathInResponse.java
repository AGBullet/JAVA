package com.geekbrains;

public class PathInResponse extends Command{
    private final String path;

    public PathInResponse(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public CommandType getType() {
        return CommandType.PATH_RESPONSE;
    }
}
