package com.viuniteam.socialviuni.service.impl;

import com.viuniteam.socialviuni.dto.response.image.ImageResponse;
import com.viuniteam.socialviuni.dto.utils.Image.ImageResponseUtils;
import com.viuniteam.socialviuni.entity.Image;
import com.viuniteam.socialviuni.repository.ImageRepository;
import com.viuniteam.socialviuni.service.ImageService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageResponseUtils imageResponseUtils;
    @Override
    public Image findOneById(Long id) {
        return imageRepository.findOneById(id);
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

	@Override
	public List<ImageResponse> getAll() {
		List<Image> imageALl = imageRepository.findAll();
		List<ImageResponse> imageResponses = imageALl
				.stream()
				.map(imageResponseUtils::convert)
				.collect(Collectors.toList());
		return imageResponses;
	}
}
