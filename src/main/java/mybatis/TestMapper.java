package mybatis;

import com.alibaba.fastjson.JSON;
import mybatis.mapper.UserMapper;
import mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ClassName TestMapper
 * @Author dianXiao2
 * @Date 2018/12/18 17:52
 **/
public class TestMapper {

    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(21L);
        System.out.println(JSON.toJSONString(user));
    }
}
