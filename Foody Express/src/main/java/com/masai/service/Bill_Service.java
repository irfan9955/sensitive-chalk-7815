package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.BillException;
import com.masai.model.Bill;

public interface Bill_Service {
	
	public Bill addBill(Integer orderId, String uniqueId) throws BillException;

	public Bill removeBill(Bill bill) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill viewBill(Bill bill) throws BillException;

	public List<Bill> viewBills(Integer custId) throws BillException;

	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException;

	public double calculateTotalCost(Bill bill) throws BillException;

}
