package pom_Pages;

public class test {

	

    public static void main(String[] args) {
       
       String name="Nagaraj";
       String rev= "";
       
       for(int i=name.length()-1; i>=0; i++)
       {
           
           rev += rev.charAt(i);
       }
       System.out.println("rev");
    }
}
