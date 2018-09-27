package com.bw.fit.zyjs.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.dict.service.DictService;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.resume.dao.ResumeDao;
import com.bw.fit.zyjs.resume.entity.TResume;
import com.bw.fit.zyjs.seeker.dao.SeekerDao;
import com.bw.fit.zyjs.seeker.entity.TSeeker;

@RequestMapping("resume")
@Controller
public class ResumeController extends BaseController {

	@Autowired
	private DictService dictService;
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private SeekerDao seekerDao;


	@RequestMapping("gotoResumeListPage/{area}")
	public String git(@PathVariable String area,Model model ){
		model.addAttribute("area", area);
		return "zyjs/resume/resumeListPage" ;
	}
	
	@RequestMapping("resumes/{area}")
	@ResponseBody
	public JSONArray sts(@ModelAttribute TResume resume){
		List<TResume> res = resumeDao.selectAll(resume);
		return (JSONArray)JSONArray.toJSON(res) ;
	}
	
	@RequestMapping(value="resume/{id}",method=RequestMethod.GET)
	public String detail(@PathVariable String id,Model model){
		TResume r = resumeDao.get(id);
		model.addAttribute("resume", r);
		TSeeker seeker = seekerDao.get(r.getSeekerId());
		seeker.setWorkStatus("1".equals(seeker.getWorkStatus())?"已找到工作":"正在寻找工作");
		model.addAttribute("seeker", seeker);
		return "zyjs/resume/resumeDetailPage";
	}
	
	
}
