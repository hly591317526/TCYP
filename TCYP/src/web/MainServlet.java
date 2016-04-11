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
		// �ж�����·��
		req.setCharacterEncoding("utf-8");
		String path = req.getServletPath();
		if (path.equals("/toLogin.do")) {
			// �򿪵�½ҳ��
			toLogin(req, res);
		} else if (path.equals("/toIndex.do")) {
			// ����ҳ
			toIndex(req, res);
		} else if (path.equals("/login.do")) {
			// ��¼У��
			login(req, res);
		} else if (path.equals("/toManage.do")) {
			// ����Ա�����Ա
			mager(req, res);
		} else if (path.equals("/toManageDesc.do")) {
			// ����Ա�����Ա ����
			magerDesc(req, res);
		} else if (path.equals("/toManageByRoot.do")) {
			// ����Ա�����Ա root
			ManageByRoot(req, res);
		} else if (path.equals("/toManageByRootDesc.do")) {
			// ����Ա�����Ա root ����
			ManageByRootDesc(req, res);
		} else if (path.equals("/toSignIn.do")) {
			// ע��
			toSignIn(req, res);
		} else if (path.equals("/toPerson.do")) {
			// ���������޸�
			toPerson(req,res);
		} else if (path.equals("/toRefelect.do")) {
			// �������
			toRefelect(req,res);
		} else if (path.equals("/toDeleteMember.do")) {
			// ɾ����Ա
			deleteMember(req, res);
		} else if (path.equals("/toAddMember.do")) {
			// ת������ҳ��
			toAddMember(req, res);
		} else if (path.equals("/addMember.do")) {
			// ���ӻ�Ա
			addMember(req, res);
		} else if (path.equals("/toUpdateMember.do")) {
			// ��ת���޸Ļ�Ա
			toUpdateMember(req, res);
		} else if (path.equals("/updateMember.do")) {
			// �޸Ļ�Ա
			updateMember(req, res);
		} else if (path.equals("/toQuit.do")) {
			// �ǳ�
			toQuit(req, res);
		}else if(path.equals("/Feedback.do")){
			//���
			feedback(req,res);
		}
		else {
			throw new RuntimeException("���޴�ҳ��");
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
		// 2.��������
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
		// 3.�ض���
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
		// 1.��ȡ���е�����
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String qq = req.getParameter("qq");
		String descr = req.getParameter("descr");
		String root = req.getParameter("memberType");
		// 2.��������
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
		// 3.�ض���
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
		// ��ѯ���еĻ�Ա
		MemberDao dao = new MemberDaoImpl();
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		List<Member> list = dao.findAll(page);
		// �����е�����ת������ѯҳ��
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);
	}

	private void magerDesc(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// ��ѯ���еĻ�Ա
		MemberDao dao = new MemberDaoImpl();
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		List<Member> list = dao.findAllDesc(page);
		// �����е�����ת������ѯҳ��
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);

	}

	private void ManageByRootDesc(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		// ��ѯ���еĻ�Ա
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		MemberDao dao = new MemberDaoImpl();
		List<Member> list = dao.findAllByRootDesc(page);
		// �����е�����ת������ѯҳ��
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);

	}

	private void ManageByRoot(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// ��ѯ���еĻ�Ա
		MemberDao dao = new MemberDaoImpl();
		int page = Integer.parseInt(req.getParameter("page") == null ? "1"
				: req.getParameter("page"));
		List<Member> list = dao.findAllByRoot(page);
		// �����е�����ת������ѯҳ��
		req.setAttribute("members", list);
		req.getRequestDispatcher("WEB-INF/main/manage.jsp").forward(req, res);

	}

	// �ǳ�����
	private void toQuit(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getSession().invalidate();
		res.sendRedirect("toIndex.do");
	}

	private void login(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		// 1.��ȡ������
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		// 2.��ȡ����У��
		HttpSession session = req.getSession();
		MemberDao dao = new MemberDaoImpl();
		Member admin = dao.findByEmail(email);
		if (admin == null) {
			// �˺Ų�����
			req.setAttribute("error", "�˺Ų����ڣ�");
			req.getRequestDispatcher("WEB-INF/main/login.jsp")
					.forward(req, res);
		} else if (!admin.getPassword().equals(pwd)) {
			// �������
			req.setAttribute("error", "�������");
			req.getRequestDispatcher("WEB-INF/main/login.jsp")
					.forward(req, res);
		} else {
			// У��ͨ��
			// ���˺Ŵ���Session
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