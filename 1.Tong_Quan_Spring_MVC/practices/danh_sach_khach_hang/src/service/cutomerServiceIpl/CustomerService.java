package service.cutomerServiceIpl;

import model.Customer;
import org.springframework.stereotype.Service;
import service.ICutomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICutomerService {
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> listCustomer = new ArrayList<>();
        listCustomer.add(new Customer(1,"Tin","vtt@gmail.com","Quang Ngai"));
        listCustomer.add(new Customer(2,"BBB","vtt@gmail.com","Quang Ngai"));
        listCustomer.add(new Customer(3,"AAA","vtt@gmail.com","Quang Ngai"));
        listCustomer.add(new Customer(4,"Thanh","vtt@gmail.com","Quang Ngai"));
        listCustomer.add(new Customer(5,"Vo","vtt@gmail.com","Quang Ngai"));
        return listCustomer;
    }
}
