package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerNotFound;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemNotFoundException;
import com.masai.model.Address;
import com.masai.model.Customer;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.repository.AddressRepository;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService {
	
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepo customerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private AddressRepository addressRepository;


	@Override
	public FoodCart addNewFoodCart(Integer customerId, FoodCart foodCart) throws FoodCartException, CustomerNotFound {

		Optional<Customer> currentCustomer = customerRepository.findById(customerId);
		
		if(currentCustomer.isPresent()) {
			
			Customer customer = currentCustomer.get();
			
			foodCart.setCustomer(customer);
			
			FoodCart savedFoodCart = cartRepository.save(foodCart);
			
			return savedFoodCart;
		}
		else {
			throw new CustomerNotFound("This customer does not exist....... Please make account first");
		}

	}
	
	

	@Override
	public FoodCart addItemToCart(Integer foodCartId, Integer itemId) throws FoodCartException {
		
		
//		List<FoodCart> cartList = cartRepository.findAll();
		
		FoodCart currentCart = cartRepository.findById(foodCartId).orElseThrow(() -> new FoodCartException("This cart is Not Found..... Please make one first through Customer"));
		
//		FoodCart currentCart = cartOptional.get();
		
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException("This Item is not present int Data...."));
			
		if(currentCart.getItems().contains(item)) throw new FoodCartException("This Item is already in cart (if want then increse quantity)....");
			
		currentCart.getItems().add(item);
			
		FoodCart updatedCart = cartRepository.save(currentCart);
			
		return updatedCart;
			
	}

	
	@Override
	public FoodCart increaseQuantityOfItem(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException {

		if(foodCart.getItems().contains(item)) {
			
			for(Item listItem : foodCart.getItems()) {
				
				if(listItem.equals(item)) {
					
					listItem.setQuantity(listItem.getQuantity()+quantity);
					
					break;
				}
				
			}
			
			FoodCart updatedCart = cartRepository.save(foodCart);
			
			return updatedCart;
		}
		else {
			throw new FoodCartException("No such Item in cart, please add it first.....");
		}

	}

	
	@Override
	public FoodCart reduceQuantityOfItem(FoodCart foodCart, Item item, Integer quantity) throws FoodCartException {
		
		if(foodCart.getItems().contains(item)) {
			
			for(Item listItem : foodCart.getItems()) {
				
				if(listItem.equals(item)) {
					
					if(listItem.getQuantity()<quantity) {
						throw new FoodCartException("Not enough quantity to remove.....");
					}
					
					listItem.setQuantity(listItem.getQuantity()-quantity);
					
					// if item quantity = 0 , then remove it 
					
					if(listItem.getQuantity()==0) {
						foodCart.getItems().remove(listItem);
					}
					
					if(foodCart.getItems().size()==0) {
						cartRepository.delete(foodCart);
						
						System.out.println("FoodCart Deleted.....");
						
					}
					
					break;
				}
				
			}
			
			FoodCart updatedCart = cartRepository.save(foodCart);
			
			return updatedCart;
		}
		else {
			throw new FoodCartException("No such Item in cart, please add it first.....");
		}
		
	}

	
	@Override
	public FoodCart removeItemFromCart(Integer foodCartId, Item item) throws FoodCartException {
		
		FoodCart foodCart = cartRepository.findById(foodCartId).orElseThrow(() -> new FoodCartException("No such food cart found....."));		
		
		if(foodCart.getItems().contains(item)) {
			
			foodCart.getItems().remove(item);

			FoodCart updatedCart = cartRepository.save(foodCart);
			
			return updatedCart;
			
		}
		else {
			throw new FoodCartException("No such item exist in Cart......");
		}
		
	}

	
	@Override
	public FoodCart clearCart(Integer foodCartId) throws FoodCartException {
		
		FoodCart foodCart = cartRepository.findById(foodCartId).orElseThrow(() -> new FoodCartException("This cart doesn't exist.....Please add new cart through Customer"));
		
		FoodCart deletedFoodCart = foodCart;
		
		foodCart.getItems().clear();
		
		Customer customer = customerRepository.findById(foodCart.getCustomer().getCustomerId()).orElseThrow(() -> new FoodCartException("This Customer has no foodCart........"));
		
		Integer addressId = customer.getAddress().getAddressId();
		
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new FoodCartException("This Address of Customer does not exist....."));
		
		addressRepository.delete(address);
		
		cartRepository.delete(foodCart);
		
		customerRepository.delete(customer);

		
	 	return deletedFoodCart;
	}


}
