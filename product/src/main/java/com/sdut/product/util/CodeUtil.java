package com.sdut.product.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CodeUtil
 * @Discription
 * @Author yinyuchen
 * @Date 2019/3/22 14:03
 **/

public final class CodeUtil {
//        public static void main(String[] args) {
//            String url = "http://www.baidu.com";
//            String path ="/img/";
//            String fileName = String.valueOf(System.currentTimeMillis()).substring(3,11)+ UUID.randomUUID().toString().replace("-","").substring(1,9)+".jpg";
//            createQrCode(url, path, fileName);
//        }

        public static String createQrCode(String url, String path, String fileName) {
            try {
                Map<EncodeHintType, String> hints = new HashMap<>();
                hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 400, 400, hints);
                File file = new File(path, fileName);
                if (file.exists() || ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
                    writeToFile(bitMatrix, "jpg", file);
                    System.out.println("-----" + file);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return fileName;
        }

        static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
            BufferedImage image = toBufferedImage(matrix);
            if (!ImageIO.write(image, format, file)) {
                throw new IOException("Could not write an image of format " + format + " to " + file);
            }
        }

        static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
            BufferedImage image = toBufferedImage(matrix);
            if (!ImageIO.write(image, format, stream)) {
                throw new IOException("Could not write an image of format " + format);
            }
        }

        private static final int BLACK = 0xFF000000;
        private static final int WHITE = 0xFFFFFFFF;

        private static BufferedImage toBufferedImage(BitMatrix matrix) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
                }
            }
            return image;
        }
    }
