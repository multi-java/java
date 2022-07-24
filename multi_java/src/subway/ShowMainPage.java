package subway;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ShowMainPage extends JFrame
{
	JFrame f = new JFrame();
	JButton btMenu;
	private static ArrayList<String>  orderList = new ArrayList<String>();/**주문한 내역을 저장하기 위한 ArrayList*/
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