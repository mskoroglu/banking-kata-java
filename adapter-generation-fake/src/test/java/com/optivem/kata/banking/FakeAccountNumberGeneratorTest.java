package com.optivem.kata.banking;

import com.optivem.kata.banking.adapters.driven.AccountNumberGeneratorTest;
import com.optivem.kata.banking.adapters.driven.fake.FakeAccountNumberGenerator;
import com.optivem.kata.banking.core.ports.driven.AccountNumberGenerator;

import static com.optivem.kata.banking.adapters.driven.fake.givens.FakeGenerationGivens.givenThat;

class FakeAccountNumberGeneratorTest extends AccountNumberGeneratorTest {

    @Override
    protected AccountNumberGenerator create() {

        var generator = new FakeAccountNumberGenerator();

        var expectedValue1 = "GB54BARC20032611545669";
        var expectedValue2 = "GB36BARC20038032622823";
        var expectedValue3 = "GB10BARC20040184197751";

        givenThat(generator).willGenerate(expectedValue1);
        givenThat(generator).willGenerate(expectedValue2);
        givenThat(generator).willGenerate(expectedValue3);

        return generator;
    }
}
