/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.opengl.impl.GLBufferSizeTracker;
import com.sun.opengl.impl.GLBufferStateTracker;
import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.impl.GLObjectTracker;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class GLImpl
implements GL {
    private GLObjectTracker tracker;
    private GLContextImpl _context;
    private int[] imageSizeTemp = new int[1];
    private boolean bufferObjectExtensionsInitialized = false;
    private boolean haveARBPixelBufferObject;
    private boolean haveEXTPixelBufferObject;
    private boolean haveGLES11;
    private boolean haveGLES20;
    private boolean haveARBVertexBufferObject;
    private GLBufferStateTracker bufferStateTracker = new GLBufferStateTracker();
    private GLBufferSizeTracker bufferSizeTracker;

    @Override
    public native void glActiveTexture(int n) {
    }

    @Override
    public native void glAttachShader(int n, int n2) {
    }

    @Override
    public native void glBindAttribLocation(int n, int n2, String string) {
    }

    @Override
    public void glBindBuffer(int n, int n2) {
        this.glBindBuffer0(n, n2);
        this.bufferStateTracker.setBoundBufferObject(n, n2);
    }

    private native void glBindBuffer0(int n, int n2) {
    }

    @Override
    public native void glBindFramebuffer(int n, int n2) {
    }

    @Override
    public native void glBindRenderbuffer(int n, int n2) {
    }

    @Override
    public native void glBindTexture(int n, int n2) {
    }

    @Override
    public native void glBlendColor(float f2, float f3, float f4, float f5) {
    }

    @Override
    public native void glBlendEquation(int n) {
    }

    @Override
    public native void glBlendEquationSeparate(int n, int n2) {
    }

    @Override
    public native void glBlendFunc(int n, int n2) {
    }

    @Override
    public native void glBlendFuncSeparate(int n, int n2, int n3, int n4) {
    }

    @Override
    public void glBufferData(int n, int n2, Buffer buffer, int n3) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"data\" was not a direct buffer");
        }
        this.glBufferData0(n, n2, buffer, BufferFactory.getDirectBufferByteOffset(buffer), n3);
        this.bufferSizeTracker.setBufferSize(this.bufferStateTracker, n, this, n2);
    }

    private native void glBufferData0(int n, int n2, Object object, int n3, int n4) {
    }

    @Override
    public void glBufferSubData(int n, int n2, int n3, Buffer buffer) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"data\" was not a direct buffer");
        }
        this.glBufferSubData0(n, n2, n3, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private native void glBufferSubData0(int n, int n2, int n3, Object object, int n4) {
    }

    @Override
    public native int glCheckFramebufferStatus(int n) {
    }

    @Override
    public native void glClear(int n) {
    }

    @Override
    public native void glClearColor(float f2, float f3, float f4, float f5) {
    }

    @Override
    public native void glClearDepthf(float f2) {
    }

    @Override
    public native void glClearStencil(int n) {
    }

    @Override
    public native void glColorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    @Override
    public native void glCompileShader(int n) {
    }

    @Override
    public void glCompressedTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"data\" was not a direct buffer");
        }
        this.glCompressedTexImage2D0(n, n2, n3, n4, n5, n6, n7, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private native void glCompressedTexImage2D0(int n, int n2, int n3, int n4, int n5, int n6, int n7, Object object, int n8) {
    }

    @Override
    public void glCompressedTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"data\" was not a direct buffer");
        }
        this.glCompressedTexSubImage2D0(n, n2, n3, n4, n5, n6, n7, n8, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private native void glCompressedTexSubImage2D0(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Object object, int n9) {
    }

    @Override
    public native void glCopyTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    @Override
    public native void glCopyTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    @Override
    public void glCoverageMaskNV(boolean bl) {
        long l = this._context.getGLProcAddressTable()._addressof_glCoverageMaskNV;
        if (l == 0L) {
            throw new GLException("Method \"glCoverageMaskNV\" not available");
        }
        this.dispatch_glCoverageMaskNV0(bl, l);
    }

    public native void dispatch_glCoverageMaskNV0(boolean bl, long l) {
    }

    @Override
    public void glCoverageOperationNV(int n) {
        long l = this._context.getGLProcAddressTable()._addressof_glCoverageOperationNV;
        if (l == 0L) {
            throw new GLException("Method \"glCoverageOperationNV\" not available");
        }
        this.dispatch_glCoverageOperationNV0(n, l);
    }

    public native void dispatch_glCoverageOperationNV0(int n, long l) {
    }

    @Override
    public int glCreateProgram() {
        int n = this.glCreateProgram0();
        if (this.tracker != null) {
            this.tracker.addProgramObject(n);
        }
        return n;
    }

    private native int glCreateProgram0() {
    }

    @Override
    public int glCreateShader(int n) {
        int n2 = this.glCreateShader0(n);
        if (this.tracker != null) {
            this.tracker.addShaderObject(n2);
        }
        return n2;
    }

    private native int glCreateShader0(int n) {
    }

    @Override
    public native void glCullFace(int n) {
    }

    @Override
    public void glDeleteBuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glDeleteBuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glDeleteBuffers1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.removeBuffers(n, intBuffer);
        }
    }

    private native void glDeleteBuffers0(int n, Object object, int n2) {
    }

    private native void glDeleteBuffers1(int n, Object object, int n2) {
    }

    @Override
    public void glDeleteBuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"buffers_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glDeleteBuffers1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.removeBuffers(n, nArray, n2);
        }
    }

    @Override
    public void glDeleteFramebuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glDeleteFramebuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glDeleteFramebuffers1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.removeFramebuffers(n, intBuffer);
        }
    }

    private native void glDeleteFramebuffers0(int n, Object object, int n2) {
    }

    private native void glDeleteFramebuffers1(int n, Object object, int n2) {
    }

    @Override
    public void glDeleteFramebuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"framebuffers_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glDeleteFramebuffers1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.removeFramebuffers(n, nArray, n2);
        }
    }

    @Override
    public void glDeleteProgram(int n) {
        this.glDeleteProgram0(n);
        if (this.tracker != null) {
            this.tracker.removeProgramObject(n);
        }
    }

    private native void glDeleteProgram0(int n) {
    }

    @Override
    public void glDeleteRenderbuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glDeleteRenderbuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glDeleteRenderbuffers1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.removeRenderbuffers(n, intBuffer);
        }
    }

    private native void glDeleteRenderbuffers0(int n, Object object, int n2) {
    }

    private native void glDeleteRenderbuffers1(int n, Object object, int n2) {
    }

    @Override
    public void glDeleteRenderbuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"renderbuffers_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glDeleteRenderbuffers1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.removeRenderbuffers(n, nArray, n2);
        }
    }

    @Override
    public void glDeleteShader(int n) {
        this.glDeleteShader0(n);
        if (this.tracker != null) {
            this.tracker.removeShaderObject(n);
        }
    }

    private native void glDeleteShader0(int n) {
    }

    @Override
    public void glDeleteTextures(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glDeleteTextures0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glDeleteTextures1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.removeTextures(n, intBuffer);
        }
    }

    private native void glDeleteTextures0(int n, Object object, int n2) {
    }

    private native void glDeleteTextures1(int n, Object object, int n2) {
    }

    @Override
    public void glDeleteTextures(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"textures_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glDeleteTextures1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.removeTextures(n, nArray, n2);
        }
    }

    @Override
    public native void glDepthFunc(int n) {
    }

    @Override
    public native void glDepthMask(boolean bl) {
    }

    @Override
    public native void glDepthRangef(float f2, float f3) {
    }

    @Override
    public native void glDetachShader(int n, int n2) {
    }

    @Override
    public native void glDisable(int n) {
    }

    @Override
    public native void glDisableVertexAttribArray(int n) {
    }

    @Override
    public native void glDrawArrays(int n, int n2, int n3) {
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, Buffer buffer) {
        this.checkElementVBODisabled();
        BufferFactory.rangeCheck(buffer, n2);
        boolean bl = BufferFactory.isDirect(buffer);
        if (bl) {
            this.glDrawElements0(n, n2, n3, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
        } else {
            this.glDrawElements1(n, n2, n3, BufferFactory.getArray(buffer), BufferFactory.getIndirectBufferByteOffset(buffer));
        }
    }

    private native void glDrawElements0(int n, int n2, int n3, Object object, int n4) {
    }

    private native void glDrawElements1(int n, int n2, int n3, Object object, int n4) {
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, long l) {
        this.checkElementVBOEnabled();
        this.glDrawElements0(n, n2, n3, l);
    }

    private native void glDrawElements0(int n, int n2, int n3, long l) {
    }

    @Override
    public native void glEnable(int n) {
    }

    @Override
    public native void glEnableVertexAttribArray(int n) {
    }

    @Override
    public native void glFinish() {
    }

    @Override
    public native void glFlush() {
    }

    @Override
    public native void glFramebufferRenderbuffer(int n, int n2, int n3, int n4) {
    }

    @Override
    public native void glFramebufferTexture2D(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public native void glFrontFace(int n) {
    }

    @Override
    public void glGenBuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGenBuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGenBuffers1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.addBuffers(n, intBuffer);
        }
    }

    private native void glGenBuffers0(int n, Object object, int n2) {
    }

    private native void glGenBuffers1(int n, Object object, int n2) {
    }

    @Override
    public void glGenBuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"buffers_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenBuffers1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.addBuffers(n, nArray, n2);
        }
    }

    @Override
    public void glGenFramebuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGenFramebuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGenFramebuffers1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.addFramebuffers(n, intBuffer);
        }
    }

    private native void glGenFramebuffers0(int n, Object object, int n2) {
    }

    private native void glGenFramebuffers1(int n, Object object, int n2) {
    }

    @Override
    public void glGenFramebuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"framebuffers_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenFramebuffers1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.addFramebuffers(n, nArray, n2);
        }
    }

    @Override
    public void glGenRenderbuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGenRenderbuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGenRenderbuffers1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.addRenderbuffers(n, intBuffer);
        }
    }

    private native void glGenRenderbuffers0(int n, Object object, int n2) {
    }

    private native void glGenRenderbuffers1(int n, Object object, int n2) {
    }

    @Override
    public void glGenRenderbuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"renderbuffers_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenRenderbuffers1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.addRenderbuffers(n, nArray, n2);
        }
    }

    @Override
    public void glGenTextures(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGenTextures0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGenTextures1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
        if (this.tracker != null) {
            this.tracker.addTextures(n, intBuffer);
        }
    }

    private native void glGenTextures0(int n, Object object, int n2) {
    }

    private native void glGenTextures1(int n, Object object, int n2) {
    }

    @Override
    public void glGenTextures(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"textures_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenTextures1(n, nArray, 4 * n2);
        if (this.tracker != null) {
            this.tracker.addTextures(n, nArray, n2);
        }
    }

    @Override
    public native void glGenerateMipmap(int n) {
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"size\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new GLException("Argument \"type\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (byteBuffer != null && bl != BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"name\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            this.glGetActiveAttrib0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
        } else {
            this.glGetActiveAttrib1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3), BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer));
        }
    }

    private native void glGetActiveAttrib0(int n, int n2, int n3, Object object, int n4, Object object2, int n5, Object object3, int n6, Object object4, int n7) {
    }

    private native void glGetActiveAttrib1(int n, int n2, int n3, Object object, int n4, Object object2, int n5, Object object3, int n6, Object object4, int n7) {
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n5) {
            throw new GLException(new StringBuffer().append("array offset argument \"size_offset\" (").append(n5).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n6) {
            throw new GLException(new StringBuffer().append("array offset argument \"type_offset\" (").append(n6).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n7) {
            throw new GLException(new StringBuffer().append("array offset argument \"name_offset\" (").append(n7).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetActiveAttrib1(n, n2, n3, nArray, 4 * n4, nArray2, 4 * n5, nArray3, 4 * n6, byArray, n7);
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"size\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new GLException("Argument \"type\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (byteBuffer != null && bl != BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"name\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            this.glGetActiveUniform0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
        } else {
            this.glGetActiveUniform1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3), BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer));
        }
    }

    private native void glGetActiveUniform0(int n, int n2, int n3, Object object, int n4, Object object2, int n5, Object object3, int n6, Object object4, int n7) {
    }

    private native void glGetActiveUniform1(int n, int n2, int n3, Object object, int n4, Object object2, int n5, Object object3, int n6, Object object4, int n7) {
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n5) {
            throw new GLException(new StringBuffer().append("array offset argument \"size_offset\" (").append(n5).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n6) {
            throw new GLException(new StringBuffer().append("array offset argument \"type_offset\" (").append(n6).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n7) {
            throw new GLException(new StringBuffer().append("array offset argument \"name_offset\" (").append(n7).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetActiveUniform1(n, n2, n3, nArray, 4 * n4, nArray2, 4 * n5, nArray3, 4 * n6, byArray, n7);
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"shaders\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            this.glGetAttachedShaders0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2));
        } else {
            this.glGetAttachedShaders1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2));
        }
    }

    private native void glGetAttachedShaders0(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    private native void glGetAttachedShaders1(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"count_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"shaders_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        this.glGetAttachedShaders1(n, n2, nArray, 4 * n3, nArray2, 4 * n4);
    }

    @Override
    public native int glGetAttribLocation(int n, String string) {
    }

    @Override
    public void glGetBooleanv(int n, ByteBuffer byteBuffer) {
        boolean bl = BufferFactory.isDirect(byteBuffer);
        if (bl) {
            this.glGetBooleanv0(n, byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
        } else {
            this.glGetBooleanv1(n, BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer));
        }
    }

    private native void glGetBooleanv0(int n, Object object, int n2) {
    }

    private native void glGetBooleanv1(int n, Object object, int n2) {
    }

    @Override
    public void glGetBooleanv(int n, byte[] byArray, int n2) {
        if (byArray != null && byArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n2).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetBooleanv1(n, byArray, n2);
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetBufferParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetBufferParameteriv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetBufferParameteriv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetBufferParameteriv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetBufferParameteriv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native int glGetError() {
    }

    @Override
    public void glGetFloatv(int n, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glGetFloatv0(n, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glGetFloatv1(n, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glGetFloatv0(int n, Object object, int n2) {
    }

    private native void glGetFloatv1(int n, Object object, int n2) {
    }

    @Override
    public void glGetFloatv(int n, float[] fArray, int n2) {
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n2).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetFloatv1(n, fArray, 4 * n2);
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetFramebufferAttachmentParameteriv0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetFramebufferAttachmentParameteriv1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetFramebufferAttachmentParameteriv0(int n, int n2, int n3, Object object, int n4) {
    }

    private native void glGetFramebufferAttachmentParameteriv1(int n, int n2, int n3, Object object, int n4) {
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetFramebufferAttachmentParameteriv1(n, n2, n3, nArray, 4 * n4);
    }

    @Override
    public void glGetIntegerv(int n, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetIntegerv0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetIntegerv1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetIntegerv0(int n, Object object, int n2) {
    }

    private native void glGetIntegerv1(int n, Object object, int n2) {
    }

    @Override
    public void glGetIntegerv(int n, int[] nArray, int n2) {
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetIntegerv1(n, nArray, 4 * n2);
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (byteBuffer != null && bl != BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"infolog\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            this.glGetProgramInfoLog0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
        } else {
            this.glGetProgramInfoLog1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer));
        }
    }

    private native void glGetProgramInfoLog0(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    private native void glGetProgramInfoLog1(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"infolog_offset\" (").append(n4).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetProgramInfoLog1(n, n2, nArray, 4 * n3, byArray, n4);
    }

    @Override
    public void glGetProgramiv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetProgramiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetProgramiv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetProgramiv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetProgramiv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetProgramiv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetProgramiv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetRenderbufferParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetRenderbufferParameteriv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetRenderbufferParameteriv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetRenderbufferParameteriv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetRenderbufferParameteriv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (byteBuffer != null && bl != BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"infolog\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            this.glGetShaderInfoLog0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
        } else {
            this.glGetShaderInfoLog1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer));
        }
    }

    private native void glGetShaderInfoLog0(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    private native void glGetShaderInfoLog1(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"infolog_offset\" (").append(n4).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetShaderInfoLog1(n, n2, nArray, 4 * n3, byArray, n4);
    }

    @Override
    public void glGetShaderPrecisionFormat(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"range\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"precision\" was not a direct buffer");
        }
        this.glGetShaderPrecisionFormat0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2));
    }

    private native void glGetShaderPrecisionFormat0(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    @Override
    public void glGetShaderSource(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"source\" was not a direct buffer");
        }
        this.glGetShaderSource0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    private native void glGetShaderSource0(int n, int n2, Object object, int n3, Object object2, int n4) {
    }

    @Override
    public void glGetShaderiv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetShaderiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetShaderiv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetShaderiv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetShaderiv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetShaderiv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetShaderiv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native String glGetString(int n) {
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glGetTexParameterfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glGetTexParameterfv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glGetTexParameterfv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetTexParameterfv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetTexParameterfv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetTexParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetTexParameteriv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetTexParameteriv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetTexParameteriv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetTexParameteriv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native int glGetUniformLocation(int n, String string) {
    }

    @Override
    public void glGetUniformfv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glGetUniformfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glGetUniformfv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glGetUniformfv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetUniformfv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetUniformfv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetUniformfv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public void glGetUniformiv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetUniformiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetUniformiv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetUniformiv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetUniformiv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetUniformiv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetUniformiv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glGetVertexAttribfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glGetVertexAttribfv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glGetVertexAttribfv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetVertexAttribfv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetVertexAttribfv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glGetVertexAttribiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glGetVertexAttribiv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glGetVertexAttribiv0(int n, int n2, Object object, int n3) {
    }

    private native void glGetVertexAttribiv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetVertexAttribiv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native void glHint(int n, int n2) {
    }

    @Override
    public native boolean glIsBuffer(int n) {
    }

    @Override
    public native boolean glIsEnabled(int n) {
    }

    @Override
    public native boolean glIsFramebuffer(int n) {
    }

    @Override
    public native boolean glIsProgram(int n) {
    }

    @Override
    public native boolean glIsRenderbuffer(int n) {
    }

    @Override
    public native boolean glIsShader(int n) {
    }

    @Override
    public native boolean glIsTexture(int n) {
    }

    @Override
    public native void glLineWidth(float f2) {
    }

    @Override
    public native void glLinkProgram(int n) {
    }

    @Override
    public native void glPixelStorei(int n, int n2) {
    }

    @Override
    public native void glPolygonOffset(float f2, float f3) {
    }

    @Override
    public void glReadPixels(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        BufferFactory.rangeCheckBytes(buffer, this.imageSizeInBytes(n5, n6, n3, n4, 1, 2, true));
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"pixels\" was not a direct buffer");
        }
        this.glReadPixels0(n, n2, n3, n4, n5, n6, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private native void glReadPixels0(int n, int n2, int n3, int n4, int n5, int n6, Object object, int n7) {
    }

    @Override
    public native void glReleaseShaderCompiler() {
    }

    @Override
    public native void glRenderbufferStorage(int n, int n2, int n3, int n4) {
    }

    @Override
    public native void glSampleCoverage(float f2, boolean bl) {
    }

    @Override
    public native void glScissor(int n, int n2, int n3, int n4) {
    }

    @Override
    public void glShaderBinary(int n, IntBuffer intBuffer, int n2, Buffer buffer, int n3) {
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"shaders\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"binary\" was not a direct buffer");
        }
        this.glShaderBinary0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), n2, buffer, BufferFactory.getDirectBufferByteOffset(buffer), n3);
    }

    private native void glShaderBinary0(int n, Object object, int n2, int n3, Object object2, int n4, int n5) {
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glShaderSource0(n, n2, stringArray, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glShaderSource1(n, n2, stringArray, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glShaderSource0(int n, int n2, String[] stringArray, Object object, int n3) {
    }

    private native void glShaderSource1(int n, int n2, String[] stringArray, Object object, int n3) {
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glShaderSource1(n, n2, stringArray, nArray, 4 * n3);
    }

    @Override
    public native void glStencilFunc(int n, int n2, int n3) {
    }

    @Override
    public native void glStencilFuncSeparate(int n, int n2, int n3, int n4) {
    }

    @Override
    public native void glStencilMask(int n) {
    }

    @Override
    public native void glStencilMaskSeparate(int n, int n2) {
    }

    @Override
    public native void glStencilOp(int n, int n2, int n3) {
    }

    @Override
    public native void glStencilOpSeparate(int n, int n2, int n3, int n4) {
    }

    @Override
    public void glTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        BufferFactory.rangeCheckBytes(buffer, this.imageSizeInBytes(n7, n8, n4, n5, 1, 2, false));
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"pixels\" was not a direct buffer");
        }
        this.glTexImage2D0(n, n2, n3, n4, n5, n6, n7, n8, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private native void glTexImage2D0(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Object object, int n9) {
    }

    @Override
    public native void glTexParameterf(int n, int n2, float f2) {
    }

    @Override
    public void glTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glTexParameterfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glTexParameterfv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glTexParameterfv0(int n, int n2, Object object, int n3) {
    }

    private native void glTexParameterfv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glTexParameterfv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glTexParameterfv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public native void glTexParameteri(int n, int n2, int n3) {
    }

    @Override
    public void glTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glTexParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glTexParameteriv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glTexParameteriv0(int n, int n2, Object object, int n3) {
    }

    private native void glTexParameteriv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glTexParameteriv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glTexParameteriv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public void glTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        BufferFactory.rangeCheckBytes(buffer, this.imageSizeInBytes(n7, n8, n5, n6, 1, 2, false));
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"pixels\" was not a direct buffer");
        }
        this.glTexSubImage2D0(n, n2, n3, n4, n5, n6, n7, n8, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private native void glTexSubImage2D0(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Object object, int n9) {
    }

    @Override
    public native void glUniform1f(int n, float f2) {
    }

    @Override
    public void glUniform1fv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glUniform1fv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniform1fv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniform1fv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform1fv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform1fv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniform1fv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public native void glUniform1i(int n, int n2) {
    }

    @Override
    public void glUniform1iv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glUniform1iv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glUniform1iv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glUniform1iv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform1iv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform1iv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glUniform1iv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native void glUniform2f(int n, float f2, float f3) {
    }

    @Override
    public void glUniform2fv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glUniform2fv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniform2fv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniform2fv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform2fv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform2fv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniform2fv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public native void glUniform2i(int n, int n2, int n3) {
    }

    @Override
    public void glUniform2iv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glUniform2iv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glUniform2iv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glUniform2iv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform2iv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform2iv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glUniform2iv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native void glUniform3f(int n, float f2, float f3, float f4) {
    }

    @Override
    public void glUniform3fv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glUniform3fv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniform3fv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniform3fv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform3fv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform3fv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniform3fv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public native void glUniform3i(int n, int n2, int n3, int n4) {
    }

    @Override
    public void glUniform3iv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glUniform3iv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glUniform3iv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glUniform3iv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform3iv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform3iv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glUniform3iv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public native void glUniform4f(int n, float f2, float f3, float f4, float f5) {
    }

    @Override
    public void glUniform4fv(int n, int n2, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glUniform4fv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniform4fv1(n, n2, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniform4fv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform4fv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform4fv(int n, int n2, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniform4fv1(n, n2, fArray, 4 * n3);
    }

    @Override
    public native void glUniform4i(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void glUniform4iv(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            this.glUniform4iv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            this.glUniform4iv1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private native void glUniform4iv0(int n, int n2, Object object, int n3) {
    }

    private native void glUniform4iv1(int n, int n2, Object object, int n3) {
    }

    @Override
    public void glUniform4iv(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        this.glUniform4iv1(n, n2, nArray, 4 * n3);
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        boolean bl2 = BufferFactory.isDirect(floatBuffer);
        if (bl2) {
            this.glUniformMatrix2fv0(n, n2, bl, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniformMatrix2fv1(n, n2, bl, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniformMatrix2fv0(int n, int n2, boolean bl, Object object, int n3) {
    }

    private native void glUniformMatrix2fv1(int n, int n2, boolean bl, Object object, int n3) {
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniformMatrix2fv1(n, n2, bl, fArray, 4 * n3);
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        boolean bl2 = BufferFactory.isDirect(floatBuffer);
        if (bl2) {
            this.glUniformMatrix3fv0(n, n2, bl, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniformMatrix3fv1(n, n2, bl, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniformMatrix3fv0(int n, int n2, boolean bl, Object object, int n3) {
    }

    private native void glUniformMatrix3fv1(int n, int n2, boolean bl, Object object, int n3) {
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniformMatrix3fv1(n, n2, bl, fArray, 4 * n3);
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        boolean bl2 = BufferFactory.isDirect(floatBuffer);
        if (bl2) {
            this.glUniformMatrix4fv0(n, n2, bl, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glUniformMatrix4fv1(n, n2, bl, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glUniformMatrix4fv0(int n, int n2, boolean bl, Object object, int n3) {
    }

    private native void glUniformMatrix4fv1(int n, int n2, boolean bl, Object object, int n3) {
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n3).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glUniformMatrix4fv1(n, n2, bl, fArray, 4 * n3);
    }

    @Override
    public native void glUseProgram(int n) {
    }

    @Override
    public native void glValidateProgram(int n) {
    }

    @Override
    public native void glVertexAttrib1f(int n, float f2) {
    }

    @Override
    public void glVertexAttrib1fv(int n, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glVertexAttrib1fv0(n, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glVertexAttrib1fv1(n, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glVertexAttrib1fv0(int n, Object object, int n2) {
    }

    private native void glVertexAttrib1fv1(int n, Object object, int n2) {
    }

    @Override
    public void glVertexAttrib1fv(int n, float[] fArray, int n2) {
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glVertexAttrib1fv1(n, fArray, 4 * n2);
    }

    @Override
    public native void glVertexAttrib2f(int n, float f2, float f3) {
    }

    @Override
    public void glVertexAttrib2fv(int n, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glVertexAttrib2fv0(n, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glVertexAttrib2fv1(n, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glVertexAttrib2fv0(int n, Object object, int n2) {
    }

    private native void glVertexAttrib2fv1(int n, Object object, int n2) {
    }

    @Override
    public void glVertexAttrib2fv(int n, float[] fArray, int n2) {
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glVertexAttrib2fv1(n, fArray, 4 * n2);
    }

    @Override
    public native void glVertexAttrib3f(int n, float f2, float f3, float f4) {
    }

    @Override
    public void glVertexAttrib3fv(int n, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glVertexAttrib3fv0(n, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glVertexAttrib3fv1(n, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glVertexAttrib3fv0(int n, Object object, int n2) {
    }

    private native void glVertexAttrib3fv1(int n, Object object, int n2) {
    }

    @Override
    public void glVertexAttrib3fv(int n, float[] fArray, int n2) {
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glVertexAttrib3fv1(n, fArray, 4 * n2);
    }

    @Override
    public native void glVertexAttrib4f(int n, float f2, float f3, float f4, float f5) {
    }

    @Override
    public void glVertexAttrib4fv(int n, FloatBuffer floatBuffer) {
        boolean bl = BufferFactory.isDirect(floatBuffer);
        if (bl) {
            this.glVertexAttrib4fv0(n, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
        } else {
            this.glVertexAttrib4fv1(n, BufferFactory.getArray(floatBuffer), BufferFactory.getIndirectBufferByteOffset(floatBuffer));
        }
    }

    private native void glVertexAttrib4fv0(int n, Object object, int n2) {
    }

    private native void glVertexAttrib4fv1(int n, Object object, int n2) {
    }

    @Override
    public void glVertexAttrib4fv(int n, float[] fArray, int n2) {
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exceeds array length (").append(fArray.length).append(")").toString());
        }
        this.glVertexAttrib4fv1(n, fArray, 4 * n2);
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, Buffer buffer) {
        this.checkArrayVBODisabled();
        BufferFactory.rangeCheck(buffer, 1);
        boolean bl2 = BufferFactory.isDirect(buffer);
        if (bl2) {
            this.glVertexAttribPointer0(n, n2, n3, bl, n4, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
        } else {
            this.glVertexAttribPointer1(n, n2, n3, bl, n4, BufferFactory.getArray(buffer), BufferFactory.getIndirectBufferByteOffset(buffer));
        }
    }

    private native void glVertexAttribPointer0(int n, int n2, int n3, boolean bl, int n4, Object object, int n5) {
    }

    private native void glVertexAttribPointer1(int n, int n2, int n3, boolean bl, int n4, Object object, int n5) {
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, long l) {
        this.checkArrayVBOEnabled();
        this.glVertexAttribPointer0(n, n2, n3, bl, n4, l);
    }

    private native void glVertexAttribPointer0(int n, int n2, int n3, boolean bl, int n4, long l) {
    }

    @Override
    public native void glViewport(int n, int n2, int n3, int n4) {
    }

    public GLImpl(GLContextImpl gLContextImpl) {
        this._context = gLContextImpl;
        this.bufferSizeTracker = gLContextImpl.getBufferSizeTracker();
    }

    @Override
    public boolean isFunctionAvailable(String string) {
        return false;
    }

    @Override
    public boolean isExtensionAvailable(String string) {
        return this._context.isExtensionAvailable(string);
    }

    @Override
    public Object getExtension(String string) {
        return null;
    }

    public GLContext getContext() {
        return this._context;
    }

    @Override
    public void setSwapInterval(int n) {
        this._context.setSwapInterval(n);
    }

    @Override
    public Object getPlatformGLExtensions() {
        return this._context.getPlatformGLExtensions();
    }

    public void setObjectTracker(GLObjectTracker gLObjectTracker) {
        this.tracker = gLObjectTracker;
    }

    private int imageSizeInBytes(int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        int n7 = 0;
        int n8 = 0;
        if (n3 < 0) {
            return 0;
        }
        if (n4 < 0) {
            return 0;
        }
        if (n5 < 0) {
            return 0;
        }
        switch (n) {
            case 6401: {
                n7 = 1;
                break;
            }
            case 6402: 
            case 6406: 
            case 6409: {
                n7 = 1;
                break;
            }
            case 6410: {
                n7 = 2;
                break;
            }
            case 6407: {
                n7 = 3;
                break;
            }
            case 6408: {
                n7 = 4;
                break;
            }
            default: {
                return 0;
            }
        }
        switch (n2) {
            case 5120: 
            case 5121: {
                n8 = 1;
                break;
            }
            case 5122: 
            case 5123: {
                n8 = 2;
                break;
            }
            case 32819: 
            case 32820: 
            case 33635: {
                n8 = 2;
                n7 = 1;
                break;
            }
            case 5124: 
            case 5125: 
            case 5126: {
                n8 = 4;
                break;
            }
            default: {
                return 0;
            }
        }
        return this.imageSizeInBytes(n7 * n8, n3, n4, n5, n6, bl);
    }

    private int imageSizeInBytes(int n, int n2, int n3, int n4, int n5, boolean bl) {
        int n6;
        int n7 = 1;
        if (bl) {
            this.glGetIntegerv(3333, this.imageSizeTemp, 0);
            n7 = this.imageSizeTemp[0];
        } else {
            this.glGetIntegerv(3317, this.imageSizeTemp, 0);
            n7 = this.imageSizeTemp[0];
        }
        n7 = Math.max(1, n7);
        int n8 = n2 * n;
        if (n7 > 1 && (n6 = n8 % n7) > 0) {
            n8 += n7 - n6;
        }
        if (n5 == 1) {
            return n8;
        }
        return n3 * n8;
    }

    private void initBufferObjectExtensionChecks() {
        if (this.bufferObjectExtensionsInitialized) {
            return;
        }
        this.bufferObjectExtensionsInitialized = true;
        this.haveARBPixelBufferObject = this.isExtensionAvailable("GL_ARB_pixel_buffer_object");
        this.haveEXTPixelBufferObject = this.isExtensionAvailable("GL_EXT_pixel_buffer_object");
        this.haveGLES11 = this.isExtensionAvailable("GL_ES_VERSION_1_1");
        this.haveGLES20 = this.isExtensionAvailable("GL_ES_VERSION_2_0");
        this.haveARBVertexBufferObject = this.isExtensionAvailable("GL_ARB_vertex_buffer_object");
    }

    private void checkBufferObject(boolean bl, boolean bl2, boolean bl3, boolean bl4, int n, String string) {
        boolean bl5;
        boolean bl6 = bl5 = bl || bl2 || bl3;
        if (!bl5) {
            if (!bl4) {
                return;
            }
            throw new GLException("Required extensions not available to call this function");
        }
        int n2 = this.bufferStateTracker.getBoundBufferObject(n, this);
        if (bl4) {
            if (n2 == 0) {
                throw new GLException(new StringBuffer().append(string).append(" must be enabled to call this method").toString());
            }
        } else if (n2 != 0) {
            throw new GLException(new StringBuffer().append(string).append(" must be disabled to call this method").toString());
        }
    }

    private void checkArrayVBODisabled() {
        this.initBufferObjectExtensionChecks();
        this.checkBufferObject(this.haveGLES11 || this.haveGLES20, this.haveARBVertexBufferObject, false, false, -1836580864, "array vertex_buffer_object");
    }

    private void checkArrayVBOEnabled() {
        this.initBufferObjectExtensionChecks();
        this.checkBufferObject(this.haveGLES11 || this.haveGLES20, this.haveARBVertexBufferObject, false, true, -1836580864, "array vertex_buffer_object");
    }

    private void checkElementVBODisabled() {
        this.initBufferObjectExtensionChecks();
        this.checkBufferObject(this.haveGLES11 || this.haveGLES20, this.haveARBVertexBufferObject, false, false, -1819803648, "element vertex_buffer_object");
    }

    private void checkElementVBOEnabled() {
        this.initBufferObjectExtensionChecks();
        this.checkBufferObject(this.haveGLES11 || this.haveGLES20, this.haveARBVertexBufferObject, false, true, -1819803648, "element vertex_buffer_object");
    }

    private void throwUOException() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void glClientActiveTexture(int n) {
        this.throwUOException();
    }

    @Override
    public void glClipPlane(int n, FloatBuffer floatBuffer) {
        this.throwUOException();
    }

    @Override
    public void glClipPlane(int n, float[] fArray, int n2) {
        this.throwUOException();
    }

    @Override
    public void glColor4f(int n, int n2, int n3, int n4) {
        this.throwUOException();
    }

    @Override
    public void glColorPointer(int n, int n2, int n3, Buffer buffer) {
        this.throwUOException();
    }

    @Override
    public void glLoadIdentity() {
        this.throwUOException();
    }

    @Override
    public void glLoadMatrixf(FloatBuffer floatBuffer) {
        this.throwUOException();
    }

    @Override
    public void glLoadMatrixf(float[] fArray, int n) {
        this.throwUOException();
    }

    @Override
    public void glMatrixMode(int n) {
        this.throwUOException();
    }

    @Override
    public void glMultMatrixf(FloatBuffer floatBuffer) {
        this.throwUOException();
    }

    @Override
    public void glMultMatrixf(float[] fArray, int n) {
        this.throwUOException();
    }

    @Override
    public void glNormalPointer(int n, int n2, Buffer buffer) {
        this.throwUOException();
    }

    @Override
    public void glOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.throwUOException();
    }

    @Override
    public void glPopMatrix() {
        this.throwUOException();
    }

    @Override
    public void glPushMatrix() {
        this.throwUOException();
    }

    @Override
    public void glRotatef(float f2, float f3, float f4, float f5) {
        this.throwUOException();
    }

    @Override
    public void glRotate(double d2, double d3, double d4, double d5) {
        this.throwUOException();
    }

    @Override
    public void glScalef(float f2, float f3, float f4) {
        this.throwUOException();
    }

    @Override
    public void glScale(double d2, double d3, double d4) {
        this.throwUOException();
    }

    @Override
    public void glTexCoordPointer(int n, int n2, int n3, Buffer buffer) {
        this.throwUOException();
    }

    @Override
    public void glTranslatef(float f2, float f3, float f4) {
        this.throwUOException();
    }

    @Override
    public void glTranslate(double d2, double d3, double d4) {
        this.throwUOException();
    }

    @Override
    public void glVertexPointer(int n, int n2, int n3, Buffer buffer) {
        this.throwUOException();
    }

    public void glGetVertexAttribPointer(int n, int n2, Buffer[] bufferArray) {
        this.throwUOException();
    }

    @Override
    public void glClearDepth(double d2) {
        this.glClearDepthf((float)d2);
    }

    @Override
    public void glDepthRange(double d2, double d3) {
        this.glDepthRangef((float)d2, (float)d3);
    }

    @Override
    public void glGenRenderbuffersEXT(int n, IntBuffer intBuffer) {
        this.glGenRenderbuffers(n, intBuffer);
    }

    @Override
    public void glGenRenderbuffersEXT(int n, int[] nArray, int n2) {
        this.glGenRenderbuffers(n, nArray, n2);
    }

    @Override
    public void glGenFramebuffersEXT(int n, IntBuffer intBuffer) {
        this.glGenFramebuffers(n, intBuffer);
    }

    @Override
    public void glGenFramebuffersEXT(int n, int[] nArray, int n2) {
        this.glGenFramebuffers(n, nArray, n2);
    }

    @Override
    public void glBindRenderbufferEXT(int n, int n2) {
        this.glBindRenderbuffer(n, n2);
    }

    @Override
    public void glRenderbufferStorageEXT(int n, int n2, int n3, int n4) {
        this.glRenderbufferStorage(n, n2, n3, n4);
    }

    @Override
    public void glBindFramebufferEXT(int n, int n2) {
        this.glBindFramebuffer(n, n2);
    }

    @Override
    public void glFramebufferRenderbufferEXT(int n, int n2, int n3, int n4) {
        this.glFramebufferRenderbuffer(n, n2, n3, n4);
    }

    @Override
    public void glFramebufferTexture1DEXT(int n, int n2, int n3, int n4, int n5) {
        this.throwUOException();
    }

    @Override
    public void glFramebufferTexture2DEXT(int n, int n2, int n3, int n4, int n5) {
        this.glFramebufferTexture2D(n, n2, n3, n4, n5);
    }

    @Override
    public void glFramebufferTexture3DEXT(int n, int n2, int n3, int n4, int n5, int n6) {
        this.throwUOException();
    }

    @Override
    public int glCheckFramebufferStatusEXT(int n) {
        return this.glCheckFramebufferStatus(n);
    }

    @Override
    public void glDeleteRenderbuffersEXT(int n, IntBuffer intBuffer) {
        this.glDeleteRenderbuffers(n, intBuffer);
    }

    @Override
    public void glDeleteRenderbuffersEXT(int n, int[] nArray, int n2) {
        this.glDeleteRenderbuffers(n, nArray, n2);
    }

    @Override
    public void glDeleteFramebuffersEXT(int n, IntBuffer intBuffer) {
        this.glDeleteFramebuffers(n, intBuffer);
    }

    @Override
    public void glDeleteFramebuffersEXT(int n, int[] nArray, int n2) {
        this.glDeleteFramebuffers(n, nArray, n2);
    }

    @Override
    public void glGetRenderbufferParameterivEXT(int n, int n2, IntBuffer intBuffer) {
        this.glGetRenderbufferParameteriv(n, n2, intBuffer);
    }

    @Override
    public void glGetRenderbufferParameterivEXT(int n, int n2, int[] nArray, int n3) {
        this.glGetRenderbufferParameteriv(n, n2, nArray, n3);
    }

    @Override
    public boolean glIsRenderbufferEXT(int n) {
        return this.glIsRenderbuffer(n);
    }

    @Override
    public boolean glIsFramebufferEXT(int n) {
        return this.glIsFramebuffer(n);
    }

    @Override
    public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, IntBuffer intBuffer) {
        this.glGetFramebufferAttachmentParameteriv(n, n2, n3, intBuffer);
    }

    @Override
    public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, int[] nArray, int n4) {
        this.glGetFramebufferAttachmentParameteriv(n, n2, n3, nArray, n4);
    }

    @Override
    public void glGenerateMipmapEXT(int n) {
        this.glGenerateMipmap(n);
    }
}

