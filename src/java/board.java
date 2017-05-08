
import java.text.*;
import java.util.*;
import java.util.logging.*;

final class board {

    static final long INTERVAL = 2000;
    final Random rand = new Random();
    private players player=new players();
    
    public int[] B1 = {5, 6};
    public int[] G1 = {23, 12};
    public int[] R1 = {34, 7};

    public int[] B2 = {25, 8};
    public int[] G2 = {28, 1};
    public int[] R2 = {42, 17};

    public int[] B3 = {15, 36};
    public int[] G3 = {22, 22};
    public int[] R3 = {5, 37};

    public int[] B4 = {25, 28};
    public int[] G4 = {9, 39};
    public int[] R4 = {10, 21};

    @Override
    public String toString() {
        return ("{ \"DOTS\": [ [\"B\"," + B1[0] + "," + B1[1] + "], [\"G\", " + G1[0] + ", " + G1[1] + "], [\"R\", " + R1[0] + ", " + R1[1] + "], [\"B\", " + B2[0] + ", " + B2[1] + "], [\"G\", " + G2[0] + ", " + G2[1] + "], [\"R\", " + R2[0] + ", " + R2[1] + "],  [\"B\", " + B3[0] + ", " + B3[1] + "], [\"G\", " + G3[0] + ", " + G3[1] + "], [\"R\", " + R3[0] + ", " + R3[1] + "], [\"B\", " + B4[0] + ", " + B4[1] + "], [\"G\", " + G4[0] + ", " + G4[1] + "], [\"R\", " + R4[0] + ", " + R4[1] + "]  ]");
    }
    public void update(String arr){
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
//        if((player.p1[1]==B1[0])&&(player.p1[2]==B1[2])){}
    }
}
