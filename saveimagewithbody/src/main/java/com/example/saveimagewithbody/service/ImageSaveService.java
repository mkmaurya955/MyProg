package com.example.saveimagewithbody.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.saveimagewithbody.vo.ImageSaveVo;

public interface ImageSaveService {

	ImageSaveVo saveImge(ImageSaveVo imageSaveVo, MultipartFile file);

}
