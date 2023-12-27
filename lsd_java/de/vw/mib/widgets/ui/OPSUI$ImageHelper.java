/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawableManager;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

final class OPSUI$ImageHelper {
    static final int AREA_VIEW_FRONT;
    static final int AREA_VIEW_RIGHT;
    static final int AREA_VIEW_REAR;
    static final int AREA_VIEW_LEFT;
    static final int TEXTURE_BACKGROUNDS;
    static final int TEXTURE_SEGMENTS;
    private static final int TEXTURE_COMBINED;
    static final int FAILURE_DRAWABLE_SENSOR_GROUP_FRONT;
    static final int FAILURE_DRAWABLE_SENSOR_GROUP_LEFT;
    static final int FAILURE_DRAWABLE_SENSOR_GROUP_RIGHT;
    static final int FAILURE_DRAWABLE_SENSOR_GROUP_REAR;
    static final int FAILURE_DRAWABLE_SENSOR_RTA_R;
    static final int FAILURE_DRAWABLE_SENSOR_RTA_L;
    static final int FAILURE_DRAWABLE_SENSOR_RTA_R_RO;
    static final int FAILURE_DRAWABLE_SENSOR_RTA_L_RO;
    static final int FAILURE_DRAWABLE_SENSOR_FTA_R;
    static final int FAILURE_DRAWABLE_SENSOR_FTA_L;
    private static final int FAILURE_DRAWABLES_COUNT;
    static final int RIM_PROTECTION_DRAWABLE_VL;
    static final int RIM_PROTECTION_DRAWABLE_VR;
    static final int RIM_PROTECTION_DRAWABLE_HL;
    static final int RIM_PROTECTION_DRAWABLE_HR;
    private static final int RIM_PROTECTION_DRAWABLES_COUNT;
    private static final int SLICE_COUNT;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static ImageDrawable[][] createAreaViewImageDrawables(Graphics3D graphics3D, ImageDrawable[][] imageDrawableArray, OPSModel oPSModel) {
        if (imageDrawableArray == null) {
            boolean bl = oPSModel.is_showOPSMini();
            String[] stringArray = new String[]{"Areaview_Front_Active", "Areaview_Right_Active", "Areaview_Rear_Active", "Areaview_Left_Active"};
            String[] stringArray2 = new String[]{"Areaview_Front_Inactive", "Areaview_Right_Inactive", "Areaview_Rear_Inactive", "Areaview_Left_Inactive"};
            int[] nArray = oPSModel.get_areaViewStates();
            if (nArray != null) {
                imageDrawableArray = new ImageDrawable[nArray.length][3];
                StringBuilder stringBuilder = new StringBuilder(64);
                block9: for (int i2 = 0; i2 < nArray.length; ++i2) {
                    try {
                        switch (nArray[i2]) {
                            case 1: {
                                if (!bl) continue block9;
                                stringBuilder.append(stringArray[i2]);
                                break;
                            }
                            default: {
                                stringBuilder.append(stringArray2[i2]);
                            }
                        }
                        if (bl) {
                            stringBuilder.append("_Mini");
                        }
                        stringBuilder.append(".png");
                        for (int i3 = 2; i3 >= 0; --i3) {
                            imageDrawableArray[i2][i3] = AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, stringBuilder.toString(), 0);
                        }
                        continue;
                    }
                    catch (IOException iOException) {
                        AbstractWidgetUI.LOGGER.error(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load area view image. '").attachThrowable(iOException).log();
                        continue;
                    }
                    finally {
                        stringBuilder.setLength(0);
                    }
                }
            }
        }
        return imageDrawableArray;
    }

    static ImageDrawable[][] createBackgroundTextureImageDrawables(Graphics3D graphics3D, ImageDrawable[][] imageDrawableArray, OPSModel oPSModel) {
        if (imageDrawableArray == null) {
            BufferImage bufferImage = OPSUI$ImageHelper.loadTextureImage(oPSModel, 0);
            imageDrawableArray = OPSUI$ImageHelper.createImageDrawables(graphics3D, oPSModel, bufferImage);
        }
        return imageDrawableArray;
    }

    static ImageDrawable createCarImageDrawable(Graphics3D graphics3D, ImageDrawable imageDrawable, OPSModel oPSModel) {
        if (imageDrawable == null || imageDrawable.getImage() == null) {
            boolean bl = oPSModel.is_showOPSMini();
            boolean bl2 = oPSModel.is_showRearOnly();
            StringBuilder stringBuilder = new StringBuilder(32);
            if (bl) {
                stringBuilder.append("car_mini");
            } else if (bl2) {
                stringBuilder.append("car").append("_ro");
            } else {
                stringBuilder.append("car");
            }
            stringBuilder.append(".png");
            try {
                imageDrawable = AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, stringBuilder.toString(), 0);
                imageDrawable.setColor(Color4f.WHITE);
            }
            catch (IOException iOException) {
                AbstractWidgetUI.LOGGER.error(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load car image. '").attachThrowable(iOException).log();
            }
        }
        return imageDrawable;
    }

