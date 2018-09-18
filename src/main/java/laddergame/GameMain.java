package laddergame;

public class GameMain {
    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] people = LadderMaker.inputPeople();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int high = LadderMaker.inputNum();

        Ladder ladder = new Ladder(LadderMaker.printPeopleLength(people), high);
        LadderMaker.printLadder(ladder.getLadder());
    }
}
