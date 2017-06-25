package com.itheima.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {
	private static SessionFactory factory = null;

	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
	}

	// 提供对外访问的方式
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void main(String[] args) {
		
	}

}