    static ImageDrawable[] createFailureTextureImageDrawables(Graphics3D graphics3D, ImageDrawable[] imageDrawableArray, OPSModel oPSModel) {
        if (imageDrawableArray == null) {
            BufferImage bufferImage = OPSUI$ImageHelper.loadTextureImage(oPSModel, 0);
            imageDrawableArray = new ImageDrawable[10];
            for (int i2 = imageDrawableArray.length - 1; i2 >= 0; --i2) {
                imageDrawableArray[i2] = OPSUI$ImageHelper.createImageDrawable(graphics3D, bufferImage);
            }
        }
        return imageDrawableArray;
    }

    static ImageDrawable[] createRimProtectionTextureImageDrawables(Graphics3D graphics3D, ImageDrawable[] imageDrawableArray, OPSModel oPSModel) {
        if (imageDrawableArray == null) {
            BufferImage bufferImage = OPSUI$ImageHelper.loadTextureImage(oPSModel, 0);
            imageDrawableArray = new ImageDrawable[4];
            for (int i2 = imageDrawableArray.length - 1; i2 >= 0; --i2) {
                imageDrawableArray[i2] = OPSUI$ImageHelper.createImageDrawable(graphics3D, bufferImage);
            }
        }
        return imageDrawableArray;
    }

    static ImageDrawable[][] createSegmentsTextureImageDrawables(Graphics3D graphics3D, ImageDrawable[][] imageDrawableArray, OPSModel oPSModel) {
        if (imageDrawableArray == null) {
            BufferImage bufferImage = OPSUI$ImageHelper.loadTextureImage(oPSModel, 1);
            imageDrawableArray = OPSUI$ImageHelper.createImageDrawables(graphics3D, oPSModel, bufferImage);
        }
        return imageDrawableArray;
    }

