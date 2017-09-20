package cn.hzm.hz.entity;

import cn.hzm.hz.common.base.BaseEntity;

public class Matter extends BaseEntity{
    //标题
	private String title;
	//内容
	private String content;
	//类型1工作2活动
	private int type;
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}