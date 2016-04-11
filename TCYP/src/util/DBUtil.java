package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * ���ݿ⹤���� ��װ���ݿ�����Ӻ͹��̡�
 * @author ������
 */
public class DBUtil {
	/*
	 * ����һ���Եľ�̬��Դ�������ļ�
	 */
	// DataSource ��BasicDataSource�Ľӿ�
	// BasicDataSource ʵ��DataSource�ӿ�
   /*
    * ���ӳ�һ�����ɣ���ȫ�������̹߳����һ�����ӳض������Զ���Ϊ��̬��ֻҪһ�ݣ��ı�����
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
			// ��ȡ�����ļ��е�jdbc������Ϣ
			driver = cfg.getProperty("jdbc.driver");
			url = cfg.getProperty("jdbc.url");
			user = cfg.getProperty("jdbc.user");
			pwd = cfg.getProperty("jdbc.pwd");
			initialSize=Integer.parseInt(cfg.getProperty("jdbc.initialSize"));
			maxIdle=Integer.parseInt(cfg.getProperty("jdbc.maxIdle"));
			maxActive=Integer.parseInt(cfg.getProperty("jdbc.maxActive"));
			/*
			 * ���������ļ��󣬵õ������ݿ�����Ӳ��������ò�����ʼ�����ӳض���
			 */
			BasicDataSource ds=new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			// Initial ��ʼ Size��С
			ds.setInitialSize(initialSize);
			// Max ���Idle���У����ÿ�������������
			ds.setMaxIdle(maxIdle);
			// Max Active� ���������������
			ds.setMaxActive(maxActive);
			DBUtil.ds=ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * ���ӵ����ݿ�
	 * 
	 * @return ���Ӷ���
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static Connection getConnection() throws SQLException {
		try {
			// Connection conn = DriverManager.getConnection(
			// url, user, pwd);
			// �޸�DBUtil��ķ����������ݿ�ط�������Ϊ�������ӳ��������ݿ⡣
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);// ��ClassNotFoundException�쳣ת����SQLException�쳣�׳�
			// return null; һ����������߼�����throw����ȷreturn���Ѳ���e�����ȥ�ͻ�ȡ��e���쳣˵����
		}
	}

	/**
	 * �ر����ݿ�ķ�����
	 * 
	 * @param conn
	 * @return �ر��Ƿ�ɹ�
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
