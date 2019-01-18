package mybatis.mapper;

import mybatis.model.User;

/**
 * @ClassName UserMapper
 * @Author dianXiao2
 * @Date 2018/12/17 16:35
 **/
public interface UserMapper {
    User findById(Long id);
}
