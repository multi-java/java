package subway;
/** 
 * 회원가입 화면
 * 
 * 작성자: 김보미
 * 작성일: 22-07-23
 * 버전: 1.1
 */
import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui03_JoinMembership extends JFrame {
	JFrame f = new JFrame();
	JPanel p,pN,pC,pS; 
	JButton bJoin,bBack; 
	JTextField tId, tPwd, tName,tPhone, tBirthdate; 
	JLabel laId, laPwd, laName,laPhone, laBirthdate;
	JLabel laText;
	Icon iconBack;
	
	
	/** 1. 회원가입한 고객정보를 저장하기위해 ArrayList 생성 및 캡슐화 
	 * -findID는 ArrayList에 id가 있는지 확인을 합니다. 
	 * -findIDPW는 ArrayList에 id, pw가 있는지 확인을 해서 로그인 가능여부를 확인합니다.
	 * */
private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public static boolean findID(String id) {
		for (int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.getId().equals(id)) return true;
		}
		return false;
	}
	public static boolean findPW(String pw) {
		for (int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.getPassword().equals(pw)) return true;
		}
		return false;
	}
	public static boolean findIDPW(String id, String pw) {
		for (int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.getId().equals(id) && c.getPassword().equals(pw)) return true;
		}
		return false;
	}

	
	public static ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public static void setCustomers(Customer customers) {
		Gui03_JoinMembership.customers.add(customers);
	}


	
		@Override
		public Insets getInsets () {
			Insets in=new  Insets(10,10,10,10);
			return in;
		}
		
		public Gui03_JoinMembership() {
			
			super(":: Toast House App v1.1 ");
			
			/**1.전체 패널(p)를  BorderLayout구성*/
			p=new JPanel(new BorderLayout(10,10));
			p.setBackground(Color.white);
			p.add(pC=new JPanel(),"Center");
			pC.setBackground(Color.white);
			p.add(pN=new JPanel(),"North"); 
			pN.setBackground(Color.white);
			p.add(pS=new JPanel(),"South"); 
			pS.setBackground(Color.white);
			
			/**2. 북쪽의 pN에 회원가입문구 */
			laText=new JLabel("회원가입"); 
			laText.setHorizontalTextPosition(JLabel.CENTER);
			laText.setVerticalTextPosition(JLabel.TOP);
			laText.setFont(new Font("sans-serif",Font.BOLD,28));
			pN.add(laText); 
			
			
			/**3. 중앙의 pC에 회원가입에 대한 정보 입력칸*/
			pC.setLayout(new GridLayout(5,2,30,30));
					
			laId=new JLabel("아이디", JLabel.CENTER);
			laPwd=new JLabel("비밀번호", JLabel.CENTER);
			laName=new JLabel("이름", JLabel.CENTER);
			laBirthdate=new JLabel("생년월일", JLabel.CENTER);
			laPhone=new JLabel("연락처", JLabel.CENTER);
	
					
			tId=new JTextField(15);
			tId.setBackground(Color.white);
			tPwd=new JTextField(15);
			tPwd.setBackground(Color.white);
			tName=new JTextField(15);
			tName.setBackground(Color.white);
			tBirthdate=new JTextField(15);
			tBirthdate.setBackground(Color.white);
			tPhone=new JTextField(15);
			tPhone.setBackground(Color.white);
		
				
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
			
			
			/**4.남쪽의 pS에 회원가입, 뒤로 버튼*/ //이전버튼을 제목옆에 위로 올리기
			bJoin=new JButton(" 회원가입 ");
			bJoin.setBackground(Color.white);
			pS.add(bJoin);
			
			iconBack=new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\icon_back.png");
			bBack=new JButton(iconBack);
			bBack.setBackground(Color.white);
			pS.add(bBack);
			
			//이벤트핸들러 부착
			MyEventHandler handler = new MyEventHandler();
			bBack.addActionListener(handler);
			bJoin.addActionListener(handler);
			
			/**5.전체 프레임 f에 전체 패널p를 배치. 
			 * 크기설정, 시각화 구현 및 창닫기 처리*/
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(p);
			f.setVisible(true);
			f.setSize(500,700);
		}
		
		/**6.이벤트처리로 회원가입 절차
		 *  뒤로 버튼을 누르면 로그인화면으로 이동
		 *  
		 * 회원가입 버튼을 누르면 고객정보 저장해서 회원가입하고, 메인화면으로 이동
		 * 
		 * -빈칸 입력 체크: 빈칸 있으면 경고메시지 "고객님의 정보를 입력해주십시오." 
		 * -생년월일 숫자 체크 : 숫자외에는 경고메시지"생년월일은 숫자만 입력 가능합니다."
		 * 							+ NumberFormatException을 try~catch절로 예외처리
		 * -아이디 중복 체크: for반복문으로 arraylist에 저장된 ID를 식별자로  중복체크해서, 
		 * 					중복ID의 경우 경고메시지 "이미 가입한 이이디입니다."
		 * - 회원 정보를 ArrayList에 저장하여 회원가입 완료하고 메인화면으로 이동
		 * */
		
			
		
		class MyEventHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				if(obj==bBack) {//뒤로 버튼
					new Gui01_Login();
					p.setVisible(false);
				}
				if(obj==bJoin) {//회원가입 버튼
					//입력한 값
					String id=tId.getText().trim();
					String pwd=tPwd.getText().trim();
					String name=tName.getText().trim();
					String phone=tPhone.getText().trim();
					String birthDate = tBirthdate.getText().trim();
			        int iBirthDate = 0;
					
			        // 빈칸 입력 체크
			        if (id.isEmpty() || pwd.isEmpty() || name.isEmpty() || phone.isEmpty() || birthDate.isEmpty()) {
			            JOptionPane.showMessageDialog(p, "고객님의 정보를 입력해주십시오.", "회원정보", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
			        //NullPointerException 확인해보기
					
			        // 생년월일 숫자 변환
			        try {
			            iBirthDate = Integer.parseInt(birthDate);
			        } catch (NumberFormatException nfe) {
			            JOptionPane.showMessageDialog(p, "생년월일은 숫자만 입력 가능합니다.", "회원정보", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
					
			        // 아이디 중복 체크:  식별자인 사용자ID 값으로만 중복체크를 한다. 사용자ID 이외 다른 값은 중복이 가능하다.
			        for (Customer customer : customers) {
			            if (customer.getId().equals(id)) {
			                JOptionPane.showMessageDialog(p, "이미 가입한 이이디입니다. 다른 아이디를 사용해주세요.", "회원정보", JOptionPane.WARNING_MESSAGE);
			                return;
			            }
			        }
			        
			     // 회원가입 등록
			        customers.add(new Customer(name, id, pwd, phone, iBirthDate));
			        
			        JOptionPane.showMessageDialog(p,"회원가입을 축하합니다");
			        f.setVisible(false);
			        //new Gui02_MainHome();
			        new Gui01_Login();
						
					
				}//if
					
					
			}// 보이드
		}//핸들러 클래스
		

}//클래스