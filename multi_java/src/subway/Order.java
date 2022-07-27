package subway;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Objects;

/** 
 * 환경을 고려해 스마트팜을 통한 무농약 식재료로 만든 토스트 판매 애플리케이션
 * 
 * 선택한 메뉴의 내역 출력 화면
 * 
 * 1) 쨈까지 선택하면 선택한 메뉴의 내역을 알 수 있는 화면으로 넘어온다.
 * 2) 자신이 선택한 메뉴, 빵, 토핑, 쨈이 텍스트 형식으로 출력이 된다.
 * 3) 주문한 내역을 텍스트 파일로 저장할 수 있다.
 * 4) 주문한 내역을 텍스트파일로 저장할 수 있는 버튼, 하단에는 네비게이션 바(my페이지, 주문하기, 즐겨찾기, 로그아웃)으로 구성되어 있다.
 * 	<1> 저장 버튼을 클릭했을 때 성공적으로 저장이 된다면 저장이 완료되었습니다라는 메시지가 출력된다.
 * 		<1-1> 어떠한 예외로 인해 실패한다면 저장이 실패했습니다라는 메시지가 출력된다.
 *  
 * @author 박상환
 * 작성일: 22-07-27
 */

/**
 * 
 * 선택한 메뉴 내역을 출력하기 위한 클래스
 * 
 * @author 박상환
 *
 */
public class Order extends JFrame {
	JFrame f = new JFrame();
	JTextArea ta;
	JButton btSave, btmypage, btShopping, btbookmark, btlogout;
	JScrollPane scrollPane;

	JLabel Lblogo, Lbname, Lbline, Lbline2, Lbcheck;

	/** ArrayList를 문자열로 가져오는 과정에서 생기는 불필요한 문자들을 제거 */

	int count = 1;
	int total_price = 0;
	int lastIdx = Sandwich.getOrderList().size() - 1;
	String orderList = Sandwich.getOrderList().get(lastIdx).toString().replace("[", "").replace("]", "")
			.replaceAll(",", "");

	// ArrayList를 문자열로 가져오는 과정에서 생기는 불필요한 문자들을 제거


	/**
	 * 
	 * 생성자 버튼이나 라벨과 같은 요소들을 정의하고 프레임에 추가시켜준다.
	 * 
	 * @author 박상환
	 * 
	 */
	public Order() {
		f.setSize(500, 700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		btmypage = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\마이페이지.jpg"));
		btShopping = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\mv주문하기.jpg"));
		btbookmark = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문내역.jpg"));
		btlogout = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\로그아웃.jpg"));
		ta = new JTextArea();

		btSave = new JButton("", new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\영수증출력.jpg"));
		Lbcheck = new JLabel("주문하신 전체내역은 <주문내역>에서도 확인할 수 있습니다");

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(ta);

		btmypage.setBounds(0, 570, 125, 100); // x, y, 가로, 세로
		btShopping.setBounds(125, 570, 125, 100);
		btbookmark.setBounds(250, 570, 125, 100); // x, y, 가로, 세로
		scrollPane.getViewport().add(ta);
		btSave.setBounds(150, 450, 200, 30);
		scrollPane.setBounds(150, 170, 200, 230);
		Lbcheck.setBounds(80, 410, 400, 30);
		btlogout.setBounds(375, 570, 125, 100); // x, y, 가로, 세로 (로그아웃bt)

		ta.append(orderList + "총 결제 금액 : " + Sandwich.total_price_m());// TextArea에 출력할 내용 저장
		count++;

		f.getContentPane().add(btSave);
		f.getContentPane().add(Lbcheck);
		f.getContentPane().add(scrollPane);
		f.getContentPane().setBackground(Color.WHITE);
		f.getContentPane().add(btmypage);
		f.getContentPane().add(btShopping);
		f.getContentPane().add(btbookmark);
		f.getContentPane().add(btlogout);
		ta.setEditable(false); // Textarea에 값 입력 못하게 설정
		f.setVisible(true);

		btmypage.setBackground(Color.white);
		btmypage.setBorderPainted(false);
		btShopping.setBackground(Color.white);
		btShopping.setBorderPainted(false);
		btbookmark.setBackground(Color.white);
		btbookmark.setBorderPainted(false);
		btlogout.setBackground(Color.white);
		btlogout.setBorderPainted(false);

		MyEventHandler handler = new MyEventHandler();
		btSave.addActionListener(handler);
		btmypage.addActionListener(handler);
		btShopping.addActionListener(handler);
		btbookmark.addActionListener(handler);
		btlogout.addActionListener(handler);

		// 제목라벨 관련
		Lblogo = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\까페로고.jpg")); // 메뉴선택 라벨 생성
		Lbname = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\주문하기.jpg")); // 메뉴선택 라벨 생성
		Lbline = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); // 메뉴선택 라벨 생성
		Lbline2 = new JLabel(new ImageIcon("C:\\Users\\park\\git\\java\\multi_java\\Image\\선.png")); // 메뉴선택 라벨 생성

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

	/**
	 * 이벤트 핸들러 버튼 클릭과 같은 이벤트가 발생하면 이벤트 처리를 담당하는 클래스
	 * 
	 * @author 박상환
	 *
	 */
	class MyEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btSave) {
				PrintWriter printWriter = null; // 문자열을 파일에 저장하기 위해 printWriter를 사용
				{
					try {
						printWriter = new PrintWriter("C:\\Users\\park\\git\\java\\order_List.txt");// 파일 저장 경로를 지정

						if (printWriter.checkError() == false) // 파일 저장하는 도중에 에러가 발생하는지 체크, 에러가 발생하면 true 리턴
						{
							JOptionPane.showMessageDialog(null, "저장이 완료되었습니다 ! ", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							// 널 체크를 위한 명령어, printWriter가 null이라면 NullPointerException 발생
							for(String a : Sandwich.getOrderList())
							{
								Objects.requireNonNull(printWriter).println(a);
							}

							printWriter.close();
						}

						else
							JOptionPane.showMessageDialog(null, "저장 실패했습니다 ! ", "Error", JOptionPane.ERROR_MESSAGE);
					}

					catch (FileNotFoundException e1) // 문자열이 존재하지 않거나 파일을 만들 수 없거나 파일을 열거나 만드는 동안 다른 오류가 발생하면
					{
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

					catch (IOException e1) { // 입출력 예외 처리
						e1.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별로 에러를 출력
					}

					
				}
			} // if문 끝
			else if (obj == btlogout) {// 로그아웃하고 로그인화면으로 이동
				f.setVisible(false);
				new Gui01_Login();
			} else if (obj == btShopping) { // 메뉴선택으로 이동
				f.setVisible(false);
				new ShowMenu();
			} else if (obj == btbookmark) {// 나만의 메뉴로 이동
				f.setVisible(false);
				new BookMark();
			} else if (obj == btmypage) {// 마이페이지로 이동
				f.setVisible(false);
				new MP01_Main();
			}
		}// actionperformed 끝
	}// 핸들러 끝
}// 클래스 끝