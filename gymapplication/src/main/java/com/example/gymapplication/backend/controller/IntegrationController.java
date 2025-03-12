package com.example.gymapplication.backend.controller;

import com.example.gymapplication.backend.model.LoginRequest;
import com.example.gymapplication.backend.model.ResultResponse;
import com.example.gymapplication.backend.model.Users;
import com.example.gymapplication.backend.model.Members;
import com.example.gymapplication.backend.model.MemberRequest;
import com.example.gymapplication.backend.repository.MemberRepository;
import com.example.gymapplication.backend.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class IntegrationController {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;

    // Constructor-based injection
    public IntegrationController(UserRepository userRepository, MemberRepository memberRepository) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;  // Initialize memberRepository
    }

    @PostMapping("/login")
    public ResponseEntity<ResultResponse> login(@RequestBody LoginRequest loginRequest) {
        // Search for the user by username
        Optional<Users> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            // Check if the password matches
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(new ResultResponse(200, "Success"));
            }
        }

        // If credentials don't match
        return ResponseEntity.status(401).body(new ResultResponse(401, "Invalid Credentials"));
    }

    @GetMapping("/listmembers")
    public List<Members> getAllMembers() {
        // Get all members from the database using the autowired memberRepository
        List<Members> members = memberRepository.findAll();  // Use memberRepository instance
        
        // Return only the required fields
        return members.stream().map(member -> {
            Members filteredMember = new Members();
            filteredMember.setId(member.getId());
            filteredMember.setFirstName(member.getFirstName());
            filteredMember.setLastName(member.getLastName());
            filteredMember.setEmail(member.getEmail());
            filteredMember.setPhone(member.getPhone());
            filteredMember.setJoinDate(member.getJoinDate());
            filteredMember.setAge(member.getAge());
            filteredMember.setName(member.getName());
            return filteredMember;
        }).collect(Collectors.toList());
    }

    @PostMapping("/addmembers")
    public ResponseEntity<Members> saveMember(@RequestBody MemberRequest memberRequest) {
        // Map the MemberRequest to Members entity
        Members newMember = new Members();
        newMember.setFirstName(memberRequest.getFirstName());
        newMember.setLastName(memberRequest.getLastName());
        newMember.setEmail(memberRequest.getEmail());
        newMember.setPhone(memberRequest.getPhone());
        newMember.setAge(memberRequest.getAge());
        newMember.setName(memberRequest.getName());
        newMember.setJoinDate(new java.util.Date());

        Members savedMember = memberRepository.save(newMember);

        return ResponseEntity.ok(savedMember);
    }

    @PostMapping("/editmember")
    public ResponseEntity<Members> editMember(@RequestBody MemberRequest memberRequest) {
        Members existingMember = memberRepository.findById(memberRequest.getId()).orElse(null);

        if (existingMember == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Update the existing member with new values
        existingMember.setFirstName(memberRequest.getFirstName());
        existingMember.setLastName(memberRequest.getLastName());
        existingMember.setEmail(memberRequest.getEmail());
        existingMember.setPhone(memberRequest.getPhone());
        existingMember.setAge(memberRequest.getAge());
        existingMember.setName(memberRequest.getName());

        Members updatedMember = memberRepository.save(existingMember);
        return ResponseEntity.ok(updatedMember);
    }

    @PostMapping("/deletemember")
    public ResponseEntity<ResultResponse> deleteMember(@RequestBody MemberRequest memberRequest) {
        Long id = memberRequest.getId();

        if (id == null) {
            return ResponseEntity.ok(new ResultResponse(401, "Missing 'id' parameter."));
        }

        if (!memberRepository.existsById(id)) {
            return ResponseEntity.ok(new ResultResponse(401, "Member not found."));
        }

        memberRepository.deleteById(id);
        return ResponseEntity.ok(new ResultResponse(200, "The Member have been done delete"));
    }

}
