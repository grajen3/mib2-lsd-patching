/*
 * Decompiled with CFR 0.152.
 */
import de.eso.mib.ImageSPIImpl;
import de.vw.mib.graphics.image.spi.NativeImage;
import java.io.File;

class Image_test {
    Image_test() {
    }

    public static void main(String[] stringArray) {
        if (stringArray.length < 1) {
            System.out.println("Usage: Image_test <directory>");
            return;
        }
        System.out.println(new StringBuffer().append("loading images from ").append(stringArray[0]).toString());
        File file = new File(stringArray[0]);
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            System.out.println("error getting files");
            return;
        }
        ImageSPIImpl imageSPIImpl = new ImageSPIImpl();
        imageSPIImpl.initNative();
        NativeImage[] nativeImageArray = new NativeImage[fileArray.length];
        for (int i2 = 0; i2 < fileArray.length; ++i2) {
            if (!fileArray[i2].isFile()) continue;
            String string = fileArray[i2].getName();
            System.out.println(new StringBuffer().append("loading file ").append(string).toString());
            try {
                nativeImageArray[i2] = imageSPIImpl.loadImageFromFile(new StringBuffer().append(stringArray[0]).append("/").append(string).toString(), 1, null);
                continue;
            }
            catch (Exception exception) {
                System.out.println("loading failed. ");
                exception.printStackTrace();
            }
        }
        System.out.println("done");
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        System.out.println("releasing images");
        for (int i3 = 0; i3 < fileArray.length; ++i3) {
            imageSPIImpl.releaseImage(nativeImageArray[i3].getBuffer());
            nativeImageArray[i3] = null;
        }
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        System.out.println("shutting down");
        imageSPIImpl.uninitNative();
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

