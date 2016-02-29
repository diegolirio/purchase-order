package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.Telephone;
import com.diegolirio.purchaseorder.repositories.AddressRepositorie;
import com.diegolirio.purchaseorder.repositories.CustomerRepositorie;
import com.diegolirio.purchaseorder.repositories.TelephoneRepositorie;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepositorie customerRepositorie;
	@Autowired
	private AddressRepositorie addressRepositorie;
	@Autowired
	private TelephoneRepositorie telephoneRepositorie;

	/**
	 * Pode fazer a busca desativado ou ativado
	 * @param id
	 * @return
	 */
	public Customer get(long id) {
		return this.customerRepositorie.findOne(id);
	}

	public Customer getByCpfCnpj(String cpfcnpj) {
		return this.customerRepositorie.findByCpfCnpjAndActive(cpfcnpj, true);
	}

	/**
	 * TODO: 1. Cria novo, Desativa, e inserir enderecos e telefones...
	 * @param customer
	 * @return 
	 */
	public Customer save(Customer customer) {
		if(customer.getId() > 0) {
			Customer c = Customer.getNewInstance(customer);
			Customer customerSaved = this.customerRepositorie.save(c);
			
			// mantem lista de end
			List<Address> listAddress = this.addressRepositorie.findByPeopleAndActive(customer, true);
			for (Address address : listAddress) {
				Address a = Address.getNewInstance(address);
				a.setPeople(customerSaved);
				this.addressRepositorie.save(a);
			}
			
			List<Telephone> listPhone = this.telephoneRepositorie.findByPeopleAndActive(customer, true);
			for (Telephone telephone : listPhone) {
				Telephone t = Telephone.getNewInstance(telephone);
				t.setPeople(customerSaved);
				this.telephoneRepositorie.save(t);
			}
			
			this.delete(customer);
			return customerSaved;
		}
		return this.customerRepositorie.save(customer);
	}

	/**
	 * pega todos os ativos
	 * @return
	 */
	public Iterable<Customer> getAllActive() {
		return this.customerRepositorie.findByActive(true);
	}

	public List<Customer> findByCpfCnpjContainingOrNameContainingIgnoreCase(String cpfCnpj, String name) {
		return this.customerRepositorie.findByCpfCnpjOrName(cpfCnpj, name);
	}

	public List<Customer> findAdvanced(String fieldSearch) {
		return this.customerRepositorie.findAdvanced(fieldSearch, fieldSearch, fieldSearch, fieldSearch);
	}

	/**
	 * Delete address if using desactive
	 * @param id
	 */
	public void delete(long id) {
		try {
			customerRepositorie.delete(id);
		} catch(ConstraintViolationException|DataIntegrityViolationException cve) {
			
			Customer c = this.customerRepositorie.findOne(id);
			c.setActive(false);
			customerRepositorie.save(c);
			// desativa enderecos
			List<Address> listAddressDesac = this.addressRepositorie.findByPeopleAndActive(c, true);
			for (Address address : listAddressDesac) {
				address.setActive(false);
				this.addressRepositorie.save(address);
			}
			// desativa telephones
			List<Telephone> listPhoneDesac = this.telephoneRepositorie.findByPeopleAndActive(c, true);
			for (Telephone p : listPhoneDesac) {
				p.setActive(false);
				this.telephoneRepositorie.save(p);
			}			
			
		}	
	}

	public void delete(Customer customer) {
		this.delete(customer.getId());
	}
	
	
}
