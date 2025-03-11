package com.example.gymapplication.backend.model;
import com.example.gymapplication.backend.model.Members;
import com.example.gymapplication.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Members> getAllMembers() {
        return memberRepository.findAll();
    }
}

