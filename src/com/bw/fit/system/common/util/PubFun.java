package com.bw.fit.system.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.activiti.engine.form.FormProperty;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ByteSource;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.*; 
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.model.BaseModel;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Decoder.BASE64Decoder;

/*****
 * 工具类组件（组件类）
 * 
 * @author yangh
 *
 */
public class PubFun {
	private static final double PI = 3.1415926535898;
	private static double EARTH_RADIUS = 6378.137;
	private static Log log = LogFactory.getLog(PubFun.class);

	public static String getSysDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String getSysDateM() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}

	public static String getTruncSysDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static boolean checkSessionValidate(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return true;
		}

		return false;
	}

	public static String getFixLenthString(int strLength) throws Exception {

		Date d = new Date();

		return String.valueOf(d.getTime());
	}

	public static String getMutilLongIntId() {
		return String.valueOf(System.currentTimeMillis());
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static double GetDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);

		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	public static double[] getAround(double lat, double lon, int raidus) {

		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}

	public static ClassPathXmlApplicationContext getSysSpringCtx() {
		ClassPathXmlApplicationContext ctx = null;
		{
			if (ctx == null) {
				ctx = new ClassPathXmlApplicationContext("springAppContext.xml");
			}
		}
		return ctx;
	}

	public static String getFileTypeName(String s) {
		int index = 0;
		for (int i = s.length() - 1; i > 0; i--) {
			if ('.' == (s.charAt(i))) {
				index = i;
				break;
			}
		}
		return (s.substring(index, s.length()));
	}

	public static String getUUID(boolean isContainMLine) {
		String s = UUID.randomUUID().toString();
		if (isContainMLine) {
			return s;
		}
		return s.replace("-", "");
	}

	public static String getUUID() {
		return getUUID(false);
	}

	public static Map<String, FormProperty> createMap(List<FormProperty> props) {
		Map<String, FormProperty> re = new HashMap<String, FormProperty>();
		for (FormProperty p : props) {
			re.put(p.getId(), p);
		}
		return re;
	}

	public static int getPageStartNum(String pageNo, String tatol) {
		log.info(tatol);
		log.info(Integer.valueOf(tatol));
		return Integer.valueOf(pageNo) * Integer.valueOf(tatol);
	}

	public static int getPageEndNum(String pageNo, String tatol) {
		return Integer.valueOf(pageNo) * Integer.valueOf(tatol)
				+ Integer.valueOf(tatol);
	}

	public static int getPageTatolNum(int size, int page_size) {
		if (page_size <= 0) {
			return -9;
		}
		int zheng = size / page_size;
		return zheng + (size % page_size > 0 ? 1 : 0);
	}

	public static String getTruncDouleNumber(String s) {
		int i = s.indexOf(".");
		return (s.substring(0, i + 2));
	}

	public static String getTruncDouleNumber(Double s) {
		String s2 = String.valueOf(s);
		int i = s2.indexOf(".");
		return (s2.substring(0, i + 2));
	}

	public static HSSFCellStyle getStyleByCompLevel(HSSFWorkbook wb, int level) {
		HSSFCellStyle style = wb.createCellStyle();
		if (level == 6) {
			style.setFillForegroundColor(HSSFColor.RED.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		} else if (level == 8) {
			style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		} else if (level == 10) {
			style.setFillForegroundColor(HSSFColor.GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		} else if (level == 12) {
			style.setFillForegroundColor(HSSFColor.AQUA.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		} else if (level == 14) {
			style.setFillForegroundColor(HSSFColor.YELLOW.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		}
		return style;
	}

	/**
	 * date2比date1多的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // 同一年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
				{
					timeDistance += 366;
				} else // 不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else // 不同年
		{
			System.out.println("判断day2 - day1 : " + (day2 - day1));
			return day2 - day1;
		}
	}

	/**
	 * 这个主要用在查询条件返回时候 去掉-9
	 */
	public static String getCleanString(String s) {
		if ("-9".equals(s))
			return "";
		return s;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}



	public static String getMACAddress(String ip) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -a " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					// if (str.indexOf("MAC Address") > 1) {
					if (str.indexOf("MAC") > 1) {
						macAddress = str.substring(str.indexOf("=") + 2,
								str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return macAddress;
	}

	/****
	 * 前者包含后者
	 * 
	 * @param longString
	 * @param str
	 * @return
	 */
	public static boolean isContains(String longString, String str) {
		if (longString != null && longString.contains(str)) {
			return true;
		}
		return false;
	}

	/** 将Base64 转换为file文件 */
	public static boolean base64ToFile(String base64, String path) {
		byte[] buffer;
		try {
			buffer = Base64.getDecoder().decode(base64);
			FileOutputStream out = new FileOutputStream(path);
			out.write(buffer);
			out.close();
			return true;
		} catch (Exception e) {
			throw new RuntimeException("base64字符串异常或地址异常\n" + e.getMessage());
		}
	}

	/** 将 file 转化为 Base64 */
	public static String fileToBase64(String path) {
		File file = new File(path);
		FileInputStream inputFile;
		try {
			inputFile = new FileInputStream(file);
			byte[] buffer = new byte[(int) file.length()];
			inputFile.read(buffer);
			inputFile.close();
			return Base64.getEncoder().encodeToString(buffer);
		} catch (Exception e) {
			throw new RuntimeException("文件路径无效\n" + e.getMessage());
		}
	}

	/*****
	 * 将一个数据扩充长度 只能比原来的长度更长
	 * 
	 * @param oldArray
	 * @param newSize
	 * @return
	 */
	private static Object resizeArray(Object oldArray, int newSize) {
		int oldSize = java.lang.reflect.Array.getLength(oldArray);
		Class elementType = oldArray.getClass().getComponentType();
		Object newArray = java.lang.reflect.Array.newInstance(elementType,
				newSize);
		int preserveLength = Math.min(oldSize, newSize);
		if (preserveLength > 0)
			System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
		return newArray;
	}

	public static boolean isImageFromBase64(String base64Str) {
		boolean flag = false;
		try {
			BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(
					new BASE64Decoder().decodeBuffer(base64Str)));
			if (null == bufImg) {
				return flag;
			}
			flag = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return flag;
	}

	public static void targetZoomOut(String sourcePath) { // 将目标图片缩小成256*256并保存
		File file1 = new File(sourcePath); // 用file1取得图片名字
		String name = file1.getName();
		try {
			BufferedImage input = ImageIO.read(file1);
			Image big = input.getScaledInstance(256, 256, Image.SCALE_DEFAULT);
			BufferedImage inputbig = new BufferedImage(256, 256,
					BufferedImage.TYPE_INT_BGR);
			inputbig.getGraphics().drawImage(input, 0, 0, 256, 256, null); // 画图

			ImageIO.write(
					inputbig,
					"jpg",
					new File(PropertiesUtil
							.getValueByKey("system.attachment_path") + name)); // 将其保存在C:/imageSort/targetPIC/下
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*****
	 * 从后台返回JSON/Xml/String 数据至前台
	 */
	public static void returnJson(HttpServletResponse response, String json)
			throws Exception {
		PrintWriter writer = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			writer = response.getWriter();
			writer.print(json);

		} catch (IOException e) {
			log.error("response error", e);
		} finally {
			if (writer != null)
				writer.close();
		}
	}

	/********
	 * 获取licnece
	 */
	public static String getLicneceMiWen(String key) {
		ResourceBundle rb = null;
		try {
			rb = ResourceBundle.getBundle("com/bw/fit/system/common/conf/licence");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rb.getString(key);
	}
 

	/****
	 * 根据shrio加密方式 得到的密文
	 * 
	 * @param userName
	 * @param passwd
	 * @param hashalgorithmName
	 *            加密方式
	 * @param iterations
	 *            加密次数
	 * @return
	 */
	public static String getUserPasswordShiro(String userName, String passwd,
			String hashalgorithmName, int iterations) {
		String credentials = passwd;
		Object salt = ByteSource.Util.bytes(PropertiesUtil
				.getValueByKey("user.pw.slogmm") + userName);
		Object result = new SimpleHash(hashalgorithmName, credentials, salt,
				iterations);
		return result.toString();
	}

	public static void copyProperties(Object dest, Object orig) {
		try {
			ConvertUtils
					.register(new DateConverter(), java.util.Date.class);
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/****
	 * 填充成功返回JSON
	 * 
	 * @param j
	 */
	public static void returnSuccessJson(JSONObject j) {
		j.put("res", "2");
		j.put("msg", "执行成功");
	}

	/****
	 * 填充失败/异常返回JSON
	 * @param j
	 * @param errorMsg
	 *            失败消息
	 */
	public static void returnFailJson(JSONObject j, String errorMsg) {
		j.put("res", "1");
		j.put("msg", errorMsg);
	}

	/*****
	 * 获取当前用户的会话 shrio 方法
	 * 
	 * @return
	 */
	public static org.apache.shiro.session.Session getCurrentSession() {
		return SecurityUtils.getSubject().getSession();
	}
	/****
	 * 获取当前账户
	 * @return
	 */
	public static Account getCurrentAccount() {
		try {
			return ((Account)SecurityUtils.getSubject().getSession().getAttribute("CurrentUser"));
		} catch (Throwable e) {
			return null;
		}
	}


	public static void fillCommonProptities(BaseModel b, boolean isFillFdid,Session session) {
		if(isFillFdid){
			b.setId(getUUID());
		}
		b.setCreator(getCurrentAccount().getId());
		b.setCreateOrgId(getCurrentAccount().getCurrentOrgId());
		List<String> orgs = (List)PubFun.getCurrentSession().getAttribute("OrgIdsOfDataAuth");
		b.setCreateOrgIds(orgs);
	}
	
	/****
	 * 根据返回标志，查询其含义
	 * @param code
	 * @return
	 */
	public static String getResDesp(String code){
		if("2".equals(code)){
			return "成功";
		}else if("3".equals(code)){
			return "提示";
		}else if("1".equals(code)){
			return "失败";
		}else{
			return "抱歉，未定义";
		}
	}

	public static byte[] strToByteArray(String str) throws Exception {
		if (str == null) {
			return null;
		}
		byte[] byteArray = str.getBytes("ISO-8859-1");
		return byteArray;
	}

	
	public static void main(String[] args) {
		//System.out.println(getUserPasswordShiro("admin", "123456", "MD5", 10));
		
		
		Map map = new HashMap();
	    map.put("AA",213);
	    map.put("BB",45);
	    map.put(123,"CC");
	    map.put(null,null);
	    map.put(new Account(),89);
	 
	 
	    //1.遍历key集.此时打印输出 null,AA,Person    //[name=DD,age=23],BB,123
	    Set set = map.keySet();
	    for(Object obj : set){
	      System.out.println(obj);
	    }
	    //2.遍历value集.此时打印输出null,213,89,45,CC
	    Collection values = map.values();
	    Iterator i = values.iterator();
	    while(i.hasNext()){
	      System.out.println(i.next());
	    }
	    System.out.println("--------------");
	    //3.如何遍历key-value对
	    //方式一
	    Set set1 = map.keySet();
	    for(Object obj : set1){
	      System.out.println(obj + "----->" + map.get(obj));
	    }
	    System.out.println("--------------");
	    //方式二
	    Set set2 = map.entrySet();
	    for(Object obj : set2 ){
	      Map.Entry entry = (Map.Entry)obj;
	      System.out.println(entry.getKey() + "---->" + entry.getValue());
	    }
	    System.out.println("--------------");
		
	}
	

	public static Map<String,Object> getFieldsNameAndValue(Class cls, String clazzName, String methodName, Object[] args) throws Exception {   
        Map<String,Object > map=new HashMap<String,Object>();  
          
        ClassPool pool = ClassPool.getDefault();    
        //ClassClassPath classPath = new ClassClassPath(this.getClass());    
        ClassClassPath classPath = new ClassClassPath(cls);    
        pool.insertClassPath(classPath);    
            
        CtClass cc = pool.get(clazzName);    
        CtMethod cm = cc.getDeclaredMethod(methodName);    
        MethodInfo methodInfo = cm.getMethodInfo();  
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();    
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);    
        if (attr == null) {    
            // exception    
        }    
       // String[] paramNames = new String[cm.getParameterTypes().length];    
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;    
        for (int i = 0; i < cm.getParameterTypes().length; i++){    
            map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名    
        }             
        //Map<>  
        return map;    
    }    
}
