package subway;

import javax.swing.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 토스트 메뉴 선택 화면
 * 
 * 1) 사용자는 메뉴 선택 버튼을 통해 화면이 들어올 수 있다.
 * 2) 메뉴는 총 3가지로 구성되어 있다.
 * 3) 이전 페이지로 돌아가는 버튼, 메뉴를 선택할 수 있는 버튼, 하단에는 네비게이션 바(my페이지, 주문하기, 즐겨찾기, 로그아웃)으로 구성되어 있다.
 * 	<1> 메뉴를 클릭하면 선택한 메뉴의 빵을 선택할 수 있는 페이지로 연결된다.
 * 	<2> 메뉴 주문은 총 4개까지 할 수 있으며, 4개를 초과하면 메뉴 선택을 할 수 없다.
 * 
 *  
 * @author 박상환
 * 작성일: 22-07-27
 */

/**
 * 추상 클래스인 Sandwich 클래스를 상속받는 클래스
 * 
 * @author 박상환
 *
 */
public class Menu extends Sandwich {
	private static String menu;
	private static int price;

	public static int getPrice() {
		return price;
	}

	public static void setPrice(int price) {
		Menu.price = price;
	}

	@Override
	public String choice(String menu) /** 부모 클래스(Sandwich)의 메소드 오버라이드 */
	{
		Menu.menu = menu;
		return menu;
	}

	public void Show() {

	}

	public static String getMenu() {
		return menu;
	}

	public static void setMenu(String menu) {
		Menu.menu = menu;
	}

}

/**
 * 메뉴 화면을 출력하기 위한 클래스
 * 
 * @author 박상환
 *
 */
class ShowMenu extends JFrame// 메뉴 선택 GUI 출력
{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton btEgg, btBacon, btCheese, btBefore, btNext, btmypage, btShopping, btbookmark, btlogout;
	JLabel Lblogo, Lbline, Lbname, lbMenu;
	ImageIcon img, img2, img3;

	/**
	 * 생성자 화면에 들어갈 버튼, 라벨 등에 대해 설정하고 화면에 추가해준다.
	 */
	public ShowMenu() {
		f.setSize(500, 700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/** 프레임을 닫았을 때 메모리에서 제거되도록 설정 */
		f.getContentPane().setLayout(null); /** 프레임을 화면 가운데에 배치 */

		/**
		 * <레이아웃 구성> 1.까페로고(lb) 2.메뉴이름(lb) 3.메뉴사진(bt) 4.메뉴선택(lb) 5.이동(bt)
		 */

		//////////// 1. 까페로고(lb)
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); // 메뉴선택 라벨 생성
		Lblogo.setBounds(5, 5, 100, 100); // 메뉴선택 사이즈 설정
		f.getContentPane().add(Lblogo); // 메뉴선택 라벨 붙임

		//////////// 2. 메뉴이름(lb)
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문하기.jpg")); // 메뉴선택 라벨 생성
		Lbname.setBounds(170, 10, 150, 100); // 메뉴선택 사이즈 설정
		f.getContentPane().add(Lbname); // 메뉴선택 라벨 붙임

		//////////// 3. 선(lb)
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); // 메뉴선택 라벨 생성
		Lbline.setBounds(0, 100, 500, 50); // 메뉴선택 사이즈 설정
		f.getContentPane().add(Lbline); // 메뉴선택 라벨 붙임

		//////////// 4. 메뉴사진(bt)
		btEgg = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\에그토스트.jpg")); // 메뉴사진(bt)
																											// 생성
		btBacon = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\베이컨토스트.jpg"));
		btCheese = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\치즈토스트.jpg"));

		btEgg.setBounds(10, 250, 130, 130); // 메뉴사진(bt) 사이즈 설정 (setBounds -> 좌우,상하,너비,높이 순서)
		btBacon.setBounds(162, 250, 130, 130);
		btCheese.setBounds(312, 250, 130, 130);

		btEgg.setBackground(Color.white); // 메뉴사진(bt) 테두리 없애기
		btEgg.setBorderPainted(false);
		btBacon.setBackground(Color.white);
		btBacon.setBorderPainted(false);
		btCheese.setBackground(Color.white);
		btCheese.setBorderPainted(false);

		f.getContentPane().add(btEgg); // 메뉴사진 버튼 붙이기 f.getContentPane().add(btBacon);
		f.getContentPane().add(btCheese);
		f.getContentPane().add(btBacon);

