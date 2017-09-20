package cn.hzm.hz.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hzm.hz.entity.Matter;
import cn.hzm.hz.service.MatterService;
import cn.hzm.hz.test.BaseTest;

public class MatterServiceTest extends BaseTest{
	@Autowired
	private MatterService ms;
     @Test
     public void matterList(){
    	List<Matter> list = ms.matterList();
    	for(Matter m:list){
    		System.out.println(m);
    	}
    	 System.err.println(1);
     }
}