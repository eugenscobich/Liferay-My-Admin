package com.scobich.liferaymyadmin.model.enums;

public enum Driver {
	MYSQL("com.mysql.jdbc.Driver", "jdbc:mysql://{0}:{1}/{2}", "3306"),
	POSTGRE_SQL("org.postgresql.Driver", "jdbc:postgresql://{0}:{1}/{2}", "5432"),
	HYPERSONIC("org.hsqldb.jdbcDriver", "jdbc:hsqldb:{0}", ""),
	;

	private String driverClassName;
	private String urlTemplate;
	private String defaultPort;

	Driver(String driverClassName, String urlTemplate, String defaultPort) {
		this.driverClassName = driverClassName;
		this.urlTemplate = urlTemplate;
		this.defaultPort = defaultPort;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public String getUrlTemplate() {
		return urlTemplate;
	}

	public String getDefaultPort() {
		return defaultPort;
	};
	

}
