# bank-account-junit-tests
## Overview
This project demonstrates the implementation of a simple BankAccount program in Java, designed to handle common banking operations like deposits, withdrawals, and balance checks. To ensure reliability and correctness, we use JUnit 5 to write and run unit tests that validate the functionality of the program. The tests also include error handling scenarios for invalid operations.
## Test Cases
This section outlines the various test cases implemented to validate the functionality and robustness of the `BankAccount` class. Each test targets a specific behavior of the program:
```java
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
```
## Dependencies
This project uses Maven for dependency management. Below is the configuration for adding JUnit 5 to the project. This dependency is essential for running the tests and validating the `BankAccount` class.
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
## Results
The test suite was executed successfully, confirming that all implemented test cases passed without any errors or failures. Below is the summary of the test results:
![image](https://github.com/user-attachments/assets/c48c91b1-ae55-4033-aa3f-94fe32578f78)
## How to Run
```xml
mvn test
```
