/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.gluegen.runtime.BufferFactory;
import java.nio.IntBuffer;
import javax.media.opengl.GLException;

public class EGL {
    public static final int KHRONOS_FALSE;
    public static final int KHRONOS_TRUE;
    public static final long KHRONOS_BOOLEAN_ENUM_FORCE_SIZE;
    public static final int KHRONOS_SUPPORT_INT64;
    public static final int KHRONOS_SUPPORT_FLOAT;
    public static final long KHRONOS_MAX_ENUM;
    public static final int EGL_VERSION_1_0;
    public static final int EGL_VERSION_1_1;
    public static final int EGL_VERSION_1_2;
    public static final int EGL_VERSION_1_3;
    public static final int EGL_VERSION_1_4;
    public static final int EGL_FALSE;
    public static final int EGL_TRUE;
    public static final int EGL_DEFAULT_DISPLAY;
    public static final int EGL_NO_CONTEXT;
    public static final int EGL_NO_DISPLAY;
    public static final int EGL_NO_SURFACE;
    public static final int EGL_SUCCESS;
    public static final int EGL_NOT_INITIALIZED;
    public static final int EGL_BAD_ACCESS;
    public static final int EGL_BAD_ALLOC;
    public static final int EGL_BAD_ATTRIBUTE;
    public static final int EGL_BAD_CONFIG;
    public static final int EGL_BAD_CONTEXT;
    public static final int EGL_BAD_CURRENT_SURFACE;
    public static final int EGL_BAD_DISPLAY;
    public static final int EGL_BAD_MATCH;
    public static final int EGL_BAD_NATIVE_PIXMAP;
    public static final int EGL_BAD_NATIVE_WINDOW;
    public static final int EGL_BAD_PARAMETER;
    public static final int EGL_BAD_SURFACE;
    public static final int EGL_CONTEXT_LOST;
    public static final int EGL_BUFFER_SIZE;
    public static final int EGL_ALPHA_SIZE;
    public static final int EGL_BLUE_SIZE;
    public static final int EGL_GREEN_SIZE;
    public static final int EGL_RED_SIZE;
    public static final int EGL_DEPTH_SIZE;
    public static final int EGL_STENCIL_SIZE;
    public static final int EGL_CONFIG_CAVEAT;
    public static final int EGL_CONFIG_ID;
    public static final int EGL_LEVEL;
    public static final int EGL_MAX_PBUFFER_HEIGHT;
    public static final int EGL_MAX_PBUFFER_PIXELS;
    public static final int EGL_MAX_PBUFFER_WIDTH;
    public static final int EGL_NATIVE_RENDERABLE;
    public static final int EGL_NATIVE_VISUAL_ID;
    public static final int EGL_NATIVE_VISUAL_TYPE;
    public static final int EGL_SAMPLES;
    public static final int EGL_SAMPLE_BUFFERS;
    public static final int EGL_SURFACE_TYPE;
    public static final int EGL_TRANSPARENT_TYPE;
    public static final int EGL_TRANSPARENT_BLUE_VALUE;
    public static final int EGL_TRANSPARENT_GREEN_VALUE;
    public static final int EGL_TRANSPARENT_RED_VALUE;
    public static final int EGL_NONE;
    public static final int EGL_BIND_TO_TEXTURE_RGB;
    public static final int EGL_BIND_TO_TEXTURE_RGBA;
    public static final int EGL_MIN_SWAP_INTERVAL;
    public static final int EGL_MAX_SWAP_INTERVAL;
    public static final int EGL_LUMINANCE_SIZE;
    public static final int EGL_ALPHA_MASK_SIZE;
    public static final int EGL_COLOR_BUFFER_TYPE;
    public static final int EGL_RENDERABLE_TYPE;
    public static final int EGL_MATCH_NATIVE_PIXMAP;
    public static final int EGL_CONFORMANT;
    public static final int EGL_SLOW_CONFIG;
    public static final int EGL_NON_CONFORMANT_CONFIG;
    public static final int EGL_TRANSPARENT_RGB;
    public static final int EGL_RGB_BUFFER;
    public static final int EGL_LUMINANCE_BUFFER;
    public static final int EGL_NO_TEXTURE;
    public static final int EGL_TEXTURE_RGB;
    public static final int EGL_TEXTURE_RGBA;
    public static final int EGL_TEXTURE_2D;
    public static final int EGL_PBUFFER_BIT;
    public static final int EGL_PIXMAP_BIT;
    public static final int EGL_WINDOW_BIT;
    public static final int EGL_VG_COLORSPACE_LINEAR_BIT;
    public static final int EGL_VG_ALPHA_FORMAT_PRE_BIT;
    public static final int EGL_MULTISAMPLE_RESOLVE_BOX_BIT;
    public static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT;
    public static final int EGL_OPENGL_ES_BIT;
    public static final int EGL_OPENVG_BIT;
    public static final int EGL_OPENGL_ES2_BIT;
    public static final int EGL_OPENGL_BIT;
    public static final int EGL_VENDOR;
    public static final int EGL_VERSION;
    public static final int EGL_EXTENSIONS;
    public static final int EGL_CLIENT_APIS;
    public static final int EGL_HEIGHT;
    public static final int EGL_WIDTH;
    public static final int EGL_LARGEST_PBUFFER;
    public static final int EGL_TEXTURE_FORMAT;
    public static final int EGL_TEXTURE_TARGET;
    public static final int EGL_MIPMAP_TEXTURE;
    public static final int EGL_MIPMAP_LEVEL;
    public static final int EGL_RENDER_BUFFER;
    public static final int EGL_VG_COLORSPACE;
    public static final int EGL_VG_ALPHA_FORMAT;
    public static final int EGL_HORIZONTAL_RESOLUTION;
    public static final int EGL_VERTICAL_RESOLUTION;
    public static final int EGL_PIXEL_ASPECT_RATIO;
    public static final int EGL_SWAP_BEHAVIOR;
    public static final int EGL_MULTISAMPLE_RESOLVE;
    public static final int EGL_BACK_BUFFER;
    public static final int EGL_SINGLE_BUFFER;
    public static final int EGL_VG_COLORSPACE_sRGB;
    public static final int EGL_VG_COLORSPACE_LINEAR;
    public static final int EGL_VG_ALPHA_FORMAT_NONPRE;
    public static final int EGL_VG_ALPHA_FORMAT_PRE;
    public static final int EGL_DISPLAY_SCALING;
    public static final int EGL_BUFFER_PRESERVED;
    public static final int EGL_BUFFER_DESTROYED;
    public static final int EGL_OPENVG_IMAGE;
    public static final int EGL_CONTEXT_CLIENT_TYPE;
    public static final int EGL_CONTEXT_CLIENT_VERSION;
    public static final int EGL_MULTISAMPLE_RESOLVE_DEFAULT;
    public static final int EGL_MULTISAMPLE_RESOLVE_BOX;
    public static final int EGL_OPENGL_ES_API;
    public static final int EGL_OPENVG_API;
    public static final int EGL_OPENGL_API;
    public static final int EGL_DRAW;
    public static final int EGL_READ;
    public static final int EGL_CORE_NATIVE_ENGINE;
    public static final int EGL_COLORSPACE;
    public static final int EGL_ALPHA_FORMAT;
    public static final int EGL_COLORSPACE_sRGB;
    public static final int EGL_COLORSPACE_LINEAR;
    public static final int EGL_ALPHA_FORMAT_NONPRE;
    public static final int EGL_ALPHA_FORMAT_PRE;
    public static final int EGL_EGLEXT_VERSION;
    public static final int EGL_KHR_config_attribs;
    public static final int EGL_CONFORMANT_KHR;
    public static final int EGL_VG_COLORSPACE_LINEAR_BIT_KHR;
    public static final int EGL_VG_ALPHA_FORMAT_PRE_BIT_KHR;
    public static final int EGL_KHR_lock_surface;
    public static final int EGL_READ_SURFACE_BIT_KHR;
    public static final int EGL_WRITE_SURFACE_BIT_KHR;
    public static final int EGL_LOCK_SURFACE_BIT_KHR;
    public static final int EGL_OPTIMAL_FORMAT_BIT_KHR;
    public static final int EGL_MATCH_FORMAT_KHR;
    public static final int EGL_FORMAT_RGB_565_EXACT_KHR;
    public static final int EGL_FORMAT_RGB_565_KHR;
    public static final int EGL_FORMAT_RGBA_8888_EXACT_KHR;
    public static final int EGL_FORMAT_RGBA_8888_KHR;
    public static final int EGL_MAP_PRESERVE_PIXELS_KHR;
    public static final int EGL_LOCK_USAGE_HINT_KHR;
    public static final int EGL_BITMAP_POINTER_KHR;
    public static final int EGL_BITMAP_PITCH_KHR;
    public static final int EGL_BITMAP_ORIGIN_KHR;
    public static final int EGL_BITMAP_PIXEL_RED_OFFSET_KHR;
    public static final int EGL_BITMAP_PIXEL_GREEN_OFFSET_KHR;
    public static final int EGL_BITMAP_PIXEL_BLUE_OFFSET_KHR;
    public static final int EGL_BITMAP_PIXEL_ALPHA_OFFSET_KHR;
    public static final int EGL_BITMAP_PIXEL_LUMINANCE_OFFSET_KHR;
    public static final int EGL_LOWER_LEFT_KHR;
    public static final int EGL_UPPER_LEFT_KHR;
    public static final int EGL_KHR_image;
    public static final int EGL_NATIVE_PIXMAP_KHR;
    public static final int EGL_KHR_vg_parent_image;
    public static final int EGL_VG_PARENT_IMAGE_KHR;
    public static final int EGL_KHR_gl_texture_2D_image;
    public static final int EGL_GL_TEXTURE_2D_KHR;
    public static final int EGL_GL_TEXTURE_LEVEL_KHR;
    public static final int EGL_KHR_gl_texture_cubemap_image;
    public static final int EGL_GL_TEXTURE_CUBE_MAP_POSITIVE_X_KHR;
    public static final int EGL_GL_TEXTURE_CUBE_MAP_NEGATIVE_X_KHR;
    public static final int EGL_GL_TEXTURE_CUBE_MAP_POSITIVE_Y_KHR;
    public static final int EGL_GL_TEXTURE_CUBE_MAP_NEGATIVE_Y_KHR;
    public static final int EGL_GL_TEXTURE_CUBE_MAP_POSITIVE_Z_KHR;
    public static final int EGL_GL_TEXTURE_CUBE_MAP_NEGATIVE_Z_KHR;
    public static final int EGL_KHR_gl_texture_3D_image;
    public static final int EGL_GL_TEXTURE_3D_KHR;
    public static final int EGL_GL_TEXTURE_ZOFFSET_KHR;
    public static final int EGL_KHR_gl_renderbuffer_image;
    public static final int EGL_GL_RENDERBUFFER_KHR;
    public static final int EGL_KHR_reusable_sync;
    public static final int EGL_SYNC_STATUS_KHR;
    public static final int EGL_SIGNALED_KHR;
    public static final int EGL_UNSIGNALED_KHR;
    public static final int EGL_TIMEOUT_EXPIRED_KHR;
    public static final int EGL_CONDITION_SATISFIED_KHR;
    public static final int EGL_SYNC_TYPE_KHR;
    public static final int EGL_SYNC_REUSABLE_KHR;
    public static final int EGL_SYNC_FLUSH_COMMANDS_BIT_KHR;
    public static final int EGL_KHR_image_base;
    public static final int EGL_IMAGE_PRESERVED_KHR;
    public static final int EGL_KHR_image_pixmap;
    public static final int EGL_IMG_context_priority;
    public static final int EGL_CONTEXT_PRIORITY_LEVEL_IMG;
    public static final int EGL_CONTEXT_PRIORITY_HIGH_IMG;
    public static final int EGL_CONTEXT_PRIORITY_MEDIUM_IMG;
    public static final int EGL_CONTEXT_PRIORITY_LOW_IMG;
    public static final int EGL_PERFMONITOR_HARDWARE_COUNTERS_BIT_NV;
    public static final int EGL_PERFMONITOR_OPENGL_ES_API_BIT_NV;
    public static final int EGL_PERFMONITOR_OPENVG_API_BIT_NV;
    public static final int EGL_PERFMONITOR_OPENGL_ES2_API_BIT_NV;
    public static final int EGL_COUNTER_NAME_NV;
    public static final int EGL_COUNTER_DESCRIPTION_NV;
    public static final int EGL_IS_HARDWARE_COUNTER_NV;
    public static final int EGL_COUNTER_MAX_NV;
    public static final int EGL_COUNTER_VALUE_TYPE_NV;
    public static final int EGL_RAW_VALUE_NV;
    public static final int EGL_PERCENTAGE_VALUE_NV;
    public static final int EGL_BAD_CURRENT_PERFMONITOR_NV;
    public static final int EGL_COVERAGE_BUFFERS_NV;
    public static final int EGL_COVERAGE_SAMPLES_NV;
    public static final int EGL_DEPTH_ENCODING_NV;
    public static final int EGL_DEPTH_ENCODING_NONE_NV;
    public static final int EGL_DEPTH_ENCODING_NONLINEAR_NV;
    public static final int EGL_SYNC_PRIOR_COMMANDS_COMPLETE_NV;
    public static final int EGL_SYNC_STATUS_NV;
    public static final int EGL_SIGNALED_NV;
    public static final int EGL_UNSIGNALED_NV;
    public static final int EGL_SYNC_FLUSH_COMMANDS_BIT_NV;
    public static final int EGL_ALREADY_SIGNALED_NV;
    public static final int EGL_TIMEOUT_EXPIRED_NV;
    public static final int EGL_CONDITION_SATISFIED_NV;
    public static final int EGL_SYNC_TYPE_NV;
    public static final int EGL_SYNC_CONDITION_NV;
    public static final int EGL_SYNC_FENCE_NV;
    public static final int EGL_create_pbuffer_from_client_buffer;
    public static final int EGL_KHR_bind_client_buffer;
    public static final int EGL_OPENVG_IMAGE_KHR;
    public static final int EGL_GL_TEXTURE_RECTANGLE_NV_KHR;
    public static final int EGL_TEXTURE_RECTANGLE_NV;
    public static final int EGL_NVVA_OUTPUT_SURFACE_NV;
    public static final int EGL_NVMA_OUTPUT_SURFACE_NV;
    public static final int EGL_OPENMAX_IL_BIT_NV;
    public static final int EGL_SURFACE_OMX_IL_EVENT_CALLBACK_NV;
    public static final int EGL_SURFACE_OMX_IL_EMPTY_BUFFER_DONE_CALLBACK_NV;
    public static final int EGL_SURFACE_OMX_IL_CALLBACK_DATA_NV;
    public static final int EGL_SURFACE_COMPONENT_HANDLE_NV;
    public static final int EGL_SWAP_HINT_NV;
    public static final int EGL_FASTEST_NV;
    public static final int EGL_ANDROID_image_native_buffer;
    public static final int EGL_NATIVE_BUFFER_ANDROID;
    public static final int EGL_DONT_CARE;
    public static final int EGL_UNKNOWN;

