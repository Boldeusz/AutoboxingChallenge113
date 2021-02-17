package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National westminster");
        bank.addBranch("Tooting");

        bank.addCustomer("Tooting", "Marcin", 50.74);
        bank.addCustomer("Tooting", "Jacek", 34.54);
        bank.addCustomer("Tooting", "Agata", 234.98);

        bank.addCustomerTransaction("Tooting","Marcin",23.94);
        bank.addCustomerTransaction("Tooting","Jacek",64.94);
        bank.addCustomerTransaction("Tooting","Agata",23.77);

        bank.listCustomers("Tooting", true);

    }
}
