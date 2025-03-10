package com.example.gymapplication.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gymapplication.backend.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
