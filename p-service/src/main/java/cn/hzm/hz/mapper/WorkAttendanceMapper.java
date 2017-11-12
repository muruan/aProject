package cn.hzm.hz.mapper;

import cn.hzm.hz.entity.WorkAttendance;

public interface WorkAttendanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkAttendance record);

    int insertSelective(WorkAttendance record);

    WorkAttendance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkAttendance record);

    int updateByPrimaryKey(WorkAttendance record);
}