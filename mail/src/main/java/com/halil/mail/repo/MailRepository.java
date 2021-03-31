package com.halil.mail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halil.mail.entity.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

}
