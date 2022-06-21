package hello.itemservice.domain;

import lombok.Data;

@Data
public class Domain {
    private String letter;
    private String transLetter;

    public Domain(String letter) {
        this.letter = letter;
    }
}
