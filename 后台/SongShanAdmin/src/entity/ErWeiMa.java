package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;
import com.spire.barcode.QRCodeDataMode;
import com.spire.barcode.QRCodeECL;

public class ErWeiMa {

	public static void main(String[] args) {

		//创建BarcodeSettings实例
		BarcodeSettings settings = new BarcodeSettings();
		//设置条码类型为QR二维码
		settings.setType(BarCodeType.QR_Code);       
		//设置二维码数据
		settings.setData("<input type='text'/>");
		//设置二维码显示数据
		settings.setData2D("<input type='text'/>");     
		//设置数据类型
		settings.setQRCodeDataMode(QRCodeDataMode.Alpha_Number);
		//设置二维码模型宽度
		settings.setX(5.0f);
		//设置二维码纠错级别
		settings.setQRCodeECL(QRCodeECL.H);

		//创建BarCodeGenerator实例
		BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
		//根据settings生成图像数据，保存至BufferedImage实例
		BufferedImage bufferedImage = barCodeGenerator.generateImage();
		//保存为PNG图片
		try {
			File f = new File("E:\\FFOutput\\QRCode.png");
			System.out.println(f.getPath());
			ImageIO.write(bufferedImage, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
