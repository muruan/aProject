package cn.hzm.hz.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hzm.hz.dao.MatterDao;
import cn.hzm.hz.entity.Matter;
import cn.hzm.hz.mapper.MatterMapper;

@Repository("matterDaoImpl")
public class MatterDaoImpl implements MatterDao{

	@Autowired
	private MatterMapper mm ;
	@Override
	public List<Matter> MatterList() {
		return mm.MatterList();
	}

}