package cn.hzm.hz.common.base;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import cn.hzm.hz.common.util.DateUtil;
import cn.hzm.hz.common.util.IdGenUtil;

public class BaseEntity {
    private long id ;
    //这个值可以随意换  ID生成工具中间的 逻辑片的 值
    private long tag = 19920411;
    
	//创建时间
	private Date createDate;
	//创建者
	private String cteateBy;
	//修改时间
	private Date modifyDate;
	//修改者
	private String modifyBy;
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate() {
		this.createDate = DateUtil.getDate();
	}

	public String getCteateBy() {
		return cteateBy;
	}

	public void setCteateBy(String cteateBy) {
		this.cteateBy = cteateBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate() {
		this.modifyDate = DateUtil.getDate();
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	
	public long getId() {
		return id;
	}

	public void setId() {
		this.id = IdGenUtil.getInstance().nextId(tag);
	}
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}