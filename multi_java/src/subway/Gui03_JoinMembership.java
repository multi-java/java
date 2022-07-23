package subway;
/** 
 * 
 * 회원가입 화면
 * 
 * 작성자: 김보미
 * 작성일: 22-07-23
 * 버전: 1.1
 */
import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;

public class Gui03_JoinMembership extends JFrame {
	
	JPanel p,pN,pC,pS; 
	//JPanel myPage; 
	JButton bJoin; 
	JTextField tId, tPwd, tName,tPhone, tEmaie, tUserNum, tBirthdate;
	JLabel laId, laPwd, laName,laPhone, laEmaie, laUserNum, laBirthdate;
	JLabel laIcon;
	JTabbedPane tabP; 
	Icon iconLogo;
	
	//컨테이너의 바깥 여백을 주는 메서드를 오버라이딩
		@Override
		public Insets getInsets () {
			Insets in=new  Insets(10,10,10,10);
			return in;
		}
		
		public Gui03_JoinMembership() {
			
			super(":: Toast House App v1.1 ");
			
			//1.전체 패널(p) 구성 
			p=new JPanel(new BorderLayout()); //전체 패널 p를  보더레이이아웃 설정
			p.setBackground(Color.white);
			p.add(pC=new JPanel(),"Center"); //1.pC를 p의 중앙에 붙임
			pC.setBackground(Color.white);
			p.add(pN=new JPanel(),"North"); //1. pN를 p의 북쪽에 붙임
			pN.setBackground(Color.white);
			p.add(pS=new JPanel(),"South"); //1. pS를 p의 남쪽에 붙임
			pS.setBackground(Color.white);
			
			//2. pN에 회원가입 문구를 로고그림
			iconLogo=new ImageIcon("toastlogo.png");
			laIcon=new JLabel(iconLogo); //
			pN.add(laIcon); 
			
			//3.  pC에 회원가입에 대한 내용 기술
			pC.setLayout(new GridLayout(7,2,30,50));
					
			laUserNum=new JLabel("회원번호");
			laId=new JLabel("아이디");
			laPwd=new JLabel("비밀번호");
			laName=new JLabel("이름");
			laBirthdate=new JLabel("생년월일");
			laPhone=new JLabel("연락처");
			laEmaie=new JLabel("이메일");
					
			tUserNum=new JTextField(20);
			tUserNum.setBackground(Color.white);
			tId=new JTextField(20);
			tId.setBackground(Color.white);
			tPwd=new JTextField(20);
			tPwd.setBackground(Color.white);
			tName=new JTextField(20);
			tName.setBackground(Color.white);
			tBirthdate=new JTextField(20);
			tBirthdate.setBackground(Color.white);
			tPhone=new JTextField(20);
			tPhone.setBackground(Color.white);
			tEmaie=new JTextField(20);
			tEmaie.setBackground(Color.white);
				
			pC.add(laUserNum);
			pC.add(tUserNum);
			pC.add(laId);
			pC.add(tId);
			pC.add(laPwd);
			pC.add(tPwd);
			pC.add(laName);
			pC.add(tName);
			pC.add(laBirthdate);
			pC.add(tBirthdate);
			pC.add(laPhone);
			pC.add(tPhone);
			pC.add(laEmaie);
			pC.add(tEmaie);
			
			//4.pS에 원가입 버튼
			
			bJoin=new JButton(" 회원가입 ");//회원가입 버튼
			bJoin.setBackground(Color.white);
			pS.add(bJoin);
			//완료 버튼
			
			//5. 페이지를 넘어가는 방식
			tabP=new JTabbedPane();
			add(tabP);
			tabP.add(p,"회원가입");
			tabP.setSelectedIndex(0);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
			

	public static void main(String[] args) {
		Gui03_JoinMembership my03=new Gui03_JoinMembership();
		my03.setSize(500,700);
		my03.setVisible(true);
		
		

	}//메인

}//클래스
