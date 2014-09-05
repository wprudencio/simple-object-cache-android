Simple Object Cache Android
===========================

A simple cache for Objects in Android.

Usage Simple Object Cache Android
=====

```java
final String ID_BANDS = "bandsObejct";

// List of bands
ArrayList<String> bands = new ArrayList<String>();
bands.add("Arctic Monkeys");
bands.add("Led Zeppelin");
bands.add("Yann Tiersen");

// Saving
SimpleObjectCache.saveObject(bands, ID_BANDS, getApplicationContext());

// Retrieving
try {
	ArrayList<String> bandsTemp = (ArrayList<String>) SimpleObjectCache
			.loadObject(ID_BANDS, getApplicationContext());
	for (String string : bandsTemp) {
		Log.d("BANDS", string);
	}
} catch (FileNotFoundException e) {
	e.printStackTrace();
}

// Deleting
Boolean wasRemoved = SimpleObjectCache.removeObject(ID_BANDS,
		getApplicationContext());
```
