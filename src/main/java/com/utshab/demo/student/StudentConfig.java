// package com.utshab.demo.student;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.time.LocalDate;
// import java.util.List;

// @Configuration
// public class StudentConfig {

//     @Bean
//     CommandLineRunner commandLineRunner(StudentRepository repository){
//         return args -> {
//             Student roy = new Student(
//                     "Roy",
//                     "roy@mail.com",
//                     LocalDate.of(2017, 11, 30)
//             );
//             Student ashik = new Student(
//                     "Ashik",
//                     "ashik@mail.com",
//                     LocalDate.of(2000, 12, 12)
//             );

//             repository.saveAll(
//                     List.of(roy, ashik)
//             );
//         };
//     }
// }
