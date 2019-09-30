package miscellaneous;

import java.util.HashMap;

public class TimeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** Initialize your data structure here. */
	HashMap<String, String[]> map = new HashMap<String, String[]>();
	public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        String[] inputVal = new String[2];
        inputVal[0] = "" + timestamp;
        inputVal[1] = value;
        
        if(map.containsKey(key)){
            String[] mapVal = map.get(key);
            Integer mapTimestamp = Integer.parseInt(mapVal[0]);
            if(timestamp > mapTimestamp){
                map.replace(key, inputVal);
            }
            return;
        } else {
            map.put(key, inputVal);
        }
        return;
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            String[] outputVal = map.get(key);
            return outputVal[1];
        } else {
            return "";
        }
    }

}
