package com.rupp.spring.controller;

import com.rupp.spring.domain.DCustomer;
import com.rupp.spring.domain.ResponseList;
import com.rupp.spring.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;
    

    //@RequestMapping(value = "/v1", method = RequestMethod.GET)
    @GetMapping("/v1/all")
    @ResponseBody
    public List<DCustomer> getDCustomers() {
        logger.debug("====get all Customers====");
        return service.list();
    }
    
    @GetMapping("/v1")
    @ResponseBody
    public ResponseList<DCustomer> getPage(@RequestParam(value="pagesize", defaultValue="10") int pagesize,
                                           @RequestParam(value = "cursorkey", required = false) String cursorkey) {
        logger.debug("====get page {} , {} ====", pagesize, cursorkey);
        return service.getPage(pagesize, cursorkey);
    }

    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
    @GetMapping("/v1/{id}")
    public ResponseEntity<DCustomer> getDCustomer(@PathVariable("id") Long id) {

        logger.debug("====get customer detail with id :[{}] ====", id);
        
        final DCustomer customer = service.get(id);
        if (customer == null) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //@RequestMapping(value = "/v1", method = RequestMethod.POST)
    @PostMapping(value = "/v1")
    public ResponseEntity<DCustomer> createDCustomer(@RequestBody DCustomer customer) {
        logger.debug("====create new customer object ====");
        service.create(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/v1/{id}")
    public ResponseEntity deleteDCustomer(@PathVariable Long id) {
        logger.debug("====delete customer detail with id :[{}] ====", id);
        if (null == service.delete(id)) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
    //@RequestMapping(value = "/v1/{id}", method = RequestMethod.PUT)
    @PutMapping("/v1/{id}")
    public ResponseEntity updateDCustomer(@PathVariable Long id, @RequestBody DCustomer customer) {
        logger.debug("====update customer detail with id :[{}] ====", id);
        customer = service.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
    @PostMapping("/v1/{id}/json")
    public ResponseEntity updateByJson(@PathVariable Long id, @RequestBody DCustomer customer) {
        logger.debug("====update customer detail with id :[{}] ====", id);
        customer = service.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No DCustomer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
    @PostMapping("/v1/json")
    public ResponseEntity createByJson(@RequestBody DCustomer customer) {
        logger.debug("====create new customer object with json====");
        service.create(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
    
    /**
     * <pre>
     * schema api : Content-Type: application/x-www-form-urlencoded 
     * example json value
     * 
     *   {
     *       primaryKeyName: "id",
     *       tableName: "Country",
     *       primaryKeyType: "long",
     *       columns: {
     *           comingSoon: "boolean",
     *           flagImageUrl: "text",
     *           isoCode: "text",
     *           name: "text",
     *           state: "long",
     *           tcsUrl: "text",
     *           createdDate: "datetime"
     *        }
     *   }
     *   </pre>
     * @param request
     */
    @RequestMapping(value = "v1/schema", method = { RequestMethod.GET })
    public ResponseEntity<Map<String, Object>> getschma(HttpServletRequest request) {
        final Map<String, Object> body = new HashMap<String, Object>();
        final Map<String,String> columns = new HashMap<>();
        
        columns.put("firstName", "text");
        columns.put("lastName", "text");
        columns.put("dob", "datetime");
        columns.put("gender", "text");
        columns.put("phone", "text");
        columns.put("email", "text");
        columns.put("address", "text");
        columns.put("createdDate", "datetime");


        body.put("columns", columns);
        body.put("tableName", "Customer");
        body.put("primaryKeyName", "id");
        body.put("primaryKeyType", "long");
        
        return new ResponseEntity<Map<String, Object>>(body, HttpStatus.OK);
    }
    
}
