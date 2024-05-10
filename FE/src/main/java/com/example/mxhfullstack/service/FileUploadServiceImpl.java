package com.example.mxhfullstack.service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUpload{
	private final Cloudinary cloudinary;

	@Override
	public String uploadFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return cloudinary.uploader()
				.upload(multipartFile.getBytes(),
						Map.of("public_id", UUID.randomUUID().toString()))
				.get("url")
				.toString();
	}
}
