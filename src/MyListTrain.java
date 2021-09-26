
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class MyListTrain {
    
   
    NodeTrain head;
    NodeTrain tail;
    Valication valication = new Valication();

    public MyListTrain() {
        head = tail = null;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean is_Empty() {
        return head == null;
    }

    public void vist(NodeTrain p) {
        if (p != null) {
            System.out.println(p + " ");
        }
    }

    public void Traverse() {
        NodeTrain p = head;
        while (p != null) {
            vist(p);
            p = p.next;
        }
    }

    public void add_Last(Train x) {
        NodeTrain q = new NodeTrain(x);
        if (is_Empty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;

    }

    public void add_First(Train x) {
        head = new NodeTrain(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void insertAfter(NodeTrain q, Train x) {
        if (q == null) {
            return;
        }
        NodeTrain p = new NodeTrain(x, q.next);
        q.next = p;
        if (tail == q) {
            tail = q;
        }
    }

    public void removeFrist() {
        if (is_Empty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void remove(NodeTrain q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFrist();
            return;
        }
        NodeTrain f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; // q is not found in the list
        } else {
            NodeTrain q1 = q.next;
            f.next = q1;
            if (q == tail) {
                tail = f;
            }
        }

    }

    public boolean Search_By_tcode(String tcode) {
        NodeTrain p = head;
        while (p != null) {
            if (p.infor.getTcode().equalsIgnoreCase(tcode)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public NodeTrain position(int k) {
        NodeTrain p = head;
        int i = 0;
        while (p != null) {
            if (i == k) {
                break;
            }
            i++;
            p = p.next;
        }
        return p;
    }

    public int size() {
        NodeTrain p = head;
        int count = 0;
        while (p != null) {
            count = count + 1;
            p = p.next;
        }
        return count;
    }

    public NodeTrain SearchBytcode(String xCode) {
        NodeTrain p = head;
        while (p != null) {
            if (p.infor.getTcode().equalsIgnoreCase(xCode)) {
                return (p);
            }
            p = p.next;
        }
        return null;
    }

    /////OPTION 1///
//    public void LoadFile() {
//        String fname = null;
//        while (true) {
//            try {
//                fname = valication.get_FileName();
//                Load_File(fname);
//                return;
//            } catch (Exception e) {
//                System.out.println("Invaild of file name!\n");
//            }
//        }
//    }
//
//    public void Load_File(String fname) throws IOException {
//        FileReader fr = new FileReader(fname);
//        BufferedReader br = new BufferedReader(fr);
//        String s;
//        String[] arr;
//        int seat, booked;
//        String tcode, train_name, depart_place;
//        double depart_time;
//        //check list empty to loading
//        if(!is_Empty()){
//            String getYesNo = valication.getInputYesNo();
//            if(!getYesNo.equalsIgnoreCase("y")){
//                return;
//            }
//        }
//        while (true) {
//            s = br.readLine();
//            if (s == null || s.length() < 6) {
//                break;
//            }
//
//            arr = s.split("\\|");
//
//            tcode = arr[0].trim();
//            train_name = arr[1].trim();
//            seat = Integer.parseInt(arr[2].trim());
//            booked = Integer.parseInt(arr[3].trim());
//            depart_time = Double.parseDouble(arr[4].trim());
//            depart_place = arr[5].trim();
//            add_Last(new Train(tcode, train_name, seat, booked, depart_time, depart_place));
//
//        }
//        fr.close();
//        br.close();
//        System.out.println("Successfully!\n");
//    }
//
//    ///////OPTION_2//////////
//    public void Add_head() {
//        String tcode = null;
//        int booked = 0;
//        while (true) {
//            tcode = valication.get_Input_String("tcode");
//            if (Search_By_tcode(tcode) == false) {
//                break;
//            } else {
//                System.out.println("This train code was exited!");
//            }
//        }
//        String train_name = valication.get_Input_String("train name");
//        int seat = 0;
//        while (true) {
//            seat = valication.get_Input_int("seat");
//            if (seat >= 0) {
//                break;
//            } else {
//                System.out.println("Invaild of seat!");
//            }
//        }
//
//        while (true) {
//            booked = valication.get_Input_int("booked");
//            if (booked >= 0 && booked <= seat) {
//                break;
//            } else {
//                System.out.println("booked must less than seat!");
//            }
//        }
//        double depart_time = 0;
//        while (true) {
//            depart_time = valication.get_Input_Double("depart time");;
//            if (depart_time >= 0) {
//                break;
//            } else {
//                System.out.println("Invaild of depart time!");
//            }
//        }
//        String depart_place = valication.get_Input_String("depart place");
//        add_Last(new Train(tcode, train_name, seat, booked, depart_time, depart_place));
//        System.out.println("Successfully!\n");
//    }
//
//    ///////////////OPTION_3///////////////
//    public void Display_Data() {
//        if (size() == 0) {
//            System.out.println("Empty!\n");
//        }
//        System.out.println("tcode  |  train_name  |  seat  |  booked  |  "
//                    + "depart_time  |  depart_place  |  available_seat ");
//        traverse_OP3();
//    }
//
//    public void traverse_OP3() {
//        NodeTrain p = head;
//        int available_seat = 0;
//        while (p != null) {
//            int booked = p.infor.getBooked();
//            int seat = p.infor.getSeat();
//            available_seat = seat - booked;
//            System.out.println(p.infor + " | " + available_seat);
//            p = p.next;
//        }
//        System.out.println("");
//    }
//
//    //////////////OPTION_4////////////
//    public void SaveFile() {
//        String fname = null;
//        while (true) {
//            try {
//                fname = valication.get_FileName();
//                Save_File(fname);
//                return;
//            } catch (Exception e) {
//                System.out.println("Invaild of file name!");
//            }
//        }
//    }
//
//    public void Save_File(String fname) throws IOException {
//        FileWriter fw = new FileWriter(fname);
//        PrintWriter pw = new PrintWriter(fw);
//        NodeTrain p = head;
//        while (p != null) {
//            pw.printf("%-10s | %-10s | %-10d | %-10d | %-10f | %-10s\n",
//                    p.infor.getTcode(), p.infor.getTrain_name(),
//                    p.infor.getSeat(), p.infor.getBooked(),
//                    p.infor.getDepart_time(), p.infor.getDepart_place());
//            p = p.next;
//        }
//        pw.close();
//        fw.close();
//        System.out.println("Succsessfully!\n");
//    }
//
//    /////////////OPTION_5////////////
//    public void Search_By_tcode() {
//        String tcode = valication.get_Input_String("train code");
//        NodeTrain resoult = SearchBytcode(tcode);
//        if (resoult == null) {
//            System.out.println("This train code is not found!");
//        } else {
//            System.out.println("tcode  |  train_name  |  seat  |  booked  |  "
//                    + "depart_time  |  depart_place  |  available_seat ");
//            System.out.println(resoult.infor);
//        }
//        System.out.println("");
//    }
//
//    ///////////////OPTION_6///////////
//    public void Delete() {
//        String tcode = valication.get_Input_String("train code");
//        NodeTrain resoult = SearchBytcode(tcode);
//        if (resoult == null) {
//            System.out.println("This train code is not found!\n");
//        } else {
//            System.out.println("Delete has been succsessfully!\n");
//        }
//        remove(resoult);
//    }
//
//    ////////////////OPTION_7//////////
//    public void SortByTcode() {
//        NodeTrain pi, pj;
//        Train temp;
//        for (pi = head; pi != null; pi = pi.next) {
//            for (pj = pi.next; pj != null; pj = pj.next) {
//                if (pi.infor.getTcode().compareTo(pj.infor.getTcode()) > 0) {
//                    temp = pi.infor;
//                    pi.infor = pj.infor;
//                    pj.infor = temp;
//                }
//            }
//        }
//        System.out.println("Sorting the list succsessfully!\n");
//    }
//
//    //////////////OPTION_8////////////
//    public void addAfterPosition() {
//        String tcode = null;
//        int booked = 0;
//        while (true) {
//            tcode = valication.get_Input_String("tcode");
//            if (Search_By_tcode(tcode) == false) {
//                break;
//            } else {
//                System.out.println("This train code was exited!");
//            }
//        }
//        String train_name = valication.get_Input_String("train name");
//        int seat = 0;
//        while (true) {
//            seat = valication.get_Input_int("seat");
//            if (seat >= 0) {
//                break;
//            } else {
//                System.out.println("Invaild of seat!");
//            }
//        }
//        while (true) {
//            booked = valication.get_Input_int("booked");
//            if (booked >= 0 && booked <= seat) {
//                break;
//            } else {
//                System.out.println("booked must less than seat!");
//            }
//        }
//        double depart_time = 0;
//        while (true) {
//            depart_time = valication.get_Input_Double("depart time");;
//            if (depart_time >= 0) {
//                break;
//            } else {
//                System.out.println("Invaild of depart time!");
//            }
//        }
//        String depart_place = valication.get_Input_String("depart place");
//        int position = valication.get_Input_int("position");
//        if (position < 0 || position > size() - 1) {
//            System.out.println("This position is not exited!");
//            return;
//        }
//        Train train = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
//        insertAfter(position(position), train);
//        System.out.println("Add data after at postion " + position + " succsesfully!");
//    }
//
//    /////////////////OPTION9////////////////////
//    public void Delete_befor_byTcode() {
//        String tcode = null;
//        tcode = valication.get_Input_String("tcode");
//        NodeTrain resoult = SearchBytcode(tcode);
//        if (resoult == null) {
//            System.out.println("This train code is not found!\n");
//        } else {
//            removeBefore(tcode);
//        }
//    }
//
//    public void removeBefore(String tcode) {
//        NodeTrain train = SearchBytcode(tcode);
//        NodeTrain f = head;
//        if (train == null) {
//            System.out.println("This code train not contain in system!\n");
//        } else {
//            if(train == head){
//                System.out.println("This code train is the frist element of list!\n");
//            }else{
//                while(f != null && f.next != train){
//                    f = f.next;
//                }
//                remove(f);
//                System.out.println("Successfully!\n");
//            }
//        }
//    }
    
}
