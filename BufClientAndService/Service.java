package BufClientAndService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** 
* @author quchengguo
* @version 2018年3月7日 下午7:33:19 
* 服务器端接收用户名和密码并且将登陆状态返回给客户端
*/
public class Service {
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(8091);
		Socket socket = ss.accept();
		
		// 读取客户端数据
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String username = bufferedReader.readLine();
		String password = bufferedReader.readLine();
		
		// 返回给客户端数据
		boolean flag = false;
		if("qcg".equals(username) && "123".equals(password)){
			flag = true;
		}
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		if(flag){
			pw.println("登陆成功");
		}else{
			pw.println("登陆失败");
		}
		
		pw.close();
		bufferedReader.close();
	}
}
