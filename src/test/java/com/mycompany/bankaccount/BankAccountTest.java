/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author phanp
 */
public class BankAccountTest {
    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(50.0);
        account.deposit(30.0);
        assertEquals(80.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    void testOverdraw() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150.0);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount(50.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testNegativeInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-50.0);
        });
        assertEquals("Initial balance cannot be negative", exception.getMessage());
    }
}
