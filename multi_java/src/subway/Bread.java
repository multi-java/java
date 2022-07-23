package subway;
import javax.swing.*;

import java.awt.Frame;
import java.awt.event.*;


public class Bread extends Sandwich
{
	private static String menu;
	@Override
	public String choice(String menu)
	{
		Bread.menu=menu;
		return menu;
	}
	public void Show()
	{
		
	}
	public static String getMenu() {
		return menu;
	}
	public static void setMenu(String menu) {
		Bread.menu = menu;
	}
	
}
class ShowBread extends JFrame		/**빵 메뉴 선택 GUI 출력*/
{
	JFrame f = new JFrame();
	JButton btHoney,btMilk,btChestnut,btMain,btBefore,btNext;
	JLabel lbBread;
	
	
	public ShowBread()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		btHoney = new JButton("Honey");
		btMilk = new JButton("Milk");
		btChestnut = new JButton("Chestnut");
		btMain = new JButton("메인");
		btBefore = new JButton("이전");
		lbBread = new JLabel("<빵 선택>");
		
		
		btHoney.setBounds(10, 170, 122, 100);		/**setBounds -> 좌우,상하,너비,높이 순서*/
		lbBread.setBounds(162, 70, 100, 100);
		btMilk.setBounds(162, 170, 122, 100);
		btChestnut.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 30, 100, 50);
		
		
		f.getContentPane().add(lbBread);
		f.getContentPane().add(btHoney);
		f.getContentPane().add(btMilk);
		f.getContentPane().add(btChestnut);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btHoney.addActionListener(handler);
		btMilk.addActionListener(handler);
		btChestnut.addActionListener(handler);
		btBefore.addActionListener(handler);
		btMain.addActionListener(handler);
	}
	class MyEventHandler implements ActionListener 	/**버튼을 클릭하면 발생하는 클래스*/
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btHoney)
			{
				Bread.setMenu("Honey");
				f.setVisible(false);
				new ShowEgg();	/**빵 선택하면 에그 메뉴 선택 GUI 출력*/
			}
			else if(obj==btMilk)
			{
				Bread.setMenu("Milk");
				f.setVisible(false);
				new ShowEgg();	
			}
			else if(obj==btChestnut)
			{
				Bread.setMenu("Chestnut");
				f.setVisible(false);
				new ShowEgg();	
			}
			else if(obj==btBefore)
			{
				f.setVisible(false);
				new ShowMenu();	
			}
			else if(obj==btMain)
			{
				new ShowMainPage();	
				f.setVisible(false);
			}
		}
	}
}
