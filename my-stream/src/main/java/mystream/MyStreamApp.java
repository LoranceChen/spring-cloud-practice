//package mystream;
//
//@SpringBootApplication
//@EnableBinding(Sink.class)
//public class MyStreamApp {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MyStreamApp.class, args);
//    }
//
//    @StreamListener(Sink.INPUT)
//    public void handle(Person person) {
//        System.out.println("Received: " + person);
//    }
//
//    public static class Person {
//        private String name;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        public String toString() {
//            return this.name;
//        }
//    }
//}