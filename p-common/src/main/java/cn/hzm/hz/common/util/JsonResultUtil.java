package cn.hzm.hz.common.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonResultUtil {
	/**
	 * @return
	 */
	public static <T> String encodeJson( boolean error,String message){
		return encodeJson(error,message,new ArrayList<T>());
	}
	
	
	public static <T> String encodeJson(boolean error,String message,List<T> list){
		/*JSONObject jsonObject=new JSONObject();
		jsonObject.put("error", String.valueOf(error));
		if(error)
			jsonObject.put("errorMessage",message);
		else
			jsonObject.put("contextMessage",message);
		jsonObject.put("dataList",JSON.toJSONString(list));	*/
		
		return JSON.toJSONString(list);
	}
	
	
}