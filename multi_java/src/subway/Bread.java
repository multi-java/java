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
class ShowBread extends JFrame
{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();
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
		btNext = new JButton("다음");
		lbBread = new JLabel("<빵 선택>");
		lbBread.setBounds(162, 70, 100, 100);
		btHoney.setBounds(10, 170, 122, 100);//좌우,상하,너비,높이
		btMilk.setBounds(162, 170, 122, 100);
		btChestnut.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 300, 100, 50);
		btNext.setBounds(330, 300, 100, 50);
		/*
											 * btChestnut.setBounds(150, 50, 100, 100); btMain.setBounds(40, 10, 10,
											 * 10); btBefore.setBounds(50, 10, 10, 10);
											 */
		//p.add(lbBread);
		//p.add(btHoney);
		//p.add(btMilk);
		/*
						 * p.add(btChestnut); p.add(btMain); p.add(btBefore); p.add(btNext);
						 */
		//add(p,"Center");
		f.getContentPane().add(lbBread);
		f.getContentPane().add(btHoney);
		f.getContentPane().add(btMilk);
		f.getContentPane().add(btChestnut);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.getContentPane().add(btNext);
		f.setVisible(true);
		MyEventHandler handler = new MyEventHandler();
		btHoney.addActionListener(handler);
		//setSize(500,700);
		//setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyEventHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btHoney)
			{
				Bread.setMenu("Honey");
				f.setVisible(false);
				new ShowEgg();	//빵 선택하면 에그 선택
			}
		}
	}
}
