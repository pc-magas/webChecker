package app.app.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;


/**
 * Created by pcmagas on 5/10/2016.
 */
public class MyHttpHandler implements HttpHandler
{
//    static String convertStreamToString(java.io.InputStream is) {
//        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
//        return s.hasNext() ? s.next() : "";
//    }

    public void handle(HttpExchange t) throws IOException
    {
        Map<String, Object> params = (Map<String, Object>)t.getAttribute("post_parameters");

        Object[] paramsAsArray=params.values().toArray();
        String s="";

        for(Object o : paramsAsArray)
        {
            s+=(String)o;
        }

        t.sendResponseHeaders(200, s.length());

        OutputStream os = t.getResponseBody();
        os.write(s.getBytes());
        os.close();
    }
}
