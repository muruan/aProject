package cn.hzm.hz.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hzm.hz.entity.User;
import cn.hzm.hz.service.UserService;

@Controller
public class TaskController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String taskIndex(Model model){
		User user = userService.findByUsername("hzm1");
		model.addAttribute("user",user);
		return "/work_index";
	}
	@RequestMapping(value="i")
	public String s(){
		return "/NewFile";
	}
}