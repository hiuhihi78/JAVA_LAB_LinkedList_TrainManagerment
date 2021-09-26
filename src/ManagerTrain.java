
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
public class ManagerTrain {

    private Valication valication = new Valication();

    public ManagerTrain() {
    }

    /////OPTION 1///
    public void LoadFile(MyListTrain list) {
        String fname = null;
        while (true) {
            try {
                fname = valication.get_FileName();
                Load_File(list, fname);
                return;
            } catch (Exception e) {
                System.out.println("This file is not contain in system!\n");
                break;
            }
        }
    }

    public void Load_File(MyListTrain list, String fname) throws IOException {
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] arr;
        int seat, booked;
        String tcode, train_name, depart_place;
        double depart_time;
        //check list empty to loading
        if (!list.is_Empty()) {
            String getYesNo = valication.getInputYesNo();
            if (!getYesNo.equalsIgnoreCase("y")) {
                return;
            }
        }
        while (true) {
            s = br.readLine();
            if (s == null || s.length() < 6) {
                break;
            }

            arr = s.split("\\|");

            tcode = arr[0].trim();
            train_name = arr[1].trim();
            seat = Integer.parseInt(arr[2].trim());
            booked = Integer.parseInt(arr[3].trim());
            depart_time = Double.parseDouble(arr[4].trim());
            depart_place = arr[5].trim();
            list.add_Last(new Train(tcode, train_name, seat, booked, depart_time, depart_place));

        }
        fr.close();
        br.close();
        System.out.println("Successfully!\n");
    }

    ///////OPTION_2//////////
    public void Add_head(MyListTrain list) {
        String tcode = null;
        int booked = 0;
        while (true) {
            tcode = valication.get_Input_String("tcode");
            if (list.Search_By_tcode(tcode) == false) {
                break;
            } else {
                System.out.println("This train code was exited!");
            }
        }
        String train_name = valication.get_Input_String("train name");
        int seat = 0;
        while (true) {
            seat = valication.get_Input_int("seat");
            if (seat > 0) {
                break;
            } else {
                System.out.println("Invaild of seat!");
            }
        }

        while (true) {
            booked = valication.get_Input_int("booked");
            if (booked < 0) {
                System.out.println("Invaild of booked!");
            } else if (booked >= 0 && booked <= seat) {
                break;
            } else {
                System.out.println("booked must less than seat!");
            }
        }
        double depart_time = 0;
        while (true) {
            depart_time = valication.get_Input_Double("depart time");;
            if (depart_time >= 0 && depart_time <= 24) {
                break;
            } else {
                System.out.println("Invaild of depart time!");
            }
        }
        String depart_place = valication.get_Input_String("depart place");
        list.add_First(new Train(tcode, train_name, seat, booked, depart_time, depart_place));
        System.out.println("Successfully!\n");
    }

    ///////////////OPTION_3///////////////
    public void Display_Data(MyListTrain list) {
        if (list.size() == 0) {
            System.out.println("Empty!\n");
            return;
        }
        System.out.println("tcode|Train_name|Seat|booked|depart_time|depart_place|available_seat");
        System.out.println("-------------------------------------------------------------------");
        traverse_OP3(list);
    }

    public void traverse_OP3(MyListTrain list) {
        NodeTrain p = list.head;
        int available_seat = 0;
        while (p != null) {
            int booked = p.infor.getBooked();
            int seat = p.infor.getSeat();
            available_seat = seat - booked;
            System.out.println(p.infor + "|" + available_seat);
            p = p.next;
        }
        System.out.println("");
    }

    //////////////OPTION_4////////////
    public void SaveFile(MyListTrain list) {
        String fname = null;
        while (true) {
            try {
                fname = valication.get_FileName();
                Save_File(list, fname);
                return;
            } catch (Exception e) {
                System.out.println("Invaild of file name!");
            }
        }
    }

    public void Save_File(MyListTrain list, String fname) throws IOException {
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeTrain p = list.head;
        while (p != null) {
            pw.printf("%-10s | %-10s | %-10d | %-10d | %-10f | %-10s\n",
                    p.infor.getTcode(), p.infor.getTrain_name(),
                    p.infor.getSeat(), p.infor.getBooked(),
                    p.infor.getDepart_time(), p.infor.getDepart_place());
            p = p.next;
        }
        pw.close();
        fw.close();
        System.out.println("Succsessfully!\n");
    }

    /////////////OPTION_5////////////
    public void Search_By_tcode(MyListTrain list) {
        String tcode = valication.get_Input_String("train code");
        NodeTrain resoult = list.SearchBytcode(tcode);
        int avaliable_seat = 0;
        if (resoult == null) {
            System.out.println("This train code is not found!");
        } else {
            avaliable_seat = resoult.infor.getSeat() - resoult.infor.getBooked();
            System.out.println("tcode|Train_name|Seat|booked|depart_time|depart_place|available_seat");
            System.out.println("-------------------------------------------------------------------");
            System.out.println(resoult.infor + "|" + avaliable_seat);
        }
        System.out.println("");
    }

    ///////////////OPTION_6///////////
    public void Delete(MyListTrain list) {
        String tcode = valication.get_Input_String("train code");
        NodeTrain resoult = list.SearchBytcode(tcode);
        if (resoult == null) {
            System.out.println("This train code is not found!\n");
        } else {
            System.out.println("Delete has been succsessfully!\n");
        }
        list.remove(resoult);
    }

    ////////////////OPTION_7//////////
    public void SortByTcode(MyListTrain list) {
        NodeTrain pi, pj;
        Train temp;
        for (pi = list.head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.infor.getTcode().compareTo(pj.infor.getTcode()) > 0) {
                    temp = pi.infor;
                    pi.infor = pj.infor;
                    pj.infor = temp;
                }
            }
        }
        System.out.println("Sorting the list succsessfully!\n");
    }

    //////////////OPTION_8////////////
    public void addAfterPosition(MyListTrain list) {
        String tcode = null;
        int booked = 0;
        int position = valication.get_Input_int("position");
        if (position < 0 || position > list.size() - 1) {
            System.out.println("This position is not exited!");
            return;
        }
        while (true) {
            tcode = valication.get_Input_String("tcode");
            if (list.Search_By_tcode(tcode) == false) {
                break;
            } else {
                System.out.println("This train code was exited!");
            }
        }
        String train_name = valication.get_Input_String("train name");
        int seat = 0;
        while (true) {
            seat = valication.get_Input_int("seat");
            if (seat > 0) {
                break;
            } else {
                System.out.println("Invaild of seat!");
            }
        }
        while (true) {
            booked = valication.get_Input_int("booked");
            if (booked >= 0 && booked <= seat) {
                break;
            } else {
                System.out.println("booked must less than seat!");
            }
        }
        double depart_time = 0;
        while (true) {
            depart_time = valication.get_Input_Double("depart time");;
            if (depart_time >= 0) {
                break;
            } else {
                System.out.println("Invaild of depart time!");
            }
        }
        String depart_place = valication.get_Input_String("depart place");
        Train train = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
        list.insertAfter(list.position(position), train);
        System.out.println("Add data after at postion " + position + " succsesfully!");
    }

    /////////////////OPTION9////////////////////
    public void Delete_befor_byTcode(MyListTrain list) {
        String tcode = null;
        tcode = valication.get_Input_String("tcode");
        NodeTrain resoult = list.SearchBytcode(tcode);
        if (resoult == null) {
            System.out.println("This train code is not found!\n");
        } else {
            removeBefore(list, tcode);
        }
    }

    public void removeBefore(MyListTrain list, String tcode) {
        NodeTrain train = list.SearchBytcode(tcode);
        NodeTrain f = list.head;
        if (train == null) {
            System.out.println("This code train not contain in system!\n");
        } else {
            if (train == list.head) {
                System.out.println("This code train is the frist element of list!\n");
            } else {
                while (f != null && f.next != train) {
                    f = f.next;
                }
                list.remove(f);
                System.out.println("Successfully!\n");
            }
        }
    }
}
