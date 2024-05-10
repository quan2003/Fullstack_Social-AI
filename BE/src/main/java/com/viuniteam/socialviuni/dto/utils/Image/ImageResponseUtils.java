package com.viuniteam.socialviuni.dto.utils.Image;

import org.springframework.stereotype.Component;

import com.viuniteam.socialviuni.dto.response.image.ImageResponse;
import com.viuniteam.socialviuni.dto.utils.ResponseUtilsAdapter;
import com.viuniteam.socialviuni.entity.Image;
import com.viuniteam.socialviuni.mapper.response.image.ImageReponseMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ImageResponseUtils extends ResponseUtilsAdapter<Image, ImageResponse>{
	private final ImageReponseMapper imageReponseMapper;
	
	@Override
	public ImageResponse convert(Image obj) {
		ImageResponse imageResponse = imageReponseMapper.from(obj);
		return imageResponse;
	}

}
