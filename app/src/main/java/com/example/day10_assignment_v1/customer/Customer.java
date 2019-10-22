package com.example.day10_assignment_v1.customer;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable
{
    Integer CustomerId;
    String CustFirstName;
    String CustLastName;
    String CustAddress;
    String CustCity;
    String CustProv;
    String CustPostal;
    String CustCountry;
    String CustHomePhone;
    String CustBusPhone;
    String CustEmail;
    String AgentId;

    public Customer(Integer customerId, String custFirstName, String custLastName,
                    String custHomePhone, String custEmail)
    {
        CustomerId = customerId;
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustHomePhone = custHomePhone;
        CustEmail = custEmail;
    }

    public Customer(Integer customerId, String custFirstName, String custLastName,
                    String custAddress, String custCity, String custProv, String custPostal,
                    String custCountry, String custHomePhone,String custBusPhone,
                    String custEmail, String agentId) {
        CustomerId = customerId;
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustAddress = custAddress;
        CustCity = custCity;
        CustProv = custProv;
        CustPostal = custPostal;
        CustCountry = custCountry;
        CustHomePhone = custHomePhone;
        CustBusPhone = custBusPhone;
        CustEmail = custEmail;
        AgentId = agentId;
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public Integer getCustomerId()
    {
        return CustomerId;
    }

    public String getCustFirstName()
    {
        return CustFirstName;
    }

    public String getCustLastName()
    {
        return CustLastName;
    }

    public String getCustAddress()
    {
        return CustAddress;
    }

    public String getCustCity()
    {
        return CustCity;
    }

    public String getCustProv()
    {
        return CustProv;
    }

    public String getCustPostal()
    {
        return CustPostal;
    }

    public String getCustCountry()
    {
        return CustCountry;
    }

    public String getCustBusPhone()
    {
        return CustBusPhone;
    }

    public String getCustHomePhone()
    {
        return CustHomePhone;
    }

    public String getCustEmail()
    {
        return CustEmail;
    }

    public String getAgentId()
    {
        return AgentId;
    }

    public void setCustomerId(Integer customerId)
    {
        CustomerId = customerId;
    }

    public void setCustFirstName(String custFirstName)
    {
        CustFirstName = custFirstName;
    }

    public void setCustLastName(String custLastName)
    {
        CustLastName = custLastName;
    }

    public void setCustAddress(String custAddress)
    {
        CustAddress = custAddress;
    }

    public void setCustCity(String custCity)
    {
        CustCity = custCity;
    }

    public void setCustProv(String custProv)
    {
        CustProv = custProv;
    }

    public void setCustPostal(String custPostal)
    {
        CustPostal = custPostal;
    }

    public void setCustCountry(String custCountry)
    {
        CustCountry = custCountry;
    }

    public void setCustBusPhone(String custBusPhone)
    {
        CustBusPhone = custBusPhone;
    }

    public void setCustHomePhone(String custHomePhone)
    {
        CustHomePhone = custHomePhone;
    }

    public void setCustEmail(String custEmail)
    {
        CustEmail = custEmail;
    }

    public void setAgentId(String agentId)
    {
        AgentId = agentId;
    }

    @Override
    public String toString() {
        return CustFirstName + " " + CustLastName ;//+ "  " + CustCity;
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "CustomerId=" + CustomerId +
//                ", CustFirstName='" + CustFirstName + '\'' +
//                ", CustLastName='" + CustLastName + '\'' +
//                ", CustAddress='" + CustAddress + '\'' +
//                ", CustCity='" + CustCity + '\'' +
//                ", CustProv='" + CustProv + '\'' +
//                ", CustPostal='" + CustPostal + '\'' +
//                ", CustCountry='" + CustCountry + '\'' +
//                ", CustBusPhone='" + CustBusPhone + '\'' +
//                ", CustHomePhone='" + CustHomePhone + '\'' +
//                ", CustEmail='" + CustEmail + '\'' +
//                ", AgentId='" + AgentId + '\'' +
//                '}';
//    }

    public Customer(Parcel in){
        String[] cust_data = new String[12];
        in.readStringArray(cust_data);

        CustomerId = Integer.valueOf(cust_data[0]);
        CustFirstName = cust_data[1];
        CustLastName = cust_data[2];
        CustAddress = cust_data[3];
        CustCity = cust_data[4];
        CustProv = cust_data[5];
        CustPostal = cust_data[6];
        CustCountry = cust_data[7];
        CustHomePhone = cust_data[8];
        CustBusPhone = cust_data[9];
        CustEmail = cust_data[10];
        AgentId = cust_data[11];
    }
    public int describeContents(){return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                String.valueOf(CustomerId),CustFirstName,CustLastName,CustAddress,CustCity,
                CustProv,CustPostal,CustCountry,CustHomePhone,CustBusPhone,CustEmail,AgentId
        });
    }
}
