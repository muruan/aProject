package cn.hzm.hz.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workAttendance")
public class workAttendanceController {
    
	@RequestMapping("/index")
	public String waList(){
		return "/workAttendanceIndex";
	}
}
