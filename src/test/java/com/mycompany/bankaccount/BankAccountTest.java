/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author phanp
 */
public class BankAccountTest {
    private BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testDeposit() {
        account.deposit(30.0);
        assertEquals(80.0, account.getBalance());
    }
    @Test
    void testDepositSmallAmount() {
        account.deposit(0.001);
        assertEquals(100.001, account.getBalance(), 0.0001); // kiểm tra độ chính xác của số thập phân
    }
    @Test
    void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
    @Test
    void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10.0);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
    @Test
    void testWithdraw() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }
    @Test
    void testWithdrawAllBalance() {
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance());
    }
    @Test
    void testWithdrawNearBalanceLimit() {
        account.withdraw(99.99);
        assertEquals(0.01, account.getBalance(), 0.001);
    }
    @Test
    void testWithdrawOverBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150.0);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }
    @Test
    void testDepositZeroAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
        assertEquals("Deposit amount must be greater than zero", exception.getMessage());
    }

    @Test
    void testWithdrawZeroAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
        assertEquals("Withdrawal amount must be greater than zero", exception.getMessage());
    }
    
}
