package com.bw.fit.train.report.controller;

import java.io.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.train.report.dao.RptDao;
import com.bw.fit.train.report.entity.TTrainSign;

@RequestMapping("trainRpt")
@Controller
public class ReportController {
	
	@Autowired
	RptDao rptDao;
	
	@RequestMapping("rpt/{startDate}/{endDate}")
	public void exportMonthDevExcel(@PathVariable String startDate,@PathVariable String endDate,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String	path = request.getServletContext().getRealPath("/") + "/upLoadFiles/";
		String  fileName = PubFun.getUUID()+".xls";
		String excelName = path + fileName; 
			// TODO Auto-generated method stub
	        JSONObject info = new JSONObject();
	        HSSFWorkbook wb = new HSSFWorkbook(); // 创建一个excell文件
	        HSSFSheet sheet = wb.createSheet("统计表"); // 创建一个excell的sheet
	        HSSFCellStyle style = wb.createCellStyle();
	        // 设置居中样式
	        Font font = wb.createFont();
	        HSSFCellStyle styles = wb.createCellStyle();
	        // 设置居中样式
	        Font fonts = wb.createFont();
	        font.setFontName("微软雅黑");
	        font.setFontHeight((short) 200);
	        HSSFRow row = sheet.createRow((int) 0);
	        font.setColor(HSSFColor.BLACK.index);
	        font.setFontHeightInPoints((short) 14);
	        style.setFont(font);
	        sheet.setColumnWidth(0, 4000); // 设置列宽
	        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
	        // 创建第一行
	        HSSFRow row0 = sheet.createRow(0);// 创建第一行
	        // 设置行高
	        row0.setHeight((short) 500); // 设置行高
	        // 创建第一列
	        HSSFCell cell0 = row0.createCell(0); // 创建一行中的一个单元格 
	        cell0.setCellStyle(style);
	        cell0.setCellValue("报名统计表");
	        fonts = font;
	        fonts.setFontHeightInPoints((short) 11);
	        styles = style;
	        styles.setFont(fonts);
	        

	        // 第二列
	        HSSFRow row1 = sheet.createRow(1);
	        HSSFRow row2 = sheet.createRow(2);
	        row2.setHeight((short) 750);
	        String[] excelHeader = { "申请人姓名", "年龄", "联系电话", "工种", "是否经营中", "企业/个体名称", "人数" , "登记时间","报名类型"  };
	        // 单元格列宽
	        int[] excelHeaderWidth = {  120,120 ,120,120,120,120,120,120,120};
	        // 设置列宽度（像素）
	        for (int i = 0; i < excelHeaderWidth.length; i++) {
	            sheet.setColumnWidth(i, 45 * excelHeaderWidth[i]);
	        }
	        // 添加表格头
	        for (int i = 0; i < excelHeader.length; i++) {
	            HSSFCell cell = row1.createCell(i);
	            cell.setCellValue(excelHeader[i]);
	            cell.setCellStyle(style);
	        }
	        
	        
	        TTrainSign tr = new TTrainSign();
	        tr.setStart_date(startDate);
	        tr.setEnd_date(endDate);
	        List<TTrainSign> list4 = rptDao.selectAll(tr);
	        // 添加表格数据
	        for (int i = 0; i < list4.size(); i++) {
	            HSSFRow rowi = sheet.createRow( i + 2);
	            rowi.createCell(0).setCellValue(list4.get(i).getPersonName());
	            rowi.createCell(1).setCellValue(list4.get(i).getAge());
	            rowi.createCell(2).setCellValue(list4.get(i).getPhone());
	            rowi.createCell(3).setCellValue(list4.get(i).getWorkType());
	            rowi.createCell(4).setCellValue(list4.get(i).getIsWorking());
	            rowi.createCell(5).setCellValue(list4.get(i).getCompanyName());
	            rowi.createCell(6).setCellValue(list4.get(i).getPersonNum());
	            rowi.createCell(7).setCellValue(list4.get(i).getCreateTime());
	            rowi.createCell(8).setCellValue(list4.get(i).getTemp_str1());
	        }
	        //
	        String uploadPath = path;
		try {

            OutputStream outp = new FileOutputStream(excelName); // 获取输出流
            wb.write(outp); // 将输出流与excell关联输出
            outp.flush();
            outp.close(); // 关闭输出流
            
			response.setContentType("application/x-download;charset=GBK");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ excelName);
			InputStream in = new FileInputStream(excelName);
			int len = 0;
			byte[] buffer = new byte[1024];
			 OutputStream out = response.getOutputStream();
			 while ((len = in.read(buffer)) > 0) {
				             out.write(buffer,0,len);
			 }
	         in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
