package com.bw.fit.system.common.util;
import java.awt.image.BufferedImage;  
import java.awt.image.RenderedImage;  
import java.io.File;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
  
import org.icepdf.core.exceptions.PDFException;  
import org.icepdf.core.exceptions.PDFSecurityException;  
import org.icepdf.core.pobjects.Document;  
import org.icepdf.core.util.GraphicsRenderingHints;  
  
/** 
 * pdf文件转图片(icepdf技术) 
 * 经过验证，发现有些会出现乱码不识别
 * @author yangh 
 * @day 2016-11-03 
 */  
public class PDF2IMGUtil {
	public static void main(String[] args) {  
        String filePath = "D:/21.pdf";  
        Document document = new Document();  
  
        try {  
            document.setFile(filePath);  
            float scale = 1.1f;// 缩放比例（大图）  
            // float scale = 0.2f;// 缩放比例（小图）  
            float rotation = 90f;// 旋转角度  
            for (int i = 0; i < document.getNumberOfPages(); i++) {  
                BufferedImage image = (BufferedImage) document.getPageImage(i,  
                        GraphicsRenderingHints.SCREEN,  
                        org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX,  
                        rotation, scale);  
                RenderedImage rendImage = image;  
                try {  
                    File file = new File("D:/icepdf_a" + i + ".jpg");  
                    // 这里png作用是：格式是jpg但有png清晰度  
                    ImageIO.write(rendImage, "png", file);  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
                image.flush();  
            }  
            document.dispose();  
        } catch (PDFException e1) {  
            e1.printStackTrace();  
        } catch (PDFSecurityException e1) {  
            e1.printStackTrace();  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
        System.out.println("======================完成============================");  
    }  
}
