package subway;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Order extends JFrame
{
	JFrame f = new JFrame();
	JTextArea ta;
	JButton btMain,btSave,btmypage,btShopping,btbookmark,btlogout;
	JScrollPane scrollPane;
	JLabel Lblogo,Lbname,Lbline, Lbline2, Lbcheck;
	
	
	/**ArrayList를 문자열로 가져오는 과정에서 생기는 불필요한 문자들을 제거*/
	
	int count = 1;
	int total_price = 0;
	int lastIdx = ShowMainPage.getOrderList().size() - 1;
	String orderList = ShowMainPage.getOrderList().get(lastIdx).toString().replace("[","").replace("]", "").replaceAll(",", "");
	public Order()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		btMain = new JButton("메인페이지");
		btSave = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\영수증출력.jpg"));
		Lbcheck = new JLabel("주문하신 전체내역은 <주문내역>에서도 확인할 수 있습니다");
		ta=new JTextArea();
		
		scrollPane = new JScrollPane();
        scrollPane.getViewport().add(ta);
		
        
		btMain.setBounds(330, 30, 100, 50);
		btSave.setBounds(150, 450, 200, 30);
		scrollPane.setBounds(150, 170, 200, 230);
		Lbcheck.setBounds(80, 410, 400, 30);
		
		
		ta.append(orderList+"총 결제 금액 : "+ShowMainPage.getTotal_price());/**TextArea에 출력할 내용 저장*/
		count++;
		
		
		f.getContentPane().add(btMain);
		f.getContentPane().add(btSave);
		f.getContentPane().add(Lbcheck);
		f.getContentPane().add(scrollPane);
		f.getContentPane().setBackground(Color.WHITE);
	    ta.setEditable(false);						/**Textarea에 값 입력 못하게 설정*/
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btMain.addActionListener(handler);
		btSave.addActionListener(handler);
	
	
	//이동버튼 관련
	
    btmypage = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
    btShopping = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
    btbookmark = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\즐겨찾기.jpg"));
    btlogout = new JButton("",new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\로그아웃.jpg"));
    
    btmypage.setBounds(0, 570, 125, 100); //x, y, 가로, 세로
    btShopping.setBounds(125,570,125,100);
    btbookmark.setBounds(250, 570, 125, 100); //x, y, 가로, 세로
    btlogout.setBounds(375, 570, 125, 100); //x, y, 가로, 세로
    
    f.getContentPane().add(btmypage);   
    f.getContentPane().add(btShopping);
    f.getContentPane().add(btbookmark);   
    f.getContentPane().add(btlogout);   
    
    btmypage.setBackground(Color.white);
    btmypage.setBorderPainted(false);
    btShopping.setBackground(Color.white);
    btShopping.setBorderPainted(false);
    btbookmark.setBackground(Color.white);
    btbookmark.setBorderPainted(false);
    btlogout.setBackground(Color.white);
    btlogout.setBorderPainted(false);
    
    
    //제목라벨 관련
    
    Lblogo = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
    Lbname = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\주문내역.jpg")); //메뉴선택 라벨 생성
    Lbline = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
    Lbline2 = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
    
    
    Lblogo.setBounds(5, 5, 100, 100); // x, y, 가로, 세로
    Lbname.setBounds(170, 10, 150, 100); // x, y, 가로, 세로
    Lbline.setBounds(0, 100, 500, 50); // x, y, 가로, 세로
    Lbline2.setBounds(0, 480, 500, 50); // x, y, 가로, 세로
    
    f.getContentPane().add(Lbline);     
    f.getContentPane().add(Lbline2); 
    f.getContentPane().add(Lbname);      
    f.getContentPane().add(Lblogo);
    f.getContentPane().setBackground(Color.white);
}

	
	
	class MyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object obj = e.getSource();
			if(obj==btMain)
			{
				new ShowMainPage();	
				f.setVisible(false);
			}
			else if(obj==btSave)
			{
				PrintWriter printWriter = null;	/**문자열을 파일에 저장하기 위해 printWriter를 사용*/
		        {
		            try 
		            {
		                printWriter = new PrintWriter("C:\\Users\\park\\git\\java\\order_List.txt");/**파일 저장 경로를 지정*/
		                
		                if(printWriter.checkError()==false)	/**파일 저장하는 도중에 에러가 발생하는지 체크, 에러가 발생하면 true 리턴*/
				            JOptionPane.showMessageDialog(null,"저장이 완료되었습니다 ! ","Success",JOptionPane.INFORMATION_MESSAGE);
		                
		                else	
				            JOptionPane.showMessageDialog(null,"저장 실패했습니다 ! ","Error",JOptionPane.ERROR_MESSAGE);
		            } 
		            
		            catch (FileNotFoundException e1) /**문자열이 존재하지 않거나 파일을 만들 수 없거나 파일을 열거나 만드는 동안 다른 오류가 발생하면*/
		            {
		            	JOptionPane.showMessageDialog(null,e1.getMessage());
		            }
		            
		            catch (IOException e1) {	/**입출력 예외 처리*/
		    			e1.printStackTrace();	/**에러의 발생근원지를 찾아서 단계별로 에러를 출력*/
		    		}
		            
		        	/**널 체크를 위한 명령어, printWriter가 null이라면 NullPointerException 발생*/
		            Objects.requireNonNull(printWriter).println(ShowMainPage.getOrderList().toString().replace("[","").replace("]", "").replaceAll(",", ""));
		            printWriter.close();
		        }
			}
		}
	}
}