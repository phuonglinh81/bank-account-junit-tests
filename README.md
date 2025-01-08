# bank-account-junit-tests
## Overview
This project demonstrates the implementation of a simple BankAccount program in Java, designed to handle common banking operations like deposits, withdrawals, and balance checks. To ensure reliability and correctness, we use JUnit 5 to write and run unit tests that validate the functionality of the program. The tests also include error-handling scenarios for invalid operations.
## Test Cases
This section outlines the various test cases implemented to validate the functionality and robustness of the `BankAccount` class. Each test targets a specific behaviour of the program:
```java
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
        assertEquals(130.0, account.getBalance());
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
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
    @Test
    void testWithdrawZeroAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
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
```bash
mvn test
```
## Link ChatGPT
This is the ChatGPT conversation link where an example of running JUnit tests was provided. You can review it to better understand the implementation details and testing process. [ChatGPT Example on JUnit Testing](https://chatgpt.com/share/677b68f2-4694-8005-9d7d-b37d5cc09f85)
