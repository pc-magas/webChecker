package app.app;

import app.app.http.MyHttpHandler;
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
            server.createContext("/checker", new MyHttpHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
