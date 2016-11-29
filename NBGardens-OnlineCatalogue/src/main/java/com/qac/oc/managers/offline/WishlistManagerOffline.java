package com.qac.oc.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.oc.entities.Customer;
import com.qac.oc.entities.Stock;
import com.qac.oc.managers.WishlistManager;
import com.qac.oc.util.TestData;

/**
 * This implementation is to be used while there is no datastore to pull data from
 * 
 * @author James Thompson
 *
 */
@Stateless
@Default
public class WishlistManagerOffline implements WishlistManager {
	@Inject
	private TestData testData;
	
	@Override
	public List<Stock> findByCustomerId(long id) {
		for(Customer customer : testData.getCustomers())
			if(customer.getId() == id)
				return customer.getWishlist();
		return null;
	}

	@Override
	public void updateWishList(long customerId, List<Stock> wishlist) {
		List<Customer> customers = testData.getCustomers();
		for(Customer customer : customers)
			if(customer.getId() == customerId)
				customer.setWishlist(wishlist);
		testData.setCustomers(customers);
	}
}
