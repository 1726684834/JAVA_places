package zhang.mapper.impl;

import org.springframework.stereotype.Repository;
import zhang.mapper.LogMapper;
import zhang.pojo.DefingLog;

@Repository
public class LogMapperImpl implements LogMapper {
	@Override
	public int saveOne(DefingLog defingLog) {
		System.out.println("保存日志操作:"+defingLog);
		return 1;
	}
}
