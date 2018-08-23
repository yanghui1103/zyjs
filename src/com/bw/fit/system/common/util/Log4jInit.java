package com.bw.fit.system.common.util;


import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
  
import org.apache.log4j.PropertyConfigurator;  
  
  
public class Log4jInit extends HttpServlet {     
    public void init(ServletConfig config) throws ServletException {  
        String prefix = config.getServletContext().getRealPath("/");  
        String file = config.getInitParameter("log4j"); 
        System.setProperty("webappHome", prefix);  
        if (file != null) {
            PropertyConfigurator.configure(prefix + file);   
        }  
    }  
}  
