/*
 * Decompiled with CFR 0.152.
 */
import com.sun.opengl.util.BufferUtil;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLDrawableFactory;

public class JOGL_test {
    private int programObject;
    private GLDrawable drawable;
    private GLContext context;

    public static void main(String[] stringArray) {
        JOGL_test jOGL_test = new JOGL_test();
        jOGL_test.init();
        int n = 1000;
        while (n-- > 0) {
            jOGL_test.display();
        }
    }

    public void init() {
        GLDrawableFactory gLDrawableFactory = GLDrawableFactory.getFactory();
        this.drawable = gLDrawableFactory.getGLDrawable(null, null, null);
        this.context = this.drawable.createContext(null);
        this.context.makeCurrent();
        GL gL = this.context.getGL();
        System.err.println(new StringBuffer().append("INIT GL IS: ").append(super.getClass().getName()).toString());
        System.err.println(new StringBuffer().append("GL_VENDOR: ").append(gL.glGetString(7936)).toString());
        System.err.println(new StringBuffer().append("GL_RENDERER: ").append(gL.glGetString(7937)).toString());
        System.err.println(new StringBuffer().append("GL_VERSION: ").append(gL.glGetString(7938)).toString());
        gL.setSwapInterval(1);
        this.initShadersAndProgram(gL);
    }

    boolean initShadersAndProgram(GL gL) {
        String[] stringArray = new String[]{"attribute vec4 vPosition;", "void main()", "{", "  gl_Position = vPosition;", "}"};
        String[] stringArray2 = new String[]{"void main()", "{", "  gl_FragColor = vec4(0.0, 1.0, 0.0, 1.0);", "}"};
        int n = this.loadShader(gL, 831193088, stringArray);
        int n2 = this.loadShader(gL, 814415872, stringArray2);
        this.programObject = gL.glCreateProgram();
        if (this.programObject == 0) {
            return false;
        }
        gL.glAttachShader(this.programObject, n);
        gL.glAttachShader(this.programObject, n2);
        gL.glBindAttribLocation(this.programObject, 0, "vPosition");
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
        gL.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        return true;
    }

    int loadShader(GL gL, int n, String[] stringArray) {
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

    public void display() {
        float[] fArray = new float[]{0.0f, 63, 0.0f, 191, 191, 0.0f, 63, 191, 0.0f};
        FloatBuffer floatBuffer = BufferUtil.newFloatBuffer(fArray.length);
        floatBuffer.put(fArray);
        floatBuffer.rewind();
        GL gL = this.context.getGL();
        gL.glViewport(0, 0, 800, 480);
        gL.glClear(16384);
        gL.glUseProgram(this.programObject);
        gL.glVertexAttribPointer(0, 3, 5126, false, 0, floatBuffer);
        gL.glEnableVertexAttribArray(0);
        gL.glDrawArrays(4, 0, 3);
        this.drawable.swapBuffers();
    }

    static {
        System.loadLibrary("jogl");
    }
}

