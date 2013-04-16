package com.scobich.liferaymyadmin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<Schema> schemas = new ArrayList<Schema>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schema> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<Schema> schemas) {
		this.schemas = schemas;
	}

}
