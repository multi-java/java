package subway;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Order extends JFrame
{
	JFrame f = new JFrame();
	JTextArea ta;
	JButton btMain;
	JScrollPane scrollPane;
	int count = 1;
	int total_price = 0;
	public Order()
	{
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		btMain = new JButton("메인페이지");
		ta=new JTextArea();
		scrollPane = new JScrollPane();
        scrollPane.getViewport().add(ta);
		
        
		btMain.setBounds(330, 30, 100, 50);
		scrollPane.setBounds(10, 30, 200, 300);
		
		
		
		ta.append(ShowMainPage.getOrderList().toString().replace("[","").replace("]", "").replaceAll(",", "")+
				"총 결제 금액 : "+ShowMainPage.getTotal_price());
		System.out.println(ShowMainPage.getOrderList().toString().replace("[","").replace("]", "").replace(",", ""));
		//orderList.add(ta.getText());
		//System.out.println(orderList.size());
		//o[count] = ta.getText();
		count++;
		
		
		f.getContentPane().add(btMain);
		f.getContentPane().add(scrollPane);
	    ta.setEditable(false);						/**Textarea에 값 입력 못하게 설정*/
		f.setVisible(true);
		
		
		MyEventHandler handler = new MyEventHandler();
		btMain.addActionListener(handler);
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
		}
	}
}