package subway;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

//1. 변수명통일 버튼(bt), 라벨(lb), 텍스트(ta)

public class ShowMainPage extends JFrame
{
	Dimension dim = new Dimension(400,150);
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JPanel pNavi = new JPanel();
	JPanel pTitle = new JPanel();
	JPanel pContent = new JPanel();
	JButton btMenu,btMypage;
	private static ArrayList<String>  orderList = new ArrayList<String>(4);/**주문한 내역을 저장하기 위한 ArrayList*/
	private static int total_price=0;/**주문한 메뉴의 가격을 모두 합산한 가격*/
	public static int getTotal_price() {
		return total_price;
	}
	public static void setTotal_price(int total_price) {
		ShowMainPage.total_price += total_price;/**메뉴의 가격을 합산한다.*/
	}
	public static ArrayList<String> getOrderList() {
		return orderList;
	}
	public static void setOrderList(String orderList) {
		ShowMainPage.orderList.add(orderList);	/**add 메소드를 통해 ArrayList에 값을 저장*/
	}

	
	public ShowMainPage()
	{
		/*
		 * f.setSize(500,700); f.setLocale(null);
		 * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * f.getContentPane().setLayout(null);
		 */
		btMenu = new JButton("메뉴 선택"); //버튼만들기
		btMypage = new JButton("마이페이지");
		/*
		 * btMenu.setBounds(330, 30, 100, 50); btMypage.setBounds(100, 500, 100, 50);
		 */
		
		pNavi.setLayout(new BoxLayout(pNavi,BoxLayout.X_AXIS));
		pTitle.setLayout(new BoxLayout(pTitle,BoxLayout.X_AXIS));
		pContent.setLayout(new BoxLayout(pContent,BoxLayout.X_AXIS));
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		
		pNavi.add(btMenu);
		pTitle.add(btMypage);
		pContent.add(btMenu);
		f.add(p,BorderLayout.CENTER);
		f.pack();
		
		/*
		 * f.getContentPane().add(btMenu); f.getContentPane().add(btMypage);
		 * f.getContentPane().setBackground(Color.WHITE); f.setVisible(true);
		 */
		//p.add(pContent,"Center");
		//p.add(pNavi,"South");
		//p.add(pTitle,"North");
		//pContent.add(btMenu);
		MyEventHandler handler = new MyEventHandler();
		btMenu.addActionListener(handler);
		btMypage.addActionListener(handler);
		f.setLocation(200,400);
		f.setPreferredSize(dim);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	class MyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btMenu)
			{
				new ShowMenu();	
				f.setVisible(false);
			}
			else if(obj==btMypage)
			{
				new BookMark();
				f.setVisible(false);
			}
		}
	}
}