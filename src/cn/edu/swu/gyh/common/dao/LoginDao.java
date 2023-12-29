package cn.edu.swu.gyh.common.dao;

import cn.edu.swu.gyh.db.BaseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    static Connection con;

    static {
        try {
            con = BaseRepo.getDBConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //登录状态（成功则返回true，失败则返回false）
    public static boolean loginStar(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        ResultSet rs; //定义一个结果集（存放结果）
        String sqlStr = "select * from users where account = ? and password = ?";  //?表示从外部输入的
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号
            preSql.setString(2, password); //把上面第二个问号设置成密码

            rs = preSql.executeQuery(); //查询，返回值放到rs里面
            if ( rs.next() ) { //rs是表头，看他下一个是否有东西，如果里面有东西执行了，就返回true
                return true;
            } else { //如果查询失败了
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //注册账号
    public static int loginRegister(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        String sqlStr = "insert into users values(?, ?)";  //?表示从外部输入的
        int num;

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号
            preSql.setString(2, password); //把上面第二个问号设置成密码

            num = preSql.executeUpdate(); //更新数据，返回值放到num里面
            return num;

        } catch (SQLException e) { //账号重复
            return 3;
        }
    }

    //注销账号
    public static int loginDelete(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        String sqlStr = "delete from users where account=?";  //?表示从外部输入的
        int num;

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号

            num = preSql.executeUpdate(); //更新数据，返回值放到num里面
            return num;

        } catch (SQLException e) { //账号重复
            return 3;
        }
    }

    //注销账号时，查找数据库是否存在该用户，用于提示框强调
    public static boolean isDelete(String account) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        ResultSet rs; //定义一个结果集（存放结果）
        String sqlStr = "select account from users where account = ?";  //?表示从外部输入的
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号

            rs = preSql.executeQuery(); //查询，返回值放到rs里面
            if (rs.next()) { //rs是表头，看他下一个是否有东西，如果里面有东西执行了，就返回true
                return true;
            } else { //如果查询失败了
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

}
