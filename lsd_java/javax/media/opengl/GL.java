/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface GL {
    public static final int KHRONOS_FALSE;
    public static final int KHRONOS_TRUE;
    public static final long KHRONOS_BOOLEAN_ENUM_FORCE_SIZE;
    public static final int KHRONOS_SUPPORT_INT64;
    public static final int KHRONOS_SUPPORT_FLOAT;
    public static final long KHRONOS_MAX_ENUM;
    public static final int GL_ES_VERSION_2_0;
    public static final int GL_DEPTH_BUFFER_BIT;
    public static final int GL_STENCIL_BUFFER_BIT;
    public static final int GL_COLOR_BUFFER_BIT;
    public static final int GL_FALSE;
    public static final int GL_TRUE;
    public static final int GL_POINTS;
    public static final int GL_LINES;
    public static final int GL_LINE_LOOP;
    public static final int GL_LINE_STRIP;
    public static final int GL_TRIANGLES;
    public static final int GL_TRIANGLE_STRIP;
    public static final int GL_TRIANGLE_FAN;
    public static final int GL_ZERO;
    public static final int GL_ONE;
    public static final int GL_SRC_COLOR;
    public static final int GL_ONE_MINUS_SRC_COLOR;
    public static final int GL_SRC_ALPHA;
    public static final int GL_ONE_MINUS_SRC_ALPHA;
    public static final int GL_DST_ALPHA;
    public static final int GL_ONE_MINUS_DST_ALPHA;
    public static final int GL_DST_COLOR;
    public static final int GL_ONE_MINUS_DST_COLOR;
    public static final int GL_SRC_ALPHA_SATURATE;
    public static final int GL_FUNC_ADD;
    public static final int GL_BLEND_EQUATION;
    public static final int GL_BLEND_EQUATION_RGB;
    public static final int GL_BLEND_EQUATION_ALPHA;
    public static final int GL_FUNC_SUBTRACT;
    public static final int GL_FUNC_REVERSE_SUBTRACT;
    public static final int GL_BLEND_DST_RGB;
    public static final int GL_BLEND_SRC_RGB;
    public static final int GL_BLEND_DST_ALPHA;
    public static final int GL_BLEND_SRC_ALPHA;
    public static final int GL_CONSTANT_COLOR;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR;
    public static final int GL_CONSTANT_ALPHA;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA;
    public static final int GL_BLEND_COLOR;
    public static final int GL_ARRAY_BUFFER;
    public static final int GL_ELEMENT_ARRAY_BUFFER;
    public static final int GL_ARRAY_BUFFER_BINDING;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING;
    public static final int GL_STREAM_DRAW;
    public static final int GL_STATIC_DRAW;
    public static final int GL_DYNAMIC_DRAW;
    public static final int GL_BUFFER_SIZE;
    public static final int GL_BUFFER_USAGE;
    public static final int GL_CURRENT_VERTEX_ATTRIB;
    public static final int GL_FRONT;
    public static final int GL_BACK;
    public static final int GL_FRONT_AND_BACK;
    public static final int GL_TEXTURE_2D;
    public static final int GL_CULL_FACE;
    public static final int GL_BLEND;
    public static final int GL_DITHER;
    public static final int GL_STENCIL_TEST;
    public static final int GL_DEPTH_TEST;
    public static final int GL_SCISSOR_TEST;
    public static final int GL_POLYGON_OFFSET_FILL;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE;
    public static final int GL_SAMPLE_COVERAGE;
    public static final int GL_NO_ERROR;
    public static final int GL_INVALID_ENUM;
    public static final int GL_INVALID_VALUE;
    public static final int GL_INVALID_OPERATION;
    public static final int GL_OUT_OF_MEMORY;
    public static final int GL_CW;
    public static final int GL_CCW;
    public static final int GL_LINE_WIDTH;
    public static final int GL_ALIASED_POINT_SIZE_RANGE;
    public static final int GL_ALIASED_LINE_WIDTH_RANGE;
    public static final int GL_CULL_FACE_MODE;
    public static final int GL_FRONT_FACE;
    public static final int GL_DEPTH_RANGE;
    public static final int GL_DEPTH_WRITEMASK;
    public static final int GL_DEPTH_CLEAR_VALUE;
    public static final int GL_DEPTH_FUNC;
    public static final int GL_STENCIL_CLEAR_VALUE;
    public static final int GL_STENCIL_FUNC;
    public static final int GL_STENCIL_FAIL;
    public static final int GL_STENCIL_PASS_DEPTH_FAIL;
    public static final int GL_STENCIL_PASS_DEPTH_PASS;
    public static final int GL_STENCIL_REF;
    public static final int GL_STENCIL_VALUE_MASK;
    public static final int GL_STENCIL_WRITEMASK;
    public static final int GL_STENCIL_BACK_FUNC;
    public static final int GL_STENCIL_BACK_FAIL;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS;
    public static final int GL_STENCIL_BACK_REF;
    public static final int GL_STENCIL_BACK_VALUE_MASK;
    public static final int GL_STENCIL_BACK_WRITEMASK;
    public static final int GL_VIEWPORT;
    public static final int GL_SCISSOR_BOX;
    public static final int GL_COLOR_CLEAR_VALUE;
    public static final int GL_COLOR_WRITEMASK;
    public static final int GL_UNPACK_ALIGNMENT;
    public static final int GL_PACK_ALIGNMENT;
    public static final int GL_MAX_TEXTURE_SIZE;
    public static final int GL_MAX_VIEWPORT_DIMS;
    public static final int GL_SUBPIXEL_BITS;
    public static final int GL_RED_BITS;
    public static final int GL_GREEN_BITS;
    public static final int GL_BLUE_BITS;
    public static final int GL_ALPHA_BITS;
    public static final int GL_DEPTH_BITS;
    public static final int GL_STENCIL_BITS;
    public static final int GL_POLYGON_OFFSET_UNITS;
    public static final int GL_POLYGON_OFFSET_FACTOR;
    public static final int GL_TEXTURE_BINDING_2D;
    public static final int GL_SAMPLE_BUFFERS;
    public static final int GL_SAMPLES;
    public static final int GL_SAMPLE_COVERAGE_VALUE;
    public static final int GL_SAMPLE_COVERAGE_INVERT;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS;
    public static final int GL_DONT_CARE;
    public static final int GL_FASTEST;
    public static final int GL_NICEST;
    public static final int GL_GENERATE_MIPMAP_HINT;
    public static final int GL_BYTE;
    public static final int GL_UNSIGNED_BYTE;
    public static final int GL_SHORT;
    public static final int GL_UNSIGNED_SHORT;
    public static final int GL_INT;
    public static final int GL_UNSIGNED_INT;
    public static final int GL_FLOAT;
    public static final int GL_FIXED;
    public static final int GL_DEPTH_COMPONENT;
    public static final int GL_ALPHA;
    public static final int GL_RGB;
    public static final int GL_RGBA;
    public static final int GL_LUMINANCE;
    public static final int GL_LUMINANCE_ALPHA;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1;
    public static final int GL_UNSIGNED_SHORT_5_6_5;
    public static final int GL_FRAGMENT_SHADER;
    public static final int GL_VERTEX_SHADER;
    public static final int GL_MAX_VERTEX_ATTRIBS;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS;
    public static final int GL_MAX_VARYING_VECTORS;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS;
    public static final int GL_SHADER_TYPE;
    public static final int GL_DELETE_STATUS;
    public static final int GL_LINK_STATUS;
    public static final int GL_VALIDATE_STATUS;
    public static final int GL_ATTACHED_SHADERS;
    public static final int GL_ACTIVE_UNIFORMS;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH;
    public static final int GL_ACTIVE_ATTRIBUTES;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH;
    public static final int GL_SHADING_LANGUAGE_VERSION;
    public static final int GL_CURRENT_PROGRAM;
    public static final int GL_NEVER;
    public static final int GL_LESS;
    public static final int GL_EQUAL;
    public static final int GL_LEQUAL;
    public static final int GL_GREATER;
    public static final int GL_NOTEQUAL;
    public static final int GL_GEQUAL;
    public static final int GL_ALWAYS;
    public static final int GL_KEEP;
    public static final int GL_REPLACE;
    public static final int GL_INCR;
    public static final int GL_DECR;
    public static final int GL_INVERT;
    public static final int GL_INCR_WRAP;
    public static final int GL_DECR_WRAP;
    public static final int GL_VENDOR;
    public static final int GL_RENDERER;
    public static final int GL_VERSION;
    public static final int GL_EXTENSIONS;
    public static final int GL_NEAREST;
    public static final int GL_LINEAR;
    public static final int GL_NEAREST_MIPMAP_NEAREST;
    public static final int GL_LINEAR_MIPMAP_NEAREST;
    public static final int GL_NEAREST_MIPMAP_LINEAR;
    public static final int GL_LINEAR_MIPMAP_LINEAR;
    public static final int GL_TEXTURE_MAG_FILTER;
    public static final int GL_TEXTURE_MIN_FILTER;
    public static final int GL_TEXTURE_WRAP_S;
    public static final int GL_TEXTURE_WRAP_T;
    public static final int GL_TEXTURE;
    public static final int GL_TEXTURE_CUBE_MAP;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE;
    public static final int GL_TEXTURE0;
    public static final int GL_TEXTURE1;
    public static final int GL_TEXTURE2;
    public static final int GL_TEXTURE3;
    public static final int GL_TEXTURE4;
    public static final int GL_TEXTURE5;
    public static final int GL_TEXTURE6;
    public static final int GL_TEXTURE7;
    public static final int GL_TEXTURE8;
    public static final int GL_TEXTURE9;
    public static final int GL_TEXTURE10;
    public static final int GL_TEXTURE11;
    public static final int GL_TEXTURE12;
    public static final int GL_TEXTURE13;
    public static final int GL_TEXTURE14;
    public static final int GL_TEXTURE15;
    public static final int GL_TEXTURE16;
    public static final int GL_TEXTURE17;
    public static final int GL_TEXTURE18;
    public static final int GL_TEXTURE19;
    public static final int GL_TEXTURE20;
    public static final int GL_TEXTURE21;
    public static final int GL_TEXTURE22;
    public static final int GL_TEXTURE23;
    public static final int GL_TEXTURE24;
    public static final int GL_TEXTURE25;
    public static final int GL_TEXTURE26;
    public static final int GL_TEXTURE27;
    public static final int GL_TEXTURE28;
    public static final int GL_TEXTURE29;
    public static final int GL_TEXTURE30;
    public static final int GL_TEXTURE31;
    public static final int GL_ACTIVE_TEXTURE;
    public static final int GL_REPEAT;
    public static final int GL_CLAMP_TO_EDGE;
    public static final int GL_MIRRORED_REPEAT;
    public static final int GL_FLOAT_VEC2;
    public static final int GL_FLOAT_VEC3;
    public static final int GL_FLOAT_VEC4;
    public static final int GL_INT_VEC2;
    public static final int GL_INT_VEC3;
    public static final int GL_INT_VEC4;
    public static final int GL_BOOL;
    public static final int GL_BOOL_VEC2;
    public static final int GL_BOOL_VEC3;
    public static final int GL_BOOL_VEC4;
    public static final int GL_FLOAT_MAT2;
    public static final int GL_FLOAT_MAT3;
    public static final int GL_FLOAT_MAT4;
    public static final int GL_SAMPLER_2D;
    public static final int GL_SAMPLER_CUBE;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE;
    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT;
    public static final int GL_COMPILE_STATUS;
    public static final int GL_INFO_LOG_LENGTH;
    public static final int GL_SHADER_SOURCE_LENGTH;
    public static final int GL_SHADER_COMPILER;
    public static final int GL_SHADER_BINARY_FORMATS;
    public static final int GL_NUM_SHADER_BINARY_FORMATS;
    public static final int GL_LOW_FLOAT;
    public static final int GL_MEDIUM_FLOAT;
    public static final int GL_HIGH_FLOAT;
    public static final int GL_LOW_INT;
    public static final int GL_MEDIUM_INT;
    public static final int GL_HIGH_INT;
    public static final int GL_FRAMEBUFFER;
    public static final int GL_RENDERBUFFER;
    public static final int GL_RGBA4;
    public static final int GL_RGB5_A1;
    public static final int GL_RGB565;
    public static final int GL_DEPTH_COMPONENT16;
    public static final int GL_STENCIL_INDEX;
    public static final int GL_STENCIL_INDEX8;
    public static final int GL_RENDERBUFFER_WIDTH;
    public static final int GL_RENDERBUFFER_HEIGHT;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT;
    public static final int GL_RENDERBUFFER_RED_SIZE;
    public static final int GL_RENDERBUFFER_GREEN_SIZE;
    public static final int GL_RENDERBUFFER_BLUE_SIZE;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
    public static final int GL_COLOR_ATTACHMENT0;
    public static final int GL_DEPTH_ATTACHMENT;
    public static final int GL_STENCIL_ATTACHMENT;
    public static final int GL_NONE;
    public static final int GL_FRAMEBUFFER_COMPLETE;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED;
    public static final int GL_FRAMEBUFFER_BINDING;
    public static final int GL_RENDERBUFFER_BINDING;
    public static final int GL_MAX_RENDERBUFFER_SIZE;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION;
    public static final int GL_ETC1_RGB8_OES;
    public static final int GL_PALETTE4_RGB8_OES;
    public static final int GL_PALETTE4_RGBA8_OES;
    public static final int GL_PALETTE4_R5_G6_B5_OES;
    public static final int GL_PALETTE4_RGBA4_OES;
    public static final int GL_PALETTE4_RGB5_A1_OES;
    public static final int GL_PALETTE8_RGB8_OES;
    public static final int GL_PALETTE8_RGBA8_OES;
    public static final int GL_PALETTE8_R5_G6_B5_OES;
    public static final int GL_PALETTE8_RGBA4_OES;
    public static final int GL_PALETTE8_RGB5_A1_OES;
    public static final int GL_DEPTH_COMPONENT24_OES;
    public static final int GL_DEPTH_COMPONENT32_OES;
    public static final int GL_PROGRAM_BINARY_LENGTH_OES;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS_OES;
    public static final int GL_PROGRAM_BINARY_FORMATS_OES;
    public static final int GL_WRITE_ONLY_OES;
    public static final int GL_BUFFER_ACCESS_OES;
    public static final int GL_BUFFER_MAPPED_OES;
    public static final int GL_BUFFER_MAP_POINTER_OES;
    public static final int GL_DEPTH_STENCIL_OES;
    public static final int GL_UNSIGNED_INT_24_8_OES;
    public static final int GL_DEPTH24_STENCIL8_OES;
    public static final int GL_RGB8_OES;
    public static final int GL_RGBA8_OES;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT_OES;
    public static final int GL_STENCIL_INDEX1_OES;
    public static final int GL_STENCIL_INDEX4_OES;
    public static final int GL_TEXTURE_WRAP_R_OES;
    public static final int GL_TEXTURE_3D_OES;
    public static final int GL_TEXTURE_BINDING_3D_OES;
    public static final int GL_MAX_3D_TEXTURE_SIZE_OES;
    public static final int GL_SAMPLER_3D_OES;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_OES;
    public static final int GL_HALF_FLOAT_OES;
    public static final int GL_UNSIGNED_INT_10_10_10_2_OES;
    public static final int GL_INT_10_10_10_2_OES;
    public static final int GL_3DC_X_AMD;
    public static final int GL_3DC_XY_AMD;
    public static final int GL_ATC_RGB_AMD;
    public static final int GL_ATC_RGBA_EXPLICIT_ALPHA_AMD;
    public static final int GL_ATC_RGBA_INTERPOLATED_ALPHA_AMD;
    public static final int GL_COUNTER_TYPE_AMD;
    public static final int GL_COUNTER_RANGE_AMD;
    public static final int GL_UNSIGNED_INT64_AMD;
    public static final int GL_PERCENTAGE_AMD;
    public static final int GL_PERFMON_RESULT_AVAILABLE_AMD;
    public static final int GL_PERFMON_RESULT_SIZE_AMD;
    public static final int GL_PERFMON_RESULT_AMD;
    public static final int GL_Z400_BINARY_AMD;
    public static final int GL_MIN_EXT;
    public static final int GL_MAX_EXT;
    public static final int GL_COLOR_EXT;
    public static final int GL_DEPTH_EXT;
    public static final int GL_STENCIL_EXT;
    public static final int GL_BGRA_EXT;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV_EXT;
    public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV_EXT;
    public static final int GL_TEXTURE_MAX_ANISOTROPY_EXT;
    public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT;
    public static final int GL_UNSIGNED_INT_2_10_10_10_REV_EXT;
    public static final int GL_SGX_PROGRAM_BINARY_IMG;
    public static final int GL_BGRA_IMG;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV_IMG;
    public static final int GL_SGX_BINARY_IMG;
    public static final int GL_COMPRESSED_RGB_PVRTC_4BPPV1_IMG;
    public static final int GL_COMPRESSED_RGB_PVRTC_2BPPV1_IMG;
    public static final int GL_COMPRESSED_RGBA_PVRTC_4BPPV1_IMG;
    public static final int GL_COMPRESSED_RGBA_PVRTC_2BPPV1_IMG;
    public static final int GL_UNPACK_ROW_LENGTH_NV;
    public static final int GL_UNPACK_SKIP_ROWS_NV;
    public static final int GL_UNPACK_SKIP_PIXELS_NV;
    public static final int GL_UNPACK_SKIP_IMAGES_NV;
    public static final int GL_UNPACK_IMAGE_HEIGHT_NV;
    public static final int GL_PACK_ROW_LENGTH_NV;
    public static final int GL_PACK_SKIP_ROWS_NV;
    public static final int GL_PACK_SKIP_PIXELS_NV;
    public static final int GL_PACK_SKIP_IMAGES_NV;
    public static final int GL_PACK_IMAGE_HEIGHT_NV;
    public static final int GL_TEXTURE_WIDTH_QCOM;
    public static final int GL_TEXTURE_HEIGHT_QCOM;
    public static final int GL_TEXTURE_DEPTH_QCOM;
    public static final int GL_TEXTURE_INTERNAL_FORMAT_QCOM;
    public static final int GL_TEXTURE_FORMAT_QCOM;
    public static final int GL_TEXTURE_TYPE_QCOM;
    public static final int GL_TEXTURE_IMAGE_VALID_QCOM;
    public static final int GL_TEXTURE_NUM_LEVELS_QCOM;
    public static final int GL_TEXTURE_TARGET_QCOM;
    public static final int GL_TEXTURE_OBJECT_VALID_QCOM;
    public static final int GL_STATE_RESTORE;
    public static final int GL_PERFMON_GLOBAL_MODE_QCOM;
    public static final int GL_WRITEONLY_RENDERING_QCOM;
    public static final int GL_OES_compressed_ETC1_RGB8_texture;
    public static final int GL_OES_compressed_paletted_texture;
    public static final int GL_OES_depth24;
    public static final int GL_OES_depth32;
    public static final int GL_OES_depth_texture;
    public static final int GL_OES_EGL_image;
    public static final int GL_OES_element_index_uint;
    public static final int GL_OES_fbo_render_mipmap;
    public static final int GL_OES_fragment_precision_high;
    public static final int GL_OES_get_program_binary;
    public static final int GL_OES_mapbuffer;
    public static final int GL_OES_packed_depth_stencil;
    public static final int GL_OES_rgb8_rgba8;
    public static final int GL_OES_standard_derivatives;
    public static final int GL_OES_stencil1;
    public static final int GL_OES_stencil4;
    public static final int GL_OES_texture_3D;
    public static final int GL_OES_texture_float;
    public static final int GL_OES_texture_float_linear;
    public static final int GL_OES_texture_half_float;
    public static final int GL_OES_texture_half_float_linear;
    public static final int GL_OES_texture_npot;
    public static final int GL_OES_vertex_half_float;
    public static final int GL_OES_vertex_type_10_10_10_2;
    public static final int GL_AMD_compressed_3DC_texture;
    public static final int GL_AMD_compressed_ATC_texture;
    public static final int GL_AMD_performance_monitor;
    public static final int GL_AMD_program_binary_Z400;
    public static final int GL_IMG_program_binary;
    public static final int GL_IMG_read_format;
    public static final int GL_IMG_shader_binary;
    public static final int GL_IMG_texture_compression_pvrtc;
    public static final int GL_QCOM_driver_control;
    public static final int GL_QCOM_extended_get;
    public static final int GL_QCOM_extended_get2;
    public static final int GL_QCOM_perfmon_global_mode;
    public static final int GL_QCOM_writeonly_rendering;
    public static final int GL_NVIDIA_PLATFORM_BINARY_NV;
    public static final int GL_CG_VERTEX_SHADER_EXT;
    public static final int GL_CG_FRAGMENT_SHADER_EXT;
    public static final int GL_R11F_G11F_B10F_EXT;
    public static final int GL_UNSIGNED_INT_10F_11F_11F_REV_EXT;
    public static final int GL_RGBA_SIGNED_COMPONENTS_EXT;
    public static final int GL_TEXTURE_2D_ARRAY_EXT;
    public static final int GL_SAMPLER_2D_ARRAY_EXT;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY_EXT;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS_EXT;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT;
    public static final int GL_COMPRESSED_RGB_S3TC_DXT1_EXT;
    public static final int GL_COMPRESSED_RGBA_S3TC_DXT1_EXT;
    public static final int GL_COMPRESSED_LUMINANCE_LATC1_EXT;
    public static final int GL_COMPRESSED_SIGNED_LUMINANCE_LATC1_EXT;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA_LATC2_EXT;
    public static final int GL_COMPRESSED_SIGNED_LUMINANCE_ALPHA_LATC2_EXT;
    public static final int GL_COMPRESSED_RGBA_S3TC_DXT3_EXT;
    public static final int GL_COMPRESSED_RGBA_S3TC_DXT5_EXT;
    public static final int GL_MAX_TEXTURE_LOD_BIAS_EXT;
    public static final int GL_TEXTURE_FILTER_CONTROL_EXT;
    public static final int GL_TEXTURE_LOD_BIAS_EXT;
    public static final int GL_TEXTURE_MIN_LOD_SGIS;
    public static final int GL_TEXTURE_MAX_LOD_SGIS;
    public static final int GL_TEXTURE_BASE_LEVEL_SGIS;
    public static final int GL_TEXTURE_MAX_LEVEL_SGIS;
    public static final int GL_COVERAGE_COMPONENT_NV;
    public static final int GL_COVERAGE_COMPONENT4_NV;
    public static final int GL_COVERAGE_ATTACHMENT_NV;
    public static final int GL_COVERAGE_BUFFERS_NV;
    public static final int GL_COVERAGE_SAMPLES_NV;
    public static final int GL_COVERAGE_ALL_FRAGMENTS_NV;
    public static final int GL_COVERAGE_EDGE_FRAGMENTS_NV;
    public static final int GL_COVERAGE_AUTOMATIC_NV;
    public static final int GL_COVERAGE_BUFFER_BIT_NV;
    public static final int GL_DEPTH_COMPONENT16_NONLINEAR_NV;
    public static final int GL_PATH_QUALITY_NV;
    public static final int GL_FILL_RULE_NV;
    public static final int GL_STROKE_CAP0_STYLE_NV;
    public static final int GL_STROKE_CAP1_STYLE_NV;
    public static final int GL_STROKE_CAP2_STYLE_NV;
    public static final int GL_STROKE_CAP3_STYLE_NV;
    public static final int GL_STROKE_JOIN_STYLE_NV;
    public static final int GL_STROKE_MITER_LIMIT_NV;
    public static final int GL_EVEN_ODD_NV;
    public static final int GL_NON_ZERO_NV;
    public static final int GL_CAP_BUTT_NV;
    public static final int GL_CAP_ROUND_NV;
    public static final int GL_CAP_SQUARE_NV;
    public static final int GL_CAP_TRIANGLE_NV;
    public static final int GL_JOIN_MITER_NV;
    public static final int GL_JOIN_ROUND_NV;
    public static final int GL_JOIN_BEVEL_NV;
    public static final int GL_JOIN_CLIPPED_MITER_NV;
    public static final int GL_MATRIX_PATH_TO_CLIP_NV;
    public static final int GL_MATRIX_STROKE_TO_PATH_NV;
    public static final int GL_MATRIX_PATH_COORD0_NV;
    public static final int GL_MATRIX_PATH_COORD1_NV;
    public static final int GL_MATRIX_PATH_COORD2_NV;
    public static final int GL_MATRIX_PATH_COORD3_NV;
    public static final int GL_FILL_PATH_NV;
    public static final int GL_STROKE_PATH_NV;
    public static final int GL_MOVE_TO_NV;
    public static final int GL_LINE_TO_NV;
    public static final int GL_QUADRATIC_BEZIER_TO_NV;
    public static final int GL_CUBIC_BEZIER_TO_NV;
    public static final int GL_START_MARKER_NV;
    public static final int GL_CLOSE_NV;
    public static final int GL_CLOSE_FILL_NV;
    public static final int GL_STROKE_CAP0_NV;
    public static final int GL_STROKE_CAP1_NV;
    public static final int GL_STROKE_CAP2_NV;
    public static final int GL_STROKE_CAP3_NV;
    public static final int GL_READ_BUFFER_NV;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_NV;
    public static final int GL_TEXTURE_WIDTH_NV;
    public static final int GL_TEXTURE_HEIGHT_NV;
    public static final int GL_TEXTURE_INTERNAL_FORMAT_NV;
    public static final int GL_TEXTURE_COMPONENTS_NV;
    public static final int GL_TEXTURE_BORDER_NV;
    public static final int GL_TEXTURE_RED_SIZE_NV;
    public static final int GL_TEXTURE_GREEN_SIZE_NV;
    public static final int GL_TEXTURE_BLUE_SIZE_NV;
    public static final int GL_TEXTURE_ALPHA_SIZE_NV;
    public static final int GL_TEXTURE_LUMINANCE_SIZE_NV;
    public static final int GL_TEXTURE_INTENSITY_SIZE_NV;
    public static final int GL_TEXTURE_DEPTH_NV;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE_NV;
    public static final int GL_TEXTURE_COMPRESSED_NV;
    public static final int GL_TEXTURE_DEPTH_SIZE_NV;
    public static final int GL_MAX_DRAW_BUFFERS_ARB;
    public static final int GL_DRAW_BUFFER0_ARB;
    public static final int GL_DRAW_BUFFER1_ARB;
    public static final int GL_DRAW_BUFFER2_ARB;
    public static final int GL_DRAW_BUFFER3_ARB;
    public static final int GL_DRAW_BUFFER4_ARB;
    public static final int GL_DRAW_BUFFER5_ARB;
    public static final int GL_DRAW_BUFFER6_ARB;
    public static final int GL_DRAW_BUFFER7_ARB;
    public static final int GL_DRAW_BUFFER8_ARB;
    public static final int GL_DRAW_BUFFER9_ARB;
    public static final int GL_DRAW_BUFFER10_ARB;
    public static final int GL_DRAW_BUFFER11_ARB;
    public static final int GL_DRAW_BUFFER12_ARB;
    public static final int GL_DRAW_BUFFER13_ARB;
    public static final int GL_DRAW_BUFFER14_ARB;
    public static final int GL_DRAW_BUFFER15_ARB;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_NV;
    public static final int GL_FRAMEBUFFER_ATTACHABLE_NV;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_SIZE_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_TYPE_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_NORMALIZED_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_OFFSET_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_WIDTH_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_STRIDE_NV;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_VERTEX_ATTRIB_ARRAY_HEIGHT_NV;
    public static final int GL_MAX_COLOR_ATTACHMENTS_NV;
    public static final int GL_COLOR_ATTACHMENT0_NV;
    public static final int GL_COLOR_ATTACHMENT1_NV;
    public static final int GL_COLOR_ATTACHMENT2_NV;
    public static final int GL_COLOR_ATTACHMENT3_NV;
    public static final int GL_COLOR_ATTACHMENT4_NV;
    public static final int GL_COLOR_ATTACHMENT5_NV;
    public static final int GL_COLOR_ATTACHMENT6_NV;
    public static final int GL_COLOR_ATTACHMENT7_NV;
    public static final int GL_COLOR_ATTACHMENT8_NV;
    public static final int GL_COLOR_ATTACHMENT9_NV;
    public static final int GL_COLOR_ATTACHMENT10_NV;
    public static final int GL_COLOR_ATTACHMENT11_NV;
    public static final int GL_COLOR_ATTACHMENT12_NV;
    public static final int GL_COLOR_ATTACHMENT13_NV;
    public static final int GL_COLOR_ATTACHMENT14_NV;
    public static final int GL_COLOR_ATTACHMENT15_NV;
    public static final int GL_ALL_COMPLETED_NV;
    public static final int GL_FENCE_STATUS_NV;
    public static final int GL_FENCE_CONDITION_NV;
    public static final int GL_PIXEL_UNPACK_BUFFER_ES_NV;
    public static final int GL_PIXEL_PACK_BUFFER_ES_NV;
    public static final int GL_PIXEL_UNPACK_BUFFER_BINDING_ES_NV;
    public static final int GL_PIXEL_PACK_BUFFER_BINDING_ES_NV;
    public static final int GL_HALF_FLOAT_ARB;
    public static final int GL_BGR_EXT;
    public static final int GL_TEXTURE_RECTANGLE_ARB;
    public static final int GL_TEXTURE_BINDING_RECTANGLE_ARB;
    public static final int GL_PROXY_TEXTURE_RECTANGLE_ARB;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE_ARB;
    public static final int GL_SAMPLER_2D_RECT_ARB;
    public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB;
    public static final int GL_RENDERBUFFER_EXT;
    public static final int GL_FRAMEBUFFER_EXT;
    public static final int GL_MAX_RENDERBUFFER_SIZE_EXT;
    public static final int GL_DEPTH_ATTACHMENT_EXT;
    public static final int GL_COLOR_ATTACHMENT0_EXT;
    public static final int GL_STENCIL_ATTACHMENT_EXT;
    public static final int GL_FRAMEBUFFER_COMPLETE_EXT;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED_EXT;

    default public void glActiveTexture(int n) {
    }

    default public void glAttachShader(int n, int n2) {
    }

    default public void glBindAttribLocation(int n, int n2, String string) {
    }

    default public void glBindBuffer(int n, int n2) {
    }

    default public void glBindFramebuffer(int n, int n2) {
    }

    default public void glBindRenderbuffer(int n, int n2) {
    }

    default public void glBindTexture(int n, int n2) {
    }

    default public void glBlendColor(float f2, float f3, float f4, float f5) {
    }

    default public void glBlendEquation(int n) {
    }

    default public void glBlendEquationSeparate(int n, int n2) {
    }

    default public void glBlendFunc(int n, int n2) {
    }

    default public void glBlendFuncSeparate(int n, int n2, int n3, int n4) {
    }

    default public void glBufferData(int n, int n2, Buffer buffer, int n3) {
    }

    default public void glBufferSubData(int n, int n2, int n3, Buffer buffer) {
    }

    default public int glCheckFramebufferStatus(int n) {
    }

    default public void glClear(int n) {
    }

    default public void glClearColor(float f2, float f3, float f4, float f5) {
    }

    default public void glClearDepthf(float f2) {
    }

    default public void glClearStencil(int n) {
    }

    default public void glColorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void glCompileShader(int n) {
    }

    default public void glCompressedTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, Buffer buffer) {
    }

    default public void glCompressedTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
    }

    default public void glCopyTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public void glCopyTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public void glCoverageMaskNV(boolean bl) {
    }

    default public void glCoverageOperationNV(int n) {
    }

    default public int glCreateProgram() {
    }

    default public int glCreateShader(int n) {
    }

    default public void glCullFace(int n) {
    }

    default public void glDeleteBuffers(int n, IntBuffer intBuffer) {
    }

    default public void glDeleteBuffers(int n, int[] nArray, int n2) {
    }

    default public void glDeleteFramebuffers(int n, IntBuffer intBuffer) {
    }

    default public void glDeleteFramebuffers(int n, int[] nArray, int n2) {
    }

    default public void glDeleteProgram(int n) {
    }

    default public void glDeleteRenderbuffers(int n, IntBuffer intBuffer) {
    }

    default public void glDeleteRenderbuffers(int n, int[] nArray, int n2) {
    }

    default public void glDeleteShader(int n) {
    }

    default public void glDeleteTextures(int n, IntBuffer intBuffer) {
    }

    default public void glDeleteTextures(int n, int[] nArray, int n2) {
    }

    default public void glDepthFunc(int n) {
    }

    default public void glDepthMask(boolean bl) {
    }

    default public void glDepthRangef(float f2, float f3) {
    }

    default public void glDetachShader(int n, int n2) {
    }

    default public void glDisable(int n) {
    }

    default public void glDisableVertexAttribArray(int n) {
    }

    default public void glDrawArrays(int n, int n2, int n3) {
    }

    default public void glDrawElements(int n, int n2, int n3, Buffer buffer) {
    }

    default public void glDrawElements(int n, int n2, int n3, long l) {
    }

    default public void glEnable(int n) {
    }

    default public void glEnableVertexAttribArray(int n) {
    }

    default public void glFinish() {
    }

    default public void glFlush() {
    }

    default public void glFramebufferRenderbuffer(int n, int n2, int n3, int n4) {
    }

    default public void glFramebufferTexture2D(int n, int n2, int n3, int n4, int n5) {
    }

    default public void glFrontFace(int n) {
    }

    default public void glGenBuffers(int n, IntBuffer intBuffer) {
    }

    default public void glGenBuffers(int n, int[] nArray, int n2) {
    }

    default public void glGenFramebuffers(int n, IntBuffer intBuffer) {
    }

    default public void glGenFramebuffers(int n, int[] nArray, int n2) {
    }

    default public void glGenRenderbuffers(int n, IntBuffer intBuffer) {
    }

    default public void glGenRenderbuffers(int n, int[] nArray, int n2) {
    }

    default public void glGenTextures(int n, IntBuffer intBuffer) {
    }

    default public void glGenTextures(int n, int[] nArray, int n2) {
    }

    default public void glGenerateMipmap(int n) {
    }

    default public void glGetActiveAttrib(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
    }

    default public void glGetActiveAttrib(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
    }

    default public void glGetActiveUniform(int n, int n2, int n3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
    }

    default public void glGetActiveUniform(int n, int n2, int n3, int[] nArray, int n4, int[] nArray2, int n5, int[] nArray3, int n6, byte[] byArray, int n7) {
    }

    default public void glGetAttachedShaders(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
    }

    default public void glGetAttachedShaders(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4) {
    }

    default public int glGetAttribLocation(int n, String string) {
    }

    default public void glGetBooleanv(int n, ByteBuffer byteBuffer) {
    }

    default public void glGetBooleanv(int n, byte[] byArray, int n2) {
    }

    default public void glGetBufferParameteriv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetBufferParameteriv(int n, int n2, int[] nArray, int n3) {
    }

    default public int glGetError() {
    }

    default public void glGetFloatv(int n, FloatBuffer floatBuffer) {
    }

    default public void glGetFloatv(int n, float[] fArray, int n2) {
    }

    default public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, IntBuffer intBuffer) {
    }

    default public void glGetFramebufferAttachmentParameteriv(int n, int n2, int n3, int[] nArray, int n4) {
    }

    default public void glGetIntegerv(int n, IntBuffer intBuffer) {
    }

    default public void glGetIntegerv(int n, int[] nArray, int n2) {
    }

    default public void glGetProgramInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
    }

    default public void glGetProgramInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
    }

    default public void glGetProgramiv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetProgramiv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glGetRenderbufferParameteriv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetRenderbufferParameteriv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glGetShaderInfoLog(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
    }

    default public void glGetShaderInfoLog(int n, int n2, int[] nArray, int n3, byte[] byArray, int n4) {
    }

    default public void glGetShaderPrecisionFormat(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2) {
    }

    default public void glGetShaderSource(int n, int n2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
    }

    default public void glGetShaderiv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetShaderiv(int n, int n2, int[] nArray, int n3) {
    }

    default public String glGetString(int n) {
    }

    default public void glGetTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glGetTexParameterfv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glGetTexParameteriv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetTexParameteriv(int n, int n2, int[] nArray, int n3) {
    }

    default public int glGetUniformLocation(int n, String string) {
    }

    default public void glGetUniformfv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glGetUniformfv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glGetUniformiv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetUniformiv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glGetVertexAttribfv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glGetVertexAttribfv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glGetVertexAttribiv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetVertexAttribiv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glHint(int n, int n2) {
    }

    default public boolean glIsBuffer(int n) {
    }

    default public boolean glIsEnabled(int n) {
    }

    default public boolean glIsFramebuffer(int n) {
    }

    default public boolean glIsProgram(int n) {
    }

    default public boolean glIsRenderbuffer(int n) {
    }

    default public boolean glIsShader(int n) {
    }

    default public boolean glIsTexture(int n) {
    }

    default public void glLineWidth(float f2) {
    }

    default public void glLinkProgram(int n) {
    }

    default public void glPixelStorei(int n, int n2) {
    }

    default public void glPolygonOffset(float f2, float f3) {
    }

    default public void glReadPixels(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
    }

    default public void glReleaseShaderCompiler() {
    }

    default public void glRenderbufferStorage(int n, int n2, int n3, int n4) {
    }

    default public void glSampleCoverage(float f2, boolean bl) {
    }

    default public void glScissor(int n, int n2, int n3, int n4) {
    }

    default public void glShaderBinary(int n, IntBuffer intBuffer, int n2, Buffer buffer, int n3) {
    }

    default public void glShaderSource(int n, int n2, String[] stringArray, IntBuffer intBuffer) {
    }

    default public void glShaderSource(int n, int n2, String[] stringArray, int[] nArray, int n3) {
    }

    default public void glStencilFunc(int n, int n2, int n3) {
    }

    default public void glStencilFuncSeparate(int n, int n2, int n3, int n4) {
    }

    default public void glStencilMask(int n) {
    }

    default public void glStencilMaskSeparate(int n, int n2) {
    }

    default public void glStencilOp(int n, int n2, int n3) {
    }

    default public void glStencilOpSeparate(int n, int n2, int n3, int n4) {
    }

    default public void glTexImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
    }

    default public void glTexParameterf(int n, int n2, float f2) {
    }

    default public void glTexParameterfv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glTexParameterfv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glTexParameteri(int n, int n2, int n3) {
    }

    default public void glTexParameteriv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glTexParameteriv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glTexSubImage2D(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Buffer buffer) {
    }

    default public void glUniform1f(int n, float f2) {
    }

    default public void glUniform1fv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glUniform1fv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glUniform1i(int n, int n2) {
    }

    default public void glUniform1iv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glUniform1iv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glUniform2f(int n, float f2, float f3) {
    }

    default public void glUniform2fv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glUniform2fv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glUniform2i(int n, int n2, int n3) {
    }

    default public void glUniform2iv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glUniform2iv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glUniform3f(int n, float f2, float f3, float f4) {
    }

    default public void glUniform3fv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glUniform3fv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glUniform3i(int n, int n2, int n3, int n4) {
    }

    default public void glUniform3iv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glUniform3iv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glUniform4f(int n, float f2, float f3, float f4, float f5) {
    }

    default public void glUniform4fv(int n, int n2, FloatBuffer floatBuffer) {
    }

    default public void glUniform4fv(int n, int n2, float[] fArray, int n3) {
    }

    default public void glUniform4i(int n, int n2, int n3, int n4, int n5) {
    }

    default public void glUniform4iv(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glUniform4iv(int n, int n2, int[] nArray, int n3) {
    }

    default public void glUniformMatrix2fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
    }

    default public void glUniformMatrix2fv(int n, int n2, boolean bl, float[] fArray, int n3) {
    }

    default public void glUniformMatrix3fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
    }

    default public void glUniformMatrix3fv(int n, int n2, boolean bl, float[] fArray, int n3) {
    }

    default public void glUniformMatrix4fv(int n, int n2, boolean bl, FloatBuffer floatBuffer) {
    }

    default public void glUniformMatrix4fv(int n, int n2, boolean bl, float[] fArray, int n3) {
    }

    default public void glUseProgram(int n) {
    }

    default public void glValidateProgram(int n) {
    }

    default public void glVertexAttrib1f(int n, float f2) {
    }

    default public void glVertexAttrib1fv(int n, FloatBuffer floatBuffer) {
    }

    default public void glVertexAttrib1fv(int n, float[] fArray, int n2) {
    }

    default public void glVertexAttrib2f(int n, float f2, float f3) {
    }

    default public void glVertexAttrib2fv(int n, FloatBuffer floatBuffer) {
    }

    default public void glVertexAttrib2fv(int n, float[] fArray, int n2) {
    }

    default public void glVertexAttrib3f(int n, float f2, float f3, float f4) {
    }

    default public void glVertexAttrib3fv(int n, FloatBuffer floatBuffer) {
    }

    default public void glVertexAttrib3fv(int n, float[] fArray, int n2) {
    }

    default public void glVertexAttrib4f(int n, float f2, float f3, float f4, float f5) {
    }

    default public void glVertexAttrib4fv(int n, FloatBuffer floatBuffer) {
    }

    default public void glVertexAttrib4fv(int n, float[] fArray, int n2) {
    }

    default public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, Buffer buffer) {
    }

    default public void glVertexAttribPointer(int n, int n2, int n3, boolean bl, int n4, long l) {
    }

    default public void glViewport(int n, int n2, int n3, int n4) {
    }

    default public boolean isFunctionAvailable(String string) {
    }

    default public boolean isExtensionAvailable(String string) {
    }

    default public void setSwapInterval(int n) {
    }

    default public Object getPlatformGLExtensions() {
    }

    default public Object getExtension(String string) {
    }

    default public void glClientActiveTexture(int n) {
    }

    default public void glClipPlane(int n, FloatBuffer floatBuffer) {
    }

    default public void glClipPlane(int n, float[] fArray, int n2) {
    }

    default public void glColor4f(int n, int n2, int n3, int n4) {
    }

    default public void glColorPointer(int n, int n2, int n3, Buffer buffer) {
    }

    default public void glLoadIdentity() {
    }

    default public void glLoadMatrixf(FloatBuffer floatBuffer) {
    }

    default public void glLoadMatrixf(float[] fArray, int n) {
    }

    default public void glMatrixMode(int n) {
    }

    default public void glMultMatrixf(FloatBuffer floatBuffer) {
    }

    default public void glMultMatrixf(float[] fArray, int n) {
    }

    default public void glNormalPointer(int n, int n2, Buffer buffer) {
    }

    default public void glOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
    }

    default public void glPopMatrix() {
    }

    default public void glPushMatrix() {
    }

    default public void glRotatef(float f2, float f3, float f4, float f5) {
    }

    default public void glRotate(double d2, double d3, double d4, double d5) {
    }

    default public void glScalef(float f2, float f3, float f4) {
    }

    default public void glScale(double d2, double d3, double d4) {
    }

    default public void glTexCoordPointer(int n, int n2, int n3, Buffer buffer) {
    }

    default public void glTranslatef(float f2, float f3, float f4) {
    }

    default public void glTranslate(double d2, double d3, double d4) {
    }

    default public void glVertexPointer(int n, int n2, int n3, Buffer buffer) {
    }

    default public void glClearDepth(double d2) {
    }

    default public void glDepthRange(double d2, double d3) {
    }

    default public void glGenRenderbuffersEXT(int n, IntBuffer intBuffer) {
    }

    default public void glGenRenderbuffersEXT(int n, int[] nArray, int n2) {
    }

    default public void glGenFramebuffersEXT(int n, IntBuffer intBuffer) {
    }

    default public void glGenFramebuffersEXT(int n, int[] nArray, int n2) {
    }

    default public void glBindRenderbufferEXT(int n, int n2) {
    }

    default public void glRenderbufferStorageEXT(int n, int n2, int n3, int n4) {
    }

    default public void glBindFramebufferEXT(int n, int n2) {
    }

    default public void glFramebufferRenderbufferEXT(int n, int n2, int n3, int n4) {
    }

    default public void glFramebufferTexture1DEXT(int n, int n2, int n3, int n4, int n5) {
    }

    default public void glFramebufferTexture2DEXT(int n, int n2, int n3, int n4, int n5) {
    }

    default public void glFramebufferTexture3DEXT(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public int glCheckFramebufferStatusEXT(int n) {
    }

    default public void glDeleteRenderbuffersEXT(int n, IntBuffer intBuffer) {
    }

    default public void glDeleteRenderbuffersEXT(int n, int[] nArray, int n2) {
    }

    default public void glDeleteFramebuffersEXT(int n, IntBuffer intBuffer) {
    }

    default public void glDeleteFramebuffersEXT(int n, int[] nArray, int n2) {
    }

    default public void glGetRenderbufferParameterivEXT(int n, int n2, IntBuffer intBuffer) {
    }

    default public void glGetRenderbufferParameterivEXT(int n, int n2, int[] nArray, int n3) {
    }

    default public boolean glIsRenderbufferEXT(int n) {
    }

    default public boolean glIsFramebufferEXT(int n) {
    }

    default public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, IntBuffer intBuffer) {
    }

    default public void glGetFramebufferAttachmentParameterivEXT(int n, int n2, int n3, int[] nArray, int n4) {
    }

    default public void glGenerateMipmapEXT(int n) {
    }
}

