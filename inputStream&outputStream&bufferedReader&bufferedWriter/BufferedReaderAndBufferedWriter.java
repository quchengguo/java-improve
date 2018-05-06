package com.study.copyfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
* @author quchengguo
* @version 2018年5月6日 下午7:08:02
* 
*/
public class BufferedReaderAndBufferedWriter {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("E:\\feedback.htm"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\feedbackcopy.htm"));
		
		String line =  null;
		while(null != (line = reader.readLine())) {
			writer.write(line);
		}
		
		writer.close();
		reader.close();
		
		System.out.println("拷贝文件成功");
	}

}
