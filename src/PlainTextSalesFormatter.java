

public class PlainTextSalesFormatter implements SalesFormatter{
	
	private static PlainTextSalesFormatter singletonInstance;
	
	static public PlainTextSalesFormatter getSingletonInstance(){
		if (singletonInstance==null) {
			singletonInstance=new PlainTextSalesFormatter();
		}
		return singletonInstance;
	}
	
	private PlainTextSalesFormatter(){
		
	}
	
	@Override
	public String formatSales(Sales sales) {
		int number=1;
		String list="";
		Product tempProduct;
		for (Order order : sales) {
			double totalCost=0;
			list+="------------------------\n";
			list+="Order "+number+"\n\n";			for (OrderItem orderItem : order) {
				tempProduct=orderItem.getProduct();
				//System.out.println(orderItem.getQuantity()+" "+tempProduct.getCode()+" "+tempProduct.getPrice());
				list+=orderItem.getQuantity()+" "+tempProduct.getCode()+" "+tempProduct.getPrice()+"\n";
				totalCost+=orderItem.getValue();
			}
			number++;
			list+="Total = "+totalCost+"\n";
		}
		return list;
	}

}
