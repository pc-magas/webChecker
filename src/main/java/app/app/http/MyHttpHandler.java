package app.app.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by pcmagas on 5/10/2016.
 */
public class MyHttpHandler implements HttpHandler
{
    public void handle(HttpExchange t) throws IOException
    {
        InputStream is = t.getRequestBody();
//        read(is); // .. read the request body
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
