package com.tiner.dao.model;

import java.io.Serializable;
import java.util.Date;

public class TblGoodsModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String customerName;
	private String productCategory;
	private int quantity;
	private double jpyPrice;
	private double cnyPrice;
	private double rate;
	private double cnyDealPrice;
	private double productProfit;
	private String status;
	private Date sendDate;
	private String remark;
	private Date updated;
	private Date created;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the jpyPrice
	 */
	public double getJpyPrice() {
		return jpyPrice;
	}
	/**
	 * @param jpyPrice the jpyPrice to set
	 */
	public void setJpyPrice(double jpyPrice) {
		this.jpyPrice = jpyPrice;
	}
	/**
	 * @return the cnyPrice
	 */
	public double getCnyPrice() {
		return cnyPrice;
	}
	/**
	 * @param cnyPrice the cnyPrice to set
	 */
	public void setCnyPrice(double cnyPrice) {
		this.cnyPrice = cnyPrice;
	}
	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	/**
	 * @return the cnyDealPrice
	 */
	public double getCnyDealPrice() {
		return cnyDealPrice;
	}
	/**
	 * @param cnyDealPrice the cnyDealPrice to set
	 */
	public void setCnyDealPrice(double cnyDealPrice) {
		this.cnyDealPrice = cnyDealPrice;
	}
	/**
	 * @return the productProfit
	 */
	public double getProductProfit() {
		return productProfit;
	}
	/**
	 * @param productProfit the productProfit to set
	 */
	public void setProductProfit(double productProfit) {
		this.productProfit = productProfit;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the sendDate
	 */
	public Date getSendDate() {
		return sendDate;
	}
	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
