
import javax.swing.*;
import java.text.*;


/**
 *
 * @author atkins01
 */
public class aClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String title;       // Value entered by user; string type
        String costStr;     // Value entered by user; string type
        String categoryStr; // Value entered by user; string type
        String category;
        String purchaseCostLevel;
        int categoryInt;
        double cost;        // The double form of the user-entered video game cost
        double totalCost = 0;
        double discountPercent;
        int resp = 0;       // The user's response as to whether to continue
        int counter = 0;    // The number of video games entered
        DecimalFormat prec2 = new DecimalFormat("$#.00");

        // Initialize the output string to the empty string
        String outputStr = "";
        
        String categoryType = " 1 Simulation\n 2 Sports\n 3 Action\n 4 "
                + "Strategy\n 5 Roleplaying\n";


        // Loop to input information on the user's video game collection
        while (true) {
            // Read in video game title from user as a string
            title = JOptionPane.showInputDialog("Enter video game title");
          

            // Read in cost from user as a string
            costStr = JOptionPane.showInputDialog("Enter video game cost");

            // Convert from type String to type double
            cost = Double.parseDouble(costStr);
            totalCost = totalCost + cost;
            categoryStr = JOptionPane.showInputDialog("Choose category by number\n" + categoryType);
            categoryInt = Integer.parseInt(categoryStr);
            counter++;
            
            switch(categoryInt)
            {
                case 1:
                    category = "Simulation";
                    break;
                case 2:
                    category = "Sports";
                    break;
                case 3:
                    category = "Action";
                    break;
                case 4:
                    category = "Strategy";
                    break;
                case 5:
                    category = "Role-playing";
                    break;
                default:
                   category = "Invalid category";
                   break;
            }
            if(totalCost < 40)
                purchaseCostLevel = "LOW";
            else if (totalCost < 80)
                purchaseCostLevel = "MEDIUM";
            else if (totalCost < 120)
                purchaseCostLevel = "HIGH";
            else
                purchaseCostLevel = "VERY HIGH";

            // Add the user-entered values to the output string 
            outputStr = outputStr + "Video Game #" + counter + "." + " Cat: " + category + ", Video game title: " 
                    + title + ", ";
            outputStr = outputStr + "Cost: " + prec2.format(cost) + " Total: " + prec2.format(totalCost) +
                    " LEVEL: " + purchaseCostLevel + "\n";

            // Get the user's choice as to whether to continue the loop
            resp = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // Test whether the user's choice is to continue the loop or not
            if (resp == JOptionPane.NO_OPTION) {
                break;
            }
        }
        
        if(totalCost < 40)
            discountPercent = 0;
        else if (totalCost < 80)
            discountPercent = 0.05;
        else if (totalCost < 120)
            discountPercent = 0.10;
        else
            discountPercent = 0.20;
        
        outputStr = outputStr + "\nYou will save " + prec2.format(totalCost * discountPercent) + 
                " on your order total of " + prec2.format(totalCost) + " with discount rate of " +
                discountPercent * 100 + "%";
        
        totalCost = totalCost - (totalCost * discountPercent);
        outputStr = outputStr + "\nFinal cost: " + prec2.format(totalCost);

        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr, "Video Game List", JOptionPane.INFORMATION_MESSAGE);

    }
    
}
