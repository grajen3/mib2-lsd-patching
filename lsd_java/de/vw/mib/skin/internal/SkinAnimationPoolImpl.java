/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin.internal;

import de.vw.mib.animation.animations.Keyframe;
import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.animations.references.FloatValueReferenceMetric;
import de.vw.mib.animation.animations.references.IntegerValueReferenceMetric;
import de.vw.mib.animation.animations.references.ValueReferenceMetric;
import de.vw.mib.animation.animations.references.WidgetPropertyReference;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.hmi.utils.BitArray;
import de.vw.mib.skin.SkinAnimationPool;
import de.vw.mib.skin.internal.SkinAnimationPoolResDataAccess;

public final class SkinAnimationPoolImpl
implements SkinAnimationPool {
    private static final int VALUE_REFERENCE_METRIC_INT;
    private static final int VALUE_REFERENCE_METRIC_FLOAT;
    private static final int VALUE_REFERENCE_METRIC_TYPECOUNT;
    private EasingParams[] EASING_PARAMS_CACHE = new EasingParams[0];
    private EasingParams[][] EASING_PARAMS_ARRAY_CACHE = new EasingParams[0][];
    private short[] EASING_PARAMS_ARRAY_DATA;
    private short[] EASING_PARAMS_ARRAY_CONTENT;
    private static final int EASING_PARAMS_ARRAY_CONTENT_COUNT;
    private static final int EASING_PARAMS_ARRAY_CONTENT_FIRSTINDEX;
    private final ValueReferenceMetric[][] VALUE_REFERENCE_METRIC_CACHES = new ValueReferenceMetric[2][];
    private Keyframe[] KEYFRAME_CACHE = new Keyframe[0];
    private byte[] KEYFRAME_PROPERTY_TYPE_DATA;
    private int[] KEYFRAME_PROPERTY_PROPERTYREF_DATA;
    private short[] KEYFRAME_PROPERTY_VRMETRIC_DATA;
    private int[] KEYFRAME_ID_DATA;
    private int[] KEYFRAME_PROPERTY_OFFSET_DATA;
    private short[] KEYFRAME_PROPERTY_COUNT_DATA;
    private Keyframe[][] KEYFRAME_ARRAY_CACHE = new Keyframe[0][];
    private short[] KEYFRAME_ARRAY_DATA;
    private short[] KEYFRAME_ARRAY_CONTENT;
    private static final int KEYFRAME_ARRAY_CONTENT_COUNT;
    private static final int KEYFRAME_ARRAY_CONTENT_FIRSTINDEX;
    private KeyframeAnimation[] KEYFRAME_ANIMATION_CACHE;
    private short[] KEYFRAME_ANIMATION_DURATION_DATA;
    private BitArray KEYFRAME_ANIMATION_LOOPING_DATA;
    private short[] KEYFRAME_ANIMATION_KEYFRAMES_DATA;
    private KeyframeAnimation[][] KEYFRAME_ANIMATION_ARRAY_CACHE;
    private short[] KEYFRAME_ANIMATION_ARRAY_DATA;
    private short[] KEYFRAME_ANIMATION_ARRAY_CONTENT;
    private static final int KEYFRAME_ANIMATION_ARRAY_CONTENT_COUNT;
    private static final int KEYFRAME_ANIMATION_ARRAY_CONTENT_FIRSTINDEX;

    protected EasingParams getEasingParams(int n) {
        return this.EASING_PARAMS_CACHE[n];
    }

    @Override
    public EasingParams[] getEasingParamsArray(int n) {
        EasingParams[] easingParamsArray = this.EASING_PARAMS_ARRAY_CACHE[n];
        if (easingParamsArray == null) {
            short s = this.EASING_PARAMS_ARRAY_DATA[n];
            int n2 = this.EASING_PARAMS_ARRAY_CONTENT[s + 0];
            easingParamsArray = new EasingParams[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                short s2 = this.EASING_PARAMS_ARRAY_CONTENT[s + 1 + i2];
                easingParamsArray[i2] = this.getEasingParams(s2);
            }
            this.EASING_PARAMS_ARRAY_CACHE[n] = easingParamsArray;
        }
        return easingParamsArray;
    }

    protected Keyframe getKeyframe(int n) {
        Keyframe keyframe = this.KEYFRAME_CACHE[n];
        if (keyframe == null) {
            int n2 = this.KEYFRAME_ID_DATA[n];
            int n3 = this.KEYFRAME_PROPERTY_OFFSET_DATA[n];
            int n4 = this.KEYFRAME_PROPERTY_COUNT_DATA[n];
            keyframe = new Keyframe(n2);
            for (int i2 = 0; i2 < n4; ++i2) {
                int n5 = n3 + i2;
                byte by = this.KEYFRAME_PROPERTY_TYPE_DATA[n5];
                int n6 = this.KEYFRAME_PROPERTY_PROPERTYREF_DATA[n5];
                short s = this.KEYFRAME_PROPERTY_VRMETRIC_DATA[n5];
                WidgetPropertyReference widgetPropertyReference = new WidgetPropertyReference(n6, by);
                ValueReferenceMetric valueReferenceMetric = this.VALUE_REFERENCE_METRIC_CACHES[by][s];
                keyframe.setProperty(widgetPropertyReference, valueReferenceMetric);
            }
            this.KEYFRAME_CACHE[n] = keyframe;
        }
        return keyframe;
    }

    protected Keyframe[] getKeyframeArray(int n) {
        Keyframe[] keyframeArray = this.KEYFRAME_ARRAY_CACHE[n];
        if (keyframeArray == null) {
            short s = this.KEYFRAME_ARRAY_DATA[n];
            int n2 = this.KEYFRAME_ARRAY_CONTENT[s + 0];
            keyframeArray = new Keyframe[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                short s2 = this.KEYFRAME_ARRAY_CONTENT[s + 1 + i2];
                keyframeArray[i2] = this.getKeyframe(s2);
            }
            this.KEYFRAME_ARRAY_CACHE[n] = keyframeArray;
        }
        return keyframeArray;
    }

    protected KeyframeAnimation getAnimation(int n) {
        KeyframeAnimation keyframeAnimation = this.KEYFRAME_ANIMATION_CACHE[n];
        if (keyframeAnimation == null) {
            short s = this.KEYFRAME_ANIMATION_DURATION_DATA[n];
            boolean bl = this.KEYFRAME_ANIMATION_LOOPING_DATA.get(n);
            short s2 = this.KEYFRAME_ANIMATION_KEYFRAMES_DATA[n];
            this.KEYFRAME_ANIMATION_CACHE[n] = keyframeAnimation = new KeyframeAnimation(this.getKeyframeArray(s2), s, bl);
        }
        return keyframeAnimation;
    }

    @Override
    public KeyframeAnimation[] getKeyframeAnimationArray(int n) {
        KeyframeAnimation[] keyframeAnimationArray = this.KEYFRAME_ANIMATION_ARRAY_CACHE[n];
        if (keyframeAnimationArray == null) {
            short s = this.KEYFRAME_ANIMATION_ARRAY_DATA[n];
            int n2 = this.KEYFRAME_ANIMATION_ARRAY_CONTENT[s + 0];
            keyframeAnimationArray = new KeyframeAnimation[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                short s2 = this.KEYFRAME_ANIMATION_ARRAY_CONTENT[s + 1 + i2];
                keyframeAnimationArray[i2] = this.getAnimation(s2);
            }
            this.KEYFRAME_ANIMATION_ARRAY_CACHE[n] = keyframeAnimationArray;
        }
        return keyframeAnimationArray;
    }

    void updateData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.updateEasingData(skinAnimationPoolResDataAccess);
        this.updateEasingArrayData(skinAnimationPoolResDataAccess);
        this.updateVRMetricIntData(skinAnimationPoolResDataAccess);
        this.updateVRMetricFloatData(skinAnimationPoolResDataAccess);
        this.updateKeyframePropertyData(skinAnimationPoolResDataAccess);
        this.updateKeyframeData(skinAnimationPoolResDataAccess);
        this.updateKeyframeArrayData(skinAnimationPoolResDataAccess);
        this.updateAnimationData(skinAnimationPoolResDataAccess);
        this.updateAnimationArrayData(skinAnimationPoolResDataAccess);
    }

    private void updateEasingData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        int n = skinAnimationPoolResDataAccess.getEasings_size();
        this.EASING_PARAMS_CACHE = new EasingParams[n];
        short[] sArray = skinAnimationPoolResDataAccess.getEasings_Kind();
        short[] sArray2 = skinAnimationPoolResDataAccess.getEasings_Class();
        int[] nArray = skinAnimationPoolResDataAccess.getEasings_Duration();
        int[] nArray2 = skinAnimationPoolResDataAccess.getEasings_Delay();
        for (int i2 = 0; i2 < n; ++i2) {
            this.EASING_PARAMS_CACHE[i2] = new EasingParams(sArray[i2], sArray2[i2], nArray[i2], nArray2[i2]);
        }
    }

    private void updateEasingArrayData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.EASING_PARAMS_ARRAY_DATA = skinAnimationPoolResDataAccess.getEasingArrays();
        this.EASING_PARAMS_ARRAY_CONTENT = skinAnimationPoolResDataAccess.getEasingArrays_Content();
        this.EASING_PARAMS_ARRAY_CACHE = new EasingParams[this.EASING_PARAMS_ARRAY_DATA.length][];
    }

    private void updateVRMetricIntData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        int n = skinAnimationPoolResDataAccess.getVRMetrics_int_size();
        IntegerValueReferenceMetric[] integerValueReferenceMetricArray = new IntegerValueReferenceMetric[n];
        short[] sArray = skinAnimationPoolResDataAccess.getVRMetrics_int_Easing();
        int[] nArray = skinAnimationPoolResDataAccess.getVRMetrics_int_Start();
        int[] nArray2 = skinAnimationPoolResDataAccess.getVRMetrics_int_Final();
        BitArray bitArray = skinAnimationPoolResDataAccess.newVRMetrics_int_Relative();
        for (int i2 = 0; i2 < n; ++i2) {
            EasingParams easingParams = this.getEasingParams(sArray[i2]);
            integerValueReferenceMetricArray[i2] = new IntegerValueReferenceMetric(nArray[i2], nArray2[i2], easingParams, bitArray.get(i2));
        }
        this.VALUE_REFERENCE_METRIC_CACHES[0] = integerValueReferenceMetricArray;
    }

    private void updateVRMetricFloatData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        int n = skinAnimationPoolResDataAccess.getVRMetrics_float_size();
        FloatValueReferenceMetric[] floatValueReferenceMetricArray = new FloatValueReferenceMetric[n];
        short[] sArray = skinAnimationPoolResDataAccess.getVRMetrics_float_Easing();
        float[] fArray = skinAnimationPoolResDataAccess.getVRMetrics_float_Start();
        float[] fArray2 = skinAnimationPoolResDataAccess.getVRMetrics_float_Final();
        BitArray bitArray = skinAnimationPoolResDataAccess.newVRMetrics_float_Relative();
        for (int i2 = 0; i2 < n; ++i2) {
            EasingParams easingParams = this.getEasingParams(sArray[i2]);
            floatValueReferenceMetricArray[i2] = new FloatValueReferenceMetric(fArray[i2], fArray2[i2], easingParams, bitArray.get(i2));
        }
        this.VALUE_REFERENCE_METRIC_CACHES[1] = floatValueReferenceMetricArray;
    }

    private void updateKeyframePropertyData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.KEYFRAME_PROPERTY_TYPE_DATA = skinAnimationPoolResDataAccess.getKeyframes_Properties_Type();
        this.KEYFRAME_PROPERTY_PROPERTYREF_DATA = skinAnimationPoolResDataAccess.getKeyframes_Properties_PropertyRef();
        this.KEYFRAME_PROPERTY_VRMETRIC_DATA = skinAnimationPoolResDataAccess.getKeyframes_Properties_VRMetric();
    }

    private void updateKeyframeData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.KEYFRAME_ID_DATA = skinAnimationPoolResDataAccess.getKeyframes_KeyframeId();
        this.KEYFRAME_PROPERTY_OFFSET_DATA = skinAnimationPoolResDataAccess.getKeyframes_Properties_Offset();
        this.KEYFRAME_PROPERTY_COUNT_DATA = skinAnimationPoolResDataAccess.getKeyframes_Properties_Count();
        this.KEYFRAME_CACHE = new Keyframe[this.KEYFRAME_ID_DATA.length];
    }

    private void updateKeyframeArrayData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.KEYFRAME_ARRAY_DATA = skinAnimationPoolResDataAccess.getKeyframeArrays();
        this.KEYFRAME_ARRAY_CONTENT = skinAnimationPoolResDataAccess.getKeyframeArrays_Content();
        this.KEYFRAME_ARRAY_CACHE = new Keyframe[this.KEYFRAME_ARRAY_DATA.length][];
    }

    private void updateAnimationData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.KEYFRAME_ANIMATION_DURATION_DATA = skinAnimationPoolResDataAccess.getAnimations_Duration();
        this.KEYFRAME_ANIMATION_LOOPING_DATA = skinAnimationPoolResDataAccess.newAnimations_Looping();
        this.KEYFRAME_ANIMATION_KEYFRAMES_DATA = skinAnimationPoolResDataAccess.getAnimations_Keyframes();
        this.KEYFRAME_ANIMATION_CACHE = new KeyframeAnimation[this.KEYFRAME_ANIMATION_KEYFRAMES_DATA.length];
    }

    private void updateAnimationArrayData(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.KEYFRAME_ANIMATION_ARRAY_DATA = skinAnimationPoolResDataAccess.getAnimationArrays();
        this.KEYFRAME_ANIMATION_ARRAY_CONTENT = skinAnimationPoolResDataAccess.getAnimationArrays_Content();
        this.KEYFRAME_ANIMATION_ARRAY_CACHE = new KeyframeAnimation[this.KEYFRAME_ANIMATION_ARRAY_DATA.length][];
    }
}

