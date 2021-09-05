package model.debt;

import model.BaseModel;
import model.history.Category;

import java.math.BigDecimal;
import java.util.UUID;

public class Debt extends BaseModel {
    private Category category;
    private int amount;
    private String date;

    public Debt() {
    }

    public Debt(UUID id, String name,
                Category category,
                int amount,
                String date
    ) {
        super(id, name);
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
