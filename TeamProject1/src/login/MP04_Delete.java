//다시 작성
package login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MP04_Delete {

}
class ShowDMember extends JFrame{
	JFrame f = new JFrame();
	JButton btBefore,btDel;
	JLabel w1,w2,w3,w4;
	
	public ShowDMember() {
		f.setSize(500,700);
		f.setLocale(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.getContentPane().setBackground(Color.white);
		
		btBefore = new JButton("이전");
		btBefore.setBounds(10, 30, 100, 50);
		
		btDel = new JButton("회원 탈퇴");
		btDel.setBounds(150, 500, 200, 50);
		btDel.setBackground(Color.red);
		btDel.setForeground(Color.white);
		
		w1= new JLabel("마스꺼 버거 회원탈퇴 시 ");
		w1.setBounds(75, 140, 350, 50);
		w1.setFont(new Font("sans-serif",Font.BOLD,16));
		w2= new JLabel("회원정보 및 서비스 이용기록은 모두 삭제되며");
		w2.setBounds(75, 210, 350, 50);
		w2.setFont(new Font("sans-serif",Font.BOLD,16));
		w3= new JLabel("삭제된 데이터는 복구가 불가능합니다.");
		w3.setBounds(75, 280, 350, 50);
		w3.setFont(new Font("sans-serif",Font.BOLD,16));
		w4= new JLabel("그동안 마스꺼 버거를 이용해주셔서 감사합니다.");
		w4.setBounds(75, 350, 350, 50);
		w4.setFont(new Font("sans-serif",Font.BOLD,16));

		
		f.getContentPane().add(btBefore);
		f.getContentPane().add(w1);
		f.getContentPane().add(w2);
		f.getContentPane().add(w3);
		f.getContentPane().add(w4);
		f.getContentPane().add(btDel);
		f.setVisible(true);
		
		MyEventHandler handler = new MyEventHandler();
		btBefore.addActionListener(handler);
	}
	class MyEventHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==btBefore)
			{
				new MP01_Main();	
				f.setVisible(false);
			}
		}
	}
	
}
