package com.jaspyc.barcode.sample;

public class BarcodeTest {

	public static void main(String[] args) {
		byte[] img = BarcodeUtils.createByteImage("123456789012345678");
		String base64 = BarcodeUtils.byteImageToBase64(img);
		
		System.out.println(base64);
	}
	
}
