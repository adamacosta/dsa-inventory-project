/**
 * HashTable is a container class for the ItemRecord, each of which
 * is used by InventoryApp to store live product inventory records.
 * This implementation uses double hashing to conduct a probe when
 * collisions occur. 
 *
 * @ authors Michael Scarpace and Adam Acosta 2014
 */

package inventory;

public class HashTable {

private ItemRecord deleted;
private ItemRecord[] data;
private int fullness;
// this is set to the smallest prime greater than twice the 
// expected number of records
private final int max = 50021; 

public HashTable(){
    	data = new ItemRecord[max];
    	fullness = 0;
	String args = "";
	args = ("-1,0,0,0,0,null,null");
    	deleted = new ItemRecord(args);
}

protected int hash1(ItemRecord target){
    	return target.getSKU() % data.length;
}

protected int hash2(ItemRecord target){
    	return 13 - (target.getSKU() % 13);
}

public int size(){
    	return fullness;
}

public ItemRecord find(int key){
	int start = key % data.length;
    	int i = start;
    	while (data[i] != null){
        	if(key == data[i].getSKU()){
            		return data[i];
        	}
        	i += (13 - (key % 13)) % data.length;
        	if(i == start){
            		break;

        	}
    	}
	System.out.println("\nSKU not found.\n");
    	return null;
}

public void insert(ItemRecord target){
	if(fullness >= data.length / 2){
        	rehash();
    	}
    	int start = hash1(target);
    	int i = start;
    	while(data[i] != null){
        	if(target.equals(data[i])){
            		return;
        	}
        	i = (i + hash2(target)) % data.length;
        	if(i == start){
            		return;
        	}
    	}
    	data[i] = target;
    	fullness++;
}

public void rehash(){
	HashTable newTable = new HashTable();
/*
 * Note: This could produce a bug if the rehash results in an array 
 * length that is not prime, so we'll want to eventually find a way
 * to find the next prime number after data.length * 2
 */
	newTable.data = new ItemRecord[data.length * 2];
	for(int i = 0; i<data.length; i++){
		if((data[i] != null) && (data[i] != deleted)){
			newTable.insert((ItemRecord)(data[i]));
		}
	}
	data = newTable.data;
	fullness = newTable.fullness;
}

public void delete(ItemRecord target){
   	int start = hash1(target);
   	int i = start;
   	while (data[i] != null){
        	if(target.equals(data[i])){
            		data[i] = deleted;
            		return;
        	}
        	i = (i + hash2(target)) % data.length;
        	if(i == start){
        		return;
        	}
	}
}

}
