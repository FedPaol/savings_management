package com.savings_management.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class VariabiliMese {

    private double monthlyIncome;

    private int workingDaysOfTheMonth;

    private double totalCashesAtm;
}


/*import java.util.Scanner;
public class Stipendio {
    public static void main(String[] args) {
        // inputs section
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stipendio del mese");
        double monthlyIncomes = scanner.nextDouble();
        System.out.println("Giorni lavorati");
        int workingDaysOfTheMonth = scanner.nextInt();
        System.out.println("Ammontare liquidi al momento");
        double totalCashesAtm = scanner.nextDouble();
        // compute method declaration
        computeUsableCash(monthlyIncomes, workingDaysOfTheMonth, totalCashesAtm);
        System.out.println("Vuoi calcolare l'ammortamento calcolato in giorni di una spesa? Scrivi si o no");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("si")) {
            System.out.println("Inserisci l'ammontare della spesa da affrontare");
            double amountOfTheExpense = scanner.nextDouble();
            double daysTillAmoutBack = calculateDaysToGetAmoutBack(amountOfTheExpense, monthlyIncomes, workingDaysOfTheMonth);
            System.out.println("Giorni necessari per ritornare a pari della spesa: " + daysTillAmoutBack);
        }
    }
    // compute method for usable cash
    public static void computeUsableCash(double monthlyIncome, int workingDaysOfTheMonth, double totalCashesAtm) {
        double dailyIncome = calculateDailyIncome(monthlyIncome, workingDaysOfTheMonth);
        System.out.println("Il daily income del mese in base ai tuoi giorni lavorati: " + dailyIncome);
        System.out.println("Ammontare massimo spendibile al momento: " + (totalCashesAtm * 0.1));
        System.out.println("Numero di giorni necessari per rientrare dell'eventuale spesa massima: " + totalCashesAtm * 0.1 / dailyIncome);
    }
    // daily income
    private static double calculateDailyIncome(double monthlyIncome, int workingDaysOfTheMonth) {
        if (monthlyIncome > workingDaysOfTheMonth) {
            return monthlyIncome / workingDaysOfTheMonth;
        } else {
            return 0;
        }
    }
    // method that gets an expense as input and calculates the amount of days necessary to get the same amount back
    private static double calculateDaysToGetAmoutBack(double amountOfTheExpense, double monthlyIncome, int workingDaysOfTheMonth) {
        double dailyIncome = calculateDailyIncome(monthlyIncome, workingDaysOfTheMonth);
        double daysTillAmountBack = amountOfTheExpense / dailyIncome;
        return daysTillAmountBack;
    }
}*/
