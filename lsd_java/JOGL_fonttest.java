/*
 * Decompiled with CFR 0.152.
 */
import com.sun.opengl.util.BufferUtil;
import de.eso.mib.FontSPIImpl;
import de.vw.mib.graphics.font.spi.NativeGlyph;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;

public class JOGL_fonttest
extends JOGL_testmain {
    private int programObject;
    private int fontstyle;

    public static void main(String[] stringArray) {
        int n = 0;
        if (stringArray.length > 0) {
            n = Integer.parseInt(stringArray[0]);
        }
        JOGL_fonttest jOGL_fonttest = new JOGL_fonttest(n);
        jOGL_fonttest.start();
    }

    JOGL_fonttest(int n) {
        this.fontstyle = n;
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
            FontSPIImpl fontSPIImpl = new FontSPIImpl();
            int n4 = fontSPIImpl.openFont(1, "VWNeoTech.ttf");
            int[] nArray = new int[2];
            fontSPIImpl.getControlBox(n4, 'A', 14, nArray);
            int n5 = nArray[0];
            int n6 = nArray[1];
            System.out.println(new StringBuffer().append(" printing 'A' with width = ").append(n5).append(" and height = ").append(n6).toString());
            NativeGlyph nativeGlyph = fontSPIImpl.getGlyph(n4, 'A', this.fontstyle, 14);
            ByteBuffer byteBuffer = nativeGlyph.bitmap.getBuffer();
            gL.glActiveTexture(-1065091072);
            gL.glBindTexture(3553, n3);
            gL.glPixelStorei(3317, 1);
            gL.glTexImage2D(3553, 0, 6409, nativeGlyph.bitmap.getWidth(), nativeGlyph.bitmap.getHeight(), 0, 6409, 5121, byteBuffer);
            int n7 = gL.glGetUniformLocation(this.programObject, "myTexture0");
            gL.glUniform1i(n7, n3);
            gL.glTexParameteri(3553, 10241, 9728);
            gL.glTexParameteri(3553, 10240, 9728);
            gL.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            fontSPIImpl.closeFont(n4);
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
        FloatBuffer floatBuffer = BufferUtil.newFloatBuffer(fArray.length);
        floatBuffer.put(fArray);
        floatBuffer.rewind();
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

