package stack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ITEM_TAB")
public class Item {
	@Id
	@Column(name = "ITEM_ID")
	private Integer id;
	@Column(name ="ITEM_NAME",nullable = true)
	private String itemName;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "PRICE")
	private float price ;
	public Item() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
