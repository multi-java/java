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
//
public class Gui01_Login_explanation  extends JFrame {

	JPanel p,pS,pC; //1.pS(남쪽 판넬), pC(중앙 판넬) 새로 생성 // 화면 구성에 대한 질문 했을 때
	JPanel myPage;//5.새로 패널 생성  // 로그인 버튼을 누르면 이벤트처리를 해서 링크로 다른 페이지로 넘어가면 되냐는 질문했을 때
	JButton bLogin, bJoin; //로그인, 회원가입 버튼
	JTextField textId, textPwd;// 로그인 입력창, 비밀번호 입력창
	JLabel laId, laPwd;// 아이디, 비밀번호 라벨
	JLabel laIcon;//새로 생성
	//Icon 
	JTabbedPane tabP; //새로 생성/
	JButton[] bt=new JButton[5]; //2.pS넣을 버튼을 새로 생성 /임의로 5개로 준 것이니, 창을 실제로 구현할때는 JButton에 배열하지말고 각각 변수선언 하라고 하심

	public Gui01_Login_explanation() {
		
		super(":: Toast House App v1.1 ");
		
		//배경
		tabP=new JTabbedPane(); //5.
		p=new JPanel(new BorderLayout()); //1. 보더 레이아웃 설정
		myPage=new JPanel();//5.
		add(tabP);//5.
		tabP.add(p,"Login");//5.
		tabP.add(myPage,"마이페이지");//5.
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); //1.pC를 p의 중앙에 붙임
		p.add(pS=new JPanel(),"South"); //1. pS를 p의 남쪽에 붙임
		pS.setLayout(new GridLayout(1,5));//2. 버튼이 떨어져 구현되니까 동등하게 5칸으로 나누려면 그리드레이아웃 적용
		
		for(int i=0;i<bt.length;i++) { //2. 새로운 버튼 5개를 아래쪽에 구현// 임의로 "이미지"라는 문구. 이미지를 넣으면 적절
			bt[i]=new JButton("이미지");
			pS.add(bt[i]);
		}
		
		tabP.setSelectedIndex(1);//5. 로그인이 0, 마이페이지가 1  보여줄 페이지를 넣어주면 됨. 이렇게 보여줄 페이지를 코드로 조절할 수 있다고 함
		
		//pC의 레이아웃을 GridLayout(2,1) //3. pC를 나누어
		//laIcon를 생성해서 pC에 붙이기//3. 위에는 로고
		//pC에 pC_b 생성해 붙이기//3. pC의 아래쪽(bottom)에는 새로운 패널을 pC_b 붙임
		
		//pC_b에 GridLayout(3,2) 아이디 textId 비밀번호 textPwd, btLogin// 4. 중앙의 아래쪽판넬에 아이디 비밀번호 구현 =>자리배치 완료
		
		bLogin=new JButton(" 로그인 ");
		bLogin.setBackground(Color.white);
				
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
		
		
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
		p.add(laId);
		p.add(laPwd);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		Gui01_Login_explanation my=new Gui01_Login_explanation();
		my.setSize(500,700);
		my.setVisible(true);

	}

}
