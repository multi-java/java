package bookmark;
import javax.swing.*;

import java.awt.Color;
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
	JLabel Lblogo,Lbname,Lbline,lbMenu;
	
	public ShowEgg()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\주문하기.jpg")); //메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
		btCheese = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\치즈.jpg"));
		btEgg = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\계란.jpg"));
		btHam = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\햄.jpg"));
		btMain = new JButton("",new ImageIcon(""));
		btBefore = new JButton("",(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\돌아가기.png")));
		lbMenu = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\토핑을 골라주세요.jpg"));
		
		
		Lblogo.setBounds(5, 5, 100, 100); 
		Lbname.setBounds(170, 10, 150, 100); 
		Lbline.setBounds(0, 100, 500, 50); 
		lbMenu.setBounds(100, 150, 250, 100);  //좌우,상하,너비,높이
		btCheese.setBounds(312, 250, 130, 130);			
		btEgg.setBounds(10, 250, 130, 130);
		btHam.setBounds(162, 250, 130, 130);
		btMain.setBounds(330, 530, 100, 50);
		btBefore.setBounds(380, 10, 100, 100);
		
		
		btCheese.setBackground(Color.white); //메뉴사진(bt) 테두리 없애기
		btCheese.setBorderPainted(false);
		btEgg.setBackground(Color.white);
		btEgg.setBorderPainted(false);
		btHam.setBackground(Color.white);
		btHam.setBorderPainted(false);
		btBefore.setBackground(Color.white);
		btBefore.setBorderPainted(false);
		
		
		f.getContentPane().add(Lbline);		
		f.getContentPane().add(Lbname);		
		f.getContentPane().add(Lblogo);	
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btCheese);
		f.getContentPane().add(btEgg);
		f.getContentPane().add(btHam);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.white);
		
		
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