/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.api.system.AbtFeatureService;
import de.vw.mib.asl.internal.system.util.IntStringMap;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

public class AbtFeatureServiceImpl
implements AbtFeatureService {
    private static final String PROXIMITY_SENSOR_TYPE_PREFIX_STRING;
    private static final IntStringMap PROXIMITY_SENSOR_TYPE_TO_STRING_MAP;
    private static final String HAND_WRITING_RECOGNITION_SUPPORTED_PREFIX_STRING;
    private static final String HAPTIC_FEEDBACK_SUPPORTED_PREFIX_STRING;
    private static final String DISPLAY_RESOLUTION_X_PREFIX_STRING;
    private static final String DISPLAY_RESOLUTION_Y_PREFIX_STRING;
    private static final String ABT_TYPE_PREFIX_STRING;
    private static final IntStringMap ABT_TYPE_TO_STRING_MAP;
    private static final String DISPLAY_SHAPE_TYPE_PREFIX_STRING;
    private static final IntStringMap DISPLAY_SHAPE_TYPE_TO_STRING_MAP;
    private static final String NUMBER_OF_HARDKEYS_PREFIX_STRING;
    private static final String BUTTON_TECHNOLOGY_TYPE_PREFIX_STRING;
    private static final IntStringMap BUTTON_TECHNOLOGY_TYPE_TO_STRING_MAP;
    private static final String ROTARY_ENCODER_TYPE_PREFIX_STRING;
    private static final IntStringMap ROTARY_ENCODER_TYPE_TO_STRING_MAP;
    private static final String TOUCH_CONTROLLER_TYPE_PREFIX_STRING;
    private static final IntStringMap TOUCH_CONTROLLER_TYPE_TO_STRING_MAP;
    private static final String TOUCH_MULTIPLICATOR_X_PREFIX_STRING;
    private static final String TOUCH_MULTIPLICATOR_Y_PREFIX_STRING;
    private final int proximitySensor;
    private final boolean hasHandWritingRecognition;
    private final boolean hasHapticFeedback;
    private final int displayResolutionX;
    private final int displayResolutionY;
    private final int abtType;
    private final int displayShape;
    private final int numberOfHardKeys;
    private final int buttonTechnology;
    private final int rotaryEncoderType;
    private final int touchController;
    private final int touchMultiplicatorX;
    private final int touchMultiplicatorY;
    private AbtFeatures abtFeatures;

    public AbtFeatureServiceImpl(AbtFeatures abtFeatures) {
        Preconditions.checkArgumentNotNull(abtFeatures, "The given instance of AbtFeatures must not be null.");
        this.abtFeatures = abtFeatures;
        this.proximitySensor = abtFeatures.getProximitySensor();
        this.hasHandWritingRecognition = abtFeatures.isHandWritingRecognition();
        this.hasHapticFeedback = abtFeatures.isHapticFeedback();
        this.displayResolutionX = abtFeatures.getDisplayResolutionX();
        this.displayResolutionY = abtFeatures.getDisplayResolutionY();
        this.abtType = abtFeatures.getAbtType();
        this.displayShape = abtFeatures.getDisplayShape();
        this.numberOfHardKeys = abtFeatures.getNubmerOfHardKeys();
        this.buttonTechnology = abtFeatures.getButtonTechnology();
        this.rotaryEncoderType = abtFeatures.getRotaryEncoderType();
        this.touchController = abtFeatures.getTouchController();
        this.touchMultiplicatorX = abtFeatures.getTouchMultiplicatorX();
        this.touchMultiplicatorY = abtFeatures.getTouchMultiplicatorY();
    }

    @Override
    public int getProximitySensor() {
        return this.proximitySensor;
    }

    @Override
    public boolean hasHandWritingRecognition() {
        return this.hasHandWritingRecognition;
    }

    @Override
    public boolean hasHapticFeedback() {
        return this.hasHapticFeedback;
    }

    @Override
    public int getDisplayResolutionX() {
        return this.displayResolutionX;
    }

    @Override
    public int getDisplayResolutionY() {
        return this.displayResolutionY;
    }

    @Override
    public int getAbtType() {
        return this.abtType;
    }

    @Override
    public int getDisplayShape() {
        return this.displayShape;
    }

    @Override
    public int getNumberOfHardKeys() {
        return this.numberOfHardKeys;
    }

    @Override
    public int getButtonTechnology() {
        return this.buttonTechnology;
    }

    @Override
    public int getRotaryEncoderType() {
        return this.rotaryEncoderType;
    }

    @Override
    public int getTouchController() {
        return this.touchController;
    }

    @Override
    public int getTouchMultiplicatorX() {
        return this.touchMultiplicatorX;
    }

    @Override
    public int getTouchMultiplicatorY() {
        return this.touchMultiplicatorY;
    }

    String getRuntimeAbtFeaturesAsString() {
        String string = "Runtime ABT features:\n";
        string = new StringBuffer().append(string).append("PROXIMITY_SENSOR_TYPE = ").append(PROXIMITY_SENSOR_TYPE_TO_STRING_MAP.get(this.getProximitySensor())).append("\n").toString();
        string = new StringBuffer().append(string).append("HAND_WRITING_RECOGNITION_SUPPORTED = ").append(this.hasHandWritingRecognition() ? "TRUE" : "FALSE").append("\n").toString();
        string = new StringBuffer().append(string).append("HAPTIC_FEEDBACK_SUPPORTED = ").append(this.hasHapticFeedback() ? "TRUE" : "FALSE").append("\n").toString();
        string = new StringBuffer().append(string).append("DISPLAY_RESOLUTION_X = ").append(this.getDisplayResolutionX()).append("\n").toString();
        string = new StringBuffer().append(string).append("DISPLAY_RESOLUTION_Y = ").append(this.getDisplayResolutionY()).append("\n").toString();
        string = new StringBuffer().append(string).append("ABT_TYPE = ").append(ABT_TYPE_TO_STRING_MAP.get(this.getAbtType())).append("\n").toString();
        string = new StringBuffer().append(string).append("DISPLAY_SHAPE_TYPE = ").append(DISPLAY_SHAPE_TYPE_TO_STRING_MAP.get(this.getDisplayShape())).append("\n").toString();
        string = new StringBuffer().append(string).append("NUMBER_OF_HARDKEYS = ").append(this.getNumberOfHardKeys()).append("\n").toString();
        string = new StringBuffer().append(string).append("BUTTON_TECHNOLOGY_TYPE = ").append(BUTTON_TECHNOLOGY_TYPE_TO_STRING_MAP.get(this.getButtonTechnology())).append("\n").toString();
        string = new StringBuffer().append(string).append("ROTARY_ENCODER_TYPE = ").append(ROTARY_ENCODER_TYPE_TO_STRING_MAP.get(this.getRotaryEncoderType())).append("\n").toString();
        string = new StringBuffer().append(string).append("TOUCH_CONTROLLER_TYPE = ").append(TOUCH_CONTROLLER_TYPE_TO_STRING_MAP.get(this.getTouchController())).append("\n").toString();
        string = new StringBuffer().append(string).append("TOUCH_MULTIPLICATOR_X = ").append(this.getTouchMultiplicatorX()).append("\n").toString();
        string = new StringBuffer().append(string).append("TOUCH_MULTIPLICATOR_Y = ").append(this.getTouchMultiplicatorY()).toString();
        return string;
    }

    String getNextStartupAbtFeaturesAsString() {
        String string = "ABT features used for / loaded on next startup:\n";
        string = new StringBuffer().append(string).append("PROXIMITY_SENSOR_TYPE = ").append(PROXIMITY_SENSOR_TYPE_TO_STRING_MAP.get(this.abtFeatures.getProximitySensor())).append("\n").toString();
        string = new StringBuffer().append(string).append("HAND_WRITING_RECOGNITION_SUPPORTED = ").append(this.abtFeatures.isHandWritingRecognition() ? "TRUE" : "FALSE").append("\n").toString();
        string = new StringBuffer().append(string).append("HAPTIC_FEEDBACK_SUPPORTED = ").append(this.abtFeatures.isHapticFeedback() ? "TRUE" : "FALSE").append("\n").toString();
        string = new StringBuffer().append(string).append("DISPLAY_RESOLUTION_X = ").append(this.abtFeatures.getDisplayResolutionX()).append("\n").toString();
        string = new StringBuffer().append(string).append("DISPLAY_RESOLUTION_Y = ").append(this.abtFeatures.getDisplayResolutionY()).append("\n").toString();
        string = new StringBuffer().append(string).append("ABT_TYPE = ").append(ABT_TYPE_TO_STRING_MAP.get(this.abtFeatures.getAbtType())).append("\n").toString();
        string = new StringBuffer().append(string).append("DISPLAY_SHAPE_TYPE = ").append(DISPLAY_SHAPE_TYPE_TO_STRING_MAP.get(this.abtFeatures.getDisplayShape())).append("\n").toString();
        string = new StringBuffer().append(string).append("NUMBER_OF_HARDKEYS = ").append(this.abtFeatures.getNubmerOfHardKeys()).append("\n").toString();
        string = new StringBuffer().append(string).append("BUTTON_TECHNOLOGY_TYPE = ").append(BUTTON_TECHNOLOGY_TYPE_TO_STRING_MAP.get(this.abtFeatures.getButtonTechnology())).append("\n").toString();
        string = new StringBuffer().append(string).append("ROTARY_ENCODER_TYPE = ").append(ROTARY_ENCODER_TYPE_TO_STRING_MAP.get(this.abtFeatures.getRotaryEncoderType())).append("\n").toString();
        string = new StringBuffer().append(string).append("TOUCH_CONTROLLER_TYPE = ").append(TOUCH_CONTROLLER_TYPE_TO_STRING_MAP.get(this.abtFeatures.getTouchController())).append("\n").toString();
        string = new StringBuffer().append(string).append("TOUCH_MULTIPLICATOR_X = ").append(this.abtFeatures.getTouchMultiplicatorX()).append("\n").toString();
        string = new StringBuffer().append(string).append("TOUCH_MULTIPLICATOR_Y = ").append(this.abtFeatures.getTouchMultiplicatorY()).toString();
        return string;
    }

    static {
        PROXIMITY_SENSOR_TYPE_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2, 3, 4}, new String[]{"UNAVAILABLE", "BASIC", "NEAR_AND_FAR", "NEAR", "FAR"});
        ABT_TYPE_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2, 3, 4, 5, 6}, new String[]{"UNKNOWN", "ALPINE_6_5", "ALPINE_8", "CONTI_6_5", "CONTI_VW_621", "CONTI_8_GEN2_GP", "CONTI_9_2_GEN2_GP"});
        DISPLAY_SHAPE_TYPE_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2}, new String[]{"ACTIVE_AREA_VISIBLE", "TRAPEZOID", "ACTIVE_AREA_COVERED"});
        BUTTON_TECHNOLOGY_TYPE_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2}, new String[]{"UNKNOWN", "PARALLEL_HUB", "SENSOR"});
        ROTARY_ENCODER_TYPE_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2}, new String[]{"UNAVAILABLE", "VOLUME", "VOLUME_MENU"});
        TOUCH_CONTROLLER_TYPE_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2, 3, 4, 5}, new String[]{"UNKNOWN", "CYPRESS_GEN_1", "ATMEL_GEN_1", "ABT_2_GP_8", "ABT_2_GP_9_2", "SYNAPTICS_INCELL"});
    }
}

