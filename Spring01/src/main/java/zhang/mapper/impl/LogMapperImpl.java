package com.cxsw.spring.mapper.impl;

import org.springframework.stereotype.Repository;

import com.cxsw.spring.mapper.LogMapper;
import com.cxsw.spring.pojo.SysLog;
@Repository
public class LogMapperImpl implements LogMapper{

	@Override
	public int saveOne(SysLog sysLog) {
		System.out.println("保存日志操作:"+sysLog);
		return 1;
	}

}
