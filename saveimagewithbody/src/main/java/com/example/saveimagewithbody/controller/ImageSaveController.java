package com.example.saveimagewithbody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.saveimagewithbody.service.ImageSaveService;
import com.example.saveimagewithbody.vo.ImageSaveVo;

@RestController
@RequestMapping("/image")
public class ImageSaveController<T> {
	@Autowired
	private ImageSaveService imageSaveService;

	@PostMapping("/saveImage")
	public ImageSaveVo saveImageInDB(
			@RequestPart ImageSaveVo imageSaveVo,
			@RequestPart MultipartFile file) {

//		ObjectMapper objectMapper = new ObjectMapper();
//		ImageSaveVo userDTO = objectMapper.readValue(imageSave, ImageSaveVo.class);
		return imageSaveService.saveImge(imageSaveVo,file);
		

	}

}
