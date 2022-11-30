import java.util.*;

class LexicographicSort {
    public static void main(String[] p) {
        Scanner u = new Scanner(System.in);
        int k, j, n = u.nextInt();
        while (n-- > 0) {
            String m = u.next();
            k = u.nextInt();
            List<String> l = new ArrayList<>();
            for (j = 0; j < k; j++) l.add(u.next());
            l.sort((a, b) -> {
                int z, x = a.length();
                z = b.length();
                for (int h = 0; h < Math.min(x, z); h++)
                    if (a.charAt(h) != b.charAt(h)) for (char c : m.toCharArray()) {
                        if (b.charAt(h) == c) return 1;
                        if (a.charAt(h) == c) return -1;
                    }
                return x - z;
            });
            for (String o : l) System.out.println(o);
        }
    }
}