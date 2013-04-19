package com.scobich.liferaymyadmin.web.util;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.scobich.liferaymyadmin.util.Constants;

public class WebUtil {

	public static void addMessage(PortletRequest request, String message) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getPortletSession().getAttribute(Constants.MESSAGES);
		if (messages == null) {
			messages = new ArrayList<String>();
			request.getPortletSession().setAttribute(Constants.MESSAGES, messages);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String currentTime = sdf.format(new Date());
		messages.add(currentTime + " - " + message);
		request.getPortletSession().setAttribute(Constants.MESSAGES, messages);
		request.setAttribute(Constants.MESSAGES, messages);
		
	}

	public static void setConnection(PortletRequest request, Connection connection) {
		request.getPortletSession().setAttribute(Constants.CONNECTION, connection);
	}

	public static Connection getConnection(PortletRequest request) {
		return (Connection)request.getPortletSession().getAttribute(Constants.CONNECTION);
	}

	
}
