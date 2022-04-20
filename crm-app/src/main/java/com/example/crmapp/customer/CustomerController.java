package com.example.crmapp.customer;

import com.example.crmapp.model.Customer;
import com.example.crmapp.repository.CustomerRepository;
import com.example.crmapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String getAllCustomers(Model model) {
        List<Customer> list = customerService.getAllCustomer();
        model.addAttribute("customers", list);
        return "customer-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer) {
        Customer c = customerService.createCustomer(customer);
        System.out.println(c);
        return "redirect:/customers/list";
    }
    @PostMapping("/back")
    public String back() {
        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String deleById(@RequestParam("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForEdit(@RequestParam("id")int id,Model model)
    {
        Customer theCustomer=customerService.getCustomer(id);
        model.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @GetMapping("/showCustomerDetail")
    public String showCustomerDetail(@RequestParam("id") int id,String firstName,String lastName,Model model)
    {
        Customer theCustomer=customerService.getCustomer(id);
        model.addAttribute("customer",theCustomer);
        return "customer-detail";
    }
}