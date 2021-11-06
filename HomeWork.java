package com.geekbrains.app;

import com.sun.javafx.collections.MappingChange;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
@WebServlet(name = "HomeWork", urlPatterns = "/hw")
public class HomeWork extends HttpServlet {
    private static Logger logger = (Logger) LoggerFactory.getLogger(HomeWork.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Integer> map = initmap();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            Product p = new Product(i+1,(String) map.keySet().toArray()[i],map.get((String) map.keySet().toArray()[i]));
            resp.getWriter().printf("<h3>" + String.format("%d. %s = %d", p.getId(),p.getTitle(),p.getCost())+".rub </h3>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();

    }

    private Map<String, Integer> initmap() {
        Map<String ,Integer> map = new LinkedHashMap<>();
        map.put("Продукт 1",10);
        map.put("Продукт 2",20);
        map.put("Продукт 3",30);
        map.put("Продукт 4",40);
        map.put("Продукт 5",50);
        map.put("Продукт 6",60);
        map.put("Продукт 7",70);
        map.put("Продукт 8",80);
        map.put("Продукт 9",90);
        map.put("Продукт 10",100);
        return map;
    }
}
