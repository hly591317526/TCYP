package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MemberDao;
import Dao.MemberDaoImpl;
import entity.Member;

public class MainServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 判断请求路径
		req.setCharacterEncoding("utf-8");
		String path = req.getServletPath();
		if (path.equals("/toLogin.do")) {
			// 打开登陆页面
			toLogin(req, res);
		} else if (path.equals("/toIndex.do")) {
			// 打开首页
			toIndex(req, res);
		} else if (path.equals("/login.do")) {
			// 登录校验
			login(req, res);
		} else if (path.equals("/toManage.do")) {
			// 管理员管理会员
			mager(req, res);
		} else if (path.equals("/toManageDesc.do")) {
			// 管理员管理会员 逆序
			magerDesc(req, res);
		} else if (path.equals("/toManageByRoot.do")) {
			// 管理员管理会员 root
			ManageByRoot(req, res);
		} else if (path.equals("/toManageByRootDesc.do")) {
			// 管理员管理会员 root 逆序
			ManageByRootDesc(req, res);
		} else if (path.equals("/toSignIn.do")) {
			// 注册
			toSignIn(req, res);
		} else if (path.equals("/toPerson.do")) {
			// 个人资料修改
			toPerson(req,res);
		} else if (path.equals("/toRefelect.do")) {
			// 意见反馈
			toRefelect(req,res);
		} else if (path.equals("/toDeleteMember.do")) {
			// 删除会员
			deleteMember(req, res);
		} else if (path.equals("/toAddMember.do")) {
			// 转到增加页面
			toAddMember(req, res);
		} else if (path.equals("/addMember.do")) {
			// 增加会员
			addMember(req, res);
		} else if (path.equals("/toUpdateMember.do")) {
			// 跳转到修改会员
			toUpdateMember(req, res);
		} else if (path.equals("/updateMember.do")) {
			// 修改会员
			updateMember(req, res);
		} else if (path.equals("/toQuit.do")) {
			// 登出
			toQuit(req, res);
		}else if(path.equals("/Feedback.do")){
			//意见
			feedback(req,res);
		}
		else {
			throw new RuntimeException("查无此页！");
		}
	}

	private void feedback(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("utf-8");
		String f1 = req.getParameter("f1");
		String f2 = req.getParameter("f2");
		String f3 = req.getParameter("f3");
		String f4 = req.getParameter("f4");
		String f5 = req.getParameter("f5");
		String f6 = req.getParameter("f6");
		System.out.println(f1+"\n"+f2+"\n"+f3+"\n"+f4+"\n"+f5+"\n"+f6+"\n");
		res.sendRedirect("toIndex.do");
	}

	private void toRefelect(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/refelect.jsp").forward(req,
				res);
	}

	private void toPerson(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/person.jsp").forward(req,
				res);
	}

	private void toSignIn(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/sign_in.jsp").forward(req, res);

	}

	private void updateMember(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String qq = req.getParameter("qq");
		String root = req.getParameter("descr");
		// 2.处理数据
		MemberDao dao = new MemberDaoImpl();
		Member m = new Member();
		if (id != null && !id.equals("")) {
			m.setId(Integer.parseInt(id));
		}
		m.setName(name);
		m.setPhone(phone);
		m.setEmail(email);
		m.setPassword(password);
		if (qq != null && !qq.equals("")) {
			m.setQq(Integer.parseInt(qq));
		}
		m.setDescr(root);
		dao.update(m);
		// 3.重定向
		if(root!=null&&root.equals("1")){
			res.sendRedirect("toManage.do?page=1");
			}else{
				session.setAttribute("user", m);
				res.sendRedirect("toIndex.do");
			}
		}

	private void toUpdateMember(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MemberDao dao = new MemberDaoImpl();
		Member m = dao.findById(id);
		req.setAttribute("member", m);
		req.getRequestDispatcher("WEB-INF/main/update_member.jsp").forward(req,
				res);
	}

	private void deleteMember(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		MemberDao dao = new MemberDaoImpl();
		dao.delete(Integer.parseInt(id));
		res.sendRedirect("toManage.do?page=1");
	}

	private void addMember(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		// 1.获取表单中的数据
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String qq = req.getParameter("qq");
		String descr = req.getParameter("descr");
		String root = req.getParameter("memberType");
		// 2.处理数据
		MemberDao dao = new MemberDaoImpl();
		Member m = new Member();
		m.setName(name);
		m.setPhone(phone);
		m.setEmail(email);
		m.setPassword(password);
		if (qq != null && !qq.equals("")) {
			m.setQq(Integer.parseInt(qq));
		}
		;
		m.setRoot(root);
		m.setDescr(descr);
		dao.save(m);
		// 3.重定向
		if(root!=null&&root.equals("1")){
		res.sendRedirect("toManage.do?page=1");
		}else{
			session.setAttribute("user", m);
			res.sendRedirect("toIndex.do");
		}
	}

	private void toAddMember(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/add_member.jsp").forward(req,
				res);
	}

	private void mager(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 查询所有的会员
		MemberDao dao = new MemberDaoImpl();
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		List<Member> list = dao.findAll(page);
		// 将所有的数据转发到查询页面
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);
	}

	private void magerDesc(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 查询所有的会员
		MemberDao dao = new MemberDaoImpl();
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		List<Member> list = dao.findAllDesc(page);
		// 将所有的数据转发到查询页面
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);

	}

	private void ManageByRootDesc(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		// 查询所有的会员
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		MemberDao dao = new MemberDaoImpl();
		List<Member> list = dao.findAllByRootDesc(page);
		// 将所有的数据转发到查询页面
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);

	}

	private void ManageByRoot(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 查询所有的会员
		MemberDao dao = new MemberDaoImpl();
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		List<Member> list = dao.findAllByRoot(page);
		// 将所有的数据转发到查询页面
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);

	}

	// 登出处理
	private void toQuit(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getSession().invalidate();
		res.sendRedirect("toIndex.do");
	}

	private void login(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		// 1.获取表单数据
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		// 2.获取数据校验
		HttpSession session = req.getSession();
		MemberDao dao = new MemberDaoImpl();
		Member admin = dao.findByEmail(email);
		if (admin == null) {
			// 账号不存在
			req.setAttribute("error", "账号不存在！");
			req.getRequestDispatcher("WEB-INF/main/login.jsp")
					.forward(req, res);
		} else if (!admin.getPassword().equals(pwd)) {
			// 密码错误
			req.setAttribute("error", "密码错误！");
			req.getRequestDispatcher("WEB-INF/main/login.jsp")
					.forward(req, res);
		} else {
			// 校验通过
			// 将账号存入Session
			session.setAttribute("user", admin);
			res.sendRedirect("toIndex.do");
		}

	}

	private void toLogin(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
	}

	private void toIndex(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req, res);
	}
}