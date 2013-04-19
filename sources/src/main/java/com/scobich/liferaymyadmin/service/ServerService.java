package com.scobich.liferaymyadmin.service;

import java.sql.Connection;
import java.text.MessageFormat;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.scobich.liferaymyadmin.model.enums.Driver;

@Service
public class ServerService {
	
	private static final Logger LOG = Logger.getLogger(ServerService.class);

	public Connection getConnection(Driver driver, String username, String password, String host, String port, String database) throws Exception {
		LOG.info("Attempt to connect to host: " + host);
		if (driver != Driver.LIFERAY) {
			String url = MessageFormat.format(driver.getUrlTemplate(), host, port, database);
			Properties properties = new Properties();
			properties.setProperty(PropsKeys.JDBC_DEFAULT_DRIVER_CLASS_NAME, driver.getDriverClassName());
			properties.setProperty(PropsKeys.JDBC_DEFAULT_USERNAME, username);
			properties.setProperty(PropsKeys.JDBC_DEFAULT_PASSWORD, password);
			properties.setProperty(PropsKeys.JDBC_DEFAULT_URL, url);
			
			DataSource dataSource = DataSourceFactoryUtil.initDataSource(properties);
			Connection con = dataSource.getConnection();
			return con;
		} else {
			return InfrastructureUtil.getDataSource().getConnection();
		}
	}
}
