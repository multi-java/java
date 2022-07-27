package subway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** 
 * 앱의 첫 화면을 구성할 클래스 생성
 * 타이틀 설정: :: Toast App v1.1 
 * JPanel p: 앱의 흰색 배경으로 구현
 * JButton bLogin, bJoin: 로그인, 회원가입 버튼을 흰색 배경으로 구현
 * JTextField textId, textPwd: 로그인 입력창, 비밀번호 입력창을 흰색 배경으로 구현
 * JLabel laId, laPwd: 아이디, 비밀번호 라벨 구현
 * 창닫기 프로세스
 * 메인메소드에서 JFrame을 호출해 setSize(),setVisible()처리
 * 
 * 작성자: 김보미
 * 작성일: 22-07-20
 * 버전: 1.1
 */

public class FistLogin_Gui  extends JFrame {

	JPanel p; //화면 배경
	//JFrame p; 
	JButton bLogin, bJoin; //로그인, 회원가입 버튼
	JTextField textId, textPwd;// 로그인 입력창, 비밀번호 입력창
	JLabel laId, laPwd;// 아이디, 비밀번호 라벨
	//Icon 

	public FistLogin_Gui() {
		
		super(":: Toast App v1.1 ");
		
		//배경
		//p=new JFrame();
		p=new JPanel();
		//p.setLocationRelativeTo(null);
		add(p);
		p.setBackground(Color.white);
		
		
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
		FistLogin_Gui my=new FistLogin_Gui();
		my.setSize(500,700);
		my.setVisible(true);

	}

}
