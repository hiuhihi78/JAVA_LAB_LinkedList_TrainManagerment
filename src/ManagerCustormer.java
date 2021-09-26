/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author hiuhihi78
 */
public class ManagerCustormer {

    Valication valication = new Valication();

    public ManagerCustormer() {
    }

    // load file
    public void LoadFile(MyListCustormer list) {
        String fname = null;
        while (true) {
            try {
                fname = valication.get_Input_String("file name");
                Load_File(list, fname);
                System.out.println("Successfully!\n");
                return;
            } catch (Exception e) {
                System.out.println("This file is not contain in system!\n");
                break;
            }
        }
    }

    public void Load_File(MyListCustormer list, String fname) throws IOException {
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] arr;
        String ID, Name, Number;
        double depart_time;
        while (true) {
            s = br.readLine();
            if (s == null || s.length() < 3) {
                break;
            }
            arr = s.split("\\|");
            ID = arr[0].trim();
            Name = arr[1].trim();
            Number = arr[2].trim();
            list.addLast(new Custormer(ID, Name, Number));
        }
        fr.close();
        br.close();
    }

    // add to end list
    public void addToTheEnd(MyListCustormer list) {
        String ID = valication.getID(list);
        String Name = valication.get_Input_String("name");
        String Number = valication.getInputNumber("number");
        list.addLast(new Custormer(ID, Name, Number));
        System.out.println("Successfully!\n");
    }

    // diplay data
    public void display(MyListCustormer list) {
        if (list.isEmpty()) {
            System.out.println("List empty!\n");
        }
        list.traverse();
    }

    // save file
    public void SaveFile(MyListCustormer list) {
        String fname = null;
        while (true) {
            try {
                fname = valication.get_Input_String("name file");
                Save_File(list, fname);
                System.out.println("Successfully!\n");
                return;
            } catch (Exception e) {
            }
        }
    }

    public void Save_File(MyListCustormer list, String fname) throws IOException {
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeCustormer p = list.head;
        while (p != null) {
            pw.printf("%-10s | %-10s | %-10d \n",
                    p.info.getID(), p.info.getName(), p.info.getNumber());
            p = p.next;
        }
        pw.close();
        fw.close();
        System.out.println("Succsessfully!\n");
    }

    // search by ccode
    public void SearchByCcode(MyListCustormer list) {
        String code = valication.get_Input_String("code");
        NodeCustormer xNode = list.searchByCcode(code);
        if (xNode == null) {
            System.out.println("This code not contain in System!");
        } else {
            System.out.println(xNode.info);
        }
    }

    // deletr by ccode
    public void DeleteByCcode(MyListCustormer list) {
        String code = valication.get_Input_String("code");
        NodeCustormer xNode = list.searchByCcode(code);
        if (xNode == null) {
            System.out.println("This code not contain in System!");
            return;
        }
        list.remove(xNode);
        System.out.println("Successfully!\n");
    }

}
