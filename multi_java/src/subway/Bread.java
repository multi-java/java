package subway;
import javax.swing.*;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.*;


public class Bread extends Sandwich
{
	private static String menu;
	@Override
	public String choice(String menu)	/**부모 클래스(Sandwich)의 메소드 오버라이드*/
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
	JLabel Lblogo,Lbname,Lbline,lbMenu,lbBread;
	
	
	public ShowBread()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**프레임을 닫았을 때 메모리에서 제거되도록 설정*/
		f.getContentPane().setLayout(null);				/**프레임을 화면 가운데에 배치*/
		
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\주문하기.jpg")); //메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
		btHoney = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\꿀빵.jpg"));
		btMilk = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\우유빵.jpg"));
		btChestnut = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\밤빵.jpg"));
		btMain = new JButton("메인");
		btBefore = new JButton("",(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\돌아가기.png")));
		lbBread = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\빵을 골라주세요.jpg"));

	
		Lblogo.setBounds(5, 5, 100, 100); 
		Lbname.setBounds(170, 10, 150, 100); 
		Lbline.setBounds(0, 100, 500, 50); 
		lbBread.setBounds(100, 150, 250,100);
		btHoney.setBounds(312, 250, 130, 130);		/**setBounds -> 좌우,상하,너비,높이 순서*/
		btMilk.setBounds(10, 250, 130, 130);
		btChestnut.setBounds(162, 250, 122, 130);
		btMain.setBounds(330, 530, 100, 50);
		btBefore.setBounds(380, 10, 100, 100);
		

		btHoney.setBackground(Color.white); //메뉴사진(bt) 테두리 없애기
		btHoney.setBorderPainted(false);
		btMilk.setBackground(Color.white);
		btMilk.setBorderPainted(false);
		btChestnut.setBackground(Color.white);
		btChestnut.setBorderPainted(false);
		btBefore.setBackground(Color.white);
		btBefore.setBorderPainted(false);

		
		f.getContentPane().add(Lbline);		
		f.getContentPane().add(Lbname);		
		f.getContentPane().add(Lblogo);	
		f.getContentPane().add(lbBread);		/**프레임에서 컨텐츠 영역을 가져와서 라벨을 붙임*/
		f.getContentPane().add(btHoney);
		f.getContentPane().add(btMilk);
		f.getContentPane().add(btChestnut);
		f.getContentPane().add(btMain);
		f.getContentPane().add(btBefore);
		f.getContentPane().setBackground(Color.white);
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
			if(obj==btHoney)	/**Honey 버튼을 클릭했을 때*/
			{
				Bread.setMenu("Honey");	/**빵 honey를 선택*/
				f.setVisible(false);	/**현재 창은 보이지 않도록 설정*/
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
			else if(obj==btBefore)	/**이전 버튼 클릭 했을 때*/
			{
				f.setVisible(false);
				new ShowMenu();		/**이전 창 출력*/
			}
			else if(obj==btMain)	/**메인 버튼 클릭 했을 때*/
			{
				new ShowMainPage();	/**메인 창 출력*/
				f.setVisible(false);
			}
		}
	}
}
