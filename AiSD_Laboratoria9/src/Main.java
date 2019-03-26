
public class Main {
    public static void main(String[] args){
        HashArray<String, Student> hash = new HashArray<>();
       // DoubleHashArray<String, Student> dhash = new DoubleHashArray<>();

        Student s1 = new Student("238006", "Jan", "Kowalski");
        Student s2 = new Student("238099", "Mariusz", "Kowalczyk");
        Student s3 = new Student("238119", "Andrzej", "Nowak");
        Student s4 = new Student("238117", "Piotr", "Rubik");
        Student s5 = new Student("238100", "Andrzej", "WOlny");
        Student s6 = new Student("238999", "Karol", "Wisniewski");
        Student s7 = new Student("238988", "Mikolaj", "Konieczny");
        Student s8 = new Student("238222", "Johny", "Deep");

        System.out.println("Adresowanie kwadratowe:");
        hash.put(s1.index, s1);
        hash.put(s2.index, s2);
        hash.put(s3.index, s3);
        //hash.dump();
        hash.put(s4.index, s4);
        //hash.dump();
        hash.put(s5.index, s5);
        hash.put(s6.index, s6);
        hash.put(s7.index, s7);
        hash.put(s8.index, s8);
        hash.dump();
        System.out.println();
        System.out.println("Metoda get: "+hash.get("238999"));

        ///////

        /*System.out.println("Hashowanie dwukrotne:");
        dhash.put(s1.index, s1);
        dhash.put(s2.index, s2);
        dhash.put(s3.index, s3);
        //dhash.dump();
        dhash.put(s4.index, s4);
        dhash.dump();
        dhash.put(s5.index, s5);
        dhash.put(s6.index, s6);
        dhash.put(s7.index, s7);
        //dhash.put(s8.index, s8);
        //dhash.dump();
        System.out.println(dhash.get("238999"));
		*/
    }
}
