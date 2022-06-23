package by.iba.service.impl;

import by.iba.constants.Constant;
import by.iba.entity.sparepart.Image;
import by.iba.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public Image getDefaultImage() {
        final Image image = new Image();
        image.setImageUrl(Constant.DEFAULT_IMAGE_URL);

        return image;
    }
}
