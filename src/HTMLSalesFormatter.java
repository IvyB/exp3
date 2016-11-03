

public class HTMLSalesFormatter implements SalesFormatter{
	
	private static HTMLSalesFormatter singletonInstance;
	
	static public HTMLSalesFormatter getSingletonInstance(){
		if (singletonInstance==null) {
			singletonInstance=new HTMLSalesFormatter();
		}
		return singletonInstance;
	}
	
	private HTMLSalesFormatter(){
		
	}
	@Override
	public String formatSales(Sales sales) {
		Product tempProduct;
		String list_head=" ";
		String list_bodyHeader="";
		String list_tail="";
		String list="";
		list_head+="<html>\n";
		list_head+="<body>\n";
		list_head+="   "+"<center><h2>Orders</h2></center>\n";
		for (Order order : sales) {
			double totalCost=0;
			String list_body="";
			for (OrderItem orderItem : order) {
				tempProduct=orderItem.getProduct();
				list_body+="<p>\n"+"  <b>code:</b> "+tempProduct.getCode()+"<br>\n";
				list_body+="  <b>quantity:</b> "+orderItem.getQuantity()+"<br>\n";
				list_body+="  <b>price:</b> "+tempProduct.getPrice()+"<br>\n<p>\n";
				totalCost+=orderItem.getValue();
			}
			list_bodyHeader+="<hr>\n";
			list_bodyHeader+="<h4>Total = "+totalCost+"</h4>\n";
			list_bodyHeader+=list_body;
		}
		list_tail+="  </body>\n"+"</html>";
		list=list_head+list_bodyHeader+list_tail;
		return list;
	}

}
