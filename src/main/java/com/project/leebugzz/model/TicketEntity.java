package com.project.leebugzz.model;

import java.sql.Date;

public class TicketEntity {

	private int ticketId;

	private String title;

	private String createrName;

	private String holderName;

	private Date createDate;

	private String status;

	public TicketEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketEntity(int ticketId, String title, String createrName, String holderName, Date createDate,
			String status) {
		super();
		this.ticketId = ticketId;
		this.title = title;
		this.createrName = createrName;
		this.holderName = holderName;
		this.createDate = createDate;
		this.status = status;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterId(String createrName) {
		this.createrName = createrName;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
