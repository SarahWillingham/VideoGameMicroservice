package com.scrybtye.vgmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrybtye.vgmicroservice.model.VideoGame;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {



}
