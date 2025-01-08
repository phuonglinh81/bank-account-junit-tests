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
    void testDepositSmallAmount() {
        BankAccount account = new BankAccount(50.0);
        account.deposit(0.001);
        assertEquals(50.001, account.getBalance(), 0.0001); // kiểm tra độ chính xác của số thập phân
    }
    @Test
    void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
    @Test
    void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10.0);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }
    @Test
    void testWithdrawAllBalance() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance());
    }
    @Test
    void testWithdrawNearBalanceLimit() {
        BankAccount account = new BankAccount(1000.0);
        account.withdraw(999.99);
        assertEquals(0.01, account.getBalance(), 0.0001);
    }
    @Test
    void testWithdrawOverBalance() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150.0);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

}
