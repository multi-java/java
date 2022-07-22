package subway;
import javax.swing.*;
import java.awt.event.*;

public class Order extends JFrame
{
	JPanel p = new JPanel();
	JTextArea ta;
	String o[] = new String[30];
	int count = 0;
	int total_price = 0;
	public Order()
	{
		Sandwich bt = new Bread();
		Sandwich et = new Egg();
		add(p,"Center");
		p.add(ta=new JTextArea(),"Center");
		total_price = Menu.getPrice()+Egg.getTopping_price();
		ta.append("선택한 메뉴 : "+Menu.getMenu()+
		"\n메뉴 가격 : "+Menu.getPrice()+
		"\n빵 : "+Bread.getMenu()+
		"\n토핑 : "+Egg.getMenu()+
		"\n토핑 가격 : "+Egg.getTopping_price()+
		"\n쨈 가격 : "+Jam.getMenu()+
		"\n총 가격 : "+total_price);
		o[count] = ta.getText();
		count++;
		setSize(500,700);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}