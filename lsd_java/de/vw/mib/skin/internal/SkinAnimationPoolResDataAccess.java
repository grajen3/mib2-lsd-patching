/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin.internal;

import de.vw.mib.hmi.utils.BitArray;

public class SkinAnimationPoolResDataAccess {
    public static final int SIGNATURE;
    private static final int HEADER_ARRAY;
    private static final int EASINGS_KIND_ARRAY;
    private static final int EASINGS_CLASS_ARRAY;
    private static final int EASINGS_DURATION_ARRAY;
    private static final int EASINGS_DELAY_ARRAY;
    private static final int EASINGARRAYS_CONTENT_ARRAY;
    private static final int EASINGARRAYS_ARRAY;
    private static final int VRMETRICS_INT_START_ARRAY;
    private static final int VRMETRICS_INT_FINAL_ARRAY;
    private static final int VRMETRICS_INT_EASING_ARRAY;
    private static final int VRMETRICS_INT_RELATIVE_ARRAY;
    private static final int VRMETRICS_FLOAT_START_ARRAY;
    private static final int VRMETRICS_FLOAT_FINAL_ARRAY;
    private static final int VRMETRICS_FLOAT_EASING_ARRAY;
    private static final int VRMETRICS_FLOAT_RELATIVE_ARRAY;
    private static final int KEYFRAMES_PROPERTIES_TYPE_ARRAY;
    private static final int KEYFRAMES_PROPERTIES_PROPERTYREF_ARRAY;
    private static final int KEYFRAMES_PROPERTIES_VRMETRIC_ARRAY;
    private static final int KEYFRAMES_KEYFRAMEID_ARRAY;
    private static final int KEYFRAMES_PROPERTIES_OFFSET_ARRAY;
    private static final int KEYFRAMES_PROPERTIES_COUNT_ARRAY;
    private static final int KEYFRAMEARRAYS_CONTENT_ARRAY;
    private static final int KEYFRAMEARRAYS_ARRAY;
    private static final int ANIMATIONS_DURATION_ARRAY;
    private static final int ANIMATIONS_LOOPING_ARRAY;
    private static final int ANIMATIONS_KEYFRAMES_ARRAY;
    private static final int ANIMATIONARRAYS_CONTENT_ARRAY;
    private static final int ANIMATIONARRAYS_ARRAY;
    private final Object[] resData;

    public SkinAnimationPoolResDataAccess(Object[] objectArray) {
        this.resData = objectArray;
    }

    public int getHeader_size() {
        return ((int[])this.resData[0]).length;
    }

    public int[] getHeader() {
        return (int[])this.resData[0];
    }

    public int getEasings_size() {
        return ((short[])this.resData[1]).length;
    }

    public short[] getEasings_Kind() {
        return (short[])this.resData[1];
    }

    public short[] getEasings_Class() {
        return (short[])this.resData[2];
    }

    public int[] getEasings_Duration() {
        return (int[])this.resData[3];
    }

    public int[] getEasings_Delay() {
        return (int[])this.resData[4];
    }

    public int getEasingArrays_Content_size() {
        return ((short[])this.resData[5]).length;
    }

    public short[] getEasingArrays_Content() {
        return (short[])this.resData[5];
    }

    public int getEasingArrays_size() {
        return ((short[])this.resData[6]).length;
    }

    public short[] getEasingArrays() {
        return (short[])this.resData[6];
    }

    public int getVRMetrics_int_size() {
        return ((int[])this.resData[7]).length;
    }

    public int[] getVRMetrics_int_Start() {
        return (int[])this.resData[7];
    }

    public int[] getVRMetrics_int_Final() {
        return (int[])this.resData[8];
    }

    public short[] getVRMetrics_int_Easing() {
        return (short[])this.resData[9];
    }

    public BitArray newVRMetrics_int_Relative() {
        return new BitArray((int[])this.resData[10]);
    }

    public int getVRMetrics_float_size() {
        return ((float[])this.resData[11]).length;
    }

    public float[] getVRMetrics_float_Start() {
        return (float[])this.resData[11];
    }

    public float[] getVRMetrics_float_Final() {
        return (float[])this.resData[12];
    }

    public short[] getVRMetrics_float_Easing() {
        return (short[])this.resData[13];
    }

    public BitArray newVRMetrics_float_Relative() {
        return new BitArray((int[])this.resData[14]);
    }

    public int getKeyframes_Properties_size() {
        return ((byte[])this.resData[15]).length;
    }

    public byte[] getKeyframes_Properties_Type() {
        return (byte[])this.resData[15];
    }

    public int[] getKeyframes_Properties_PropertyRef() {
        return (int[])this.resData[16];
    }

    public short[] getKeyframes_Properties_VRMetric() {
        return (short[])this.resData[17];
    }

    public int getKeyframes_size() {
        return ((int[])this.resData[18]).length;
    }

    public int[] getKeyframes_KeyframeId() {
        return (int[])this.resData[18];
    }

    public int[] getKeyframes_Properties_Offset() {
        return (int[])this.resData[19];
    }

    public short[] getKeyframes_Properties_Count() {
        return (short[])this.resData[20];
    }

    public int getKeyframeArrays_Content_size() {
        return ((short[])this.resData[21]).length;
    }

    public short[] getKeyframeArrays_Content() {
        return (short[])this.resData[21];
    }

    public int getKeyframeArrays_size() {
        return ((short[])this.resData[22]).length;
    }

    public short[] getKeyframeArrays() {
        return (short[])this.resData[22];
    }

    public int getAnimations_size() {
        return ((short[])this.resData[23]).length;
    }

    public short[] getAnimations_Duration() {
        return (short[])this.resData[23];
    }

    public BitArray newAnimations_Looping() {
        return new BitArray((int[])this.resData[24]);
    }

    public short[] getAnimations_Keyframes() {
        return (short[])this.resData[25];
    }

    public int getAnimationArrays_Content_size() {
        return ((short[])this.resData[26]).length;
    }

    public short[] getAnimationArrays_Content() {
        return (short[])this.resData[26];
    }

    public int getAnimationArrays_size() {
        return ((short[])this.resData[27]).length;
    }

    public short[] getAnimationArrays() {
        return (short[])this.resData[27];
    }
}

