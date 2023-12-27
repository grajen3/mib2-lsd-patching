/*
 * Decompiled with CFR 0.152.
 */
import com.sun.opengl.util.BufferUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class JOGL_testutils {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String[] getShaderSourceFromFile(String string) {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList(16);
        try {
            objectArray = new File(string);
            if (!objectArray.exists() || !objectArray.canRead()) {
                throw new IOException(new StringBuffer().append("File ").append(string).append(" cannot be found or read.").toString());
            }
            BufferedReader bufferedReader = null;
            try {
                String string2 = null;
                bufferedReader = new BufferedReader(new FileReader((File)objectArray));
                while ((string2 = bufferedReader.readLine()) != null) {
                    arrayList.add(string2);
                }
            }
            finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        objectArray = new String[arrayList.size()];
        objectArray = (String[])arrayList.toArray(objectArray);
        return objectArray;
    }

    static int loadShader(GL gL, int n, String[] stringArray) {
        IntBuffer intBuffer = BufferUtil.newIntBuffer(1);
        int n2 = gL.glCreateShader(n);
        if (n2 == 0) {
            return 0;
        }
        gL.glShaderSource(n2, stringArray.length, stringArray, null);
        gL.glCompileShader(n2);
        gL.glGetShaderiv(n2, -2121596928, intBuffer);
        if (intBuffer.get(0) == 0) {
            IntBuffer intBuffer2 = BufferUtil.newIntBuffer(1);
            gL.glGetShaderiv(n2, -2071265280, intBuffer2);
            if (intBuffer2.get(0) > 1) {
                ByteBuffer byteBuffer = BufferUtil.newByteBuffer(intBuffer2.get(0));
                IntBuffer intBuffer3 = BufferUtil.newIntBuffer(1);
                gL.glGetShaderInfoLog(n2, intBuffer2.get(0), intBuffer3, byteBuffer);
                System.out.println("Shader Compiler Error:");
                byteBuffer.rewind();
                for (int i2 = 0; i2 < intBuffer3.get(0); ++i2) {
                    System.out.print((char)byteBuffer.get());
                }
            }
            gL.glDeleteShader(n2);
            return 0;
        }
        return n2;
    }

    public static float[] createCube(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f2 - f5 / 2.0f;
        float f9 = f2 + f5 / 2.0f;
        float f10 = f3 - f6 / 2.0f;
        float f11 = f3 + f6 / 2.0f;
        float f12 = f4 + f7 / 2.0f;
        float f13 = f4 - f7 / 2.0f;
        float[] fArray = new float[]{f8, f11, f12, f9, f10, f12, f8, f10, f12, f8, f11, f12, f9, f11, f12, f9, f10, f12, f9, f11, f12, f9, f11, f13, f9, f10, f13, f9, f11, f12, f9, f10, f12, f9, f10, f12, f8, f11, f12, f8, f10, f12, f8, f11, f13, f8, f10, f12, f8, f10, f13, f8, f11, f13, f8, f11, f13, f9, f10, f13, f9, f11, f13, f8, f11, f13, f8, f10, f13, f9, f10, f13, f8, f10, f12, f9, f10, f13, f8, f10, f13, f8, f10, f12, f9, f10, f12, f9, f10, f13, f8, f11, f12, f8, f11, f13, f9, f11, f13, f8, f11, f12, f9, f11, f13, f9, f11, f12};
        return fArray;
    }
}

