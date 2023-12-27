/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import de.eso.mib.FontControlBox;
import de.eso.mib.FontGlyphInfo;
import de.eso.mib.FontMetricsInfo;
import de.eso.mib.ImageHeaderInfo;
import de.eso.mib.ImageInfo;
import de.eso.mib.SGlyphMetric;
import de.eso.mib.SLineMetric;
import de.eso.mib.STextMetric;
import de.eso.mib.StateInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Map;

public class SPI {
    public static void buffer_free(Buffer buffer) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new RuntimeException("Argument \"buffer\" was not a direct buffer");
        }
        SPI.buffer_free0(buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private static native void buffer_free0(Object object, int n) {
    }

    public static ByteBuffer custom_allocate(int n) {
        ByteBuffer byteBuffer = SPI.custom_allocate0(n);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer custom_allocate0(int n) {
    }

    public static void custom_free(Buffer buffer) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new RuntimeException("Argument \"data\" was not a direct buffer");
        }
        SPI.custom_free0(buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private static native void custom_free0(Object object, int n) {
    }

    public static native void debug_activate_logsink(int n) {
    }

    public static native void debug_deactivate_logsink(int n) {
    }

    public static void debug_write_log_entry(short s, Buffer buffer, int n) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new RuntimeException("Argument \"buf\" was not a direct buffer");
        }
        SPI.debug_write_log_entry0(s, buffer, BufferFactory.getDirectBufferByteOffset(buffer), n);
    }

    private static native void debug_write_log_entry0(short s, Object object, int n, int n2) {
    }

    public static void dosthi(IntBuffer intBuffer) {
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new RuntimeException("Argument \"i\" was not a direct buffer");
        }
        SPI.dosthi0(intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
    }

    private static native void dosthi0(Object object, int n) {
    }

    public static void dosthv(Buffer buffer) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new RuntimeException("Argument \"v\" was not a direct buffer");
        }
        SPI.dosthv0(buffer, BufferFactory.getDirectBufferByteOffset(buffer));
    }

    private static native void dosthv0(Object object, int n) {
    }

    public static native int font_close(int n) {
    }

    public static int font_get_ascender(int n, int n2, StateInfo stateInfo) {
        return SPI.font_get_ascender0(n, n2, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native int font_get_ascender0(int n, int n2, ByteBuffer byteBuffer) {
    }

    public static void font_get_control_box(int n, int n2, int n3, FontControlBox fontControlBox) {
        SPI.font_get_control_box0(n, n2, n3, fontControlBox == null ? null : fontControlBox.getBuffer());
    }

    private static native void font_get_control_box0(int n, int n2, int n3, ByteBuffer byteBuffer) {
    }

    public static int font_get_descender(int n, int n2, StateInfo stateInfo) {
        return SPI.font_get_descender0(n, n2, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native int font_get_descender0(int n, int n2, ByteBuffer byteBuffer) {
    }

    public static String font_get_family_name(int n, StateInfo stateInfo) {
        return SPI.font_get_family_name0(n, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native String font_get_family_name0(int n, ByteBuffer byteBuffer) {
    }

    public static ByteBuffer font_get_glyph(int n, int n2, int n3, int n4, FontGlyphInfo fontGlyphInfo, int n5) {
        ByteBuffer byteBuffer = SPI.font_get_glyph0(n, n2, n3, n4, fontGlyphInfo == null ? null : fontGlyphInfo.getBuffer(), n5);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer font_get_glyph0(int n, int n2, int n3, int n4, ByteBuffer byteBuffer, int n5) {
    }

    public static int font_get_height(int n, int n2, StateInfo stateInfo) {
        return SPI.font_get_height0(n, n2, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native int font_get_height0(int n, int n2, ByteBuffer byteBuffer) {
    }

    public static int font_get_kerning(int n, int n2, int n3, int n4, StateInfo stateInfo) {
        return SPI.font_get_kerning0(n, n2, n3, n4, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native int font_get_kerning0(int n, int n2, int n3, int n4, ByteBuffer byteBuffer) {
    }

    public static SGlyphMetric[] font_get_layout_line_content(int n, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        ByteBuffer byteBuffer = bl ? SPI.font_get_layout_line_content0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer)) : SPI.font_get_layout_line_content1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        SGlyphMetric[] sGlyphMetricArray = new SGlyphMetric[SPI.getFirstElement(intBuffer)];
        for (int i2 = 0; i2 < SPI.getFirstElement(intBuffer); ++i2) {
            byteBuffer.position(i2 * SGlyphMetric.size());
            byteBuffer.limit((1 + i2) * SGlyphMetric.size());
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            byteBuffer2.order(ByteOrder.nativeOrder());
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            sGlyphMetricArray[i2] = SGlyphMetric.create(byteBuffer2);
        }
        return sGlyphMetricArray;
    }

    private static native ByteBuffer font_get_layout_line_content0(int n, Object object, int n2) {
    }

    private static native ByteBuffer font_get_layout_line_content1(int n, Object object, int n2) {
    }

    public static SGlyphMetric[] font_get_layout_line_content(int n, int[] nArray, int n2) {
        if (nArray != null && nArray.length <= n2) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"numGlyphLayouts_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        ByteBuffer byteBuffer = SPI.font_get_layout_line_content1(n, nArray, 4 * n2);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        SGlyphMetric[] sGlyphMetricArray = new SGlyphMetric[SPI.getFirstElement(nArray, n2)];
        for (int i2 = 0; i2 < SPI.getFirstElement(nArray, n2); ++i2) {
            byteBuffer.position(i2 * SGlyphMetric.size());
            byteBuffer.limit((1 + i2) * SGlyphMetric.size());
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            byteBuffer2.order(ByteOrder.nativeOrder());
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            sGlyphMetricArray[i2] = SGlyphMetric.create(byteBuffer2);
        }
        return sGlyphMetricArray;
    }

    public static int font_get_max_advance_width(int n, int n2, StateInfo stateInfo) {
        return SPI.font_get_max_advance_width0(n, n2, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native int font_get_max_advance_width0(int n, int n2, ByteBuffer byteBuffer) {
    }

    public static void font_get_metrics(int n, int n2, int n3, FontMetricsInfo fontMetricsInfo) {
        SPI.font_get_metrics0(n, n2, n3, fontMetricsInfo == null ? null : fontMetricsInfo.getBuffer());
    }

    private static native void font_get_metrics0(int n, int n2, int n3, ByteBuffer byteBuffer) {
    }

    public static String font_get_style_name(int n, StateInfo stateInfo) {
        return SPI.font_get_style_name0(n, stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native String font_get_style_name0(int n, ByteBuffer byteBuffer) {
    }

    public static native int font_is_glyph_available(int n, int n2) {
    }

    public static native int font_open(int n, String string) {
    }

    public static SLineMetric[] font_perform_text_layout(int n, int n2, int n3, int n4, int n5, int n6, int n7, String string, int n8, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, IntBuffer intBuffer6, IntBuffer intBuffer7, IntBuffer intBuffer8, STextMetric sTextMetric, IntBuffer intBuffer9) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new RuntimeException("Argument \"alignment\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new RuntimeException("Argument \"linebreakmodel\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer4 != null && bl != BufferFactory.isDirect(intBuffer4)) {
            throw new RuntimeException("Argument \"startindex\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer5 != null && bl != BufferFactory.isDirect(intBuffer5)) {
            throw new RuntimeException("Argument \"endindex\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer6 != null && bl != BufferFactory.isDirect(intBuffer6)) {
            throw new RuntimeException("Argument \"fontid\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer7 != null && bl != BufferFactory.isDirect(intBuffer7)) {
            throw new RuntimeException("Argument \"fontsize\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer8 != null && bl != BufferFactory.isDirect(intBuffer8)) {
            throw new RuntimeException("Argument \"style\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer9 != null && bl != BufferFactory.isDirect(intBuffer9)) {
            throw new RuntimeException("Argument \"numTextLineLayouts\" : Buffers passed to this method must all be either direct or indirect");
        }
        ByteBuffer byteBuffer = bl ? SPI.font_perform_text_layout0(n, n2, n3, n4, n5, n6, n7, string, n8, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3), intBuffer4, BufferFactory.getDirectBufferByteOffset(intBuffer4), intBuffer5, BufferFactory.getDirectBufferByteOffset(intBuffer5), intBuffer6, BufferFactory.getDirectBufferByteOffset(intBuffer6), intBuffer7, BufferFactory.getDirectBufferByteOffset(intBuffer7), intBuffer8, BufferFactory.getDirectBufferByteOffset(intBuffer8), sTextMetric == null ? null : sTextMetric.getBuffer(), intBuffer9, BufferFactory.getDirectBufferByteOffset(intBuffer9)) : SPI.font_perform_text_layout1(n, n2, n3, n4, n5, n6, n7, string, n8, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3), BufferFactory.getArray(intBuffer4), BufferFactory.getIndirectBufferByteOffset(intBuffer4), BufferFactory.getArray(intBuffer5), BufferFactory.getIndirectBufferByteOffset(intBuffer5), BufferFactory.getArray(intBuffer6), BufferFactory.getIndirectBufferByteOffset(intBuffer6), BufferFactory.getArray(intBuffer7), BufferFactory.getIndirectBufferByteOffset(intBuffer7), BufferFactory.getArray(intBuffer8), BufferFactory.getIndirectBufferByteOffset(intBuffer8), sTextMetric == null ? null : sTextMetric.getBuffer(), BufferFactory.getArray(intBuffer9), BufferFactory.getIndirectBufferByteOffset(intBuffer9));
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        SLineMetric[] sLineMetricArray = new SLineMetric[SPI.getFirstElement(intBuffer9)];
        for (int i2 = 0; i2 < SPI.getFirstElement(intBuffer9); ++i2) {
            byteBuffer.position(i2 * SLineMetric.size());
            byteBuffer.limit((1 + i2) * SLineMetric.size());
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            byteBuffer2.order(ByteOrder.nativeOrder());
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            sLineMetricArray[i2] = SLineMetric.create(byteBuffer2);
        }
        return sLineMetricArray;
    }

    private static native ByteBuffer font_perform_text_layout0(int n, int n2, int n3, int n4, int n5, int n6, int n7, String string, int n8, Object object, int n9, Object object2, int n10, Object object3, int n11, Object object4, int n12, Object object5, int n13, Object object6, int n14, Object object7, int n15, Object object8, int n16, ByteBuffer byteBuffer, Object object9, int n17) {
    }

    private static native ByteBuffer font_perform_text_layout1(int n, int n2, int n3, int n4, int n5, int n6, int n7, String string, int n8, Object object, int n9, Object object2, int n10, Object object3, int n11, Object object4, int n12, Object object5, int n13, Object object6, int n14, Object object7, int n15, Object object8, int n16, ByteBuffer byteBuffer, Object object9, int n17) {
    }

    public static SLineMetric[] font_perform_text_layout(int n, int n2, int n3, int n4, int n5, int n6, int n7, String string, int n8, int[] nArray, int n9, int[] nArray2, int n10, int[] nArray3, int n11, int[] nArray4, int n12, int[] nArray5, int n13, int[] nArray6, int n14, int[] nArray7, int n15, int[] nArray8, int n16, STextMetric sTextMetric, int[] nArray9, int n17) {
        if (nArray != null && nArray.length <= n9) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"linespacing_offset\" (").append(n9).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n10) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"alignment_offset\" (").append(n10).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n11) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"linebreakmodel_offset\" (").append(n11).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        if (nArray4 != null && nArray4.length <= n12) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"startindex_offset\" (").append(n12).append(") equals or exceeds array length (").append(nArray4.length).append(")").toString());
        }
        if (nArray5 != null && nArray5.length <= n13) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"endindex_offset\" (").append(n13).append(") equals or exceeds array length (").append(nArray5.length).append(")").toString());
        }
        if (nArray6 != null && nArray6.length <= n14) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"fontid_offset\" (").append(n14).append(") equals or exceeds array length (").append(nArray6.length).append(")").toString());
        }
        if (nArray7 != null && nArray7.length <= n15) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"fontsize_offset\" (").append(n15).append(") equals or exceeds array length (").append(nArray7.length).append(")").toString());
        }
        if (nArray8 != null && nArray8.length <= n16) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"style_offset\" (").append(n16).append(") equals or exceeds array length (").append(nArray8.length).append(")").toString());
        }
        if (nArray9 != null && nArray9.length <= n17) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"numTextLineLayouts_offset\" (").append(n17).append(") equals or exceeds array length (").append(nArray9.length).append(")").toString());
        }
        ByteBuffer byteBuffer = SPI.font_perform_text_layout1(n, n2, n3, n4, n5, n6, n7, string, n8, nArray, 4 * n9, nArray2, 4 * n10, nArray3, 4 * n11, nArray4, 4 * n12, nArray5, 4 * n13, nArray6, 4 * n14, nArray7, 4 * n15, nArray8, 4 * n16, sTextMetric == null ? null : sTextMetric.getBuffer(), nArray9, 4 * n17);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        SLineMetric[] sLineMetricArray = new SLineMetric[SPI.getFirstElement(nArray9, n17)];
        for (int i2 = 0; i2 < SPI.getFirstElement(nArray9, n17); ++i2) {
            byteBuffer.position(i2 * SLineMetric.size());
            byteBuffer.limit((1 + i2) * SLineMetric.size());
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            byteBuffer2.order(ByteOrder.nativeOrder());
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            sLineMetricArray[i2] = SLineMetric.create(byteBuffer2);
        }
        return sLineMetricArray;
    }

    public static native void font_release_layout() {
    }

    public static ByteBuffer getDisplayContent(int n, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new RuntimeException("Argument \"height\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new RuntimeException("Argument \"size_of_returned_data\" : Buffers passed to this method must all be either direct or indirect");
        }
        ByteBuffer byteBuffer = bl ? SPI.getDisplayContent0(n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3)) : SPI.getDisplayContent1(n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3));
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer getDisplayContent0(int n, Object object, int n2, Object object2, int n3, Object object3, int n4) {
    }

    private static native ByteBuffer getDisplayContent1(int n, Object object, int n2, Object object2, int n3, Object object3, int n4) {
    }

    public static ByteBuffer getDisplayContent(int n, int[] nArray, int n2, int[] nArray2, int n3, int[] nArray3, int n4) {
        if (nArray != null && nArray.length <= n2) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"width_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n3) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"height_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n4) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"size_of_returned_data_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        ByteBuffer byteBuffer = SPI.getDisplayContent1(n, nArray, 4 * n2, nArray2, 4 * n3, nArray3, 4 * n4);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static ByteBuffer getDisplayableContent(int n, int n2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new RuntimeException("Argument \"height\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new RuntimeException("Argument \"size_of_returned_data\" : Buffers passed to this method must all be either direct or indirect");
        }
        ByteBuffer byteBuffer = bl ? SPI.getDisplayableContent0(n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3)) : SPI.getDisplayableContent1(n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3));
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer getDisplayableContent0(int n, int n2, Object object, int n3, Object object2, int n4, Object object3, int n5) {
    }

    private static native ByteBuffer getDisplayableContent1(int n, int n2, Object object, int n3, Object object2, int n4, Object object3, int n5) {
    }

    public static ByteBuffer getDisplayableContent(int n, int n2, int[] nArray, int n3, int[] nArray2, int n4, int[] nArray3, int n5) {
        if (nArray != null && nArray.length <= n3) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"width_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n4) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"height_offset\" (").append(n4).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n5) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"size_of_returned_data_offset\" (").append(n5).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        ByteBuffer byteBuffer = SPI.getDisplayableContent1(n, n2, nArray, 4 * n3, nArray2, 4 * n4, nArray3, 4 * n5);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static ByteBuffer getDisplayableContentP(int n, int n2, int n3, int n4, int n5, int n6, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (intBuffer2 != null && bl != BufferFactory.isDirect(intBuffer2)) {
            throw new RuntimeException("Argument \"height\" : Buffers passed to this method must all be either direct or indirect");
        }
        if (intBuffer3 != null && bl != BufferFactory.isDirect(intBuffer3)) {
            throw new RuntimeException("Argument \"size_of_returned_data\" : Buffers passed to this method must all be either direct or indirect");
        }
        ByteBuffer byteBuffer = bl ? SPI.getDisplayableContentP0(n, n2, n3, n4, n5, n6, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer), intBuffer2, BufferFactory.getDirectBufferByteOffset(intBuffer2), intBuffer3, BufferFactory.getDirectBufferByteOffset(intBuffer3)) : SPI.getDisplayableContentP1(n, n2, n3, n4, n5, n6, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer), BufferFactory.getArray(intBuffer2), BufferFactory.getIndirectBufferByteOffset(intBuffer2), BufferFactory.getArray(intBuffer3), BufferFactory.getIndirectBufferByteOffset(intBuffer3));
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer getDisplayableContentP0(int n, int n2, int n3, int n4, int n5, int n6, Object object, int n7, Object object2, int n8, Object object3, int n9) {
    }

    private static native ByteBuffer getDisplayableContentP1(int n, int n2, int n3, int n4, int n5, int n6, Object object, int n7, Object object2, int n8, Object object3, int n9) {
    }

    public static ByteBuffer getDisplayableContentP(int n, int n2, int n3, int n4, int n5, int n6, int[] nArray, int n7, int[] nArray2, int n8, int[] nArray3, int n9) {
        if (nArray != null && nArray.length <= n7) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"width_offset\" (").append(n7).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        if (nArray2 != null && nArray2.length <= n8) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"height_offset\" (").append(n8).append(") equals or exceeds array length (").append(nArray2.length).append(")").toString());
        }
        if (nArray3 != null && nArray3.length <= n9) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"size_of_returned_data_offset\" (").append(n9).append(") equals or exceeds array length (").append(nArray3.length).append(")").toString());
        }
        ByteBuffer byteBuffer = SPI.getDisplayableContentP1(n, n2, n3, n4, n5, n6, nArray, 4 * n7, nArray2, 4 * n8, nArray3, 4 * n9);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static void image_header_get(String string, ImageHeaderInfo imageHeaderInfo) {
        SPI.image_header_get0(string, imageHeaderInfo == null ? null : imageHeaderInfo.getBuffer());
    }

    private static native void image_header_get0(String string, ByteBuffer byteBuffer) {
    }

    public static void image_header_get_from_id(int n, ImageHeaderInfo imageHeaderInfo) {
        SPI.image_header_get_from_id0(n, imageHeaderInfo == null ? null : imageHeaderInfo.getBuffer());
    }

    private static native void image_header_get_from_id0(int n, ByteBuffer byteBuffer) {
    }

    public static ByteBuffer image_load_from_id(int n, ImageInfo imageInfo) {
        ByteBuffer byteBuffer = SPI.image_load_from_id0(n, imageInfo == null ? null : imageInfo.getBuffer());
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer image_load_from_id0(int n, ByteBuffer byteBuffer) {
    }

    public static native void image_save_threadid() {
    }

    public static void image_save_to_file(String string, int n, int n2, int n3, int n4, Buffer buffer, StateInfo stateInfo) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new RuntimeException("Argument \"data\" was not a direct buffer");
        }
        SPI.image_save_to_file0(string, n, n2, n3, n4, buffer, BufferFactory.getDirectBufferByteOffset(buffer), stateInfo == null ? null : stateInfo.getBuffer());
    }

    private static native void image_save_to_file0(String string, int n, int n2, int n3, int n4, Object object, int n5, ByteBuffer byteBuffer) {
    }

    public static native void image_set_nlbl_dims(int n) {
    }

    public static ByteBuffer image_thumbnail_load(String string, ImageInfo imageInfo) {
        ByteBuffer byteBuffer = SPI.image_thumbnail_load0(string, imageInfo == null ? null : imageInfo.getBuffer());
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer image_thumbnail_load0(String string, ByteBuffer byteBuffer) {
    }

    public static native void imagespi_deinit() {
    }

    public static native void imagespi_init() {
    }

    public static native int initDisplaySPI() {
    }

    public static native void init_native() {
    }

    public static void os_log_event_buf(int n, Buffer buffer, int n2) {
        if (!BufferFactory.isDirect(buffer)) {
            throw new RuntimeException("Argument \"data\" was not a direct buffer");
        }
        SPI.os_log_event_buf0(n, buffer, BufferFactory.getDirectBufferByteOffset(buffer), n2);
    }

    private static native void os_log_event_buf0(int n, Object object, int n2, int n3) {
    }

    public static native void os_log_event_str(int n, String string) {
    }

    public static float process_data(FloatBuffer floatBuffer, int n) {
        if (!BufferFactory.isDirect(floatBuffer)) {
            throw new RuntimeException("Argument \"data\" was not a direct buffer");
        }
        return SPI.process_data0(floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer), n);
    }

    private static native float process_data0(Object object, int n, int n2) {
    }

    public static native float process_global_data(int n) {
    }

    public static void set_global_data(FloatBuffer floatBuffer) {
        if (!BufferFactory.isDirect(floatBuffer)) {
            throw new RuntimeException("Argument \"data\" was not a direct buffer");
        }
        SPI.set_global_data0(floatBuffer, BufferFactory.getDirectBufferByteOffset(floatBuffer));
    }

    private static native void set_global_data0(Object object, int n) {
    }

    public static native long timer_get_ticks() {
    }

    public static native long timer_get_ticks_per_second() {
    }

    public static native void uninit_native() {
    }

    private static int getFirstElement(IntBuffer intBuffer) {
        if (intBuffer == null) {
            return 0;
        }
        return intBuffer.get(intBuffer.position());
    }

    private static int getFirstElement(int[] nArray, int n) {
        if (nArray == null) {
            return 0;
        }
        return nArray[n];
    }

    public static void exif_data_get(String string, Map map, StateInfo stateInfo, int n, int[] nArray) {
        SPI.exif_data_get0(string, map, stateInfo == null ? null : stateInfo.getBuffer(), n, nArray);
    }

    private static native void exif_data_get0(String string, Object object, ByteBuffer byteBuffer, int n, Object object2) {
    }

    public static ByteBuffer image_load(String string, int n, ImageInfo imageInfo, Object object) {
        ByteBuffer byteBuffer = SPI.image_load0(string, n, imageInfo == null ? null : imageInfo.getBuffer(), object);
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer image_load0(String string, int n, ByteBuffer byteBuffer, Object object) {
    }
}

