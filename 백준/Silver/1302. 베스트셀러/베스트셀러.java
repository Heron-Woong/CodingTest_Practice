import java.io.*;
import java.util.*;

public class Main {
    public static class Book {
        String name; int count;
        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            hm.put(temp, hm.getOrDefault(temp, 0)+1);
        }
        ArrayList<Book> books = new ArrayList<>();
        for (String s : hm.keySet()) {
            books.add(new Book(s, hm.get(s)));
        }
        Collections.sort(books, (b1, b2) -> {
            if(b1.count == b2.count) return b1.name.compareTo(b2.name);
            return b2.count - b1.count;
        });
        System.out.println(books.get(0).name);
    }
}