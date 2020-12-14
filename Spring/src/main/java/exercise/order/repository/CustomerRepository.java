package exercise.order.repository;

import exercise.order.domain.Customer;
import org.springframework.stereotype.Component;

public interface CustomerRepository {
	void save(Customer customer);
	void delete(long id);
}
