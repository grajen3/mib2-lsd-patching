/*
 * Decompiled with CFR 0.152.
 */
import com.sun.opengl.util.BufferUtil;
import de.eso.mib.ImageSPIImpl;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.graphics.image.spi.NativeImageHeader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import org.dsi.ifc.global.ResourceLocator;

public class JOGL_textest
extends JOGL_testmain {
    private int programObject;

    public static void main(String[] stringArray) {
        JOGL_textest jOGL_textest = new JOGL_textest();
        jOGL_textest.start();
    }

    private IntBuffer loadTexture(GL gL, int n, int n2) {
        int[] nArray = new int[n * n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n; ++i3) {
                int n3;
                int n4;
                int n5;
                int n6;
                if (i3 < 32) {
                    n6 = 255;
                    n5 = 255;
                    n4 = 255;
                    n3 = 255;
                } else if (i3 < 64) {
                    n6 = 255;
                    n5 = 0;
                    n4 = 0;
                    n3 = 255;
                } else if (i3 < 96) {
                    n6 = 0;
                    n5 = 255;
                    n4 = 0;
                    n3 = 255;
                } else {
                    n6 = 0;
                    n5 = 0;
                    n4 = 255;
                    n3 = 255;
                }
                nArray[i2 * n + i3] = n3 << 24 | n4 << 16 | n5 << 8 | n6;
            }
        }
        IntBuffer intBuffer = BufferUtil.newIntBuffer(nArray.length);
        intBuffer.put(nArray);
        intBuffer.rewind();
        return intBuffer;
    }

    @Override
    boolean initShadersAndProgram() {
        try {
            GL gL = this.context.getGL();
            String[] stringArray = JOGL_testutils.getShaderSourceFromFile("./shader/texturing.vert");
            String[] stringArray2 = JOGL_testutils.getShaderSourceFromFile("./shader/texturing.frag");
            int n = JOGL_testutils.loadShader(gL, 831193088, stringArray);
            int n2 = JOGL_testutils.loadShader(gL, 814415872, stringArray2);
            this.programObject = gL.glCreateProgram();
            if (this.programObject == 0) {
                return false;
            }
            gL.glAttachShader(this.programObject, n);
            gL.glAttachShader(this.programObject, n2);
            gL.glLinkProgram(this.programObject);
            IntBuffer intBuffer = BufferUtil.newIntBuffer(1);
            gL.glGetProgramiv(this.programObject, -2104819712, intBuffer);
            if (intBuffer.get(0) == 0) {
                IntBuffer intBuffer2 = BufferUtil.newIntBuffer(1);
                gL.glGetProgramiv(this.programObject, -2071265280, intBuffer2);
                if (intBuffer2.get(0) > 1) {
                    ByteBuffer byteBuffer = BufferUtil.newByteBuffer(intBuffer2.get(0));
                    IntBuffer intBuffer3 = BufferUtil.newIntBuffer(1);
                    gL.glGetProgramInfoLog(this.programObject, intBuffer2.get(0), intBuffer3, byteBuffer);
                    byteBuffer.rewind();
                    for (int i2 = 0; i2 < intBuffer3.get(0); ++i2) {
                        System.out.print((char)byteBuffer.get());
                    }
                }
                gL.glDeleteProgram(this.programObject);
                return false;
            }
            gL.glBindAttribLocation(this.programObject, 0, "vPosition");
            gL.glBindAttribLocation(this.programObject, 1, "vTexCoord");
            IntBuffer intBuffer4 = BufferUtil.newIntBuffer(1);
            gL.glGenTextures(1, intBuffer4);
            int n3 = intBuffer4.get(0);
            ImageSPIImpl imageSPIImpl = new ImageSPIImpl();
            ResourceLocator resourceLocator = new ResourceLocator("Backgrounds/Dummy_Kompass.png");
            NativeImageHeader nativeImageHeader = imageSPIImpl.getImageHeaderFromResource(resourceLocator);
            int n4 = nativeImageHeader.width;
            int n5 = nativeImageHeader.height;
            System.out.println(new StringBuffer().append("Image header w,h=").append(nativeImageHeader.width).append(",").append(nativeImageHeader.height).toString());
            NativeImage nativeImage = imageSPIImpl.loadImageFromResource(resourceLocator, 1, new JOGL_textest$1(this));
            ByteBuffer byteBuffer = nativeImage.getBuffer();
            gL.glActiveTexture(-1065091072);
            gL.glBindTexture(3553, n3);
            gL.glTexImage2D(3553, 0, 6408, n4, n5, 0, 6408, 5121, byteBuffer);
            int n6 = gL.glGetUniformLocation(this.programObject, "myTexture0");
            gL.glUniform1i(n6, n3);
            gL.glTexParameteri(3553, 10241, 9729);
            gL.glTexParameteri(3553, 10240, 9729);
            gL.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("caught FileNotFoundException");
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            System.out.println("caught IOException");
            iOException.printStackTrace();
        }
        return true;
    }

    @Override
    public void display() {
        float[] fArray = new float[]{191, 191, 0.0f, 191, 63, 0.0f, 63, 191, 0.0f, 63, 63, 0.0f};
        FloatBuffer floatBuffer = FloatBuffer.wrap(fArray);
        float[] fArray2 = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        FloatBuffer floatBuffer2 = BufferUtil.newFloatBuffer(fArray2.length);
        floatBuffer2.put(fArray2);
        floatBuffer2.rewind();
        GL gL = this.context.getGL();
        gL.glViewport(0, 0, 800, 480);
        gL.glClear(16384);
        gL.glUseProgram(this.programObject);
        gL.glVertexAttribPointer(0, 3, 5126, false, 0, floatBuffer);
        gL.glEnableVertexAttribArray(0);
        gL.glVertexAttribPointer(1, 2, 5126, false, 0, floatBuffer2);
        gL.glEnableVertexAttribArray(1);
        gL.glDrawArrays(5, 0, 4);
    }
}

