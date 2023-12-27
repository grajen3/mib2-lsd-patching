/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.GuidanceModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.WidgetUI;
import java.io.IOException;

public final class GuidanceUI
extends AbstractWidgetUI
implements WidgetUI {
    public static final boolean GUIDANCE_DEBUG = System.getProperty("de.vw.mib.widgets.guidancedebug") != null;
    private ScaleImageDrawable[] sideStreetDrawables;
    private ScaleImageDrawable distanceBarOutlineDrawable;
    private ScaleImageDrawable distanceBarFillingDrawable;
    private ScaleImageDrawable mainElementDrawable;
    private ScaleImageDrawable zLevelDrawable;

    @Override
    public void deInit() {
        GuidanceUI.disposeDrawable(this.distanceBarFillingDrawable);
        this.distanceBarFillingDrawable = null;
        GuidanceUI.disposeDrawable(this.distanceBarOutlineDrawable);
        this.distanceBarOutlineDrawable = null;
        GuidanceUI.disposeDrawables(this.sideStreetDrawables);
        this.sideStreetDrawables = null;
        GuidanceUI.disposeDrawable(this.mainElementDrawable);
        this.mainElementDrawable = null;
        GuidanceUI.disposeDrawable(this.zLevelDrawable);
        this.zLevelDrawable = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        GuidanceModel guidanceModel = (GuidanceModel)widgetModel;
        guidanceModel.validateManeuver();
        if (guidanceModel.getMainElementImageIndex() != -1) {
            this.drawSideStreets(graphics3D, guidanceModel, f2);
            this.drawDistanceBarOutline(graphics3D, guidanceModel, f2);
            this.drawDistanceBarFilling(graphics3D, guidanceModel, f2);
            this.drawMainElement(graphics3D, guidanceModel, f2);
            this.drawZLevel(graphics3D, guidanceModel, f2);
        }
    }

    private void drawMainElement(Graphics3D graphics3D, GuidanceModel guidanceModel, float f2) {
        Object object;
        try {
            this.updateMainElementDrawable(graphics3D, guidanceModel);
            if (this.mainElementDrawable != null) {
                object = guidanceModel.get_mainElementImagesPositions();
                int n = guidanceModel.getMainElementImageIndex();
                Point point = object[n];
                Color4b color4b = this.getElementColor(guidanceModel);
                this.mainElementDrawable.setColor(color4b);
                this.mainElementDrawable.setAlpha(f2);
                this.mainElementDrawable.draw(point.x, point.y);
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(256);
            logMessage.append("Widget '").append(guidanceModel.getQualifiedName()).append("': Unable to load main element image: ").append(iOException).log();
        }
        if (GUIDANCE_DEBUG) {
            object = new StringBuilder();
            ((StringBuilder)object).append("M: 0x").append(Integer.toHexString(guidanceModel.get_mainElement()).toUpperCase());
            ((StringBuilder)object).append(" | D: 0x").append(Integer.toHexString(guidanceModel.get_direction()).toUpperCase());
            ((StringBuilder)object).append(" | Img: ").append(guidanceModel.getMainElementImageIndex());
            this.drawDebugText(graphics3D, 0, 0, ((StringBuilder)object).toString());
        }
    }

    private void drawSideStreets(Graphics3D graphics3D, GuidanceModel guidanceModel, float f2) {
        try {
            IntSet intSet = guidanceModel.getSideStreetImageIndices();
            if (intSet.size() > 0) {
                this.updateSideStreetsDrawables(graphics3D, guidanceModel);
                Point[] pointArray = guidanceModel.get_sideStreetImagesPositions();
                int n = 0;
                IntIterator intIterator = intSet.iterator();
                while (intIterator.hasNext()) {
                    int n2 = intIterator.next();
                    Point point = pointArray[n2];
                    if (this.sideStreetDrawables[n] != null) {
                        this.sideStreetDrawables[n].setAlpha(f2);
                        this.sideStreetDrawables[n].draw(point.x, point.y);
                    }
                    ++n;
                }
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(256);
            logMessage.append("Widget '").append(guidanceModel.getQualifiedName()).append("': Unable to load side street images: ").append(iOException).log();
        }
    }

    private void drawZLevel(Graphics3D graphics3D, GuidanceModel guidanceModel, float f2) {
        try {
            this.updateZLevelDrawable(graphics3D, guidanceModel);
            if (this.zLevelDrawable != null) {
                Point point = guidanceModel.get_zLevelImagesPosition();
                this.zLevelDrawable.setAlpha(f2);
                this.zLevelDrawable.draw(point.x, point.y);
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(256);
            logMessage.append("Widget '").append(guidanceModel.getQualifiedName()).append("': Unable to load zLevel image: ").append(iOException).log();
        }
    }

    private void drawDistanceBarOutline(Graphics3D graphics3D, GuidanceModel guidanceModel, float f2) {
        try {
            this.updateDistanceBarOutlineDrawable(graphics3D, guidanceModel);
            if (this.distanceBarOutlineDrawable != null) {
                Point[] pointArray = guidanceModel.get_distanceImagesPositions();
                int n = guidanceModel.getDistanceImageIndex();
                Point point = pointArray[n];
                Color4b color4b = this.getElementColor(guidanceModel);
                this.distanceBarOutlineDrawable.setColor(color4b);
                this.distanceBarOutlineDrawable.setAlpha(f2);
                this.distanceBarOutlineDrawable.draw(point.x, point.y);
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(256);
            logMessage.append("Widget '").append(guidanceModel.getQualifiedName()).append("': Unable to load distance bar image: ").append(iOException).log();
        }
        if (GUIDANCE_DEBUG) {
            this.drawDebugText(graphics3D, 0, 12, new StringBuffer().append("DisVis: ").append(guidanceModel.is_distanceVisible()).append(" | DisVal: ").append(guidanceModel.get_currentDistancePercent()).toString());
        }
    }

    private void drawDistanceBarFilling(Graphics3D graphics3D, GuidanceModel guidanceModel, float f2) {
        try {
            this.updateDistanceBarFillingDrawable(graphics3D, guidanceModel);
            if (this.distanceBarFillingDrawable != null) {
                Point[] pointArray = guidanceModel.get_distanceImagesPositions();
                int n = guidanceModel.getBarGraphFillingIndex();
                this.distanceBarFillingDrawable.setAlpha(f2);
                this.distanceBarFillingDrawable.draw(pointArray[n].x, pointArray[n].y);
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(256);
            logMessage.append("Widget '").append(guidanceModel.getQualifiedName()).append("': Unable to load distance bar filling image: ").append(iOException).log();
        }
        if (GUIDANCE_DEBUG) {
            this.drawDebugText(graphics3D, 0, 12, new StringBuffer().append("DisVis: ").append(guidanceModel.is_distanceVisible()).append(" | DisVal: ").append(guidanceModel.get_currentDistancePercent()).toString());
        }
    }

    private void updateDistanceBarFillingDrawable(Graphics3D graphics3D, GuidanceModel guidanceModel) {
        if (guidanceModel.isInvalid()) {
            int n;
            Image[] imageArray = guidanceModel.get_distanceImages();
            int n2 = guidanceModel.getBarGraphFillingIndex();
            int n3 = n = guidanceModel.is_distanceVisible() ? guidanceModel.get_currentDistancePercent() : 100;
            if (imageArray != null && n2 != -1 && n2 < imageArray.length) {
                this.distanceBarFillingDrawable = GuidanceUI.updateScaleImageDrawable(graphics3D, guidanceModel, this.distanceBarFillingDrawable, imageArray[n2]);
                if (this.distanceBarFillingDrawable != null) {
                    int n4 = Math.round((float)this.distanceBarFillingDrawable.getHeight() / 51266 * (float)n);
                    this.distanceBarFillingDrawable.setHeight(n4);
                }
            } else {
                GuidanceUI.disposeDrawable(this.distanceBarFillingDrawable);
                this.distanceBarFillingDrawable = null;
            }
        }
    }

    private void updateDistanceBarOutlineDrawable(Graphics3D graphics3D, GuidanceModel guidanceModel) {
        if (guidanceModel.isInvalid()) {
            Image[] imageArray = guidanceModel.get_distanceImages();
            int n = guidanceModel.getDistanceImageIndex();
            if (imageArray != null && n != -1) {
                this.distanceBarOutlineDrawable = GuidanceUI.updateScaleImageDrawable(graphics3D, guidanceModel, this.distanceBarOutlineDrawable, imageArray[n]);
            } else {
                GuidanceUI.disposeDrawable(this.distanceBarOutlineDrawable);
                this.distanceBarOutlineDrawable = null;
            }
        }
    }

    private void updateMainElementDrawable(Graphics3D graphics3D, GuidanceModel guidanceModel) {
        if (guidanceModel.isInvalid()) {
            Image[] imageArray = guidanceModel.get_mainElementImages();
            int n = guidanceModel.getMainElementImageIndex();
            if (n != -1 && n <= imageArray.length) {
                this.mainElementDrawable = GuidanceUI.updateScaleImageDrawable(graphics3D, guidanceModel, this.mainElementDrawable, imageArray[n]);
            } else {
                GuidanceUI.disposeDrawable(this.mainElementDrawable);
                this.mainElementDrawable = null;
            }
        }
    }

    private void updateSideStreetsDrawables(Graphics3D graphics3D, GuidanceModel guidanceModel) {
        if (guidanceModel.isInvalid()) {
            IntSet intSet = guidanceModel.getSideStreetImageIndices();
            Image[] imageArray = guidanceModel.get_sideStreetImages();
            if (imageArray == null || imageArray.length != intSet.size()) {
                GuidanceUI.disposeDrawables(this.sideStreetDrawables);
                this.sideStreetDrawables = new ScaleImageDrawable[intSet.size()];
            }
            if (imageArray != null) {
                int n = 0;
                IntIterator intIterator = intSet.iterator();
                while (intIterator.hasNext()) {
                    int n2 = intIterator.next();
                    this.sideStreetDrawables[n] = GuidanceUI.updateScaleImageDrawable(graphics3D, guidanceModel, this.sideStreetDrawables[n], imageArray[n2]);
                    ++n;
                }
            }
        }
    }

    private void updateZLevelDrawable(Graphics3D graphics3D, GuidanceModel guidanceModel) {
        if (guidanceModel.isInvalid()) {
            int n = guidanceModel.getZLevelImageIndex();
            Image[] imageArray = guidanceModel.get_zLevelImages();
            if (n != -1 && n <= imageArray.length) {
                this.zLevelDrawable = GuidanceUI.updateScaleImageDrawable(graphics3D, guidanceModel, this.zLevelDrawable, imageArray[n]);
            } else {
                GuidanceUI.disposeDrawable(this.zLevelDrawable);
                this.zLevelDrawable = null;
            }
        }
    }

    private Color4b getElementColor(GuidanceModel guidanceModel) {
        return guidanceModel.is_distanceVisible() ? guidanceModel.getMainElementColor() : Color4b.WHITE;
    }
}

