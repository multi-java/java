package subway;
import javax.swing.*;
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
		btNext = new JButton("다음");
		lbMenu = new JLabel("<쨈 선택>");
		lbMenu.setBounds(162, 70, 100, 100);
		btBlue.setBounds(10, 170, 122, 100);//좌우,상하,너비,높이
		btStraw.setBounds(162, 170, 122, 100);
		btApple.setBounds(312, 170, 122, 100);
		btMain.setBounds(330, 30, 100, 50);
		btBefore.setBounds(10, 300, 100, 50);
		btNext.setBounds(330, 300, 100, 50);
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btBlue);
		f.getContentPane().add(btStraw);
		f.getContentPane().add(btApple);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.getContentPane().add(btNext);
		f.setVisible(true);
		MyEventHandler handler = new MyEventHandler();
		btBlue.addActionListener(handler);
	}
	class MyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btBlue)
			{
				Jam.setMenu("Blueberry");
				new Order();	//빵 선택하면 에그 선택
				f.setVisible(false);
			}
		}
	}
}
