package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 알아낸 뒤
        // 스트라이크의 개수를 구한다.
        // 남은 수는 볼의 개수이다.
        final Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, player);

        int strike = 0;
        for (int placeIndex = 0; placeIndex < player.size(); placeIndex++) {

            if (judgement.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }
        int ball = correctCount - strike;
        if (correctCount == 0) {
            return "낫싱";
        }
        if (ball != 0) {
            if(strike == 0) {
                return ball +"볼";
            } else {
                return ball + "볼 " + strike + "스트라이크";
            }
        }
        return strike + "스트라이크";
    }
}
