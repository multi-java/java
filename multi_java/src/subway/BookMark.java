package subway;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class BookMark extends JFrame {// JFrame 상속
	JFrame f = new JFrame();
	JPanel p = new JPanel();

	JButton Drop0, Drop1, Drop2, Drop3;
	JButton btmypage, btShopping, btbookmark, btlogout; // 삭제버튼 선언
	JLabel Lblogo, Lbname, Lbline, total;
	JScrollPane scrollPane;

	JTextArea bookmark0, bookmark1, bookmark2, bookmark3;

	public void check() { // 북마크를 삭제할 때 해당 인덱스값이 비었다면 공백값으로 표시하는 메소드

		if (ShowMainPage.getOrderList().size() == 4) {
			bookmark0.setText(ShowMainPage.getOrderList().get(0));
			bookmark1.setText(ShowMainPage.getOrderList().get(1));
			bookmark2.setText(ShowMainPage.getOrderList().get(2));
			bookmark3.setText(ShowMainPage.getOrderList().get(3));
			total.setText("");
			total.setText(ShowMainPage.getOrderList().size() + "개 메뉴의 총 가격은 " + ShowMainPage.total + "원 입니다.");
		} else if (ShowMainPage.getOrderList().size() == 3) {
			bookmark0.setText(ShowMainPage.getOrderList().get(0));
			bookmark1.setText(ShowMainPage.getOrderList().get(1));
			bookmark2.setText(ShowMainPage.getOrderList().get(2));
			bookmark3.setText("");
			total.setText(ShowMainPage.getOrderList().size() + "개 메뉴의 총 가격은 " + ShowMainPage.total + "원 입니다.");

		} else if (ShowMainPage.getOrderList().size() == 2) {
			bookmark0.setText(ShowMainPage.getOrderList().get(0));
			bookmark1.setText(ShowMainPage.getOrderList().get(1));
			bookmark2.setText("");
			bookmark3.setText("");
			total.setText(ShowMainPage.getOrderList().size() + "개 메뉴의 총 가격은 " + ShowMainPage.total + "원 입니다.");
		} else if (ShowMainPage.getOrderList().size() == 1) {
			bookmark0.setText(ShowMainPage.getOrderList().get(0));
			bookmark1.setText("");
			bookmark2.setText("");
			bookmark3.setText("");
			total.setText(ShowMainPage.getOrderList().size() + "개 메뉴의 총 가격은 " + ShowMainPage.total + "원 입니다.");
		} else if (ShowMainPage.getOrderList().size() < 1) {
			bookmark0.setText("");
			bookmark1.setText("");
			bookmark2.setText("");
			bookmark3.setText("");
			total.setText("");
		}
	}

	/**
	 * <레이아웃 초기설정> 1. 상환씨꺼 복사
	 */

	public BookMark() {
		f.setSize(500, 700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		f.getContentPane().setLayout(null);

		/**
		 * <레이아웃 구성> 1. 페이지이름 => 라벨 3. 즐겨찾기순번 => 라벨 4. 즐겨찾기내용 => 버튼 5. 즐겨찾기삭제 => 버튼
		 **/

		//////////// 1. 페이지이름 (라벨)

		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); // 메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문내역.jpg")); // 메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); // 메뉴선택 라벨 생성

		Lblogo.setBounds(5, 5, 100, 100); // x, y, 가로, 세로
		Lbname.setBounds(170, 10, 150, 100); // x, y, 가로, 세로
		Lbline.setBounds(0, 100, 500, 50); // x, y, 가로, 세로

		f.getContentPane().add(Lbline);
		f.getContentPane().add(Lbname);
		f.getContentPane().add(Lblogo);
		f.getContentPane().setBackground(Color.white);

		//////////// 3. 총가격(라벨)
		total = new JLabel();

		//////////// 4. 즐겨찾기내용(버튼)
		bookmark0 = new JTextArea(); // 주문내역0 생성
		bookmark1 = new JTextArea(); // 주문내역1 생성
		bookmark2 = new JTextArea(); // 주문내역2 생성
		bookmark3 = new JTextArea(); // 주문내역3 생성

		check();

		bookmark0.setBounds(50, 170, 193, 128); // x, y, 가로, 세로 (주문내역0)
		bookmark1.setBounds(250, 170, 193, 128); // x, y, 가로, 세로 (주문내역1)
		bookmark2.setBounds(50, 343, 193, 128); // x, y, 가로, 세로 (주문내역2)
		bookmark3.setBounds(250, 343, 193, 128); // x, y, 가로, 세로 (주문내역3)
		total.setBounds(150, 510, 300, 80); // x, y, 가로, 세로 (총가격)

		f.getContentPane().add(bookmark0); // 패널에 붙이기 (주문내역0)
		f.getContentPane().add(bookmark1); // 패널에 붙이기 (주문내역1)
		f.getContentPane().add(bookmark2); // 패널에 붙이기 (주문내역2)
		f.getContentPane().add(bookmark3); // 패널에 붙이기 (주문내역3)

		bookmark0.setEditable(false); // 테두리 없애기 (주문내역0)
		bookmark1.setEditable(false); // 테두리 없애기 (주문내역1)
		bookmark2.setEditable(false); // 테두리 없애기 (주문내역2)
		bookmark3.setEditable(false); // 테두리 없애기 (주문내역3)

		//////////// 5. 즐겨찾기삭제 (버튼)
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
		f.getContentPane().add(total); // 패널에 붙이기

		//////////// 5. 이동버튼 (버튼)

		btmypage = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		btShopping = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
		btbookmark = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\즐겨찾기.jpg"));
		btlogout = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg"));

		btmypage.setBounds(0, 570, 125, 100); // x, y, 가로, 세로
		btShopping.setBounds(125, 570, 125, 100);
		btbookmark.setBounds(250, 570, 125, 100); // x, y, 가로, 세로
		btlogout.setBounds(375, 570, 125, 100); // x, y, 가로, 세로

		f.getContentPane().add(btmypage);
		f.getContentPane().add(btShopping);
		f.getContentPane().add(btbookmark);
		f.getContentPane().add(btlogout);

		btmypage.setBackground(Color.white);
		btmypage.setBorderPainted(false);
		btShopping.setBackground(Color.white);
		btShopping.setBorderPainted(false);
		btbookmark.setBackground(Color.white);
		btbookmark.setBorderPainted(false);
		btlogout.setBackground(Color.white);
		btlogout.setBorderPainted(false);

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
					ShowMainPage.total -= ShowMainPage.getTotal_price().get(0);
					ShowMainPage.getOrderList().remove(0);
					check();
				}

				if (click == Drop1)// 삭제버튼을 눌렀을 때
				{
					ShowMainPage.total -= ShowMainPage.getTotal_price().get(1);
					ShowMainPage.getOrderList().remove(1);
					check();
				}
				if (click == Drop2)// 삭제버튼을 눌렀을 때
				{
					ShowMainPage.total -= ShowMainPage.getTotal_price().get(2);
					ShowMainPage.getOrderList().remove(2);
					check();
				}
				if (click == Drop3)// 삭제버튼을 눌렀을 때
				{
					ShowMainPage.total -= ShowMainPage.getTotal_price().get(3);
					ShowMainPage.getOrderList().remove(3);
					check();
				}

				/*
				 * 2. 메인이동하기버튼 (이벤트처리) if(click==btMain) //메인 버튼 클릭 했을 때 { new
				 * ShowMainPage();//메인 창 출력 f.setVisible(false); }
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
				new ShowMainPage();
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
