package com.viuniteam.socialviuni.service;

import java.util.List;

import com.viuniteam.socialviuni.dto.response.image.ImageResponse;
import com.viuniteam.socialviuni.entity.Image;

public interface ImageService {
    Image findOneById(Long id);
    Image save(Image image);
    List<ImageResponse> getAll();
    void deleteById(Long id);
}
