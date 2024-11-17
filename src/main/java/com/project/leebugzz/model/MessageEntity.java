package com.project.leebugzz.model;

import java.sql.Date;

public class MessageEntity {

	private int messageId;

	private int ticketId;

	private String authorName;
	
	private String recepientName;
	
	private String text;

	private Date createDate;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;

	}

	public MessageEntity() {
		super();
// TODO Auto-generated constructor stub
	}

	public MessageEntity(int messageId, int ticketId, String authorName, String recepientName, String text,
			Date createDate) {
		super();
		this.messageId = messageId;
		this.ticketId = ticketId;
		this.authorName = authorName;
		this.recepientName = recepientName;
		this.text = text;
		this.createDate = createDate;
	}

}