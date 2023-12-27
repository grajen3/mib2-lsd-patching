/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import com.sun.opengl.impl.GLImpl;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class DebugGL
implements GL {
    private GLContext _context;
    private GL downstreamGL;

    public DebugGL(GL gL) {
        if (gL == null) {
            throw new IllegalArgumentException("null downstreamGL");
        }
        this.downstreamGL = gL;
        if (gL instanceof GLImpl) {
            this._context = ((GLImpl)gL).getContext();
        }
    }

    @Override
    public void glActiveTexture(int n) {
        this.checkContext();
        this.downstreamGL.glActiveTexture(n);
        this.checkGLGetError("glActiveTexture");
    }

    @Override
    public void glAttachShader(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glAttachShader(n, n2);
        this.checkGLGetError("glAttachShader");
    }

    @Override
    public void glBindAttribLocation(int n, int n2, String string) {
        this.checkContext();
        this.downstreamGL.glBindAttribLocation(n, n2, string);
        this.checkGLGetError("glBindAttribLocation");
    }

    @Override
    public void glBindBuffer(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBindBuffer(n, n2);
        this.checkGLGetError("glBindBuffer");
    }

    @Override
    public void glBindFramebuffer(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBindFramebuffer(n, n2);
        this.checkGLGetError("glBindFramebuffer");
    }

    @Override
    public void glBindRenderbuffer(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBindRenderbuffer(n, n2);
        this.checkGLGetError("glBindRenderbuffer");
    }

    @Override
    public void glBindTexture(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBindTexture(n, n2);
        this.checkGLGetError("glBindTexture");
    }

    @Override
    public void glBlendColor(float f2, float f3, float f4, float f5) {
        this.checkContext();
        this.downstreamGL.glBlendColor(f2, f3, f4, f5);
        this.checkGLGetError("glBlendColor");
    }

    @Override
    public void glBlendEquation(int n) {
        this.checkContext();
        this.downstreamGL.glBlendEquation(n);
        this.checkGLGetError("glBlendEquation");
    }

    @Override
    public void glBlendEquationSeparate(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBlendEquationSeparate(n, n2);
        this.checkGLGetError("glBlendEquationSeparate");
    }

    @Override
    public void glBlendFunc(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBlendFunc(n, n2);
        this.checkGLGetError("glBlendFunc");
    }

    @Override
    public void glBlendFuncSeparate(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glBlendFuncSeparate(n, n2, n3, n4);
        this.checkGLGetError("glBlendFuncSeparate");
    }

    @Override
    public void glBufferData(int n, int n2, Buffer buffer, int n3) {
        this.checkContext();
        this.downstreamGL.glBufferData(n, n2, buffer, n3);
        this.checkGLGetError("glBufferData");
    }

    @Override
    public void glBufferSubData(int n, int n2, int n3, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glBufferSubData(n, n2, n3, buffer);
        this.checkGLGetError("glBufferSubData");
    }

    @Override
    public int glCheckFramebufferStatus(int n) {
        this.checkContext();
        int n2 = this.downstreamGL.glCheckFramebufferStatus(n);
        this.checkGLGetError("glCheckFramebufferStatus");
        return n2;
    }

    @Override
    public void glClear(int n) {
        this.checkContext();
        this.downstreamGL.glClear(n);
        this.checkGLGetError("glClear");
    }

    @Override
    public void glClearColor(float f2, float f3, float f4, float f5) {
        this.checkContext();
        this.downstreamGL.glClearColor(f2, f3, f4, f5);
        this.checkGLGetError("glClearColor");
    }

    @Override
    public void glClearDepthf(float f2) {
        this.checkContext();
        this.downstreamGL.glClearDepthf(f2);
        this.checkGLGetError("glClearDepthf");
    }

    @Override
    public void glClearStencil(int n) {
        this.checkContext();
        this.downstreamGL.glClearStencil(n);
        this.checkGLGetError("glClearStencil");
    }

    @Override
    public void glColorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.checkContext();
        this.downstreamGL.glColorMask(bl, bl2, bl3, bl4);
        this.checkGLGetError("glColorMask");
    }

    @Override
    public void glCompileShader(int n) {
        this.checkContext();
        this.downstreamGL.glCompileShader(n);
        this.checkGLGetError("glCompileShader");
    }

    @Override
    public void glCompressedTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glCompressedTexImage2D(n, n2, n3, n4, n5, n6, n7, buffer);
        this.checkGLGetError("glCompressedTexImage2D");
    }

    @Override
    public void glCompressedTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glCompressedTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8, buffer);
        this.checkGLGetError("glCompressedTexSubImage2D");
    }

    @Override
    public void glCopyTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.checkContext();
        this.downstreamGL.glCopyTexImage2D(n, n2, n3, n4, n5, n6, n7, n8);
        this.checkGLGetError("glCopyTexImage2D");
    }

    @Override
    public void glCopyTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.checkContext();
        this.downstreamGL.glCopyTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8);
        this.checkGLGetError("glCopyTexSubImage2D");
    }

    @Override
    public void glCoverageMaskNV(boolean bl) {
        this.checkContext();
        this.downstreamGL.glCoverageMaskNV(bl);
        this.checkGLGetError("glCoverageMaskNV");
    }

    @Override
    public void glCoverageOperationNV(int n) {
        this.checkContext();
        this.downstreamGL.glCoverageOperationNV(n);
        this.checkGLGetError("glCoverageOperationNV");
    }

    @Override
    public int glCreateProgram() {
        this.checkContext();
        int n = this.downstreamGL.glCreateProgram();
        this.checkGLGetError("glCreateProgram");
        return n;
    }

    @Override
    public int glCreateShader(int n) {
        this.checkContext();
        int n2 = this.downstreamGL.glCreateShader(n);
        this.checkGLGetError("glCreateShader");
        return n2;
    }

    @Override
    public void glCullFace(int n) {
        this.checkContext();
        this.downstreamGL.glCullFace(n);
        this.checkGLGetError("glCullFace");
    }

    @Override
    public void glDeleteBuffers(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glDeleteBuffers(n, intBuffer);
        this.checkGLGetError("glDeleteBuffers");
    }

    @Override
    public void glDeleteBuffers(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glDeleteBuffers(n, nArray, n2);
        this.checkGLGetError("glDeleteBuffers");
    }

    @Override
    public void glDeleteFramebuffers(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glDeleteFramebuffers(n, intBuffer);
        this.checkGLGetError("glDeleteFramebuffers");
    }

    @Override
    public void glDeleteFramebuffers(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glDeleteFramebuffers(n, nArray, n2);
        this.checkGLGetError("glDeleteFramebuffers");
    }

    @Override
    public void glDeleteProgram(int n) {
        this.checkContext();
        this.downstreamGL.glDeleteProgram(n);
        this.checkGLGetError("glDeleteProgram");
    }

    @Override
    public void glDeleteRenderbuffers(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glDeleteRenderbuffers(n, intBuffer);
        this.checkGLGetError("glDeleteRenderbuffers");
    }

    @Override
    public void glDeleteRenderbuffers(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glDeleteRenderbuffers(n, nArray, n2);
        this.checkGLGetError("glDeleteRenderbuffers");
    }

    @Override
    public void glDeleteShader(int n) {
        this.checkContext();
        this.downstreamGL.glDeleteShader(n);
        this.checkGLGetError("glDeleteShader");
    }

    @Override
    public void glDeleteTextures(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glDeleteTextures(n, intBuffer);
        this.checkGLGetError("glDeleteTextures");
    }

    @Override
    public void glDeleteTextures(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glDeleteTextures(n, nArray, n2);
        this.checkGLGetError("glDeleteTextures");
    }

    @Override
    public void glDepthFunc(int n) {
        this.checkContext();
        this.downstreamGL.glDepthFunc(n);
        this.checkGLGetError("glDepthFunc");
    }

    @Override
    public void glDepthMask(boolean bl) {
        this.checkContext();
        this.downstreamGL.glDepthMask(bl);
        this.checkGLGetError("glDepthMask");
    }

    @Override
    public void glDepthRangef(float f2, float f3) {
        this.checkContext();
        this.downstreamGL.glDepthRangef(f2, f3);
        this.checkGLGetError("glDepthRangef");
    }

    @Override
    public void glDetachShader(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glDetachShader(n, n2);
        this.checkGLGetError("glDetachShader");
    }

    @Override
    public void glDisable(int n) {
        this.checkContext();
        this.downstreamGL.glDisable(n);
        this.checkGLGetError("glDisable");
    }

    @Override
    public void glDisableVertexAttribArray(int n) {
        this.checkContext();
        this.downstreamGL.glDisableVertexAttribArray(n);
        this.checkGLGetError("glDisableVertexAttribArray");
    }

    @Override
    public void glDrawArrays(int n, int n2, int n3) {
        this.checkContext();
        this.downstreamGL.glDrawArrays(n, n2, n3);
        this.checkGLGetError("glDrawArrays");
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glDrawElements(n, n2, n3, buffer);
        this.checkGLGetError("glDrawElements");
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, long l) {
        this.checkContext();
        this.downstreamGL.glDrawElements(n, n2, n3, l);
        this.checkGLGetError("glDrawElements");
    }

    @Override
    public void glEnable(int n) {
        this.checkContext();
        this.downstreamGL.glEnable(n);
        this.checkGLGetError("glEnable");
    }

    @Override
    public void glEnableVertexAttribArray(int n) {
        this.checkContext();
        this.downstreamGL.glEnableVertexAttribArray(n);
        this.checkGLGetError("glEnableVertexAttribArray");
    }

    @Override
    public void glFinish() {
        this.checkContext();
        this.downstreamGL.glFinish();
        this.checkGLGetError("glFinish");
    }

    @Override
    public void glFlush() {
        this.checkContext();
        this.downstreamGL.glFlush();
        this.checkGLGetError("glFlush");
    }

    @Override
    public void glFramebufferRenderbuffer(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glFramebufferRenderbuffer(n, n2, n3, n4);
        this.checkGLGetError("glFramebufferRenderbuffer");
    }

    @Override
    public void glFramebufferTexture2D(int n, int n2, int n3, int n4, int n5) {
        this.checkContext();
        this.downstreamGL.glFramebufferTexture2D(n, n2, n3, n4, n5);
        this.checkGLGetError("glFramebufferTexture2D");
    }

    @Override
    public void glFrontFace(int n) {
        this.checkContext();
        this.downstreamGL.glFrontFace(n);
        this.checkGLGetError("glFrontFace");
    }

    @Override
    public void glGenBuffers(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGenBuffers(n, intBuffer);
        this.checkGLGetError("glGenBuffers");
    }

    @Override
    public void glGenBuffers(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGenBuffers(n, nArray, n2);
        this.checkGLGetError("glGenBuffers");
    }

    @Override
    public void glGenFramebuffers(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGenFramebuffers(n, intBuffer);
        this.checkGLGetError("glGenFramebuffers");
    }

    @Override
    public void glGenFramebuffers(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGenFramebuffers(n, nArray, n2);
        this.checkGLGetError("glGenFramebuffers");
    }

    @Override
    public void glGenRenderbuffers(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGenRenderbuffers(n, intBuffer);
        this.checkGLGetError("glGenRenderbuffers");
    }

    @Override
    public void glGenRenderbuffers(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGenRenderbuffers(n, nArray, n2);
        this.checkGLGetError("glGenRenderbuffers");
    }

    @Override
    public void glGenTextures(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGenTextures(n, intBuffer);
        this.checkGLGetError("glGenTextures");
    }

    @Override
    public void glGenTextures(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGenTextures(n, nArray, n2);
        this.checkGLGetError("glGenTextures");
    }

    @Override
    public void glGenerateMipmap(int n) {
        this.checkContext();
        this.downstreamGL.glGenerateMipmap(n);
        this.checkGLGetError("glGenerateMipmap");
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        this.checkContext();
        this.downstreamGL.glGetActiveAttrib(n, n2, n3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
        this.checkGLGetError("glGetActiveAttrib");
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        this.checkContext();
        this.downstreamGL.glGetActiveAttrib(n, n2, n3, nArray, n4, nArray2, n5, nArray3, n6, byArray, n7);
        this.checkGLGetError("glGetActiveAttrib");
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        this.checkContext();
        this.downstreamGL.glGetActiveUniform(n, n2, n3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
        this.checkGLGetError("glGetActiveUniform");
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        this.checkContext();
        this.downstreamGL.glGetActiveUniform(n, n2, n3, nArray, n4, nArray2, n5, nArray3, n6, byArray, n7);
        this.checkGLGetError("glGetActiveUniform");
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.checkContext();
        this.downstreamGL.glGetAttachedShaders(n, n2, intBuffer, intBuffer2);
        this.checkGLGetError("glGetAttachedShaders");
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4) {
        this.checkContext();
        this.downstreamGL.glGetAttachedShaders(n, n2, nArray, n3, nArray2, n4);
        this.checkGLGetError("glGetAttachedShaders");
    }

    @Override
    public int glGetAttribLocation(int n, String string) {
        this.checkContext();
        int n2 = this.downstreamGL.glGetAttribLocation(n, string);
        this.checkGLGetError("glGetAttribLocation");
        return n2;
    }

    @Override
    public void glGetBooleanv(int n, ByteBuffer byteBuffer) {
        this.checkContext();
        this.downstreamGL.glGetBooleanv(n, byteBuffer);
        this.checkGLGetError("glGetBooleanv");
    }

    @Override
    public void glGetBooleanv(int n, byte[] byArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGetBooleanv(n, byArray, n2);
        this.checkGLGetError("glGetBooleanv");
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetBufferParameteriv(n, n2, intBuffer);
        this.checkGLGetError("glGetBufferParameteriv");
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetBufferParameteriv(n, n2, nArray, n3);
        this.checkGLGetError("glGetBufferParameteriv");
    }

    @Override
    public int glGetError() {
        this.checkContext();
        int n = this.downstreamGL.glGetError();
        this.checkGLGetError("glGetError");
        return n;
    }

    @Override
    public void glGetFloatv(int n, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glGetFloatv(n, floatBuffer);
        this.checkGLGetError("glGetFloatv");
    }

    @Override
    public void glGetFloatv(int n, float[] fArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGetFloatv(n, fArray, n2);
        this.checkGLGetError("glGetFloatv");
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetFramebufferAttachmentParameteriv(n, n2, n3, intBuffer);
        this.checkGLGetError("glGetFramebufferAttachmentParameteriv");
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, int[] nArray, int n4) {
        this.checkContext();
        this.downstreamGL.glGetFramebufferAttachmentParameteriv(n, n2, n3, nArray, n4);
        this.checkGLGetError("glGetFramebufferAttachmentParameteriv");
    }

    @Override
    public void glGetIntegerv(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetIntegerv(n, intBuffer);
        this.checkGLGetError("glGetIntegerv");
    }

    @Override
    public void glGetIntegerv(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGetIntegerv(n, nArray, n2);
        this.checkGLGetError("glGetIntegerv");
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        this.checkContext();
        this.downstreamGL.glGetProgramInfoLog(n, n2, intBuffer, byteBuffer);
        this.checkGLGetError("glGetProgramInfoLog");
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        this.checkContext();
        this.downstreamGL.glGetProgramInfoLog(n, n2, nArray, n3, byArray, n4);
        this.checkGLGetError("glGetProgramInfoLog");
    }

    @Override
    public void glGetProgramiv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetProgramiv(n, n2, intBuffer);
        this.checkGLGetError("glGetProgramiv");
    }

    @Override
    public void glGetProgramiv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetProgramiv(n, n2, nArray, n3);
        this.checkGLGetError("glGetProgramiv");
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetRenderbufferParameteriv(n, n2, intBuffer);
        this.checkGLGetError("glGetRenderbufferParameteriv");
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetRenderbufferParameteriv(n, n2, nArray, n3);
        this.checkGLGetError("glGetRenderbufferParameteriv");
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        this.checkContext();
        this.downstreamGL.glGetShaderInfoLog(n, n2, intBuffer, byteBuffer);
        this.checkGLGetError("glGetShaderInfoLog");
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        this.checkContext();
        this.downstreamGL.glGetShaderInfoLog(n, n2, nArray, n3, byArray, n4);
        this.checkGLGetError("glGetShaderInfoLog");
    }

    @Override
    public void glGetShaderPrecisionFormat(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.checkContext();
        this.downstreamGL.glGetShaderPrecisionFormat(n, n2, intBuffer, intBuffer2);
        this.checkGLGetError("glGetShaderPrecisionFormat");
    }

    @Override
    public void glGetShaderSource(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        this.checkContext();
        this.downstreamGL.glGetShaderSource(n, n2, intBuffer, byteBuffer);
        this.checkGLGetError("glGetShaderSource");
    }

    @Override
    public void glGetShaderiv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetShaderiv(n, n2, intBuffer);
        this.checkGLGetError("glGetShaderiv");
    }

    @Override
    public void glGetShaderiv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetShaderiv(n, n2, nArray, n3);
        this.checkGLGetError("glGetShaderiv");
    }

    @Override
    public String glGetString(int n) {
        this.checkContext();
        String string = this.downstreamGL.glGetString(n);
        this.checkGLGetError("glGetString");
        return string;
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glGetTexParameterfv(n, n2, floatBuffer);
        this.checkGLGetError("glGetTexParameterfv");
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetTexParameterfv(n, n2, fArray, n3);
        this.checkGLGetError("glGetTexParameterfv");
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetTexParameteriv(n, n2, intBuffer);
        this.checkGLGetError("glGetTexParameteriv");
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetTexParameteriv(n, n2, nArray, n3);
        this.checkGLGetError("glGetTexParameteriv");
    }

    @Override
    public int glGetUniformLocation(int n, String string) {
        this.checkContext();
        int n2 = this.downstreamGL.glGetUniformLocation(n, string);
        this.checkGLGetError("glGetUniformLocation");
        return n2;
    }

    @Override
    public void glGetUniformfv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glGetUniformfv(n, n2, floatBuffer);
        this.checkGLGetError("glGetUniformfv");
    }

    @Override
    public void glGetUniformfv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetUniformfv(n, n2, fArray, n3);
        this.checkGLGetError("glGetUniformfv");
    }

    @Override
    public void glGetUniformiv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetUniformiv(n, n2, intBuffer);
        this.checkGLGetError("glGetUniformiv");
    }

    @Override
    public void glGetUniformiv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetUniformiv(n, n2, nArray, n3);
        this.checkGLGetError("glGetUniformiv");
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glGetVertexAttribfv(n, n2, floatBuffer);
        this.checkGLGetError("glGetVertexAttribfv");
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetVertexAttribfv(n, n2, fArray, n3);
        this.checkGLGetError("glGetVertexAttribfv");
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetVertexAttribiv(n, n2, intBuffer);
        this.checkGLGetError("glGetVertexAttribiv");
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetVertexAttribiv(n, n2, nArray, n3);
        this.checkGLGetError("glGetVertexAttribiv");
    }

    @Override
    public void glHint(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glHint(n, n2);
        this.checkGLGetError("glHint");
    }

    @Override
    public boolean glIsBuffer(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsBuffer(n);
        this.checkGLGetError("glIsBuffer");
        return bl;
    }

    @Override
    public boolean glIsEnabled(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsEnabled(n);
        this.checkGLGetError("glIsEnabled");
        return bl;
    }

    @Override
    public boolean glIsFramebuffer(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsFramebuffer(n);
        this.checkGLGetError("glIsFramebuffer");
        return bl;
    }

    @Override
    public boolean glIsProgram(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsProgram(n);
        this.checkGLGetError("glIsProgram");
        return bl;
    }

    @Override
    public boolean glIsRenderbuffer(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsRenderbuffer(n);
        this.checkGLGetError("glIsRenderbuffer");
        return bl;
    }

    @Override
    public boolean glIsShader(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsShader(n);
        this.checkGLGetError("glIsShader");
        return bl;
    }

    @Override
    public boolean glIsTexture(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsTexture(n);
        this.checkGLGetError("glIsTexture");
        return bl;
    }

    @Override
    public void glLineWidth(float f2) {
        this.checkContext();
        this.downstreamGL.glLineWidth(f2);
        this.checkGLGetError("glLineWidth");
    }

    @Override
    public void glLinkProgram(int n) {
        this.checkContext();
        this.downstreamGL.glLinkProgram(n);
        this.checkGLGetError("glLinkProgram");
    }

    @Override
    public void glPixelStorei(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glPixelStorei(n, n2);
        this.checkGLGetError("glPixelStorei");
    }

    @Override
    public void glPolygonOffset(float f2, float f3) {
        this.checkContext();
        this.downstreamGL.glPolygonOffset(f2, f3);
        this.checkGLGetError("glPolygonOffset");
    }

    @Override
    public void glReadPixels(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glReadPixels(n, n2, n3, n4, n5, n6, buffer);
        this.checkGLGetError("glReadPixels");
    }

    @Override
    public void glReleaseShaderCompiler() {
        this.checkContext();
        this.downstreamGL.glReleaseShaderCompiler();
        this.checkGLGetError("glReleaseShaderCompiler");
    }

    @Override
    public void glRenderbufferStorage(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glRenderbufferStorage(n, n2, n3, n4);
        this.checkGLGetError("glRenderbufferStorage");
    }

    @Override
    public void glSampleCoverage(float f2, boolean bl) {
        this.checkContext();
        this.downstreamGL.glSampleCoverage(f2, bl);
        this.checkGLGetError("glSampleCoverage");
    }

    @Override
    public void glScissor(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glScissor(n, n2, n3, n4);
        this.checkGLGetError("glScissor");
    }

    @Override
    public void glShaderBinary(int n, IntBuffer intBuffer, int n2, Buffer buffer, int n3) {
        this.checkContext();
        this.downstreamGL.glShaderBinary(n, intBuffer, n2, buffer, n3);
        this.checkGLGetError("glShaderBinary");
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glShaderSource(n, n2, stringArray, intBuffer);
        this.checkGLGetError("glShaderSource");
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glShaderSource(n, n2, stringArray, nArray, n3);
        this.checkGLGetError("glShaderSource");
    }

    @Override
    public void glStencilFunc(int n, int n2, int n3) {
        this.checkContext();
        this.downstreamGL.glStencilFunc(n, n2, n3);
        this.checkGLGetError("glStencilFunc");
    }

    @Override
    public void glStencilFuncSeparate(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glStencilFuncSeparate(n, n2, n3, n4);
        this.checkGLGetError("glStencilFuncSeparate");
    }

    @Override
    public void glStencilMask(int n) {
        this.checkContext();
        this.downstreamGL.glStencilMask(n);
        this.checkGLGetError("glStencilMask");
    }

    @Override
    public void glStencilMaskSeparate(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glStencilMaskSeparate(n, n2);
        this.checkGLGetError("glStencilMaskSeparate");
    }

    @Override
    public void glStencilOp(int n, int n2, int n3) {
        this.checkContext();
        this.downstreamGL.glStencilOp(n, n2, n3);
        this.checkGLGetError("glStencilOp");
    }

    @Override
    public void glStencilOpSeparate(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glStencilOpSeparate(n, n2, n3, n4);
        this.checkGLGetError("glStencilOpSeparate");
    }

    @Override
    public void glTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glTexImage2D(n, n2, n3, n4, n5, n6, n7, n8, buffer);
        this.checkGLGetError("glTexImage2D");
    }

    @Override
    public void glTexParameterf(int n, int n2, float f2) {
        this.checkContext();
        this.downstreamGL.glTexParameterf(n, n2, f2);
        this.checkGLGetError("glTexParameterf");
    }

    @Override
    public void glTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glTexParameterfv(n, n2, floatBuffer);
        this.checkGLGetError("glTexParameterfv");
    }

    @Override
    public void glTexParameterfv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glTexParameterfv(n, n2, fArray, n3);
        this.checkGLGetError("glTexParameterfv");
    }

    @Override
    public void glTexParameteri(int n, int n2, int n3) {
        this.checkContext();
        this.downstreamGL.glTexParameteri(n, n2, n3);
        this.checkGLGetError("glTexParameteri");
    }

    @Override
    public void glTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glTexParameteriv(n, n2, intBuffer);
        this.checkGLGetError("glTexParameteriv");
    }

    @Override
    public void glTexParameteriv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glTexParameteriv(n, n2, nArray, n3);
        this.checkGLGetError("glTexParameteriv");
    }

    @Override
    public void glTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8, buffer);
        this.checkGLGetError("glTexSubImage2D");
    }

    @Override
    public void glUniform1f(int n, float f2) {
        this.checkContext();
        this.downstreamGL.glUniform1f(n, f2);
        this.checkGLGetError("glUniform1f");
    }

    @Override
    public void glUniform1fv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform1fv(n, n2, floatBuffer);
        this.checkGLGetError("glUniform1fv");
    }

    @Override
    public void glUniform1fv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform1fv(n, n2, fArray, n3);
        this.checkGLGetError("glUniform1fv");
    }

    @Override
    public void glUniform1i(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glUniform1i(n, n2);
        this.checkGLGetError("glUniform1i");
    }

    @Override
    public void glUniform1iv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform1iv(n, n2, intBuffer);
        this.checkGLGetError("glUniform1iv");
    }

    @Override
    public void glUniform1iv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform1iv(n, n2, nArray, n3);
        this.checkGLGetError("glUniform1iv");
    }

    @Override
    public void glUniform2f(int n, float f2, float f3) {
        this.checkContext();
        this.downstreamGL.glUniform2f(n, f2, f3);
        this.checkGLGetError("glUniform2f");
    }

    @Override
    public void glUniform2fv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform2fv(n, n2, floatBuffer);
        this.checkGLGetError("glUniform2fv");
    }

    @Override
    public void glUniform2fv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform2fv(n, n2, fArray, n3);
        this.checkGLGetError("glUniform2fv");
    }

    @Override
    public void glUniform2i(int n, int n2, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform2i(n, n2, n3);
        this.checkGLGetError("glUniform2i");
    }

    @Override
    public void glUniform2iv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform2iv(n, n2, intBuffer);
        this.checkGLGetError("glUniform2iv");
    }

    @Override
    public void glUniform2iv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform2iv(n, n2, nArray, n3);
        this.checkGLGetError("glUniform2iv");
    }

    @Override
    public void glUniform3f(int n, float f2, float f3, float f4) {
        this.checkContext();
        this.downstreamGL.glUniform3f(n, f2, f3, f4);
        this.checkGLGetError("glUniform3f");
    }

    @Override
    public void glUniform3fv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform3fv(n, n2, floatBuffer);
        this.checkGLGetError("glUniform3fv");
    }

    @Override
    public void glUniform3fv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform3fv(n, n2, fArray, n3);
        this.checkGLGetError("glUniform3fv");
    }

    @Override
    public void glUniform3i(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glUniform3i(n, n2, n3, n4);
        this.checkGLGetError("glUniform3i");
    }

    @Override
    public void glUniform3iv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform3iv(n, n2, intBuffer);
        this.checkGLGetError("glUniform3iv");
    }

    @Override
    public void glUniform3iv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform3iv(n, n2, nArray, n3);
        this.checkGLGetError("glUniform3iv");
    }

    @Override
    public void glUniform4f(int n, float f2, float f3, float f4, float f5) {
        this.checkContext();
        this.downstreamGL.glUniform4f(n, f2, f3, f4, f5);
        this.checkGLGetError("glUniform4f");
    }

    @Override
    public void glUniform4fv(int n, int n2, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform4fv(n, n2, floatBuffer);
        this.checkGLGetError("glUniform4fv");
    }

    @Override
    public void glUniform4fv(int n, int n2, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform4fv(n, n2, fArray, n3);
        this.checkGLGetError("glUniform4fv");
    }

    @Override
    public void glUniform4i(int n, int n2, int n3, int n4, int n5) {
        this.checkContext();
        this.downstreamGL.glUniform4i(n, n2, n3, n4, n5);
        this.checkGLGetError("glUniform4i");
    }

    @Override
    public void glUniform4iv(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glUniform4iv(n, n2, intBuffer);
        this.checkGLGetError("glUniform4iv");
    }

    @Override
    public void glUniform4iv(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniform4iv(n, n2, nArray, n3);
        this.checkGLGetError("glUniform4iv");
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniformMatrix2fv(n, n2, bl, floatBuffer);
        this.checkGLGetError("glUniformMatrix2fv");
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniformMatrix2fv(n, n2, bl, fArray, n3);
        this.checkGLGetError("glUniformMatrix2fv");
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniformMatrix3fv(n, n2, bl, floatBuffer);
        this.checkGLGetError("glUniformMatrix3fv");
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniformMatrix3fv(n, n2, bl, fArray, n3);
        this.checkGLGetError("glUniformMatrix3fv");
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glUniformMatrix4fv(n, n2, bl, floatBuffer);
        this.checkGLGetError("glUniformMatrix4fv");
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        this.checkContext();
        this.downstreamGL.glUniformMatrix4fv(n, n2, bl, fArray, n3);
        this.checkGLGetError("glUniformMatrix4fv");
    }

    @Override
    public void glUseProgram(int n) {
        this.checkContext();
        this.downstreamGL.glUseProgram(n);
        this.checkGLGetError("glUseProgram");
    }

    @Override
    public void glValidateProgram(int n) {
        this.checkContext();
        this.downstreamGL.glValidateProgram(n);
        this.checkGLGetError("glValidateProgram");
    }

    @Override
    public void glVertexAttrib1f(int n, float f2) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib1f(n, f2);
        this.checkGLGetError("glVertexAttrib1f");
    }

    @Override
    public void glVertexAttrib1fv(int n, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib1fv(n, floatBuffer);
        this.checkGLGetError("glVertexAttrib1fv");
    }

    @Override
    public void glVertexAttrib1fv(int n, float[] fArray, int n2) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib1fv(n, fArray, n2);
        this.checkGLGetError("glVertexAttrib1fv");
    }

    @Override
    public void glVertexAttrib2f(int n, float f2, float f3) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib2f(n, f2, f3);
        this.checkGLGetError("glVertexAttrib2f");
    }

    @Override
    public void glVertexAttrib2fv(int n, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib2fv(n, floatBuffer);
        this.checkGLGetError("glVertexAttrib2fv");
    }

    @Override
    public void glVertexAttrib2fv(int n, float[] fArray, int n2) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib2fv(n, fArray, n2);
        this.checkGLGetError("glVertexAttrib2fv");
    }

    @Override
    public void glVertexAttrib3f(int n, float f2, float f3, float f4) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib3f(n, f2, f3, f4);
        this.checkGLGetError("glVertexAttrib3f");
    }

    @Override
    public void glVertexAttrib3fv(int n, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib3fv(n, floatBuffer);
        this.checkGLGetError("glVertexAttrib3fv");
    }

    @Override
    public void glVertexAttrib3fv(int n, float[] fArray, int n2) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib3fv(n, fArray, n2);
        this.checkGLGetError("glVertexAttrib3fv");
    }

    @Override
    public void glVertexAttrib4f(int n, float f2, float f3, float f4, float f5) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib4f(n, f2, f3, f4, f5);
        this.checkGLGetError("glVertexAttrib4f");
    }

    @Override
    public void glVertexAttrib4fv(int n, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib4fv(n, floatBuffer);
        this.checkGLGetError("glVertexAttrib4fv");
    }

    @Override
    public void glVertexAttrib4fv(int n, float[] fArray, int n2) {
        this.checkContext();
        this.downstreamGL.glVertexAttrib4fv(n, fArray, n2);
        this.checkGLGetError("glVertexAttrib4fv");
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glVertexAttribPointer(n, n2, n3, bl, n4, buffer);
        this.checkGLGetError("glVertexAttribPointer");
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, long l) {
        this.checkContext();
        this.downstreamGL.glVertexAttribPointer(n, n2, n3, bl, n4, l);
        this.checkGLGetError("glVertexAttribPointer");
    }

    @Override
    public void glViewport(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glViewport(n, n2, n3, n4);
        this.checkGLGetError("glViewport");
    }

    @Override
    public boolean isFunctionAvailable(String string) {
        this.checkContext();
        boolean bl = this.downstreamGL.isFunctionAvailable(string);
        this.checkGLGetError("isFunctionAvailable");
        return bl;
    }

    @Override
    public boolean isExtensionAvailable(String string) {
        this.checkContext();
        boolean bl = this.downstreamGL.isExtensionAvailable(string);
        this.checkGLGetError("isExtensionAvailable");
        return bl;
    }

    @Override
    public void setSwapInterval(int n) {
        this.checkContext();
        this.downstreamGL.setSwapInterval(n);
        this.checkGLGetError("setSwapInterval");
    }

    @Override
    public Object getPlatformGLExtensions() {
        this.checkContext();
        Object object = this.downstreamGL.getPlatformGLExtensions();
        this.checkGLGetError("getPlatformGLExtensions");
        return object;
    }

    @Override
    public Object getExtension(String string) {
        this.checkContext();
        Object object = this.downstreamGL.getExtension(string);
        this.checkGLGetError("getExtension");
        return object;
    }

    @Override
    public void glClientActiveTexture(int n) {
        this.checkContext();
        this.downstreamGL.glClientActiveTexture(n);
        this.checkGLGetError("glClientActiveTexture");
    }

    @Override
    public void glClipPlane(int n, FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glClipPlane(n, floatBuffer);
        this.checkGLGetError("glClipPlane");
    }

    @Override
    public void glClipPlane(int n, float[] fArray, int n2) {
        this.checkContext();
        this.downstreamGL.glClipPlane(n, fArray, n2);
        this.checkGLGetError("glClipPlane");
    }

    @Override
    public void glColor4f(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glColor4f(n, n2, n3, n4);
        this.checkGLGetError("glColor4f");
    }

    @Override
    public void glColorPointer(int n, int n2, int n3, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glColorPointer(n, n2, n3, buffer);
        this.checkGLGetError("glColorPointer");
    }

    @Override
    public void glLoadIdentity() {
        this.checkContext();
        this.downstreamGL.glLoadIdentity();
        this.checkGLGetError("glLoadIdentity");
    }

    @Override
    public void glLoadMatrixf(FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glLoadMatrixf(floatBuffer);
        this.checkGLGetError("glLoadMatrixf");
    }

    @Override
    public void glLoadMatrixf(float[] fArray, int n) {
        this.checkContext();
        this.downstreamGL.glLoadMatrixf(fArray, n);
        this.checkGLGetError("glLoadMatrixf");
    }

    @Override
    public void glMatrixMode(int n) {
        this.checkContext();
        this.downstreamGL.glMatrixMode(n);
        this.checkGLGetError("glMatrixMode");
    }

    @Override
    public void glMultMatrixf(FloatBuffer floatBuffer) {
        this.checkContext();
        this.downstreamGL.glMultMatrixf(floatBuffer);
        this.checkGLGetError("glMultMatrixf");
    }

    @Override
    public void glMultMatrixf(float[] fArray, int n) {
        this.checkContext();
        this.downstreamGL.glMultMatrixf(fArray, n);
        this.checkGLGetError("glMultMatrixf");
    }

    @Override
    public void glNormalPointer(int n, int n2, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glNormalPointer(n, n2, buffer);
        this.checkGLGetError("glNormalPointer");
    }

    @Override
    public void glOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.checkContext();
        this.downstreamGL.glOrtho(f2, f3, f4, f5, f6, f7);
        this.checkGLGetError("glOrtho");
    }

    @Override
    public void glPopMatrix() {
        this.checkContext();
        this.downstreamGL.glPopMatrix();
        this.checkGLGetError("glPopMatrix");
    }

    @Override
    public void glPushMatrix() {
        this.checkContext();
        this.downstreamGL.glPushMatrix();
        this.checkGLGetError("glPushMatrix");
    }

    @Override
    public void glRotatef(float f2, float f3, float f4, float f5) {
        this.checkContext();
        this.downstreamGL.glRotatef(f2, f3, f4, f5);
        this.checkGLGetError("glRotatef");
    }

    @Override
    public void glRotate(double d2, double d3, double d4, double d5) {
        this.checkContext();
        this.downstreamGL.glRotate(d2, d3, d4, d5);
        this.checkGLGetError("glRotate");
    }

    @Override
    public void glScalef(float f2, float f3, float f4) {
        this.checkContext();
        this.downstreamGL.glScalef(f2, f3, f4);
        this.checkGLGetError("glScalef");
    }

    @Override
    public void glScale(double d2, double d3, double d4) {
        this.checkContext();
        this.downstreamGL.glScale(d2, d3, d4);
        this.checkGLGetError("glScale");
    }

    @Override
    public void glTexCoordPointer(int n, int n2, int n3, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glTexCoordPointer(n, n2, n3, buffer);
        this.checkGLGetError("glTexCoordPointer");
    }

    @Override
    public void glTranslatef(float f2, float f3, float f4) {
        this.checkContext();
        this.downstreamGL.glTranslatef(f2, f3, f4);
        this.checkGLGetError("glTranslatef");
    }

    @Override
    public void glTranslate(double d2, double d3, double d4) {
        this.checkContext();
        this.downstreamGL.glTranslate(d2, d3, d4);
        this.checkGLGetError("glTranslate");
    }

    @Override
    public void glVertexPointer(int n, int n2, int n3, Buffer buffer) {
        this.checkContext();
        this.downstreamGL.glVertexPointer(n, n2, n3, buffer);
        this.checkGLGetError("glVertexPointer");
    }

    @Override
    public void glClearDepth(double d2) {
        this.checkContext();
        this.downstreamGL.glClearDepth(d2);
        this.checkGLGetError("glClearDepth");
    }

    @Override
    public void glDepthRange(double d2, double d3) {
        this.checkContext();
        this.downstreamGL.glDepthRange(d2, d3);
        this.checkGLGetError("glDepthRange");
    }

    @Override
    public void glGenRenderbuffersEXT(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGenRenderbuffersEXT(n, intBuffer);
        this.checkGLGetError("glGenRenderbuffersEXT");
    }

    @Override
    public void glGenRenderbuffersEXT(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGenRenderbuffersEXT(n, nArray, n2);
        this.checkGLGetError("glGenRenderbuffersEXT");
    }

    @Override
    public void glGenFramebuffersEXT(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGenFramebuffersEXT(n, intBuffer);
        this.checkGLGetError("glGenFramebuffersEXT");
    }

    @Override
    public void glGenFramebuffersEXT(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glGenFramebuffersEXT(n, nArray, n2);
        this.checkGLGetError("glGenFramebuffersEXT");
    }

    @Override
    public void glBindRenderbufferEXT(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBindRenderbufferEXT(n, n2);
        this.checkGLGetError("glBindRenderbufferEXT");
    }

    @Override
    public void glRenderbufferStorageEXT(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glRenderbufferStorageEXT(n, n2, n3, n4);
        this.checkGLGetError("glRenderbufferStorageEXT");
    }

    @Override
    public void glBindFramebufferEXT(int n, int n2) {
        this.checkContext();
        this.downstreamGL.glBindFramebufferEXT(n, n2);
        this.checkGLGetError("glBindFramebufferEXT");
    }

    @Override
    public void glFramebufferRenderbufferEXT(int n, int n2, int n3, int n4) {
        this.checkContext();
        this.downstreamGL.glFramebufferRenderbufferEXT(n, n2, n3, n4);
        this.checkGLGetError("glFramebufferRenderbufferEXT");
    }

    @Override
    public void glFramebufferTexture1DEXT(int n, int n2, int n3, int n4, int n5) {
        this.checkContext();
        this.downstreamGL.glFramebufferTexture1DEXT(n, n2, n3, n4, n5);
        this.checkGLGetError("glFramebufferTexture1DEXT");
    }

    @Override
    public void glFramebufferTexture2DEXT(int n, int n2, int n3, int n4, int n5) {
        this.checkContext();
        this.downstreamGL.glFramebufferTexture2DEXT(n, n2, n3, n4, n5);
        this.checkGLGetError("glFramebufferTexture2DEXT");
    }

    @Override
    public void glFramebufferTexture3DEXT(int n, int n2, int n3, int n4, int n5, int n6) {
        this.checkContext();
        this.downstreamGL.glFramebufferTexture3DEXT(n, n2, n3, n4, n5, n6);
        this.checkGLGetError("glFramebufferTexture3DEXT");
    }

    @Override
    public int glCheckFramebufferStatusEXT(int n) {
        this.checkContext();
        int n2 = this.downstreamGL.glCheckFramebufferStatusEXT(n);
        this.checkGLGetError("glCheckFramebufferStatusEXT");
        return n2;
    }

    @Override
    public void glDeleteRenderbuffersEXT(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glDeleteRenderbuffersEXT(n, intBuffer);
        this.checkGLGetError("glDeleteRenderbuffersEXT");
    }

    @Override
    public void glDeleteRenderbuffersEXT(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glDeleteRenderbuffersEXT(n, nArray, n2);
        this.checkGLGetError("glDeleteRenderbuffersEXT");
    }

    @Override
    public void glDeleteFramebuffersEXT(int n, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glDeleteFramebuffersEXT(n, intBuffer);
        this.checkGLGetError("glDeleteFramebuffersEXT");
    }

    @Override
    public void glDeleteFramebuffersEXT(int n, int[] nArray, int n2) {
        this.checkContext();
        this.downstreamGL.glDeleteFramebuffersEXT(n, nArray, n2);
        this.checkGLGetError("glDeleteFramebuffersEXT");
    }

    @Override
    public void glGetRenderbufferParameterivEXT(int n, int n2, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetRenderbufferParameterivEXT(n, n2, intBuffer);
        this.checkGLGetError("glGetRenderbufferParameterivEXT");
    }

    @Override
    public void glGetRenderbufferParameterivEXT(int n, int n2, int[] nArray, int n3) {
        this.checkContext();
        this.downstreamGL.glGetRenderbufferParameterivEXT(n, n2, nArray, n3);
        this.checkGLGetError("glGetRenderbufferParameterivEXT");
    }

    @Override
    public boolean glIsRenderbufferEXT(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsRenderbufferEXT(n);
        this.checkGLGetError("glIsRenderbufferEXT");
        return bl;
    }

    @Override
    public boolean glIsFramebufferEXT(int n) {
        this.checkContext();
        boolean bl = this.downstreamGL.glIsFramebufferEXT(n);
        this.checkGLGetError("glIsFramebufferEXT");
        return bl;
    }

    @Override
    public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, IntBuffer intBuffer) {
        this.checkContext();
        this.downstreamGL.glGetFramebufferAttachmentParameterivEXT(n, n2, n3, intBuffer);
        this.checkGLGetError("glGetFramebufferAttachmentParameterivEXT");
    }

    @Override
    public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, int[] nArray, int n4) {
        this.checkContext();
        this.downstreamGL.glGetFramebufferAttachmentParameterivEXT(n, n2, n3, nArray, n4);
        this.checkGLGetError("glGetFramebufferAttachmentParameterivEXT");
    }

    @Override
    public void glGenerateMipmapEXT(int n) {
        this.checkContext();
        this.downstreamGL.glGenerateMipmapEXT(n);
        this.checkGLGetError("glGenerateMipmapEXT");
    }

    private void checkGLGetError(String string) {
        int n = this.downstreamGL.glGetError();
        if (n == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(new StringBuffer().append("glGetError() returned the following error codes after a call to ").append(string).append("(): ").toString());
        int n2 = 10;
        do {
            switch (n) {
                case 1280: {
                    stringBuffer.append("GL_INVALID_ENUM ");
                    break;
                }
                case 1281: {
                    stringBuffer.append("GL_INVALID_VALUE ");
                    break;
                }
                case 1282: {
                    stringBuffer.append("GL_INVALID_OPERATION ");
                    break;
                }
                case 1285: {
                    stringBuffer.append("GL_OUT_OF_MEMORY ");
                    break;
                }
                case 0: {
                    throw new InternalError("Should not be treating GL_NO_ERROR as error");
                }
                default: {
                    throw new InternalError(new StringBuffer().append("Unknown glGetError() return value: ").append(n).toString());
                }
            }
        } while (--n2 >= 0 && (n = this.downstreamGL.glGetError()) != 0);
        throw new GLException(stringBuffer.toString());
    }

    private void checkContext() {
        GLContext gLContext = GLContext.getCurrent();
        if (gLContext == null) {
            throw new GLException("No OpenGL context is current on this thread");
        }
        if (this._context != null && this._context != gLContext) {
            throw new GLException("This GL object is being incorrectly used with a different GLContext than that which created it");
        }
    }
}

