package subway;

import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;
/** 
 *  환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 앱의 첫 화면: 아이디와 비밀번호를 입력해 로그인
 * 
 * 작성자: 김보미
 * 작성일: 22-07-20
 * 버전: 1.1
 */

public class Gui01_Login  extends JFrame {

	JPanel p,pN,pC; 
	JPanel myPage; 
	JButton bLogin, bJoin; 
	JTextField textId, textPwd;
	JLabel laId, laPwd;
	JLabel laIcon;
	JTabbedPane tabP; 
	Icon iconLogo;
	
	//컨테이너의 바깥 여백을 주는 메서드를 오버라이딩
	@Override
	public Insets getInsets () {
		Insets in=new  Insets(10,10,10,10);
		return in;
	}

	public Gui01_Login() {
		
		super(":: Toast House App v1.1 ");
		
		//1.전체 패널(p) 구성
		p=new JPanel(new BorderLayout()); //전체 패널 p를  보더레이이아웃 설정
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); //1.pC를 p의 중앙에 붙임
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North"); //1. pN를 p의 북쪽에 붙임
		pN.setBackground(Color.white);
		
		//2. pN에 로고 
		iconLogo=new ImageIcon("toastlogo.png");
		laIcon=new JLabel(iconLogo); //
		pN.add(laIcon); 
		
		//3.  pC에 아이디, 비밀번호 입력칸
		pC.setLayout(new GridLayout(3,2,30,50));
				
		bLogin=new JButton(" 로그인 ");//로그인, 회원가입 버튼
		bLogin.setBackground(Color.white);
				
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
				
		textId=new JTextField(20);//아이디, 비밀번호 입력창
		textId.setBackground(Color.white);
		textPwd=new JTextField(20);
		textPwd.setBackground(Color.white);
		
		laId=new JLabel("      ID");//아이디, 비밀번호 라벨
		laPwd=new JLabel("Password");
		
		pC.add(laId);
		pC.add(textId);
		pC.add(laPwd);
		pC.add(textPwd);
		pC.add(bJoin);
		pC.add(bLogin);
		
		//4. 페이지를 넘어가는 방식 
		tabP=new JTabbedPane();
		myPage=new JPanel();
		add(tabP);
		tabP.add(p,"Login");
		tabP.add(myPage,"마이페이지");
		tabP.setSelectedIndex(0);//5. 로그인이 0, 마이페이지가 1   보여줄 페이지를 조절
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		Gui01_Login my01=new Gui01_Login();
		my01.setSize(500,700);
		my01.setVisible(true);

	}

}
