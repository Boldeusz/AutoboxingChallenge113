package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String nameOfBranch) {
        Branch tempBranch = findBranch(nameOfBranch);
        if (tempBranch == null) {
            tempBranch = new Branch(nameOfBranch);
            this.branches.add(tempBranch);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction) {
        Branch tempBranch = findBranch(nameOfBranch);
        if (tempBranch != null) {
            return tempBranch.newCustomer(nameOfCustomer, initialTransaction);
        } else {
            return false;
        }
    }

    private Branch findBranch(String nameOfBranch) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getName().equals(nameOfBranch)) {
                return this.branches.get(i);
            }
        }
        return null;
    }
    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {
        Branch tempBranch = findBranch(nameOfBranch);
        if(tempBranch != null) {
            return tempBranch.addCustomerTransaction(nameOfCustomer,transaction);
        } else {
            return false;
        }
    }

    public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
        Branch branch = findBranch(nameOfBranch);
        if (branch != null && printTransactions) {
            System.out.println("Customer details for branch " + branch.getName());
            for (int i = 0; i < branch.getCustomers().size(); i++) {
                System.out.println("Customer: " + branch.getCustomers().get(i).getName() +
                        "[" + (i + 1) + "]");
                System.out.println("Transactions:");
                for (int j = 0; j < branch.getCustomers().get(i).getTransactions().size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount " + branch.getCustomers().get(i).getTransactions().get(j));
                }
            }
            return true;
        } else if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            for (int i = 0; i < branch.getCustomers().size(); i++) {
                System.out.println("Customer: " + branch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
            }
            return true;
        } else {
            return false;
        }
    }
}
