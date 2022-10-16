package com.LAGarden.Model;

import java.io.Serializable;

public class CartItem implements Serializable{
	public CTMonAn getCtMA() {
		return ctMA;
	}
	public void setCtMA(CTMonAn ctMA) {
		this.ctMA = ctMA;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CTMonAn ctMA;
    public int quantity ;
}
