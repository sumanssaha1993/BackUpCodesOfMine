package com.TestProgs;

import java.sql.Timestamp;
import java.util.Date;

import com.annotations.table;

@table(name="dmoc_sales_order_hdr")
public class SalesOrder {
	
	private Integer p_so_id;
	
	private Integer customer_id;
	
	private String status;
	
	private Double r_gross_amt;
	
	private Double r_tax_amt;
	
	private Double r_net_amt;
	
	private Timestamp order_date;
	
	private Integer address_id;
	
	private String delv_status;
	

	public Integer getP_so_id() {
		return p_so_id;
	}

	public void setP_so_id(Integer p_so_id) {
		this.p_so_id = p_so_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getR_gross_amt() {
		return r_gross_amt;
	}

	public void setR_gross_amt(Double r_gross_amt) {
		this.r_gross_amt = r_gross_amt;
	}

	public Double getR_tax_amt() {
		return r_tax_amt;
	}

	public void setR_tax_amt(Double r_tax_amt) {
		this.r_tax_amt = r_tax_amt;
	}

	public Double getR_net_amt() {
		return r_net_amt;
	}

	public void setR_net_amt(Double r_net_amt) {
		this.r_net_amt = r_net_amt;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getDelv_status() {
		return delv_status;
	}

	public void setDelv_status(String delv_status) {
		this.delv_status = delv_status;
	}

	@Override
	public String toString() {
		return "SalesOrderDTO [p_so_id=" + p_so_id + ", customer_id=" + customer_id + ", status=" + status
				+ ", r_gross_amt=" + r_gross_amt + ", r_tax_amt=" + r_tax_amt + ", r_net_amt=" + r_net_amt
				+ ", order_date=" + order_date + ", address_id=" + address_id + ", delv_status=" + delv_status + "]";
	}
}
