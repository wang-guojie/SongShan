package unit;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;
import com.spire.barcode.QRCodeDataMode;
import com.spire.barcode.QRCodeECL;

import entity.Goods;
import entity.Ticket;

public class ErWeiMa {
	
	private Ticket ti;
	
	public ErWeiMa() { }
	
	public ErWeiMa(Ticket ticket) {
		this.ti = ticket;
	}
	
	// 获取配置文件代码
	// String url = getServletConfig().getServletContext().getInitParameter("url"); 
	
	// 拼接数据
	public String text(){
		
		String text = "嵩山旅游官网预定\n商品名称：" + ti.getGoods().getGoodName() + 
				"\n预订人：" + ti.getUser() + "\n预订数量：" + ti.getBuyCount() + 
				"\n预定日期：" + ti.getBeginTime() + "\n结束日期：" + ti.getEndTime() +
				"\n总金额：￥" + ti.getMoney();
		
		return text;
	}
	
	public String ok(String realPath){
		//创建BarcodeSettings实例
		BarcodeSettings settings = new BarcodeSettings();
		//设置条码类型为QR二维码
		settings.setType(BarCodeType.QR_Code);
		//设置二维码数据
		settings.setData(text());
		//设置二维码显示数据
		settings.setData2D("嵩山少林寺预定票");
		//设置数据类型
		settings.setQRCodeDataMode(QRCodeDataMode.Alpha_Number);
		//设置二维码模型宽度
		settings.setX(2.0f);
		//设置二维码纠错级别
		settings.setQRCodeECL(QRCodeECL.H);

		//创建BarCodeGenerator实例
		BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
		//根据settings生成图像数据，保存至BufferedImage实例
		BufferedImage bufferedImage = barCodeGenerator.generateImage();
		//保存为PNG图片
		try {
			// 将当前系统时间的年月日拼成上传的文件名
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat( "yyyyMMdd_hhmmss");
			String fileName = ft.format(dNow) + ".png";
			File f = new File(realPath + "/" + fileName);
			System.out.println(f.getPath());
			ImageIO.write(bufferedImage, "png", f);
			return "/upload/" + fileName;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
