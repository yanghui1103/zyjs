package com.bw.fit.zyjs.innerMail.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.innerMail.model.Mail;

public interface MailService {

	JSONObject insert(Mail mail) throws RbackException ;
}
