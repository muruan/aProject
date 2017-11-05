package cn.hzm.hz.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

	@RequestMapping("/index")
	public String taskIndex(){
		return "/work_index";
	}
	@RequestMapping(value="i")
	public String s(){
		return "/NewFile";
	}
}