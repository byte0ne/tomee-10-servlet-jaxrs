package com.example.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/*")
public class WildcardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String path = req.getRequestURI().substring(req.getContextPath().length());
        
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Wildcard Servlet Captured: " + path + "</h1>");
        
        if (path.startsWith("/api/")) {
            resp.getWriter().println("<p style='color:red'>ERROR: Wildcard servlet incorrectly captured an API request!</p>");
        }
        
        resp.getWriter().println("</body></html>");
    }
}