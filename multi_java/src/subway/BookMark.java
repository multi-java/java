package subway;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

/**
 * 
 * @author 손하은
 * 작성일 : 2022-07-28
 */
public class BookMark extends JFrame {// JFrame 상속

	JFrame f = new JFrame(); // 프레임
	JPanel p = new JPanel(); // 패널

	JLabel Lblogo, Lbname, Lbline; // (공통GUI)상단
	JButton btmypage, btShopping, btbookmark, btlogout; // (공통GUI)네비게이션바
	JTextArea bookmark0, bookmark1, bookmark2, bookmark3; // 주문내용출력
	JButton Drop0, Drop1, Drop2, Drop3; // 삭제버튼
	JLabel total; // 총가격

	public void check() { // 주문내용출력bt에 주문내역을 출력해주는 메소드
		if (Sandwich.getOrderList().size() == 4) { // 리스트 길이는 4개를 기준으로, 부족한 인덱스에 공백을 임의로 부여하여 채워줌
			bookmark0.setText(Sandwich.getOrderList().get(0));
			bookmark1.setText(Sandwich.getOrderList().get(1));
			bookmark2.setText(Sandwich.getOrderList().get(2));
			bookmark3.setText(Sandwich.getOrderList().get(3));
			total.setText(Sandwich.getOrderList().size() + "개 메뉴의 총 가격은 " + Sandwich.total + "원 입니다.");

		} else if (Sandwich.getOrderList().size() == 3) {
			bookmark0.setText(Sandwich.getOrderList().get(0));
			bookmark1.setText(Sandwich.getOrderList().get(1));
			bookmark2.setText(Sandwich.getOrderList().get(2));
			bookmark3.setText("");
			total.setText(Sandwich.getOrderList().size() + "개 메뉴의 총 가격은 " + Sandwich.total + "원 입니다.");

		} else if (Sandwich.getOrderList().size() == 2) {
			bookmark0.setText(Sandwich.getOrderList().get(0));
			bookmark1.setText(Sandwich.getOrderList().get(1));
			bookmark2.setText("");
			bookmark3.setText("");
			total.setText(Sandwich.getOrderList().size() + "개 메뉴의 총 가격은 " + Sandwich.total + "원 입니다.");
		} else if (Sandwich.getOrderList().size() == 1) {
			bookmark0.setText(Sandwich.getOrderList().get(0));
			bookmark1.setText("");
			bookmark2.setText("");
			bookmark3.setText("");
			total.setText(Sandwich.getOrderList().size() + "개 메뉴의 총 가격은 " + Sandwich.total + "원 입니다.");
		} else if (Sandwich.getOrderList().size() < 1) {
			bookmark0.setText("");
			bookmark1.setText("");
			bookmark2.setText("");
			bookmark3.setText("");
			total.setText("");
		}
	}

	public BookMark() { // 북마크 프레임 생성
		f.setSize(500, 700); // 500*700 사이즈 설정
		f.setLocale(null); // 중앙배치
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		f.getContentPane().setLayout(null);

		/**
		 * <레이아웃 구성>
		 * 
		 * 1.(공통GUI)상단 lb => 까페로고, 페이지이름, 레이아웃선 이미지파일 표시 
		 * 2.(공통GUI)네비게이션바 bt => 마이페이지,
		 * 주문하기, 주문내역, 로그아웃으로 이동할 수 있는 bt 표시 
		 * 3.주문내역내용 lb => 주문받은 내역을 표시 
		 * 4.주문내역삭제 bt =>
		 * 주문내역을 삭제할 수 있는 bt 표시
		 * 5.총가격 => 4개 주문내역의 총 가격 표시
		 * 
		 * 
		 **/

		//////////// 1.(공통GUI) 상단 ////////////
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); // 까페로고 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\lb주문내역.jpg")); // 페이지이름("주문내역")
																										// 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); // 레이아웃선 생성

