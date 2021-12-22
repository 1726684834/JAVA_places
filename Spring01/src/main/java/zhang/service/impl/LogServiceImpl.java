package zhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhang.mapper.LogMapper;
import zhang.pojo.DefingLog;
import zhang.service.LogService;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:30
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;

    @Override
    public int saveOne(DefingLog defingLog) {
        return logMapper.saveOne (defingLog);
    }
}
