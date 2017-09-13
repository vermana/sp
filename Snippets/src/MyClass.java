 interface First {

    default void hello(){
        System.out.println("This is First");
    }
}

 interface Second extends First
 
 
 {

    default void hello(){
        System.out.println("This is Second");
    }
}

  public class MyClass implements First,Second {

    public static void main(String[] args) {
        new MyClass().hello();
    }
}