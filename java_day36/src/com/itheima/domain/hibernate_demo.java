package com.itheima.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.utils.hibernateUtils;

public class hibernate_demo {
	// 添加操作
	@Test
	public void addUser() {

		SessionFactory factory = hibernateUtils.getSessionFactory();
		// 获取session
		Session session = factory.openSession();
		// 开启事务
		/*Transaction ts = session.beginTransaction();*/
		/*ts.begin();*/
		try {
			
			for (int i = 0; i <10; i++) {
				User user = new User();
				user.setUsername("屈永旺");
				user.setPassword("1234");
				user.setAddress("北京");
				session.save(user);
				System.out.println(user.getUid());
			}
			/*User user = new User();
			user.setUsername("屈永旺");
			user.setPassword("1234");
			user.setAddress("北京");
			user.setScore(100);
			// user.setUid(3);
			System.out.println(user.getUid());*/
			
			
			/*System.out.println(user.getUid());
			session.save(user);
			System.out.println(user.getUid());*/
		} catch (Exception ex) {
			/*ts.rollback();*/
			ex.printStackTrace();
		} finally {
			/*ts.commit();*/
			session.close();
			factory.close();
		}
	}

	// 根据id进行查询
	@Test
	public void getUser() {
		SessionFactory factory = hibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		// 开启事务
		Transaction ts = session.beginTransaction();
		try {

			User user = session.get(User.class, 8);
			System.out.println(user);

		} catch (Exception ex) {
			ts.rollback();
			ex.printStackTrace();
		} finally {
			ts.commit();
			session.close();
			factory.close();
		}

	}

	// 进行修改
	@Test
	public void changetUser() {
		SessionFactory factory = hibernateUtils.getSessionFactory();
		// 获得session
		Session session = factory.openSession();

		// 开启事务
		Transaction ts = session.beginTransaction();
		try {
			//进行修改
			//先进行查询
			User user=session.get(User.class, 5);
			user.setScore(95);
			session.update(user);
			

		} catch (Exception ex) {
			ts.rollback();
			ex.printStackTrace();

		} finally {
			ts.commit();
			session.close();
			factory.close();
		}
	}
	
	//进行删除
	@Test
	public void delUser() {
		SessionFactory factory=hibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			
			User user=session.get(User.class, 5);
			session.delete(user);
			
		}catch(Exception ex){
			ts.rollback();
			ex.printStackTrace();
		}finally {
			ts.commit();
			session.close();
			factory.close();
		}
	}
	
	

}
