package com.ait.otom.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ait.otom.entities.CustomerEntity;
import com.ait.otom.entities.OrderEntity;
import com.ait.otom.repositories.CustomerEntityRepository;

@Component
public class MyRunner implements ApplicationRunner {

	@Autowired
	CustomerEntityRepository customerRepo;

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		 * persist a customer with orders
		 */
		/*
		 * CustomerEntity customer = new CustomerEntity(101, "Patrik",
		 * "patrik@gmail.com", null); OrderEntity order1 = new OrderEntity(9010211,
		 * LocalDate.of(2022, 8, 24), "Dispatched"); OrderEntity order2 = new
		 * OrderEntity(2876101, LocalDate.of(2022, 8, 22), "Delivered"); OrderEntity
		 * order3 = new OrderEntity(6934417, LocalDate.of(2022, 8, 26), "Pending");
		 * List<OrderEntity> lstOrders = new ArrayList<>(); lstOrders.add(order1);
		 * lstOrders.add(order2); lstOrders.add(order3);
		 * customer.setLstOfOrdersOfCustomer(lstOrders); customerRepo.save(customer);
		 */

		/*
		 * associate a customer with one more order It is possible by adding the new
		 * order to the collection associated with a customer The process is, 1. load
		 * the customer 2. retrieve the associated collection 3. add new order to that
		 * collection
		 */
		/*
		 * Optional<CustomerEntity> opt = customerRepo.findById(101);
		 * if(opt.isPresent()) { CustomerEntity customerEntity = opt.get();
		 * List<OrderEntity> lstOfOrders = customerEntity.getLstOfOrdersOfCustomer(); //
		 * create a new order OrderEntity new_order_entity = new OrderEntity(3775981,
		 * LocalDate.of(2022, 8, 25), "Pending"); lstOfOrders.add(new_order_entity); }
		 */

		/*
		 * remove(dis-associate) a customer from an order It is possible by removing
		 * that order from the collection
		 */
		Optional<CustomerEntity> opt = customerRepo.findById(101);
		if (opt.isPresent()) {
			CustomerEntity customerEntity = opt.get();
			List<OrderEntity> lstOfOrders = customerEntity.getLstOfOrdersOfCustomer();
			for (OrderEntity orderEntity : lstOfOrders) {
				if (orderEntity.getOrderId() == 6934417) {
					lstOfOrders.remove(orderEntity);
				}
			}
		}
	}

}
