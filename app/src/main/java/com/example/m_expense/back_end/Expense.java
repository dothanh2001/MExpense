package com.example.m_expense.back_end;

import java.util.Objects;

public class Expense {
    String amount;
    String kindOf;

    public Expense(String amount, String kindOf) {
        this.amount = amount;
        this.kindOf = kindOf;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKindOf() {
        return kindOf;
    }

    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(amount, expense.amount) && Objects.equals(kindOf, expense.kindOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, kindOf);
    }
}
