package subway;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Order extends JFrame
{
	JFrame f = new JFrame();
	JTextArea ta;
	JButton btMain,btSave;
	JScrollPane scrollPane;
	
	/**ArrayList를 문자열로 가져오는 과정에서 생기는 불필요한 문자들을 제거*/
	String orderList = ShowMainPage.getOrderList().toString().replace("[","").replace("]", "").replaceAll(",", "");
	
	int count = 1;
	int total_price = 0;
	public Order()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		btMain = new JButton("메인페이지");
		btSave = new JButton("저장");
		ta=new JTextArea();
		scrollPane = new JScrollPane();
        scrollPane.getViewport().add(ta);
		
        
		btMain.setBounds(330, 30, 100, 50);
		btSave.setBounds(330, 150, 100, 50);
		scrollPane.setBounds(10, 30, 200, 300);
		
		
		
		ta.append(orderList+"총 결제 금액 : "+ShowMainPage.getTotal_price());/**TextArea에 출력할 내용 저장*/
		count++;
		
		
		f.getContentPane().add(btMain);
		f.getContentPane().add(btSave);
		f.getContentPane().add(scrollPane);
	    ta.setEditable(false);						/**Textarea에 값 입력 못하게 설정*/
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btMain.addActionListener(handler);
		btSave.addActionListener(handler);
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
		            Objects.requireNonNull(printWriter).println(orderList);
		            printWriter.close();
		        }
			}
		}
	}
}