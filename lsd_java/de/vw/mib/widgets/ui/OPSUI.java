/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.car.ops.OPSConfigData;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.AbstractWidgetUI$OffscreenDrawableHelper;
import de.vw.mib.widgets.ui.OPSUI$1;
import de.vw.mib.widgets.ui.OPSUI$AlphaTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$ClippedTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$DefaultBezierTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$ImageHelper;
import de.vw.mib.widgets.ui.OPSUI$OPSUIHelper;
import de.vw.mib.widgets.ui.OPSUI$RectangleTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$TrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$TrackHelper;
import java.util.Arrays;

public final class OPSUI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private static final int ROTATE_TO_MINI;
    private static final int ROTATE_Z;
    private static final int SCALE_X_MIRROR;
    private static final int SCALE_X_NONE;
    private static final int SCALE_Y_MIRROR;
    private static final int SCALE_Y_NONE;
    private static final int TRANSLATE_X_NONE;
    private static final int TRANSLATE_Y_NONE;
    private static final int TRANSLATE_Z_NONE;
    private static final short STARTING_POINT;
    private static final short FRONT_AXLE_CENTER;
    private static final short REAR_AXLE_CENTER;
    private static final short FRONT_CORNER_LEFT;
    private static final short FRONT_OVERHANG_LEFT;
    private static final boolean DEBUG;
    private static final int RADIUS_STRAIGHT_TRACK;
    private static final int DRAWABLE_INDEX_MAIN;
    private static final int DRAWABLE_INDEX_LEFT;
    private static final int DRAWABLE_INDEX_RIGHT;
    private ImageDrawable[][] areaViewImageDrawables;
    private ImageDrawable carImageDrawable;
    private Rectangle childClipArea;
    private final boolean[] drawSensors = new boolean[54];
    private boolean errMsgAlreadyLogged = false;
    private ImageDrawable[][] backgroundTextureDrawables;
    private ImageDrawable[][] segmentsTextureDrawables;
    private ImageDrawable[] failureTextureDrawables;
    private ImageDrawable[] rimProtectionDrawable;
    private Point2f trackCenterPoint;
    private OffscreenDrawable contentDrawable;
    private ImageDrawable trackImageDrawable;
    private ImageDrawable trackAlphaImageDrawable;
    private CubicBezierCurveDrawable trackCurveDrawable;
    private OPSUI$TrackDrawer trackDrawer;
    private OPSUI$TrackDrawer trackDrawerStraight;
    private Rectangle[] trackValues;
    private ImageDrawable trailerImageDrawable;
    private Rectangle trackClipArea;
    private int lastAlpha;
    private Color4f trackBlendColor;
    private RectangleDrawable debugTrackValueOffsetDrawable;
    private RectangleDrawable debugTrackValueDrawable;

    @Override
    public void init() {
        super.init();
        this.trackBlendColor = new Color4f(Color4f.WHITE);
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.addPropertyChangedListener(this);
        }
    }

    @Override
    public void deInit() {
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.removePropertyChangedListener(this);
        }
        this.releaseMembers();
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.releaseMembers();
    }

    private void releaseMembers() {
        this.childClipArea = null;
        this.trackBlendColor = null;
        this.errMsgAlreadyLogged = false;
        this.trackCenterPoint = null;
        this.trackValues = null;
        OPSUI.dispose(this.trackDrawer);
        this.trackDrawer = null;
        OPSUI.dispose(this.trackDrawerStraight);
        this.trackDrawerStraight = null;
        OPSUI.disposeDrawables(this.areaViewImageDrawables);
        this.areaViewImageDrawables = null;
        OPSUI.disposeDrawables(this.backgroundTextureDrawables);
        this.backgroundTextureDrawables = null;
        OPSUI.disposeDrawables(this.segmentsTextureDrawables);
        this.segmentsTextureDrawables = null;
        OPSUI.disposeDrawables(this.failureTextureDrawables);
        this.failureTextureDrawables = null;
        OPSUI.disposeDrawables(this.rimProtectionDrawable);
        this.rimProtectionDrawable = null;
        OPSUI.disposeDrawable(this.contentDrawable);
        this.contentDrawable = null;
        OPSUI.disposeDrawable(this.trackAlphaImageDrawable);
        this.trackAlphaImageDrawable = null;
        OPSUI.disposeDrawable(this.trackImageDrawable);
        this.trackImageDrawable = null;
        OPSUI.disposeDrawable(this.trackCurveDrawable);
        this.trackCurveDrawable = null;
        OPSUI.disposeDrawable(this.debugTrackValueDrawable);
        this.debugTrackValueDrawable = null;
        OPSUI.disposeDrawable(this.debugTrackValueOffsetDrawable);
        this.debugTrackValueOffsetDrawable = null;
        OPSUI.disposeDrawable(this.carImageDrawable);
        this.carImageDrawable = null;
        OPSUI.disposeDrawable(this.trailerImageDrawable);
        this.trailerImageDrawable = null;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 29: {
                this.areaViewStatesChanged();
                break;
            }
            case 19: {
                this.directionChanged();
                break;
            }
            case 39: {
                this.maneuverAssistStatesChanged();
                break;
            }
            case 28: {
                this.showAreaViewChanged();
                break;
            }
            case 24: {
                this.showOPSMiniChanged();
                break;
            }
            case 22: {
                this.showRearOnlyChanged();
                break;
            }
            case 27: {
                this.showTestModeChanged();
                break;
            }
            case 35: {
                this.showFTAChanged();
                break;
            }
            case 31: {
                this.showRTAChanged();
                break;
            }
            case 38: {
                this.showManeuverAssistChanged();
                break;
            }
            case 40: {
                this.showRimProtectionChanged();
                break;
            }
            case 18: {
                this.trackDisplayChanged();
                break;
            }
        }
    }

    private void areaViewStatesChanged() {
        OPSUI.disposeDrawables(this.areaViewImageDrawables);
        this.areaViewImageDrawables = null;
    }

    private void directionChanged() {
        OPSUI.disposeDrawable(this.trackCurveDrawable);
        this.trackCurveDrawable = null;
        OPSUI.disposeDrawable(this.trackImageDrawable);
        this.trackImageDrawable = null;
        OPSUI.dispose(this.trackDrawer);
        this.trackDrawer = null;
        OPSUI.dispose(this.trackDrawerStraight);
        this.trackDrawerStraight = null;
    }

    private void maneuverAssistStatesChanged() {
        OPSUI.disposeDrawable(this.trackCurveDrawable);
        this.trackCurveDrawable = null;
        OPSUI.disposeDrawable(this.trackImageDrawable);
        this.trackImageDrawable = null;
        OPSUI.dispose(this.trackDrawer);
        this.trackDrawer = null;
        OPSUI.dispose(this.trackDrawerStraight);
        this.trackDrawerStraight = null;
    }

    private void showAreaViewChanged() {
        OPSUI.disposeDrawables(this.areaViewImageDrawables);
        this.areaViewImageDrawables = null;
        OPSUI.disposeDrawables(this.backgroundTextureDrawables);
        this.backgroundTextureDrawables = null;
        OPSUI.disposeDrawables(this.segmentsTextureDrawables);
        this.segmentsTextureDrawables = null;
        OPSUI.disposeDrawables(this.failureTextureDrawables);
        this.failureTextureDrawables = null;
    }

    private void showOPSMiniChanged() {
        this.trackValues = null;
        OPSUI.disposeDrawable(this.carImageDrawable);
        this.carImageDrawable = null;
        OPSUI.disposeDrawable(this.trailerImageDrawable);
        this.trailerImageDrawable = null;
        OPSUI.disposeDrawables(this.backgroundTextureDrawables);
        this.backgroundTextureDrawables = null;
        OPSUI.disposeDrawables(this.segmentsTextureDrawables);
        this.segmentsTextureDrawables = null;
        OPSUI.disposeDrawables(this.failureTextureDrawables);
        this.failureTextureDrawables = null;
        OPSUI.disposeDrawables(this.areaViewImageDrawables);
        this.areaViewImageDrawables = null;
    }

    private void showRearOnlyChanged() {
        OPSUI.disposeDrawable(this.carImageDrawable);
        this.carImageDrawable = null;
        OPSUI.disposeDrawable(this.trailerImageDrawable);
        this.trailerImageDrawable = null;
        OPSUI.disposeDrawables(this.backgroundTextureDrawables);
        this.backgroundTextureDrawables = null;
        OPSUI.disposeDrawables(this.segmentsTextureDrawables);
        this.segmentsTextureDrawables = null;
        OPSUI.disposeDrawables(this.failureTextureDrawables);
        this.failureTextureDrawables = null;
    }

    private void showTestModeChanged() {
        OPSUI.dispose(this.trackDrawer);
        this.trackDrawer = null;
        OPSUI.dispose(this.trackDrawerStraight);
        this.trackDrawerStraight = null;
    }

    private void showFTAChanged() {
    }

    private void showManeuverAssistChanged() {
        OPSUI.disposeDrawable(this.trackCurveDrawable);
        this.trackCurveDrawable = null;
        OPSUI.disposeDrawable(this.trackImageDrawable);
        this.trackImageDrawable = null;
        OPSUI.dispose(this.trackDrawer);
        this.trackDrawer = null;
        OPSUI.dispose(this.trackDrawerStraight);
        this.trackDrawerStraight = null;
    }

    private void showRimProtectionChanged() {
        OPSUI.disposeDrawables(this.rimProtectionDrawable);
        this.rimProtectionDrawable = null;
    }

    private void showRTAChanged() {
    }

    private void trackDisplayChanged() {
        OPSUI.disposeDrawable(this.trackCurveDrawable);
        this.trackCurveDrawable = null;
        OPSUI.disposeDrawable(this.trackImageDrawable);
        this.trackImageDrawable = null;
        OPSUI.dispose(this.trackDrawer);
        this.trackDrawer = null;
        OPSUI.dispose(this.trackDrawerStraight);
        this.trackDrawerStraight = null;
    }

    private void drawAreaView(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, Color4b color4b, float f2) {
        if (oPSModel.is_showAreaView()) {
            this.areaViewImageDrawables = OPSUI$ImageHelper.createAreaViewImageDrawables(graphics3D, this.areaViewImageDrawables, oPSModel);
            if (this.areaViewImageDrawables != null) {
                BufferImage bufferImage;
                ImageDrawable[] imageDrawableArray;
                short s = 0;
                short s2 = 0;
                short s3 = 0;
                int n = 0;
                short s4 = 0;
                short s5 = 0;
                int n2 = 0;
                if (OPSUI$ImageHelper.isAreaViewImageDrawableAvailable(this.areaViewImageDrawables, 0)) {
                    imageDrawableArray = this.areaViewImageDrawables[0];
                    s = oPSConfigData.getAreaViewDataValue(0);
                    s2 = oPSConfigData.getAreaViewDataValue(1);
                    s3 = oPSConfigData.getAreaViewDataValue(4);
                    bufferImage = imageDrawableArray[0].getImage();
                    n = bufferImage.getHeight();
                    n2 = bufferImage.getWidth();
                    s4 = oPSConfigData.getAreaViewDataValue(2);
                    s5 = oPSConfigData.getAreaViewDataValue(3);
                    this.drawImageDrawableSliced(graphics3D, imageDrawableArray, s4, s5, s, s2, s3, n, 0, 0, n2, n, color4b, f2, 0);
                }
                if (OPSUI$ImageHelper.isAreaViewImageDrawableAvailable(this.areaViewImageDrawables, 1)) {
                    imageDrawableArray = this.areaViewImageDrawables[1];
                    s = oPSConfigData.getAreaViewDataValue(5);
                    s2 = oPSConfigData.getAreaViewDataValue(9);
                    s3 = oPSConfigData.getAreaViewDataValue(10);
                    bufferImage = imageDrawableArray[0].getImage();
                    n = bufferImage.getHeight();
                    n2 = bufferImage.getWidth();
                    s4 = oPSConfigData.getAreaViewDataValue(6);
                    s5 = oPSConfigData.getAreaViewDataValue(7);
                    this.drawImageDrawableSliced(graphics3D, imageDrawableArray, s4, s5, s, s2, s3, n, 0, 0, n2, n, color4b, f2, 0);
                }
                if (OPSUI$ImageHelper.isAreaViewImageDrawableAvailable(this.areaViewImageDrawables, 2)) {
                    imageDrawableArray = this.areaViewImageDrawables[2];
                    s = oPSConfigData.getAreaViewDataValue(11);
                    s2 = oPSConfigData.getAreaViewDataValue(12);
                    s3 = oPSConfigData.getAreaViewDataValue(15);
                    bufferImage = imageDrawableArray[0].getImage();
                    n = bufferImage.getHeight();
                    n2 = bufferImage.getWidth();
                    s4 = oPSConfigData.getAreaViewDataValue(13);
                    s5 = oPSConfigData.getAreaViewDataValue(14);
                    this.drawImageDrawableSliced(graphics3D, imageDrawableArray, s4, s5, s, s2, s3, n, 0, 0, n2, n, color4b, f2, 0);
                }
                if (OPSUI$ImageHelper.isAreaViewImageDrawableAvailable(this.areaViewImageDrawables, 3)) {
                    imageDrawableArray = this.areaViewImageDrawables[3];
                    s = oPSConfigData.getAreaViewDataValue(5);
                    s2 = oPSConfigData.getAreaViewDataValue(8);
                    s3 = oPSConfigData.getAreaViewDataValue(10);
                    bufferImage = imageDrawableArray[0].getImage();
                    n = bufferImage.getHeight();
                    n2 = bufferImage.getWidth();
                    s4 = oPSConfigData.getAreaViewDataValue(6);
                    s5 = oPSConfigData.getAreaViewDataValue(7);
                    this.drawImageDrawableSliced(graphics3D, imageDrawableArray, s4, s5, s, s2, s3, n, 0, 0, n2, n, color4b, f2, 0);
                }
            }
        }
    }

    private void drawBackground(int n, Graphics3D graphics3D, ImageDrawable[] imageDrawableArray, short[] sArray, int n2, int n3, int n4, int n5, Color4b color4b, float f2, int n6) {
        boolean bl = OPSUI$OPSUIHelper.isRightSideBackground(n);
        if (bl) {
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, n2, n3, 0.0f);
            graphics3D.scaleMatrix(0, n4, n5, 1.0f);
        }
        if (sArray[5] > 0) {
            this.drawImageDrawableSliced(graphics3D, imageDrawableArray, sArray[5], sArray[1], sArray[2], sArray[3], sArray[4], sArray[6], sArray[7], sArray[8], sArray[9], color4b, f2, n6);
        } else {
            this.drawImageDrawableSubTexture(graphics3D, imageDrawableArray[0], sArray[1], sArray[2], sArray[3], sArray[4], sArray[6], sArray[7], sArray[8], sArray[9], color4b, f2, n6);
        }
        if (bl) {
            graphics3D.popMatrix(0);
        }
    }

    private void drawBackgrounds(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, Color4b color4b, float f2) {
        if (oPSConfigData != null && imageDrawableArray != null) {
            boolean bl = oPSModel.is_showRearOnly();
            boolean bl2 = oPSModel.is_show360();
            boolean bl3 = oPSModel.is_showRTA();
            boolean bl4 = oPSModel.is_showFTA();
            boolean bl5 = oPSModel.is_showTrailer();
            boolean bl6 = oPSModel.is_showAreaView();
            if (bl) {
                if (!bl5) {
                    if (bl3) {
                        this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_4K_RTA, color4b, f2);
                    }
                    this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_4K, color4b, f2);
                }
            } else if (bl2) {
                if (bl5) {
                    if (bl4) {
                        this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360_FTA, color4b, f2);
                    }
                    if (bl6) {
                        this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360_AV_TRAILER, color4b, f2);
                    } else {
                        this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360_TRAILER, color4b, f2);
                    }
                } else {
                    if (bl4) {
                        this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360_FTA, color4b, f2);
                    }
                    if (bl3) {
                        this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360_RTA, color4b, f2);
                    }
                    if (bl6) {
                        this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360_AV, color4b, f2);
                    } else {
                        this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_360, color4b, f2);
                    }
                }
            } else if (bl5) {
                if (bl4) {
                    this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_8K_FTA, color4b, f2);
                }
                this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_8K_TRAILER, color4b, f2);
            } else {
                if (bl4) {
                    this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_8K_FTA, color4b, f2);
                }
                if (bl3) {
                    this.drawBackgroundsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_8K_RTA, color4b, f2);
                }
                this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.BG_GROUP_8K, color4b, f2);
            }
        }
    }

    private void drawBackgrounds(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, Color4b color4b, float f2) {
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            int n = nArray[i2];
            if (!OPSUI$OPSUIHelper.isBackgroundAvailable(oPSModel, n)) continue;
            short[] sArray = oPSConfigData.getAdditionalGraphicsData(OPSUI$OPSUIHelper.mapRightToLeftBackground(n));
            if (sArray != null) {
                int n2;
                ImageDrawable[] imageDrawableArray2;
                int n3 = OPSUI$OPSUIHelper.mapBackgroundToSensor(n);
                int n4 = OPSUI$OPSUIHelper.mapRightToLeftSensor(n3);
                ImageDrawable[] imageDrawableArray3 = imageDrawableArray2 = n4 >= 0 && n4 < imageDrawableArray.length ? imageDrawableArray[n4] : null;
                if (imageDrawableArray2 == null) continue;
                int n5 = OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData);
                int n6 = OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData);
                int n7 = OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData);
                int n8 = OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData);
                int n9 = OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, OPSUI$OPSUIHelper.mapSensorToSensorGroup(n3));
                boolean bl = n9 != 0;
                boolean bl2 = oPSModel.is_showColoredSensorFailure();
                float f3 = f2;
                if (bl) {
                    if (bl2) {
                        n2 = n9 == 1 ? 15 : 12;
                        Color4b color4b2 = OPSUI$OPSUIHelper.getSensorStateColor(oPSModel.get_sensorStateColors(), n2).getCurrentColor();
                        this.drawBackground(n, graphics3D, imageDrawableArray2, sArray, n5, n6, n7, n8, color4b2, f3 *= AbstractWidgetUI.normalizeAlpha(OPSUI$OPSUIHelper.getColoredSensorFailureAlpha(oPSModel.get_coloredSensorFailureAlphas(), n2)), 3);
                        continue;
                    }
                    this.drawBackground(n, graphics3D, imageDrawableArray2, sArray, n5, n6, n7, n8, color4b, f3 *= AbstractWidgetUI.normalizeAlpha(oPSConfigData.getImageMetaData(0)), 0);
                    continue;
                }
                if (bl2) {
                    n2 = OPSUI$OPSUIHelper.getSensorStateValue(oPSModel.get_sensorStateValues(), n3);
                    this.drawBackground(n, graphics3D, imageDrawableArray2, sArray, n5, n6, n7, n8, color4b, f3 *= AbstractWidgetUI.normalizeAlpha(OPSUI$OPSUIHelper.getColoredSensorFailureAlpha(oPSModel.get_coloredSensorFailureAlphas(), n2)), 0);
                    continue;
                }
                this.drawBackground(n, graphics3D, imageDrawableArray2, sArray, n5, n6, n7, n8, color4b, f2, 0);
                continue;
            }
            LOGGER.warn(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': None positioning data available to position background image [id=").append(n).append("].").log();
        }
    }

    private void drawBackgroundsTrafficAlert(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, Color4b color4b, float f2) {
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            ImageDrawable[] imageDrawableArray2;
            int n = nArray[i2];
            if (!OPSUI$OPSUIHelper.isBackgroundTrafficAlertAvailable(oPSModel, n)) continue;
            short[] sArray = oPSConfigData.getAdditionalGraphicsData(OPSUI$OPSUIHelper.mapRightToLeftBackgroundTrafficAlert(n));
            int n2 = OPSUI$OPSUIHelper.mapBackgroundTrafficAlertToSensor(n);
            ImageDrawable[] imageDrawableArray3 = imageDrawableArray2 = n2 >= 0 && n2 < imageDrawableArray.length ? imageDrawableArray[n2] : null;
            if (imageDrawableArray2 == null) continue;
            this.drawBackground(n, graphics3D, imageDrawableArray2, sArray, OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData), color4b, f2, 0);
        }
    }

    private void drawCarImage(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, float f2) {
        if (oPSConfigData != null) {
            short[] sArray = null;
            short[] sArray2 = null;
            if (oPSModel.is_showRearOnly()) {
                if (oPSModel.is_showTrailer()) {
                    sArray2 = oPSConfigData.getCarSpecificImageData(3);
                }
                sArray = oPSConfigData.getCarSpecificImageData(1);
            } else {
                if (oPSModel.is_showTrailer()) {
                    sArray2 = oPSConfigData.getCarSpecificImageData(2);
                }
                sArray = oPSConfigData.getCarSpecificImageData(0);
            }
            if (sArray2 != null) {
                this.trailerImageDrawable = OPSUI$ImageHelper.createTrailerImageDrawable(graphics3D, this.trailerImageDrawable, oPSModel);
                this.trailerImageDrawable.setAlpha(f2);
                this.trailerImageDrawable.draw(sArray2[1], sArray2[2]);
            }
            this.carImageDrawable = OPSUI$ImageHelper.createCarImageDrawable(graphics3D, this.carImageDrawable, oPSModel);
            this.carImageDrawable.setAlpha(f2);
            this.carImageDrawable.draw(sArray[1], sArray[2]);
        }
    }

    private void drawImageDrawableSliced(Graphics3D graphics3D, ImageDrawable[] imageDrawableArray, short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8, short s9, Color4b color4b, float f2, int n) {
        this.drawImageDrawableSliced(graphics3D, imageDrawableArray, s, s, s2, s3, s4, s5, s6, s7, s8, s9, color4b, f2, n);
    }

    private void drawImageDrawableSliced(Graphics3D graphics3D, ImageDrawable[] imageDrawableArray, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Color4b color4b, float f2, int n11) {
        this.drawImageDrawableSubTexture(graphics3D, imageDrawableArray[1], n3, n4, n, n6, 0, 0, n, n10, color4b, f2, n11);
        this.drawImageDrawableSubTexture(graphics3D, imageDrawableArray[0], n3 + n, n4, n5 - (n + n2), n6, n7 + n, n8, n9 - (n + n2), n10, color4b, f2, n11);
        this.drawImageDrawableSubTexture(graphics3D, imageDrawableArray[2], n3 + n5 - n2, n4, n2, n6, n7 + n9 - n2, n8, n2, n10, color4b, f2, n11);
    }

    private void drawImageDrawableSubTexture(Graphics3D graphics3D, ImageDrawable imageDrawable, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Color4b color4b, float f2, int n9) {
        imageDrawable.setColor(color4b);
        imageDrawable.setAlpha(f2);
        imageDrawable.setDestinationX(n);
        imageDrawable.setDestinationY(n2);
        imageDrawable.setDestinationWidth(n3);
        imageDrawable.setDestinationHeight(n4);
        imageDrawable.setSourceX(n5);
        imageDrawable.setSourceY(n6);
        imageDrawable.setSourceWidth(n7);
        imageDrawable.setSourceHeight(n8);
        imageDrawable.setImageBlending(n9);
        if (imageDrawable.getImageBlendingColor() != null) {
            imageDrawable.getImageBlendingColor().set(color4b);
        } else {
            imageDrawable.setImageBlendingColor(new Color4f(color4b.getRGBA()));
        }
        imageDrawable.draw();
    }

    private void drawOverlays(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, Color4b color4b, float f2) {
        if (oPSConfigData != null && imageDrawableArray != null) {
            boolean bl = oPSModel.is_show360();
            boolean bl2 = oPSModel.is_showRTA();
            boolean bl3 = oPSModel.is_showFTA();
            boolean bl4 = oPSModel.is_showTrailer();
            if (bl) {
                if (bl3) {
                    this.drawOverlays(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.OL_GROUP_360_FTA, color4b, f2);
                }
                if (!bl4 && bl2) {
                    this.drawOverlays(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.OL_GROUP_360_RTA, color4b, f2);
                }
            } else {
                if (bl3) {
                    this.drawOverlays(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.OL_GROUP_8K_FTA, color4b, f2);
                }
                if (!bl4 && bl2) {
                    this.drawOverlays(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.OL_GROUP_8K_RTA, color4b, f2);
                }
            }
        }
    }

    private void drawOverlays(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, Color4b color4b, float f2) {
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            ImageDrawable[] imageDrawableArray2;
            int n = nArray[i2];
            if (!OPSUI$OPSUIHelper.isOverlayAvailable(oPSModel, n)) continue;
            short[] sArray = oPSConfigData.getAdditionalGraphicsData(OPSUI$OPSUIHelper.mapRightToLeftOverlay(n));
            int n2 = OPSUI$OPSUIHelper.mapOverlayToSensor(n);
            ImageDrawable[] imageDrawableArray3 = imageDrawableArray2 = n2 >= 0 && n2 < imageDrawableArray.length ? imageDrawableArray[n2] : null;
            if (imageDrawableArray2 == null) continue;
            this.drawBackground(n, graphics3D, imageDrawableArray2, sArray, OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData), color4b, f2, 0);
        }
    }

    private void drawRimProtections(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, float f2) {
        if (oPSModel.is_showRimProtection() && oPSConfigData != null) {
            boolean bl = oPSModel.is_show360();
            this.rimProtectionDrawable = OPSUI$ImageHelper.createRimProtectionTextureImageDrawables(graphics3D, this.rimProtectionDrawable, oPSModel);
            if (bl) {
                this.drawRimProtections(graphics3D, oPSModel, oPSConfigData, this.rimProtectionDrawable, OPSModel.RP_GROUP_360, f2);
            }
        }
    }

    private void drawRimProtections(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[] imageDrawableArray, int[] nArray, float f2) {
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            Color4b color4b;
            int n;
            ImageDrawable imageDrawable;
            short[] sArray;
            int n2 = nArray[i2];
            if (!OPSUI$OPSUIHelper.isRimProtectionAvailable(oPSModel, n2) || (sArray = oPSConfigData.getAdditionalGraphicsData(n2)) == null) continue;
            int n3 = OPSUI$OPSUIHelper.mapRimProtectionToSensor(n2);
            ImageDrawable imageDrawable2 = imageDrawable = n3 >= 0 && n3 < imageDrawableArray.length ? imageDrawableArray[n3] : null;
            if (imageDrawable == null) continue;
            int n4 = n = n3 >= 0 && oPSModel.get_rimProtectionStates() != null && n3 < oPSModel.get_rimProtectionStates().length ? oPSModel.get_rimProtectionStates()[n3] : -1;
            if (n == -1) continue;
            Color4b color4b2 = color4b = n >= 0 && oPSModel.get_rimProtectionStateColors() != null && n < oPSModel.get_rimProtectionStateColors().length ? oPSModel.get_rimProtectionStateColors()[n].getCurrentColor() : null;
            if (color4b == null) continue;
            this.drawImageDrawableSubTexture(graphics3D, imageDrawable, sArray[1], sArray[2], sArray[3], sArray[4], sArray[6], sArray[7], sArray[8], sArray[9], color4b, f2, 0);
        }
    }

    private void drawSensorFailure(Graphics3D graphics3D, OPSModel oPSModel, ImageDrawable imageDrawable, short[] sArray, int n, Color4b color4b, float f2) {
        boolean bl = oPSModel.is_showColoredSensorFailure();
        if (bl) {
            Color[] colorArray = oPSModel.get_sensorStateColors();
            switch (n) {
                case 1: {
                    color4b = OPSUI$OPSUIHelper.getSensorStateColor(colorArray, 15).getCurrentColor();
                    this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                    break;
                }
                case 2: {
                    color4b = OPSUI$OPSUIHelper.getSensorStateColor(colorArray, 12).getCurrentColor();
                    this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                    break;
                }
                default: {
                    this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                    break;
                }
            }
        } else {
            this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
        }
    }

    private void drawSensorFailure(Graphics3D graphics3D, ImageDrawable imageDrawable, short[] sArray, Color4b color4b, float f2) {
        this.drawImageDrawableSubTexture(graphics3D, imageDrawable, sArray[1], sArray[2], sArray[3], sArray[4], sArray[6], sArray[7], sArray[8], sArray[9], color4b, f2, 0);
    }

    private void drawSensorFailures(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[] imageDrawableArray, Color4b color4b, float f2) {
        if (oPSConfigData != null && imageDrawableArray != null) {
            int[] nArray;
            boolean bl = oPSModel.is_showRearOnly();
            boolean bl2 = oPSModel.is_showTrailer();
            boolean bl3 = oPSModel.is_show360();
            boolean bl4 = oPSModel.is_showRTA();
            boolean bl5 = oPSModel.is_showFTA();
            int n = 0;
            short[] sArray = null;
            ImageDrawable imageDrawable = null;
            if (!bl) {
                n = OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, 0);
                switch (n) {
                    case 1: {
                        sArray = oPSConfigData.getAdditionalGraphicsData(0);
                        imageDrawable = imageDrawableArray[0];
                        break;
                    }
                    case 2: {
                        sArray = oPSConfigData.getAdditionalGraphicsData(21);
                        imageDrawable = imageDrawableArray[0];
                        break;
                    }
                }
                if (sArray != null) {
                    this.drawSensorFailure(graphics3D, oPSModel, imageDrawable, sArray, n, color4b, f2);
                    sArray = null;
                }
                if (bl3) {
                    n = OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, 1);
                    switch (n) {
                        case 1: {
                            sArray = oPSConfigData.getAdditionalGraphicsData(1);
                            imageDrawable = imageDrawableArray[1];
                            break;
                        }
                        case 2: {
                            sArray = oPSConfigData.getAdditionalGraphicsData(22);
                            imageDrawable = imageDrawableArray[1];
                            break;
                        }
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, oPSModel, imageDrawable, sArray, n, color4b, f2);
                        sArray = null;
                    }
                    n = OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, 2);
                    switch (n) {
                        case 1: {
                            sArray = oPSConfigData.getAdditionalGraphicsData(2);
                            imageDrawable = imageDrawableArray[2];
                            break;
                        }
                        case 2: {
                            sArray = oPSConfigData.getAdditionalGraphicsData(23);
                            imageDrawable = imageDrawableArray[2];
                            break;
                        }
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, oPSModel, imageDrawable, sArray, n, color4b, f2);
                        sArray = null;
                    }
                }
                if (bl5 && (nArray = oPSModel.get_ftaStates()) != null && nArray.length >= 2) {
                    if (nArray[0] == 15) {
                        sArray = oPSConfigData.getAdditionalGraphicsData(37);
                        imageDrawable = imageDrawableArray[9];
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                        sArray = null;
                    }
                    if (nArray[1] == 15) {
                        sArray = oPSConfigData.getAdditionalGraphicsData(38);
                        imageDrawable = imageDrawableArray[8];
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                        sArray = null;
                    }
                }
                if (bl4 && !bl2 && (nArray = oPSModel.get_rtaStates()) != null && nArray.length >= 2) {
                    if (nArray[0] == 15) {
                        sArray = oPSConfigData.getAdditionalGraphicsData(19);
                        imageDrawable = imageDrawableArray[5];
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                        sArray = null;
                    }
                    if (nArray[1] == 15) {
                        sArray = oPSConfigData.getAdditionalGraphicsData(20);
                        imageDrawable = imageDrawableArray[4];
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                        sArray = null;
                    }
                }
            }
            if (!bl2) {
                n = OPSUI$OPSUIHelper.isSensorGroupAvailable(oPSModel, 3);
                switch (n) {
                    case 1: {
                        sArray = oPSConfigData.getAdditionalGraphicsData(bl ? 4 : 3);
                        imageDrawable = imageDrawableArray[3];
                        break;
                    }
                    case 2: {
                        sArray = oPSConfigData.getAdditionalGraphicsData(bl ? 25 : 24);
                        imageDrawable = imageDrawableArray[3];
                        break;
                    }
                }
                if (sArray != null) {
                    this.drawSensorFailure(graphics3D, oPSModel, imageDrawable, sArray, n, color4b, f2);
                    sArray = null;
                }
                if (bl && bl4 && (nArray = oPSModel.get_rtaStates()) != null && nArray.length >= 2) {
                    if (nArray[OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(400)] == 15) {
                        sArray = oPSConfigData.getAdditionalGraphicsData(29);
                        imageDrawable = imageDrawableArray[7];
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                        sArray = null;
                    }
                    if (nArray[OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(401)] == 15) {
                        sArray = oPSConfigData.getAdditionalGraphicsData(30);
                        imageDrawable = imageDrawableArray[6];
                    }
                    if (sArray != null) {
                        this.drawSensorFailure(graphics3D, imageDrawable, sArray, color4b, f2);
                        sArray = null;
                    }
                }
            }
        }
    }

    private void drawSensorSegment(Graphics3D graphics3D, short[] sArray, ImageDrawable[] imageDrawableArray, boolean bl, int n, int n2, int n3, int n4, Color4b color4b, float f2) {
        if (bl) {
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, n, n2, 0.0f);
            graphics3D.scaleMatrix(0, n3, n4, 1.0f);
        }
        this.drawSensorSegmentBlended(graphics3D, sArray, imageDrawableArray, color4b, f2);
        if (bl) {
            graphics3D.popMatrix(0);
        }
    }

    private void drawSensorSegmentBlended(Graphics3D graphics3D, short[] sArray, ImageDrawable[] imageDrawableArray, Color4b color4b, float f2) {
        if (sArray[7] != 0) {
            this.drawImageDrawableSliced(graphics3D, imageDrawableArray, sArray[7], sArray[3], sArray[4], sArray[5], sArray[6], sArray[8], sArray[9], sArray[10], sArray[11], color4b, f2, 0);
        } else {
            this.drawImageDrawableSubTexture(graphics3D, imageDrawableArray[0], sArray[3], sArray[4], sArray[5], sArray[6], sArray[8], sArray[9], sArray[10], sArray[11], color4b, f2, 0);
        }
    }

    private void drawSegmentsCameraBased(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, Color4b color4b, float f2) {
        if (oPSConfigData != null && imageDrawableArray != null) {
            Arrays.fill(this.drawSensors, false);
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                ImageDrawable[] imageDrawableArray2;
                int n = nArray[i2];
                if (this.drawSensors[OPSUI$OPSUIHelper.isLogicalSensor(n) ? OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n) : n]) continue;
                int[] nArray2 = oPSModel.get_sensorsSegmentValues();
                int n2 = nArray2[OPSUI$OPSUIHelper.isLogicalSensor(n) ? OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n) : n];
                if (oPSModel.is_showTestMode()) {
                    ImageDrawable[] imageDrawableArray3;
                    int n3 = OPSUI$OPSUIHelper.mapRightToLeftSensor(OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n));
                    ImageDrawable[] imageDrawableArray4 = imageDrawableArray3 = n3 >= 0 && n3 < imageDrawableArray.length ? imageDrawableArray[n3] : null;
                    if (imageDrawableArray3 == null) continue;
                    this.drawSensorsAtOnce(graphics3D, oPSModel, oPSConfigData, imageDrawableArray3, OPSUI$OPSUIHelper.mapSensorToConfigSectorIdCameraBased(n), OPSUI$OPSUIHelper.isRightSideSensorCameraBased(n), color4b, f2);
                    continue;
                }
                short[] sArray = OPSUI$OPSUIHelper.getDataSetCameraBased(oPSConfigData, n, n2, oPSModel.is_show360());
                if (sArray == null) continue;
                int n4 = OPSUI$OPSUIHelper.mapRightToLeftSensor(OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n));
                ImageDrawable[] imageDrawableArray5 = imageDrawableArray2 = n4 >= 0 && n4 < imageDrawableArray.length ? imageDrawableArray[n4] : null;
                if (imageDrawableArray2 != null) {
                    this.drawSensorSegment(graphics3D, sArray, imageDrawableArray2, OPSUI$OPSUIHelper.isRightSideSensorCameraBased(n), OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData), Color4b.WHITE, f2);
                }
                this.drawSensors[OPSUI$OPSUIHelper.isLogicalSensor((int)n) ? OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor((int)n) : n] = true;
            }
        }
    }

    private void drawSensorSegments(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, Color4b color4b, float f2) {
        boolean bl = oPSModel.is_showRearOnly();
        boolean bl2 = oPSModel.is_show360();
        boolean bl3 = oPSModel.is_showRTA();
        boolean bl4 = oPSModel.is_showFTA();
        boolean bl5 = oPSModel.is_showTrailer();
        boolean bl6 = oPSModel.is_showCameraBasedSegments();
        if (bl) {
            if (!bl5) {
                this.drawSensorSegments(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_4K, f2);
                if (bl3) {
                    this.drawSensorSegmentsRearTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.RTASEG_GROUP_4K, f2);
                }
            }
        } else if (bl2) {
            if (bl5) {
                this.drawSensorSegments(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_360_TRAILER, f2);
                if (bl6) {
                    this.drawSegmentsCameraBased(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_360_CB_TRAILER, color4b, f2);
                }
                if (bl4) {
                    this.drawSensorSegmentsFrontTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.FTASEG_GROUP_360, f2);
                }
            } else {
                this.drawSensorSegments(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_360, f2);
                if (bl6) {
                    this.drawSegmentsCameraBased(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_360_CB, color4b, f2);
                }
                if (bl4) {
                    this.drawSensorSegmentsFrontTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.FTASEG_GROUP_360, f2);
                }
                if (bl3) {
                    this.drawSensorSegmentsRearTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.RTASEG_GROUP_360, f2);
                }
            }
        } else if (bl5) {
            this.drawSensorSegments(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_8K_TRAILER, f2);
            this.drawSegmentsCameraBased(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_8K_CB_TRAILER, color4b, f2);
            if (bl4) {
                this.drawSensorSegmentsFrontTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.FTASEG_GROUP_8K, f2);
            }
        } else {
            this.drawSensorSegments(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_8K, f2);
            if (bl6) {
                this.drawSegmentsCameraBased(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.SENSEG_GROUP_8K_CB, color4b, f2);
            }
            if (bl4) {
                this.drawSensorSegmentsFrontTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.FTASEG_GROUP_8K, f2);
            }
            if (bl3) {
                this.drawSensorSegmentsRearTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, OPSModel.RTASEG_GROUP_8K, f2);
            }
        }
    }

    private void drawSensorSegments(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, float f2) {
        if (oPSConfigData != null && imageDrawableArray != null) {
            Arrays.fill(this.drawSensors, false);
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                ImageDrawable[] imageDrawableArray2;
                Color[] colorArray;
                int n;
                int[] nArray2;
                int n2 = nArray[i2];
                if (this.drawSensors[OPSUI$OPSUIHelper.isLogicalSensor(n2) ? OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n2) : n2] || (nArray2 = oPSModel.get_sensorStateValues()) == null || nArray2.length <= 0) continue;
                int n3 = n = OPSUI$OPSUIHelper.isLogicalSensor(n2) ? nArray2[OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n2)] : nArray2[n2];
                if (n < 0 || n > 3 || !OPSUI$OPSUIHelper.isSensorGroupAvailableBySensor(oPSModel, n2) || (colorArray = oPSModel.get_sensorStateColors()) == null || n < 0 || n >= colorArray.length) continue;
                Color color = colorArray[n];
                if (oPSModel.is_showTestMode()) {
                    ImageDrawable[] imageDrawableArray3;
                    int n4 = OPSUI$OPSUIHelper.mapRightToLeftSensor(OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n2));
                    ImageDrawable[] imageDrawableArray4 = imageDrawableArray3 = n4 >= 0 && n4 < imageDrawableArray.length ? imageDrawableArray[n4] : null;
                    if (imageDrawableArray3 == null) continue;
                    this.drawSensorsAtOnce(graphics3D, oPSModel, oPSConfigData, imageDrawableArray3, OPSUI$OPSUIHelper.mapSensorToConfigSectorId(n2), OPSUI$OPSUIHelper.isRightSideSensor(n2), color.getCurrentColor(), f2);
                    continue;
                }
                int[] nArray3 = oPSModel.get_sensorsSegmentValues();
                int n5 = OPSUI$OPSUIHelper.getSensorSegmentValue(nArray3, n2);
                short[] sArray = OPSUI$OPSUIHelper.getDataSet(oPSConfigData, n2, n5);
                if (sArray == null) continue;
                int n6 = OPSUI$OPSUIHelper.mapRightToLeftSensor(OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n2));
                ImageDrawable[] imageDrawableArray5 = imageDrawableArray2 = n6 >= 0 && n6 < imageDrawableArray.length ? imageDrawableArray[n6] : null;
                if (imageDrawableArray2 != null) {
                    this.drawSensorSegment(graphics3D, sArray, imageDrawableArray2, OPSUI$OPSUIHelper.isRightSideSensor(n2), OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData), color.getCurrentColor(), f2);
                }
                this.drawSensors[OPSUI$OPSUIHelper.isLogicalSensor((int)n2) ? OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor((int)n2) : n2] = true;
            }
        }
    }

    private void drawSensorSegmentsFrontTrafficAlert(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, float f2) {
        this.drawSensorSegmentsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, nArray, oPSModel.get_ftaStates(), 2, 3, oPSModel.get_ftaStateColors(), false, f2);
    }

    private void drawSensorSegmentsRearTrafficAlert(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, float f2) {
        this.drawSensorSegmentsTrafficAlert(graphics3D, oPSModel, oPSConfigData, imageDrawableArray, nArray, oPSModel.get_rtaStates(), 2, 3, oPSModel.get_rtaStateColors(), true, f2);
    }

    private void drawSensorSegmentsTrafficAlert(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[][] imageDrawableArray, int[] nArray, int[] nArray2, int n, int n2, Color[] colorArray, boolean bl, float f2) {
        if (oPSConfigData != null && imageDrawableArray != null) {
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                ImageDrawable[] imageDrawableArray2;
                short[] sArray;
                int n3;
                int n4 = nArray[i2];
                if (nArray2 == null || nArray2.length <= 0) continue;
                int n5 = n3 = OPSUI$OPSUIHelper.isLogicalSensor(n4) ? nArray2[OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n4)] : nArray2[n4];
                if (n3 < n || n3 > n2 || colorArray == null || n3 < 0 || n3 >= colorArray.length) continue;
                Color color = colorArray[n3];
                if (oPSModel.is_showTestMode()) {
                    ImageDrawable[] imageDrawableArray3;
                    int n6 = OPSUI$OPSUIHelper.mapRightToLeftSensor(OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(nArray[i2]));
                    ImageDrawable[] imageDrawableArray4 = imageDrawableArray3 = n6 >= 0 && n6 < imageDrawableArray.length ? imageDrawableArray[n6] : null;
                    if (imageDrawableArray3 == null) continue;
                    this.drawSensorsAtOnce(graphics3D, oPSModel, oPSConfigData, imageDrawableArray3, bl ? OPSUI$OPSUIHelper.mapSensorToConfigSectorIdRearTrafficAlert(nArray[i2]) : OPSUI$OPSUIHelper.mapSensorToConfigSectorIdFrontTrafficAlert(nArray[i2]), OPSUI$OPSUIHelper.isRightSideSensorTrafficAlert(n4), color.getCurrentColor(), f2);
                    continue;
                }
                short[] sArray2 = sArray = bl ? OPSUI$OPSUIHelper.getDataSetRearTrafficAlert(oPSConfigData, n4) : OPSUI$OPSUIHelper.getDataSetFrontTrafficAlert(oPSConfigData, n4);
                if (sArray == null) continue;
                int n7 = OPSUI$OPSUIHelper.isLogicalSensor(n4) ? OPSUI$OPSUIHelper.mapLogicalSensorToRealSensor(n4) : n4;
                ImageDrawable[] imageDrawableArray5 = imageDrawableArray2 = n7 >= 0 && n7 < imageDrawableArray.length ? imageDrawableArray[n7] : null;
                if (imageDrawableArray2 == null) continue;
                this.drawSensorSegment(graphics3D, sArray, imageDrawableArray2, OPSUI$OPSUIHelper.isRightSideSensorTrafficAlert(n4), OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData), color.getCurrentColor(), f2);
            }
        }
    }

    private void drawSensorsAtOnce(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, ImageDrawable[] imageDrawableArray, int n, boolean bl, Color4b color4b, float f2) {
        short[] sArray = null;
        for (int i2 = oPSConfigData.getSegmentsPerSector(n) - 1; i2 >= 0; --i2) {
            sArray = oPSConfigData.getSegmentDataById(n, i2);
            if (sArray == null) continue;
            this.drawSensorSegment(graphics3D, sArray, imageDrawableArray, bl, OPSUI$OPSUIHelper.getTranslationValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getTranslationValueY(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueX(oPSModel, oPSConfigData), OPSUI$OPSUIHelper.getScaleValueY(oPSModel, oPSConfigData), color4b, f2);
        }
    }

    private void drawTrack(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, Rectangle rectangle) {
        boolean bl = oPSModel.get_radiusRear() >= -16842752;
        this.buildTrackDrawer(graphics3D, oPSModel);
        if (bl) {
            this.drawTrack(graphics3D, oPSModel, oPSConfigData, this.trackDrawerStraight, rectangle);
        } else {
            this.drawTrack(graphics3D, oPSModel, oPSConfigData, this.trackDrawer, rectangle);
        }
    }

    private void drawTrack(Graphics3D graphics3D, OPSModel oPSModel, OPSConfigData oPSConfigData, OPSUI$TrackDrawer oPSUI$TrackDrawer, Rectangle rectangle) {
        if (!oPSModel.is_showRearOnly()) {
            switch (oPSModel.get_trackDisplay()) {
                case 1: 
                case 2: {
                    float f2 = OPSUI$TrackHelper.calculateTrackScaledRadius(oPSModel, this.trackValues);
                    float f3 = OPSUI$TrackHelper.calculateTrackWidth(oPSModel, this.trackValues);
                    this.trackCenterPoint = OPSUI$TrackHelper.calculateTrackCenterPoint(this.trackCenterPoint, oPSModel, this.trackValues, f2);
                    this.trackClipArea = OPSUI$TrackHelper.updateTrackClipArea(this.trackClipArea, rectangle, f2);
                    oPSUI$TrackDrawer.draw(this.trackClipArea, f3, this.trackCenterPoint.x, this.trackCenterPoint.y);
                    break;
                }
                case 0: {
                    this.trackClipArea = OPSUI$TrackHelper.updateTrackClipArea(this.trackClipArea, rectangle, 0.0f);
                    oPSUI$TrackDrawer.draw(this.trackClipArea, 0.0f, 0.0f, 0.0f);
                    break;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean drawContentOffscreen(Graphics3D graphics3D, OPSModel oPSModel, Rectangle rectangle, OPSConfigData oPSConfigData, Color4b color4b, float f2) {
        int n;
        boolean bl = oPSModel.is_showAreaView();
        boolean bl2 = oPSModel.is_showOPSMini();
        int n2 = bl && !bl2 ? -oPSModel.getAbsX() : 0;
        int n3 = n = bl && !bl2 ? -oPSModel.getAbsY() : 0;
        if (oPSModel.isInvalid() || this.contentDrawable == null || !this.contentDrawable.isValid() || this.hasAlphaChanged(oPSModel)) {
            int n4;
            int n5 = bl && !bl2 ? oPSModel.getView().get_width() : oPSModel.get_width();
            int n6 = n4 = bl && !bl2 ? oPSModel.getView().get_height() : oPSModel.get_height();
            if (!AbstractWidgetUI$OffscreenDrawableHelper.isOffscreenDrawableValid(this.contentDrawable, n5, n4)) {
                AbstractWidgetUI$OffscreenDrawableHelper.disposeOffscreenDrawable(this.contentDrawable);
                this.contentDrawable = AbstractWidgetUI$OffscreenDrawableHelper.createOffscreenDrawable(graphics3D, n5, n4, true);
                if (this.contentDrawable == null) {
                    if (LOGGER.isTraceEnabled(128)) {
                        LOGGER.warn(128).append("Unable to create an off-screen drawable for the track!").log();
                    }
                    return false;
                }
            }
            AbstractWidgetUI$OffscreenDrawableHelper.prepare(graphics3D, this.contentDrawable, rectangle);
            try {
                if (bl) {
                    graphics3D.translateMatrix(0, -n2, -n, 0.0f);
                }
                this.drawContent(graphics3D, oPSModel, rectangle, oPSConfigData, color4b, 1.0f);
            }
            finally {
                AbstractWidgetUI$OffscreenDrawableHelper.restore(graphics3D, this.contentDrawable, rectangle);
            }
        }
        if (this.contentDrawable != null) {
            this.contentDrawable.setAlpha(f2);
            this.trackBlendColor.setAlpha(f2);
            graphics3D.setBlendColor(this.trackBlendColor);
            int[] nArray = new int[]{graphics3D.getBlendFactorSourceRGB(), graphics3D.getBlendFactorDestinationRGB(), graphics3D.getBlendFactorSourceAlpha(), graphics3D.getBlendFactorDestinationAlpha()};
            graphics3D.setBlendFactorsSeparate(13, 7, 1, 7);
            this.contentDrawable.draw(n2, n);
            graphics3D.setBlendFactorsSeparate(nArray[0], nArray[1], nArray[2], nArray[3]);
            return true;
        }
        return false;
    }

    private void drawContent(Graphics3D graphics3D, OPSModel oPSModel, Rectangle rectangle, OPSConfigData oPSConfigData, Color4b color4b, float f2) {
        this.handleMiniMode(graphics3D, oPSModel);
        this.drawBackgrounds(graphics3D, oPSModel, oPSConfigData, this.backgroundTextureDrawables, rectangle, this.childClipArea, rectangle, color4b, f2);
        this.drawSensorFailures(graphics3D, oPSModel, oPSConfigData, this.failureTextureDrawables, color4b, f2);
        this.drawSensorSegments(graphics3D, oPSModel, oPSConfigData, this.segmentsTextureDrawables, rectangle, this.childClipArea, rectangle, color4b, f2);
        this.drawOverlays(graphics3D, oPSModel, oPSConfigData, this.backgroundTextureDrawables, rectangle, this.childClipArea, rectangle, color4b, f2);
        this.drawRimProtections(graphics3D, oPSModel, oPSConfigData, rectangle, this.childClipArea, rectangle, f2);
        this.drawTrack(graphics3D, oPSModel, oPSConfigData, rectangle);
        this.drawAreaView(graphics3D, oPSModel, oPSConfigData, color4b, f2);
        this.drawCarImage(graphics3D, oPSModel, oPSConfigData, f2);
        if (oPSModel.is_showTestMode()) {
            this.drawDebugTrackValues(graphics3D, oPSModel, this.trackValues);
        }
    }

    private boolean hasAlphaChanged(OPSModel oPSModel) {
        int n = oPSModel.getView().get_alpha();
        if (n != this.lastAlpha) {
            this.lastAlpha = n;
            return true;
        }
        return false;
    }

    private void buildTrackDrawer(Graphics3D graphics3D, OPSModel oPSModel) {
        if (this.trackDrawer == null || !(this.trackDrawer instanceof OPSUI$AlphaTrackDrawer)) {
            if (oPSModel.get_trackDisplay() != 0) {
                this.trackCurveDrawable = OPSUI$ImageHelper.createTrackCurveDrawable(graphics3D, this.trackCurveDrawable, oPSModel);
                this.trackImageDrawable = OPSUI$ImageHelper.createTrackImageDrawable(graphics3D, this.trackImageDrawable, oPSModel);
                this.trackAlphaImageDrawable = OPSUI$ImageHelper.createTrackAlphaImageDrawable(graphics3D, this.trackAlphaImageDrawable, oPSModel);
                this.trackDrawer = new OPSUI$DefaultBezierTrackDrawer(graphics3D, oPSModel, this.trackValues, this.trackCurveDrawable);
                this.trackDrawerStraight = new OPSUI$RectangleTrackDrawer(graphics3D, oPSModel, this.trackImageDrawable, this.trackValues);
                if (!oPSModel.is_showTestMode()) {
                    this.trackDrawer = new OPSUI$ClippedTrackDrawer(graphics3D, this.trackDrawer, oPSModel, this.trackValues);
                }
            } else {
                this.trackDrawer = this.trackDrawerStraight = new OPSUI$1(this);
            }
            if (this.trackAlphaImageDrawable != null) {
                this.trackDrawer = new OPSUI$AlphaTrackDrawer(graphics3D, oPSModel, this.trackDrawer, this.trackAlphaImageDrawable);
                this.trackDrawerStraight = new OPSUI$AlphaTrackDrawer(graphics3D, oPSModel, this.trackDrawerStraight, this.trackAlphaImageDrawable);
            }
        }
    }

    private void drawDebugTrackValues(Graphics3D graphics3D, OPSModel oPSModel, Rectangle[] rectangleArray) {
        if (!oPSModel.is_showRearOnly()) {
            int n;
            for (n = rectangleArray.length - 1; n >= 0; --n) {
                this.updateTrackValueDrawables(graphics3D, oPSModel, rectangleArray, n);
                this.debugTrackValueOffsetDrawable.setColor(Color4f.MAGENTA);
                this.debugTrackValueOffsetDrawable.draw();
                this.debugTrackValueDrawable.setColor(Color4f.CYAN);
                this.debugTrackValueDrawable.draw();
            }
            this.drawDebugLine(graphics3D, rectangleArray[1].x, rectangleArray[1].y, rectangleArray[2].x - 1, rectangleArray[2].y, Color4f.MAGENTA);
            if (oPSModel.is_direction()) {
                n = rectangleArray[0].y + 2 * (rectangleArray[2].y - rectangleArray[0].y) - 1;
                this.drawDebugLine(graphics3D, rectangleArray[0].x, n, rectangleArray[2].x, rectangleArray[2].y + 1, Color4f.ORANGE);
            } else {
                this.drawDebugLine(graphics3D, rectangleArray[0].x, rectangleArray[0].y + 1, rectangleArray[2].x, rectangleArray[2].y, Color4f.ORANGE);
            }
        }
    }

    private void updateTrackValueDrawables(Graphics3D graphics3D, OPSModel oPSModel, Rectangle[] rectangleArray, int n) {
        int n2 = rectangleArray[n].y;
        int n3 = rectangleArray[n].height;
        if (n == 0 && !oPSModel.is_direction()) {
            n3 *= -1;
        } else if (n == 0 && oPSModel.is_direction()) {
            n2 += 2 * (rectangleArray[2].y - rectangleArray[0].y) - 1;
            --n3;
        }
        this.debugTrackValueOffsetDrawable = this.updateRectangleDrawable(graphics3D, this.debugTrackValueOffsetDrawable, rectangleArray[n].x - 1, n2 + 1, 1, n3);
        this.debugTrackValueDrawable = this.updateRectangleDrawable(graphics3D, this.debugTrackValueDrawable, rectangleArray[n].x - 2, n2 - 1, 3, 3);
    }

    private RectangleDrawable updateRectangleDrawable(Graphics3D graphics3D, RectangleDrawable rectangleDrawable, int n, int n2, int n3, int n4) {
        if (rectangleDrawable == null) {
            rectangleDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
        }
        rectangleDrawable.set(n, n2, n3, n4);
        return rectangleDrawable;
    }

    private void handleMiniMode(Graphics3D graphics3D, OPSModel oPSModel) {
        if (oPSModel.is_showOPSMini()) {
            graphics3D.translateMatrix(0, oPSModel.get_width() >> 1, oPSModel.get_height() >> 1, 0.0f);
            graphics3D.rotateMatrix(0, 46146, 0.0f, 0.0f, 1.0f);
            graphics3D.translateMatrix(0, -oPSModel.get_height() >> 1, -oPSModel.get_width() >> 1, 0.0f);
        }
    }

    private void updateChildClippingArea(OPSModel oPSModel) {
        if (this.childClipArea == null) {
            this.childClipArea = new Rectangle();
        }
        if (oPSModel.is_showAreaView() && !oPSModel.is_showOPSMini()) {
            this.childClipArea.setBounds(0, 0, oPSModel.getView().get_width(), oPSModel.getView().get_height());
        } else {
            this.childClipArea.setBounds(0, 0, oPSModel.get_width(), oPSModel.get_height());
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        OPSModel oPSModel = (OPSModel)widgetModel;
        OPSConfigData oPSConfigData = (OPSConfigData)oPSModel.getConfigData();
        if (oPSConfigData != null && oPSConfigData.isDeserialized()) {
            this.updateChildClippingArea(oPSModel);
            this.backgroundTextureDrawables = OPSUI$ImageHelper.createBackgroundTextureImageDrawables(graphics3D, this.backgroundTextureDrawables, oPSModel);
            this.failureTextureDrawables = OPSUI$ImageHelper.createFailureTextureImageDrawables(graphics3D, this.failureTextureDrawables, oPSModel);
            this.segmentsTextureDrawables = OPSUI$ImageHelper.createSegmentsTextureImageDrawables(graphics3D, this.segmentsTextureDrawables, oPSModel);
            this.trackValues = OPSUI$TrackHelper.initializeTrackValues(this.trackValues, oPSConfigData);
            this.drawContentOffscreen(graphics3D, oPSModel, rectangle2, oPSConfigData, Color4b.WHITE, f2);
            if (this.errMsgAlreadyLogged) {
                this.errMsgAlreadyLogged = false;
            }
        } else {
            if (IS_DEVELOPMENT_BUILD) {
                super.paintUnavailable(graphics3D, widgetModel, "Missing/unexpected configuration file");
            }
            if (!this.errMsgAlreadyLogged) {
                LogMessage logMessage = LOGGER.error(128);
                logMessage.append("Widget '").append(oPSModel.getQualifiedName()).append("': Unable to paint widget, because of the missing/unexpected configuration file. '").log();
                this.errMsgAlreadyLogged = true;
            }
        }
    }
}

