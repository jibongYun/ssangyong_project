package data;

public class UsedPC {

	private String usedPoint;
	public String usedCoupon;
	
	public UsedPC(String usedPoint, String usedCoupon) {
		super();
		this.usedPoint = usedPoint;
		this.usedCoupon = usedCoupon;
	}
	
	public String getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(String usedPoint) {
		this.usedPoint = usedPoint;
	}
	public String getUsedCoupon() {
		return usedCoupon;
	}
	public void setUsedCoupon(String usedCoupon) {
		this.usedCoupon = usedCoupon;
	}
	

}