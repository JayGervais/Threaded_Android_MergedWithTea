package com.example.day10_assignment_v1.admin;

public class Admin
{
    private Integer AdminId;
    private String AdminFirstName;
    private String AdminLastName;
    private String AdminEmail;
    private String AdminPosition;
    private String AdminPassword;

    public Admin(Integer adminId, String adminFirstName, String adminLastName, String adminEmail, String adminPosition, String adminPassword)
    {
        AdminId = adminId;
        AdminFirstName = adminFirstName;
        AdminLastName = adminLastName;
        AdminEmail = adminEmail;
        AdminPosition = adminPosition;
        AdminPassword = adminPassword;
    }

    public Admin(String adminFirstName, String adminLastName, String adminEmail, String adminPosition)
    {
        AdminFirstName = adminFirstName;
        AdminLastName = adminLastName;
        AdminEmail = adminEmail;
        AdminPosition = adminPosition;
    }

    @Override
    public String toString()
    {
        return AdminId + " " + AdminFirstName + " " + AdminLastName
                + " " + AdminEmail + " " + AdminPosition;
    }

    public Integer getAdminId()
    {
        return AdminId;
    }

    public void setAdminId(Integer adminId)
    {
        AdminId = adminId;
    }

    public String getAdminFirstName()
    {
        return AdminFirstName;
    }

    public void setAdminFirstName(String adminFirstName)
    {
        AdminFirstName = adminFirstName;
    }

    public String getAdminLastName()
    {
        return AdminLastName;
    }

    public void setAdminLastName(String adminLastName)
    {
        AdminLastName = adminLastName;
    }

    public String getAdminEmail()
    {
        return AdminEmail;
    }

    public void setAdminEmail(String adminEmail)
    {
        AdminEmail = adminEmail;
    }

    public String getAdminPosition()
    {
        return AdminPosition;
    }

    public void setAdminPosition(String adminPosition)
    {
        AdminPosition = adminPosition;
    }

    public void setAdminPassword(String adminPassword)
    {
        AdminPassword = adminPassword;
    }
}
