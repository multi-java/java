package subway;
import javax.swing.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;


public class Menu extends Sandwich
{
	private static String menu;
	private static int price;
	public static int getPrice() {
		return price;
	}
	public static void setPrice(int price) {
		Menu.price = price;
	}
	@Override
	public String choice(String menu)		/**부모 클래스(Sandwich)의 메소드 오버라이드*/
	{
		Menu.menu=menu;
		return menu;
	}
	public void Show()
	{
		
	}
	public static String getMenu() {
		return menu;
	}
	public static void setMenu(String menu) {
		Menu.menu = menu;
	}
	
}
class ShowMenu extends JFrame//메뉴 선택 GUI 출력
{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton btEgg,btBacon,btCheese,btMain,btBefore,btNext,btmypage, btbookmark;
	JLabel Lblogo, Lbline, Lbname,lbMenu;
	ImageIcon img,img2,img3;
	
	

	public ShowMenu()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**프레임을 닫았을 때 메모리에서 제거되도록 설정*/
		f.getContentPane().setLayout(null);				/**프레임을 화면 가운데에 배치*/
		
		/**<레이아웃 구성>
		1.까페로고(lb)
		2.메뉴이름(lb)
		3.메뉴사진(bt)
		4.메뉴선택(lb)
		5.이동(bt)
		*/
		
		
		////////////1. 까페로고(lb)
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
		Lblogo.setBounds(5, 5, 100, 100); //메뉴선택 사이즈 설정
		f.getContentPane().add(Lblogo);		//메뉴선택 라벨 붙임
		
		////////////2. 메뉴이름(lb)
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문하기.jpg")); //메뉴선택 라벨 생성
		Lbname.setBounds(170, 10, 150, 100); //메뉴선택 사이즈 설정
		f.getContentPane().add(Lbname);		//메뉴선택 라벨 붙임
		
		////////////3. 선(lb)
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
		Lbline.setBounds(0, 100, 500, 50); //메뉴선택 사이즈 설정
		f.getContentPane().add(Lbline);		//메뉴선택 라벨 붙임
		

		//////////// 4. 메뉴사진(bt)
		btEgg = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\에그토스트.jpg")); //메뉴사진(bt) 생성
		btBacon = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\베이컨토스트.jpg"));
		btCheese = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\치즈토스트.jpg"));
		
		
		btEgg.setBounds(10, 250, 130, 130);	//메뉴사진(bt) 사이즈 설정 (setBounds -> 좌우,상하,너비,높이 순서)
		btBacon.setBounds(162, 250, 130, 130);
		btCheese.setBounds(312, 250, 130, 130);
		
		btEgg.setBackground(Color.white); //메뉴사진(bt) 테두리 없애기
		btEgg.setBorderPainted(false);
		btBacon.setBackground(Color.white);
		btBacon.setBorderPainted(false);
		btCheese.setBackground(Color.white);
		btCheese.setBorderPainted(false);
		
		
		  f.getContentPane().add(btEgg); //메뉴사진 버튼 붙이기 f.getContentPane().add(btBacon);
		  f.getContentPane().add(btCheese);
		  f.getContentPane().add(btBacon);
		 
		//p.add(pTitle,"North");
		//p.add(pContent,"Center");
		//p.add(pNavi,"South");
		
		

		//////////// 5. 메뉴선택(lb)
		lbMenu = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\메뉴를 골라주세요.jpg")); //메뉴선택 라벨 생성
		lbMenu.setBounds(100, 150, 250, 100); //메뉴선택 사이즈 설정
		f.getContentPane().add(lbMenu);		//메뉴선택 라벨 붙임
		
		
		////////////6. 이동(bt)	
		btMain = new JButton("메인"); //이동버튼 생성
		btBefore = new JButton("",(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\돌아가기.png")));
		btbookmark = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\즐겨찾기.jpg"));
		btmypage = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		
		btMain.setBounds(700, 700, 100, 50); //이동버튼 사이즈
		btBefore.setBounds(380, 10, 100, 100);
		btbookmark.setBounds(0, 550, 125, 100);
		btmypage.setBounds(125, 550, 125, 100);

		

		f.getContentPane().add(btMain); //이동버튼 붙이기
		f.getContentPane().add(btBefore);
		f.getContentPane().add(btbookmark);		
		f.getContentPane().add(btmypage);	
		f.getContentPane().setBackground(Color.white);
		
		
		btBefore.setBackground(Color.white); //이동버튼(bt) 테두리 없애기
		btBefore.setBorderPainted(false);
		btbookmark.setBackground(Color.white);
		btbookmark.setBorderPainted(false);
		btmypage.setBackground(Color.white);
		btmypage.setBorderPainted(false);

		
		
		f.setVisible(true);
		
		

		/**<이벤트 구성>
		1. 메뉴사진(bt)
		2. 이동(bt)
		*/
			
		MyEventHandler handler = new MyEventHandler();
	
		////////////1. 메뉴사진(bt)
	btEgg.addActionListener(handler);
	btBacon.addActionListener(handler);
	btCheese.addActionListener(handler);
		
	
		////////////2. 이동(bt) 
	btMain.addActionListener(handler);}
	
	
	
	class MyEventHandler implements ActionListener	/**버튼을 클릭하면 발생하는 클래스*/
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			
		//////////////1-1. 메뉴 사진 버튼
			if(obj==btEgg)//Egg 버튼을 클릭했을 때
			{
				if (ShowMainPage.getOrderList().size()<4){ 		//4개이하면 받고, 4개이상이면 에러창띄어주기
					Menu.setMenu("Egg");//메뉴 저장
					Menu.setPrice(2000);//메뉴 가격 저장
					new ShowBread();	//빵 메뉴 출력
					f.setVisible(false);//현재 창은 보이지 않도록 설정
				}
				else
				{
					JOptionPane.showMessageDialog(null,"주문은 4개까지만 가능합니다 !","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE); //에러창띄어주기
				}
			}
			else if(obj==btBacon)
			{
				if 
				(
					ShowMainPage.getOrderList().size()<4){ 		//4개이하면 받고, 4개이상이면 에러창띄어주기
					Menu.setMenu("Bacon");
					Menu.setPrice(3000);
					f.setVisible(false);
					new ShowBread();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"주문은 4개까지만 가능합니다 !","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE); //에러창띄어주기
				}
			}
			else if(obj==btCheese)
			{	
				if (
						ShowMainPage.getOrderList().size()<4){ 		//4개이하면 받고, 4개이상이면 에러창띄어주기
						Menu.setMenu("Cheese");
						Menu.setPrice(2500);
						f.setVisible(false);
						new ShowBread();
					}
				else
				{
					JOptionPane.showMessageDialog(null,"주문은 4개까지만 가능합니다 !","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE); //에러창띄어주기
				}
			}
			
			///////////////2-1. 이동 버튼
			else if(obj==btMain)	/**메인 버튼 클릭 했을 때*/
			{
				new ShowMainPage();		/**메인 창 출력*/
				f.setVisible(false);
			}
		}
	}
}
