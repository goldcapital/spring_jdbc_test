package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        StudentRepository studentRepository = (StudentRepository) applicationContext.getBean("studentRepository");

        studentRepository.createTable();

           /* Student dto=new Student();
            dto.setName("vali");
            dto.setSurname("toshmat");
            dto.setCreatedDate(LocalDateTime.now())*/;

         //   studentRepository.save(dto);

//studentRepository.saveWithPrepareStatement(dto);

List <Student> list=studentRepository.getId(1);
for (Student student :list) {
    System.out.println(student);
}

    }
}
