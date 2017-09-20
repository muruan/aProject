package cn.hzm.hz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzm.hz.dao.MatterDao;
import cn.hzm.hz.entity.Matter;
import cn.hzm.hz.service.MatterService;

@Service("matterService")
public class MatterServiceImpl implements MatterService{

	@Autowired
	private MatterDao matterDao;
	
	@Override
	public List<Matter> matterList() {
		
		return matterDao.MatterList();
	}

}