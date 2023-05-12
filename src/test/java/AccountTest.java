import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setup() {
        account = new Account("389-5457867-62");
    }

    @Test
    void shouldNotThrowExceptionUsingConstructorIfAccountNumberIsValid() {

        Executable executable = () -> account = new Account("355-7894561-53");

        assertDoesNotThrow(executable);
    }

    @Test
    void shouldNotThrowExceptionUsingSetterIfAccountNumberIsValid() {

        Executable executable = () -> account.setAccountNumber("333-7123522-31");

        assertDoesNotThrow(executable);
    }

    @Test
    void shouldThrowExceptionIfPatternIsNotValid() {

        Executable executable = () -> account.setAccountNumber("333-712352-231");

        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    void shouldThrowExceptionIfLastTwoNumberAreNotValid() {

        Executable executable = () -> account.setAccountNumber("333-7123522-32");

        assertThrows(IllegalArgumentException.class, executable);

    }

}