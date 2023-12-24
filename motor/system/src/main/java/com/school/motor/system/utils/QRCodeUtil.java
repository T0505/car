package com.school.motor.system.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author T
 * 二维码生成
 */
public class QRCodeUtil {

    public static boolean generate(Object data,String path,int size) {

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(data.toString(), BarcodeFormat.QR_CODE, size, size, hints);
            BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            ImageIO.write(image, "png", new File(path + ".png"));
            return true;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean generate(Object data) {
        return generate(data,"code",300);
    }
}
