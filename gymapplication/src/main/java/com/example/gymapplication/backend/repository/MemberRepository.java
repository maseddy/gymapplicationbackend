package com.example.gymapplication.backend.repository;

import com.example.gymapplication.backend.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Members, Long> {
}
