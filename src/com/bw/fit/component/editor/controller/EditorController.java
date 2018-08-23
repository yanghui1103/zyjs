package com.bw.fit.component.editor.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.ActionEnter;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.util.PropertiesUtil;
import com.bw.fit.system.common.util.PubFun;

@Controller
@RequestMapping("editor")
public class EditorController extends BaseController {

	/** 
     * 上传文件/图片/视频
     * @param file 
     * @param request 
     * @param response 
     * @return 
     */  
    @ResponseBody  
	@RequestMapping(value = "upload/file")
    public Map<String, Object> images (@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){  
        Map<String, Object> params = new HashMap<String, Object>();  
        try{  
        	if(file == null){
        		return null ;
        	}
             String basePath = PropertiesUtil.getValueByKey("fit_editor_file_path");
             String visitUrl = PropertiesUtil.getValueByKey("fit_editor_file_path");
             String origname = file.getOriginalFilename() ;
             String ext = origname.substring(origname.indexOf(".")+1, origname.length());
             String fileName = String.valueOf(System.currentTimeMillis()).concat("_").concat(PubFun.getUUID()).concat(".").concat(ext);  
             StringBuilder sb = new StringBuilder();  
             //拼接保存路径  
             sb.append(basePath).append("/").append(fileName);  
             visitUrl = visitUrl.concat(fileName);  
             File f = new File(sb.toString());  
             if(!f.exists()){  
                 f.getParentFile().mkdirs();  
             }  
             OutputStream out = new FileOutputStream(f);  
             FileCopyUtils.copy(file.getInputStream(), out);  
             params.put("state", "SUCCESS");  
             params.put("url", visitUrl);  
             params.put("size", file.getSize());  
             params.put("original", fileName);  
             params.put("type", file.getContentType());  
        } catch (Exception e){ 
        	e.printStackTrace();
            params.put("state", "ERROR");  
        }  
         return params;  
    }  
    
    @RequestMapping(value="/config")  
    public void config(HttpServletRequest request, HttpServletResponse response) {  
        response.setContentType("application/json");  
        String rootPath = request.getSession()  
                .getServletContext().getRealPath("/");  
        System.out.println("进入UEditorController");  
  
        try {  
            String exec = new ActionEnter(request, rootPath).exec();  
            PrintWriter writer = response.getWriter();  
            writer.write(exec);  
            writer.flush();  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
    
    /** 
     * 供读取服务器上传成功的图片显示到jsp上使用(多个图片循环调用) 
     * @param request 
     * @param response 
     * @param imagePath  图片地址 
     * @return 
     */  
    @ResponseBody  
    @RequestMapping(value = "/viewImagesToPage")  
    public String viewImagesToPage(HttpServletRequest request,  
                                   HttpServletResponse response,  
                                   @RequestParam(value = "imagePath", required = false) String imagePath  
                                  ) {  
        System.out.println("imagePath:"+imagePath);  
        ServletOutputStream out = null;  
        FileInputStream ips = null;  
        try {  
            ips = new FileInputStream(new File(imagePath));  
            response.setContentType("multipart/form-data");  
            out = response.getOutputStream();  
            // 读取文件流  
            int i = 0;  
            byte[] buffer = new byte[4096];  
            while ((i = ips.read(buffer)) != -1) {  
                // 写文件流  
                out.write(buffer, 0, i);  
            }  
            out.flush();  
            ips.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (out != null) {  
                try {  
                    out.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            if (ips != null) {  
                try {  
                    ips.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return null;  
    }  
    
    /** 
     * 下载文件 
     * @param request 
     * @param response 
     * @return 
     * @throws IOException 
     */  
    @RequestMapping(value = "/fileDownLoad",method = RequestMethod.GET)  
    public void fileDownLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        // 下载本地文件  
        String url = request.getParameter("url")+"";  
        String fileName = request.getParameter("filename")+"";  
        //如果是IE浏览器，则用URLEncode解析  
        //if(isMSBrowser(request)){  
        fileName = URLEncoder.encode(fileName, "UTF-8");  
        //}else{//如果是谷歌、火狐则解析为ISO-8859-1  
         //   fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");  
        //}  
        System.out.println("filename:"+fileName+" url:"+url);  
        // 读到流中  
        InputStream inStream = new FileInputStream(url);// 文件的存放路径  
        //      fileName = url.substring(url.lastIndexOf("/")+1);  
        //      System.out.println("filename:"+fileName);  
        // 设置输出的格式  
        response.reset();  
        //      response.setContentType("bin");  
        //        response.setContentType("application/vnd.ms-excel;charset=utf-8");  
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
        // 循环取出流中的数据  
        byte[] b = new byte[100];  
        int len;  
        try {  
            while ((len = inStream.read(b)) > 0)  
                response.getOutputStream().write(b, 0, len);  
            inStream.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