		//////////// 5. 메뉴선택(lb)
		lbMenu = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\메뉴를 골라주세요.jpg")); // 메뉴선택 라벨
																											// 생성
		lbMenu.setBounds(100, 150, 250, 100); // 메뉴선택 사이즈 설정
		f.getContentPane().add(lbMenu); // 메뉴선택 라벨 붙임

		//////////// 6. 이동(bt)
		btmypage = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		btShopping = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
		btbookmark = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문내역.jpg"));
		btlogout = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg"));
		btBefore = new JButton("", (new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\돌아가기.png")));

		btBefore.setBounds(380, 10, 100, 100);
		btmypage.setBounds(0, 570, 125, 100); // x, y, 가로, 세로
		btShopping.setBounds(125, 570, 125, 100);
		btbookmark.setBounds(250, 570, 125, 100); // x, y, 가로, 세로
		btlogout.setBounds(375, 570, 125, 100); // x, y, 가로, 세로

		f.getContentPane().add(btBefore);
		f.getContentPane().setBackground(Color.white);
		f.getContentPane().add(btmypage);
		f.getContentPane().add(btShopping);
		f.getContentPane().add(btbookmark);
		f.getContentPane().add(btlogout);

		btBefore.setBackground(Color.white); // 이동버튼(bt) 테두리 없애기
		btBefore.setBorderPainted(false);
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
		 * <이벤트 구성> 1. 메뉴사진(bt) 2. 이동(bt)
		 */

		MyEventHandler handler = new MyEventHandler();

		//////////// 1. 메뉴사진(bt)
		btEgg.addActionListener(handler);
		btBacon.addActionListener(handler);
		btCheese.addActionListener(handler);
		btmypage.addActionListener(handler);
		btShopping.addActionListener(handler);
		btbookmark.addActionListener(handler);
		btlogout.addActionListener(handler);

		//////////// 2. 이동(bt)
	}// 생성자 끝

	/**
	 * 버튼 클릭과 같은 이벤트가 발생되었을 때 이벤트를 처리하는 클래스
	 * 
	 * @author 박상환
	 *
	 */
	class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			////////////// 1-1. 메뉴 사진 버튼
			if (obj == btEgg)// Egg 버튼을 클릭했을 때
			{

				if (Sandwich.getOrderList().size() < 4) { // 선택한 메뉴가 4개 이하면 주문이 가능하도록, 4개 이상이면 불가능하도록 에러창띄어주기
					Menu.setMenu("Egg");// 메뉴 저장
					Menu.setPrice(2000);// 메뉴 가격 저장
					new ShowBread(); // 빵 메뉴 출력
					f.setVisible(false);// 현재 창은 보이지 않도록 설정
				} else {
					JOptionPane.showMessageDialog(null, "주문은 4개까지만 가능합니다 !", "ERROR_MESSAGE",
							JOptionPane.ERROR_MESSAGE); // 에러창 띄어주기
				}
			} else if (obj == btBacon) {
				if (Sandwich.getOrderList().size() < 4) { // 선택한 메뉴가 4개 이하면 주문이 가능하도록, 4개 이상이면 불가능하도록 에러창띄어주기
					Menu.setMenu("Bacon");
					Menu.setPrice(3000);
					f.setVisible(false);
					new ShowBread();
				} else {
					JOptionPane.showMessageDialog(null, "주문은 4개까지만 가능합니다 !", "ERROR_MESSAGE",
							JOptionPane.ERROR_MESSAGE); // 에러창띄어주기
				}
			} else if (obj == btCheese) {
				if (Sandwich.getOrderList().size() < 4) { // 선택한 메뉴가 4개 이하면 주문이 가능하도록, 4개 이상이면 불가능하도록 에러창띄어주기
					Menu.setMenu("Cheese");
					Menu.setPrice(2500);
					f.setVisible(false);
					new ShowBread();
				} else {
					JOptionPane.showMessageDialog(null, "주문은 4개까지만 가능합니다 !", "ERROR_MESSAGE",
							JOptionPane.ERROR_MESSAGE); // 에러창띄어주기
				}
			} else if (obj == btlogout) {// 로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();
			} else if (obj == btShopping) { // 메뉴선택으로 이동
				f.setVisible(false);
				new Menu();
			} else if (obj == btbookmark) {// 나만의 메뉴로 이동
				f.setVisible(false);
				new BookMark();
			} else if (obj == btmypage) {// 마이페이지로 이동
				f.setVisible(false);
				new MP01_Main();
			}

		}// actionPerformed 끝
	}// 핸들러 끝
}// 클래스 끝
