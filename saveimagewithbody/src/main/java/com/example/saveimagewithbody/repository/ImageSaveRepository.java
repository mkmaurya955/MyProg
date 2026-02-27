package com.example.saveimagewithbody.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saveimagewithbody.vo.ImageSaveVo;

@Repository
public interface ImageSaveRepository extends JpaRepository<ImageSaveVo, Long>{

}
