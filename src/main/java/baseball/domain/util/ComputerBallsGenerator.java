package baseball.domain.util;

import static baseball.domain.constant.NumberConstant.BASEBALL_NUMBER_MAX_VALUE;
import static baseball.domain.constant.NumberConstant.BASEBALL_NUMBER_MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerBallsGenerator {
    private static final int BASEBALL_GENERATION_NUMBER = 3;

    public static List<Integer> generate() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BASEBALL_GENERATION_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_MIN_VALUE.getValue(),
                    BASEBALL_NUMBER_MAX_VALUE.getValue());
            addNonDuplicateNumberInComputerNumbers(computerNumbers, randomNumber);
        }
        return computerNumbers;
    }

    private static void addNonDuplicateNumberInComputerNumbers(List<Integer> computerNumbers, int value) {
        if (!computerNumbers.contains(value)) {
            computerNumbers.add(value);
        }
    }
}