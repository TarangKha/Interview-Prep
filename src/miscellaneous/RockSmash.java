package miscellaneous;

import java.util.*;
import java.io.*;

public class RockSmash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> stoneList = new ArrayList<Integer>();
        for(int i = 0; i < stones)
        Collections.sort(stoneList, Collections.reverseOrder());
        int size = stoneList.size();
        while(size >= 2){
            Integer rock = smash(stoneList);
            if(rock != 0){
                stoneList.add(rock);
            }
            Collections.sort(stoneList, Collections.reverseOrder());
            size = stoneList.size();
        }
        if(!stoneList.isEmpty()){
            return stoneList.get(0);
        } else {
            return 0;
        }
    }
    */
    
    public static int smash(ArrayList<Integer> stoneList){
        Integer rockY = stoneList.remove(0);
        Integer rockX = stoneList.remove(0);
        return rockY - rockX;
    }

}
