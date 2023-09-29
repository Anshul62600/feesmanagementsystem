package codecaveproject;

import java.util.Scanner;
class feesmanagement {
    static class Student {
        private int rollNumber;
        private String name;
        private double feesPaid;


        public  Student(int rollNumber, String name, double feesPaid) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.feesPaid = feesPaid;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getName() {
            return name;
        }

        public double getFeesPaid() {
            return feesPaid;
        }

        public void payFees(double amount) {
            feesPaid += amount;
        }

      /*  public double getBalance() {
            return feesPaid;
        }*/

       @Override
        public String toString() {
            return "Roll Number: " + rollNumber + ", Name: " + name + ", Fees Paid: " + feesPaid;
        }
    }

    public class FeesManagementSystem {
        private static final int MAX_STUDENTS = 100;
        private static Student[] students = new Student[MAX_STUDENTS];
        private static int studentCount = 0;


        public static void addStudent(Scanner scanner) {
            if (studentCount < MAX_STUDENTS) {
                System.out.print("Enter Roll Number: ");
                int rollNumber = scanner.nextInt();
                scanner.nextLine(); // Take the newline character

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                students[studentCount] = new Student(rollNumber, name,0.0);
                studentCount++;
                System.out.println("Student added successfully.");
            }
            else {
                System.out.println("Maximum student limit reached.");
            }
        }

        private static void payFees(Scanner scanner) {
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();

            boolean found = false;

            for (int i = 0; i < studentCount; i++) {
                if (students[i].getRollNumber() == rollNumber) {
                    found = true;
                    System.out.print("Enter Fees Amount to Pay: ");
                    double amount = scanner.nextDouble();
                    students[i].payFees(amount);
                    System.out.println("Fees paid successfully.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found with Roll Number: " + rollNumber);
            }
        }

        private static void checkStudentDetails(Scanner scanner) {
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();

            boolean found = false;

            for (int i = 0; i < studentCount; i++) {
                if (students[i].getRollNumber() == rollNumber) {
                    found = true;
                    System.out.println("Student Details:");
                    System.out.println(students[i]);
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found with Roll Number: " + rollNumber);
            }
        }
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input=0;
        while (input!=4) {
            System.out.println("Fees Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fees");
            System.out.println("3. Check Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    FeesManagementSystem.addStudent(scanner);
                    break;
                case 2:
                    FeesManagementSystem.payFees(scanner);
                    break;
                case 3:
                    FeesManagementSystem.checkStudentDetails(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    input=choice;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    }
