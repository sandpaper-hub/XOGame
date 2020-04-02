package GUI_Ver;

import java.util.ArrayList;

public class Test {
    private ArrayList<Integer> a = new ArrayList<>();

    void fillArrayList() {
        for (int i = 0; i < 5; i++) {
            a.add(1);
        }
    }

    public ArrayList<Integer> getA() {
        return a;
    }

    void sumObjects () {
        int result = 0;
        for (int t : a) {
            result += t;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.fillArrayList();
        test.getA().set(2, 10);
        test.sumObjects();
    }
}
