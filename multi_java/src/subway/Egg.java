package subway;
import javax.swing.*;
import java.awt.event.*;

public class Egg extends Sandwich
{
	private static String menu;
	private static int topping_price;
	public static int getTopping_price() {
		return topping_price;
	}
	public static void setTopping_price(int topping_price) {
		Egg.topping_price = topping_price;
	}
	public static String getMenu() {
		return menu;
	}
	public static void setMenu(String menu) {
		Egg.menu = menu;
	}
	@Override
	public String choice(String menu)
	{
		Egg.menu=menu;
		return menu;
	}
	public Egg() {
		
	}

}
class ShowEgg extends JFrame
{
	JFrame f = new JFrame();
	JButton btCheese,btEgg,btHam,btMain,btBefore,btNext;
	JLabel lbMenu;
	
	public ShowEgg()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		btCheese = new JButton("Cheese");
		btEgg = new JButton("Egg");
		btHam = new JButton("Ham");
		btMain = new JButton("메인");
		btBefore = new JButton("이전");
		lbMenu = new JLabel("<토핑 선택>");
		
		
		lbMenu.setBounds(162, 70, 100, 100);
		btCheese.setBounds(10, 170, 122, 100);			//좌우,상하,너비,높이
		btEgg.setBounds(162, 170, 122, 100);
		btHam.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 30, 100, 50);
		
		
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btCheese);
		f.getContentPane().add(btEgg);
		f.getContentPane().add(btHam);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btCheese.addActionListener(handler);
		btEgg.addActionListener(handler);
		btHam.addActionListener(handler);
		btBefore.addActionListener(handler);
		btMain.addActionListener(handler);
	}
	class MyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btCheese)
			{
				Egg.setMenu("Cheese");
				Egg.setTopping_price(1000);		/**Cheese 토핑의 가격*/
				new ShowJam();					/**쨈 화면 출력*/
				f.setVisible(false);
			}
			else if(obj==btEgg)
			{
				Egg.setMenu("Egg");
				Egg.setTopping_price(500);
				new ShowJam();	
				f.setVisible(false);
			}
			else if(obj==btHam)
			{
				Egg.setMenu("Ham");
				Egg.setTopping_price(1500);
				new ShowJam();	
				f.setVisible(false);
			}
			else if(obj==btBefore)
			{
				f.setVisible(false);
				new ShowBread();	
			}
			else if(obj==btMain)
			{
				new ShowMainPage();	
				f.setVisible(false);
			}
		}
	}
}