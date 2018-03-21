package my_http_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by quchengguo on 2018/3/21.
 * 模拟Servlet自定义一个客户端
 */
public class HTTPClient {
    public static void main(String[] args) {
        System.out.println("客户端启动...");
        String uri = "index.html";
        doGet("localhost", 8080, uri);
    }

    /**
     * 按照GET请求方式访问HTTPServer
     */
    public static void doGet(String host, int port, String uri){
        Socket socket = null;
        try{
            socket = new Socket(host, port);
            // 1.创建HTTP请求
            StringBuffer sb = new StringBuffer("GET " + uri + " HTTP/1.1\r\n");
            // 2.创建请求头
            sb.append("Accept: */*\r\n");
            sb.append("Accept-Language: zh-cn\r\n");
            sb.append("Accept-Encoding: gzip, deflate\r\n");
            sb.append("User-Agent: HTTPClient\r\n");
            sb.append("Host: localhost:8080\r\n");
            sb.append("Connection: Keep-Alive\r\n\r\n");

            // 3.发送http请求
            OutputStream socketOut = socket.getOutputStream();
            socketOut.write(sb.toString().getBytes());

            Thread.sleep(2000);

            // 4.接收响应结果
            InputStream socketIn = socket.getInputStream();
            // 返回此输入流下一个方法调用可以不受阻塞地从此输入流读取（或跳过）的估计字节数
            int size = socketIn.available();
            byte[] buffer = new byte[size];
            socketIn.read(buffer);
            System.out.println(new String(buffer));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
