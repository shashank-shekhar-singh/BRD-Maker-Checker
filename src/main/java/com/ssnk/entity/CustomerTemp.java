package com.ssnk.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_temp")
public class CustomerTemp extends BaseEntity {
    @Column(length = 20, nullable = false)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(nullable = false)
    private String address1;
    private String address2;
    @Column(length = 6, nullable = false)
    private String pincode;
    @Column(unique = true)
    private String email;
    @Column(unique = true, nullable = false, length = 10)
    private String contactNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecordStatus recordStatus;
    @Column(nullable = false)
    private boolean activeFlag;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
