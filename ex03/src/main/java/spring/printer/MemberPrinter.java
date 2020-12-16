package spring.printer;

import spring.vo.Member;

public class MemberPrinter {
	
	private String num;

	public void setNum(String num) {
		this.num = num;
	}

	public void print(Member member) {
		System.out.printf(
				"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), member.getEmail(),
				member.getName(), member.getRegisterDate());
		System.out.println("이 객체의 번호는 "+num);
	}
	
}
