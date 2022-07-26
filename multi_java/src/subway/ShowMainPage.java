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
	JFrame f = new JFrame();
	JButton btMenu,btMypage;
	private static ArrayList<String>  orderList = new ArrayList<String>(4);/**주문한 내역을 저장하기 위한 ArrayList*/
	private static ArrayList<Integer> total_price = new ArrayList<Integer>(4);/**주문한 메뉴의 가격을 모두 합산한 가격*/
	public static ArrayList<Integer> getTotal_price() {
		return total_price;
	}
	public static void setTotal_price(int total_price) {
		ShowMainPage.total_price.add(total_price);/**메뉴의 가격을 합산한다.*/
	}
	public static ArrayList<String> getOrderList() {
		return orderList;
	}
	public static void setOrderList(String orderList) {
		ShowMainPage.orderList.add(orderList);	/**add 메소드를 통해 ArrayList에 값을 저장*/
	}

	
	public ShowMainPage()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**프레임을 닫았을 때 메모리에서 제거되도록 설정*/
		f.getContentPane().setLayout(null);	
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
		btMenu.setBounds(0, 50, 125, 100);
		btMypage.setBounds(125, 50, 125, 100);

		f.getContentPane().add(btMenu);		
		f.getContentPane().add(btMypage);	
		f.getContentPane().setBackground(Color.white);
		
		/*
		 * f.getContentPane().add(btMenu); f.getContentPane().add(btMypage);
		 * f.getContentPane().setBackground(Color.WHITE); f.setVisible(true);
		 */
		//p.add(pContent,"Center");
		//p.add(pNavi,"South");
		//p.add(pTitle,"North");
		//pContent.add(btMenu);
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btMenu.addActionListener(handler);
		btMypage.addActionListener(handler);
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