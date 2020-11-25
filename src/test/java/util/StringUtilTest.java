package util;

import ir.smartpath.authenticationservice.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class StringUtilTest {

    private List<Integer> randomNumbers;

    public StringUtilTest() {
        fillRandomList();
    }

    @Test
    void findSumTest() {
        int testCaseNumber = 20000;
        IntStream.range(0, testCaseNumber).forEachOrdered(i -> {
            int nextPointer = i + 1;
            if (i == testCaseNumber - 1) nextPointer = 0;
            Assertions.assertEquals(StringUtil.findSum(String.valueOf(randomNumbers.get(i)), String.valueOf(randomNumbers.get(nextPointer))),
                    String.valueOf(randomNumbers.get(i) + randomNumbers.get(nextPointer)));
        });

    }

    private void fillRandomList() {
        randomNumbers = new ArrayList<>();

        IntStream.range(0, 9999999).forEachOrdered(n -> {
            randomNumbers.add(n);
        });
        Collections.shuffle(randomNumbers);
    }
}
