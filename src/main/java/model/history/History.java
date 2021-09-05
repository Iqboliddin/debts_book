package model.history;

import model.BaseModel;

import java.math.BigDecimal;
import java.util.UUID;

public class History extends BaseModel {
    private String date;
    private Category category;
    private BigDecimal amount;

    public History() {
    }

    public History(UUID id, String name, String date,
                   Category category,
                   BigDecimal amount)
    {
        super(id, name);
        this.date = date;
        this.category = category;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
