import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private String name;
    private int age;
    private String team;
    private String car;
    private int current_points;
    private static ArrayList<Driver> allDrivers = new ArrayList<Driver>();

    public Driver(String name, int age, String team, String car, int current_points) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.car = car;
        this.current_points = current_points;
        allDrivers.add(this);
    }

    public static void ADD() {
        String name = string_input_validator("name");
        boolean user_exist = validate_driver_by_name(allDrivers, name);
        if (user_exist) {
            System.out.println("Driver already exists by the name: " + name + " !");
            ADD();
        } else {
            int age = age_input_validator();
            String team = string_input_validator("team");
            String car = string_input_validator("car");
            int current_points = Integer.parseInt(current_points_input_validator());
            Driver new_user = new Driver(name, age, team, car, current_points);
            System.out.println("Driver " + name.trim() + " successfully added to team " + team + " !");
        }
    }

    public static String string_input_validator(String types) {
        Scanner scanner = new Scanner(System.in);
        String string_input = "";
        boolean done = false;
        while (!done) {
            try {
                if (types.equals("name")) {
                    System.out.print("Please enter your name : ");
                    string_input = scanner.nextLine();
                } else if (types.equals("car")) {
                    System.out.print("Please enter your car : ");
                    string_input = scanner.nextLine();
                } else if (types.equals("team")) {
                    System.out.print("Please enter your team : ");
                    string_input = scanner.nextLine();
                } else if (types.equals("delete")) {
                    System.out.print("Please enter name to delete : ");
                    string_input = scanner.nextLine();
                } else if (types.equals("update")) {
                    System.out.print("Please enter name to update : ");
                    string_input = scanner.nextLine();
                }

                if (string_input.trim().length() > 0) {
                    done = true;
                    return string_input;
                } else {
                    System.out.println("Invalid input please try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("String required");
            }
        }
        return string_input;
    }

    public static int age_input_validator() {
        Scanner scanner = new Scanner(System.in);
        int age_input = 0;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Please enter your age : ");
                age_input = Integer.parseInt(scanner.nextLine());
                if (age_input > 0) {
                    if (age_input >= 18 && age_input <= 80) {
                        done = true;
                        return age_input;
                    } else {
                        System.out.println("Age should be in the 18 - 80 range");
                    }
                } else {
                    System.out.println("Age should be a positive integer");
                }
            } catch (NumberFormatException e) {
                System.out.println("Integer required");
            }
        }
        return age_input;
    }

    public static String current_points_input_validator() {
        Scanner scanner = new Scanner(System.in);
        String currentPointsInput;
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Please enter your current points : ");
                currentPointsInput = scanner.nextLine();
                if (currentPointsInput.trim().length() >= 0) {
                    int converted = Integer.parseInt(currentPointsInput);
                    if (converted >= 0) {
                        done = true;
                        return currentPointsInput;
                    } else {
                        System.out.println("Current points should be a positive Integer !");
                    }
                } else {
                    System.out.println("Invalid input please try again !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Integer required.(If you haven't please enter 0)");
            }
        }
        return null;
    }
    public static boolean validate_driver_by_name(List<Driver> drivers, String newName) {
        for (Driver driver : drivers) {
            if (driver.name.equalsIgnoreCase(newName)) {
                return true;
            }
        }
        return false;
    }
}

