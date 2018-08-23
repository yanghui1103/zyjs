package com.bw.fit.system.common.util;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SmsSender {

	private static Logger logger = LoggerFactory.getLogger(SmsSender.class);

	private static final String endpoint = "http://10.1.1.10/API/BS3Webservice.asmx?wsdl";
	private static final String UserName = "ytxhxs";
	private static final String UserPsw = "12345";

	/**
	 * 调用短信平台接口发送短信，手机号多个时用加,分割;成功返回true
	 * @param PhoneNumber
	 * @param Content
	 * @return boolean
	 */
	public static boolean SendSMSString(String PhoneNumber, String Content) {

		boolean flag = false;
		try {
			String nameSpace = "http://tempuri.org/";
			String result = "";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTimeout(200000);
			call.setTargetEndpointAddress(new URL(endpoint));
			call.setUseSOAPAction(true);
			call.setSOAPActionURI("http://tempuri.org/" + "SendSMS");
			call.setOperationName(new QName(nameSpace, "SendSMS"));
			call.addParameter(new QName(nameSpace, "UserName"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "UserPsw"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "AccountInfo"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "AccountType"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "SchTime"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "IsBlackWord"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "IsBlackNumber"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "SMSMobile"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "SMSContent"), XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter(new QName(nameSpace, "IsPage"), XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);// 设置返回类型
			// 2017年3月24日 01:25:42 297763 新增 通过数据字典获取发送短信开关参数及默认接收手机号码
			result = (String) call.invoke(new Object[] { UserName, UserPsw, "", "", "", "", "", PhoneNumber, Content, "" });
			System.out.println(result);  
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return flag;
	} 
	public static void main(String[] args) { 
		SmsSender.SendSMSString("15147540360", "厚生生");
	}


}
