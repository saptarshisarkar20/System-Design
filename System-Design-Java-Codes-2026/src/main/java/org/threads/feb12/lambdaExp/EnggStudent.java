package org.threads.feb12.lambdaExp;

class EnggStudent {
    public static void main(String[] args) {
        // Old way of implementation
        Student engg = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is a Engg Student";
            }
        };

        // modern way of implementation
        Student laww = name -> name + " is a Law student";


        System.out.println(engg.getBio("Ramendra"));
        System.out.println(laww.getBio("Rajendra"));

    }
}