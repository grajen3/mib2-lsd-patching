/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.util.BufferUtil;
import com.sun.opengl.util.KernelTraceLogger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class GLImplCQ
implements GL {
    private static final int COMMAND_QUEUE_SIZE = Integer.parseInt(System.getProperty("jogl.commandQueueSize", "2048"));
    private static final int PARAMETER_QUEUE_SIZE = Integer.parseInt(System.getProperty("jogl.parameterQueueSize", "16384"));
    private static final int SIZEOF_BYTE;
    private static final int SIZEOF_SHORT;
    private static final int SIZEOF_FLOAT;
    private static final int SIZEOF_INT;
    private static final int SIZEOF_DOUBLE;
    private static final int SIZEOF_LONG;
    private GLContextImpl _context;
    private short[] commandQueue;
    private int[] intQueue;
    private float[] floatQueue;
    private byte[] byteQueue;
    private int commandQueuePosition;
    private int intQueuePosition;
    private int floatQueuePosition;
    private int byteQueuePosition;
    public static final int DEBUG_LEVEL_1;
    public static final int DEBUG_LEVEL_2;
    public static final int DEBUG_LEVEL_3;
    public static final int DEBUG_LEVEL_4;
    public static final int DEBUG_LEVEL_5;
    private int debugLevel = 3;
    private boolean debugQueue = false;
    private boolean kernelTracesEnabled = false;
    private boolean glFinishAfterFlushQueueEnabled = false;
    public static final int PERFORMANCE_STATISTICS_LEVEL_1;
    public static final int PERFORMANCE_STATISTICS_LEVEL_2;
    private int performanceStatisticsLevel = 1;
    private boolean performanceStatisticsEnabled = false;
    private ArrayList tmpBufferStorage = new ArrayList();
    private boolean jsr239_conform = false;
    private static final short CMD_GL_ACTIVE_TEXTURE_I;
    private static final short CMD_GL_ATTACH_SHADER_II;
    private static final short CMD_GL_BIND_ATTRIB_LOCATION_IIString;
    private static final short CMD_GL_BIND_BUFFER_II;
    private static final short CMD_GL_BIND_FRAMEBUFFER_II;
    private static final short CMD_GL_BIND_RENDERBUFFER_II;
    private static final short CMD_GL_BIND_TEXTURE_II;
    private static final short CMD_GL_BLEND_COLOR_FFFF;
    private static final short CMD_GL_BLEND_EQUATION_I;
    private static final short CMD_GL_BLEND_EQUATION_SEPARATE_II;
    private static final short CMD_GL_BLEND_FUNC_II;
    private static final short CMD_GL_BLEND_FUNC_SEPARATE_IIII;
    private static final short CMD_GL_BUFFER_DATA_IIBufI;
    private static final short CMD_GL_BUFFER_SUB_DATA_IIIBuf;
    private static final short CMD_GL_CHECK_FRAMEBUFFER_STATUS_I;
    private static final short CMD_GL_CLEAR_I;
    private static final short CMD_GL_CLEAR_COLOR_FFFF;
    private static final short CMD_GL_CLEAR_DEPTHF_F;
    private static final short CMD_GL_CLEAR_STENCIL_I;
    private static final short CMD_GL_COLOR_MASK_ZZZZ;
    private static final short CMD_GL_COMPILE_SHADER_I;
    private static final short CMD_GL_COMPRESSED_TEX_IMAGE_2D_IIIIIIIBuf;
    private static final short CMD_GL_COMPRESSED_TEX_SUB_IMAGE_2D_IIIIIIIIBuf;
    private static final short CMD_GL_COPY_TEX_IMAGE_2D_IIIIIIII;
    private static final short CMD_GL_COPY_TEX_SUB_IMAGE_2D_IIIIIIII;
    private static final short CMD_GL_COVERAGE_MASK_N_V_Z;
    private static final short CMD_GL_COVERAGE_OPERATION_N_V_I;
    private static final short CMD_GL_CREATE_PROGRAM_;
    private static final short CMD_GL_CREATE_SHADER_I;
    private static final short CMD_GL_CULL_FACE_I;
    private static final short CMD_GL_DELETE_BUFFERS_IIbuf;
    private static final short CMD_GL_DELETE_BUFFERS_IIarrayI;
    private static final short CMD_GL_DELETE_FRAMEBUFFERS_IIbuf;
    private static final short CMD_GL_DELETE_FRAMEBUFFERS_IIarrayI;
    private static final short CMD_GL_DELETE_PROGRAM_I;
    private static final short CMD_GL_DELETE_RENDERBUFFERS_IIbuf;
    private static final short CMD_GL_DELETE_RENDERBUFFERS_IIarrayI;
    private static final short CMD_GL_DELETE_SHADER_I;
    private static final short CMD_GL_DELETE_TEXTURES_IIbuf;
    private static final short CMD_GL_DELETE_TEXTURES_IIarrayI;
    private static final short CMD_GL_DEPTH_FUNC_I;
    private static final short CMD_GL_DEPTH_MASK_Z;
    private static final short CMD_GL_DEPTH_RANGEF_FF;
    private static final short CMD_GL_DETACH_SHADER_II;
    private static final short CMD_GL_DISABLE_I;
    private static final short CMD_GL_DISABLE_VERTEX_ATTRIB_ARRAY_I;
    private static final short CMD_GL_DRAW_ARRAYS_III;
    private static final short CMD_GL_DRAW_ELEMENTS_IIIBuf;
    private static final short CMD_GL_DRAW_ELEMENTS_IIIL;
    private static final short CMD_GL_ENABLE_I;
    private static final short CMD_GL_ENABLE_VERTEX_ATTRIB_ARRAY_I;
    private static final short CMD_GL_FINISH_;
    private static final short CMD_GL_FLUSH_;
    private static final short CMD_GL_FRAMEBUFFER_RENDERBUFFER_IIII;
    private static final short CMD_GL_FRAMEBUFFER_TEXTURE_2D_IIIII;
    private static final short CMD_GL_FRONT_FACE_I;
    private static final short CMD_GL_GEN_BUFFERS_IIbuf;
    private static final short CMD_GL_GEN_BUFFERS_IIarrayI;
    private static final short CMD_GL_GEN_FRAMEBUFFERS_IIbuf;
    private static final short CMD_GL_GEN_FRAMEBUFFERS_IIarrayI;
    private static final short CMD_GL_GEN_RENDERBUFFERS_IIbuf;
    private static final short CMD_GL_GEN_RENDERBUFFERS_IIarrayI;
    private static final short CMD_GL_GEN_TEXTURES_IIbuf;
    private static final short CMD_GL_GEN_TEXTURES_IIarrayI;
    private static final short CMD_GL_GENERATE_MIPMAP_I;
    private static final short CMD_GL_GET_ACTIVE_ATTRIB_IIIIbufIbufIbufBbuf;
    private static final short CMD_GL_GET_ACTIVE_ATTRIB_IIIIarrayIIarrayIIarrayIBarrayI;
    private static final short CMD_GL_GET_ACTIVE_UNIFORM_IIIIbufIbufIbufBbuf;
    private static final short CMD_GL_GET_ACTIVE_UNIFORM_IIIIarrayIIarrayIIarrayIBarrayI;
    private static final short CMD_GL_GET_ATTACHED_SHADERS_IIIbufIbuf;
    private static final short CMD_GL_GET_ATTACHED_SHADERS_IIIarrayIIarrayI;
    private static final short CMD_GL_GET_ATTRIB_LOCATION_IString;
    private static final short CMD_GL_GET_BOOLEANV_IBbuf;
    private static final short CMD_GL_GET_BOOLEANV_IBarrayI;
    private static final short CMD_GL_GET_BUFFER_PARAMETERIV_IIIbuf;
    private static final short CMD_GL_GET_BUFFER_PARAMETERIV_IIIarrayI;
    private static final short CMD_GL_GET_ERROR_;
    private static final short CMD_GL_GET_FLOATV_IFbuf;
    private static final short CMD_GL_GET_FLOATV_IFarrayI;
    private static final short CMD_GL_GET_FRAMEBUFFER_ATTACHMENT_PARAMETERIV_IIIIbuf;
    private static final short CMD_GL_GET_FRAMEBUFFER_ATTACHMENT_PARAMETERIV_IIIIarrayI;
    private static final short CMD_GL_GET_INTEGERV_IIbuf;
    private static final short CMD_GL_GET_INTEGERV_IIarrayI;
    private static final short CMD_GL_GET_PROGRAM_INFO_LOG_IIIbufBbuf;
    private static final short CMD_GL_GET_PROGRAM_INFO_LOG_IIIarrayIBarrayI;
    private static final short CMD_GL_GET_PROGRAMIV_IIIbuf;
    private static final short CMD_GL_GET_PROGRAMIV_IIIarrayI;
    private static final short CMD_GL_GET_RENDERBUFFER_PARAMETERIV_IIIbuf;
    private static final short CMD_GL_GET_RENDERBUFFER_PARAMETERIV_IIIarrayI;
    private static final short CMD_GL_GET_SHADER_INFO_LOG_IIIbufBbuf;
    private static final short CMD_GL_GET_SHADER_INFO_LOG_IIIarrayIBarrayI;
    private static final short CMD_GL_GET_SHADER_PRECISION_FORMAT_IIIbufIbuf;
    private static final short CMD_GL_GET_SHADER_SOURCE_IIIbufBbuf;
    private static final short CMD_GL_GET_SHADERIV_IIIbuf;
    private static final short CMD_GL_GET_SHADERIV_IIIarrayI;
    private static final short CMD_GL_GET_STRING_I;
    private static final short CMD_GL_GET_TEX_PARAMETERFV_IIFbuf;
    private static final short CMD_GL_GET_TEX_PARAMETERFV_IIFarrayI;
    private static final short CMD_GL_GET_TEX_PARAMETERIV_IIIbuf;
    private static final short CMD_GL_GET_TEX_PARAMETERIV_IIIarrayI;
    private static final short CMD_GL_GET_UNIFORM_LOCATION_IString;
    private static final short CMD_GL_GET_UNIFORMFV_IIFbuf;
    private static final short CMD_GL_GET_UNIFORMFV_IIFarrayI;
    private static final short CMD_GL_GET_UNIFORMIV_IIIbuf;
    private static final short CMD_GL_GET_UNIFORMIV_IIIarrayI;
    private static final short CMD_GL_GET_VERTEX_ATTRIBFV_IIFbuf;
    private static final short CMD_GL_GET_VERTEX_ATTRIBFV_IIFarrayI;
    private static final short CMD_GL_GET_VERTEX_ATTRIBIV_IIIbuf;
    private static final short CMD_GL_GET_VERTEX_ATTRIBIV_IIIarrayI;
    private static final short CMD_GL_HINT_II;
    private static final short CMD_GL_IS_BUFFER_I;
    private static final short CMD_GL_IS_ENABLED_I;
    private static final short CMD_GL_IS_FRAMEBUFFER_I;
    private static final short CMD_GL_IS_PROGRAM_I;
    private static final short CMD_GL_IS_RENDERBUFFER_I;
    private static final short CMD_GL_IS_SHADER_I;
    private static final short CMD_GL_IS_TEXTURE_I;
    private static final short CMD_GL_LINE_WIDTH_F;
    private static final short CMD_GL_LINK_PROGRAM_I;
    private static final short CMD_GL_PIXEL_STOREI_II;
    private static final short CMD_GL_POLYGON_OFFSET_FF;
    private static final short CMD_GL_READ_PIXELS_IIIIIIBuf;
    private static final short CMD_GL_RELEASE_SHADER_COMPILER_;
    private static final short CMD_GL_RENDERBUFFER_STORAGE_IIII;
    private static final short CMD_GL_SAMPLE_COVERAGE_FZ;
    private static final short CMD_GL_SCISSOR_IIII;
    private static final short CMD_GL_SHADER_BINARY_IIbufIBufI;
    private static final short CMD_GL_SHADER_SOURCE_IIStringarrayIbuf;
    private static final short CMD_GL_SHADER_SOURCE_IIStringarrayIarrayI;
    private static final short CMD_GL_STENCIL_FUNC_III;
    private static final short CMD_GL_STENCIL_FUNC_SEPARATE_IIII;
    private static final short CMD_GL_STENCIL_MASK_I;
    private static final short CMD_GL_STENCIL_MASK_SEPARATE_II;
    private static final short CMD_GL_STENCIL_OP_III;
    private static final short CMD_GL_STENCIL_OP_SEPARATE_IIII;
    private static final short CMD_GL_TEX_IMAGE_2D_IIIIIIIIBuf;
    private static final short CMD_GL_TEX_PARAMETERF_IIF;
    private static final short CMD_GL_TEX_PARAMETERFV_IIFbuf;
    private static final short CMD_GL_TEX_PARAMETERFV_IIFarrayI;
    private static final short CMD_GL_TEX_PARAMETERI_III;
    private static final short CMD_GL_TEX_PARAMETERIV_IIIbuf;
    private static final short CMD_GL_TEX_PARAMETERIV_IIIarrayI;
    private static final short CMD_GL_TEX_SUB_IMAGE_2D_IIIIIIIIBuf;
    private static final short CMD_GL_UNIFORM_1F_IF;
    private static final short CMD_GL_UNIFORM_1FV_IIFbuf;
    private static final short CMD_GL_UNIFORM_1FV_IIFarrayI;
    private static final short CMD_GL_UNIFORM_1I_II;
    private static final short CMD_GL_UNIFORM_1IV_IIIbuf;
    private static final short CMD_GL_UNIFORM_1IV_IIIarrayI;
    private static final short CMD_GL_UNIFORM_2F_IFF;
    private static final short CMD_GL_UNIFORM_2FV_IIFbuf;
    private static final short CMD_GL_UNIFORM_2FV_IIFarrayI;
    private static final short CMD_GL_UNIFORM_2I_III;
    private static final short CMD_GL_UNIFORM_2IV_IIIbuf;
    private static final short CMD_GL_UNIFORM_2IV_IIIarrayI;
    private static final short CMD_GL_UNIFORM_3F_IFFF;
    private static final short CMD_GL_UNIFORM_3FV_IIFbuf;
    private static final short CMD_GL_UNIFORM_3FV_IIFarrayI;
    private static final short CMD_GL_UNIFORM_3I_IIII;
    private static final short CMD_GL_UNIFORM_3IV_IIIbuf;
    private static final short CMD_GL_UNIFORM_3IV_IIIarrayI;
    private static final short CMD_GL_UNIFORM_4F_IFFFF;
    private static final short CMD_GL_UNIFORM_4FV_IIFbuf;
    private static final short CMD_GL_UNIFORM_4FV_IIFarrayI;
    private static final short CMD_GL_UNIFORM_4I_IIIII;
    private static final short CMD_GL_UNIFORM_4IV_IIIbuf;
    private static final short CMD_GL_UNIFORM_4IV_IIIarrayI;
    private static final short CMD_GL_UNIFORM_MATRIX_2FV_IIZFbuf;
    private static final short CMD_GL_UNIFORM_MATRIX_2FV_IIZFarrayI;
    private static final short CMD_GL_UNIFORM_MATRIX_3FV_IIZFbuf;
    private static final short CMD_GL_UNIFORM_MATRIX_3FV_IIZFarrayI;
    private static final short CMD_GL_UNIFORM_MATRIX_4FV_IIZFbuf;
    private static final short CMD_GL_UNIFORM_MATRIX_4FV_IIZFarrayI;
    private static final short CMD_GL_USE_PROGRAM_I;
    private static final short CMD_GL_VALIDATE_PROGRAM_I;
    private static final short CMD_GL_VERTEX_ATTRIB_1F_IF;
    private static final short CMD_GL_VERTEX_ATTRIB_1FV_IFbuf;
    private static final short CMD_GL_VERTEX_ATTRIB_1FV_IFarrayI;
    private static final short CMD_GL_VERTEX_ATTRIB_2F_IFF;
    private static final short CMD_GL_VERTEX_ATTRIB_2FV_IFbuf;
    private static final short CMD_GL_VERTEX_ATTRIB_2FV_IFarrayI;
    private static final short CMD_GL_VERTEX_ATTRIB_3F_IFFF;
    private static final short CMD_GL_VERTEX_ATTRIB_3FV_IFbuf;
    private static final short CMD_GL_VERTEX_ATTRIB_3FV_IFarrayI;
    private static final short CMD_GL_VERTEX_ATTRIB_4F_IFFFF;
    private static final short CMD_GL_VERTEX_ATTRIB_4FV_IFbuf;
    private static final short CMD_GL_VERTEX_ATTRIB_4FV_IFarrayI;
    private static final short CMD_GL_VERTEX_ATTRIB_POINTER_IIIZIBuf;
    private static final short CMD_GL_VERTEX_ATTRIB_POINTER_IIIZIL;
    private static final short CMD_GL_VIEWPORT_IIII;
    private static final String[] commandStrings;
    private int[] imageSizeTemp = new int[1];

    private native int glCheckFramebufferStatus0(int n) {
    }

    private native int glCreateProgram0() {
    }

    private native int glCreateShader0(int n) {
    }

    private native void glFinish0() {
    }

    private native void glFlush0() {
    }

    private native void glGenBuffers0(int n, IntBuffer intBuffer, int n2) {
    }

    private native void glGenBuffers1(int n, int[] nArray, int n2) {
    }

    private native void glGenFramebuffers0(int n, IntBuffer intBuffer, int n2) {
    }

    private native void glGenFramebuffers1(int n, int[] nArray, int n2) {
    }

    private native void glGenRenderbuffers0(int n, IntBuffer intBuffer, int n2) {
    }

    private native void glGenRenderbuffers1(int n, int[] nArray, int n2) {
    }

    private native void glGenTextures0(int n, IntBuffer intBuffer, int n2) {
    }

    private native void glGenTextures1(int n, int[] nArray, int n2) {
    }

    private native void glGetActiveAttrib0(int n, int n2, int n3, IntBuffer intBuffer, int n4, IntBuffer intBuffer2, int n5, IntBuffer intBuffer3, int n6, ByteBuffer byteBuffer, int n7) {
    }

    private native void glGetActiveAttrib1(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
    }

    private native void glGetActiveUniform0(int n, int n2, int n3, IntBuffer intBuffer, int n4, IntBuffer intBuffer2, int n5, IntBuffer intBuffer3, int n6, ByteBuffer byteBuffer, int n7) {
    }

    private native void glGetActiveUniform1(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
    }

    private native void glGetAttachedShaders0(int n, int n2, IntBuffer intBuffer, int n3, IntBuffer intBuffer2, int n4) {
    }

    private native void glGetAttachedShaders1(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4) {
    }

    private native int glGetAttribLocation0(int n, String string) {
    }

    private native void glGetBooleanv0(int n, ByteBuffer byteBuffer, int n2) {
    }

    private native void glGetBooleanv1(int n, byte[] byArray, int n2) {
    }

    private native void glGetBufferParameteriv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetBufferParameteriv1(int n, int n2, int[] nArray, int n3) {
    }

    private native int glGetError0() {
    }

    private native void glGetFloatv0(int n, FloatBuffer floatBuffer, int n2) {
    }

    private native void glGetFloatv1(int n, float[] fArray, int n2) {
    }

    private native void glGetFramebufferAttachmentParameteriv0(int n, int n2, int n3, IntBuffer intBuffer, int n4) {
    }

    private native void glGetFramebufferAttachmentParameteriv1(int n, int n2, int n3, int[] nArray, int n4) {
    }

    private native void glGetIntegerv0(int n, IntBuffer intBuffer, int n2) {
    }

    private native void glGetIntegerv1(int n, int[] nArray, int n2) {
    }

    private native void glGetProgramInfoLog0(int n, int n2, IntBuffer intBuffer, int n3, ByteBuffer byteBuffer, int n4) {
    }

    private native void glGetProgramInfoLog1(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
    }

    private native void glGetProgramiv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetProgramiv1(int n, int n2, int[] nArray, int n3) {
    }

    private native void glGetRenderbufferParameteriv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetRenderbufferParameteriv1(int n, int n2, int[] nArray, int n3) {
    }

    private native void glGetShaderInfoLog0(int n, int n2, IntBuffer intBuffer, int n3, ByteBuffer byteBuffer, int n4) {
    }

    private native void glGetShaderInfoLog1(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
    }

    private native void glGetShaderPrecisionFormat0(int n, int n2, IntBuffer intBuffer, int n3, IntBuffer intBuffer2, int n4) {
    }

    private native void glGetShaderSource0(int n, int n2, IntBuffer intBuffer, int n3, ByteBuffer byteBuffer, int n4) {
    }

    private native void glGetShaderiv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetShaderiv1(int n, int n2, int[] nArray, int n3) {
    }

    private native String glGetString0(int n) {
    }

    private native void glGetTexParameterfv0(int n, int n2, FloatBuffer floatBuffer, int n3) {
    }

    private native void glGetTexParameterfv1(int n, int n2, float[] fArray, int n3) {
    }

    private native void glGetTexParameteriv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetTexParameteriv1(int n, int n2, int[] nArray, int n3) {
    }

    private native int glGetUniformLocation0(int n, String string) {
    }

    private native void glGetUniformfv0(int n, int n2, FloatBuffer floatBuffer, int n3) {
    }

    private native void glGetUniformfv1(int n, int n2, float[] fArray, int n3) {
    }

    private native void glGetUniformiv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetUniformiv1(int n, int n2, int[] nArray, int n3) {
    }

    private native void glGetVertexAttribfv0(int n, int n2, FloatBuffer floatBuffer, int n3) {
    }

    private native void glGetVertexAttribfv1(int n, int n2, float[] fArray, int n3) {
    }

    private native void glGetVertexAttribiv0(int n, int n2, IntBuffer intBuffer, int n3) {
    }

    private native void glGetVertexAttribiv1(int n, int n2, int[] nArray, int n3) {
    }

    private native boolean glIsBuffer0(int n) {
    }

    private native boolean glIsEnabled0(int n) {
    }

    private native boolean glIsFramebuffer0(int n) {
    }

    private native boolean glIsProgram0(int n) {
    }

    private native boolean glIsRenderbuffer0(int n) {
    }

    private native boolean glIsShader0(int n) {
    }

    private native boolean glIsTexture0(int n) {
    }

    private native void glReadPixels0(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer, int n7) {
    }

    private native void glShaderSource0(int n, int n2, String[] stringArray, IntBuffer intBuffer, int n3) {
    }

    private native void glShaderSource1(int n, int n2, String[] stringArray, int[] nArray, int n3) {
    }

    @Override
    public void glActiveTexture(int n) {
        this.addToQueue((short)1, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glAttachShader(int n, int n2) {
        this.addToQueue((short)2, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBindAttribLocation(int n, int n2, String string) {
        int n3 = 4 + (string == null ? 0 : string.length() + 1);
        this.addToQueue((short)3, 2, 0, n3);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(string);
    }

    @Override
    public void glBindBuffer(int n, int n2) {
        this.addToQueue((short)4, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBindFramebuffer(int n, int n2) {
        this.addToQueue((short)5, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBindRenderbuffer(int n, int n2) {
        this.addToQueue((short)6, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBindTexture(int n, int n2) {
        this.addToQueue((short)7, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBlendColor(float f2, float f3, float f4, float f5) {
        this.addToQueue((short)8, 0, 4, 0);
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
        this.floatQueue[this.floatQueuePosition++] = f4;
        this.floatQueue[this.floatQueuePosition++] = f5;
    }

    @Override
    public void glBlendEquation(int n) {
        this.addToQueue((short)9, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glBlendEquationSeparate(int n, int n2) {
        this.addToQueue((short)10, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBlendFunc(int n, int n2) {
        this.addToQueue((short)11, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glBlendFuncSeparate(int n, int n2, int n3, int n4) {
        this.addToQueue((short)12, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glBufferData(int n, int n2, Buffer buffer, int n3) {
        BufferFactory.rangeCheckBytes(buffer, n2);
        this.addToQueue((short)13, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(buffer);
        this.intQueue[this.intQueuePosition++] = n3;
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glBufferData() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glBufferSubData(int n, int n2, int n3, Buffer buffer) {
        BufferFactory.rangeCheckBytes(buffer, n3);
        this.addToQueue((short)14, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glBufferSubData() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public int glCheckFramebufferStatus(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glCheckFramebufferStatus() -> flushes the queue before being executed");
        }
        this.flushQueue();
        int n2 = this.glCheckFramebufferStatus0(n);
        return n2;
    }

    @Override
    public void glClear(int n) {
        this.addToQueue((short)16, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glClearColor(float f2, float f3, float f4, float f5) {
        this.addToQueue((short)17, 0, 4, 0);
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
        this.floatQueue[this.floatQueuePosition++] = f4;
        this.floatQueue[this.floatQueuePosition++] = f5;
    }

    @Override
    public void glClearDepthf(float f2) {
        this.addToQueue((short)18, 0, 1, 0);
        this.floatQueue[this.floatQueuePosition++] = f2;
    }

    @Override
    public void glClearStencil(int n) {
        this.addToQueue((short)19, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glColorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.addToQueue((short)20, 0, 0, 4);
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        this.byteQueue[this.byteQueuePosition++] = bl2 ? (byte)1 : 0;
        this.byteQueue[this.byteQueuePosition++] = bl3 ? (byte)1 : 0;
        this.byteQueue[this.byteQueuePosition++] = bl4 ? (byte)1 : 0;
    }

    @Override
    public void glCompileShader(int n) {
        this.addToQueue((short)21, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glCompressedTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
        this.addToQueue((short)22, 8, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
        this.intQueue[this.intQueuePosition++] = n6;
        this.intQueue[this.intQueuePosition++] = n7;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glCompressedTexImage2D() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glCompressedTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.addToQueue((short)23, 9, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
        this.intQueue[this.intQueuePosition++] = n6;
        this.intQueue[this.intQueuePosition++] = n7;
        this.intQueue[this.intQueuePosition++] = n8;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glCompressedTexSubImage2D() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glCopyTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.addToQueue((short)24, 8, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
        this.intQueue[this.intQueuePosition++] = n6;
        this.intQueue[this.intQueuePosition++] = n7;
        this.intQueue[this.intQueuePosition++] = n8;
    }

    @Override
    public void glCopyTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.addToQueue((short)25, 8, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
        this.intQueue[this.intQueuePosition++] = n6;
        this.intQueue[this.intQueuePosition++] = n7;
        this.intQueue[this.intQueuePosition++] = n8;
    }

    @Override
    public void glCoverageMaskNV(boolean bl) {
        this.addToQueue((short)26, 0, 0, 1);
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
    }

    @Override
    public void glCoverageOperationNV(int n) {
        this.addToQueue((short)27, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public int glCreateProgram() {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glCreateProgram() -> flushes the queue before being executed");
        }
        this.flushQueue();
        int n = this.glCreateProgram0();
        return n;
    }

    @Override
    public int glCreateShader(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glCreateShader() -> flushes the queue before being executed");
        }
        this.flushQueue();
        int n2 = this.glCreateShader0(n);
        return n2;
    }

    @Override
    public void glCullFace(int n) {
        this.addToQueue((short)30, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glDeleteBuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        this.addToQueue((short)31, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glDeleteBuffers() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glDeleteBuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        int n3 = 2 + (nArray == null ? 0 : nArray.length - n2);
        this.addToQueue((short)32, n3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"buffers_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n2);
    }

    @Override
    public void glDeleteFramebuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        this.addToQueue((short)33, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glDeleteFramebuffers() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glDeleteFramebuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        int n3 = 2 + (nArray == null ? 0 : nArray.length - n2);
        this.addToQueue((short)34, n3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"framebuffers_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n2);
    }

    @Override
    public void glDeleteProgram(int n) {
        this.addToQueue((short)35, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glDeleteRenderbuffers(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        this.addToQueue((short)36, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glDeleteRenderbuffers() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glDeleteRenderbuffers(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        int n3 = 2 + (nArray == null ? 0 : nArray.length - n2);
        this.addToQueue((short)37, n3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"renderbuffers_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n2);
    }

    @Override
    public void glDeleteShader(int n) {
        this.addToQueue((short)38, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glDeleteTextures(int n, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n);
        this.addToQueue((short)39, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glDeleteTextures() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glDeleteTextures(int n, int[] nArray, int n2) {
        BufferFactory.rangeCheck(nArray, n2, n);
        int n3 = 2 + (nArray == null ? 0 : nArray.length - n2);
        this.addToQueue((short)40, n3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"textures_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n2);
    }

    @Override
    public void glDepthFunc(int n) {
        this.addToQueue((short)41, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glDepthMask(boolean bl) {
        this.addToQueue((short)42, 0, 0, 1);
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
    }

    @Override
    public void glDepthRangef(float f2, float f3) {
        this.addToQueue((short)43, 0, 2, 0);
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
    }

    @Override
    public void glDetachShader(int n, int n2) {
        this.addToQueue((short)44, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glDisable(int n) {
        this.addToQueue((short)45, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glDisableVertexAttribArray(int n) {
        this.addToQueue((short)46, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glDrawArrays(int n, int n2, int n3) {
        this.addToQueue((short)47, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, Buffer buffer) {
        BufferFactory.rangeCheck(buffer, n2);
        this.addToQueue((short)48, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glDrawElements() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glDrawElements(int n, int n2, int n3, long l) {
        this.addToQueue((short)49, 5, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = (int)(l & 0xFFFFFFFFFFFFFFFFL);
        this.intQueue[this.intQueuePosition++] = (int)(l >>> 32);
    }

    @Override
    public void glEnable(int n) {
        this.addToQueue((short)50, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glEnableVertexAttribArray(int n) {
        this.addToQueue((short)51, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glFinish() {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glFinish() -> flushes the queue before being executed");
        }
        this.flushQueue();
        this.glFinish0();
    }

    @Override
    public void glFlush() {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glFlush() -> flushes the queue before being executed");
        }
        this.flushQueue();
        this.glFlush0();
    }

    @Override
    public void glFramebufferRenderbuffer(int n, int n2, int n3, int n4) {
        this.addToQueue((short)54, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glFramebufferTexture2D(int n, int n2, int n3, int n4, int n5) {
        this.addToQueue((short)55, 5, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
    }

    @Override
    public void glFrontFace(int n) {
        this.addToQueue((short)56, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glGenBuffers(int n, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenBuffers() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"buffers\" was not a direct buffer");
        }
        BufferFactory.rangeCheck(intBuffer, n);
        this.glGenBuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGenBuffers(int n, int[] nArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenBuffers() -> flushes the queue before being executed");
        }
        this.flushQueue();
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"buffers_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenBuffers1(n, nArray, n2);
    }

    @Override
    public void glGenFramebuffers(int n, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenFramebuffers() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"framebuffers\" was not a direct buffer");
        }
        BufferFactory.rangeCheck(intBuffer, n);
        this.glGenFramebuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGenFramebuffers(int n, int[] nArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenFramebuffers() -> flushes the queue before being executed");
        }
        this.flushQueue();
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"framebuffers_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenFramebuffers1(n, nArray, n2);
    }

    @Override
    public void glGenRenderbuffers(int n, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenRenderbuffers() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"renderbuffers\" was not a direct buffer");
        }
        BufferFactory.rangeCheck(intBuffer, n);
        this.glGenRenderbuffers0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGenRenderbuffers(int n, int[] nArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenRenderbuffers() -> flushes the queue before being executed");
        }
        this.flushQueue();
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"renderbuffers_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenRenderbuffers1(n, nArray, n2);
    }

    @Override
    public void glGenTextures(int n, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenTextures() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"textures\" was not a direct buffer");
        }
        BufferFactory.rangeCheck(intBuffer, n);
        this.glGenTextures0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGenTextures(int n, int[] nArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGenTextures() -> flushes the queue before being executed");
        }
        this.flushQueue();
        BufferFactory.rangeCheck(nArray, n2, n);
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"textures_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGenTextures1(n, nArray, n2);
    }

    @Override
    public void glGenerateMipmap(int n) {
        this.addToQueue((short)65, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetActiveAttrib() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"size\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer3)) {
            throw new GLException("Argument \"type\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"name\" was not a direct buffer");
        }
        this.glGetActiveAttrib0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    @Override
    public void glGetActiveAttrib(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetActiveAttrib() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n4).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n5) {
            throw new GLException(new StringBuffer().append("array offset argument \"size_offset\" (").append(n5).append(") equals or exeeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n6) {
            throw new GLException(new StringBuffer().append("array offset argument \"type_offset\" (").append(n6).append(") equals or exeeds array length (").append(nArray3.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n7) {
            throw new GLException(new StringBuffer().append("array offset argument \"name_offset\" (").append(n7).append(") equals or exeeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetActiveAttrib1(n, n2, n3, nArray, n4, nArray2, n5, nArray3, n6, byArray, n7);
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetActiveUniform() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"size\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer3)) {
            throw new GLException("Argument \"type\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"name\" was not a direct buffer");
        }
        this.glGetActiveUniform0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    @Override
    public void glGetActiveUniform(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetActiveUniform() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n4).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n5) {
            throw new GLException(new StringBuffer().append("array offset argument \"size_offset\" (").append(n5).append(") equals or exeeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n6) {
            throw new GLException(new StringBuffer().append("array offset argument \"type_offset\" (").append(n6).append(") equals or exeeds array length (").append(nArray3.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n7) {
            throw new GLException(new StringBuffer().append("array offset argument \"name_offset\" (").append(n7).append(") equals or exeeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetActiveUniform1(n, n2, n3, nArray, n4, nArray2, n5, nArray3, n6, byArray, n7);
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetAttachedShaders() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"count\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"shaders\" was not a direct buffer");
        }
        this.glGetAttachedShaders0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2));
    }

    @Override
    public void glGetAttachedShaders(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetAttachedShaders() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"count_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"shaders_offset\" (").append(n4).append(") equals or exeeds array length (").append(nArray2.length).append(")").toString());
        }
        this.glGetAttachedShaders1(n, n2, nArray, n3, nArray2, n4);
    }

    @Override
    public int glGetAttribLocation(int n, String string) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetAttribLocation() -> flushes the queue before being executed");
        }
        this.flushQueue();
        int n2 = this.glGetAttribLocation0(n, string);
        return n2;
    }

    @Override
    public void glGetBooleanv(int n, ByteBuffer byteBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetBooleanv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetBooleanv0(n, byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    @Override
    public void glGetBooleanv(int n, byte[] byArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetBooleanv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (byArray != null && byArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n2).append(") equals or exeeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetBooleanv1(n, byArray, n2);
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetBufferParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetBufferParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetBufferParameteriv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetBufferParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetBufferParameteriv1(n, n2, nArray, n3);
    }

    @Override
    public int glGetError() {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetError() -> flushes the queue before being executed");
        }
        this.flushQueue();
        int n = this.glGetError0();
        return n;
    }

    @Override
    public void glGetFloatv(int n, FloatBuffer floatBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetFloatv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(floatBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetFloatv0(n, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
    }

    @Override
    public void glGetFloatv(int n, float[] fArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetFloatv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n2).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetFloatv1(n, fArray, n2);
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetFramebufferAttachmentParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetFramebufferAttachmentParameteriv0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, int[] nArray, int n4) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetFramebufferAttachmentParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n4).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetFramebufferAttachmentParameteriv1(n, n2, n3, nArray, n4);
    }

    @Override
    public void glGetIntegerv(int n, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetIntegerv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetIntegerv0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetIntegerv(int n, int[] nArray, int n2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetIntegerv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n2).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetIntegerv1(n, nArray, n2);
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetProgramInfoLog() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"infolog\" was not a direct buffer");
        }
        this.glGetProgramInfoLog0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    @Override
    public void glGetProgramInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetProgramInfoLog() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"infolog_offset\" (").append(n4).append(") equals or exeeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetProgramInfoLog1(n, n2, nArray, n3, byArray, n4);
    }

    @Override
    public void glGetProgramiv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetProgramiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetProgramiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetProgramiv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetProgramiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetProgramiv1(n, n2, nArray, n3);
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetRenderbufferParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetRenderbufferParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetRenderbufferParameteriv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetRenderbufferParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetRenderbufferParameteriv1(n, n2, nArray, n3);
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetShaderInfoLog() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"infolog\" was not a direct buffer");
        }
        this.glGetShaderInfoLog0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    @Override
    public void glGetShaderInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetShaderInfoLog() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        if (byArray != null && byArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"infolog_offset\" (").append(n4).append(") equals or exeeds array length (").append(byArray.length).append(")").toString());
        }
        this.glGetShaderInfoLog1(n, n2, nArray, n3, byArray, n4);
    }

    @Override
    public void glGetShaderPrecisionFormat(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetShaderPrecisionFormat() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"range\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"precision\" was not a direct buffer");
        }
        this.glGetShaderPrecisionFormat0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2));
    }

    @Override
    public void glGetShaderSource(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetShaderSource() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new GLException("Argument \"source\" was not a direct buffer");
        }
        this.glGetShaderSource0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    @Override
    public void glGetShaderiv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetShaderiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetShaderiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetShaderiv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetShaderiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetShaderiv1(n, n2, nArray, n3);
    }

    @Override
    public String glGetString(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetString() -> flushes the queue before being executed");
        }
        this.flushQueue();
        String string = this.glGetString0(n);
        return string;
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetTexParameterfv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(floatBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetTexParameterfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
    }

    @Override
    public void glGetTexParameterfv(int n, int n2, float[] fArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetTexParameterfv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetTexParameterfv1(n, n2, fArray, n3);
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetTexParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetTexParameteriv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetTexParameteriv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetTexParameteriv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetTexParameteriv1(n, n2, nArray, n3);
    }

    @Override
    public int glGetUniformLocation(int n, String string) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetUniformLocation() -> flushes the queue before being executed");
        }
        this.flushQueue();
        int n2 = this.glGetUniformLocation0(n, string);
        return n2;
    }

    @Override
    public void glGetUniformfv(int n, int n2, FloatBuffer floatBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetUniformfv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(floatBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetUniformfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
    }

    @Override
    public void glGetUniformfv(int n, int n2, float[] fArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetUniformfv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetUniformfv1(n, n2, fArray, n3);
    }

    @Override
    public void glGetUniformiv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetUniformiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetUniformiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetUniformiv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetUniformiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetUniformiv1(n, n2, nArray, n3);
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, FloatBuffer floatBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetVertexAttribfv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(floatBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetVertexAttribfv0(n, n2, floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
    }

    @Override
    public void glGetVertexAttribfv(int n, int n2, float[] fArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetVertexAttribfv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.glGetVertexAttribfv1(n, n2, fArray, n3);
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetVertexAttribiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"params\" was not a direct buffer");
        }
        this.glGetVertexAttribiv0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glGetVertexAttribiv(int n, int n2, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glGetVertexAttribiv() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glGetVertexAttribiv1(n, n2, nArray, n3);
    }

    @Override
    public void glHint(int n, int n2) {
        this.addToQueue((short)110, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public boolean glIsBuffer(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsBuffer() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsBuffer0(n);
        return bl;
    }

    @Override
    public boolean glIsEnabled(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsEnabled() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsEnabled0(n);
        return bl;
    }

    @Override
    public boolean glIsFramebuffer(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsFramebuffer() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsFramebuffer0(n);
        return bl;
    }

    @Override
    public boolean glIsProgram(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsProgram() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsProgram0(n);
        return bl;
    }

    @Override
    public boolean glIsRenderbuffer(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsRenderbuffer() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsRenderbuffer0(n);
        return bl;
    }

    @Override
    public boolean glIsShader(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsShader() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsShader0(n);
        return bl;
    }

    @Override
    public boolean glIsTexture(int n) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glIsTexture() -> flushes the queue before being executed");
        }
        this.flushQueue();
        boolean bl = this.glIsTexture0(n);
        return bl;
    }

    @Override
    public void glLineWidth(float f2) {
        this.addToQueue((short)118, 0, 1, 0);
        this.floatQueue[this.floatQueuePosition++] = f2;
    }

    @Override
    public void glLinkProgram(int n) {
        this.addToQueue((short)119, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glPixelStorei(int n, int n2) {
        this.addToQueue((short)120, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glPolygonOffset(float f2, float f3) {
        this.addToQueue((short)121, 0, 2, 0);
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
    }

    @Override
    public void glReadPixels(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glReadPixels() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(buffer)) {
            throw new GLException("Argument \"pixels\" was not a direct buffer");
        }
        this.glReadPixels0(n, n2, n3, n4, n5, n6, buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    @Override
    public void glReleaseShaderCompiler() {
        this.addToQueue((short)123, 0, 0, 0);
    }

    @Override
    public void glRenderbufferStorage(int n, int n2, int n3, int n4) {
        this.addToQueue((short)124, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glSampleCoverage(float f2, boolean bl) {
        this.addToQueue((short)125, 0, 1, 1);
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
    }

    @Override
    public void glScissor(int n, int n2, int n3, int n4) {
        this.addToQueue((short)126, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glShaderBinary(int n, IntBuffer intBuffer, int n2, Buffer buffer, int n3) {
        BufferFactory.rangeCheckBytes(buffer, n3);
        this.addToQueue((short)127, 5, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(intBuffer);
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(buffer);
        this.intQueue[this.intQueuePosition++] = n3;
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glShaderBinary() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, IntBuffer intBuffer) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glShaderSource() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new GLException("Argument \"length\" was not a direct buffer");
        }
        this.glShaderSource0(n, n2, stringArray, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    @Override
    public void glShaderSource(int n, int n2, String[] stringArray, int[] nArray, int n3) {
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glShaderSource() -> flushes the queue before being executed");
        }
        this.flushQueue();
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"length_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.glShaderSource1(n, n2, stringArray, nArray, n3);
    }

    @Override
    public void glStencilFunc(int n, int n2, int n3) {
        this.addToQueue((short)130, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
    }

    @Override
    public void glStencilFuncSeparate(int n, int n2, int n3, int n4) {
        this.addToQueue((short)131, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glStencilMask(int n) {
        this.addToQueue((short)132, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glStencilMaskSeparate(int n, int n2) {
        this.addToQueue((short)133, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glStencilOp(int n, int n2, int n3) {
        this.addToQueue((short)134, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
    }

    @Override
    public void glStencilOpSeparate(int n, int n2, int n3, int n4) {
        this.addToQueue((short)135, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.addToQueue((short)136, 9, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
        this.intQueue[this.intQueuePosition++] = n6;
        this.intQueue[this.intQueuePosition++] = n7;
        this.intQueue[this.intQueuePosition++] = n8;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glTexImage2D() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glTexParameterf(int n, int n2, float f2) {
        this.addToQueue((short)137, 2, 1, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.floatQueue[this.floatQueuePosition++] = f2;
    }

    @Override
    public void glTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
        this.addToQueue((short)138, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glTexParameterfv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glTexParameterfv(int n, int n2, float[] fArray, int n3) {
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)139, 2, n4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glTexParameteri(int n, int n2, int n3) {
        this.addToQueue((short)140, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
    }

    @Override
    public void glTexParameteriv(int n, int n2, IntBuffer intBuffer) {
        this.addToQueue((short)141, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glTexParameteriv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glTexParameteriv(int n, int n2, int[] nArray, int n3) {
        int n4 = 3 + (nArray == null ? 0 : nArray.length - n3);
        this.addToQueue((short)142, n4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"params_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n3);
    }

    @Override
    public void glTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
        this.addToQueue((short)143, 9, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
        this.intQueue[this.intQueuePosition++] = n6;
        this.intQueue[this.intQueuePosition++] = n7;
        this.intQueue[this.intQueuePosition++] = n8;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glTexSubImage2D() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform1f(int n, float f2) {
        this.addToQueue((short)144, 1, 1, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
    }

    @Override
    public void glUniform1fv(int n, int n2, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2);
        this.addToQueue((short)145, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform1fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform1fv(int n, int n2, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)146, 2, n4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUniform1i(int n, int n2) {
        this.addToQueue((short)147, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
    }

    @Override
    public void glUniform1iv(int n, int n2, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n2);
        this.addToQueue((short)148, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform1iv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform1iv(int n, int n2, int[] nArray, int n3) {
        BufferFactory.rangeCheck(nArray, n3, n2);
        int n4 = 3 + (nArray == null ? 0 : nArray.length - n3);
        this.addToQueue((short)149, n4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n3);
    }

    @Override
    public void glUniform2f(int n, float f2, float f3) {
        this.addToQueue((short)150, 1, 2, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
    }

    @Override
    public void glUniform2fv(int n, int n2, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2 * 2);
        this.addToQueue((short)151, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform2fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform2fv(int n, int n2, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2 * 2);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)152, 2, n4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUniform2i(int n, int n2, int n3) {
        this.addToQueue((short)153, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
    }

    @Override
    public void glUniform2iv(int n, int n2, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n2 * 2);
        this.addToQueue((short)154, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform2iv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform2iv(int n, int n2, int[] nArray, int n3) {
        BufferFactory.rangeCheck(nArray, n3, n2 * 2);
        int n4 = 3 + (nArray == null ? 0 : nArray.length - n3);
        this.addToQueue((short)155, n4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n3);
    }

    @Override
    public void glUniform3f(int n, float f2, float f3, float f4) {
        this.addToQueue((short)156, 1, 3, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
        this.floatQueue[this.floatQueuePosition++] = f4;
    }

    @Override
    public void glUniform3fv(int n, int n2, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2 * 3);
        this.addToQueue((short)157, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform3fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform3fv(int n, int n2, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2 * 3);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)158, 2, n4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUniform3i(int n, int n2, int n3, int n4) {
        this.addToQueue((short)159, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
    }

    @Override
    public void glUniform3iv(int n, int n2, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n2 * 3);
        this.addToQueue((short)160, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform3iv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform3iv(int n, int n2, int[] nArray, int n3) {
        BufferFactory.rangeCheck(nArray, n3, n2 * 3);
        int n4 = 3 + (nArray == null ? 0 : nArray.length - n3);
        this.addToQueue((short)161, n4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n3);
    }

    @Override
    public void glUniform4f(int n, float f2, float f3, float f4, float f5) {
        this.addToQueue((short)162, 1, 4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
        this.floatQueue[this.floatQueuePosition++] = f4;
        this.floatQueue[this.floatQueuePosition++] = f5;
    }

    @Override
    public void glUniform4fv(int n, int n2, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2 * 4);
        this.addToQueue((short)163, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform4fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform4fv(int n, int n2, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2 * 4);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)164, 2, n4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUniform4i(int n, int n2, int n3, int n4, int n5) {
        this.addToQueue((short)165, 5, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = n5;
    }

    @Override
    public void glUniform4iv(int n, int n2, IntBuffer intBuffer) {
        BufferFactory.rangeCheck(intBuffer, n2 * 4);
        this.addToQueue((short)166, 3, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.addToQueue(intBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniform4iv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniform4iv(int n, int n2, int[] nArray, int n3) {
        BufferFactory.rangeCheck(nArray, n3, n2 * 4);
        int n4 = 3 + (nArray == null ? 0 : nArray.length - n3);
        this.addToQueue((short)167, n4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"v_offset\" (").append(n3).append(") equals or exeeds array length (").append(nArray.length).append(")").toString());
        }
        this.addToQueue(nArray, n3);
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2 * 4);
        this.addToQueue((short)168, 3, 0, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniformMatrix2fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniformMatrix2fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2 * 4);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)169, 2, n4, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        byte by = this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2 * 9);
        this.addToQueue((short)170, 3, 0, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniformMatrix3fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniformMatrix3fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2 * 9);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)171, 2, n4, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        byte by = this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
        BufferFactory.rangeCheck(floatBuffer, n2 * 16);
        this.addToQueue((short)172, 3, 0, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glUniformMatrix4fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glUniformMatrix4fv(int n, int n2, boolean bl, float[] fArray, int n3) {
        BufferFactory.rangeCheck(fArray, n3, n2 * 16);
        int n4 = 1 + (fArray == null ? 0 : fArray.length - n3);
        this.addToQueue((short)173, 2, n4, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        byte by = this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        if (fArray != null && fArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n3).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n3);
    }

    @Override
    public void glUseProgram(int n) {
        this.addToQueue((short)174, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glValidateProgram(int n) {
        this.addToQueue((short)175, 1, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
    }

    @Override
    public void glVertexAttrib1f(int n, float f2) {
        this.addToQueue((short)176, 1, 1, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
    }

    @Override
    public void glVertexAttrib1fv(int n, FloatBuffer floatBuffer) {
        this.addToQueue((short)177, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glVertexAttrib1fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glVertexAttrib1fv(int n, float[] fArray, int n2) {
        int n3 = 1 + (fArray == null ? 0 : fArray.length - n2);
        this.addToQueue((short)178, 1, n3, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n2);
    }

    @Override
    public void glVertexAttrib2f(int n, float f2, float f3) {
        this.addToQueue((short)179, 1, 2, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
    }

    @Override
    public void glVertexAttrib2fv(int n, FloatBuffer floatBuffer) {
        this.addToQueue((short)180, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glVertexAttrib2fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glVertexAttrib2fv(int n, float[] fArray, int n2) {
        int n3 = 1 + (fArray == null ? 0 : fArray.length - n2);
        this.addToQueue((short)181, 1, n3, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n2);
    }

    @Override
    public void glVertexAttrib3f(int n, float f2, float f3, float f4) {
        this.addToQueue((short)182, 1, 3, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
        this.floatQueue[this.floatQueuePosition++] = f4;
    }

    @Override
    public void glVertexAttrib3fv(int n, FloatBuffer floatBuffer) {
        this.addToQueue((short)183, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glVertexAttrib3fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glVertexAttrib3fv(int n, float[] fArray, int n2) {
        int n3 = 1 + (fArray == null ? 0 : fArray.length - n2);
        this.addToQueue((short)184, 1, n3, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n2);
    }

    @Override
    public void glVertexAttrib4f(int n, float f2, float f3, float f4, float f5) {
        this.addToQueue((short)185, 1, 4, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.floatQueue[this.floatQueuePosition++] = f2;
        this.floatQueue[this.floatQueuePosition++] = f3;
        this.floatQueue[this.floatQueuePosition++] = f4;
        this.floatQueue[this.floatQueuePosition++] = f5;
    }

    @Override
    public void glVertexAttrib4fv(int n, FloatBuffer floatBuffer) {
        this.addToQueue((short)186, 2, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.addToQueue(floatBuffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glVertexAttrib4fv() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glVertexAttrib4fv(int n, float[] fArray, int n2) {
        int n3 = 1 + (fArray == null ? 0 : fArray.length - n2);
        this.addToQueue((short)187, 1, n3, 0);
        this.intQueue[this.intQueuePosition++] = n;
        if (fArray != null && fArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"values_offset\" (").append(n2).append(") equals or exeeds array length (").append(fArray.length).append(")").toString());
        }
        this.addToQueue(fArray, n2);
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, Buffer buffer) {
        BufferFactory.rangeCheck(buffer, n2);
        this.addToQueue((short)188, 5, 0, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        this.intQueue[this.intQueuePosition++] = n4;
        this.addToQueue(buffer);
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println("JOGL: glVertexAttribPointer() -> flushes the queue after being executed");
        }
        this.flushQueue();
    }

    @Override
    public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, long l) {
        this.addToQueue((short)189, 6, 0, 1);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.byteQueue[this.byteQueuePosition++] = bl ? (byte)1 : 0;
        this.intQueue[this.intQueuePosition++] = n4;
        this.intQueue[this.intQueuePosition++] = (int)(l & 0xFFFFFFFFFFFFFFFFL);
        this.intQueue[this.intQueuePosition++] = (int)(l >>> 32);
    }

    @Override
    public void glViewport(int n, int n2, int n3, int n4) {
        this.addToQueue((short)190, 4, 0, 0);
        this.intQueue[this.intQueuePosition++] = n;
        this.intQueue[this.intQueuePosition++] = n2;
        this.intQueue[this.intQueuePosition++] = n3;
        this.intQueue[this.intQueuePosition++] = n4;
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

    private native void initGLExtensions() {
    }

    public GLImplCQ(GLContextImpl gLContextImpl) {
        this._context = gLContextImpl;
        System.out.println(new StringBuffer().append("JOGL: command queue size is set to ").append(COMMAND_QUEUE_SIZE).toString());
        System.out.println(new StringBuffer().append("JOGL: parameter queue size is set to ").append(PARAMETER_QUEUE_SIZE).toString());
        this.commandQueue = new short[COMMAND_QUEUE_SIZE];
        this.intQueue = new int[PARAMETER_QUEUE_SIZE];
        this.floatQueue = new float[PARAMETER_QUEUE_SIZE];
        this.byteQueue = new byte[PARAMETER_QUEUE_SIZE];
        this.initGLExtensions();
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

    @Override
    public void setSwapInterval(int n) {
        this._context.setSwapInterval(n);
    }

    @Override
    public Object getPlatformGLExtensions() {
        return this._context.getPlatformGLExtensions();
    }

    public GLContext getContext() {
        return this._context;
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

    private native void flushQueue(short[] sArray, int[] nArray, float[] fArray, byte[] byArray, int n, int n2, int n3, int n4) {
    }

    public void flushQueue() {
        if (this.commandQueuePosition == 0) {
            return;
        }
        if (this.debugQueue && this.debugLevel >= 2) {
            System.out.println(new StringBuffer().append("JOGL: Flushing the queue from command 0 to command ").append(this.commandQueuePosition - 1).toString());
        }
        if (this.isKernelTracingEnabled()) {
            KernelTraceLogger.setKernelTraceUserEvent("java: flushQueue start");
        }
        this.flushQueue(this.commandQueue, this.intQueue, this.floatQueue, this.byteQueue, this.commandQueuePosition, this.intQueuePosition, this.floatQueuePosition, this.byteQueuePosition);
        if (this.isKernelTracingEnabled()) {
            KernelTraceLogger.setKernelTraceUserEvent("java: flushQueue done");
        }
        this.tmpBufferStorage.clear();
        this.commandQueuePosition = 0;
        this.intQueuePosition = 0;
        this.floatQueuePosition = 0;
        this.byteQueuePosition = 0;
    }

    private void addToQueue(short s, int n, int n2, int n3) {
        if (this.debugQueue && this.debugLevel >= 4) {
            System.out.println(new StringBuffer().append("JOGL: Trying to add command ").append(commandStrings[s]).append(" to the queue.").toString());
        }
        if (this.commandQueuePosition >= COMMAND_QUEUE_SIZE) {
            if (this.debugQueue && this.debugLevel >= 1) {
                System.out.println(new StringBuffer().append("JOGL: Command queue capacity (").append(COMMAND_QUEUE_SIZE).append(") is reached -> flushing the queue.").toString());
            }
            this.flushQueue();
        }
        if (this.intQueuePosition + n >= PARAMETER_QUEUE_SIZE || this.floatQueuePosition + n2 >= PARAMETER_QUEUE_SIZE || this.byteQueuePosition + n3 >= PARAMETER_QUEUE_SIZE) {
            if (this.debugQueue && this.debugLevel >= 1) {
                System.out.println(new StringBuffer().append("JOGL: parameter queue capacity (").append(PARAMETER_QUEUE_SIZE).append(") is reached -> flushing the queue.").toString());
            }
            this.flushQueue();
        }
        this.commandQueue[this.commandQueuePosition++] = s;
    }

    private void addToQueue(int n) {
        this.intQueue[this.intQueuePosition++] = n;
    }

    private void addToQueue(long l) {
        this.intQueue[this.intQueuePosition++] = (int)(l >>> 32);
        this.intQueue[this.intQueuePosition++] = (int)(l & 0xFFFFFFFFFFFFFFFFL);
    }

    private void addToQueue(int[] nArray, int n) {
        if (nArray == null) {
            this.intQueue[this.intQueuePosition++] = 0;
        } else {
            int n2 = nArray.length - n;
            this.intQueue[this.intQueuePosition++] = n2;
            for (int i2 = n; i2 < nArray.length; ++i2) {
                this.intQueue[this.intQueuePosition + i2] = nArray[i2];
            }
            this.intQueuePosition += nArray.length - n;
        }
    }

    private void addToQueue(float f2) {
        this.floatQueue[this.floatQueuePosition++] = f2;
    }

    private void addToQueue(float[] fArray, int n) {
        if (fArray == null) {
            this.floatQueue[this.floatQueuePosition++] = 0.0f;
        } else {
            int n2 = fArray.length - n;
            this.floatQueue[this.floatQueuePosition++] = n2;
            for (int i2 = n; i2 < fArray.length; ++i2) {
                this.floatQueue[this.floatQueuePosition + i2] = fArray[i2];
            }
            this.floatQueuePosition += fArray.length - n;
        }
    }

    private void addToQueue(boolean bl) {
        byte by = bl ? (byte)1 : 0;
        this.byteQueue[this.byteQueuePosition++] = by;
    }

    private void addToQueue(byte by) {
        this.byteQueue[this.byteQueuePosition++] = by;
    }

    private void addToQueue(byte[] byArray, int n) {
        if (byArray == null) {
            this.byteQueue[this.intQueuePosition++] = 0;
            this.byteQueue[this.intQueuePosition++] = 0;
            this.byteQueue[this.intQueuePosition++] = 0;
            this.byteQueue[this.intQueuePosition++] = 0;
        } else {
            int n2 = byArray.length - n;
            this.byteQueue[this.byteQueuePosition++] = (byte)(n2 >>> 24 & 0xFF);
            this.byteQueue[this.byteQueuePosition++] = (byte)(n2 >>> 16 & 0xFF);
            this.byteQueue[this.byteQueuePosition++] = (byte)(n2 >>> 8 & 0xFF);
            this.byteQueue[this.byteQueuePosition++] = (byte)(n2 & 0xFF);
            for (int i2 = n; i2 < byArray.length; ++i2) {
                this.byteQueue[this.byteQueuePosition + i2] = byArray[i2];
            }
            this.byteQueuePosition += byArray.length - n;
        }
    }

    private void addToQueue(String string) {
        if (string == null) {
            this.byteQueue[this.intQueuePosition++] = 0;
            this.byteQueue[this.intQueuePosition++] = 0;
            this.byteQueue[this.intQueuePosition++] = 0;
            this.byteQueue[this.intQueuePosition++] = 0;
        } else {
            int n = string.length() + 1;
            this.byteQueue[this.byteQueuePosition++] = (byte)(n >>> 24 & 0xFF);
            this.byteQueue[this.byteQueuePosition++] = (byte)(n >>> 16 & 0xFF);
            this.byteQueue[this.byteQueuePosition++] = (byte)(n >>> 8 & 0xFF);
            this.byteQueue[this.byteQueuePosition++] = (byte)(n & 0xFF);
            byte[] byArray = string.getBytes();
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                this.byteQueue[this.byteQueuePosition + i2] = byArray[i2];
            }
            this.byteQueuePosition += byArray.length;
            this.byteQueue[this.byteQueuePosition++] = 0;
        }
    }

    private native int getNativeAddress(Buffer buffer, int n) {
    }

    private int getNIOBufferPointer(Buffer buffer) {
        int n = buffer.position();
        if (buffer instanceof ShortBuffer) {
            n *= 2;
        } else if (buffer instanceof IntBuffer) {
            n *= 4;
        } else if (buffer instanceof FloatBuffer) {
            n *= 4;
        }
        int n2 = this.getNativeAddress(buffer, n);
        return n2;
    }

    private void addToQueue(Buffer buffer) {
        if (buffer == null) {
            this.addToQueue(0);
            return;
        }
        boolean bl = BufferFactory.isDirect(buffer);
        if (bl) {
            this.addToQueue(this.getNIOBufferPointer(buffer));
        } else if (!this.jsr239_conform) {
            ByteBuffer byteBuffer = null;
            int n = buffer.position();
            if (buffer instanceof ByteBuffer) {
                byte[] byArray = new byte[buffer.remaining()];
                ByteBuffer byteBuffer2 = (ByteBuffer)buffer;
                byteBuffer = BufferUtil.newByteBuffer(buffer.remaining());
                byteBuffer2.get(byArray);
                byteBuffer.put(byArray);
            } else if (buffer instanceof ShortBuffer) {
                short[] sArray = new short[buffer.remaining()];
                ShortBuffer shortBuffer = (ShortBuffer)buffer;
                byteBuffer = BufferUtil.newByteBuffer(buffer.remaining() * 2);
                shortBuffer.get(sArray);
                ShortBuffer shortBuffer2 = byteBuffer.asShortBuffer();
                shortBuffer2.put(sArray);
            } else if (buffer instanceof IntBuffer) {
                int[] nArray = new int[buffer.remaining()];
                IntBuffer intBuffer = (IntBuffer)buffer;
                byteBuffer = BufferUtil.newByteBuffer(buffer.remaining() * 4);
                intBuffer.get(nArray);
                IntBuffer intBuffer2 = byteBuffer.asIntBuffer();
                intBuffer2.put(nArray);
            } else if (buffer instanceof FloatBuffer) {
                float[] fArray = new float[buffer.remaining()];
                FloatBuffer floatBuffer = (FloatBuffer)buffer;
                byteBuffer = BufferUtil.newByteBuffer(buffer.remaining() * 4);
                floatBuffer.get(fArray);
                FloatBuffer floatBuffer2 = byteBuffer.asFloatBuffer();
                floatBuffer2.put(fArray);
            } else {
                throw new GLException("only indirect ByteBuffer, ShortBuffer, IntBuffer and FloatBuffer are supported by the JOGL command queueing");
            }
            byteBuffer.rewind();
            buffer.position(n);
            this.tmpBufferStorage.add(byteBuffer);
            this.addToQueue(this.getNIOBufferPointer(byteBuffer));
        } else {
            throw new GLException("nondirect nio buffers are not supported by the JOGL command queueing");
        }
    }

    private native void setDebuggingEnabled0(boolean bl) {
    }

    public void setDebuggingEnabled(boolean bl) {
        this.debugQueue = bl;
        this.setDebuggingEnabled0(bl);
    }

    public boolean isDebuggingEnabled() {
        return this.debugQueue;
    }

    private native void setDebugLevel0(int n) {
    }

    public void setDebugLevel(int n) {
        this.debugLevel = n;
        this.setDebugLevel0(n);
    }

    public int getDebugLevel() {
        return this.debugLevel;
    }

    private native void setKernelTracesEnabled0(boolean bl) {
    }

    public void setKernelTracesEnabled(boolean bl) {
        this.kernelTracesEnabled = bl;
        this.setKernelTracesEnabled0(bl);
    }

    public boolean isKernelTracingEnabled() {
        return this.kernelTracesEnabled;
    }

    private native void setPerformanceStatisticsEnabled0(boolean bl) {
    }

    public void setPerformanceStatisticsEnabled(boolean bl) {
        this.performanceStatisticsEnabled = bl;
        this.setPerformanceStatisticsEnabled0(bl);
    }

    private native void setPerformanceStatisticsLevel0(int n) {
    }

    public void setPerformanceStatisticsLevel(int n) {
        this.performanceStatisticsLevel = n;
        this.setPerformanceStatisticsLevel0(n);
    }

    public boolean isPerformanceStatisticsEnabled() {
        return this.performanceStatisticsEnabled;
    }

    public int getPerformanceStatisticsLevel() {
        return this.performanceStatisticsLevel;
    }

    private native void printPerformanceStatistics0(int n) {
    }

    public void printPerformanceStatistics(int n) {
        this.printPerformanceStatistics0(n);
    }

    private native void resetPerformanceStatistics0() {
    }

    public void resetPerformanceStatistics() {
        this.resetPerformanceStatistics0();
    }

    private native void setGLFinishAfterFlushQueueEnabled0(boolean bl) {
    }

    public void setGLFinishAfterFlushQueueEnabled(boolean bl) {
        this.glFinishAfterFlushQueueEnabled = bl;
        this.setGLFinishAfterFlushQueueEnabled0(bl);
    }

    static {
        commandStrings = new String[]{"NULL_COMMAND", "glActiveTexture", "glAttachShader", "glBindAttribLocation", "glBindBuffer", "glBindFramebuffer", "glBindRenderbuffer", "glBindTexture", "glBlendColor", "glBlendEquation", "glBlendEquationSeparate", "glBlendFunc", "glBlendFuncSeparate", "glBufferData", "glBufferSubData", "glCheckFramebufferStatus", "glClear", "glClearColor", "glClearDepthf", "glClearStencil", "glColorMask", "glCompileShader", "glCompressedTexImage2D", "glCompressedTexSubImage2D", "glCopyTexImage2D", "glCopyTexSubImage2D", "glCoverageMaskNV", "glCoverageOperationNV", "glCreateProgram", "glCreateShader", "glCullFace", "glDeleteBuffers", "glDeleteBuffers", "glDeleteFramebuffers", "glDeleteFramebuffers", "glDeleteProgram", "glDeleteRenderbuffers", "glDeleteRenderbuffers", "glDeleteShader", "glDeleteTextures", "glDeleteTextures", "glDepthFunc", "glDepthMask", "glDepthRangef", "glDetachShader", "glDisable", "glDisableVertexAttribArray", "glDrawArrays", "glDrawElements", "glDrawElements", "glEnable", "glEnableVertexAttribArray", "glFinish", "glFlush", "glFramebufferRenderbuffer", "glFramebufferTexture2D", "glFrontFace", "glGenBuffers", "glGenBuffers", "glGenFramebuffers", "glGenFramebuffers", "glGenRenderbuffers", "glGenRenderbuffers", "glGenTextures", "glGenTextures", "glGenerateMipmap", "glGetActiveAttrib", "glGetActiveAttrib", "glGetActiveUniform", "glGetActiveUniform", "glGetAttachedShaders", "glGetAttachedShaders", "glGetAttribLocation", "glGetBooleanv", "glGetBooleanv", "glGetBufferParameteriv", "glGetBufferParameteriv", "glGetError", "glGetFloatv", "glGetFloatv", "glGetFramebufferAttachmentParameteriv", "glGetFramebufferAttachmentParameteriv", "glGetIntegerv", "glGetIntegerv", "glGetProgramInfoLog", "glGetProgramInfoLog", "glGetProgramiv", "glGetProgramiv", "glGetRenderbufferParameteriv", "glGetRenderbufferParameteriv", "glGetShaderInfoLog", "glGetShaderInfoLog", "glGetShaderPrecisionFormat", "glGetShaderSource", "glGetShaderiv", "glGetShaderiv", "glGetString", "glGetTexParameterfv", "glGetTexParameterfv", "glGetTexParameteriv", "glGetTexParameteriv", "glGetUniformLocation", "glGetUniformfv", "glGetUniformfv", "glGetUniformiv", "glGetUniformiv", "glGetVertexAttribfv", "glGetVertexAttribfv", "glGetVertexAttribiv", "glGetVertexAttribiv", "glHint", "glIsBuffer", "glIsEnabled", "glIsFramebuffer", "glIsProgram", "glIsRenderbuffer", "glIsShader", "glIsTexture", "glLineWidth", "glLinkProgram", "glPixelStorei", "glPolygonOffset", "glReadPixels", "glReleaseShaderCompiler", "glRenderbufferStorage", "glSampleCoverage", "glScissor", "glShaderBinary", "glShaderSource", "glShaderSource", "glStencilFunc", "glStencilFuncSeparate", "glStencilMask", "glStencilMaskSeparate", "glStencilOp", "glStencilOpSeparate", "glTexImage2D", "glTexParameterf", "glTexParameterfv", "glTexParameterfv", "glTexParameteri", "glTexParameteriv", "glTexParameteriv", "glTexSubImage2D", "glUniform1f", "glUniform1fv", "glUniform1fv", "glUniform1i", "glUniform1iv", "glUniform1iv", "glUniform2f", "glUniform2fv", "glUniform2fv", "glUniform2i", "glUniform2iv", "glUniform2iv", "glUniform3f", "glUniform3fv", "glUniform3fv", "glUniform3i", "glUniform3iv", "glUniform3iv", "glUniform4f", "glUniform4fv", "glUniform4fv", "glUniform4i", "glUniform4iv", "glUniform4iv", "glUniformMatrix2fv", "glUniformMatrix2fv", "glUniformMatrix3fv", "glUniformMatrix3fv", "glUniformMatrix4fv", "glUniformMatrix4fv", "glUseProgram", "glValidateProgram", "glVertexAttrib1f", "glVertexAttrib1fv", "glVertexAttrib1fv", "glVertexAttrib2f", "glVertexAttrib2fv", "glVertexAttrib2fv", "glVertexAttrib3f", "glVertexAttrib3fv", "glVertexAttrib3fv", "glVertexAttrib4f", "glVertexAttrib4fv", "glVertexAttrib4fv", "glVertexAttribPointer", "glVertexAttribPointer", "glViewport"};
    }
}

