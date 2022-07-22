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
	public String choice(String menu)
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
class ShowMenu extends JFrame
{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton btEgg,btBacon,btCheese,btMain,btBefore,btNext;
	JLabel lbMenu;
	
	public ShowMenu()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		btEgg = new JButton("에그 토스트");
		btBacon = new JButton("베이컨 토스트");
		btCheese = new JButton("치즈 토스트");
		btMain = new JButton("메인");
		btBefore = new JButton("이전");
		btNext = new JButton("다음");
		lbMenu = new JLabel("<메뉴 선택>");
		lbMenu.setBounds(162, 70, 100, 100);
		btEgg.setBounds(10, 170, 122, 100);	//좌우,상하,너비,높이
		btBacon.setBounds(162, 170, 122, 100);
		btCheese.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 300, 100, 50);
		btNext.setBounds(330, 300, 100, 50);
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btEgg);
		f.getContentPane().add(btBacon);
		f.getContentPane().add(btCheese);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.getContentPane().add(btNext);
		f.setVisible(true);
		MyEventHandler handler = new MyEventHandler();
		btEgg.addActionListener(handler);
	}
	class MyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btEgg)
			{
				Menu.setMenu("Egg");
				Menu.setPrice(2000);
				new ShowBread();	//빵 선택하면 에그 선택
				f.setVisible(false);
			}
		}
	}
}
