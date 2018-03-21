package my_http_server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by quchengguo on 2018/3/21.
 * 模拟Servlet自定义个服务器端
 */
public class HTTPServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket;
        System.out.println("服务器启动...");
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("服务器正在监听端口:" + serverSocket.getLocalPort());
            while (true){
                final Socket socket = serverSocket.accept();
                System.out.println("建立了与客户端的一个新的TCP连接， 该客户的地址为：" + socket.getInetAddress() + ":" + socket.getPort());
                service(socket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 响应客户端的HTTP请求
     */
    public static void service(Socket socket) throws Exception{
        // 1.读取请求信息
        InputStream socketIn = socket.getInputStream();
        Thread.sleep(500);

        // avaliable获取流中可读字节的长度
        int size = socketIn.available();
        byte[] buffer = new byte[size];
        socketIn.read(buffer);
        String request = new String(buffer);
        System.out.println("*****request start*****");
        System.out.println(request);
        System.out.println("*****request end*****");

        // 2.解析http请求
        // 获得http请求的第一行，每行的末尾都有\r\n
        String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
        String[] parts = firstLineOfRequest.split(" ");
        System.out.println("parts: " + Arrays.toString(parts));
        String uri = parts[1];

        // 3.决定http响应正文的类型
        String contentType;
        if(uri.indexOf("html") != -1 || uri.indexOf("htm") != -1){
            contentType = "text/html";
        }else if(uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1){
            contentType = "image/jpeg";
        }else if(uri.indexOf("gif") != -1) {
            contentType = "image/gif";
        }else {
            contentType = "application/octet-stream";
        }
        // 4.创建http的响应结果
        //  http响应的第一行
        String reponseFirstLine = "HTTP/1.1 200 OK \r\n";
        // http响应头
        String reponseHeader = "Content-Type:" + contentType + "\r\n\r\n";
        // 获得读取响应正文的输入流，服务器读取自己的资源然后将资源返回给客户端，uri是相对路径
        InputStream in = HTTPServer.class.getResourceAsStream(uri);
        // 5.发送http响应结果
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(reponseFirstLine.getBytes());
        socketOut.write(reponseHeader.getBytes());
        int len = 0;
        buffer = new byte[128];
        while ((len = in.read(buffer)) != -1){
            socketOut.write(buffer, 0, len);
        }
        Thread.sleep(1000);
        socket.close();
    }
}
