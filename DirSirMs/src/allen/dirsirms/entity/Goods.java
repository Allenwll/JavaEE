package allen.dirsirms.entity;

import java.util.Date;

/***
 * Title: Goods 
 *  
 * Description:
 *    
 *      商品
 *	
 * Company: 个人
 * 
 * @author Allen Wang
 *
 * @email:1303542271@qq.com
 *
 * @date  2016年10月8日  下午5:39:06
 *
 */
public class Goods {
	
	//商品编号
	private int id;
	
	//商品类型ID
	private int typeId;
	
	//商品名称
	private String goodsName;
	
	//出产地
	private String introduce;
	
	//原价
	private double price;
	
	//现价
	private double nowPrice;
	
	//商品图片
	private String plcturn;
	
	//上货时间
	private Date inTime;
	
	//新商品
	private int newGoods;
	
	//是否出售中
	private int sale;
	
	//是否热售
	private int hit;

	@Override
	public String toString() {
		return "Goods [id=" + id + ", typeId=" + typeId + ", goodsName="
				+ goodsName + ", introduce=" + introduce + ", price=" + price
				+ ", nowPrice=" + nowPrice + ", plcturn=" + plcturn
				+ ", inTime=" + inTime + ", newGoods=" + newGoods + ", sale="
				+ sale + ", hit=" + hit + "]";
	}
		
	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Goods(int id, int typeId, String goodsName, String introduce,
			double price, double nowPrice, String plcturn, Date inTime,
			int newGoods, int sale, int hit) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.goodsName = goodsName;
		this.introduce = introduce;
		this.price = price;
		this.nowPrice = nowPrice;
		this.plcturn = plcturn;
		this.inTime = inTime;
		this.newGoods = newGoods;
		this.sale = sale;
		this.hit = hit;
	}

	public Goods(int typeId, String goodsName, String introduce, double price,
			double nowPrice, String plcturn, Date inTime, int newGoods,
			int sale, int hit) {
		super();
		this.typeId = typeId;
		this.goodsName = goodsName;
		this.introduce = introduce;
		this.price = price;
		this.nowPrice = nowPrice;
		this.plcturn = plcturn;
		this.inTime = inTime;
		this.newGoods = newGoods;
		this.sale = sale;
		this.hit = hit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + hit;
		result = prime * result + id;
		result = prime * result + ((inTime == null) ? 0 : inTime.hashCode());
		result = prime * result
				+ ((introduce == null) ? 0 : introduce.hashCode());
		result = prime * result + newGoods;
		long temp;
		temp = Double.doubleToLongBits(nowPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((plcturn == null) ? 0 : plcturn.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sale;
		result = prime * result + typeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (hit != other.hit)
			return false;
		if (id != other.id)
			return false;
		if (inTime == null) {
			if (other.inTime != null)
				return false;
		} else if (!inTime.equals(other.inTime))
			return false;
		if (introduce == null) {
			if (other.introduce != null)
				return false;
		} else if (!introduce.equals(other.introduce))
			return false;
		if (newGoods != other.newGoods)
			return false;
		if (Double.doubleToLongBits(nowPrice) != Double
				.doubleToLongBits(other.nowPrice))
			return false;
		if (plcturn == null) {
			if (other.plcturn != null)
				return false;
		} else if (!plcturn.equals(other.plcturn))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (sale != other.sale)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getPlcturn() {
		return plcturn;
	}

	public void setPlcturn(String plcturn) {
		this.plcturn = plcturn;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public int getNewGoods() {
		return newGoods;
	}

	public void setNewGoods(int newGoods) {
		this.newGoods = newGoods;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
