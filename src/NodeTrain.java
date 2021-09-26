/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiuhihi78
 */
public class NodeTrain {
    public Train infor;
    public NodeTrain next;

    public NodeTrain() {
    }
    
    public NodeTrain(Train x){
        this.infor = x;
        this.next = null;
    }
    
    public NodeTrain(Train infor, NodeTrain next) {
        this.infor = infor;
        this.next = next;
    }

    public Train getInfor() {
        return infor;
    }

    public void setInfor(Train infor) {
        this.infor = infor;
    }

    public NodeTrain getNext() {
        return next;
    }

    public void setNext(NodeTrain next) {
        this.next = next;
    }
}
