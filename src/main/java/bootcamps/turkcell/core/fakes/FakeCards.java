package bootcamps.turkcell.core.fakes;

import bootcamps.turkcell.core.domain.entities.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FakeCards {

    private List<Card> cards;

    public FakeCards() {
        this.cards = new ArrayList<>();
        cards.add(new Card("5890040000000016", "Sırrı KÖMÜR", 2029, 7, "123"));
    }
}
