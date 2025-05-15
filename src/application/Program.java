package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJurídica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Contribuinte> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberTaxPayers = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= numberTaxPayers; i++){
            System.out.printf("Tax payer #%d data:%n",i);
            System.out.print("Individual or company (i/c): ");
            char pfOrPj = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String nome = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if(pfOrPj == 'c'){
                System.out.println("Number of employees");
                int numberEmployees = sc.nextInt();
                sc.nextLine();
                Contribuinte contribuinte = new PessoaJurídica(nome,anualIncome,numberEmployees);
                list.add(contribuinte);
            } else if(pfOrPj == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditure = sc.nextDouble();
                sc.nextLine();
                Contribuinte contribuinte = new PessoaFisica(nome,anualIncome,healthExpenditure);
                list.add(contribuinte);
            }
        }

        System.out.println("TAXES PAID: ");
        double totalTaxes = 0.0;

        for(Contribuinte c : list){
            System.out.printf("%s: $ %.2f%n",c.getNome(), c.totalImposto());
            totalTaxes += c.totalImposto();
        }
        System.out.printf("TOTAL TAXES: $%.2f%n ", totalTaxes);
        sc.close();
    }
}
