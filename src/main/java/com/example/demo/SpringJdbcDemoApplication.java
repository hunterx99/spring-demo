package com.example.demo;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	@Autowired
	private StudentDao studentDao;

	//private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		//studentDao.insert(new Student(100,"Abbs","abc@gmail.com"));
		//studentDao.insert(new Student(101,"ann","ann@gmail.com"));
		System.out.println(studentDao.findAll());
		//studentDao.deleteById(103);
		//System.out.println(studentDao.findAll());
		studentDao.update(new Student(100,"bro","bro@gmail.com"));
		System.out.println(studentDao.findAll());


	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

}
