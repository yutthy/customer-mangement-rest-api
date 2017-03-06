/***/
package com.rupp.spring.domain;

import java.util.Date;

/**
 * map to table test_table customer
 * @version $id$ - $Revision$
 * @date 2017
 */
public class DCustomer {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private String email;
    private String address;
    private String phone;
    private Date createdDate;

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    private Date modifiedDate;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {return gender; }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DCustomer() {
        
    }
    public DCustomer(Long id, String firstName, String lastName, String gender, Date dob, String email, String address, String phone, Date modifiedDate) {
        this.id = id;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.gender     = gender;
        this.dob        = dob;
        this.email      = email;
        this.address    = address;
        this.phone      = phone;
        this.modifiedDate   = modifiedDate;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
}
