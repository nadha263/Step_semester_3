
package Abstraction.practiseproblems;

import java.util.*;

public class WeeklyStaffPay {
    abstract static class Staff {
        String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double calculatePay();
    }

    static class FullTime extends Staff {
        double salary;

        FullTime(String name, double salary) {
            super(name);
            this.salary = salary;
        }

        double calculatePay() {
            return salary;
        }
    }

    static class Hourly extends Staff {
        double hours, rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of staff members: ");
        int n = sc.nextInt();

        List<Staff> staffList = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter staff type (FULLTIME/HOURLY/INTERN): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter staff name: ");
            String name = sc.next();

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    System.out.print("Enter weekly salary: ");
                    staff = new FullTime(name, sc.nextDouble());
                    break;

                case "HOURLY":
                    System.out.print("Enter hours worked: ");
                    double hours = sc.nextDouble();
                    System.out.print("Enter hourly rate: ");
                    double rate = sc.nextDouble();
                    staff = new Hourly(name, hours, rate);
                    break;

                case "INTERN":
                    System.out.print("Enter stipend: ");
                    staff = new Intern(name, sc.nextDouble());
                    break;

                default:
                    System.out.println("Invalid staff type");
                    i--;
                    continue;
            }

            staffList.add(staff);
        }

        for (Staff staff : staffList) {
            double pay = staff.calculatePay();
            System.out.printf("%s: %.2f%n", staff.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}