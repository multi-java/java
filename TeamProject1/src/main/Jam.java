package main;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class Jam extends Sandwich
{
	private static String menu;
	@Override
	public String choice(String menu)
	{
		Jam.menu=menu;
		return menu;
	}
	public void Show()
	{
		
	}
	public static String getMenu() {
		return menu;
	}
	public static void setMenu(String menu) {
		Jam.menu = menu;
	}
	
}
class ShowJam extends JFrame
{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton btBlue,btStraw,btApple,btMain,btBefore,btNext;
	JLabel lbMenu;
	
	public ShowJam()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		btBlue = new JButton("Blueberry");
		btStraw = new JButton("Strawberry");
		btApple = new JButton("Apple");
		btMain = new JButton("메인");
		btBefore = new JButton("이전");
		lbMenu = new JLabel("<쨈 선택>");
		
		
		lbMenu.setBounds(162, 70, 100, 100);
		btBlue.setBounds(10, 170, 122, 100);		/**setBounds -> 좌우,상하,너비,높이 순서*/
		btStraw.setBounds(162, 170, 122, 100);
		btApple.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 30, 100, 50);
		
		
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btBlue);
		f.getContentPane().add(btStraw);
		f.getContentPane().add(btApple);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btBlue.addActionListener(handler);
		btStraw.addActionListener(handler);
		btApple.addActionListener(handler);
		btBefore.addActionListener(handler);
	}
	
	
	class MyEventHandler implements ActionListener
	{
		String order ="";	/**주문 내역 저장하기 위한 문자열*/
		int menu_price = 0;	/**메뉴의 가격과 토핑의 가격을 더한 값*/
		
		
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btBlue)
			{
				Jam.setMenu("Blueberry");
				showMenu();
				new Order();	
				f.setVisible(false);
			}
			else if(obj==btStraw)
			{
				Jam.setMenu("Strawberry");
				showMenu();
				new Order();	
				f.setVisible(false);
			}
			else if(obj==btApple)
			{
				Jam.setMenu("Apple");
				showMenu();
				new Order();	
				f.setVisible(false);
			}
			else if(obj==btBefore)
			{
				f.setVisible(false);
				new ShowEgg();	
			}
			else if(obj==btMain)
			{
				new ShowMainPage();	
				f.setVisible(false);
			}
			
		}
		
		
		public void showMenu()
		{
			menu_price = Menu.getPrice()+Egg.getTopping_price();	/**메뉴의 가격 저장*/
			ShowMainPage.setTotal_price(menu_price);
			order = 		/**주문한 메뉴의 정보를 저장*/
			(Integer.toString(ShowMainPage.getOrderList().size() + 1))+". 선택한 메뉴 : "+Menu.getMenu()+
			"\n메뉴 가격 : "+Menu.getPrice()+
			"\n빵 : "+Bread.getMenu()+
			"\n토핑 : "+Egg.getMenu()+
			"\n토핑 가격 : "+Egg.getTopping_price()+
			"\n쨈 가격 : "+Jam.getMenu()+
			"\n총 가격 : "+Integer.toString(menu_price)+
			"\n\n===================="+
			"\n\n";
			ShowMainPage.setOrderList(order);
			System.out.println(ShowMainPage.getOrderList().size());
			System.out.println(ShowMainPage.getOrderList().get(0));
			/*
			 * System.out.println(ShowMainPage.getOrderList().get(1));
			 * System.out.println(ShowMainPage.getOrderList().get(2));
			 * System.out.println(ShowMainPage.getOrderList().get(3));
			 */
			System.out.println("size : "+ShowMainPage.getOrderList().size());
		}
	}
}