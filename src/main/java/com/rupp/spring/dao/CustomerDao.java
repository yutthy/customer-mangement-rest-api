package com.rupp.spring.dao;

import com.rupp.spring.domain.DCustomer;
import com.rupp.spring.domain.ResponseList;

import java.util.List;

public interface CustomerDao {

    /**
     * Returns list of customers from dummy database.
     * 
     * @return list of customers
     */
    List<DCustomer> list();

    /**
     * Return dCustomer object for given id from dummy database. If dCustomer is not found for id, returns null.
     * 
     * @param id
     *            dCustomer id
     * @return dCustomer object for given id
     */
    DCustomer get(Long id);
    /**
     * Create new dCustomer in dummy database. Updates the id and insert new dCustomer in list.
     * 
     * @param dCustomer
     *            DCustomer object
     * @return dCustomer object with updated id
     */
    DCustomer create(DCustomer dCustomer);
    
    Long delete(Long id);
    
    DCustomer update(DCustomer dCustomer);
    
    ResponseList<DCustomer> getPage(int pagesize, String cursorkey);
}
