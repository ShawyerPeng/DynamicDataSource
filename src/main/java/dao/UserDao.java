package dao;

import annotation.DataSourceEnum;
import annotation.DateSource;
import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SqlSession sqlSession;

    @DateSource(DataSourceEnum.MASTER)
    public int insert(User user) {
        return sqlSession.getMapper(UserMapper.class).insert(user);
    }

    @DateSource(DataSourceEnum.SLAVE)
    public List<User> findAll() {
        return sqlSession.getMapper(UserMapper.class).select(null);
    }
}
