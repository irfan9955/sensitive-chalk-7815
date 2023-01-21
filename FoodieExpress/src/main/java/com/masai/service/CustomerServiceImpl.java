package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerNotFound;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;



@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo CR;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFound {
    
       if(customer!=null) {
    	   
    	   Customer cus =CR.save(customer);
    	   
    	   return cus;
       }
       else
    	   throw new CustomerNotFound("customer detail should not be null");
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFound {
		
      Optional<Customer> opt=CR.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			Customer updatedCustomer= CR.save(customer);
			
			return updatedCustomer;
			
		}else
			throw new CustomerNotFound("Invalid Customer detils..."); 
		
	}

	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerNotFound {
		
		Optional<Customer> opt=CR.findById(customerId);
	      
	      if(opt.isPresent()) {
	    	  
	    	  Customer deletedCustomer=opt.get();
	    	  
	    	  CR.delete(deletedCustomer);
	    	  
	    	  return deletedCustomer;
	      }
	      else {
	    	  throw new CustomerNotFound("Customer not found with this Id"+customerId);
	      }
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerNotFound {
		
		 Optional<Customer> opt=CR.findById(customerId);
         
			if(opt.isPresent()) {
				Customer customer=opt.get();
				return customer;
			}
			else {
				throw new CustomerNotFound("Customer not found with this Id: "+customerId);
				
			}
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerNotFound {
		
		List<Customer> cList = CR.findAll();

		if(cList.isEmpty()){
			throw new CustomerNotFound("There is no Customer present in the database");
		}

		return cList;
	}
	
	
}
