package listener;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



@WebListener
public class ContextListener implements ServletContextListener {
    public ContextListener()
    {	}
    public void contextDestroyed(ServletContextEvent event)  
    {	}
    public void contextInitialized(ServletContextEvent event)  { 
    	Properties properties = new Properties();
    	ServletContext context = event.getServletContext();
    	Enumeration<String> e = context.getInitParameterNames();
    	while(e.hasMoreElements()){
    		String name = e.nextElement();
    		String value = context.getInitParameter(name);
    		properties.setProperty(name, value);
    	}
    	Factory.setContextProperties(properties);
    }
}
