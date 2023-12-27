/*
 * Decompiled with CFR 0.152.
 */
package de.eso.IconExtractor;

import de.eso.IconExtractor.IconExtractor$Bitmap;
import java.nio.ByteBuffer;

public class IconExtractor {
    private static final int NO_ERROR;
    private static final int NATIVE_ICONEXTRACTOR_NOT_FOUND;
    private static final int FUNCTION_RESOLUTION_FAILED;
    private static final int FRAMEWORK_INIT_FAILED;
    private static final int IMAGE_NOT_FOUND;
    private static final int JNI_ERROR;

    private static void explainError(int n) {
        switch (n) {
            case 0: {
                break;
            }
            case -1: {
                throw new RuntimeException("Native part of iconextractor could not be loaded. Check presence of libstyledbservice.so and its dependencies!");
            }
            case -2: {
                throw new RuntimeException("Native part of iconextractor was found, but methods could not be resolved. This is very unlikely to happen unless someone messed up the system or iconextracor interface was changed.");
            }
            case -3: {
                throw new RuntimeException("Framework initialization failed! Check that a valid framework.json is reachable via IPL_CONFIG_DIR, that process name 'styledbservice' is configured there and that the broker is running.");
            }
            case -4: {
                throw new RuntimeException("Image with specified id not found. This can have a lot of reasons. First, please check if a COMM connection to navigation process is working. If it is, please make sure that navigation really has an image with the requested id.");
            }
            case -5: {
                throw new RuntimeException("Well, something went terribly wrong in internal JNI communication. This is either an out-of-memory situation or a mismatch between java and native parts of iconextractor.");
            }
            default: {
                throw new RuntimeException(new StringBuffer().append("WTF: unhandled exception id ").append(n).toString());
            }
        }
    }

    public static void initialize() {
        System.loadLibrary("styledbservice");
        int n = IconExtractor.initializeIE();
        IconExtractor.explainError(n);
    }

    public static void shutdown() {
        IconExtractor.shutdownIE();
    }

    public static IconExtractor$Bitmap getImage(long l, long l2) {
        int[] nArray = new int[2];
        int n = IconExtractor.getSize(l, nArray);
        IconExtractor.explainError(n);
        if (nArray[0] == 0 && nArray[1] == 0) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(nArray[0] * nArray[1] * 4);
        n = IconExtractor.getData(l, byteBuffer, l2);
        IconExtractor.explainError(n);
        IconExtractor$Bitmap iconExtractor$Bitmap = new IconExtractor$Bitmap(nArray[0], nArray[1], byteBuffer);
        return iconExtractor$Bitmap;
    }

    public static IconExtractor$Bitmap getImage(long l) {
        return IconExtractor.getImage(l, (long)0);
    }

    public static IconExtractor$Bitmap getImage(String string, long l) {
        if (string == null) {
            throw new RuntimeException("String id is null!");
        }
        int[] nArray = new int[2];
        int n = IconExtractor.getSizeStr(string, nArray);
        IconExtractor.explainError(n);
        if (nArray[0] == 0 && nArray[1] == 0) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(nArray[0] * nArray[1] * 4);
        n = IconExtractor.getDataStr(string, byteBuffer, l);
        IconExtractor.explainError(n);
        IconExtractor$Bitmap iconExtractor$Bitmap = new IconExtractor$Bitmap(nArray[0], nArray[1], byteBuffer);
        return iconExtractor$Bitmap;
    }

    public static IconExtractor$Bitmap getImage(String string) {
        return IconExtractor.getImage(string, (long)0);
    }

    private static native int initializeIE() {
    }

    private static native void shutdownIE() {
    }

    private static native int getSize(long l, int[] nArray) {
    }

    private static native int getData(long l, ByteBuffer byteBuffer, long l2) {
    }

    private static native int getSizeStr(String string, int[] nArray) {
    }

    private static native int getDataStr(String string, ByteBuffer byteBuffer, long l) {
    }

    public static void main(String[] stringArray) {
        System.out.println("This is a iconextractor standalone test");
        IconExtractor.initialize();
        IconExtractor$Bitmap iconExtractor$Bitmap = IconExtractor.getImage(1L, (long)0);
        if (iconExtractor$Bitmap == null) {
            System.out.println("No bitmap found");
        } else {
            System.out.println(new StringBuffer().append("IconExtractor got bitmap of size ").append(iconExtractor$Bitmap.getWidth()).append("x").append(iconExtractor$Bitmap.getHeight()).toString());
        }
        IconExtractor.shutdown();
    }
}

