package BufClientAndService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/** 
* @author quchengguo
* @version 2018年3月7日 下午7:14:28 
* 使用bufferReader从键盘录入用户名和密码发送服务器并接收返回消息
*/
public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("chengguo", 8091);
		// 键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String username = br.readLine();
		System.out.println("请输入密码：");
		String password = br.readLine();
		
		// 写入流中
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		printWriter.println(username);
		printWriter.println(password);
		
		// 接收返回(读取流中的数据)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String receive = bufferedReader.readLine();
		System.out.println(receive);
		
		socket.close();
		
	}
}
