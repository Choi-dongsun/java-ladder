package ladder.domain;

import java.util.List;

public class User {
    private String name;
    private Integer position;
    private String result;

    public User(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    void linkResult(List<String> resultOfGame) {
        for (int i = 0; i < resultOfGame.size(); i++) {
            checkLinkResult(resultOfGame, i);
        }
    }

    private void checkLinkResult(List<String> resultOfGame, int i) {
        if(this.position == i) {
            this.result = resultOfGame.get(i);
        }
    }

    void moveRight() {
        this.position++;
    }

    void moveLeft() {
        this.position--;
    }

    public String getName() {
        return this.name;
    }

    String getResult() {
        return this.result;
    }

    Integer getPosition() {
        return this.position;
    }


}