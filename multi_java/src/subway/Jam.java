package subway;
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
	JButton btBlue,btStraw,btApple,btMain,btBefore,btNext,btmypage,btbookmark;
	JLabel Lblogo,Lbname,Lbline,lbMenu;
	
	public ShowJam()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\주문하기.jpg")); //메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
		btBlue = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\블루베리쨈.jpg"));
		btStraw = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\딸기쨈.jpg"));
		btApple = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\사과쨈.jpg"));
		btMain = new JButton("메인");
		btBefore = new JButton("",(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\돌아가기.png")));
		lbMenu = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\쨈을 골라주세요.jpg"));
		btbookmark = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\즐겨찾기.jpg"));
		btmypage = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		
		Lblogo.setBounds(5, 5, 100, 100); 
		Lbname.setBounds(170, 10, 150, 100); 
		Lbline.setBounds(0, 100, 500, 50); 
		lbMenu.setBounds(100, 150, 250, 100);
		btBlue.setBounds(10, 250, 130, 130);		/**setBounds -> 좌우,상하,너비,높이 순서*/
		btStraw.setBounds(162,250, 130, 130);
		btApple.setBounds(312,250, 130, 130);
		btMain.setBounds(330, 530, 100, 50);
		btBefore.setBounds(380, 10, 100, 100);
		btbookmark.setBounds(0, 550, 125, 100);
		btmypage.setBounds(125, 550, 125, 100);
		
		btBlue.setBackground(Color.white); //메뉴사진(bt) 테두리 없애기
		btBlue.setBorderPainted(false);
		btStraw.setBackground(Color.white);
		btStraw.setBorderPainted(false);
		btApple.setBackground(Color.white);
		btApple.setBorderPainted(false);
		btBefore.setBackground(Color.white);
		btBefore.setBorderPainted(false);
		btbookmark.setBackground(Color.white);
		btbookmark.setBorderPainted(false);
		btmypage.setBackground(Color.white);
		btmypage.setBorderPainted(false);
		
		
		f.getContentPane().add(lbMenu);
		f.getContentPane().add(btBlue);
		f.getContentPane().add(btStraw);
		f.getContentPane().add(btApple);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.getContentPane().add(Lbline);		
		f.getContentPane().add(Lbname);		
		f.getContentPane().add(Lblogo);		
		f.getContentPane().add(btbookmark);		
		f.getContentPane().add(btmypage);	
		f.getContentPane().setBackground(Color.white);
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
