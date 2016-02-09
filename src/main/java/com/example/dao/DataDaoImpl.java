package com.example.dao;
import java.io.Serializable;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Employee;

@Repository
public class DataDaoImpl implements Datadao {

 @Autowired
private SessionFactory sessionFactory;

 @Transactional
public int insertRow(Employee employee) {
	Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(employee);
	  tx.commit();
	  Serializable id = session.getIdentifier(employee);
	  session.close();
	  return (Integer) id;
}

 public List<Employee> getList() {
  Session session = sessionFactory.openSession();
  @SuppressWarnings("unchecked")
  List<Employee> employeeList = session.createQuery("from Employee")
    .list();
  session.close();
  return employeeList;
 }


 public int deleteRow(int id) {
  Session session = sessionFactory.openSession();
  Transaction tx = session.beginTransaction();
  Employee employee = (Employee) session.load(Employee.class, id);
  session.delete(employee);
  tx.commit();
  Serializable ids = session.getIdentifier(employee);
  session.close();
  return (Integer) ids;
 }

public Employee getRowById(int id) {
	Session session = sessionFactory.openSession();
	  Employee employee = (Employee) session.load(Employee.class, id);
	  return employee;
}

public int updateRow(Employee employee) {
	Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(employee);
	  tx.commit();
	  Serializable id = session.getIdentifier(employee);
	  session.close();
	  return (Integer) id;
}

}