import com.humanbooster.exercices.Calculatrice;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        double a;
        double b;
        String c;
        int p = 0;
        Scanner scan = new Scanner(System.in);
        
        try {
            //Inputs
            System.out.println("Entrez le premier nombre:");
            a = scan.nextDouble();
            System.out.println("Entrez l'operation:");
            c = scan.next();
            System.out.println("Entrez le second nombre:");
            b = scan.nextDouble();
            p = setPrecision(a,b);

            //Calcul
            switch (c){
                case "+":
                    System.out.println(Calculatrice.additionner(a, b, p));
                    break;
                case "-":
                    System.out.println(Calculatrice.soustraire(a, b, p));
                    break;
                case "*":
                    System.out.println(Calculatrice.multiplier(a, b, p));
                    break;
                case "/":
                    System.out.println(Calculatrice.diviser(a, b, p));
                    break;
                case "^":
                    System.out.println(Calculatrice.pow(a, b, p));
                    break;
                default:
                    System.err.println("Invalid Operator");
            }
        } catch (ArithmeticException e){
            System.err.println("Error: " + errHandler(e));
        } catch (InputMismatchException e){
            System.err.println("Error: " + errHandler(e));
        } catch (Exception e) {
            System.err.println("Error: " + errHandler(e));
        }
        finally{
            scan.close();
        }
    }

    // Error Handler
    public static String errHandler(Exception e){
        String errMsg = (e.getMessage() == null) ? "Unknow Error" : e.getMessage();
        return errMsg;
    }

    public static int setPrecision(double a, double b){
        int p = 0;
        String[] a_split = Double.toString(a).split("\\.");
        String[] b_split = Double.toString(b).split("\\.");

        // Get the most precise number
        if (a_split.length > 1 && b_split.length == 1) {
            return p = a_split.length;
        }
        else if (b_split.length > 1 && a_split.length == 1) {
            return p = b_split.length;
        }
        else if (a_split.length > 1 && b_split.length > 1){
            return p = (a_split[1].length() > b_split[1].length()) ? a_split[1].length() : b_split[1].length();
        }
        else return p;
    }
}
