package com.lecturesearch.lecture.OAuth2.password;


public class testPassword {

    public void test(){
        PasswordEncoding passwordEncoding = new PasswordEncoding();

        String rawPassword1 = "12345678";
        String rawPassword2 = "12345678";

        String newPassword1 = passwordEncoding.encode(rawPassword1);
        String newPassword2 = passwordEncoding.encode(rawPassword2);

        System.out.println("newPassword1 : "+newPassword1);
        System.out.println("newPassword2 : "+newPassword2);

        System.out.println("boolean : "+newPassword1==newPassword2);
        System.out.println("matches : "+passwordEncoding.matches(rawPassword2,newPassword1));
    }
}
