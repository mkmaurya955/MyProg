package com.example.saveimagewithbody.serviceImpl;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.saveimagewithbody.repository.ImageSaveRepository;
import com.example.saveimagewithbody.service.ImageSaveService;
import com.example.saveimagewithbody.vo.ImageSaveVo;

@Service
public class ImageSaveServiceImpl implements ImageSaveService {

	@Autowired
	private ImageSaveRepository imageSaveRepository;

	@Override
	public ImageSaveVo saveImge(ImageSaveVo imageSaveVo,MultipartFile file) {

		ImageSaveVo imag = new ImageSaveVo();
		
		imag.setFirstName(imageSaveVo.getFirstName());

		imag.setDeptName(imageSaveVo.getDeptName());
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("Not a valid file");
		}
		try {
//			imag.setImageData(ImageUtil.compressImage(file.getBytes()));
			imag.setImageData(Base64.getEncoder().encodeToString(file.getBytes()));
			// if we use byte array entity then
//			imag.setImageData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageSaveRepository.save(imag);

	}

}
