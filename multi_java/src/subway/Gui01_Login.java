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

	JPanel p,pS,pC; //화면 배경
	JPanel myPage;
	//JFrame p; 
	JButton bLogin, bJoin; //로그인, 회원가입 버튼
	JTextField textId, textPwd;// 로그인 입력창, 비밀번호 입력창
	JLabel laId, laPwd, laIcon;// 아이디, 비밀번호 라벨
	//Icon 
	JTabbedPane tabP;
	JButton[] bt=new JButton[5];

	public Gui01_Login() {
		
		super(":: Toast App v1.1 ");
		
		//배경
		//p=new JFrame();
		tabP=new JTabbedPane();
		p=new JPanel(new BorderLayout());
		myPage=new JPanel();
		//p.setLocationRelativeTo(null);
		add(tabP);
		tabP.add(p,"Login");
		tabP.add(myPage,"마이페이지");
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center");
		p.add(pS=new JPanel(),"South");
		pS.setLayout(new GridLayout(1,5));
		for(int i=0;i<bt.length;i++) {
			bt[i]=new JButton("이미지");
			pS.add(bt[i]);
		}
		
		tabP.setSelectedIndex(1);
		
		//pC의 레이아웃을 GridLayout(2,1)
		//laIcon를 생성해서 pC에 붙이기
		//pC에 pC_b 생성해 붙이기
		
		//pC_b에 GridLayout(3,2) 아이디 textId 비밀번호 textPwd, btLogin
		
		//로그인, 회원가입 버튼
		/*setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		btn1.setBounds(30, 170, 122, 30);*/
		
		bLogin=new JButton(" 로그인 ");
		bLogin.setBackground(Color.white);
		//bLogin.setBounds(30, 170, 122, 30);
		
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
		//bJoin.setBounds(100, 50, 122, 30);
		
		p.add(bLogin);
		p.add(bJoin);
		
		// 로그인 입력창, 비밀번호 입력창
		textId=new JTextField(20);
		textId.setBackground(Color.white);
		textPwd=new JTextField(20);
		textPwd.setBackground(Color.white);
	
		p.add(textId);
		p.add(textPwd);
		
		// 아이디, 비밀번호 라벨
		laId=new JLabel("      ID");
		laPwd=new JLabel("Password");
		//laID.setBounds(30,40,450,20);  
		//laPwd.setBounds(50,140,450,20);  
		p.add(laId);
		p.add(laPwd);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		Gui01_Login my=new Gui01_Login();
		my.setSize(500,700);
		my.setVisible(true);

	}

}
