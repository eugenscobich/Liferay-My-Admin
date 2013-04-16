package com.scobich.liferaymyadmin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Schema implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<Table> tables = new ArrayList<Table>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

}
