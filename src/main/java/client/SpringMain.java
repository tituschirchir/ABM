package client;

import config.AppConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringMain {
    public static void main(String[] args) throws Exception {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        ServletHolder sh = new ServletHolder(new DispatcherServlet(context));
        ServletContextHandler sch = new ServletContextHandler();
        sch.setContextPath("/");
        sch.addServlet(sh, "/*");
        sch.addFilter(filter(), "/*", null);

        Server server = new Server(1213);
        server.setHandler(sch);
        server.start();
    }

    private static FilterHolder filter() {
        FilterHolder filterHolder = new FilterHolder(CrossOriginFilter.class);
        filterHolder.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER, "true");
        filterHolder.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_EXPOSE_HEADERS_HEADER, "Content-Type");
        filterHolder.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_HEADERS_HEADER, "GET, OPTIONS, POST, PUT, DELETE");
        return filterHolder;
    }
}