    public static native boolean eglBindAPI(int n) {
    }

    public static native boolean eglBindTexImage(int n, int n2, int n3) {
    }

    public static boolean eglChooseConfig(int n, IntBuffer intBuffer, IntBuffer intBuffer2, int n2, IntBuffer intBuffer3) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"configs\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new GLException("Argument \"num_config\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            return EGL.eglChooseConfig0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), n2, intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3));
        }
        return EGL.eglChooseConfig1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), n2, BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3));
    }

    private static native boolean eglChooseConfig0(int n, Object object, int n2, Object object2, int n3, int n4, Object object3, int n5) {
    }

    private static native boolean eglChooseConfig1(int n, Object object, int n2, Object object2, int n3, int n4, Object object3, int n5) {
    }

    public static boolean eglChooseConfig(int n, int[] nArray, int n2, int[] nArray2, int n3, int n4, int[] nArray3, int n5) {
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"attrib_list_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"configs_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n5) {
            throw new GLException(new StringBuffer().append("array offset argument \"num_config_offset\" (").append(n5).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        return EGL.eglChooseConfig1(n, nArray, 4 * n2, nArray2, 4 * n3, n4, nArray3, 4 * n5);
    }

    public static native boolean eglCopyBuffers(int n, int n2, int n3) {
    }

    public static int eglCreateContext(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglCreateContext0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglCreateContext1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int eglCreateContext0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native int eglCreateContext1(int n, int n2, int n3, Object object, int n4) {
    }

    public static int eglCreateContext(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"attrib_list_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglCreateContext1(n, n2, n3, nArray, 4 * n4);
    }

    public static int eglCreatePbufferFromClientBuffer(int n, int n2, int n3, int n4, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglCreatePbufferFromClientBuffer0(n, n2, n3, n4, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglCreatePbufferFromClientBuffer1(n, n2, n3, n4, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int eglCreatePbufferFromClientBuffer0(int n, int n2, int n3, int n4, Object object, int n5) {
    }

    private static native int eglCreatePbufferFromClientBuffer1(int n, int n2, int n3, int n4, Object object, int n5) {
    }

    public static int eglCreatePbufferFromClientBuffer(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        if (nArray != null && nArray.length <= n5) {
            throw new GLException(new StringBuffer().append("array offset argument \"attrib_list_offset\" (").append(n5).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglCreatePbufferFromClientBuffer1(n, n2, n3, n4, nArray, 4 * n5);
    }

    public static int eglCreatePbufferSurface(int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglCreatePbufferSurface0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglCreatePbufferSurface1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int eglCreatePbufferSurface0(int n, int n2, Object object, int n3) {
    }

    private static native int eglCreatePbufferSurface1(int n, int n2, Object object, int n3) {
    }

    public static int eglCreatePbufferSurface(int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"attrib_list_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglCreatePbufferSurface1(n, n2, nArray, 4 * n3);
    }

    public static int eglCreatePixmapSurface(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglCreatePixmapSurface0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglCreatePixmapSurface1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int eglCreatePixmapSurface0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native int eglCreatePixmapSurface1(int n, int n2, int n3, Object object, int n4) {
    }

    public static int eglCreatePixmapSurface(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"attrib_list_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglCreatePixmapSurface1(n, n2, n3, nArray, 4 * n4);
    }

    public static int eglCreateWindowSurface(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglCreateWindowSurface0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglCreateWindowSurface1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int eglCreateWindowSurface0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native int eglCreateWindowSurface1(int n, int n2, int n3, Object object, int n4) {
    }

    public static int eglCreateWindowSurface(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"attrib_list_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglCreateWindowSurface1(n, n2, n3, nArray, 4 * n4);
    }

    public static native boolean eglDestroyContext(int n, int n2) {
    }

    public static native boolean eglDestroySurface(int n, int n2) {
    }

    public static boolean eglGetConfigAttrib(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglGetConfigAttrib0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglGetConfigAttrib1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native boolean eglGetConfigAttrib0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native boolean eglGetConfigAttrib1(int n, int n2, int n3, Object object, int n4) {
    }

    public static boolean eglGetConfigAttrib(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglGetConfigAttrib1(n, n2, n3, nArray, 4 * n4);
    }

    public static boolean eglGetConfigs(int n, IntBuffer intBuffer, int n2, IntBuffer intBuffer2) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"num_config\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            return EGL.eglGetConfigs0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), n2, intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2));
        }
        return EGL.eglGetConfigs1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), n2, BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2));
    }

    private static native boolean eglGetConfigs0(int n, Object object, int n2, int n3, Object object2, int n4) {
    }

    private static native boolean eglGetConfigs1(int n, Object object, int n2, int n3, Object object2, int n4) {
    }

    public static boolean eglGetConfigs(int n, int[] nArray, int n2, int n3, int[] nArray2, int n4) {
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"configs_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"num_config_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        return EGL.eglGetConfigs1(n, nArray, 4 * n2, n3, nArray2, 4 * n4);
    }

    public static native int eglGetCurrentContext() {
    }

    public static native int eglGetCurrentDisplay() {
    }

    public static native int eglGetCurrentSurface(int n) {
    }

    public static native int eglGetDisplay(int n) {
    }

    public static native int eglGetError() {
    }

    public static native long eglGetProcAddress(String string) {
    }

    public static boolean eglInitialize(int n, IntBuffer intBuffer, IntBuffer intBuffer2) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new GLException("Argument \"minor\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (bl) {
            return EGL.eglInitialize0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2));
        }
        return EGL.eglInitialize1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2));
    }

    private static native boolean eglInitialize0(int n, Object object, int n2, Object object2, int n3) {
    }

    private static native boolean eglInitialize1(int n, Object object, int n2, Object object2, int n3) {
    }

    public static boolean eglInitialize(int n, int[] nArray, int n2, int[] nArray2, int n3) {
        if (nArray != null && nArray.length <= n2) {
            throw new GLException(new StringBuffer().append("array offset argument \"major_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n3) {
            throw new GLException(new StringBuffer().append("array offset argument \"minor_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        return EGL.eglInitialize1(n, nArray, 4 * n2, nArray2, 4 * n3);
    }

    public static native boolean eglMakeCurrent(int n, int n2, int n3, int n4) {
    }

    public static native int eglQueryAPI() {
    }

    public static boolean eglQueryContext(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglQueryContext0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglQueryContext1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native boolean eglQueryContext0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native boolean eglQueryContext1(int n, int n2, int n3, Object object, int n4) {
    }

    public static boolean eglQueryContext(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglQueryContext1(n, n2, n3, nArray, 4 * n4);
    }

    public static native String eglQueryString(int n, int n2) {
    }

    public static boolean eglQuerySurface(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.eglQuerySurface0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.eglQuerySurface1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native boolean eglQuerySurface0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native boolean eglQuerySurface1(int n, int n2, int n3, Object object, int n4) {
    }

    public static boolean eglQuerySurface(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"value_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.eglQuerySurface1(n, n2, n3, nArray, 4 * n4);
    }

    public static native boolean eglReleaseTexImage(int n, int n2, int n3) {
    }

    public static native boolean eglReleaseThread() {
    }

    public static native boolean eglSurfaceAttrib(int n, int n2, int n3, int n4) {
    }

    public static native boolean eglSwapBuffers(int n, int n2) {
    }

    public static native boolean eglSwapInterval(int n, int n2) {
    }

    public static native boolean eglTerminate(int n) {
    }

    public static native boolean eglWaitClient() {
    }

    public static native boolean eglWaitGL() {
    }

    public static native boolean eglWaitNative(int n) {
    }

    public static native void kdDeinit() {
    }

    public static native int kdGetDisplayHeight() {
    }

    public static native int kdGetDisplayWidth() {
    }

    public static native void kdInit() {
    }

    public static int kdWindowCreate(int n, int n2, int n3, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return EGL.kdWindowCreate0(n, n2, n3, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return EGL.kdWindowCreate1(n, n2, n3, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int kdWindowCreate0(int n, int n2, int n3, Object object, int n4) {
    }

    private static native int kdWindowCreate1(int n, int n2, int n3, Object object, int n4) {
    }

    public static int kdWindowCreate(int n, int n2, int n3, int[] nArray, int n4) {
        if (nArray != null && nArray.length <= n4) {
            throw new GLException(new StringBuffer().append("array offset argument \"handle_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return EGL.kdWindowCreate1(n, n2, n3, nArray, 4 * n4);
    }

    public static void kdWindowDestroy(IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            EGL.kdWindowDestroy0(intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        } else {
            EGL.kdWindowDestroy1(BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        }
    }

    private static native void kdWindowDestroy0(Object object, int n) {
    }

    private static native void kdWindowDestroy1(Object object, int n) {
    }

    public static void kdWindowDestroy(int[] nArray, int n) {
        if (nArray != null && nArray.length <= n) {
            throw new GLException(new StringBuffer().append("array offset argument \"handle_offset\" (").append(n).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        EGL.kdWindowDestroy1(nArray, 4 * n);
    }
}

