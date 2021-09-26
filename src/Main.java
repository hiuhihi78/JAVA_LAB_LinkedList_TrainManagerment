
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hiuhihi78
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MyListTrain listTrain = new MyListTrain();
        MyListCustormer listCustormer = new MyListCustormer();
        MyListBooking listBooking = new MyListBooking();
        ManagerTrain managerTrain = new ManagerTrain();
        ManagerCustormer managerCustormer = new ManagerCustormer();
        ManagerBooking managerBooking = new ManagerBooking();
        Valication valication = new Valication();
        String choice = null;
        while (true) {
            System.out.println("            TRAIN MANAGERMENT");
            System.out.println("--------------------------------------");
            System.out.println("1.1.      Load data from file");
            System.out.println("1.2.      Input & add to the end");
            System.out.println("1.3.      Display data");
            System.out.println("1.4.      Save train list to file");
            System.out.println("1.5.      Search by tcode");
            System.out.println("1.6.      Delete by tcode");
            System.out.println("1.7.      Sort by tcode");
            System.out.println("1.8.      Add after position  k");
            System.out.println("1.9.      Delete the node before the node having tcode = xCode");
            System.out.println("            CUSTORMER MANAGERMENT");
            System.out.println("--------------------------------------");
            System.out.println("2.1.      Load data from file");
            System.out.println("2.2.      Input & add to the end");
            System.out.println("2.3.      Display data");
            System.out.println("2.4.      Save customer list to file");
            System.out.println("2.5.      Search by ccode");
            System.out.println("2.6.      Delete by ccode");
            System.out.println("            BOOKING MANAGERMENT");
            System.out.println("--------------------------------------");
            System.out.println("3.1.      Input data");
            System.out.println("3.2.      Display data width available seats");
            System.out.println("3.3.      Sort  by tcode + ccode");
            choice = valication.get_Input_String("your choice");
            switch (choice) {
                case "1.1":
                    managerTrain.LoadFile(listTrain);
                    break;
                case "1.2":
                    managerTrain.Add_head(listTrain);
                    break;
                case "1.3":
                    managerTrain.Display_Data(listTrain);
                    break;
                case "1.4":
                    managerTrain.SaveFile(listTrain);
                    break;
                case "1.5":
                    managerTrain.Search_By_tcode(listTrain);
                    break;
                case "1.6":
                    managerTrain.Delete(listTrain);
                    break;
                case "1.7":
                    managerTrain.SortByTcode(listTrain);
                    break;
                case "1.8":
                    managerTrain.addAfterPosition(listTrain);
                    break;
                case "1.9":
                    managerTrain.Delete_befor_byTcode(listTrain);
                    break;
                case "2.1":
                    managerCustormer.LoadFile(listCustormer);
                    break;
                case "2.2":
                    managerCustormer.addToTheEnd(listCustormer);
                    break;
                case "2.3":
                    managerCustormer.display(listCustormer);
                    break;
                case "2.4":
                    managerCustormer.SaveFile(listCustormer);
                    break;
                case "2.5":
                    managerCustormer.SearchByCcode(listCustormer);
                    break;
                case "2.6":
                    managerCustormer.DeleteByCcode(listCustormer);
                    break;
                case "3.1":
                    managerBooking.InputData(listTrain, listCustormer, listBooking);
                    break;
                case "3.2":
                    managerBooking.displayData(listBooking,listTrain);
                    break;
                case "3.3":
                    managerBooking.sortTcodeCcode(listBooking);
                    break;
                default:
                    System.out.println("Invaild of choice! Please reenter!");

            }
        }

    }
}
