package hello.itemservice.domain.item;


import lombok.Data;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
public class Item {

    private Long id;
    @NotEmpty(message = "itemName은 필수 값입니다.")
    private String itemName;
    @Max(value = 10000, message = "만원 이하만 가능합니다.")
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
