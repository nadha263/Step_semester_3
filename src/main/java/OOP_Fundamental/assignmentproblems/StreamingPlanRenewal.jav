
package OOP_Fundamental.assignmentproblems;

import java.util.*;
import java.time.*;

public class StreamingPlanRenewal {
    interface Plan {
        LocalDate getRenewalDate(LocalDate startDate);
    }

    static class Basic implements Plan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(30);
        }
    }

    static class Standard implements Plan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(90);
        }
    }

    static class Premium implements Plan {
        public LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(365);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Plan> plans = new HashMap<>();
        plans.put("BASIC", new Basic());
        plans.put("STANDARD", new Standard());
        plans.put("PREMIUM", new Premium());

        System.out.print("Enter number of subscribers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter plan type (BASIC/STANDARD/PREMIUM): ");
            String type = sc.nextLine().trim().toUpperCase();

            System.out.print("Enter subscriber name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(sc.nextLine().trim());

            LocalDate renewalDate = plans.get(type).getRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}