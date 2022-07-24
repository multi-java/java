package subway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Container;


public class BookMark extends JFrame {/**JFrame 상속*/
	JButton Drop1, Drop2, Drop3, Drop4; //버튼 선언
	
	public BookMark(){
		this.setTitle("즐겨찾기"); //프레임 타이틀 설정
		this.setSize(500,700); //프레임 사이즈 설정
		this.setVisible(true); //프레임 출력 실행
		this. setLocationRelativeTo(null); //화면 중앙 보내기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기
	
		
	Container container = this. getContentPane();
	
	container.setLayout(null); //container의 배치관리자 제거
	
	
	
    ////////////제목 (라벨)
	JLabel label = new JLabel("::즐겨찾기 PAGE::");
	label.setLocation(200,50); // 제목 위치설정
	label.setSize(300,100); // 제목 사이즈설정
	container.add(label); // 제목 붙이기
	
	
    ////////////메인 (버튼)
	JButton main = new JButton("메인");
	main.setLocation(390,20); // 메인 위치설정
	main.setSize(80,50); // 메인 사이즈설정
	container.add(main); // 메인 붙이기

	
	////////////즐겨찾기 순번(라벨)
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
	
	
	////////////즐겨찾기(버튼)

    test.order.add("1");
    test.order.add("2");
    test.order.add("3");
    test.order.add("4");
	
	JButton bookmark1 = new JButton(test.order. get(0)); //즐겨찾기 생성
	JButton bookmark2 = new JButton(test.order. get(1));
	JButton bookmark3 = new JButton(test.order. get(2));
	JButton bookmark4 = new JButton(test.order. get(3));

	bookmark1.setLocation(70, 200); //즐겨찾기 위치설정
	bookmark2.setLocation(70, 300);
	bookmark3.setLocation(70, 400);
	bookmark4.setLocation(70, 500);
	
	bookmark1.setSize(300,80); // 즐겨찾기 사이즈설정
	bookmark2.setSize(300,80);
	bookmark3.setSize(300,80);
	bookmark4.setSize(300,80);
	
	container.add(bookmark1); //즐겨찾기 붙이기
	container.add(bookmark2);
	container.add(bookmark3);
	container.add(bookmark4);
	
	
	////////////즐겨찾기삭제 (버튼)
	Drop1 = new JButton("삭제"); //삭제 생성
	Drop2 = new JButton("삭제");
	Drop3 = new JButton("삭제");
	Drop4 = new JButton("삭제");

	
	Drop1.setLocation(390, 200); //삭제 위치설정
	Drop2.setLocation(390, 300);
	Drop3.setLocation(390, 400);
	Drop4.setLocation(390, 500);
	
	Drop1.setSize(80,80); // 삭제 사이즈설정
	Drop2.setSize(80,80);
	Drop3.setSize(80,80);
	Drop4.setSize(80,80);
	
	container.add(Drop1); //삭제 붙이기
	container.add(Drop2);
	container.add(Drop3);
	container.add(Drop4);
    
	////////////즐겨찾기삭제 (이벤트처리)
	MyEventHandler handler = new MyEventHandler();
    Drop1.addActionListener(handler);    
}
	
	 class MyEventHandler implements ActionListener  {

		
		
	    public void actionPerformed(ActionEvent e)
	    {
	     try {//리스트가 비었을때 에러메시지 송출
	       Object click = e.getSource();
	       if(click==Drop1)//삭제버튼을 눌렀을 때
	       {
	    	   test.order.remove(0);
	    	   System.out.println(test.order. get(0));
	       }
	       else if(click==Drop2)//삭제버튼을 눌렀을 때
	       {
	    	   test.order.remove(1);
	    	   System.out.println(test.order. get(1));
	       }
	       else if(click==Drop3)//삭제버튼을 눌렀을 때
	       {
	    	   test.order.remove(2);
	    	   System.out.println(test.order. get(2));
	       }
	       else if(click==Drop4)//삭제버튼을 눌렀을 때
	       {
	    	   test.order.remove(3);
	    	   System.out.println(test.order. get(3));
	       }
	     }catch(IndexOutOfBoundsException a) {System.out.println("삭제할 것이 없습니다");}
	    }
	 }
	 
	 	


public static void main(String[] args) 
	{
		new BookMark(); //페이지 실행
	}
}
	
	
	