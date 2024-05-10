package com.viuniteam.socialviuni.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viuniteam.socialviuni.dto.response.image.ImageResponse;
import com.viuniteam.socialviuni.entity.Image;
import com.viuniteam.socialviuni.service.ImageService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;

	@GetMapping
	public ResponseEntity<List<ImageResponse>> getAll() {
		return ResponseEntity.ok(imageService.getAll());
	}
}
