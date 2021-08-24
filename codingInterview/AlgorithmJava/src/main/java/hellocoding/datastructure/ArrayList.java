package hellocoding.datastructure;

public class ArrayList implements DataStructure {
    private int[] array;
    private int length;

    public ArrayList(int num) {
        this.array = new int[num];
        this.length = 0;
    }


    @Override
    public int[] insert(int num) {
        this.array[this.length] = num;
        this.length++;
        return this.array;
    }

    public int[] insertWithIndex(int num, int index) {
        if (index >= this.length) {
            return null;
        } else {
            if (this.length < this.array.length) {
                for (int i = length; i > index; i--) {
                    this.array[i] = this.array[i - 1];
                }
                this.array[index] = num;
                this.length++;
            } else {
                for (int i = length - 1; i > index; i--) {
                    this.array[i] = this.array[i - 1];
                }
            }
        }
        return this.array;
    }

    @Override
    public void print() {
        System.out.println("ArrayList length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            System.out.printf("%5d", this.array[i]);
        }
        System.out.println();
    }

    @Override
    public int delete(int num) {
        int searchedIndex = search(num);
        if (searchedIndex != -1) {
            for (int i = searchedIndex; i < this.length - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.length--;
            return num;
        } else {
            return -1;
        }
    }

    @Override
    public Integer search(int num) {
        for (int i = 0; i < this.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
