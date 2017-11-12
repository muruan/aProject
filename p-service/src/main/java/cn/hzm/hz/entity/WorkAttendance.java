package cn.hzm.hz.entity;

import java.util.Date;

public class WorkAttendance {
    private Long id;

    private String createBy;

    private Date createDate;

    private Integer dayhour;

    private Byte type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDayhour() {
        return dayhour;
    }

    public void setDayhour(Integer dayhour) {
        this.dayhour = dayhour;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}