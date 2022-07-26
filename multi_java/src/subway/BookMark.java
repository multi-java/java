package subway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class BookMark extends JFrame {//JFrame 상속
	JFrame f = new JFrame();
	JButton Drop0, Drop1, Drop2, Drop3; //삭제버튼 선언
	JButton bookmark0, bookmark1, bookmark2, bookmark3, btMain; //즐겨찾기버튼 선언
	Container container;
	
	

    
    public void check() { //북마크를 삭제할 때
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
	1. 배치관리자 제거 => 좌표로 레이아웃 위치, 크기 설정
	 **/
	public BookMark(){
		f.setTitle("즐겨찾기"); //프레임 타이틀 설정
		f.setSize(500,700); //프레임 사이즈 설정
		f.setVisible(true); //프레임 출력 실행
		f. setLocationRelativeTo(null); //화면 중앙 보내기
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기
	
		
	container = this. getContentPane();
	
	container.setLayout(null); //container의 배치관리자 제거
	
	
	
	/** <레이아웃 구성>
	1. 페이지이름 => 라벨 
	2. 메인돌아가기버튼 => 버튼
	3. 즐겨찾기순번 => 라벨
	4. 즐겨찾기내용 => 버튼
	5. 즐겨찾기삭제 => 버튼
	 **/
	
	 //////////// 1. 페이지이름 (라벨)
	JLabel label = new JLabel("::즐겨찾기 PAGE::");
	label.setLocation(200,50); // 제목 위치설정
	label.setSize(300,100); // 제목 사이즈설정
	container.add(label); // 제목 붙이기
	
	
    //////////// 2. 메인돌아가기 (버튼)
	btMain = new JButton("메인");
	btMain.setLocation(390,20); // 메인 위치설정
	btMain.setSize(80,50); // 메인 사이즈설정
	container.add(btMain); // 메인 붙이기

	
	//////////// 3. 즐겨찾기순번(라벨)
	JLabel no1 = new JLabel("1번"); //순번 생성
	JLabel no2 = new JLabel("2번");
	JLabel no3 = new JLabel("3번");
	JLabel no4 = new JLabel("4번");
	
	 no1.setLocation(30,200); // 순번 위치설정
	 no2.setLocation(30,300);
	 no3.setLocation(30,400);
	 no4.setLocation(30,500);
	
	 no1.setSize(80,80); // 순번 사이즈설정
	 no2.setSize(80,80);
	 no3.setSize(80,80);
	 no4.setSize(80,80);

	container.add(no1); // 순번 붙이기
	container.add(no2);
	container.add(no3);
	container.add(no4);
	
	
	//////////// 4. 즐겨찾기내용(버튼)

	
	bookmark0 = new JButton(); //즐겨찾기 생성
	bookmark1 = new JButton(); //즐겨찾기 생성
	bookmark2 = new JButton(); //즐겨찾기 생성
	bookmark3 = new JButton(); //즐겨찾기 생성
	check();


	bookmark0.setLocation(70, 200); //즐겨찾기 위치설정
	bookmark1.setLocation(70, 300);
	bookmark2.setLocation(70, 400);
	bookmark3.setLocation(70, 500);
	
	bookmark0.setSize(300,80); // 즐겨찾기 사이즈설정
	bookmark1.setSize(300,80);
	bookmark2.setSize(300,80);
	bookmark3.setSize(300,80);
	
	container.add(bookmark0); //즐겨찾기 붙이기
	container.add(bookmark1);
	container.add(bookmark2);
	container.add(bookmark3);
	
	
	//////////// 5. 즐겨찾기삭제 (버튼)
	Drop0 = new JButton("삭제"); //삭제 생성
	Drop1 = new JButton("삭제");
	Drop2 = new JButton("삭제");
	Drop3 = new JButton("삭제");

	
	Drop0.setLocation(390, 200); //삭제 위치설정
	Drop1.setLocation(390, 300);
	Drop2.setLocation(390, 400);
	Drop3.setLocation(390, 500);
	
	Drop0.setSize(80,80); // 삭제 사이즈설정
	Drop1.setSize(80,80);
	Drop2.setSize(80,80);
	Drop3.setSize(80,80);
	
	container.add(Drop0); //삭제 붙이기
	container.add(Drop1);
	container.add(Drop2);
	container.add(Drop3);
	
	f.add(container);
	container.setBackground(Color.WHITE);
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
    btMain.addActionListener(handler);
    
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
	       
	       
	   	//////////// 2. 메인이동하기버튼 (이벤트처리)	       
			if(click==btMain)	//메인 버튼 클릭 했을 때
			{
				new ShowMainPage();//메인 창 출력
				f.setVisible(false);
			}
	       
	     }catch(IndexOutOfBoundsException a) {System.out.println("삭제할 것이 없습니다");}
	
	     
	     
	    }//액션퍼포먼스
	    
	 }//핸들러
	 
	 
}//퍼블릭클래스
	 	

	
	