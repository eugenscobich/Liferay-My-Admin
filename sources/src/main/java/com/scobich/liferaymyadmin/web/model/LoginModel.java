package com.scobich.liferaymyadmin.web.model;

import java.io.Serializable;

import com.scobich.liferaymyadmin.model.enums.Driver;


public class LoginModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Driver driver;
	private String username;
	private String password;
	private String host;
	private String port;
	private String database;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
