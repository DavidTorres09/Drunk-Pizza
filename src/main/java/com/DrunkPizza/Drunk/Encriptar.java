package com.DrunkPizza.Drunk;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var claveArturito = encoder.encode("123");
        var claveJuan = encoder.encode("456");
        var claveLucia = encoder.encode("789");
        System.out.println("Arturito (123): "+claveArturito);
        System.out.println("Juan (456): "+claveJuan);
        System.out.println("Lucia (789): "+claveLucia);
        
    
    }
    
}
