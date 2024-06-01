
import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        
        System.out.println("Enter an operation:");
        
        String operation = in.next();
        
        operation = operation.toLowerCase();
        
        switch (operation) {
            case "add": 
                     System.out.println("Enter two integers:");
                     
                     int f = 0;
                     int s = 0;
                     
                     if (in.hasNextInt()) {
                         f = in.nextInt();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     if (in.hasNextInt()) {
                         s = in.nextInt();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     int sum = f+s;
                     System.out.println("Answer: " + sum);
                     break;
                     
                     
            case "subtract":  
                     System.out.println("Enter two integers:");
                     
                     int fsub, ssub;
                     
                     if (in.hasNextInt()) {
                         fsub = in.nextInt();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     if (in.hasNextInt()) {
                         ssub = in.nextInt();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     int diff = fsub-ssub;
                     System.out.println("Answer: " + diff);
                     break;
                     
            case "multiply":  
                     System.out.println("Enter two doubles:");
                     
                     double fd, sd;
                     
                     if (in.hasNextDouble()) {
                         fd = in.nextDouble();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     if (in.hasNextDouble()) {
                         sd = in.nextDouble();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     double prod = fd * sd;
                     
                     System.out.println("Answer: " + String.format("%.2f",prod));
                     break;
                     
            case "divide": 
                     System.out.println("Enter two doubles:");
                     
                     double fd_div;
                     double sd_div;
                              
                     if (in.hasNextDouble()) {
                         fd_div = in.nextDouble();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     if (in.hasNextDouble()) {
                         sd_div = in.nextDouble();
                     } else {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     }
                     
                     double quot = fd_div / sd_div;
                     
                     if (sd_div == 0) {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                     } else {
                         System.out.println("Answer: " + String.format("%.2f",quot));
                         break;
                     }
                     
            case "alphabetize":  
                     System.out.println("Enter two words:");
                     String fs = in.next();
                     String ss = in.next();
                     
                     String fsl = fs.toLowerCase();
                     String ssl = ss.toLowerCase();
                     
                     if (fsl.compareTo(ssl) < 0 ) {
                         System.out.println("Answer: " + fs + " comes before " + ss + " alphabetically.");
                     } else if (fsl.compareTo(ssl) > 0 ) {
                         System.out.println("Answer: " + ss + " comes before " + fs + " alphabetically.");
                     } else if (fsl.compareTo(ssl) == 0 ) {
                         System.out.println("Answer: Chicken or Egg.");
                     }
                     
                     break;
            default: 
                     System.out.println("Invalid input entered. Terminating...");
                     break;
        }
        
    }
}
