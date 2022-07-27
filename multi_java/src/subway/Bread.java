package subway;
import javax.swing.*;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.*;

/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 빵 선택 화면
 * 
 * 1) 메뉴 선택 화면에서 넘어오면 빵 선택 화면이 나온다.
 * 2) 빵은 총 3가지로 구성되어 있다.
 * 3) 이전 페이지로 돌아가는 버튼, 메뉴를 선택할 수 있는 버튼, 하단에는 네비게이션 바(my페이지, 주문하기, 즐겨찾기, 로그아웃)으로 구성되어 있다.
 * 	<1> 메뉴를 클릭하면 선택한 메뉴의 토핑을 선택할 수 있는 페이지로 연결된다.
 * 	<2> 이전 버튼을 클릭하면 메뉴 선택 화면으로 돌아간다.
 * 
 *  
 * @author 박상환
 * 작성일: 22-07-27
 */


/**
 * 추상 클래스인 Sandwich를 상속받는 클래스
 * @author 박상환
 *
 */
public class Bread extends Sandwich
{
	private static String menu;
	@Override
	public String choice(String menu)	//부모 클래스(Sandwich)의 메소드 오버라이드
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

/**
 * 빵 메뉴 GUI 출력하기 위한 클래스
 * */
class ShowBread extends JFrame		
{
	JFrame f = new JFrame();
	JButton btHoney,btMilk,btChestnut,btBefore,btNext,btmypage, btShopping, btbookmark, btlogout ;
	JLabel Lblogo,Lbname,Lbline,lbMenu,lbBread;
	
	/**
	 * 생성자
	 * 화면에 들어갈 버튼, 라벨 등에 대해 설정하고 화면에 추가해준다.
	 */
	public ShowBread()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임을 닫았을 때 메모리에서 제거되도록 설정
		f.getContentPane().setLayout(null);				//프레임을 화면 가운데에 배치
	      btmypage = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
        btShopping = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
        btbookmark = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\MV주문내역.jpg"));
        btlogout = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg"));
	            
	           
	    
	            
	            
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문하기.jpg")); //메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
		btHoney = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\꿀빵.jpg"));
		btMilk = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\우유빵.jpg"));
		btChestnut = new JButton("",new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\밤빵.jpg"));
		btBefore = new JButton("",(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\돌아가기.png")));
		lbBread = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\빵을 골라주세요.jpg"));

	
		Lblogo.setBounds(5, 5, 100, 100); 
		Lbname.setBounds(170, 10, 150, 100); 
		Lbline.setBounds(0, 100, 500, 50); 
		lbBread.setBounds(100, 150, 250,100);
		btHoney.setBounds(312, 250, 130, 130);		//setBounds -> 좌우,상하,너비,높이 순서
		btMilk.setBounds(10, 250, 130, 130);
		btChestnut.setBounds(162, 250, 122, 130);
		btBefore.setBounds(380, 10, 100, 100); 
		btmypage.setBounds(0, 570, 125, 100); //x, y, 가로, 세로
        btShopping.setBounds(125,570,125,100);
        btbookmark.setBounds(250, 570, 125, 100); //x, y, 가로, 세로
        btlogout.setBounds(375, 570, 125, 100); //x, y, 가로, 세로
		

		btHoney.setBackground(Color.white); //메뉴사진(bt) 테두리 없애기
		btHoney.setBorderPainted(false);
		btMilk.setBackground(Color.white);
		btMilk.setBorderPainted(false);
		btChestnut.setBackground(Color.white);
		btChestnut.setBorderPainted(false);
		btBefore.setBackground(Color.white);
		btBefore.setBorderPainted(false);
		btmypage.setBackground(Color.white);
        btmypage.setBorderPainted(false);
        btShopping.setBackground(Color.white);
        btShopping.setBorderPainted(false);
        btbookmark.setBackground(Color.white);
        btbookmark.setBorderPainted(false);
        btlogout.setBackground(Color.white);
        btlogout.setBorderPainted(false);

		
		f.getContentPane().add(Lbline);		
		f.getContentPane().add(Lbname);		
		f.getContentPane().add(Lblogo);	
		f.getContentPane().add(lbBread);		//프레임에서 컨텐츠 영역을 가져와서 라벨을 붙임
		f.getContentPane().add(btHoney);
		f.getContentPane().add(btMilk);
		f.getContentPane().add(btChestnut);
		f.getContentPane().add(btBefore);        
        f.getContentPane().add(btmypage);   
        f.getContentPane().add(btShopping);
        f.getContentPane().add(btbookmark);   
        f.getContentPane().add(btlogout);   
		f.getContentPane().setBackground(Color.white);
		f.setVisible(true);			
				
		
		
		MyEventHandler handler = new MyEventHandler();
		btHoney.addActionListener(handler);
		btMilk.addActionListener(handler);
		btChestnut.addActionListener(handler);
		btBefore.addActionListener(handler);
	    btmypage.addActionListener(handler); 
	    btShopping.addActionListener(handler); 
	    btbookmark.addActionListener(handler); 
	    btlogout.addActionListener(handler); 

	}//생성자 끝
	
	/**
	 * 이벤트 핸들러 클래스
	 * 버튼 등에 이벤트가 발생했을 때 이벤트를 처리한다.
	 * */
	class MyEventHandler implements ActionListener 	
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btHoney)	//Honey 버튼을 클릭했을 때
			{
				Bread.setMenu("Honey");	//빵 honey를 선택
				f.setVisible(false);	//현재 창은 보이지 않도록 설정
				new ShowEgg();	//빵 선택하면 토핑 메뉴 선택 GUI 출력
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
			else if(obj==btBefore)	//이전 버튼 클릭 했을 때
			{
				f.setVisible(false);
				new ShowMenu();		//이전 창 출력
			}
			else if(obj==btlogout) {//로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();			 
				}
			else if(obj==btShopping) { //메뉴선택으로 이동
				f.setVisible(false);
				new ShowMainPage();
				}
			else if(obj==btbookmark) {//나만의 메뉴로 이동
				f.setVisible(false);
				new BookMark();
				}
			else if(obj== btmypage) {//마이페이지로 이동
				f.setVisible(false);
				new MP01_Main();
				}
		}//actionperformed 끝
	}//핸들러 끝
}//클래스 끝
