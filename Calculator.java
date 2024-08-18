import java.util.Scanner;

public class Calculator {

    public static void main(String args[]) {
        int myWatt;
        System.out.print("Enter Watt-hour: ");
        Scanner in = new Scanner(System.in);
        myWatt = in.nextInt();
        double billAmount = unitCal(myWatt);
        System.out.println("Your estimated electricity bill is: Rs."+billAmount);
        in.close();
    }

    public static double unitCal(int watthour) {
        double billAmount = 0;
        int unitsLeft = watthour;

        double[][] slabRates = { { 102, 5 }, { 78, 6.24 }, { 120, 6.89 }, { 300, 7.44 }, { 300, 7.43 }, { 900, 9.22 },
                { Integer.MAX_VALUE, 9.22 } };

        for (double[] slab : slabRates) {
            double slabLimit = slab[0];
            double slabRate = slab[1];

            if (unitsLeft > 0) {
                double unitsInThisSlab = Math.min(unitsLeft, slabLimit);
                billAmount += unitsInThisSlab * slabRate;
                unitsLeft -= unitsInThisSlab;
            } else {
                break;
            }
        }
        return billAmount;
    }
}