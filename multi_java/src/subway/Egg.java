package subway;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 토핑 선택 화면
 * 
 * 1) 빵 선택 화면에서 넘어오면 토핑 선택 화면이 나온다.
 * 2) 토핑은 총 3가지로 구성되어 있다.
 * 3) 이전 페이지로 돌아가는 버튼, 메뉴를 선택할 수 있는 버튼, 하단에는 네비게이션 바(my페이지, 주문하기, 즐겨찾기, 로그아웃)으로 구성되어 있다.
 * 	<1> 메뉴를 클릭하면 선택한 메뉴의 쨈을 선택할 수 있는 페이지로 연결된다.
 * 	<2> 이전 버튼을 클릭하면 빵 선택 화면으로 돌아간다.
 * 
 *  
 * @author 박상환
 * 작성일: 22-07-27
 */

/**
 * 추상 클래스인 Sandwich를 상속받는 클래스
 * 
 * @author 박상환
 *
 */
public class Egg extends Sandwich {
	private static String menu;
	private static int topping_price;

	public static int getTopping_price() {
		return topping_price;
	}

	public static void setTopping_price(int topping_price) {
		Egg.topping_price = topping_price;
	}

	public static String getMenu() {
		return menu;
	}

	public static void setMenu(String menu) {
		Egg.menu = menu;
	}

	@Override
	public String choice(String menu) {
		Egg.menu = menu;
		return menu;
	}

	public Egg() {

	}

}

/**
 * 
 * 토핑 메뉴 GUI 출력하기 위한 클래스
 * 
 * @author 박상환
 *
 */
class ShowEgg extends JFrame {
	JFrame f = new JFrame();
	JButton btCheese, btEgg, btHam, btBefore, btNext, btmypage, btShopping, btbookmark, btlogout;
	JLabel Lblogo, Lbname, Lbline, lbMenu;

	/**
	 * 생성자 버튼이나 라벨과 같은 요소들을 정의하고 프레임에 추가시켜준다.
	 */
	public ShowEgg() {
		f.setSize(500, 700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); // 메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문하기.jpg"));
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png"));
		btCheese = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\치즈.jpg"));
		btEgg = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\계란.jpg"));
		btHam = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\햄.jpg"));
		btBefore = new JButton("", (new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\돌아가기.png")));
		lbMenu = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\토핑을 골라주세요.jpg"));
		btmypage = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		btShopping = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
		btbookmark = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문내역.jpg"));
		btlogout = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg"));

		Lblogo.setBounds(5, 5, 100, 100); // 좌우,상하,너비,높이
		Lbname.setBounds(170, 10, 150, 100);
		Lbline.setBounds(0, 100, 500, 50);
		lbMenu.setBounds(100, 150, 250, 100);
		btCheese.setBounds(312, 250, 130, 130);
		btEgg.setBounds(10, 250, 130, 130);
		btHam.setBounds(162, 250, 130, 130);
		btBefore.setBounds(380, 10, 100, 100);
		btmypage.setBounds(0, 570, 125, 100); // x, y, 가로, 세로
		btShopping.setBounds(125, 570, 125, 100);
		btbookmark.setBounds(250, 570, 125, 100);
		btlogout.setBounds(375, 570, 125, 100);

		btCheese.setBackground(Color.white);
		btCheese.setBorderPainted(false); // 버튼 테두리 없애기
		btEgg.setBackground(Color.white);
		btEgg.setBorderPainted(false);
		btHam.setBackground(Color.white);
		btHam.setBorderPainted(false);
		btBefore.setBackground(Color.white);
		btBefore.setBorderPainted(false);
		btmypage.setBackground(Color.white);
		btmypage.setBorderPainted(false);
		btShopping.setBackground(Color.white);
		btShopping.setBorderPainted(false);
		btbookmark.setBackground(Color.white);
		btbookmark.setBorderPainted(false);
		btlogout.setBackground(Color.white);
		btlogout.setBorderPainted(false);

		f.getContentPane().add(Lbline);
		f.getContentPane().add(Lbname);
		f.getContentPane().add(Lblogo);
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btCheese);
		f.getContentPane().add(btEgg);
		f.getContentPane().add(btHam);
		f.getContentPane().add(btBefore);
		f.getContentPane().setBackground(Color.WHITE);
		f.getContentPane().setBackground(Color.white);
		f.getContentPane().add(btmypage);
		f.getContentPane().add(btShopping);
		f.getContentPane().add(btbookmark);
		f.getContentPane().add(btlogout);
		f.setVisible(true);

		MyEventHandler handler = new MyEventHandler();
		btCheese.addActionListener(handler);
		btEgg.addActionListener(handler);
		btHam.addActionListener(handler);
		btBefore.addActionListener(handler);
		btmypage.addActionListener(handler);
		btShopping.addActionListener(handler);
		btbookmark.addActionListener(handler);
		btlogout.addActionListener(handler);
	}// 생성자 끝

	/**
	 * 이벤트 핸들러 클래스 버튼 클릭 등과 같은 이벤트가 발생하면 이벤트를 처리하는 클래스이다.
	 * 
	 * @author 박상환
	 *
	 */
	class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btCheese) {
				Egg.setMenu("Cheese");
				Egg.setTopping_price(1000); // Cheese 토핑의 가격
				new ShowJam(); // 쨈 화면 출력
				f.setVisible(false);
			} else if (obj == btEgg) {
				Egg.setMenu("Egg");
				Egg.setTopping_price(500);
				new ShowJam();
				f.setVisible(false);
			} else if (obj == btHam) {
				Egg.setMenu("Ham");
				Egg.setTopping_price(1500);
				new ShowJam();
				f.setVisible(false);
			} else if (obj == btBefore) {
				f.setVisible(false);
				new ShowBread();
			} else if (obj == btlogout) {// 로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();
			} else if (obj == btShopping) { // 메뉴선택으로 이동
				f.setVisible(false);
				new ShowMenu();
			} else if (obj == btbookmark) {// 나만의 메뉴로 이동
				f.setVisible(false);
				new BookMark();
			} else if (obj == btmypage) {// 마이페이지로 이동
				f.setVisible(false);
				new MP01_Main();
			}
		}// actionperformed 끝
	}// 핸들러 끝
}// 클래스 끝