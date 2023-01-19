package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.BillException;
import com.masai.model.Bill;

public class BillServiceImpl implements Bill_Service{

	@Override
	public Bill addBill(Integer orderId, String uniqueId) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill removeBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill viewBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(Integer custId) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalCost(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
