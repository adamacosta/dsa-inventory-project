/**
 * Copies the scanned in ArrayList<ItemRecord> into an Array.
 * 
 * @author Junko Kotake 
 */

package inventory;

public class ItemArray {

private ItemRecord[] records;
private final int max = 5000;
private int size;

public ItemArray() {
	records = new ItemRecord[max];
	size = 0;
}

public int size() {
	return size;
}
   
/** insert - insert new ItemRecord */
public void insert(ItemRecord newRecord) {
	int i = size;
	while (i > 0 && newRecord.getSKU() < records[i - 1].getSKU()) {
		records[i] = records[i - 1];
		i--;
	}
	records[i] = newRecord;
	size++;
}

/** find - find ItemRecord with keyValue 
 * Returns null if key not found
 */
public ItemRecord find(int key) {
	int lower = 0;
	int upper = size - 1;
	int middle;
	while (upper >= lower) {
		middle = (upper + lower) / 2;
		if (records[middle].getSKU() == key) {
			return records[middle];
		} else if (records[middle].getSKU() > key) {
			upper = middle - 1;
		} else {
			lower = middle + 1;
		}
	}
	return null;
}

/** delete - delete old ItemRecord */
public void delete(int key) {
	int i;
	for (i = 0; i < size; i++) {
		if (records[i].getSKU() == key) {
			break;
		}
	}
	for (int j = i; j < size; j++) {
		records[j] = records[j + 1];
	}
	size--;
}

}
