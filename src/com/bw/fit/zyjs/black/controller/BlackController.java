package com.bw.fit.zyjs.black.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.zyjs.black.dao.BlackDao;
import com.bw.fit.zyjs.black.entity.TBlack;
import com.bw.fit.zyjs.company.dao.EstaDao;
import com.bw.fit.zyjs.company.entity.TEsta;

@RequestMapping("black")
@Controller
public class BlackController  extends BaseController{
	@Autowired
	private BlackDao blackDao;
	@Autowired
	private EstaDao estaDao;
	
	@RequestMapping("blacks/{area}")
	@ResponseBody
	public JSONArray list(@PathVariable String area,@ModelAttribute TBlack black,Model model){
		model.addAttribute("area", area);
		black.setArea(area);
		List<TBlack> bs = blackDao.selectAll(black);
		TEsta te = new TEsta();
		te.setArea(area);
		te.setKeyWords(black.getKeyWords());
		List<TEsta> es = estaDao.selectAll(te);
		List<TBlack> newBs = new ArrayList<>();
		if(bs!=null && bs.size()>0){
			newBs = bs.stream().filter(x->{
				TBlack ss = x;
				Optional<TEsta> op = es.stream().filter(b->b.getId().equals(ss.getObjId())).findAny();
				if(op.isPresent()){
					x.setTemp_str1(op.get().getName());
					x.setTemp_str2(op.get().getTemp_str1().equals("个人")?op.get().getPhone():op.get().getEmail());
					return true;
				}else{
					return false ;
				}
			}).collect(Collectors.toList());
			
			List<TBlack>  list = newBs.parallelStream().skip((black.getPage() - 1) * black.getRows())
			.limit(black.getRows()).collect(Collectors.toList());
			return (JSONArray)JSONArray.toJSON(list);
		}
		return null ;
	}
	
	@RequestMapping("black/{id}")
	public String detail(@PathVariable String id,Model model){
		
		return "zyjs/black/blackDetailPage";
	}
}
