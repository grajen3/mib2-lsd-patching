/*
 * Decompiled with CFR 0.152.
 */
import de.eso.mib.DebugSPIImpl;
import de.eso.mib.FileSPIImpl;
import de.eso.mib.FontSPIImpl;
import de.eso.mib.ImageSPIImpl;
import de.eso.mib.SPI;
import de.eso.mib.TimerSPIImpl;
import de.vw.mib.file.spi.ContentChunk;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.graphics.image.spi.NativeImageHeader;
import de.vw.mib.graphics.image.spi.NativeImageLoadingListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.Map;

class SPI_test {
    SPI_test() {
    }

    public void updateLogConfig(ByteBuffer byteBuffer) {
        System.out.println("received updateLogConfig via DebugListener interface");
    }

    static String chunkIDtoStr(int n) {
        byte[] byArray = new byte[]{(byte)n, (byte)(n >>> 8), (byte)(n >>> 16), (byte)(n >>> 24)};
        return new String(byArray);
    }

    public static void main(String[] stringArray) {
        try {
            Object object;
            int n;
            Object object2;
            Object object3;
            NativeImage nativeImage;
            Object object4;
            Object object5;
            Object object6;
            System.out.println("======= debugspi test =======");
            DebugSPIImpl debugSPIImpl = new DebugSPIImpl();
            byte[] byArray = new byte[]{0, 0, 1, 34, 58, -39, 45, -126, 1, 1, 10, 0, 72, 0, 97, 0, 108, 0, 108, 0, 111, 0};
            debugSPIImpl.writeLogEntry((short)257, byArray);
            System.out.println("======= filespi test ======= ");
            FileSPIImpl fileSPIImpl = FileSPIImpl.getInstance();
            System.out.println(new StringBuffer().append("abs path of . =").append(fileSPIImpl.getFileForRelativePath(".").getAbsolutePath()).toString());
            try {
                int n2 = fileSPIImpl.openContentFile("/eso/hmi/lsd/Resources/skin1/images.mcf", -1, true);
                int[] nArray = fileSPIImpl.getFilteredTOCFromContentFile(n2, 1229801248);
                object6 = fileSPIImpl.loadChunkFromContentFile(n2, 1229801248, nArray[0], true);
                try {
                    fileSPIImpl.loadChunkFromContentFile(n2, 1, 707529216, true);
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                fileSPIImpl.closeContentFile(n2);
                try {
                    fileSPIImpl.openContentFile("/eso/hmi/lsd/Resources/skin1/images.mcf", 666, true);
                    System.out.println("No, what happened? I expected this to fail.");
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println("OK.");
                }
                int n3 = fileSPIImpl.openContentFile("/eso/hmi/lsd/Resources/skin1/mcf.mcf", -1, true);
                Object[] objectArray = fileSPIImpl.loadObjectArrayFromContentFile(n3, 8);
                object5 = (int[])objectArray[0];
                System.out.println(new StringBuffer().append("ints: ").append(object5[0]).append(", ").append(object5[1]).toString());
                int n4 = fileSPIImpl.openContentFile("test.mcf", -1, true);
                int[] nArray2 = fileSPIImpl.getChunkTypesFromContentFile(n4);
                System.out.println(new StringBuffer().append("There are ").append(nArray2.length).append(" chunk types").toString());
                for (int i2 = 0; i2 < nArray2.length; ++i2) {
                    nArray = fileSPIImpl.getFilteredTOCFromContentFile(n4, nArray2[i2]);
                    System.out.println(new StringBuffer().append("There are ").append(nArray.length).append(" entries in ").append(SPI_test.chunkIDtoStr(nArray2[i2])).toString());
                    for (int i3 = 0; i3 < nArray.length; ++i3) {
                        object4 = fileSPIImpl.loadChunkFromContentFile(n4, nArray2[i2], nArray[i3], false);
                        System.out.println(new StringBuffer().append("ID: ").append(nArray[i3]).append(" Chunk header: ").append(((ContentChunk)object4).getHeader().capacity()).append(" Chunk data: ").append(((ContentChunk)object4).getData().capacity()).toString());
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println("======= fontspi test ======= ");
            FontSPIImpl fontSPIImpl = new FontSPIImpl();
            fontSPIImpl.initNative();
            int n5 = fontSPIImpl.openFont(1, "VWNeoTech.ttf");
            System.out.println(new StringBuffer().append("family=").append(fontSPIImpl.getFamilyName(n5)).toString());
            System.out.println(new StringBuffer().append("style=").append(fontSPIImpl.getStyleName(n5)).toString());
            System.out.println(new StringBuffer().append("asc,dsc=").append(fontSPIImpl.getAscender(n5, 14)).append(",").append(fontSPIImpl.getDescender(n5, 14)).toString());
            System.out.println(new StringBuffer().append("height=").append(fontSPIImpl.getHeight(n5, 14)).toString());
            System.out.println(new StringBuffer().append("kerning=").append(fontSPIImpl.getKerning(n5, '1', '2', 14)).toString());
            System.out.println(new StringBuffer().append("getMaxAdvanceWidth=").append(fontSPIImpl.getMaxAdvanceWidth(n5, 14)).toString());
            object6 = new int[2];
            fontSPIImpl.getControlBox(n5, 'X', 14, (int[])object6);
            System.out.println(new StringBuffer().append("ctrlbox=").append((int)object6[0]).append(",").append((int)object6[1]).toString());
            long l = System.currentTimeMillis();
            object5 = fontSPIImpl.getGlyph(n5, 'X', 0, 14);
            long l2 = System.currentTimeMillis();
            System.out.println(new StringBuffer().append("createGlyph took: ").append(l2 - l).append(" ms").toString());
            System.out.println(new StringBuffer().append("Unicode 'X' present? ").append(fontSPIImpl.isGlyphAvailable(n5, 'X')).toString());
            System.out.println(new StringBuffer().append("invalid Unicode U+ffff present? ").append(fontSPIImpl.isGlyphAvailable(n5, '\uffff0000')).toString());
            object5 = null;
            fontSPIImpl.closeFont(n5);
            fontSPIImpl.uninitNative();
            System.out.println("======= imagespi test ======= ");
            ImageSPIImpl imageSPIImpl = new ImageSPIImpl();
            imageSPIImpl.initNative();
            NativeImageHeader nativeImageHeader = imageSPIImpl.getImageHeaderFromFile("Backgrounds/Dummy_Kompass.png");
            System.out.println(new StringBuffer().append("Image header w,h=").append(nativeImageHeader.width).append(",").append(nativeImageHeader.height).toString());
            object4 = imageSPIImpl.loadImageFromFile("Backgrounds/Dummy_Kompass.png", 1, (NativeImageLoadingListener)new SPI_test$1());
            try {
                nativeImageHeader = imageSPIImpl.getImageHeaderFromFile("Backgrounds/Dummysdgsfdg_Kompass.png");
            }
            catch (Exception exception) {
                System.out.println("Exception thrown for non-existing image");
            }
            try {
                nativeImage = imageSPIImpl.loadImageFromFile("not/existing/path.png", 2, (NativeImageLoadingListener)new SPI_test$2());
            }
            catch (Exception exception) {
                System.out.println(new StringBuffer().append("path expetion: ").append(exception.toString()).toString());
            }
            System.out.println("path expetion done");
            System.out.println("Loading empty string");
            try {
                nativeImage = imageSPIImpl.loadImageFromFile("", 1, (NativeImageLoadingListener)new SPI_test$3());
            }
            catch (Exception exception) {
                System.out.println(new StringBuffer().append("Empty string: ").append(exception.toString()).toString());
            }
            try {
                nativeImage = imageSPIImpl.loadThumbnailImageFromFile("kodak-dc240.jpg");
                if (object4 == null) {
                    System.out.println("No thumbnail found");
                } else {
                    System.out.println(new StringBuffer().append("Thumbnail width: ").append(nativeImage.width).append(", height: ").append(nativeImage.height).toString());
                }
            }
            catch (Exception exception) {
                System.out.println("No thumbnail found");
            }
            nativeImage = imageSPIImpl.loadImageRegionFromFile("Backgrounds/Dummy_Kompass.png", 10, 10, 50, 50, (NativeImageLoadingListener)new SPI_test$4());
            System.out.println(new StringBuffer().append("Region loaded: w,h").append(nativeImage.getWidth()).append(" ").append(nativeImage.getHeight()).toString());
            NativeImage nativeImage2 = imageSPIImpl.loadImageFromFile("Backgrounds/Dummy_Kompass.png", 2, null);
            System.out.println(new StringBuffer().append("Image scale 2 w,h=").append(nativeImage2.width).append(",").append(nativeImage2.height).toString());
            NativeImage nativeImage3 = imageSPIImpl.loadImageFromFile("Backgrounds/Dummy_Kompass.png", 2, null);
            System.out.println(new StringBuffer().append("Image scale 2 w,h=").append(nativeImage3.width).append(",").append(nativeImage3.height).toString());
            Map map = imageSPIImpl.getExifFromFile("feier.jpg");
            System.out.println(new StringBuffer().append("Found ").append(map.size()).append(" exif entries").toString());
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int n6;
                object3 = (Integer)iterator.next();
                Object object7 = map.get(object3);
                if (object7 instanceof Long[]) {
                    object2 = (Long[])object7;
                    System.out.print(new StringBuffer().append(object3).append(": ").toString());
                    for (n6 = 0; n6 < ((Number[])object2).length; ++n6) {
                        System.out.print(new StringBuffer().append(object2[n6]).append(" / ").toString());
                    }
                    System.out.println("");
                    continue;
                }
                if (object7 instanceof Short[]) {
                    object2 = (Short[])object7;
                    System.out.print(new StringBuffer().append(object3).append(": ").toString());
                    for (n6 = 0; n6 < ((Number[])object2).length; ++n6) {
                        System.out.print(new StringBuffer().append(object2[n6]).append(" / ").toString());
                    }
                    System.out.println("");
                    continue;
                }
                if (object7 instanceof Long[][]) {
                    object2 = (Long[][])object7;
                    System.out.print(new StringBuffer().append(object3).append(": ").toString());
                    for (n6 = 0; n6 < ((Number[])object2).length; ++n6) {
                        for (int i4 = 0; i4 < ((Number)object2[n6]).length; ++i4) {
                            System.out.print(new StringBuffer().append(object2[n6][i4]).append(" / ").toString());
                        }
                        System.out.print("/ ");
                    }
                    System.out.println("");
                    continue;
                }
                System.out.println(new StringBuffer().append(object3).append(": ").append(object7).toString());
            }
            object3 = new int[]{305, 306, 0xA00000};
            map = imageSPIImpl.getExifFromFile("feier.jpg", 0, (int[])object3);
            System.out.println(new StringBuffer().append("Found ").append(map.size()).append(" exif entries").toString());
            for (n = 2; n < 4; ++n) {
                try {
                    object2 = imageSPIImpl.loadImageFromSkin(1, n);
                    System.out.println(new StringBuffer().append("MIF image skin 1 id ").append(n).append(" width: ").append(object2.width).append(", height: ").append(object2.height).toString());
                    continue;
                }
                catch (Exception exception) {
                    System.out.println("MIF image skin 1 failed: ");
                    exception.printStackTrace();
                }
            }
            for (n = 2; n < 4; ++n) {
                try {
                    imageSPIImpl.setMultiImageFileForSkin(0, "Images/test.mif");
                    object2 = imageSPIImpl.loadImageFromSkin(0, n);
                    System.out.println(new StringBuffer().append("MIF image skin 0 id ").append(n).append(" width: ").append(object2.width).append(", height: ").append(object2.height).toString());
                    continue;
                }
                catch (Exception exception) {
                    System.out.println("MIF image skin 0 failed: ");
                    exception.printStackTrace();
                }
            }
            try {
                object = imageSPIImpl.getImageHeaderFromFile(11);
                System.out.println(new StringBuffer().append("icon width (header): ").append(((NativeImageHeader)object).width).append(", height: ").append(((NativeImageHeader)object).height).toString());
                object2 = imageSPIImpl.loadImageFromFile(11, 1, null);
                System.out.println(new StringBuffer().append("icon width (loaded): ").append(object2.width).append(", height: ").append(object2.height).toString());
            }
            catch (Exception exception) {
                System.out.println(new StringBuffer().append("IconExtractor: ").append(exception.toString()).toString());
            }
            imageSPIImpl.uninitNative();
            System.out.println("======= timerspi test ======= ");
            object = new TimerSPIImpl();
            long l3 = object.getSystemTime();
            System.out.println(new StringBuffer().append("timerspi ticks per second =").append(object.getSystemTimeFrequency()).toString());
            System.out.println("sleeping 0.75 seconds");
            Thread.sleep(0);
            long l4 = object.getSystemTime();
            System.out.println(new StringBuffer().append("timerspi t0=").append(l3).append(", t1=").append(l4).append(", diff=").append(l4 - l3).toString());
            System.out.println("Testing NativeImage finalize");
            object4 = null;
            nativeImageHeader = null;
            System.out.println("Testing NativeImage finalize: called gc, waiting 2000ms");
            System.gc();
            Thread.sleep(0);
            System.out.println("Testing NativeImage finalize; done");
            System.out.println("======= test =======");
            boolean bl = false;
            IntBuffer intBuffer = ByteBuffer.allocateDirect(16).asIntBuffer();
            IntBuffer intBuffer2 = ByteBuffer.allocateDirect(4).asIntBuffer();
            IntBuffer intBuffer3 = ByteBuffer.allocateDirect(4).asIntBuffer();
            int n7 = 512;
            System.out.println("test: allocating direct buffer + asFloat");
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(32);
            FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
            System.out.println("test: putting values");
            float[] fArray = new float[]{1.0f, 2.0f, 16448, 32832, 41024};
            floatBuffer.put(fArray);
            System.out.println("test: rewind");
            floatBuffer.rewind();
            System.out.println("test: calling process data");
            float f2 = 0.0f;
            f2 = SPI.process_data(floatBuffer, 5);
            for (int i5 = 0; i5 < 5; ++i5) {
                System.out.println(new StringBuffer().append("buf[").append(i5).append("]=").append(floatBuffer.get(i5)).toString());
            }
            IntBuffer intBuffer4 = ByteBuffer.allocateDirect(16).asIntBuffer();
            SPI.dosthi(intBuffer4);
            ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(16);
            SPI.dosthv(byteBuffer2);
        }
        catch (InterruptedException interruptedException) {
            System.out.println("caught InterruptedException");
            interruptedException.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("caught FileNotFoundException");
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            System.out.println("caught IOException");
            iOException.printStackTrace();
        }
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

