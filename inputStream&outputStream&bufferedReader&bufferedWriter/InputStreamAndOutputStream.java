package com.study.copyfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/*
* @author quchengguo
* @version 2018年5月6日 下午7:13:09
*/
public class InputStreamAndOutputStream {

	public static void main(String[] args) throws Exception{
		InputStream input = new FileInputStream("E:\\java课程笔记.pdf");
		OutputStream output = new FileOutputStream("E:\\java课程笔记copy.pdf");
		
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = input.read(buf)) != -1) {
			output.write(buf, 0, len);
		}
		
		output.close();
		input.close();
		
		System.out.println("拷贝文件成功!");
	}

}
