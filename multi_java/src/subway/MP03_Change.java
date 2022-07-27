package subway;

/** 
 * 	마이페이지 개인정보 수정 화면
 *	 작성자 정유진
 * 	작성일 7:26  
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MP03_Change extends JFrame {
	JFrame f = new JFrame();
	JPanel p, pN, pC, pS;
	JButton bJoin, bBack;
	JTextField tId, tPwd, tName, tPhone, tBirthdate;
	JLabel laId, laPwd, laName, laPhone, laBirthdate,Lblogo;
	JLabel laText;
	
	/**
	 * 1.정보 수정 화면에 대한 클래스
	 */
	private static ArrayList<Customer> customers = Gui03_JoinMembership.getCustomers();

	public static boolean findID(String id) {
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(0);
			if (c.getId().equals(id))
				return true;
		}
		return false;
	}

	public static boolean findPW(String pw) {
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.getPassword().equals(pw))
				return true;
		}
		return false;
	}

	public static boolean findIDPW(String id, String pw) {
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.getId().equals(id) && c.getPassword().equals(pw))
				return true;
		}
		return false;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(Customer customers) {
		MP03_Change.customers.add(customers);
	}

	@Override
	public Insets getInsets() {
		Insets in = new Insets(10, 10, 10, 10);
		return in;
	}

	/** 2. 정보 조회 화면 GUI */
	public MP03_Change() {

		super(":: Toast House App v1.1 ");

		/** 2.1 전체 패널 BorderLayout구성 */
		p = new JPanel(new BorderLayout(10, 10));
		p.setBackground(Color.white);
		p.add(pC = new JPanel(), "Center");
		pC.setBackground(Color.white);
		p.add(pN = new JPanel(), "North");
		pN.setBackground(Color.white);
		p.add(pS = new JPanel(), "South");
		pS.setBackground(Color.white);
		
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg"));
		Lblogo.setBounds(5, 5, 100, 100);
		f.getContentPane().add(Lblogo); // 까페로고 패널 위 붙이기

		p.add(new JLabel("   "), "East");

		/** 2.2 타이틀 */
		laText = new JLabel("정보 수정");
		laText.setHorizontalTextPosition(JLabel.CENTER);
		laText.setVerticalTextPosition(JLabel.TOP);
		laText.setFont(new Font("sans-serif", Font.BOLD, 28));
		pN.add(laText);

		/** 2.3 중심 화면- 정보 입력칸 */
		pC.setLayout(new GridLayout(5, 2, 30, 30));

		laId = new JLabel("아이디 ", JLabel.CENTER);
		laId.setFont(new Font("NanumGothic", Font.BOLD, 26));
		laPwd = new JLabel("비밀번호", JLabel.CENTER);
		laPwd.setFont(new Font("NanumGothic", Font.BOLD, 26));
		laName = new JLabel("이름", JLabel.CENTER);
		laName.setFont(new Font("NanumGothic", Font.BOLD, 26));
		laBirthdate = new JLabel("생년월일", JLabel.CENTER);
		laBirthdate.setFont(new Font("NanumGothic", Font.BOLD, 26));
		laPhone = new JLabel("연락처", JLabel.CENTER);
		laPhone.setFont(new Font("NanumGothic", Font.BOLD, 26));

		JPanel pnN = new JPanel();

		pnN.setBackground(Color.white);
		pN.add(pnN, "Center");
		// pN의 위쪽에 여백이 생기도록 빈 라벨을 넣는다.
		pN.add(new JLabel(" "), "North");
		pnN.add(laText);

		/**
		 * 3. 회원 정보 수정 회원가입 시 배열에 저장된 개인 정보를 꺼내와서 출력한다.
		 * 
		 * 로그인 시 입력한 아이디 Gui01_Login.id 를 if문과 for루프를 통해 배열에 저장된 아이디들과 비교하여 동일한 아이디를 발견
		 * 시 해당 아이디의 정보들을 변수에 저장하여 출력한다.
		 * 
		 * 
		 */

		String a = "";
		String b = "";
		int c = 0;
		String d = "";
		int i = 0;

		/**
		 * 2.1 로그인한 아이디와 일치하는 정보를 가진 배열을 탐색하는 for루프
		 */
		for (; i < Gui03_JoinMembership.getCustomers().size(); i++) {
			if (Gui03_JoinMembership.getCustomers().get(i).getId().equals(Gui01_Login.id)) {
				a = Gui03_JoinMembership.getCustomers().get(i).getPassword();
				b = Gui03_JoinMembership.getCustomers().get(i).getName();
				c = Gui03_JoinMembership.getCustomers().get(i).getBirthdate();
				d = Gui03_JoinMembership.getCustomers().get(i).getPhone();
			}
		}

		/**
		 * 3. 정보 수정란 텍스트필드에 적힌 기존의 정보를 지우고 새로운 정보를 입력한 뒤 저장 버튼을 누르면 정보 수정 완료
		 */
		tId = new JTextField(Gui01_Login.id, 15);
		tId.setFont(new Font("NanumGothic", Font.BOLD, 26));
		tId.setBackground(Color.white);
		tPwd = new JTextField(a, 15);
		tPwd.setFont(new Font("NanumGothic", Font.BOLD, 26));
		tPwd.setBackground(Color.white);
		tName = new JTextField(b, 15);
		tName.setFont(new Font("NanumGothic", Font.BOLD, 26));
		tName.setBackground(Color.white);
		tBirthdate = new JTextField(String.valueOf(c), 15);
		tBirthdate.setFont(new Font("NanumGothic", Font.BOLD, 26));
		tBirthdate.setBackground(Color.white);
		tPhone = new JTextField(d, 15);
		tPhone.setFont(new Font("NanumGothic", Font.BOLD, 26));
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

		/** 4.남쪽의 pS에 저장, 뒤로 버튼 */ // 이전버튼을 제목옆에 위로 올리기
		bJoin = new JButton(" 저 장 ");
		bJoin.setFont(new Font("NanumGothic", Font.BOLD, 26));
		bJoin.setBackground(Color.white);
		pS.add(bJoin);

		bBack = new JButton(" 취 소 ");
		bBack.setFont(new Font("NanumGothic", Font.BOLD, 26));
		bBack.setBackground(Color.white);
		pS.add(bBack);

		// 이벤트핸들러 부착
		MyEventHandler handler = new MyEventHandler();
		bBack.addActionListener(handler);
		bJoin.addActionListener(handler);

		/**
		 * 5.전체 프레임 f에 전체 패널p를 배치. 크기설정, 시각화 구현 및 창닫기 처리
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		f.setSize(500, 700);
	}

	/**
	 * 6.이벤트처리로 정보 수정 절차 - 회원가입과 동일한 절차 뒤로 버튼을 누르면 마이페이지 화면으로 이동
	 * 
	 * 정보 수정 버튼을 누르면 고객정보 수정하고, 마이페이지 화면으로 이동 -빈칸 입력 체크: 빈칸 있으면 경고메시지 "고객님의 정보를
	 * 입력해주십시오." -생년월일 숫자 체크 : 숫자외에는 경고메시지"생년월일은 숫자만 입력 가능합니다." +
	 * NumberFormatException을 try~catch절로 예외처리 -아이디 중복 체크: for반복문으로 arraylist에 저장된
	 * ID를 식별자로 중복체크해서, 중복ID의 경우 경고메시지 "이미 가입한 이이디입니다." - 회원 정보를 ArrayList에 저장하여 정보
	 * 수정 완료하고 마이페이지 화면으로 이동
	 */

	class MyEventHandler implements ActionListener {
		String lId;

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == bBack) {// 뒤로 버튼
				new MP01_Main();
				f.setVisible(false);
			}
			/**
			 * 새로 기입한 정보를 배열에 저장
			 */
			if (obj == bJoin) {// 정보 수정 버튼

				lId = tId.getText().trim();
				Gui03_JoinMembership.getCustomers().get(0).setId(lId);
				Gui03_JoinMembership.getCustomers().get(0).getId();

				String id = tId.getText().trim();
				String pwd = tPwd.getText().trim();
				String name = tName.getText().trim();
				String phone = tPhone.getText().trim();
				String birthDate = tBirthdate.getText().trim();
				int iBirthDate = 0;

				// 빈칸 입력 체크
				if (id.isEmpty() || pwd.isEmpty() || name.isEmpty() || phone.isEmpty() || birthDate.isEmpty()) {
					JOptionPane.showMessageDialog(p, "고객님의 정보를 입력해주십시오.", "회원정보", JOptionPane.WARNING_MESSAGE);
					return;
				}
				// NullPointerException 확인해보기

				// 생년월일 숫자 변환
				try {
					iBirthDate = Integer.parseInt(birthDate);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(p, "생년월일은 숫자만 입력 가능합니다.", "회원정보", JOptionPane.WARNING_MESSAGE);
					return;
				}
				// 정보 수정
				customers.add(new Customer(name, id, pwd, phone, iBirthDate));

				JOptionPane.showMessageDialog(p, "변경되었습니다. 다시 로그인하시기 바랍니다");
				f.setVisible(false);
				new Gui01_Login();

			}
		}
	}
}