    static ImageDrawable createTrackAlphaImageDrawable(Graphics3D graphics3D, ImageDrawable imageDrawable, OPSModel oPSModel) {
        if (imageDrawable == null || imageDrawable.getImage() == null) {
            try {
                String string = new StringBuffer().append(oPSModel.is_showAreaView() ? "Track_Alpha_Areaview" : "Track_Alpha").append(".png").toString();
                imageDrawable = AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, string, 0);
            }
            catch (IOException iOException) {
                LogMessage logMessage = AbstractWidgetUI.LOGGER.error(128);
                logMessage.append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load track alpha image. '").append(iOException).log();
            }
        }
        return imageDrawable;
    }

    static CubicBezierCurveDrawable createTrackCurveDrawable(Graphics3D graphics3D, CubicBezierCurveDrawable cubicBezierCurveDrawable, OPSModel oPSModel) {
        block5: {
            if (cubicBezierCurveDrawable == null || cubicBezierCurveDrawable.getImage() == null) {
                String string = null;
                boolean bl = true;
                try {
                    string = OPSUI$ImageHelper.buildTrackImageFileName(oPSModel, false);
                    cubicBezierCurveDrawable = AbstractWidgetUI.createBezierCurveDrawableFromSkin0(graphics3D, string, 0, true);
                }
                catch (IOException iOException) {
                    LogMessage logMessage = AbstractWidgetUI.LOGGER.error(128);
                    logMessage.append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load track image. '").append(iOException).log();
                    String string2 = "Track".concat(".png");
                    if (string2.equals(string)) break block5;
                    try {
                        cubicBezierCurveDrawable = AbstractWidgetUI.createBezierCurveDrawableFromSkin0(graphics3D, string2, 0, true);
                    }
                    catch (IOException iOException2) {
                        // empty catch block
                    }
                }
            }
        }
        return cubicBezierCurveDrawable;
    }

    static ImageDrawable createTrackImageDrawable(Graphics3D graphics3D, ImageDrawable imageDrawable, OPSModel oPSModel) {
        block5: {
            if (imageDrawable == null || imageDrawable.getImage() == null) {
                String string = null;
                try {
                    string = OPSUI$ImageHelper.buildTrackImageFileName(oPSModel, true);
                    imageDrawable = AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, string, 0);
                }
                catch (IOException iOException) {
                    LogMessage logMessage = AbstractWidgetUI.LOGGER.error(128);
                    logMessage.append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load track image. '").append(iOException).log();
                    String string2 = "Track".concat(".png");
                    if (string2.equals(string)) break block5;
                    try {
                        imageDrawable = AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, string2, 0);
                    }
                    catch (IOException iOException2) {
                        // empty catch block
                    }
                }
            }
        }
        return imageDrawable;
    }

    static ImageDrawable createTrailerImageDrawable(Graphics3D graphics3D, ImageDrawable imageDrawable, OPSModel oPSModel) {
        if (imageDrawable == null || imageDrawable.getImage() == null) {
            boolean bl = oPSModel.is_showOPSMini();
            boolean bl2 = oPSModel.is_showRearOnly();
            StringBuilder stringBuilder = new StringBuilder(32);
            if (bl) {
                stringBuilder.append("trailer_mini");
            } else if (bl2) {
                stringBuilder.append("trailer").append("_ro");
            } else {
                stringBuilder.append("trailer");
            }
            stringBuilder.append(".png");
            try {
                imageDrawable = AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, stringBuilder.toString(), 0);
                imageDrawable.setColor(Color4f.WHITE);
            }
            catch (IOException iOException) {
                AbstractWidgetUI.LOGGER.error(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load trailer image. '").attachThrowable(iOException).log();
            }
        }
        return imageDrawable;
    }

    static boolean isAreaViewImageDrawableAvailable(ImageDrawable[][] imageDrawableArray, int n) {
        return imageDrawableArray != null && n < imageDrawableArray.length && imageDrawableArray[n] != null && imageDrawableArray[n].length > 0 && imageDrawableArray[n][0] != null;
    }

    private static String buildTrackImageFileName(OPSModel oPSModel, boolean bl) {
        String string = "Track".concat(".png");
        if (oPSModel.is_showManeuverAssist() && oPSModel.get_maneuverAssistStates() != null && oPSModel.get_maneuverAssistStates().length >= 4) {
            boolean bl2 = false;
            boolean bl3 = false;
            switch (oPSModel.get_trackDisplay()) {
                case 1: {
                    bl2 = oPSModel.get_maneuverAssistStates()[0] == 2;
                    bl3 = oPSModel.get_maneuverAssistStates()[1] == 2;
                    break;
                }
                case 2: {
                    bl2 = oPSModel.get_maneuverAssistStates()[2] == 2;
                    bl3 = oPSModel.get_maneuverAssistStates()[3] == 2;
                    break;
                }
            }
            string = bl2 && !bl3 && (bl || !oPSModel.is_direction()) ? "Track_Maneuver_Assist_Left.png" : (!bl2 && bl3 || !bl && bl2 && !bl3 && oPSModel.is_direction() ? "Track_Maneuver_Assist_Right.png" : "Track_Maneuver_Assist_Both.png");
        }
        return string;
    }

    private static ImageDrawable createImageDrawable(Graphics3D graphics3D, BufferImage bufferImage) {
        DrawableManager drawableManager = graphics3D.getDrawableManager();
        ImageDrawable imageDrawable = drawableManager.createImageDrawable();
        imageDrawable.setImage(bufferImage);
        return imageDrawable;
    }

    private static ImageDrawable[][] createImageDrawables(Graphics3D graphics3D, OPSModel oPSModel, BufferImage bufferImage) {
        int n = oPSModel.get_sensorStateValues() != null ? oPSModel.get_sensorStateValues().length / 2 : 0;
        return OPSUI$ImageHelper.createImageDrawables(graphics3D, oPSModel, bufferImage, n);
    }

    private static ImageDrawable[][] createImageDrawables(Graphics3D graphics3D, OPSModel oPSModel, BufferImage bufferImage, int n) {
        ImageDrawable[][] imageDrawableArray = new ImageDrawable[n][3];
        for (int i2 = imageDrawableArray.length - 1; i2 >= 0; --i2) {
            for (int i3 = imageDrawableArray[i2].length - 1; i3 >= 0; --i3) {
                imageDrawableArray[i2][i3] = OPSUI$ImageHelper.createImageDrawable(graphics3D, bufferImage);
            }
        }
        return imageDrawableArray;
    }

    private static BufferImage loadTextureImage(OPSModel oPSModel, int n) {
        BufferImage bufferImage;
        block15: {
            boolean bl = oPSModel.is_showAreaView();
            boolean bl2 = oPSModel.is_showOPSMini();
            boolean bl3 = oPSModel.is_showRearOnly();
            StringBuilder stringBuilder = new StringBuilder();
            bufferImage = null;
            boolean bl4 = false;
            switch (n) {
                case 0: {
                    stringBuilder.append("OPS_Texture_Backgrounds");
                    break;
                }
                case 1: {
                    stringBuilder.append("OPS_Texture_Segments");
                    break;
                }
                case 2: {
                    bl4 = true;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown texture type passed.");
                }
            }
            if (bl4) {
                if (bl2) {
                    stringBuilder.append("OPSTextures_mini.png");
                } else {
                    stringBuilder.append("OPSTextures.png");
                }
            } else {
                if (bl3 && !bl2) {
                    stringBuilder.append("_RearOnly");
                } else if (bl) {
                    stringBuilder.append("_Areaview");
                }
                if (bl2) {
                    stringBuilder.append("_Mini");
                }
                stringBuilder.append(".png");
            }
            try {
                bufferImage = SkinHelper.getCarSpecificImageFromCommonSkin(stringBuilder.toString(), 0);
            }
            catch (IOException iOException) {
                AbstractWidgetUI.LOGGER.error(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to load texture image from path '").append(stringBuilder).append("'.").log();
                if (bl4) break block15;
                bufferImage = OPSUI$ImageHelper.loadTextureImage(oPSModel, 2);
            }
        }
        return bufferImage;
    }

    private OPSUI$ImageHelper() {
    }
}

