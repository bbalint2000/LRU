import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] splitSentenceByWords(String str) {

        if (str == null || str.equals(""))
            return new String[0];

        String[] words = str.split("[ ,\\[\\]^_`{|}~]+");
        return words;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        int laphiba = 0;
        String[] input;
        String output = "";
        input = splitSentenceByWords(data);
        Keret a = new Keret("A", false, 0, 0);
        Keret b = new Keret("B", false, 0, 0);
        Keret c = new Keret("C", false, 0, 0);

        Keret[] cache = {a, b, c};


        for (int i = 0; i < input.length; i++) {
            int in = Math.abs(Integer.parseInt(input[i]));
            a.setCnt(a.getCnt()+1);
            b.setCnt(b.getCnt()+1);
            c.setCnt(c.getCnt()+1);
            if(a.getCnt() >3)
                a.setLock(false);
            if(b.getCnt() >3)
                b.setLock(false);
            if(c.getCnt() >3)
                c.setLock(false);

            if (cache[0].getValue() != in && cache[1].getValue() != in && cache[2].getValue() != in) {
                if (a.isLock() && b.isLock() && c.isLock()) {
                    laphiba++;
                    output += "*";
                    continue;
                } else {
                    if (!cache[0].isLock()) {
                        Keret temp = cache[0];
                        cache[0] = cache[1];
                        cache[1] = cache[2];
                        cache[2] = temp;
                        cache[2].setValue(in);
                       // cache[2].setLock(true);
                        cache[2].setCnt(0);
                        output += cache[2].getName();
                        laphiba++;
                        continue;
                    }
                    if (!cache[1].isLock()) {
                        Keret temp = cache[1];
                        cache[1] = cache[2];
                        cache[2] = temp;
                        cache[2].setValue(in);
                     //   cache[2].setLock(true);
                        cache[2].setCnt(0);
                        output += cache[2].getName();
                        laphiba++;
                        continue;
                    }
                    if (!cache[2].isLock()) {
                        cache[2].setValue(in);
                      //  cache[2].setLock(true);
                        cache[2].setCnt(0);
                        output += cache[2].getName();
                        laphiba++;
                        continue;
                    }
                }
            }
            if (cache[0].getValue() == in) {
                Keret temp = cache[0];
                cache[0] = cache[1];
                cache[1] = cache[2];
                cache[2] = temp;
                cache[2].setLock(false);
                output += "-";
                continue;
            }
            if (cache[1].getValue() == in) {
                Keret temp = cache[1];
                cache[1] = cache[2];
                cache[2] = temp;
                cache[2].setValue(in);
                cache[2].setLock(false);
                output += "-";
                continue;
            }
            if (cache[2].getValue() == in) {
                cache[2].setLock(false);
                output += "-";
                continue;
            }

        }
        System.out.println(output);
        System.out.println(laphiba);
    }
}