		Lblogo.setBounds(5, 5, 100, 100); // 까페로고 위치설정 : x, y, 가로, 세로
		Lbname.setBounds(170, 10, 150, 100); // 페이지이름 위치설정: x, y, 가로, 세로
		Lbline.setBounds(0, 100, 500, 50); // 선라인 위치설정: x, y, 가로, 세로

		f.getContentPane().add(Lblogo); // 까페로고 패널 위 붙이기
		f.getContentPane().add(Lbname); // 페이지이름 패널 위 붙이기
		f.getContentPane().add(Lbline); // 레이아웃선 패널 위 붙이기
		f.getContentPane().setBackground(Color.white);

		//////////// 2. (공통GUI) 네비게이션바 ////////////
		btmypage = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg")); // 마이페이지
																												// bt
		btShopping = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg")); // 주문하기bt
		btbookmark = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문내역.jpg")); // 주문내역bt
		btlogout = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg")); // 로그아웃bt

		btmypage.setBounds(0, 570, 125, 100); // x, y, 가로, 세로 (마이페이지bt)
		btShopping.setBounds(125, 570, 125, 100); // x, y, 가로, 세로 (주문하기bt)
		btbookmark.setBounds(250, 570, 125, 100); // x, y, 가로, 세로 (주문내역bt)
		btlogout.setBounds(375, 570, 125, 100); // x, y, 가로, 세로 (로그아웃bt)

		f.getContentPane().add(btmypage); // 패널 위 붙이기 (마이페이지bt)
		f.getContentPane().add(btShopping); // 패널 위 붙이기 (주문하기bt)
		f.getContentPane().add(btbookmark); // 패널 위 붙이기 (주문내역bt)
		f.getContentPane().add(btlogout); // 패널 위 붙이기 (로그아웃bt)

		btmypage.setBackground(Color.white); // 마이페이지bt 뒷배경 없애기
		btmypage.setBorderPainted(false);
		btShopping.setBackground(Color.white); // 주문하기bt 뒷배경 없애기
		btShopping.setBorderPainted(false);
		btbookmark.setBackground(Color.white); // 주문내역bt 뒷배경 없애기
		btbookmark.setBorderPainted(false);
		btlogout.setBackground(Color.white); // 로그아웃bt 뒷배경 없애기
		btlogout.setBorderPainted(false);

		//////////// 3. 주문내역내용 ////////////
		bookmark0 = new JTextArea(); // 주문내역0 생성
		bookmark1 = new JTextArea(); // 주문내역1 생성
		bookmark2 = new JTextArea(); // 주문내역2 생성
		bookmark3 = new JTextArea(); // 주문내역3 생성

		bookmark0.setBounds(50, 170, 193, 128); // x, y, 가로, 세로 (주문내역0)
		bookmark1.setBounds(250, 170, 193, 128); // x, y, 가로, 세로 (주문내역1)
		bookmark2.setBounds(50, 343, 193, 128); // x, y, 가로, 세로 (주문내역2)
		bookmark3.setBounds(250, 343, 193, 128); // x, y, 가로, 세로 (주문내역3)

		f.getContentPane().add(bookmark0); // 패널에 붙이기 (주문내역0)
		f.getContentPane().add(bookmark1); // 패널에 붙이기 (주문내역1)
		f.getContentPane().add(bookmark2); // 패널에 붙이기 (주문내역2)
		f.getContentPane().add(bookmark3); // 패널에 붙이기 (주문내역3)

		bookmark0.setEditable(false); // 테두리 없애기 (주문내역0)
		bookmark1.setEditable(false); // 테두리 없애기 (주문내역1)
		bookmark2.setEditable(false); // 테두리 없애기 (주문내역2)
		bookmark3.setEditable(false); // 테두리 없애기 (주문내역3)

