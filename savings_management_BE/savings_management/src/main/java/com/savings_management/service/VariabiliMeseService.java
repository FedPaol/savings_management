package com.savings_management.service;

public interface VariabiliMeseService {

    public Double computeUsableCash(double income, int workingDaysOfTheMonth, double totalCashesAtm);

    public Double calculateDaysToGetAmountBack(double amountOfTheExpense, double monthlyIncome, int workingDaysOfTheMonth);
}
