package com.savings_management.service;

import com.savings_management.entity.VariabiliMese;
import com.savings_management.exception.ExceptionHandlerController;

public class VariabiliMeseServiceImpl implements VariabiliMeseService{

    // compute method for usable cash
    // ipotesi: usare un try-catch in modo da inserire l'exception handler direttamente nel catch?
    @Override
    public Double computeUsableCash(double monthlyIncome, int workingDaysOfTheMonth, double totalCashesAtm) {
        VariabiliMese variabiliMese = new VariabiliMese();
        variabiliMese.setMonthlyIncome(monthlyIncome);
        variabiliMese.setWorkingDaysOfTheMonth(workingDaysOfTheMonth);
        variabiliMese.setTotalCashesAtm(totalCashesAtm);
        double dailyIncome;
        if (variabiliMese.getMonthlyIncome() > variabiliMese.getWorkingDaysOfTheMonth()) {
            dailyIncome = calculateDailyIncome(variabiliMese.getMonthlyIncome(), variabiliMese.getWorkingDaysOfTheMonth());
            return dailyIncome;
        } else {
            Exception exception = new Exception();
            ExceptionHandlerController exceptionHandlerController = new ExceptionHandlerController();
            exceptionHandlerController.handleBadRequestException(exception);
            return null;
        }
    }

    // method that gets an expense as input and calculates the amount of days necessary to get the same amount back
    // amountOfTheExpense = variabile inserita dall'utente al momento
    @Override
    public Double calculateDaysToGetAmountBack(double amountOfTheExpense, double monthlyIncome, int workingDaysOfTheMonth) {
        VariabiliMese variabiliMese = new VariabiliMese();
        variabiliMese.setMonthlyIncome(monthlyIncome);
        variabiliMese.setWorkingDaysOfTheMonth(workingDaysOfTheMonth);
        if (variabiliMese.getMonthlyIncome() > variabiliMese.getWorkingDaysOfTheMonth()) {
            double dailyIncome = calculateDailyIncome(variabiliMese.getMonthlyIncome(), variabiliMese.getWorkingDaysOfTheMonth());
            double daysTillAmountBack = amountOfTheExpense / dailyIncome;
            return daysTillAmountBack;
        } else {
            Exception exception = new Exception();
            ExceptionHandlerController exceptionHandlerController = new ExceptionHandlerController();
            exceptionHandlerController.handleBadRequestException(exception);
            return null;
        }
    }

    // calcola daily income
    public Double calculateDailyIncome(double monthlyIncome, int workingDaysOfTheMonth) {
        return monthlyIncome / workingDaysOfTheMonth;
    }
}
