package com.company;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ControllerServer {

    private static Model model = new Model();

    public ControllerServer(){
        this.start();
    }

    private void start(){
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(1400), 0);
            HttpContext context = server.createContext("/SinaRenderer" );
            context.setHandler(ControllerServer::handleRequest);
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void handleRequest(HttpExchange exchange) throws IOException, IOException {
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody() , StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        int b ;
        StringBuilder buf = new StringBuilder(512);
        while((b = br.read() ) != -1){
            buf.append(((char) b ));
        }
        br.close();
        isr.close();

        System.out.println(" " + buf);

        String response = model.body() ;

        exchange.getResponseHeaders().add("Access-Control-Allow-Origin" , "*");

        if(exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")){
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods" , "GET, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers" , "Content-Type,Authorization");
            exchange.sendResponseHeaders(204,-1);
            return ;
        }

        exchange.sendResponseHeaders(200 , response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }


    public Model getModel(){
        return model ;
    }

    public Model Model(){
        return model ;
    }


}
