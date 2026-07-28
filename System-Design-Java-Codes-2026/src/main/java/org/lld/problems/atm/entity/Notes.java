package org.lld.problems.atm.entity;

public enum Notes {
    // Indian Rupee
    INR_10(10, "INR", "Ten Rupees"),
    INR_50(50, "INR", "Fifty Rupees"),
    INR_100(100, "INR", "One Hundred Rupees"),
    INR_500(500, "INR", "Five Hundred Rupees"),
    INR_2000(2000, "INR", "Two Thousand Rupees");

    private final int denomination;
    private final String currencyCode;
    private final String description;

    Notes(int denomination, String currencyCode, String description) {
        this.denomination = denomination;
        this.currencyCode = currencyCode;
        this.description = description;
    }

    public int getDenomination() {
        return denomination;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + " (" + currencyCode + ")";
    }
}