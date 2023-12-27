/*
 * Decompiled with CFR 0.152.
 */
import de.eso.mib.DisplaySPIImpl;
import de.vw.mib.graphics.image.spi.NativeImage;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

class CDisplaySPITest {
    CDisplaySPITest() {
    }

    public static boolean analyseNI(NativeImage nativeImage, int n, int n2, int n3) {
        boolean bl = true;
        System.out.println("native image:");
        System.out.println(new StringBuffer().append("\twidth=").append(nativeImage.getWidth()).toString());
        System.out.println(new StringBuffer().append("\theight=").append(nativeImage.getHeight()).toString());
        System.out.println(new StringBuffer().append("\tformat=").append(nativeImage.getFormat()).toString());
        if (nativeImage.getWidth() != n) {
            System.out.println(new StringBuffer().append("error: expected width = ").append(n).append(" but returned NativeImage says width = ").append(nativeImage.getWidth()).toString());
            bl = false;
        }
        if (nativeImage.getHeight() != n2) {
            System.out.println(new StringBuffer().append("error: expected height = ").append(n2).append(" but returned NativeImage says height = ").append(nativeImage.getHeight()).toString());
            bl = false;
        }
        if (nativeImage.getFormat() != n3) {
            System.out.println(new StringBuffer().append("error: expected format = ").append(n3).append(" but returned NativeImage says format = ").append(nativeImage.getFormat()).toString());
            bl = false;
        }
        return bl;
    }

    public static boolean writeNI(NativeImage nativeImage, String string) {
        ByteBuffer byteBuffer = nativeImage.getBuffer();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            byte[] byArray = new byte[byteBuffer.limit()];
            byteBuffer.get(byArray);
            dataOutputStream.write(byArray);
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            System.out.println(new StringBuffer().append("IO error: ").append(iOException).toString());
            return false;
        }
        return true;
    }

    public static void main(String[] stringArray) {
        DisplaySPIImpl displaySPIImpl = new DisplaySPIImpl();
        displaySPIImpl.initDisplaySPI();
        System.out.println("this is the DisplaySPI stand alone test");
        System.out.println("calling 'getDisplayContent(0)'");
        long l = System.currentTimeMillis();
        NativeImage nativeImage = displaySPIImpl.getDisplayContent(0);
        long l2 = System.currentTimeMillis();
        if (nativeImage == null) {
            System.out.println("error: 'getDisplayContent(0)' returned null, NativeImage expected");
        } else {
            System.out.println(new StringBuffer().append("call took: ").append(l2 - l).append("ms").toString());
            if (CDisplaySPITest.analyseNI(nativeImage, 800, 480, 4356)) {
                System.out.println("test successful");
            } else {
                System.out.println("test failed");
            }
            System.out.println(new StringBuffer().append("writing result to /tmp/SPITest_getDisplayContent_0_").append(nativeImage.getWidth()).append("_").append(nativeImage.getHeight()).append(".raw").toString());
            CDisplaySPITest.writeNI(nativeImage, new StringBuffer().append("/tmp/SPITest_getDisplayContent_0_").append(nativeImage.getWidth()).append("_").append(nativeImage.getHeight()).append(".raw").toString());
        }
        System.out.println("calling 'getDisplayableContent(0, 16)'");
        l = System.currentTimeMillis();
        nativeImage = displaySPIImpl.getDisplayableContent(0, 16);
        l2 = System.currentTimeMillis();
        if (nativeImage == null) {
            System.out.println("error: 'getDisplayableContent(0, 16)' returned null, NativeImage expected");
        } else {
            System.out.println(new StringBuffer().append("call took: ").append(l2 - l).append("ms").toString());
            if (CDisplaySPITest.analyseNI(nativeImage, 800, 480, 4356)) {
                System.out.println("test successful");
            } else {
                System.out.println("test failed");
            }
            System.out.println(new StringBuffer().append("writing result to /tmp/getDisplayableContent_0_16_").append(nativeImage.getWidth()).append("_").append(nativeImage.getHeight()).append(".raw").toString());
            CDisplaySPITest.writeNI(nativeImage, new StringBuffer().append("/tmp/getDisplayableContent_0_16_").append(nativeImage.getWidth()).append("_").append(nativeImage.getHeight()).append(".raw").toString());
        }
        System.out.println("calling 'getDisplayableContent(0, 19)'");
        l = System.currentTimeMillis();
        nativeImage = displaySPIImpl.getDisplayableContent(0, 19);
        l2 = System.currentTimeMillis();
        if (nativeImage == null) {
            System.out.println("error: 'getDisplayableContent(0, 19)' returned null, NativeImage expected");
        } else {
            System.out.println(new StringBuffer().append("call took: ").append(l2 - l).append("ms").toString());
            if (CDisplaySPITest.analyseNI(nativeImage, 800, 480, 4356)) {
                System.out.println("test successful");
            } else {
                System.out.println("test failed");
            }
            System.out.println(new StringBuffer().append("writing result to /tmp/getDisplayableContent_0_19_").append(nativeImage.getWidth()).append("_").append(nativeImage.getHeight()).append(".raw").toString());
            CDisplaySPITest.writeNI(nativeImage, new StringBuffer().append("/tmp/getDisplayableContent_0_19_").append(nativeImage.getWidth()).append("_").append(nativeImage.getHeight()).append(".raw").toString());
        }
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

