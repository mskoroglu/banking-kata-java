package com.optivem.kata.banking;

import com.optivem.kata.banking.adapters.BankingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BankingApplication.class)
class BankingApplicationTests {

    @Test
    void contextLoads() {
        var args = new String[]{};
        BankingApplication.main(args);
    }

}
