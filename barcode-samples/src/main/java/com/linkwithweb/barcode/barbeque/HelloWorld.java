
/**
*
*/
package com.linkwithweb.barcode.barbeque;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 * @author kumara
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorld();
		try {
			helloWorld.outputtingBarcodeAsPNG();
		} catch (BarcodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void usingBarbecueAsSwingComponent() {
		// Always get a Barcode from the BarcodeFactory
		Barcode barcode = null;
		try {
			barcode = BarcodeFactory.createCode128B("1234567890123456");
		} catch (BarcodeException e) {
			// Error handling
		}
	}

	public void drawingBarcodeDirectToGraphics() throws BarcodeException, OutputException {
		// Always get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128B("1234567890123456");

		// We are created an image from scratch here, but for printing in Java,
		// your
		// print renderer should have a Graphics internally anyway
		BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_BYTE_GRAY);
		// We need to cast the Graphics from the Image to a Graphics2D - this is
		// OK
		Graphics2D g = (Graphics2D) image.getGraphics();

		// Barcode supports a direct draw method to Graphics2D that lets you
		// position the
		// barcode on the canvas
		barcode.draw(g, 10, 56);
	}

	public void outputtingBarcodeAsPNG() throws BarcodeException {
		// get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128("1234567890123456");

		try {
			File f = new File("mybarcode.png");

			// Let the barcode image handler do the hard work
			BarcodeImageHandler.savePNG(barcode, f);
		} catch (Exception e) {
			// Error handling here
		}
	}
}