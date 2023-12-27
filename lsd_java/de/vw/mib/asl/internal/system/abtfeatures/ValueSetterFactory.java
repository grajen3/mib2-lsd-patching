/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.BooleanSetter;
import de.vw.mib.asl.internal.system.abtfeatures.IntegerSetter;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$1;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$10;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$11;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$12;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$13;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$2;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$3;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$4;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$5;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$6;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$7;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$8;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory$9;
import de.vw.mib.asl.internal.system.util.IntStringMap;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class ValueSetterFactory {
    static final short FEATURE_ID_PROXIMITY_SENSOR;
    static final short FEATURE_ID_HAND_WRITING_RECOGNITION;
    static final short FEATURE_ID_HAPTIC_FEEDBACK;
    static final short FEATURE_ID_DISPLAY_RESOLUTION_X;
    static final short FEATURE_ID_DISPLAY_RESOLUTION_Y;
    static final short FEATURE_ID_ABT_TYPE;
    static final short FEATURE_ID_DISPLAY_SHAPE;
    static final short FEATURE_ID_NUMBE_OF_HARD_KEYS;
    static final short FEATURE_ID_BUTTON_TECHNOLOGY;
    static final short FEATURE_ID_ROTARY_ENCODER_TYPE;
    static final short FEATURE_ID_TOUCH_CONTROLLER;
    static final short FEATURE_ID_TOUCH_MULTIPLICATOR_X;
    static final short FEATURE_ID_TOUCH_MULTIPLICATOR_Y;
    static final IntStringMap FEATURE_ID_TO_STRING_MAP;
    private final AbtFeatures abtFeatures;

    public ValueSetterFactory(AbtFeatures abtFeatures) {
        this.abtFeatures = abtFeatures;
    }

    public IntObjectMap createValueSetterMappings() {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        intObjectOptHashMap.put(1, this.createProximitySensorSetter());
        intObjectOptHashMap.put(4, this.createHandWritingRecognitionSetter());
        intObjectOptHashMap.put(5, this.createHapticFeedbackSetter());
        intObjectOptHashMap.put(6, this.createDisplayResolutionXSetter());
        intObjectOptHashMap.put(7, this.createDisplayResolutionYSetter());
        intObjectOptHashMap.put(8, this.createAbtTypeSetter());
        intObjectOptHashMap.put(9, this.createDisplayShapeSetter());
        intObjectOptHashMap.put(10, this.createNumberOfHardKeysSetter());
        intObjectOptHashMap.put(11, this.createButtonTechnologySetter());
        intObjectOptHashMap.put(12, this.createRotaryEncoderTypeSetter());
        intObjectOptHashMap.put(13, this.createTouchControllerSetter());
        intObjectOptHashMap.put(14, this.createTouchMultiplicatorXSetter());
        intObjectOptHashMap.put(15, this.createTouchMultiplicatorYSetter());
        return intObjectOptHashMap;
    }

    private BooleanSetter createHandWritingRecognitionSetter() {
        return new ValueSetterFactory$1(this, this.abtFeatures);
    }

    private BooleanSetter createHapticFeedbackSetter() {
        return new ValueSetterFactory$2(this, this.abtFeatures);
    }

    private IntegerSetter createProximitySensorSetter() {
        return new ValueSetterFactory$3(this, this.abtFeatures, 4);
    }

    private IntegerSetter createDisplayResolutionXSetter() {
        return new ValueSetterFactory$4(this, this.abtFeatures);
    }

    private IntegerSetter createDisplayResolutionYSetter() {
        return new ValueSetterFactory$5(this, this.abtFeatures);
    }

    private IntegerSetter createAbtTypeSetter() {
        return new ValueSetterFactory$6(this, this.abtFeatures, 6);
    }

    private IntegerSetter createDisplayShapeSetter() {
        return new ValueSetterFactory$7(this, this.abtFeatures, 2);
    }

    private IntegerSetter createNumberOfHardKeysSetter() {
        return new ValueSetterFactory$8(this, this.abtFeatures);
    }

    private IntegerSetter createButtonTechnologySetter() {
        return new ValueSetterFactory$9(this, this.abtFeatures, 2);
    }

    private IntegerSetter createRotaryEncoderTypeSetter() {
        return new ValueSetterFactory$10(this, this.abtFeatures, 2);
    }

    private IntegerSetter createTouchControllerSetter() {
        return new ValueSetterFactory$11(this, this.abtFeatures, 5);
    }

    private IntegerSetter createTouchMultiplicatorXSetter() {
        return new ValueSetterFactory$12(this, this.abtFeatures);
    }

    private IntegerSetter createTouchMultiplicatorYSetter() {
        return new ValueSetterFactory$13(this, this.abtFeatures);
    }

    static {
        FEATURE_ID_TO_STRING_MAP = new IntStringMap("unknown", new int[]{1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new String[]{"PROXIMITY_SENSOR", "HAND_WRITING_RECOGNITION", "HAPTIC_FEEDBACK", "DISPLAY_RESOLUTION_X", "DISPLAY_RESOLUTION_Y", "ABT_TYPE", "DISPLAY_SHAPE", "NUMBER_OF_HARD_KEYS", "BUTTON_TECHNOLOGY", "ROTARY_ENCODER_TYPE", "TOUCH_CONTROLLER", "TOUCH_MULTIPLICATOR_X", "TOUCH_MULTIPLICATOR_Y"});
    }
}

