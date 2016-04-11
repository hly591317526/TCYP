package Dao;

import java.util.List;

import entity.Member;

public interface MemberDao {

	Member findByEmail(String email);
	
	List<Member>  findAll(int page);	
	
	List<Member>  findAllDesc(int page);
	
	List<Member>  findAllByRoot(int page);	
	
	List<Member>  findAllByRootDesc(int page);
	
	void save(Member member);

	Member findById(int id);

	void update(Member member);

	void delete(int id);
}
