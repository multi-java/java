package subway;

import java.util.ArrayList;

public class test {
	static ArrayList<String> order = new ArrayList<String>();
	public static void main(String[] args) {
	
	}
	
	public void OrderAdd(){ //상환씨한테받은 주문내역 a에 넣기
		
		//order.add("하이");
		System.out.println(order.get(0));
		
	
	
	
		if (order.size()<5){ 		//4개이하면 받고, 4개이상이면 에러창띄어주기
			//order.add();
		}

		else if (order.size()>4){
			System.out.println("즐겨찾기는 4개까지만 저장할 수 있습니다"); //에러창띄어주기

		}
	}

}