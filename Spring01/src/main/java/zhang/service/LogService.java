package zhang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhang.mapper.LogMapper;
import zhang.pojo.DefingLog;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:28
 */
@Service
public interface LogService {
    int saveOne(DefingLog defingLog);
}
