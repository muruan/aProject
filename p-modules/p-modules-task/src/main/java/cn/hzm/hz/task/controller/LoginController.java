package cn.hzm.hz.task.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import cn.hzm.hz.entity.User;
import cn.hzm.hz.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)    
    public String loginForm(Model model){    
        model.addAttribute("user", new User());    
        return "/login";    
    }    
        
    @RequestMapping(value="/login",method=RequestMethod.POST) 

	public String login(User user,Model model){
		 try {                
	            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！    
	            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));    
	            return "/index";    
	        } catch (AuthenticationException e) {    
	            model.addAttribute("error","用户名或密码错误");   
	            return "/error/403";    
	        }    
	}
    
    @RequestMapping(value="/testPermission")
    @RequiresPermissions(value="sys:delete", logical= Logical.OR)
    public String testPermission(){
    	return "/testPermission";
    }
    
    
    @ExceptionHandler({UnauthorizedException.class})  
    
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {  
        ModelAndView mv = new ModelAndView();  
        mv.addObject("exception", e);  
        mv.setViewName("/error/unauthorized");  
        return mv;  
    }   
    
    
}