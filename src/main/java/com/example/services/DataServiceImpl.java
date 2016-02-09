package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.Datadao;
import com.example.model.Employee;

@Service
public class DataServiceImpl implements DataService{

@Autowired
Datadao Datadd;
	
	public int insertRow(Employee employee) {
		return Datadd.insertRow(employee);
	}

	public List<Employee> getList() {
		return Datadd.getList();
	}

	public Employee getRowById(int id) {
		return Datadd.getRowById(id);
	}

	public int updateRow(Employee employee) {
		return Datadd.updateRow(employee);
	}

	public int deleteRow(int id) {
		return Datadd.deleteRow(id);  
	}
	
}
