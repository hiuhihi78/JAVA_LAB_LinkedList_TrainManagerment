/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class ManagerBooking {

    private Valication valication = new Valication();

    public ManagerBooking() {
    }

    public void InputData(MyListTrain listTrain, MyListCustormer listCustormer,
            MyListBooking listBooking) {
        String tcode = valication.get_Input_String("tcode");
        String ccode = valication.get_Input_String("ccode");
        int seat = valication.get_Input_Int("seat");

        boolean checkTcode = valication.checkTcode(tcode, listTrain);
        boolean checkCcode = valication.checkCcode(ccode, listCustormer);
        boolean checkTcodeAndCcode = valication.checkTcodeAndCcode(tcode, ccode, listBooking);
        boolean checkBookingSeat = valication.CheckBookingSeat(tcode, seat, listTrain);
        NodeTrain xTrain = listTrain.SearchBytcode(tcode);
        if (checkTcodeAndCcode == true) {
            System.out.println("This info was exited in system!\n");
            return;
        }
        if (checkCcode == false || checkTcode == false) {
            System.out.println("tcode or ccode not contain in system!\n");
            return;
        }
        if (checkBookingSeat == false) {
            return;
        }
        listBooking.addLast(new Booking(tcode, ccode, seat));
        System.out.println("Successfully!\n");
        /// adding new booking seat in train list
        xTrain.infor.setBooked(xTrain.infor.getBooked() + seat);

    }

    public void displayData(MyListBooking listBooking, MyListTrain listTrain) {
        NodeBooking p = listBooking.head;
        if (listBooking.size() == 0) {
            System.out.println("List is empty!\n");
            return;
        }
        while (p != null) {
            // search obj in train list to get avalible seat 
            String tcode = p.info.getTcode();
            int avalible_seat = valication.getAvalible_seat_by_Tcode(listTrain, tcode);
            System.out.println(p.info + "|" + avalible_seat);
            p = p.next;
        }
        System.out.println("");
    }

    public void sortTcodeCcode(MyListBooking listBooking) {
        listBooking.sortByTcodeCcode();
        System.out.println("Successfully!\n");
    }
}
