package subway;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ShowMainPage extends JFrame
{
	JFrame f = new JFrame();
	JButton btMenu;
	private static ArrayList<String> orderList = new ArrayList<String>();
	private static int total_price=0;
	public static int getTotal_price() {
		return total_price;
	}
	public static void setTotal_price(int total_price) {
		ShowMainPage.total_price += total_price;
	}
	public static ArrayList<String> getOrderList() {
		return orderList;
	}
	public static void setOrderList(String orderList) {
		ShowMainPage.orderList.add(orderList);
	}
	public ShowMainPage()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		btMenu = new JButton("메뉴 선택");

		btMenu.setBounds(330, 30, 100, 50);
		
		f.getContentPane().add(btMenu);
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btMenu.addActionListener(handler);
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
		}
	}
}