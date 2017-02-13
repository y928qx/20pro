package com.sanqing.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ���ļ�����ת��Ϊbyte[]
 */
public class FileToByte {
	public static byte[] getBytesFromFile(File f) {
		if (f == null) { //����ļ�Ϊnullֱ�ӷ���һ��null
			return null;
		}
		try {
			FileInputStream stream = new FileInputStream(f);//��ʼ��һ���ļ�������
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);//��ʼ��һ���ֽ����������
			byte[] b = new byte[1000];//���û���Ϊ1000
			int n;
			while ((n = stream.read(b)) != -1)
				//ѭ����ȡ�ļ���Ϣ
				out.write(b, 0, n);//д�뵽�ֽ�����������С�
			stream.close();//�ر�������
			out.close();//�ر������
			return out.toByteArray();//����������е��ֽ�����
		} catch (IOException e) {
		}
		return null;
	}
}
