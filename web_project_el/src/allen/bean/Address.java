/**
 * 
 */
package allen.bean;

/**
 * @author Allen
 * 
 *         Title: Address
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午9:35:04
 * 
 *       Email:1303542271 @qq.com
 */
public class Address {

	private String province;

	private String city;

	private String county;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * 
	 */
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String province, String city, String county) {
		super();
		this.province = province;
		this.city = city;
		this.county = county;
	}

	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + ", county="
				+ county + "]";
	}

}
