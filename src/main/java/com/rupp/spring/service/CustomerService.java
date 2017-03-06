package com.rupp.spring.service;

import com.rupp.spring.domain.DCustomer;
import com.rupp.spring.domain.ResponseList;

import java.util.List;

public interface CustomerService {
    List<DCustomer> list();
    DCustomer get(Long id);
    DCustomer create(DCustomer dCustomer);
    Long delete(Long id);
    DCustomer update(Long id, DCustomer dCustomer);
    ResponseList<DCustomer> getPage(int pagesize, String cursorkey);
}
