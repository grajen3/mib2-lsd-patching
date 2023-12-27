/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;

public class TraceGL
implements GL {
    private PrintStream stream;
    private int indent = 0;
    private GL downstreamGL;

    public TraceGL(GL gL, PrintStream printStream) {
        if (gL == null) {
            throw new IllegalArgumentException("null downstreamGL");
        }
        this.downstreamGL = gL;
        this.stream = printStream;
    }

    @Override
    public void glActiveTexture(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glActiveTexture(").append(n).append(")").toString());
        this.downstreamGL.glActiveTexture(n);
        this.println("");
    }

    @Override
    public void glAttachShader(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glAttachShader(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glAttachShader(n, n2);
        this.println("");
    }

    @Override
    public void glBindAttribLocation(int n, int n2, String string) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindAttribLocation(").append(n).append(",").append(n2).append(",").append(string).append(")").toString());
        this.downstreamGL.glBindAttribLocation(n, n2, string);
        this.println("");
    }

    @Override
    public void glBindBuffer(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindBuffer(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBindBuffer(n, n2);
        this.println("");
    }

    @Override
    public void glBindFramebuffer(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindFramebuffer(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBindFramebuffer(n, n2);
        this.println("");
    }

    @Override
    public void glBindRenderbuffer(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindRenderbuffer(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBindRenderbuffer(n, n2);
        this.println("");
    }

    @Override
    public void glBindTexture(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindTexture(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBindTexture(n, n2);
        this.println("");
    }

    @Override
    public void glBlendColor(float f2, float f3, float f4, float f5) {
        this.printIndent();
        this.print(new StringBuffer().append("glBlendColor(").append(f2).append(",").append(f3).append(",").append(f4).append(",").append(f5).append(")").toString());
        this.downstreamGL.glBlendColor(f2, f3, f4, f5);
        this.println("");
    }

    @Override
    public void glBlendEquation(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glBlendEquation(").append(n).append(")").toString());
        this.downstreamGL.glBlendEquation(n);
        this.println("");
    }

    @Override
    public void glBlendEquationSeparate(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBlendEquationSeparate(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBlendEquationSeparate(n, n2);
        this.println("");
    }

    @Override
    public void glBlendFunc(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBlendFunc(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBlendFunc(n, n2);
        this.println("");
    }

    @Override
    public void glBlendFuncSeparate(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glBlendFuncSeparate(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glBlendFuncSeparate(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glBufferData(int n, int n2, Buffer buffer, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glBufferData(").append(n).append(",").append(n2).append(",").append(buffer).append(",").append(n3).append(")").toString());
        this.downstreamGL.glBufferData(n, n2, buffer, n3);
        this.println("");
    }

    @Override
    public void glBufferSubData(int n, int n2, int n3, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glBufferSubData(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glBufferSubData(n, n2, n3, buffer);
        this.println("");
    }

    @Override
    public int glCheckFramebufferStatus(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glCheckFramebufferStatus(").append(n).append(")").toString());
        int n2 = this.downstreamGL.glCheckFramebufferStatus(n);
        this.println(new StringBuffer().append(" = ").append(n2).toString());
        return n2;
    }

    @Override
    public void glClear(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glClear(").append(n).append(")").toString());
        this.downstreamGL.glClear(n);
        this.println("");
    }

    @Override
    public void glClearColor(float f2, float f3, float f4, float f5) {
        this.printIndent();
        this.print(new StringBuffer().append("glClearColor(").append(f2).append(",").append(f3).append(",").append(f4).append(",").append(f5).append(")").toString());
        this.downstreamGL.glClearColor(f2, f3, f4, f5);
        this.println("");
    }

    @Override
    public void glClearDepthf(float f2) {
        this.printIndent();
        this.print(new StringBuffer().append("glClearDepthf(").append(f2).append(")").toString());
        this.downstreamGL.glClearDepthf(f2);
        this.println("");
    }

    @Override
    public void glClearStencil(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glClearStencil(").append(n).append(")").toString());
        this.downstreamGL.glClearStencil(n);
        this.println("");
    }

    @Override
    public void glColorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.printIndent();
        this.print(new StringBuffer().append("glColorMask(").append(bl).append(",").append(bl2).append(",").append(bl3).append(",").append(bl4).append(")").toString());
        this.downstreamGL.glColorMask(bl, bl2, bl3, bl4);
        this.println("");
    }

    @Override
    public void glCompileShader(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glCompileShader(").append(n).append(")").toString());
        this.downstreamGL.glCompileShader(n);
        this.println("");
    }

    @Override
    public void glCompressedTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glCompressedTexImage2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(n7).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glCompressedTexImage2D(n, n2, n3, n4, n5, n6, n7, buffer);
        this.println("");
    }

    @Override
    public void glCompressedTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glCompressedTexSubImage2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(n7).append(",").append(n8).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glCompressedTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8, buffer);
        this.println("");
    }

    @Override
    public void glCopyTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.printIndent();
        this.print(new StringBuffer().append("glCopyTexImage2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(n7).append(",").append(n8).append(")").toString());
        this.downstreamGL.glCopyTexImage2D(n, n2, n3, n4, n5, n6, n7, n8);
        this.println("");
    }

    @Override
    public void glCopyTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.printIndent();
        this.print(new StringBuffer().append("glCopyTexSubImage2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(n7).append(",").append(n8).append(")").toString());
        this.downstreamGL.glCopyTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8);
        this.println("");
    }

    @Override
    public void glCoverageMaskNV(boolean bl) {
        this.printIndent();
        this.print(new StringBuffer().append("glCoverageMaskNV(").append(bl).append(")").toString());
        this.downstreamGL.glCoverageMaskNV(bl);
        this.println("");
    }

    @Override
    public void glCoverageOperationNV(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glCoverageOperationNV(").append(n).append(")").toString());
        this.downstreamGL.glCoverageOperationNV(n);
        this.println("");
    }

    @Override
    public int glCreateProgram() {
        this.printIndent();
        this.print("glCreateProgram()");
        int n = this.downstreamGL.glCreateProgram();
        this.println(new StringBuffer().append(" = ").append(n).toString());
        return n;
    }

    @Override
    public int glCreateShader(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glCreateShader(").append(n).append(")").toString());
        int n2 = this.downstreamGL.glCreateShader(n);
        this.println(new StringBuffer().append(" = ").append(n2).toString());
        return n2;
    }

    @Override
    public void glCullFace(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glCullFace(").append(n).append(")").toString());
        this.downstreamGL.glCullFace(n);
        this.println("");
    }

    @Override
    public void glDeleteBuffers(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteBuffers(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glDeleteBuffers(n, intBuffer);
        this.println("");
    }

    @Override
    public void glDeleteBuffers(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteBuffers(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDeleteBuffers(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glDeleteFramebuffers(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteFramebuffers(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glDeleteFramebuffers(n, intBuffer);
        this.println("");
    }

    @Override
    public void glDeleteFramebuffers(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteFramebuffers(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDeleteFramebuffers(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glDeleteProgram(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteProgram(").append(n).append(")").toString());
        this.downstreamGL.glDeleteProgram(n);
        this.println("");
    }

    @Override
    public void glDeleteRenderbuffers(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteRenderbuffers(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glDeleteRenderbuffers(n, intBuffer);
        this.println("");
    }

    @Override
    public void glDeleteRenderbuffers(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteRenderbuffers(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDeleteRenderbuffers(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glDeleteShader(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteShader(").append(n).append(")").toString());
        this.downstreamGL.glDeleteShader(n);
        this.println("");
    }

    @Override
    public void glDeleteTextures(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteTextures(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glDeleteTextures(n, intBuffer);
        this.println("");
    }

    @Override
    public void glDeleteTextures(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteTextures(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDeleteTextures(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glDepthFunc(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glDepthFunc(").append(n).append(")").toString());
        this.downstreamGL.glDepthFunc(n);
        this.println("");
    }

    @Override
    public void glDepthMask(boolean bl) {
        this.printIndent();
        this.print(new StringBuffer().append("glDepthMask(").append(bl).append(")").toString());
        this.downstreamGL.glDepthMask(bl);
        this.println("");
    }

    @Override
    public void glDepthRangef(float f2, float f3) {
        this.printIndent();
        this.print(new StringBuffer().append("glDepthRangef(").append(f2).append(",").append(f3).append(")").toString());
        this.downstreamGL.glDepthRangef(f2, f3);
        this.println("");
    }

    @Override
    public void glDetachShader(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDetachShader(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDetachShader(n, n2);
        this.println("");
    }

    @Override
    public void glDisable(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glDisable(").append(n).append(")").toString());
        this.downstreamGL.glDisable(n);
        this.println("");
    }

    @Override
    public void glDisableVertexAttribArray(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glDisableVertexAttribArray(").append(n).append(")").toString());
        this.downstreamGL.glDisableVertexAttribArray(n);
        this.println("");
    }

    @Override
    public void glDrawArrays(int n, int n2, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glDrawArrays(").append(n).append(",").append(n2).append(",").append(n3).append(")").toString());
        this.downstreamGL.glDrawArrays(n, n2, n3);
        this.println("");
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDrawElements(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glDrawElements(n, n2, n3, buffer);
        this.println("");
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, long l) {
        this.printIndent();
        this.print(new StringBuffer().append("glDrawElements(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(l).append(")").toString());
        this.downstreamGL.glDrawElements(n, n2, n3, l);
        this.println("");
    }

    @Override
    public void glEnable(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glEnable(").append(n).append(")").toString());
        this.downstreamGL.glEnable(n);
        this.println("");
    }

    @Override
    public void glEnableVertexAttribArray(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glEnableVertexAttribArray(").append(n).append(")").toString());
        this.downstreamGL.glEnableVertexAttribArray(n);
        this.println("");
    }

    @Override
    public void glFinish() {
        this.printIndent();
        this.print("glFinish()");
        this.downstreamGL.glFinish();
        this.println("");
    }

    @Override
    public void glFlush() {
        this.printIndent();
        this.print("glFlush()");
        this.downstreamGL.glFlush();
        this.println("");
    }

    @Override
    public void glFramebufferRenderbuffer(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glFramebufferRenderbuffer(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glFramebufferRenderbuffer(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glFramebufferTexture2D(int n, int n2, int n3, int n4, int n5) {
        this.printIndent();
        this.print(new StringBuffer().append("glFramebufferTexture2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(")").toString());
        this.downstreamGL.glFramebufferTexture2D(n, n2, n3, n4, n5);
        this.println("");
    }

    @Override
    public void glFrontFace(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glFrontFace(").append(n).append(")").toString());
        this.downstreamGL.glFrontFace(n);
        this.println("");
    }

    @Override
    public void glGenBuffers(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenBuffers(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGenBuffers(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGenBuffers(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenBuffers(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGenBuffers(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGenFramebuffers(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenFramebuffers(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGenFramebuffers(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGenFramebuffers(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenFramebuffers(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGenFramebuffers(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGenRenderbuffers(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenRenderbuffers(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGenRenderbuffers(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGenRenderbuffers(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenRenderbuffers(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGenRenderbuffers(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGenTextures(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenTextures(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGenTextures(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGenTextures(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenTextures(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGenTextures(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGenerateMipmap(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenerateMipmap(").append(n).append(")").toString());
        this.downstreamGL.glGenerateMipmap(n);
        this.println("");
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetActiveAttrib(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(intBuffer).append(",").append(intBuffer2).append(",").append(intBuffer3).append(",").append(byteBuffer).append(")").toString());
        this.downstreamGL.glGetActiveAttrib(n, n2, n3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
        this.println("");
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetActiveAttrib(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(this.dumpArray(nArray)).append(",").append(n4).append(",").append(this.dumpArray(nArray2)).append(",").append(n5).append(",").append(this.dumpArray(nArray3)).append(",").append(n6).append(",").append(this.dumpArray(byArray)).append(",").append(n7).append(")").toString());
        this.downstreamGL.glGetActiveAttrib(n, n2, n3, nArray, n4, nArray2, n5, nArray3, n6, byArray, n7);
        this.println("");
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetActiveUniform(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(intBuffer).append(",").append(intBuffer2).append(",").append(intBuffer3).append(",").append(byteBuffer).append(")").toString());
        this.downstreamGL.glGetActiveUniform(n, n2, n3, intBuffer, intBuffer2, intBuffer3, byteBuffer);
        this.println("");
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetActiveUniform(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(this.dumpArray(nArray)).append(",").append(n4).append(",").append(this.dumpArray(nArray2)).append(",").append(n5).append(",").append(this.dumpArray(nArray3)).append(",").append(n6).append(",").append(this.dumpArray(byArray)).append(",").append(n7).append(")").toString());
        this.downstreamGL.glGetActiveUniform(n, n2, n3, nArray, n4, nArray2, n5, nArray3, n6, byArray, n7);
        this.println("");
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetAttachedShaders(").append(n).append(",").append(n2).append(",").append(intBuffer).append(",").append(intBuffer2).append(")").toString());
        this.downstreamGL.glGetAttachedShaders(n, n2, intBuffer, intBuffer2);
        this.println("");
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetAttachedShaders(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(",").append(this.dumpArray(nArray2)).append(",").append(n4).append(")").toString());
        this.downstreamGL.glGetAttachedShaders(n, n2, nArray, n3, nArray2, n4);
        this.println("");
    }

    @Override
    public int glGetAttribLocation(int n, String string) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetAttribLocation(").append(n).append(",").append(string).append(")").toString());
        int n2 = this.downstreamGL.glGetAttribLocation(n, string);
        this.println(new StringBuffer().append(" = ").append(n2).toString());
        return n2;
    }

    @Override
    public void glGetBooleanv(int n, ByteBuffer byteBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetBooleanv(").append(n).append(",").append(byteBuffer).append(")").toString());
        this.downstreamGL.glGetBooleanv(n, byteBuffer);
        this.println("");
    }

    @Override
    public void glGetBooleanv(int n, byte[] byArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetBooleanv(").append(n).append(",").append(this.dumpArray(byArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGetBooleanv(n, byArray, n2);
        this.println("");
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetBufferParameteriv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetBufferParameteriv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetBufferParameteriv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetBufferParameteriv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public int glGetError() {
        this.printIndent();
        this.print("glGetError()");
        int n = this.downstreamGL.glGetError();
        this.println(new StringBuffer().append(" = ").append(n).toString());
        return n;
    }

    @Override
    public void glGetFloatv(int n, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetFloatv(").append(n).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glGetFloatv(n, floatBuffer);
        this.println("");
    }

    @Override
    public void glGetFloatv(int n, float[] fArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetFloatv(").append(n).append(",").append(this.dumpArray(fArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGetFloatv(n, fArray, n2);
        this.println("");
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetFramebufferAttachmentParameteriv(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetFramebufferAttachmentParameteriv(n, n2, n3, intBuffer);
        this.println("");
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, int[] nArray, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetFramebufferAttachmentParameteriv(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(this.dumpArray(nArray)).append(",").append(n4).append(")").toString());
        this.downstreamGL.glGetFramebufferAttachmentParameteriv(n, n2, n3, nArray, n4);
        this.println("");
    }

    @Override
    public void glGetIntegerv(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetIntegerv(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetIntegerv(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGetIntegerv(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetIntegerv(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGetIntegerv(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetProgramInfoLog(").append(n).append(",").append(n2).append(",").append(intBuffer).append(",").append(byteBuffer).append(")").toString());
        this.downstreamGL.glGetProgramInfoLog(n, n2, intBuffer, byteBuffer);
        this.println("");
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetProgramInfoLog(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(",").append(this.dumpArray(byArray)).append(",").append(n4).append(")").toString());
        this.downstreamGL.glGetProgramInfoLog(n, n2, nArray, n3, byArray, n4);
        this.println("");
    }

    @Override
    public void glGetProgramiv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetProgramiv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetProgramiv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetProgramiv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetProgramiv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetProgramiv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetRenderbufferParameteriv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetRenderbufferParameteriv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetRenderbufferParameteriv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetRenderbufferParameteriv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetShaderInfoLog(").append(n).append(",").append(n2).append(",").append(intBuffer).append(",").append(byteBuffer).append(")").toString());
        this.downstreamGL.glGetShaderInfoLog(n, n2, intBuffer, byteBuffer);
        this.println("");
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetShaderInfoLog(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(",").append(this.dumpArray(byArray)).append(",").append(n4).append(")").toString());
        this.downstreamGL.glGetShaderInfoLog(n, n2, nArray, n3, byArray, n4);
        this.println("");
    }

    @Override
    public void glGetShaderPrecisionFormat(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetShaderPrecisionFormat(").append(n).append(",").append(n2).append(",").append(intBuffer).append(",").append(intBuffer2).append(")").toString());
        this.downstreamGL.glGetShaderPrecisionFormat(n, n2, intBuffer, intBuffer2);
        this.println("");
    }

    @Override
    public void glGetShaderSource(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetShaderSource(").append(n).append(",").append(n2).append(",").append(intBuffer).append(",").append(byteBuffer).append(")").toString());
        this.downstreamGL.glGetShaderSource(n, n2, intBuffer, byteBuffer);
        this.println("");
    }

    @Override
    public void glGetShaderiv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetShaderiv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetShaderiv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetShaderiv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetShaderiv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetShaderiv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public String glGetString(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetString(").append(n).append(")").toString());
        String string = this.downstreamGL.glGetString(n);
        this.println(new StringBuffer().append(" = ").append(string).toString());
        return string;
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetTexParameterfv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glGetTexParameterfv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetTexParameterfv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetTexParameterfv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetTexParameteriv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetTexParameteriv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetTexParameteriv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetTexParameteriv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public int glGetUniformLocation(int n, String string) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetUniformLocation(").append(n).append(",").append(string).append(")").toString());
        int n2 = this.downstreamGL.glGetUniformLocation(n, string);
        this.println(new StringBuffer().append(" = ").append(n2).toString());
        return n2;
    }

    @Override
    public void glGetUniformfv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetUniformfv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glGetUniformfv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glGetUniformfv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetUniformfv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetUniformfv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glGetUniformiv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetUniformiv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetUniformiv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetUniformiv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetUniformiv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetUniformiv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetVertexAttribfv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glGetVertexAttribfv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetVertexAttribfv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetVertexAttribfv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetVertexAttribiv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetVertexAttribiv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetVertexAttribiv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetVertexAttribiv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glHint(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glHint(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glHint(n, n2);
        this.println("");
    }

    @Override
    public boolean glIsBuffer(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsBuffer(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsBuffer(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsEnabled(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsEnabled(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsEnabled(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsFramebuffer(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsFramebuffer(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsFramebuffer(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsProgram(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsProgram(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsProgram(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsRenderbuffer(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsRenderbuffer(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsRenderbuffer(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsShader(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsShader(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsShader(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsTexture(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsTexture(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsTexture(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public void glLineWidth(float f2) {
        this.printIndent();
        this.print(new StringBuffer().append("glLineWidth(").append(f2).append(")").toString());
        this.downstreamGL.glLineWidth(f2);
        this.println("");
    }

    @Override
    public void glLinkProgram(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glLinkProgram(").append(n).append(")").toString());
        this.downstreamGL.glLinkProgram(n);
        this.println("");
    }

    @Override
    public void glPixelStorei(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glPixelStorei(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glPixelStorei(n, n2);
        this.println("");
    }

    @Override
    public void glPolygonOffset(float f2, float f3) {
        this.printIndent();
        this.print(new StringBuffer().append("glPolygonOffset(").append(f2).append(",").append(f3).append(")").toString());
        this.downstreamGL.glPolygonOffset(f2, f3);
        this.println("");
    }

    @Override
    public void glReadPixels(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glReadPixels(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glReadPixels(n, n2, n3, n4, n5, n6, buffer);
        this.println("");
    }

    @Override
    public void glReleaseShaderCompiler() {
        this.printIndent();
        this.print("glReleaseShaderCompiler()");
        this.downstreamGL.glReleaseShaderCompiler();
        this.println("");
    }

    @Override
    public void glRenderbufferStorage(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glRenderbufferStorage(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glRenderbufferStorage(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glSampleCoverage(float f2, boolean bl) {
        this.printIndent();
        this.print(new StringBuffer().append("glSampleCoverage(").append(f2).append(",").append(bl).append(")").toString());
        this.downstreamGL.glSampleCoverage(f2, bl);
        this.println("");
    }

    @Override
    public void glScissor(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glScissor(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glScissor(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glShaderBinary(int n, IntBuffer intBuffer, int n2, Buffer buffer, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glShaderBinary(").append(n).append(",").append(intBuffer).append(",").append(n2).append(",").append(buffer).append(",").append(n3).append(")").toString());
        this.downstreamGL.glShaderBinary(n, intBuffer, n2, buffer, n3);
        this.println("");
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glShaderSource(").append(n).append(",").append(n2).append(",").append(this.dumpArray(stringArray)).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glShaderSource(n, n2, stringArray, intBuffer);
        this.println("");
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glShaderSource(").append(n).append(",").append(n2).append(",").append(this.dumpArray(stringArray)).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glShaderSource(n, n2, stringArray, nArray, n3);
        this.println("");
    }

    @Override
    public void glStencilFunc(int n, int n2, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glStencilFunc(").append(n).append(",").append(n2).append(",").append(n3).append(")").toString());
        this.downstreamGL.glStencilFunc(n, n2, n3);
        this.println("");
    }

    @Override
    public void glStencilFuncSeparate(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glStencilFuncSeparate(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glStencilFuncSeparate(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glStencilMask(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glStencilMask(").append(n).append(")").toString());
        this.downstreamGL.glStencilMask(n);
        this.println("");
    }

    @Override
    public void glStencilMaskSeparate(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glStencilMaskSeparate(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glStencilMaskSeparate(n, n2);
        this.println("");
    }

    @Override
    public void glStencilOp(int n, int n2, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glStencilOp(").append(n).append(",").append(n2).append(",").append(n3).append(")").toString());
        this.downstreamGL.glStencilOp(n, n2, n3);
        this.println("");
    }

    @Override
    public void glStencilOpSeparate(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glStencilOpSeparate(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glStencilOpSeparate(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexImage2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(n7).append(",").append(n8).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glTexImage2D(n, n2, n3, n4, n5, n6, n7, n8, buffer);
        this.println("");
    }

    @Override
    public void glTexParameterf(int n, int n2, float f2) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexParameterf(").append(n).append(",").append(n2).append(",").append(f2).append(")").toString());
        this.downstreamGL.glTexParameterf(n, n2, f2);
        this.println("");
    }

    @Override
    public void glTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexParameterfv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glTexParameterfv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glTexParameterfv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexParameterfv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glTexParameterfv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glTexParameteri(int n, int n2, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexParameteri(").append(n).append(",").append(n2).append(",").append(n3).append(")").toString());
        this.downstreamGL.glTexParameteri(n, n2, n3);
        this.println("");
    }

    @Override
    public void glTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexParameteriv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glTexParameteriv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glTexParameteriv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexParameteriv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glTexParameteriv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexSubImage2D(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(",").append(n7).append(",").append(n8).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glTexSubImage2D(n, n2, n3, n4, n5, n6, n7, n8, buffer);
        this.println("");
    }

    @Override
    public void glUniform1f(int n, float f2) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform1f(").append(n).append(",").append(f2).append(")").toString());
        this.downstreamGL.glUniform1f(n, f2);
        this.println("");
    }

    @Override
    public void glUniform1fv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform1fv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniform1fv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniform1fv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform1fv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform1fv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glUniform1i(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform1i(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glUniform1i(n, n2);
        this.println("");
    }

    @Override
    public void glUniform1iv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform1iv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glUniform1iv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glUniform1iv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform1iv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform1iv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glUniform2f(int n, float f2, float f3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform2f(").append(n).append(",").append(f2).append(",").append(f3).append(")").toString());
        this.downstreamGL.glUniform2f(n, f2, f3);
        this.println("");
    }

    @Override
    public void glUniform2fv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform2fv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniform2fv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniform2fv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform2fv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform2fv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glUniform2i(int n, int n2, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform2i(").append(n).append(",").append(n2).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform2i(n, n2, n3);
        this.println("");
    }

    @Override
    public void glUniform2iv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform2iv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glUniform2iv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glUniform2iv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform2iv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform2iv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glUniform3f(int n, float f2, float f3, float f4) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform3f(").append(n).append(",").append(f2).append(",").append(f3).append(",").append(f4).append(")").toString());
        this.downstreamGL.glUniform3f(n, f2, f3, f4);
        this.println("");
    }

    @Override
    public void glUniform3fv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform3fv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniform3fv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniform3fv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform3fv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform3fv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glUniform3i(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform3i(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glUniform3i(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glUniform3iv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform3iv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glUniform3iv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glUniform3iv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform3iv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform3iv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glUniform4f(int n, float f2, float f3, float f4, float f5) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform4f(").append(n).append(",").append(f2).append(",").append(f3).append(",").append(f4).append(",").append(f5).append(")").toString());
        this.downstreamGL.glUniform4f(n, f2, f3, f4, f5);
        this.println("");
    }

    @Override
    public void glUniform4fv(int n, int n2, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform4fv(").append(n).append(",").append(n2).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniform4fv(n, n2, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniform4fv(int n, int n2, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform4fv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform4fv(n, n2, fArray, n3);
        this.println("");
    }

    @Override
    public void glUniform4i(int n, int n2, int n3, int n4, int n5) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform4i(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(")").toString());
        this.downstreamGL.glUniform4i(n, n2, n3, n4, n5);
        this.println("");
    }

    @Override
    public void glUniform4iv(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform4iv(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glUniform4iv(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glUniform4iv(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniform4iv(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniform4iv(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniformMatrix2fv(").append(n).append(",").append(n2).append(",").append(bl).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniformMatrix2fv(n, n2, bl, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniformMatrix2fv(").append(n).append(",").append(n2).append(",").append(bl).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniformMatrix2fv(n, n2, bl, fArray, n3);
        this.println("");
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniformMatrix3fv(").append(n).append(",").append(n2).append(",").append(bl).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniformMatrix3fv(n, n2, bl, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniformMatrix3fv(").append(n).append(",").append(n2).append(",").append(bl).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniformMatrix3fv(n, n2, bl, fArray, n3);
        this.println("");
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniformMatrix4fv(").append(n).append(",").append(n2).append(",").append(bl).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glUniformMatrix4fv(n, n2, bl, floatBuffer);
        this.println("");
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glUniformMatrix4fv(").append(n).append(",").append(n2).append(",").append(bl).append(",").append(this.dumpArray(fArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glUniformMatrix4fv(n, n2, bl, fArray, n3);
        this.println("");
    }

    @Override
    public void glUseProgram(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glUseProgram(").append(n).append(")").toString());
        this.downstreamGL.glUseProgram(n);
        this.println("");
    }

    @Override
    public void glValidateProgram(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glValidateProgram(").append(n).append(")").toString());
        this.downstreamGL.glValidateProgram(n);
        this.println("");
    }

    @Override
    public void glVertexAttrib1f(int n, float f2) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib1f(").append(n).append(",").append(f2).append(")").toString());
        this.downstreamGL.glVertexAttrib1f(n, f2);
        this.println("");
    }

    @Override
    public void glVertexAttrib1fv(int n, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib1fv(").append(n).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glVertexAttrib1fv(n, floatBuffer);
        this.println("");
    }

    @Override
    public void glVertexAttrib1fv(int n, float[] fArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib1fv(").append(n).append(",").append(this.dumpArray(fArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glVertexAttrib1fv(n, fArray, n2);
        this.println("");
    }

    @Override
    public void glVertexAttrib2f(int n, float f2, float f3) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib2f(").append(n).append(",").append(f2).append(",").append(f3).append(")").toString());
        this.downstreamGL.glVertexAttrib2f(n, f2, f3);
        this.println("");
    }

    @Override
    public void glVertexAttrib2fv(int n, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib2fv(").append(n).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glVertexAttrib2fv(n, floatBuffer);
        this.println("");
    }

    @Override
    public void glVertexAttrib2fv(int n, float[] fArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib2fv(").append(n).append(",").append(this.dumpArray(fArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glVertexAttrib2fv(n, fArray, n2);
        this.println("");
    }

    @Override
    public void glVertexAttrib3f(int n, float f2, float f3, float f4) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib3f(").append(n).append(",").append(f2).append(",").append(f3).append(",").append(f4).append(")").toString());
        this.downstreamGL.glVertexAttrib3f(n, f2, f3, f4);
        this.println("");
    }

    @Override
    public void glVertexAttrib3fv(int n, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib3fv(").append(n).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glVertexAttrib3fv(n, floatBuffer);
        this.println("");
    }

    @Override
    public void glVertexAttrib3fv(int n, float[] fArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib3fv(").append(n).append(",").append(this.dumpArray(fArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glVertexAttrib3fv(n, fArray, n2);
        this.println("");
    }

    @Override
    public void glVertexAttrib4f(int n, float f2, float f3, float f4, float f5) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib4f(").append(n).append(",").append(f2).append(",").append(f3).append(",").append(f4).append(",").append(f5).append(")").toString());
        this.downstreamGL.glVertexAttrib4f(n, f2, f3, f4, f5);
        this.println("");
    }

    @Override
    public void glVertexAttrib4fv(int n, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib4fv(").append(n).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glVertexAttrib4fv(n, floatBuffer);
        this.println("");
    }

    @Override
    public void glVertexAttrib4fv(int n, float[] fArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttrib4fv(").append(n).append(",").append(this.dumpArray(fArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glVertexAttrib4fv(n, fArray, n2);
        this.println("");
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttribPointer(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(bl).append(",").append(n4).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glVertexAttribPointer(n, n2, n3, bl, n4, buffer);
        this.println("");
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, long l) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexAttribPointer(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(bl).append(",").append(n4).append(",").append(l).append(")").toString());
        this.downstreamGL.glVertexAttribPointer(n, n2, n3, bl, n4, l);
        this.println("");
    }

    @Override
    public void glViewport(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glViewport(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glViewport(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public boolean isFunctionAvailable(String string) {
        this.printIndent();
        this.print(new StringBuffer().append("isFunctionAvailable(").append(string).append(")").toString());
        boolean bl = this.downstreamGL.isFunctionAvailable(string);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean isExtensionAvailable(String string) {
        this.printIndent();
        this.print(new StringBuffer().append("isExtensionAvailable(").append(string).append(")").toString());
        boolean bl = this.downstreamGL.isExtensionAvailable(string);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public void setSwapInterval(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("setSwapInterval(").append(n).append(")").toString());
        this.downstreamGL.setSwapInterval(n);
        this.println("");
    }

    @Override
    public Object getPlatformGLExtensions() {
        this.printIndent();
        this.print("getPlatformGLExtensions()");
        Object object = this.downstreamGL.getPlatformGLExtensions();
        this.println(new StringBuffer().append(" = ").append(object).toString());
        return object;
    }

    @Override
    public Object getExtension(String string) {
        this.printIndent();
        this.print(new StringBuffer().append("getExtension(").append(string).append(")").toString());
        Object object = this.downstreamGL.getExtension(string);
        this.println(new StringBuffer().append(" = ").append(object).toString());
        return object;
    }

    @Override
    public void glClientActiveTexture(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glClientActiveTexture(").append(n).append(")").toString());
        this.downstreamGL.glClientActiveTexture(n);
        this.println("");
    }

    @Override
    public void glClipPlane(int n, FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glClipPlane(").append(n).append(",").append(floatBuffer).append(")").toString());
        this.downstreamGL.glClipPlane(n, floatBuffer);
        this.println("");
    }

    @Override
    public void glClipPlane(int n, float[] fArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glClipPlane(").append(n).append(",").append(this.dumpArray(fArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glClipPlane(n, fArray, n2);
        this.println("");
    }

    @Override
    public void glColor4f(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glColor4f(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glColor4f(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glColorPointer(int n, int n2, int n3, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glColorPointer(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glColorPointer(n, n2, n3, buffer);
        this.println("");
    }

    @Override
    public void glLoadIdentity() {
        this.printIndent();
        this.print("glLoadIdentity()");
        this.downstreamGL.glLoadIdentity();
        this.println("");
    }

    @Override
    public void glLoadMatrixf(FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glLoadMatrixf(").append(floatBuffer).append(")").toString());
        this.downstreamGL.glLoadMatrixf(floatBuffer);
        this.println("");
    }

    @Override
    public void glLoadMatrixf(float[] fArray, int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glLoadMatrixf(").append(this.dumpArray(fArray)).append(",").append(n).append(")").toString());
        this.downstreamGL.glLoadMatrixf(fArray, n);
        this.println("");
    }

    @Override
    public void glMatrixMode(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glMatrixMode(").append(n).append(")").toString());
        this.downstreamGL.glMatrixMode(n);
        this.println("");
    }

    @Override
    public void glMultMatrixf(FloatBuffer floatBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glMultMatrixf(").append(floatBuffer).append(")").toString());
        this.downstreamGL.glMultMatrixf(floatBuffer);
        this.println("");
    }

    @Override
    public void glMultMatrixf(float[] fArray, int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glMultMatrixf(").append(this.dumpArray(fArray)).append(",").append(n).append(")").toString());
        this.downstreamGL.glMultMatrixf(fArray, n);
        this.println("");
    }

    @Override
    public void glNormalPointer(int n, int n2, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glNormalPointer(").append(n).append(",").append(n2).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glNormalPointer(n, n2, buffer);
        this.println("");
    }

    @Override
    public void glOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.printIndent();
        this.print(new StringBuffer().append("glOrtho(").append(f2).append(",").append(f3).append(",").append(f4).append(",").append(f5).append(",").append(f6).append(",").append(f7).append(")").toString());
        this.downstreamGL.glOrtho(f2, f3, f4, f5, f6, f7);
        this.println("");
    }

    @Override
    public void glPopMatrix() {
        this.printIndent();
        this.print("glPopMatrix()");
        this.downstreamGL.glPopMatrix();
        this.println("");
    }

    @Override
    public void glPushMatrix() {
        this.printIndent();
        this.print("glPushMatrix()");
        this.downstreamGL.glPushMatrix();
        this.println("");
    }

    @Override
    public void glRotatef(float f2, float f3, float f4, float f5) {
        this.printIndent();
        this.print(new StringBuffer().append("glRotatef(").append(f2).append(",").append(f3).append(",").append(f4).append(",").append(f5).append(")").toString());
        this.downstreamGL.glRotatef(f2, f3, f4, f5);
        this.println("");
    }

    @Override
    public void glRotate(double d2, double d3, double d4, double d5) {
        this.printIndent();
        this.print(new StringBuffer().append("glRotate(").append(d2).append(",").append(d3).append(",").append(d4).append(",").append(d5).append(")").toString());
        this.downstreamGL.glRotate(d2, d3, d4, d5);
        this.println("");
    }

    @Override
    public void glScalef(float f2, float f3, float f4) {
        this.printIndent();
        this.print(new StringBuffer().append("glScalef(").append(f2).append(",").append(f3).append(",").append(f4).append(")").toString());
        this.downstreamGL.glScalef(f2, f3, f4);
        this.println("");
    }

    @Override
    public void glScale(double d2, double d3, double d4) {
        this.printIndent();
        this.print(new StringBuffer().append("glScale(").append(d2).append(",").append(d3).append(",").append(d4).append(")").toString());
        this.downstreamGL.glScale(d2, d3, d4);
        this.println("");
    }

    @Override
    public void glTexCoordPointer(int n, int n2, int n3, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glTexCoordPointer(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glTexCoordPointer(n, n2, n3, buffer);
        this.println("");
    }

    @Override
    public void glTranslatef(float f2, float f3, float f4) {
        this.printIndent();
        this.print(new StringBuffer().append("glTranslatef(").append(f2).append(",").append(f3).append(",").append(f4).append(")").toString());
        this.downstreamGL.glTranslatef(f2, f3, f4);
        this.println("");
    }

    @Override
    public void glTranslate(double d2, double d3, double d4) {
        this.printIndent();
        this.print(new StringBuffer().append("glTranslate(").append(d2).append(",").append(d3).append(",").append(d4).append(")").toString());
        this.downstreamGL.glTranslate(d2, d3, d4);
        this.println("");
    }

    @Override
    public void glVertexPointer(int n, int n2, int n3, Buffer buffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glVertexPointer(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(buffer).append(")").toString());
        this.downstreamGL.glVertexPointer(n, n2, n3, buffer);
        this.println("");
    }

    @Override
    public void glClearDepth(double d2) {
        this.printIndent();
        this.print(new StringBuffer().append("glClearDepth(").append(d2).append(")").toString());
        this.downstreamGL.glClearDepth(d2);
        this.println("");
    }

    @Override
    public void glDepthRange(double d2, double d3) {
        this.printIndent();
        this.print(new StringBuffer().append("glDepthRange(").append(d2).append(",").append(d3).append(")").toString());
        this.downstreamGL.glDepthRange(d2, d3);
        this.println("");
    }

    @Override
    public void glGenRenderbuffersEXT(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenRenderbuffersEXT(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGenRenderbuffersEXT(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGenRenderbuffersEXT(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenRenderbuffersEXT(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGenRenderbuffersEXT(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGenFramebuffersEXT(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenFramebuffersEXT(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGenFramebuffersEXT(n, intBuffer);
        this.println("");
    }

    @Override
    public void glGenFramebuffersEXT(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenFramebuffersEXT(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glGenFramebuffersEXT(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glBindRenderbufferEXT(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindRenderbufferEXT(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBindRenderbufferEXT(n, n2);
        this.println("");
    }

    @Override
    public void glRenderbufferStorageEXT(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glRenderbufferStorageEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glRenderbufferStorageEXT(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glBindFramebufferEXT(int n, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glBindFramebufferEXT(").append(n).append(",").append(n2).append(")").toString());
        this.downstreamGL.glBindFramebufferEXT(n, n2);
        this.println("");
    }

    @Override
    public void glFramebufferRenderbufferEXT(int n, int n2, int n3, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glFramebufferRenderbufferEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(")").toString());
        this.downstreamGL.glFramebufferRenderbufferEXT(n, n2, n3, n4);
        this.println("");
    }

    @Override
    public void glFramebufferTexture1DEXT(int n, int n2, int n3, int n4, int n5) {
        this.printIndent();
        this.print(new StringBuffer().append("glFramebufferTexture1DEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(")").toString());
        this.downstreamGL.glFramebufferTexture1DEXT(n, n2, n3, n4, n5);
        this.println("");
    }

    @Override
    public void glFramebufferTexture2DEXT(int n, int n2, int n3, int n4, int n5) {
        this.printIndent();
        this.print(new StringBuffer().append("glFramebufferTexture2DEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(")").toString());
        this.downstreamGL.glFramebufferTexture2DEXT(n, n2, n3, n4, n5);
        this.println("");
    }

    @Override
    public void glFramebufferTexture3DEXT(int n, int n2, int n3, int n4, int n5, int n6) {
        this.printIndent();
        this.print(new StringBuffer().append("glFramebufferTexture3DEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(n4).append(",").append(n5).append(",").append(n6).append(")").toString());
        this.downstreamGL.glFramebufferTexture3DEXT(n, n2, n3, n4, n5, n6);
        this.println("");
    }

    @Override
    public int glCheckFramebufferStatusEXT(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glCheckFramebufferStatusEXT(").append(n).append(")").toString());
        int n2 = this.downstreamGL.glCheckFramebufferStatusEXT(n);
        this.println(new StringBuffer().append(" = ").append(n2).toString());
        return n2;
    }

    @Override
    public void glDeleteRenderbuffersEXT(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteRenderbuffersEXT(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glDeleteRenderbuffersEXT(n, intBuffer);
        this.println("");
    }

    @Override
    public void glDeleteRenderbuffersEXT(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteRenderbuffersEXT(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDeleteRenderbuffersEXT(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glDeleteFramebuffersEXT(int n, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteFramebuffersEXT(").append(n).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glDeleteFramebuffersEXT(n, intBuffer);
        this.println("");
    }

    @Override
    public void glDeleteFramebuffersEXT(int n, int[] nArray, int n2) {
        this.printIndent();
        this.print(new StringBuffer().append("glDeleteFramebuffersEXT(").append(n).append(",").append(this.dumpArray(nArray)).append(",").append(n2).append(")").toString());
        this.downstreamGL.glDeleteFramebuffersEXT(n, nArray, n2);
        this.println("");
    }

    @Override
    public void glGetRenderbufferParameterivEXT(int n, int n2, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetRenderbufferParameterivEXT(").append(n).append(",").append(n2).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetRenderbufferParameterivEXT(n, n2, intBuffer);
        this.println("");
    }

    @Override
    public void glGetRenderbufferParameterivEXT(int n, int n2, int[] nArray, int n3) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetRenderbufferParameterivEXT(").append(n).append(",").append(n2).append(",").append(this.dumpArray(nArray)).append(",").append(n3).append(")").toString());
        this.downstreamGL.glGetRenderbufferParameterivEXT(n, n2, nArray, n3);
        this.println("");
    }

    @Override
    public boolean glIsRenderbufferEXT(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsRenderbufferEXT(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsRenderbufferEXT(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public boolean glIsFramebufferEXT(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glIsFramebufferEXT(").append(n).append(")").toString());
        boolean bl = this.downstreamGL.glIsFramebufferEXT(n);
        this.println(new StringBuffer().append(" = ").append(bl).toString());
        return bl;
    }

    @Override
    public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, IntBuffer intBuffer) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetFramebufferAttachmentParameterivEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(intBuffer).append(")").toString());
        this.downstreamGL.glGetFramebufferAttachmentParameterivEXT(n, n2, n3, intBuffer);
        this.println("");
    }

    @Override
    public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, int[] nArray, int n4) {
        this.printIndent();
        this.print(new StringBuffer().append("glGetFramebufferAttachmentParameterivEXT(").append(n).append(",").append(n2).append(",").append(n3).append(",").append(this.dumpArray(nArray)).append(",").append(n4).append(")").toString());
        this.downstreamGL.glGetFramebufferAttachmentParameterivEXT(n, n2, n3, nArray, n4);
        this.println("");
    }

    @Override
    public void glGenerateMipmapEXT(int n) {
        this.printIndent();
        this.print(new StringBuffer().append("glGenerateMipmapEXT(").append(n).append(")").toString());
        this.downstreamGL.glGenerateMipmapEXT(n);
        this.println("");
    }

    protected String dumpArray(Object object) {
        if (object == null) {
            return "[null]";
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int n = Array.getLength(object);
        int n2 = Math.min(n, 16);
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(Array.get(object, i2));
            if (i2 >= n2 - 1) continue;
            stringBuffer.append(',');
        }
        if (n > 16) {
            stringBuffer.append("...").append(n);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    protected void print(String string) {
        this.stream.print(string);
    }

    protected void println(String string) {
        this.stream.println(string);
    }

    protected void printIndent() {
        for (int i2 = 0; i2 < this.indent; ++i2) {
            this.stream.print(' ');
        }
    }
}

