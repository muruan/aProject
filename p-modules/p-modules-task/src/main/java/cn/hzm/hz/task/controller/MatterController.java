package cn.hzm.hz.task.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.hzm.hz.common.util.JsonResultUtil;
import cn.hzm.hz.entity.Matter;
import cn.hzm.hz.service.MatterService;


@Controller
public class MatterController {
	
	@Resource
	private MatterService matterService;
	
	@ResponseBody
	@RequestMapping("/matterList")
	public String matterList(){
		List<Matter> matterList = matterService.matterList();
		//model.addAttribute("matterList",matterList);
		boolean error=false;
		String msg="查询成功";
		//return JsonResultUtil.encodeJson(error,msg, matterList);
		//return JSON.toJSONString(matterList);
		return JsonResultUtil.encodeJson(error, msg, matterList);
	}

}