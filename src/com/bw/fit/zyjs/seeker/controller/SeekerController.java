package com.bw.fit.zyjs.seeker.controller;

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
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.dict.service.DictService;
import com.bw.fit.zyjs.hunter.model.Hunter;
import com.bw.fit.zyjs.resume.dao.ResumeDao;
import com.bw.fit.zyjs.resume.entity.TResume;
import com.bw.fit.zyjs.seeker.dao.SeekerDao;
import com.bw.fit.zyjs.seeker.entity.TSeeker;
import com.bw.fit.zyjs.seeker.model.Seeker;
import com.bw.fit.zyjs.seeker.service.SeekerService;

@RequestMapping("seeker")
@Controller
public class SeekerController extends BaseController {

	@Autowired
	private SeekerService seekerService;
	@Autowired
	private DictService dictService;
	@Autowired
	private SeekerDao seekerDao;
	@Autowired
	private ResumeDao resumeDao;

	@RequestMapping("gotoSeekersPage/{area}")
	public String git(@PathVariable String area,Model model ){
		model.addAttribute("area", area);
		return "zyjs/seeker/seekerListPage" ;
	}

	@RequestMapping(value="seekers/{area}",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray hunters(@PathVariable String area,@ModelAttribute Seeker seeker ){
		seeker.setArea(area);
		List<Seeker> Seekers = seekerService.selectAll(seeker);
		if(Seekers != null ){
			for(Seeker s:Seekers){
				s.setEducation(dictService.getDictByValue(s.getEducation()).getDictName());
			}
		}
		return (JSONArray) JSONArray.toJSON(Seekers);
	}
	
	@RequestMapping(value="seeker/{id}",method=RequestMethod.GET)
	public String get(@PathVariable String id,Model model){
		TSeeker tk = seekerDao.get(id);
		model.addAttribute("seeker", tk);
		List<TResume> rs = resumeDao.getResumes(id);
		model.addAttribute("resumes", rs);
		return "zyjs/seeker/seekerDetailPage";
	}
	
	@RequestMapping(value="black/{id}",method=RequestMethod.GET)
	public String black(@PathVariable String id,Model model){
		TSeeker tk = seekerDao.get(id);
		model.addAttribute("seeker", tk);
		List<TResume> rs = resumeDao.getResumes(id);
		model.addAttribute("resumes", rs);
		return "zyjs/seeker/seekerBlackPage";
	}
}
