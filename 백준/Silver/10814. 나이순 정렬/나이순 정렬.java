import java.io.*;
import java.util.*;

public class Main {
    public static class Member implements Comparable<Member> {
        String name; int age; int index;
        public Member(int age, String name, int index) {
            this.name = name;
            this.age = age;
            this.index = index;
        }
        public int compareTo(Member m) {
            if(this.age == m.age) return this.index - m.index;
            return this.age - m.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] member = buf.readLine().split(" ");
            members.add(new Member(Integer.parseInt(member[0]), member[1], i));
        }
        Collections.sort(members);
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).age + " " + members.get(i).name);
        }
    }
}