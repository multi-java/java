package subway;
import javax.swing.*;
import java.awt.event.*;


public class Menu extends Sandwich
{
	private static String menu;
	private static int price;
	public static int getPrice() {
		return price;
	}
	public static void setPrice(int price) {
		Menu.price = price;
	}
	@Override
	public String choice(String menu)		/**부모 클래스(Sandwich)의 메소드 오버라이드*/
	{
		Menu.menu=menu;
		return menu;
	}
	public void Show()
	{
		
	}
	public static String getMenu() {
		return menu;
	}
	public static void setMenu(String menu) {
		Menu.menu = menu;
	}
	
}
class ShowMenu extends JFrame		/**메뉴 선택 GUI 출력*/
{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton btEgg,btBacon,btCheese,btMain,btBefore,btNext;
	JLabel lbMenu;
	
	public ShowMenu()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**프레임을 닫았을 때 메모리에서 제거되도록 설정*/
		f.getContentPane().setLayout(null);				/**프레임을 화면 가운데에 배치*/
		
		
		btEgg = new JButton("에그 토스트");
		btBacon = new JButton("베이컨 토스트");
		btCheese = new JButton("치즈 토스트");
		btMain = new JButton("메인");
		btBefore = new JButton("이전");
		lbMenu = new JLabel("<메뉴 선택>");
		
		
		lbMenu.setBounds(162, 70, 100, 100);
		btEgg.setBounds(10, 170, 122, 100);		/**setBounds -> 좌우,상하,너비,높이 순서*/
		btBacon.setBounds(162, 170, 122, 100);
		btCheese.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 30, 100, 50);
		
		
		f.getContentPane().add(lbMenu);		/**프레임에서 컨텐츠 영역을 가져와서 라벨을 붙임*/
		f.getContentPane().add(btEgg);
		f.getContentPane().add(btBacon);
		f.getContentPane().add(btCheese);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btEgg.addActionListener(handler);
		btBacon.addActionListener(handler);
		btCheese.addActionListener(handler);
		btMain.addActionListener(handler);
	}
	class MyEventHandler implements ActionListener	/**버튼을 클릭하면 발생하는 클래스*/
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btEgg)/**Egg 버튼을 클릭했을 때*/
			{
				Menu.setMenu("Egg");/**메뉴 저장*/
				Menu.setPrice(2000);	/**메뉴 가격 저장*/
				new ShowBread();	/**빵 메뉴 출력*/
				f.setVisible(false);/**현재 창은 보이지 않도록 설정*/
			}
			else if(obj==btBacon)
			{
				Menu.setMenu("Bacon");
				Menu.setPrice(3000);
				f.setVisible(false);
				new ShowBread();	
			}
			else if(obj==btCheese)
			{
				Menu.setMenu("Cheese");
				Menu.setPrice(2500);
				f.setVisible(false);
				new ShowBread();	
			}
			else if(obj==btMain)	/**메인 버튼 클릭 했을 때*/
			{
				new ShowMainPage();		/**메인 창 출력*/
				f.setVisible(false);
			}
		}
	}
}
