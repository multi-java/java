package subway;

import java.util.ArrayList;

abstract public class Sandwich {
	abstract public String choice(String menu);
	static int total=0;
	private static ArrayList<String>  orderList = new ArrayList<String>(4);/**주문한 내역을 저장하기 위한 ArrayList*/
	private static ArrayList<Integer> total_price = new ArrayList<Integer>(4);/**주문한 메뉴의 가격을 모두 합산한 가격*/
	public static ArrayList<Integer> getTotal_price() {
		return total_price;
	}
	public static void setTotal_price(int total_price) {
		Sandwich.total_price.add(total_price);/**메뉴의 가격을 합산한다.*/
	}
	public static ArrayList<String> getOrderList() {
		return orderList;
	}
	public static void setOrderList(String orderList) {
		Sandwich.orderList.add(orderList);	/**add 메소드를 통해 ArrayList에 값을 저장*/
	}
	public static int total_price_m()
	{
		total=0;
		for(int a : Sandwich.getTotal_price())
		{
			total+=a;
		}
		return total;
	}
}
