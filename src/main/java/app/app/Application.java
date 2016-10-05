package app.app;

import app.app.http.MyHttpHandler;
import app.app.http.ParameterFilter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by pcmagas on 5/10/2016.
 */
public class Application
{
    public static void main(String[] args)
    {
        try
        {
            HttpServer server = HttpServer.create(new InetSocketAddress(8082),0);

            HttpContext context=server.createContext("/checker", new MyHttpHandler());
            context.getFilters().add(new ParameterFilter());

            server.setExecutor(null); // creates a default executor
            server.start();
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
