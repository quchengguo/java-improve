package BufClientAndService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/** 
* @author quchengguo
* @version 2018��3��7�� ����7:14:28 
* ʹ��bufferReader�Ӽ���¼���û��������뷢�ͷ����������շ�����Ϣ
*/
public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("chengguo", 8091);
		// ����¼��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String username = br.readLine();
		System.out.println("���������룺");
		String password = br.readLine();
		
		// д������
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		printWriter.println(username);
		printWriter.println(password);
		
		// ���շ���(��ȡ���е�����)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String receive = bufferedReader.readLine();
		System.out.println(receive);
		
		socket.close();
		
	}
}
