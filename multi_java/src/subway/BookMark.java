package subway;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;



public class BookMark extends JFrame {//JFrame 상속
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	
	JButton Drop0, Drop1, Drop2, Drop3; //삭제버튼 선언
	JButton bookmark0, bookmark1, bookmark2, bookmark3 ; //즐겨찾기버튼 선언
	JLabel Lblogo,Lbname,Lbline;
	JScrollPane scrollPane;
	

    
    public void check() { //북마크를 삭제할 때 해당 인덱스값이 비었다면 공백값으로 표시하는 메소드
	   if(ShowMainPage.getOrderList().size()==3) {
    	   bookmark0.setText(ShowMainPage.getOrderList().get(0));
    	   bookmark1.setText(ShowMainPage.getOrderList().get(1));
    	   bookmark2.setText(ShowMainPage.getOrderList().get(2));
    	   bookmark3.setText(""); 
	   }
	   else if(ShowMainPage.getOrderList().size()==2) {
    	   bookmark0.setText(ShowMainPage.getOrderList().get(0));
    	   bookmark1.setText(ShowMainPage.getOrderList().get(1));
    	   bookmark2.setText(""); 
    	   bookmark3.setText(""); 
	   }
       else if(ShowMainPage.getOrderList().size()==1) {
    	   bookmark0.setText(ShowMainPage.getOrderList().get(0));
    	   bookmark1.setText(""); 
    	   bookmark2.setText(""); 
    	   bookmark3.setText(""); 
       }
	  else if(ShowMainPage.getOrderList().size()<1) {
		  bookmark0.setText(""); 
		  bookmark1.setText(""); 
		  bookmark2.setText(""); 
		  bookmark3.setText(""); 
	 }
    }
    
    
	/** <레이아웃 초기설정>
	1. 상환씨꺼 복사 */
    
	public BookMark(){
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임을 닫았을 때 메모리에서 제거되도록 설정
		f.getContentPane().setLayout(null);		
		
		
	/** <레이아웃 구성>
	1. 페이지이름 => 라벨 
	2. 메인돌아가기버튼 => 버튼
	3. 즐겨찾기순번 => 라벨
	4. 즐겨찾기내용 => 버튼
	5. 즐겨찾기삭제 => 버튼
	 **/
	
	 //////////// 1. 페이지이름 (라벨)
			
	Lblogo = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\까페로고.jpg")); //메뉴선택 라벨 생성
	Lbname = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\MY페이지.jpg")); //메뉴선택 라벨 생성
	Lbline = new JLabel(new ImageIcon("C:\\Users\\하은\\git\\java\\multi_java\\Image\\선.png")); //메뉴선택 라벨 생성
	
	Lblogo.setBounds(5, 5, 100, 100); //(위치) 가로, 세로 (크기) 가로, 세로
	Lbname.setBounds(170, 10, 150, 100); 
	Lbline.setBounds(0, 100, 500, 50); 
	
	f.getContentPane().add(Lbline);		
	f.getContentPane().add(Lbname);		
	f.getContentPane().add(Lblogo);
	f.getContentPane().setBackground(Color.white);
	
	//////////// 3. 즐겨찾기순번(라벨)
	JLabel no1 = new JLabel("1번"); //순번 생성
	JLabel no2 = new JLabel("2번");
	JLabel no3 = new JLabel("3번");
	JLabel no4 = new JLabel("4번");
	
	no1.setBounds(30,200,80,80); // 순번 위치설정
	no2.setBounds(30,300,80,80);
	no3.setBounds(30,400,80,80);
	no4.setBounds(30,500,80,80);
	
	f.getContentPane().add(no1);		
	f.getContentPane().add(no2);		
	f.getContentPane().add(no3);
	f.getContentPane().add(no4);

	
	//////////// 4. 즐겨찾기내용(버튼)
	bookmark0 = new JButton(); //즐겨찾기 생성
	bookmark1 = new JButton(); //즐겨찾기 생성
	bookmark2 = new JButton(); //즐겨찾기 생성
	bookmark3 = new JButton(); //즐겨찾기 생성
	check();
	
	bookmark0.setBounds(70, 200,300,80); //즐겨찾기 위치설정
	bookmark1.setBounds(70, 300,300,80);
	bookmark2.setBounds(70, 400,300,80);
	bookmark3.setBounds(70, 500,300,80);
	
	f.getContentPane().add(bookmark0);		
	f.getContentPane().add(bookmark1);		
	f.getContentPane().add(bookmark2);
	f.getContentPane().add(bookmark3);
	
	
	//////////// 5. 즐겨찾기삭제 (버튼)
	Drop0 = new JButton("삭제"); //삭제 생성
	Drop1 = new JButton("삭제");
	Drop2 = new JButton("삭제");
	Drop3 = new JButton("삭제");

	
	Drop0.setBounds(390, 200,80,80); //삭제 위치설정
	Drop1.setBounds(390, 300,80,80);
	Drop2.setBounds(390, 400,80,80);
	Drop3.setBounds(390, 500,80,80);

	f.getContentPane().add(Drop0);		
	f.getContentPane().add(Drop1);		
	f.getContentPane().add(Drop2);
	f.getContentPane().add(Drop3);
	
	f.setVisible(true);
	
	
	
	/** <이벤트구성>
	1. 즐겨찾기삭제 (버튼)  => 눌렀을 경우, 해당 index의 배열요소가 삭제됨. 
						삭제된 index 에는 그 다음 순번의 배열요소가 들어옴.
	2. 이동하기 (버튼)  =>  메인으로 이동한다.			
	 **/
    
	
	//////////// 1. 즐겨찾기삭제 (이벤트처리)
	MyEventHandler handler = new MyEventHandler(); //리스너 처리
    Drop0.addActionListener(handler); 
    Drop1.addActionListener(handler);
    Drop2.addActionListener(handler);
    Drop3.addActionListener(handler);
    
}
	
	 class MyEventHandler implements ActionListener  {
	    public void actionPerformed(ActionEvent e)
	    {
	     try {//리스트가 비었을때 에러메시지 송출
	       Object click = e.getSource();
	       
	       if(click==Drop0)//삭제버튼을 눌렀을 때
	       {
	    	   ShowMainPage.getOrderList().remove(0);
	    	   System.out.println(ShowMainPage.getOrderList().size());
	    	   check();
	       }
	       
	       if(click==Drop1)//삭제버튼을 눌렀을 때
	       {
	    	   ShowMainPage.getOrderList().remove(1);
	    	   check();
	       }
	       if(click==Drop2)//삭제버튼을 눌렀을 때
	       {
	    	   ShowMainPage.getOrderList().remove(2);
	    	   check();
	       }
	       if(click==Drop3)//삭제버튼을 눌렀을 때
	       {
	    	   ShowMainPage.getOrderList().remove(3);
	    	   check();
	       }
	       
	       
	   	/* 2. 메인이동하기버튼 (이벤트처리)	       
			if(click==btMain)	//메인 버튼 클릭 했을 때
			{
				new ShowMainPage();//메인 창 출력
				f.setVisible(false);
			}
	     */
	       
	     }catch(IndexOutOfBoundsException a) {
	    	 JOptionPane.showMessageDialog(null,"더 이상 삭제할 것이 없습니다.","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE); //에러창띄어주기
	     }
	    
	     
	     }//액션퍼포먼스
	    
	 }//핸들러
	 
	 
}//퍼블릭클래스
	 	

	
	