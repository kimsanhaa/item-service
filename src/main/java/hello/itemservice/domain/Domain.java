package hello.itemservice.domain;

import lombok.Data;

@Data
public class Domain {
    private String letter;
    private String jpLetter;
    private String enLetter;

    public Domain(String letter) {
        this.letter = letter;
    }
}
