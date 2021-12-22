package zhang.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhang.pojo.DefingLog;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:26
 */
@Mapper
public interface LogMapper {
    int saveOne(DefingLog defingLog);
}
