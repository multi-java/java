package subway;
/** 
 * 다양한 선택이 가능한 소비자 중심의 토스트 판매 애플리케이션  
 * 
 * 회원가입 화면 : 이름, 생년월일, 아이디, 비밀번호, 연락처를 기입하는 회원가입 과정  
 * 
 * 1) 회원가입을 하지않으려면 뒤로가기 버튼을 누르며느 자동으로 로그인 화면으로 이동.
 * 2) 고객정보 저장해서 회원가입
 * 	<1> 필수 입력 정보가 공백으로 남을 경우, 경고 창이 뜨며 다시 입력할 수 있음.
 *  <2> 생년월일이 숫자 입력이 아닐 경우, 경고 창이 뜨며 다시 입력할 수 있음.
 *  <3> 아이디 중복체크하여 이미 가입한 아이디의 경우, 경고 창이 뜨며 다시 입력할 수 있음.
 *  <4> 회원가입하면 고객정보 저장하고 , 자동으로 로그인화면으로 이동
 * 
 * 작성자: 김보미
 * 작성일: 22-07-27
 * 버전: 1.1
 */


import javax.swing.*;     
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**1.회원가입 화면에 대한 클래스*/
public class Gui03_JoinMembership extends JFrame {
	JFrame f = new JFrame(":: Cafe7 App v1.1 ");
	JPanel p,pN,pC,pS; 
	JButton bJoin,bBack; 
	JTextField tId, tPwd, tName,tPhone, tBirthdate; 
	JLabel laId, laPwd, laName,laPhone, laBirthdate;
	JLabel laText;
	Icon iconBack,iconJoin;
	
	/**2.회원가입한 고객정보를 저장하기위한 ArrayList 클래스*/
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
		
		/**2-1)  customers(ArrayList)에 같은 아이디를 갖는 객체가 있는지를 확인하는 메서드*/
		public static boolean findID(String id) {
			for (int i=0; i<customers.size(); i++) {
				Customer c = customers.get(i);
				if (c.getId().equals(id)) return true;
			}
			return false;
		}
		/**2-2)  customers(ArrayList)에 같은 비밀번호를 갖는 객체가 있는지를 확인하는 메서드*/
		public static boolean findPW(String pw) {
			for (int i=0; i<customers.size(); i++) {
				Customer c = customers.get(i);
				if (c.getPassword().equals(pw)) return true;
			}
			return false;
		}
		/**2-3)  아이디, 비밀번호가 일치하는지를 확인하여 로그인 가능 여부를 확인하는 메서드*/
		public static boolean findIDPW(String id, String pw) {
			for (int i=0; i<customers.size(); i++) {
				Customer c = customers.get(i);
				if (c.getId().equals(id) && c.getPassword().equals(pw)) return true;
			}
			return false;
		}
		
		/**2-4) private 접근자를 갖는  customers(ArrayList)를 외부에서 접근하기 위해 제공하는 getter(캡슐화) 메서드*/
		public static ArrayList<Customer> getCustomers() {
			return customers;
		}
		/**2-5) private 접근자를 갖는  customers(ArrayList)를 외부에서 접근하기 위해 제공하는 setter(캡슐화) 메서드 */
		public static void setCustomers(Customer customers) {
			Gui03_JoinMembership.customers.add(customers);
		}


		/**3. 프레임에 여백을 주는 메서드*/
		@Override
		public Insets getInsets () {
			Insets in=new  Insets(10,10,10,10);
			return in;
		}
		
