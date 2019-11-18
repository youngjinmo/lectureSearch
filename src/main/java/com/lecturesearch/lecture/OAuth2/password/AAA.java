package com.lecturesearch.lecture.OAuth2.password;


public class AAA {

    public void test(){
        String rawPassword1 = "12345678";
        String rawPassword2 = "12345678";
        PasswordEncoding passwordEncoding = new PasswordEncoding();

        String newPassword1 = passwordEncoding.encode(rawPassword1);
        String newPassword2 = passwordEncoding.encode(rawPassword2);

        System.out.println("rawPassword1 : "+rawPassword1);
        System.out.println("rawPassword2 : "+rawPassword2);
        System.out.println("newPassword1 : "+newPassword1);
        System.out.println("newPassword2 : "+newPassword2);

        System.out.println("\n boolean : "+newPassword1==newPassword2);
    }
}
