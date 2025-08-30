
package com.pnc.PNCService;

import com.pnc.PNCEntity.CustomerEntity;
import com.pnc.PNCRepository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    private final ReentrantLock lock = new ReentrantLock();

    private final Set<String> savedEmails = Collections.synchronizedSet(new HashSet<>());

    public void saveCustomerWithThreadSafety(CustomerEntity customer) {
        lock.lock();
        try {
            if (!savedEmails.contains(customer.getEmail())) {
                savedEmails.add(customer.getEmail());
                repository.save(customer);
                System.out.println("Saved customer: " + customer.getEmail());
            } else {
                System.out.println("Duplicate detected: " + customer.getEmail());
            }
        } finally {
            lock.unlock();
        }
    }

    @Async
    public void processAsyncSave(CustomerEntity customer) {
        saveCustomerWithThreadSafety(customer);
    }

    public List<CustomerEntity> getSortedCustomers() {
        List<CustomerEntity> list = repository.findAll();
        list.sort(Comparator.comparing(CustomerEntity::getName));
        return list;
    }
}
