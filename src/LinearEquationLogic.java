import java.util.Scanner;
public class LinearEquationLogic {
    private LinearEquation linear;
    private Scanner sc;
    private boolean repeat;

    public LinearEquationLogic() {
        linear = null;
        sc = new Scanner(System.in);
        repeat = true;
    }
    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (repeat) {
            getCoordinateInfo();
            if (linear.isSlopeDefined() == false) {
                System.out.println(linear.vertLine());
            } else {
                enterXValue();
            }
            repeatTest();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }
    private void getCoordinateInfo() {
        System.out.print("Enter coordinate 1: ");
        String coord1 = sc.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = sc.nextLine();
        int x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(" ") + 1, coord1.indexOf(")")));
        int x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(" ") + 1, coord2.indexOf(")")));

        linear = new LinearEquation(x1, y1, x2, y2);

        if (linear.isSlopeDefined()) {
            System.out.println(linear.lineInfo());
        }
    }
    private void enterXValue() {
        System.out.print("\nEnter a value for x: ");
        double xValue = sc.nextDouble();
        sc.nextLine();




        System.out.println(linear.coordinateForX(xValue));
    }

    private void repeatTest() {
        System.out.print("\nWould you like to enter another pair of coordinates? y/n: ");
        String yOrN = sc.nextLine();
        if (yOrN.equals("y")) {
            repeat = true;
        } else {
            repeat = false;
        }
    }

}