		//////////// 4. 주문내역삭제 ////////////
		Drop0 = new JButton(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\삭제.jpg")); // 삭제0 생성 (주문내역0의
																										// 삭제)
		Drop1 = new JButton(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\삭제.jpg")); // 삭제1 생성 (주문내역1의
																										// 삭제)
		Drop2 = new JButton(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\삭제.jpg")); // 삭제2 생성 (주문내역2의
																										// 삭제)
		Drop3 = new JButton(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\삭제.jpg")); // 삭제3 생성 (주문내역3의
																										// 삭제)

		Drop0.setBounds(50, 298, 193, 20); // x, y, 가로, 세로 (삭제0)
		Drop1.setBounds(250, 298, 193, 20); // x, y, 가로, 세로 (삭제1)
		Drop2.setBounds(50, 471, 193, 20); // x, y, 가로, 세로 (삭제2)
		Drop3.setBounds(250, 471, 193, 20); // x, y, 가로, 세로 (삭제3)

		f.getContentPane().add(Drop0); // 패널에 붙이기 (삭제0)
		f.getContentPane().add(Drop1); // 패널에 붙이기 (삭제1)
		f.getContentPane().add(Drop2); // 패널에 붙이기 (삭제2)
		f.getContentPane().add(Drop3); // 패널에 붙이기 (삭제3)

		//////////// 5. 총가격 ////////////
		total = new JLabel(); // 주문내용출력bt에 주문내역을 출력해주는 메소드
		total.setBounds(150, 510, 300, 80); // x, y, 가로, 세로 (총가격)
		f.getContentPane().add(total); // 패널에 붙이기 (토탈값)
		
		check();

		f.setVisible(true);
		/**
		 * <이벤트구성> 1. 즐겨찾기삭제 (버튼) => 눌렀을 경우, 해당 index의 배열요소가 삭제됨. 삭제된 index 에는 그 다음 순번의
		 * 배열요소가 들어옴. 2. 이동하기 (버튼) => 메인으로 이동한다.
		 **/

		//////////// 1. 즐겨찾기삭제 (이벤트처리)
		MyEventHandler handler = new MyEventHandler(); // 리스너 처리
		Drop0.addActionListener(handler);
		Drop1.addActionListener(handler);
		Drop2.addActionListener(handler);
		Drop3.addActionListener(handler);
		btmypage.addActionListener(handler);
		btShopping.addActionListener(handler);
		btbookmark.addActionListener(handler);
		btlogout.addActionListener(handler);

	}

	class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object click = e.getSource();
			try {// 리스트가 비었을때 에러메시지 송출

				if (click == Drop0)// 삭제버튼을 눌렀을 때
				{
					Sandwich.total -= Sandwich.getTotal_price().get(0);
					Sandwich.getOrderList().remove(0);
					check();
				}

				if (click == Drop1)// 삭제버튼을 눌렀을 때
				{
					Sandwich.total -= Sandwich.getTotal_price().get(1);
					Sandwich.getOrderList().remove(1);
					check();
				}
				if (click == Drop2)// 삭제버튼을 눌렀을 때
				{
					Sandwich.total -= Sandwich.getTotal_price().get(2);
					Sandwich.getOrderList().remove(2);
					check();
				}
				if (click == Drop3)// 삭제버튼을 눌렀을 때
				{
					Sandwich.total -= Sandwich.getTotal_price().get(3);
					Sandwich.getOrderList().remove(3);
					check();
				}

				/*
				 * 2. 메인이동하기버튼 (이벤트처리) if(click==btMain) //메인 버튼 클릭 했을 때 { new
				 * Sandwich();//메인 창 출력 f.setVisible(false); }
				 */

			} catch (IndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "더 이상 삭제할 것이 없습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); // 에러창띄어주기
			}
			if (click == btlogout) {// 로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();
			}
			if (click == btShopping) { // 메뉴선택으로 이동
				f.setVisible(false);
				new ShowMenu();
			}
			if (click == btbookmark) {// 나만의 메뉴로 이동
				f.setVisible(false);
				new BookMark();
			}
			if (click == btmypage) {// 마이페이지로 이동
				f.setVisible(false);
				new MP01_Main();
			}

		}// 액션퍼포먼스

	}// 핸들러

}// 퍼블릭클래스
