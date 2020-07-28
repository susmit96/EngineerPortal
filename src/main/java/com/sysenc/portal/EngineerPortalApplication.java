package com.sysenc.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EngineerPortalApplication implements CommandLineRunner{

//	public static void main(String[] args) {
//		SpringApplication.run(EngineerPortalApplication.class, args);
//	}

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(EngineerPortalApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Override
    public void run(String... args) {

        String password = "susmit41";

//        String digest = passwordEncoder.encode(password);
//        System.out.println("ハッシュ値 = " + digest);

        String digest = "$2y$11$3py8i.160iga/Ki0QnsJ7etwzJMBneLHunsk465M6Q5Iuf4KquBIm";

        if (passwordEncoder.matches(password, digest)) {
            System.out.println("一致したよ");
            return;
        }
        System.out.println("一致しなかったよ");
    }


}
