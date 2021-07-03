package com.daysbetween.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysbetween.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
