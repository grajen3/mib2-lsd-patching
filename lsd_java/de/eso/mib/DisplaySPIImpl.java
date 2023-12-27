/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import de.eso.mib.SPI;
import de.vw.mib.graphics.display.spi.DisplaySPI;
import de.vw.mib.graphics.image.spi.NativeImage;
import java.nio.ByteBuffer;

public class DisplaySPIImpl
implements DisplaySPI {
    public boolean initDisplaySPI() {
        int n = SPI.initDisplaySPI();
        boolean bl = false;
        if (n == 1) {
            bl = true;
        }
        return bl;
    }

    @Override
    public Object getNativeDisplayableHandle(int n, int n2) {
        return new Integer(n);
    }

    @Override
    public NativeImage getDisplayableContent(int n, int n2) {
        int[] nArray = new int[3];
        ByteBuffer byteBuffer = SPI.getDisplayableContent(n, n2, nArray, 0, nArray, 1, nArray, 2);
        if (byteBuffer == null) {
            System.out.println("DisplaySPI::getDisplayableContent: native call returned null");
            return null;
        }
        byteBuffer.rewind();
        NativeImage nativeImage = new NativeImage(byteBuffer, nArray[0], nArray[1], 4356);
        return nativeImage;
    }

    @Override
    public NativeImage getDisplayableContent(int n, int n2, int n3, int n4, int n5, int n6) {
        int[] nArray = new int[3];
        ByteBuffer byteBuffer = SPI.getDisplayableContentP(n, n2, n3, n4, n5, n6, nArray, 0, nArray, 1, nArray, 2);
        if (byteBuffer == null) {
            System.out.println("DisplaySPI::getDisplayableContentP: native call returned null");
            return null;
        }
        byteBuffer.rewind();
        NativeImage nativeImage = new NativeImage(byteBuffer, nArray[0], nArray[1], 4356);
        return nativeImage;
    }

    @Override
    public void releaseContent(ByteBuffer byteBuffer) {
        BufferFactory.dispose(byteBuffer);
    }

    @Override
    public NativeImage getDisplayContent(int n) {
        int[] nArray = new int[3];
        ByteBuffer byteBuffer = SPI.getDisplayContent(n, nArray, 0, nArray, 1, nArray, 2);
        if (byteBuffer == null) {
            System.out.println("DisplaySPI::getDisplayContent: native call returned null");
            return null;
        }
        byteBuffer.rewind();
        NativeImage nativeImage = new NativeImage(byteBuffer, nArray[0], nArray[1], 4356);
        return nativeImage;
    }

    @Override
    public void releaseContent(NativeImage nativeImage) {
        if (nativeImage != null) {
            BufferFactory.dispose(nativeImage.getBuffer());
        }
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

