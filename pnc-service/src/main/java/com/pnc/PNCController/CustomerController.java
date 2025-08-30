package com.pnc.PNCController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnc.PNCEntity.CustomerEntity;
import com.pnc.PNCService.CustomerService;



@RestController
@RequestMapping("/pnc/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/details")
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return ResponseEntity.ok(service.getSortedCustomers());
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CustomerEntity customer) {
        service.saveCustomerWithThreadSafety(customer);
        return ResponseEntity.status(201).body("Saved");
    }
}
