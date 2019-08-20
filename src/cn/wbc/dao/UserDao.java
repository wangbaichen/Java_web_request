package cn.wbc.dao;

import cn.wbc.domain.User;
import cn.wbc.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user表的类
 */
public class UserDao {
    //声明JDBCTemplate对象公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登陆方法
     * @param loginUser 只有用户名和密码
     * @return  user包含用户全部数据
     */
    public User login(User loginUser){
        //1.编写sql
        String sql ="select * from user where username = ? and password = ?";
        //2.调用query方法
        User user = template.queryForObject(sql,
                new BeanPropertyRowMapper<User>(User.class),
                loginUser.getUsername(),
                loginUser.getPassword());


        return user;
    }

}
