package Utils;

public class DynamicArray<G> {

    //From class code examples (https://moodle.wit.ie/mod/folder/view.php?id=2983768&forceview=1)
    @SuppressWarnings("unchecked")
    private G[] mainArray = (G[])new Object[10];
    private int arrayIndex = 0;

    @SuppressWarnings("unchecked")
    public void addData(G data) {
        if (arrayIndex >= mainArray.length) {
            G[] newArray = (G[])new Object[(int)(mainArray.length * 2)];
            for(int i = 0; i < mainArray.length; i++) {
                mainArray = newArray;
            }
            mainArray[arrayIndex] = data;
            arrayIndex++;
        }
    }
    public G getData(int getterIndex) {
        return mainArray[getterIndex];
    }
    public int size() {
        return mainArray.length;
    }
}
