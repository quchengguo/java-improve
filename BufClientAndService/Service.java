package BufClientAndService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** 
* @author quchengguo
* @version 2018��3��7�� ����7:33:19 
* �������˽����û��������벢�ҽ���½״̬���ظ��ͻ���
*/
public class Service {
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(8091);
		Socket socket = ss.accept();
		
		// ��ȡ�ͻ�������
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String username = bufferedReader.readLine();
		String password = bufferedReader.readLine();
		
		// ���ظ��ͻ�������
		boolean flag = false;
		if("qcg".equals(username) && "123".equals(password)){
			flag = true;
		}
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		if(flag){
			pw.println("��½�ɹ�");
		}else{
			pw.println("��½ʧ��");
		}
		
		pw.close();
		bufferedReader.close();
	}
}
