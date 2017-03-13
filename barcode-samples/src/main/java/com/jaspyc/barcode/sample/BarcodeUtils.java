package com.jaspyc.barcode.sample;

import java.io.File;
import java.nio.file.Files;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class BarcodeUtils {

	public static byte[] createByteImage(String code) {
		byte[] byteImage = null;

		try {
			File file = File.createTempFile(code + ".png", ".tmp");
			
			Barcode barcode = BarcodeFactory.createCode128(code);
			barcode.setFont(null);
			barcode.setDrawingQuietSection(false);
			barcode.setResolution(600);
			barcode.setBarWidth(8);

			BarcodeImageHandler.savePNG(barcode, file);
			
			byteImage = Files.readAllBytes(file.toPath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return byteImage;
	}
	
	public static String byteImageToBase64(byte[] byteImage) {
		return new StringBuilder()
			.append("data:image/png;base64,")
			.append(StringUtils.newStringUtf8(Base64.encodeBase64(byteImage, false)))
			.toString();
	}
	
	public static String createBase64(String code) {
		return byteImageToBase64(createByteImage(code));
	}
	
}
