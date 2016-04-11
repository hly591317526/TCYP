package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库工具类 封装数据库的连接和过程。
 * @author 冬冬侠
 */
public class DBUtil {
	/*
	 * 加载一次性的静态资源：配置文件
	 */
	// DataSource 是BasicDataSource的接口
	// BasicDataSource 实现DataSource接口
   /*
    * 连接池一个即可，被全部的子线程共享的一个连接池对象！所以定义为静态（只要一份）的变量！
    */
	private static DataSource ds;
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	private static int initialSize;
	private static int maxIdle;
	private static int maxActive;
	static {
		String file = "util/db.properties";
		Properties cfg = new Properties();
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(file);
			cfg.load(in);
			// 读取配置文件中的jdbc参数信息
			driver = cfg.getProperty("jdbc.driver");
			url = cfg.getProperty("jdbc.url");
			user = cfg.getProperty("jdbc.user");
			pwd = cfg.getProperty("jdbc.pwd");
			initialSize=Integer.parseInt(cfg.getProperty("jdbc.initialSize"));
			maxIdle=Integer.parseInt(cfg.getProperty("jdbc.maxIdle"));
			maxActive=Integer.parseInt(cfg.getProperty("jdbc.maxActive"));
			/*
			 * 加载配置文件后，得到了数据库的连接参数。利用参数初始化连接池对象。
			 */
			BasicDataSource ds=new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			// Initial 初始 Size大小
			ds.setInitialSize(initialSize);
			// Max 最大Idle空闲，设置空闲连接数量。
			ds.setMaxIdle(maxIdle);
			// Max Active活动 设置最大活动连接数量
			ds.setMaxActive(maxActive);
			DBUtil.ds=ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 连接到数据库
	 * 
	 * @return 链接对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static Connection getConnection() throws SQLException {
		try {
			// Connection conn = DriverManager.getConnection(
			// url, user, pwd);
			// 修改DBUtil类的方法连接数据库地方法更新为利用连接池连接数据库。
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);// 把ClassNotFoundException异常转换成SQLException异常抛出
			// return null; 一个方法结果逻辑错误throw，正确return。把参数e传入进去就获取了e的异常说明。
		}
	}

	/**
	 * 关闭数据库的方法。
	 * 
	 * @param conn
	 * @return 关闭是否成功
	 * @throws SQLException
	 */
	public static boolean closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	 public static boolean rollBack(Connection conn){
		  try {
			if(conn!=null){
				conn.rollback();
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return false;
	 }
	 
}