		/**4. 회원가입 화면구성에 대한 생성자*/
		public Gui03_JoinMembership() {
			
			super(":: Cafe7 App v1.1 ");
			
			/**4-1)전체 패널(p)를  BorderLayout구성 : pC(중앙), pS(남쪽), pN(북쪽)*/
			p=new JPanel(new BorderLayout(10, 10));
			p.setBackground(Color.white);
			p.add(pC=new JPanel(),"Center");
			pC.setBackground(Color.white);
			
			/**4-2) 북쪽의 pN: 회원가입 로고와 뒤로가기 버튼 부착
			 - 위쪽으로 여백이 생기도록 pN의 레이아웃을 BorderLayout으로 설정*/
			p.add(pN=new JPanel(new BorderLayout()),"North"); 
			pN.setBackground(Color.white);

				/**북쪽의 pN에 회원가입 로고 */
			iconJoin=new ImageIcon("joinlogo3.png"); 
			laText=new JLabel(iconJoin); 
			pN.add(laText); 
			
				/** pN의 위쪽에 여백이 생기도록 pN의 가운데에 pnN을 새로 배치*/
			JPanel pnN = new JPanel();
			pnN.setBackground(Color.white);
			pN.add(pnN, "Center");

				/** pN의 위쪽에 여백이 생기도록 빈 라벨 삽입*/
			pN.add(new JLabel(" "), "North");
			
				/** 뒤로가기 버튼**/
			pnN.add(laText); 
			iconBack=new ImageIcon("돌아가기.png");
			bBack=new JButton(iconBack);
			bBack.setBackground(Color.white);
			
			pnN.add(bBack);
			
			/**4-3) 중앙의 pC에 회원가입에 대한 정보 입력칸
			 * -라벨과 입력칸을 넣기위해 GridLayout 5,2 설정 */
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
			
				/** 5줄, 2열의 GridLayout에 넣을 첫 번째 패널: 아이디 라벨*/
			JPanel pn1 = new JPanel();
			pn1.setBackground(Color.white);
			pn1.add(laId);
			pC.add(pn1);
				/** 5줄, 2열의 GridLayout에 넣을 두 번째 패널: 아이디 입력칸
				 * -tId를 GridLayout에 넣지 않고 패널을 통하여 넣으면 텍스트필드가 패널크기와 같지않으니 보다 얇은 높이로 형성
				 * - 아래의 입력칸들에 같은 효과 */
			JPanel pn2 = new JPanel();
			pn2.setBackground(Color.white);
			pn2.add(tId);
			pC.add(pn2);
				/** 5줄, 2열의 GridLayout에 넣을 세 번째 패널: 비밀번호 라벨 */
			JPanel pn3 = new JPanel();
			pn3.setBackground(Color.white);
			pn3.add(laPwd);
			pC.add(pn3);
				/** 5줄, 2열의 GridLayout에 넣을 네 번째 패널 : 비밀번호 입력칸 */
			JPanel pn4 = new JPanel();
			pn4.setBackground(Color.white);
			pn4.add(tPwd);
			pC.add(pn4);
				/** 5줄, 2열의 GridLayout에 넣을 다섯 번째 패널: 이름 라벨*/
			JPanel pn5 = new JPanel();
			pn5.setBackground(Color.white);
			pn5.add(laName);
			pC.add(pn5);
				/** 5줄, 2열의 GridLayout에 넣을 여섯 번째 패널: 이름 입력칸*/
			JPanel pn6 = new JPanel();
			pn6.setBackground(Color.white);
			pn6.add(tName);
			pC.add(pn6);
				/** 5줄, 2열의 GridLayout에 넣을 일곱 번째 패널: 생년월일 라벨*/
			JPanel pn7 = new JPanel();
			pn7.setBackground(Color.white);
			pn7.add(laBirthdate);
			pC.add(pn7);
				/** 5줄, 2열의 GridLayout에 넣을 여덟 번째 패널: 생년월일 입력칸*/
			JPanel pn8 = new JPanel();
			pn8.setBackground(Color.white);
			pn8.add(tBirthdate);
			pC.add(pn8);
				/** 5줄, 2열의 GridLayout에 넣을 아홉 번째 패널: 연락처 라벨*/
			JPanel pn9 = new JPanel();
			pn9.setBackground(Color.white);
			pn9.add(laPhone);
			pC.add(pn9);
				/** 5줄, 2열의 GridLayout에 넣을 열 번째 패널: 연락처 입력칸*/
			JPanel pn10 = new JPanel();
			pn10.setBackground(Color.white);
			pn10.add(tPhone);
			pC.add(pn10);
			
			/**4-4) 남쪽의 pS의 아래쪽에 여백이 생기도록 GridLayout 설정*/
			p.add(pS=new JPanel(new GridLayout(2, 1)),"South"); 
			pS.setBackground(Color.white);
			p.add(new JLabel("   "), "East");
				/**pS에 회원가입 버튼*/ 
			JPanel pnS1 = new JPanel();
			pnS1.setBackground(Color.white);

			bJoin=new JButton(" 회원가입 ");
			bJoin.setBackground(Color.white);
			pnS1.add(bJoin);
			pS.add(pnS1);
			
				/** pS의 아래쪽에 여백이 생기도록 함*/
			JPanel pnS2 = new JPanel();
			pnS2.setBackground(Color.white);
			pS.add(pnS2);

			
			/**4-5) 버튼에 이벤트핸들러 부착*/
			MyEventHandler handler = new MyEventHandler();
			bBack.addActionListener(handler);
			bJoin.addActionListener(handler);
			
			/**4-6)전체 프레임 f에 모든 패널을 배치. 크기설정, 시각화 구현 및 창닫기 처리*/
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(p);
			f.setVisible(true);
			f.setSize(500,700);
		}
	
			
		/**5.회원가입 절차 및 로그인화면으로의 이동에 대한 이벤트 처리 담당 클래스*/
		class MyEventHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				Object obj=e.getSource();
				/**5-1)뒤로가기 버튼을 누르면 로그인화면으로 이동*/
				if(obj==bBack) {
					new Gui01_Login();
					p.setVisible(false);
				}
				/**5-2) 회원가입 버튼을 누르면, 절차에 따라 조건 충족 시 회원가입이 완료되고 로그인 화면으로 이동*/
				if(obj==bJoin) {
					String id=tId.getText().trim();
					String pwd=tPwd.getText().trim();
					String name=tName.getText().trim();
					String phone=tPhone.getText().trim();
					String birthDate = tBirthdate.getText().trim();
			        int iBirthDate = 0;
					
			        /** 빈 칸 있을 경우*/
			        if (id.isEmpty() || pwd.isEmpty() || name.isEmpty() || phone.isEmpty() || birthDate.isEmpty()) {
			            JOptionPane.showMessageDialog(p, "고객님의 정보를 입력해주십시오.", "회원정보", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
			       					
			        /** 생년월일 입력칸에 숫자가 아닌 문자를 입력할 경우*/
			        try {
			            iBirthDate = Integer.parseInt(birthDate);
			        } catch (NumberFormatException nfe) {
			            JOptionPane.showMessageDialog(p, "생년월일은 숫자만 입력 가능합니다.", "회원정보", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
					
			        /** 중복된 아이디의 경우: 사용자ID를 식별자로서 중복 체크한다. 사용자ID 이외 다른 값은 중복이 가능하다.**/
			        for (Customer customer : customers) {
			            if (customer.getId().equals(id)) {
			                JOptionPane.showMessageDialog(p, "이미 가입한 이이디입니다. 다른 아이디를 사용해주세요.", "회원정보", JOptionPane.WARNING_MESSAGE);
			                return;
			            }
			        }
			        
			        /** 위의 3가지 조건에 통과하면, 고객정보를 ArrayList인 customers에 저장하고 회원가입 완료
			         * - 회원가입을 완료하면 자동으로 로그인 화면으로 이동*/
			        customers.add(new Customer(name, id, pwd, phone, iBirthDate));
			        JOptionPane.showMessageDialog(p,"회원가입을 축하합니다");
			        f.setVisible(false);
			        new Gui01_Login();	
					
				}
					
					
			}
		}
		

}
