package com.masai.service;

import java.time.LocalDate;
import java.util.List;


import com.masai.exception.BillException;
import com.masai.model.Bill;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill removeBill(Integer bid) throws BillException;

	public Bill viewBill(Integer bid) throws BillException;

	public List<Bill> viewAllBills(String startDate, String endDate) throws BillException;
	
	public Double CalculateTotalCost(Integer id)throws BillException;

}
