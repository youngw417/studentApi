package com.example.SpringApplication.repo;

import com.example.SpringApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
