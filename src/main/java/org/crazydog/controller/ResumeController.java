package org.crazydog.controller;

import org.crazydog.domain.HireInfoEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.crazydog.serviceI.impl.searchmodel.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ResumeController {
	
	@Autowired
	@Qualifier("resumeServiceImpl")
	private ResumeServiceImpl resumeService;
	
	@RequestMapping(value="/resume",params="action=getAll")
	public String getAllmes(HttpServletRequest request){
		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
		request.setAttribute("resumes", resumes);
		Iterator<ResumeEntity> it = resumes.iterator();
		while(it.hasNext()){
			ResumeEntity a = it.next();
			System.out.println(a.getAddress());
			System.out.println(a.getHireById());
		}
		return "resume";
	}
	/*
		条件查询
	 */
	@RequestMapping(value="/resume",params ="action=modelSearch")
	public String modelSearch(@RequestParam("name")String name,@RequestParam("highestEdu")String highestEdu,@RequestParam("luquState")String luquState,HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.valueOf(luquState));
		List<ResumeEntity> resumes = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes", resumes);
		return "resume";
	}
	/*
		批量删除
	 */
	@RequestMapping(value="/resume",params ="action=bitchdelete")
	public String bitchdelete(HttpServletRequest request){
		System.out.println("======================================");
		String[] ids =  request.getParameterValues("selectid");
		int[] id = resumeService.stringtoint(ids);
		resumeService.batchdeleteresume(id);
		System.out.println("=============================");
		java.util.List<ResumeEntity> resumes = resumeService.getAllEntities();
		request.setAttribute("resumes", resumes);
		return "resume";
	}

	/*
		批量录取
	 */
	@RequestMapping(value="/resume",params ="action=bitchHire")
	public String bitchHire(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectes");
		int[] id = resumeService.stringtoint(ids);
		resumeService.batchHire(id, "李飞");
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		List<ResumeEntity> resumes2 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes2", resumes2);
		return "bitchhire";

	}

	/*
            批量取消录取
         */
	@RequestMapping(value="/resume",params ="action=bitchCancelHire")
	public String bitchCancelHire(HttpServletRequest request){
		String[] ids =  request.getParameterValues("selectes");
		int[] id = resumeService.stringtoint(ids);
		resumeService.batchcancelHire(id,"李飞");
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.录取);
		List<ResumeEntity> resumes1 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes1", resumes1);
		return "bitchCancelHire";

	}






	/*
		获取所有录取等待状态的简历
	 */
	@RequestMapping(value="/resume",params ="action=getNoHire")
	public String getNoHire(HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.等待审核);
		List<ResumeEntity> resumes2 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes2", resumes2);
		return "bitchhire";
	}
	/*
            获取所有已录取简历
         */
	@RequestMapping(value="/resume",params ="action=getAllHire")
	public String getAllHire(HttpServletRequest request){
		ResumeSearchModel resumeSearchModel = new ResumeSearchModel(null,null, ResumeSearchModel.Luqu.录取);
		List<ResumeEntity> resumes1 = resumeService.advanceSearch(resumeSearchModel);
		request.setAttribute("resumes1", resumes1);
		return "bitchCancelHire";
	}

}
