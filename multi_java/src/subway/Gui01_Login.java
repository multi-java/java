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

	JPanel p,pS,pC,pC_b; //1.pS(남쪽 판넬), pC(중앙 판넬) 새로 생성 // 화면 구성에 대한 질문 했을 때
	JPanel myPage;//5.새로 패널 생성  // 로그인 버튼을 누르면 이벤트처리를 해서 링크로 다른 페이지로 넘어가면 되냐는 질문했을 때
	JButton bbMypage, bbMenu, bbMymenu; //2.pS넣을 버튼을 새로 생성 
	JButton bLogin, bJoin; //로그인, 회원가입 버튼
	JTextField textId, textPwd;// 로그인 입력창, 비밀번호 입력창
	JLabel laId, laPwd;// 아이디, 비밀번호 라벨
	JLabel laIcon;//새로 생성
	Icon iconMenu, iconMymenu,iconMypage, iconLogo;
	JTabbedPane tabP; //새로 생성
	
	//컨테이너의 바깥 여백을 주는 메서드를 오버라이딩 //day11 MySearchEngine
	@Override
	public Insets getInsets () { //Insets 객체를 반환해야함
		Insets in=new  Insets(10,10,10,10);//top,left,bottom.right 반시계방항 //컨트롤 스페이스바 누르면 생성자가 나온다
		return in;
	}
	
	//클래스 괄호가 여기 있어야 하는거 아닌가??

	public Gui01_Login() {
		
		super(":: Toast House App v1.1 ");
		
		//배경
		
		
		p=new JPanel(new BorderLayout()); //1. 보더 레이아웃 설정
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); //1.pC를 p의 중앙에 붙임
		p.add(pS=new JPanel(),"South"); //1. pS를 p의 남쪽에 붙임
		
		pS.setLayout(new GridLayout(1,3));//2. 버튼이 떨어져 구현되니까 동등하게 나누려면 그리드레이아웃 적용
	
		iconMymenu=new ImageIcon("icon_mymenu.png");
		iconMenu=new ImageIcon("icon_menu.png");
		iconMypage=new ImageIcon("icon_mypage.png");

		bbMypage=new JButton(iconMypage );
		bbMenu=new JButton( iconMenu);
		bbMymenu=new JButton(iconMymenu);

		pS.add(bbMypage);
		pS.add(bbMenu);
		pS.add(bbMymenu);
		
		//pC의 레이아웃을 GridLayout(2,1) //3. pC를 나누어
		pC.setLayout(new GridLayout(2,1));
		
		//laIcon를 생성해서 pC에 붙이기//3. 위에는 로고
		iconLogo=new ImageIcon("toastlogo");
		laIcon=new JLabel(iconLogo); //
		pC.add(laIcon); //로고가 왜 안보이지?? 갑자기 패인이 가려짐ㅠㅠ
		
		//pC에 pC_b 생성해 붙이기//3. pC의 아래쪽(bottom)에는 새로운 패널을 pC_b 붙임
		pC.add(pC_b=new JPanel());
		
		//pC_b에 GridLayout(3,20) 아이디 textId 비밀번호 textPwd, btLogin// 4. 중앙의 아래쪽판넬에 아이디 비밀번호 구현 =>자리배치 완료
		pC_b.setLayout(new GridLayout(3,2,30,50));
		
		
		bLogin=new JButton(" 로그인 ");
		bLogin.setBackground(Color.white);
				
		bJoin=new JButton(" 회원가입 ");
		bJoin.setBackground(Color.white);
		
		
		// 로그인 입력창, 비밀번호 입력창
		textId=new JTextField(20);
		textId.setBackground(Color.white);
		textPwd=new JTextField(20);
		textPwd.setBackground(Color.white);
		
		// 아이디, 비밀번호 라벨
		laId=new JLabel("      ID");
		laPwd=new JLabel("Password");
		
		
		pC_b.add(laId);
		pC_b.add(textId);
		pC_b.add(laPwd);
		pC_b.add(textPwd);
		pC_b.add(bJoin);
		pC_b.add(bLogin);
		
		tabP=new JTabbedPane(); //5.
		myPage=new JPanel();//5.
		add(tabP);//5.
		tabP.add(p,"Login");//5.
		tabP.add(myPage,"마이페이지");//5.
		tabP.setSelectedIndex(0);//5. 로그인이 0, 마이페이지가 1  보여줄 페이지를 넣어주면 됨. 이렇게 보여줄 페이지를 코드로 조절할 수 있다고 함
		
		
		//bLogin(로그인 후 메뉴선택페이지), bJoin(회원가입 페이지) 버튼에 대한 이벤트 처리
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Object obj=e.getSource();//이벤트가 발생된 객체
				//String cmd=e.getActionCommand();//이벤트소스의 라벨문자열을 반환한다.
				//setTitle(cmd);//Daum이라고 바뀜
				//((JButton)obj).setBackground(Color.pink); //부모타입 Object로는 setBackground를 못쓰니까  bt의 자료유형인 JButton으로 형변환
			}
		});
		
		//anonymous class
		//ActionListener는 인터페이스라서 new할 수 없고 오류나는데, {}해서 이름없는 로컬이너클래스를 활용함.
				/*day11의 MyGui경우 전체적인 이벤트처리를 경우에 따라 진행
				 * 이번 경우는 다소 비효율적이지만, 개별적이고 특수한 전용 이벤트 처리를 해주는 효과가 있다. 		 */
		bJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bJoin.setBackground(Color.yellow);
				//setTitle(str[1]+"버튼을 눌렀군요");
			}
		});
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		Gui01_Login my=new Gui01_Login();
		my.setSize(500,700);
		my.setVisible(true);

	}

}
