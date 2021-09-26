
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hiuhihi78
 */
public class Valication {

    public Valication() {
    }

    Scanner sc = new Scanner(System.in);

    public int get_Choice() {
        String StringChoice = null;
        int Choice = 0;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                StringChoice = sc.nextLine().trim();
                Choice = Integer.parseInt(StringChoice);
                return Choice;
            } catch (Exception e) {
                System.out.println("Invaild of choice!");
            }
        }
    }

    public String get_FileName() {
        String fname = null;
        while (true) {
            System.out.print("Enter the file name: ");
            fname = sc.nextLine().trim();
            if (fname != null) {
                return fname;
            } else {
                System.out.println("Invaid of file name!");
            }
        }
    }
//     int seat, booked;
//        String tcode, train_name, depart_place;

    public String get_Input_String(String paramater) {
        String input = null;
        while (true) {
            System.out.print("Enter " + paramater + ": ");
            input = sc.nextLine().trim();
            if (!input.equalsIgnoreCase("")) {
                return input;
            } else {
                System.out.println("Invaild of " + paramater + "!");
            }
        }
    }

    public int get_Input_int(String paramater) {
        String temp = null;
        int input = 0;
        while (true) {
            try {
                System.out.print("Enter " + paramater + ": ");
                temp = sc.nextLine().trim();
                input = Integer.parseInt(temp);
                return input;
            } catch (Exception e) {
                System.out.println("Invaild of " + paramater + "!");
            }
        }
    }

    public double get_Input_Double(String paramater) {
        String temp = null;
        double input = 0;
        while (true) {
            try {
                System.out.print("Enter " + paramater + ": ");
                temp = sc.nextLine().trim();
                input = Double.parseDouble(temp);
                return input;
            } catch (Exception e) {
                System.out.println("Invaild of " + paramater + "!");
            }
        }
    }

    public int get_Input_Int(String paramater) {
        String input = null;
        int resoult = 0;
        while (true) {
            try {
                System.out.print("Enter " + paramater + ": ");
                input = sc.nextLine().trim();
                if (input != "") {
                    resoult = Integer.parseInt(input);
                    return resoult;
                } else {
                    System.out.println("Invaild of " + paramater + "!");
                }
            } catch (Exception e) {
                System.out.println("Invaild of " + paramater + "!");
            }
        }
    }

    public String getInputNumber(String paramater) {
        String input = null;
        while (true) {
            try {
                System.out.print("Enter " + paramater + ": ");
                input = sc.nextLine().trim();
                int temp = Integer.parseInt(input); //check is number
                if (input != null) {
                    return input;
                } else {
                    System.out.println("Invaild of " + paramater + "!");
                }
            } catch (Exception e) {
            }
        }
    }

    public String getCode(MyListCustormer list) {
        while (true) {
            String code = get_Input_String("code");
            if (!code.equalsIgnoreCase(list.searchByCcode(code).info.getID())) {
                return code;
            }
        }
    }

    public String getID(MyListCustormer list) {
        String ID = null;
        while (true) {
            ID = get_Input_String("ID");
            if (list.searchByCcode(ID)== null) {
                return ID;
            } else {
                System.out.println("This ID was exited in system!");
            }
        }
    }

    //check tcode was exited?
    public boolean checkTcode(String tcode, MyListTrain listTrain) {
        NodeTrain train = listTrain.SearchBytcode(tcode);
        if (train == null) {
            return false;
        } else {
            return true;
        }
    }

    //check ccode was exited?
    public boolean checkCcode(String ccode, MyListCustormer listCustormer) {
        NodeCustormer train = listCustormer.searchByCcode(ccode);
        if (train == null) {
            return false;
        } else {
            return true;
        }
    }

    //check ccode and tcode was exited?
    public boolean checkTcodeAndCcode(String tcode, String ccode, MyListBooking listbooking) {
        NodeBooking booking = listbooking.searchByTcodeAndCcode(tcode, ccode);
        if (booking == null) {
            return false;
        } else {
            return true;
        }
    }

    //check booking seat
    public boolean CheckBookingSeat(String tcode, int seat, MyListTrain listTrain) {
        NodeTrain train = listTrain.SearchBytcode(tcode);
        if (train == null) {
            return false;
        }
        int available_seat = train.getInfor().getSeat() - train.getInfor().getBooked();
        if (available_seat == 0) {
            System.out.println("Train is  exhausted.");
            return false;
        }
        if (seat > available_seat) {
            System.out.println("Train not have enough seat!");
            return false;
        } else {
            return true;
        }
    }

    //total booking seat in a train
    public int totalBookingSeat(String tcode, MyListBooking listBooking) {
        int count = 0;
        NodeBooking p = listBooking.head;
        while (p != null) {
            String xTcode = p.info.getTcode();
            int booked = p.info.getSeat();
            if (tcode.equalsIgnoreCase(xTcode)) {
                count = count + booked;
            }
            p = p.next;
        }
        return count;
    }

    // get avakuvke seat of a train by train code
    public int getAvalible_seat_by_Tcode(MyListTrain listTrain, String tcode) {
        NodeTrain p = listTrain.head;
        int available_seat = 0;
        NodeTrain train = listTrain.SearchBytcode(tcode);
        available_seat = train.getInfor().getSeat() - train.getInfor().getBooked();
        return available_seat;
    }

    //get input y/n
    public String getInputYesNo() {
        System.out.println("You wants to keep the existing data or not?(Y/N)");
        while (true) {
            String choice = get_Input_String("your choice");
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
                return choice;
            }else{
                System.out.println("Invaild of choice!");
            }
        }
    }

}
