package ua.com.public_utilities.bl;

import lombok.*;
import ua.com.public_utilities.entity.Rate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    List<ItemCart> cart;


    private BigDecimal totalValue;

    public Cart() {
        cart = new ArrayList<>();

    }

    public synchronized void addNewItemToCart (Rate rate, double index) {

        boolean logic = true;

        for (ItemCart el : cart) {
            if (rate.getId() == el.getRate().getId()){
                logic = false;
            }
        }

        if (logic == true) {
            cart.add(new ItemCart(rate, index));
        }
    }

    public synchronized void deleteItem (Rate rate) {
        for (ItemCart el : cart) {
            if (el.getRate().getId() == rate.getId()) {
                cart.remove(el);
                break;
            }
        }
    }

    public synchronized BigDecimal getTotalVal(){

        totalValue = BigDecimal.valueOf(0);
        for (ItemCart el : cart) {
            totalValue = totalValue.add(el.getRate().getPrice().multiply(BigDecimal.valueOf(el.getIndex())));
        }
        return totalValue;
    }
}
