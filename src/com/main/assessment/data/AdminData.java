package com.main.assessment.data;

import java.util.ArrayList;
import java.util.List;

import com.main.assessment.concrete.Admin;

/**
 * AdminData
 */
public class AdminData {

    private static List<Admin> admins = new ArrayList<>(List.of(
            new Admin("admin", "admin", "ADMIN", null)));

    /*
     * to get the all admins
     */
    public List<Admin> getAllAdmins() {
        return admins;
    }

    /*
     * to get particular admin by username and password
     */
    public Admin getAdmin(String username, String password) {
        return admins.stream()
                .filter(admin -> admin.getUserName().equals(username) && admin.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}