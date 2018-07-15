package server.remote;

import java.io.Serializable;

public class SubPart implements Serializable {
    public SubPart(){ }
    public SubPart(Part part, int count){
        this.part = part;
        this.count = count;
    }
    public Part part;
    public int count;
}
