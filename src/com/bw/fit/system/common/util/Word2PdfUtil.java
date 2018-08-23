package com.bw.fit.system.common.util;

import java.io.*;
import java.io.InputStream;

import org.aspectj.weaver.ast.Test;  

import com.aspose.words.Document;  
import com.aspose.words.License;  
import com.aspose.words.SaveFormat;  
public class Word2PdfUtil {

    public static void main(String[] args) {  
        doc2pdf("d:/2.doc","d:/22.pdf");  
    }  
  
    public static boolean getLicense() {  
        boolean result = false;  
        try {  
            InputStream is = Test.class.getClassLoader().getResourceAsStream("com/bw/fit/common/conf/convertPdfLicense.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下  
            License aposeLic = new License();  
            aposeLic.setLicense(is);  
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    public static void doc2pdf(String inPath, String outPath) {  
    	 // 验证License
//        if (!getLicense()) {
//            return;
//        }
        try {  
            long old = System.currentTimeMillis();  
            File file = new File(outPath); // 新建一个空白pdf文档  
            FileOutputStream os = new FileOutputStream(file);  
            Document doc = new Document(inPath); // Address是将要被转化的word文档  
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,  
                                         // EPUB, XPS, SWF 相互转换  
            long now = System.currentTimeMillis();  
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
