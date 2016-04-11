package Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.DBUtil;
import entity.Member;

public class MemberDaoImpl implements MemberDao {

	private Member creatMember(ResultSet rs) throws SQLException {
		return new Member(rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getInt(7),
				rs.getString(8), rs.getString(9));
	}

	public List<Member> findAll(int page) {
		String sql = "SELECT * FROM(SELECT ROWNUM rn, t.* FROM(SELECT * FROM tcyp_member ORDER BY id ) t) WHERE rn BETWEEN ? AND ?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 8 + 1);
			ps.setInt(2, page * 8);
			ResultSet rs = ps.executeQuery();
			List<Member> list = new ArrayList<Member>();
			while (rs.next()) {
				list.add(creatMember(rs));
			}
			return list;
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("查询所有账号失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public List<Member> findAllDesc(int page) {
		String sql = "SELECT * FROM(SELECT ROWNUM rn, t.* FROM(SELECT * FROM tcyp_member ORDER BY id desc ) t) WHERE rn BETWEEN ? AND ?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 8 + 1);
			ps.setInt(2, page * 8);
			ResultSet rs = ps.executeQuery();
			List<Member> list = new ArrayList<Member>();
			while (rs.next()) {
				list.add(creatMember(rs));
			}
			return list;
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("查询所有账号失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public List<Member> findAllByRoot(int page) {
		String sql = "SELECT * FROM(SELECT ROWNUM rn, t.* FROM(SELECT * FROM tcyp_member ORDER BY root,id ) t) WHERE rn BETWEEN ? AND ?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 8 + 1);
			ps.setInt(2, page * 8);
			ResultSet rs = ps.executeQuery();
			List<Member> list = new ArrayList<Member>();
			while (rs.next()) {
				list.add(creatMember(rs));
			}
			return list;
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("查询所有账号失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public List<Member> findAllByRootDesc(int page) {
		String sql = "SELECT * FROM(SELECT ROWNUM rn, t.* FROM(SELECT * FROM tcyp_member ORDER BY root desc,id ) t) WHERE rn BETWEEN ? AND ?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * 8 + 1);
			ps.setInt(2, page * 8);
			ResultSet rs = ps.executeQuery();
			List<Member> list = new ArrayList<Member>();
			while (rs.next()) {
				list.add(creatMember(rs));
			}
			return list;
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("查询所有账号失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public Member findByEmail(String email) {
		String sql = "select  * from TCYP_Member where email=?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Member m = null;
			while (rs.next()) {
				m = new Member(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8));
			}
			return m;
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("根据email查询账号失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public void save(Member m) {
		String sql = "insert into tcyp_member values("
				+ "tcyp_member_id.nextval,?,?,?,?,?,?,?)";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			// setInt/setDouble需要传入int 或者double 不支持null
			// 但是该字段在数据库中允许为空
			ps.setObject(2, m.getPhone());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getPassword());
			ps.setObject(5, m.getQq());
			ps.setString(6, m.getRoot());
			ps.setString(7, m.getDescr());
			ps.executeUpdate();
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("增加资费失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public Member findById(int id) {
		String sql = "select * from tcyp_member where id=?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Member m = null;
			while (rs.next()) {
				m = new Member(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8));
			}
			return m;
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("根据ID查询资费失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void update(Member m) {
		String sql = "update  tcyp_member set name=?, phone=?, email=?,password=?,qq=?,"
				+ "info=? where id=?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getPhone());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getPassword());
			ps.setObject(5, m.getQq());
			ps.setString(6, m.getDescr());
			ps.setObject(7, m.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("增加资费失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	public void delete(int id) {
		String sql = "delete  from tcyp_member where id=?";
		Connection conn = null;
		try {
			// 创建连接
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// 记录错误日志
			e.printStackTrace();
			throw new RuntimeException("根据ID删除数据失败", e);
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
}
