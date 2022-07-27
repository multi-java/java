package login;
/** 
 * 	마이페이지 회원탈퇴 화면
 *	작성자 정유진
 * 	작성일 7:26  
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MP04_Delete extends JFrame {
	JFrame f=new JFrame();
	JPanel p,pN,pC,pS;
	JLabel title;
	Icon titleLogo;
	JLabel w1,w2,w3,w4,w5,w6;
	JButton btBefore,btDel;
	
	@Override
	public Insets getInsets () { 
		Insets in=new  Insets(10,10,10,10);
		return in;
	}
	
	/** 1. 회원 탈퇴 화면 GUI
	 */
	public MP04_Delete() {
		super(":: Toast House App v1.1 ");
		
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p=new JPanel(new BorderLayout(10,10)); 
		p.setBackground(Color.white);
		p.add(pC=new JPanel(),"Center"); 
		pC.setBackground(Color.white);
		p.add(pN=new JPanel(),"North"); 
		pN.setBackground(Color.white);
		p.add(pS=new JPanel(),"South"); 
		pS.setBackground(Color.white);

		/**1.1 마이페이지 타이틀*/
		titleLogo=new ImageIcon("image/MyPage.jpg");
		title=new JLabel(titleLogo);
		pN.add(title);

		/**1.2 버튼*/
		pS.setLayout(new GridLayout(1,2));
		btBefore = new JButton("취 소");
		
		
		btDel = new JButton("회원 탈퇴");
		btDel.setBackground(Color.red);
		btDel.setForeground(Color.white);
		
		btBefore.setFont(new Font("sans-serif",Font.BOLD,30));
		pS.add(btBefore);
		btDel.setFont(new Font("sans-serif",Font.BOLD,30));
		pS.add(btDel);
		
		
		/**1.3 탈퇴 고객 안내문*/
		pC.setLayout(new GridLayout(6,1));
		w1=new JLabel(" ");
		w2= new JLabel("cafe7 회원탈퇴 시 ");
		w2.setFont(new Font("NanumGothic",Font.BOLD,20));
		w3= new JLabel("회원정보 및 서비스 이용기록은 모두 삭제되며");
		w3.setFont(new Font("NanumGothic",Font.BOLD,20));
		w4= new JLabel("삭제된 데이터는 복구가 불가능합니다.");
		w4.setFont(new Font("NanumGothic",Font.BOLD,20));
		w5= new JLabel("그동안 cafe7을 이용해주셔서 감사합니다.");
		w5.setFont(new Font("NanumGothic",Font.BOLD,20));
		w6= new JLabel(" ");
		
		pC.add(w1);
		pC.add(w2);
		pC.add(w3);
		pC.add(w4);
		pC.add(w5);
		pC.add(w6);

			f.add(p);
			f.setVisible(true);
				
			
			//버튼 활성화
			MyEventHandler handler = new MyEventHandler();
			btBefore.addActionListener(handler);
			btDel.addActionListener(handler);

		}
			class MyEventHandler implements ActionListener{
				
				/** 2. 정보 삭제
				 * 현재 로그인한 계정의 아이디가 담긴 배열의 정보를 삭제하기 위한 if문
				 */
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					if(obj==btDel) {
						for(int i=0;i<Gui03_JoinMembership.getCustomers().size();i++) {
							if(Gui03_JoinMembership.getCustomers().get(i).getId().equals(Gui01_Login.id))
							{
								Gui03_JoinMembership.getCustomers().remove(i);
							}
						}
						new Gui01_Login();	
						f.setVisible(false);
				}else if(obj==btBefore)
				{
					new MP01_Main();	
					f.setVisible(false);
				}
			
			}

	}
	}

