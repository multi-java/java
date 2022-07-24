package subway;
import javax.swing.*;

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
	JButton btEgg,btBacon,btCheese,btMain,btBefore,btNext;
	JLabel lbMenu;
	ImageIcon img,img2,img3;
	
	

	public ShowMenu()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**프레임을 닫았을 때 메모리에서 제거되도록 설정*/
		f.getContentPane().setLayout(null);				/**프레임을 화면 가운데에 배치*/
		
		/**<레이아웃 구성>
		1.메뉴사진(bt)
		3.메뉴선택(lb)
		3.이동(bt)
		*/

		//////////// 1. 메뉴사진(bt)
		btEgg = new JButton("에그 토스트"); //메뉴사진 버튼 생성
		btBacon = new JButton("베이컨 토스트",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\Bacon_Toast_2.png"));
		btCheese = new JButton("치즈 토스트");
		
		//btEgg.setIcon(i); //메뉴버튼에 이미지넣기
		//btBacon.setIcon(i);
		//btCheese.setIcon(i);
		
		btEgg.setBounds(10, 170, 122, 100);	//메뉴사진 버튼 사이즈 설정 (setBounds -> 좌우,상하,너비,높이 순서)
		btBacon.setBounds(162, 170, 122, 100);
		btCheese.setBounds(312, 170, 122, 100);
		btBacon.setVerticalTextPosition(JButton.BOTTOM);
		btBacon.setHorizontalTextPosition(JButton.CENTER);
		
		img = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\Bacon_Toast.jpg"); //이미지파일가져오기
		img2 = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\Cheeses_Toast.jpg");
		img3 = new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\Egg_Toast.jpg");
		
		f.getContentPane().add(btEgg); //메뉴사진 버튼 붙이기
		f.getContentPane().add(btBacon);
		f.getContentPane().add(btCheese);
		
		
		//////////// 2. 메뉴선택(lb)
		lbMenu = new JLabel("<메뉴 선택>"); //메뉴선택 라벨 생성
		lbMenu.setBounds(162, 70, 100, 100); //메뉴선택 사이즈 설정
		
		f.getContentPane().add(lbMenu);		//메뉴선택 라벨 붙임
		
		
		////////////3. 이동(bt)	
		btMain = new JButton("메인"); //이동버튼 생성
		btBefore = new JButton("이전");

		btMain.setBounds(330, 30, 100, 50); //이동버튼 사이즈
		btBefore.setBounds(10, 30, 100, 50);
		
		f.getContentPane().add(btMain); //이동버튼 붙이기
		f.getContentPane().add(btBefore);
		
		
		
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
				if (ShowMainPage.getOrderList().size()<4){ 		//4개이하면 받고, 4개이상이면 에러창띄어주기
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
				if (ShowMainPage.getOrderList().size()<4){ 		//4개이하면 받고, 4개이상이면 에러창띄어주기
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
