
/*
 * ����ģʽ����ֻ�ṩ˽�еĹ��캯��
 * �ඨ���к���һ������ľ�̬˽�ж���
 * �����ṩ��һ����̬�Ĺ��еĺ������ڴ������ȡ������ľ�̬˽�ж���
 */

public class XMLSalesFormatter implements SalesFormatter{
	
	private static XMLSalesFormatter singletonInstance;
	
	private XMLSalesFormatter() {
	}
	
	static public XMLSalesFormatter getSingletonInstance(){
		if (singletonInstance==null) {
			singletonInstance=new XMLSalesFormatter();
		}
		return singletonInstance;
	}
	@Override
	public String formatSales(Sales sales) {
		String head="<Sales>\n";
		String list="";
		String body2="";
		String body_head="";
		Product tempProduct;
		for (Order order : sales) {
			String body1="";
			double totalCost=0;
			for (OrderItem orderItem : order) {
				tempProduct=orderItem.getProduct();
				body1+="  <OrderItem quantity=\""+orderItem.getQuantity()+"\"";
				body1+="price=\""+tempProduct.getPrice()+"\">"+tempProduct.getCode()+"</OrderItem>\n";
				totalCost+=orderItem.getValue();
			}
			body_head+=" <Order total=\""+totalCost+"\">\n";
			body_head+=body1;
			body_head+=" </Order>\n";
		}
		body2+="</Sales>";
		list+=head+body_head+body2;
		return list;
	}

}
