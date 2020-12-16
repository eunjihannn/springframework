package spring.printer;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter { //생성자가 없음.

	//@Autowired(required = false)
	@Resource(name="memberDao")
	private MemberDao memDao;
	private MemberPrinter printer;

	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}

	@Autowired //자동주입
	//@Qualifier("check01") //충돌이 일어나는 경우 한정자 (객체가 두개 이상인 경우)
	//@Resource(name="printer1")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
//	@Autowired
//	public void injectDependency(MemberDao memberDao, @Qualifier("check01") MemberPrinter printer) {
//		this.memDao = memberDao;
//		this.printer = printer;
//	}

	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
}
