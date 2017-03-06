package com.rupp.spring.service;

import com.rupp.spring.dao.CustomerDao;
import com.rupp.spring.domain.DCustomer;
import com.rupp.spring.domain.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerSevice")
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    
    @Autowired
    private CustomerDao dao;
    
    @Override
    public List<DCustomer> list() {
        return dao.list();
    }

    @Override
    public DCustomer get(Long id) {
        return dao.get(id);
    }

    @Override
    public DCustomer create(DCustomer dCustomer) {
        return dao.create(dCustomer);
    }

    @Override
    public Long delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public DCustomer update(Long id, DCustomer dCustomer) {
        
        if (dao.get(id) == null) {
            return null;
        }
        dCustomer.setId(id);
        return dao.update(dCustomer);
    }
    
    public ResponseList<DCustomer> getPage(int pagesize, String cursorkey) {
        logger.debug(" getPage limit : {} cursorkey : {}", pagesize, cursorkey);
        return dao.getPage(pagesize, cursorkey);
    }
}
