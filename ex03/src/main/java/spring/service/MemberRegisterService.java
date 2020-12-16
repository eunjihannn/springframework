package spring.service;

import java.util.Date;

import javax.annotation.Resource;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {
	
	@Resource(name="memberDao") //name=내가 주입받을 객체의 아이디값
	private MemberDao memberDao; //new MemberDao();

	//@Autowired(required = false) //요구사항이 필수인가? (기본값은  true)
//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				new Date());
		memberDao.insert(newMember);
	}
}
