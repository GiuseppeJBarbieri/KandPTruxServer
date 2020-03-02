package models;

import java.io.Serializable;

public class Server_To_Client_Message_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4027093718161670847L;
	/*
	 * for info or error integer,
	 * 0 = No Error
	 * 1 = Error
	 */
	private int infoOrError;
	private String title;
	private String header;
	private String content;

	public Server_To_Client_Message_Model(int infoOrError, String title, String header, String content) {
		super();
		this.infoOrError = infoOrError;
		this.title = title;
		this.header = header;
		this.content = content;
	}

	public int getInfoOrError() {
		return infoOrError;
	}

	public void setInfoOrError(int infoOrError) {
		this.infoOrError = infoOrError;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
