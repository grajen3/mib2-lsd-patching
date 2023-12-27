/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.LaneGuidanceModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import java.io.IOException;
import java.util.Arrays;

public class LaneGuidanceUI
extends AbstractImageUI
implements PropertyChangedListener {
    private static final int MARKING_LEFT;
    private static final int MARKING_MIDDLE;
    private static final int MARKING_RIGHT;
    private static final int MARKING_COUNT;
    private static final int[] EMPTY_DIRECTIONS_INFOS;
    private static final int[] LANE_INFO_TYPES_TO_TRIM;
    private Point currentPosition;
    protected int[] laneDirections;
    private ScaleImageDrawable[] laneDrawables;
    protected int[] laneInfos;
    protected int leftMarking;
    private ScaleImageDrawable[] markingDrawables;
    protected int rightMarking;

    @Override
    public void init() {
        super.init();
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.addPropertyChangedListener(this);
        }
    }

    @Override
    public void deInit() {
        LaneGuidanceUI.disposeDrawables(this.laneDrawables);
        this.laneDrawables = null;
        LaneGuidanceUI.disposeDrawables(this.markingDrawables);
        this.markingDrawables = null;
        this.laneDirections = null;
        this.laneInfos = null;
        this.leftMarking = 0;
        this.rightMarking = 0;
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.removePropertyChangedListener(this);
        }
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.currentPosition = new Point();
    }

    protected Image getLaneImage(LaneGuidanceModel laneGuidanceModel, int n, int n2) {
        Image[] imageArray;
        int n3 = 14;
        if (LaneGuidanceModel.LANE_DIRECTION_INFO_INDEX__MAPPING.containsKey(n)) {
            imageArray = (Image[])LaneGuidanceModel.LANE_DIRECTION_INFO_INDEX__MAPPING.get(n);
            if (imageArray.containsKey(n2)) {
                n3 = imageArray.get(n2);
            } else {
                LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': unknown 'laneInfo=").append(n2).append("'!").log();
            }
        } else {
            LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': unknown 'laneDirection=").append(n).append("'!").log();
        }
        imageArray = laneGuidanceModel.get_laneImages();
        if (n3 >= 0 && imageArray != null && n3 < imageArray.length && imageArray[n3] != null) {
            return imageArray[n3];
        }
        LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': no image defined at 'laneImages[").append(n3).append("]'!").log();
        n3 = 14;
        if (n3 >= 0 && imageArray != null && n3 < imageArray.length && imageArray[n3] != null) {
            return imageArray[n3];
        }
        return null;
    }

    private int calcDistanceToFirstOccurrenceAheadOrder(int[] nArray, int[] nArray2) {
        int n = -1;
        if (nArray2 != null && nArray2.length > 1) {
            edu.emory.mathcs.backport.java.util.Arrays.sort(nArray2);
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2;
            int n3 = nArray2 != null && nArray2.length > 0 ? Arrays.binarySearch(nArray2, nArray[i2]) : (n2 = nArray[i2] > 0 ? i2 : -1);
            if (n2 < 0) continue;
            n = i2;
            break;
        }
        return n;
    }

    private int calcDistanceToFirstOccurrenceReverseOrder(int[] nArray, int[] nArray2) {
        int n = -1;
        if (nArray2 != null && nArray2.length > 1) {
            edu.emory.mathcs.backport.java.util.Arrays.sort(nArray2);
        }
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            int n2;
            int n3 = nArray2 != null && nArray2.length > 0 ? Arrays.binarySearch(nArray2, nArray[i2]) : (n2 = nArray[i2] > 0 ? i2 : -1);
            if (n2 < 0) continue;
            n = nArray.length - 1 - i2;
            break;
        }
        return n;
    }

    private ScaleImageDrawable createDrawable(Graphics3D graphics3D, Image image) {
        BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(image);
        if (bufferImage != null) {
            ScaleImageDrawable scaleImageDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
            scaleImageDrawable.setImage(bufferImage);
            scaleImageDrawable.setScaleImage(image.getCurrentImage());
            scaleImageDrawable.setWidth(bufferImage.getWidth());
            scaleImageDrawable.setHeight(bufferImage.getHeight());
            return scaleImageDrawable;
        }
        return null;
    }

    private ScaleImageDrawable[] createLaneDrawables(Graphics3D graphics3D, LaneGuidanceModel laneGuidanceModel, int[] nArray, int[] nArray2) {
        int n = Math.min(nArray.length, nArray2.length);
        ScaleImageDrawable[] scaleImageDrawableArray = new ScaleImageDrawable[n];
        for (int i2 = 0; i2 < n; ++i2) {
            Image image = this.getLaneImage(laneGuidanceModel, nArray[i2], nArray2[i2]);
            if (image == null) continue;
            try {
                scaleImageDrawableArray[i2] = this.createDrawable(graphics3D, image);
                continue;
            }
            catch (IOException iOException) {
                LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': Unable to load image! ").attachThrowable(iOException).log();
            }
        }
        return scaleImageDrawableArray;
    }

    private ScaleImageDrawable[] createMarkingDrawables(Graphics3D graphics3D, LaneGuidanceModel laneGuidanceModel, int n, int n2) {
        Image image;
        ScaleImageDrawable[] scaleImageDrawableArray = new ScaleImageDrawable[3];
        Image[] imageArray = laneGuidanceModel.get_laneMarkingImages();
        if (imageArray != null && imageArray.length > 0) {
            int n3;
            int n4 = this.getMarkingImageIndex(n, true);
            if (n4 >= 0 && n4 < imageArray.length) {
                try {
                    scaleImageDrawableArray[0] = this.createDrawable(graphics3D, imageArray[n4]);
                }
                catch (IOException iOException) {
                    LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': Unable to load left marking image! ").attachThrowable(iOException).log();
                }
            }
            if ((n3 = this.getMarkingImageIndex(n2, false)) >= 0 && n3 < imageArray.length) {
                try {
                    scaleImageDrawableArray[2] = this.createDrawable(graphics3D, imageArray[n3]);
                }
                catch (IOException iOException) {
                    LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': Unable to load right marking image! ").attachThrowable(iOException).log();
                }
            }
        }
        if ((image = laneGuidanceModel.get_laneSeparatorImage()) != null) {
            try {
                scaleImageDrawableArray[1] = this.createDrawable(graphics3D, image);
            }
            catch (IOException iOException) {
                LOGGER.warn(256).append("Widget '").append(laneGuidanceModel.getQualifiedName()).append("': Unable to load separator image! ").attachThrowable(iOException).log();
            }
        }
        return scaleImageDrawableArray;
    }

    private void determineToBePaintedLanesAndMarkings(Graphics3D graphics3D, LaneGuidanceModel laneGuidanceModel) {
        int n = laneGuidanceModel.get_numberOfVisibleLanes();
        int[] nArray = laneGuidanceModel.get_laneDirection();
        int[] nArray2 = laneGuidanceModel.get_laneInfo();
        int[] nArray3 = laneGuidanceModel.get_laneMarkingLeft();
        int[] nArray4 = laneGuidanceModel.get_laneMarkingRight();
        this.laneDirections = nArray != null ? nArray : EMPTY_DIRECTIONS_INFOS;
        this.laneInfos = nArray2 != null ? nArray2 : EMPTY_DIRECTIONS_INFOS;
        this.leftMarking = nArray3 != null && nArray3.length > 0 ? nArray3[0] : 0;
        int n2 = this.rightMarking = nArray4 != null && nArray4.length > 0 ? nArray4[nArray4.length - 1] : 0;
        if (this.laneInfos.length > n) {
            this.trimVisibleLanes(laneGuidanceModel, this.laneInfos);
        }
        this.markingDrawables = this.createMarkingDrawables(graphics3D, laneGuidanceModel, this.leftMarking, this.rightMarking);
        this.laneDrawables = this.createLaneDrawables(graphics3D, laneGuidanceModel, this.laneDirections, this.laneInfos);
    }

    private int getMarkingImageIndex(int n, boolean bl) {
        int n2 = -1;
        switch (n) {
            case 2: {
                n2 = bl ? 2 : 3;
                break;
            }
            case 1: {
                n2 = bl ? 0 : 1;
                break;
            }
        }
        return n2;
    }

    @Override
    protected final void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        LaneGuidanceModel laneGuidanceModel = (LaneGuidanceModel)widgetModel;
        if (laneGuidanceModel.get_numberOfVisibleLanes() <= 0) {
            return;
        }
        this.currentPosition.setLocation(0, 0);
        if (this.markingDrawables == null || this.laneDrawables == null) {
            this.determineToBePaintedLanesAndMarkings(graphics3D, laneGuidanceModel);
        }
        if (this.markingDrawables != null && 0 < this.markingDrawables.length) {
            this.paintDrawableByPoint(this.markingDrawables[0], this.currentPosition, f2);
        }
        if (this.markingDrawables != null && 1 < this.markingDrawables.length) {
            this.paintLanesAndSeparators(this.laneDrawables, this.markingDrawables[1], this.currentPosition, f2);
        }
        if (this.markingDrawables != null && 2 < this.markingDrawables.length) {
            this.paintDrawableByPoint(this.markingDrawables[2], this.currentPosition, f2);
        }
    }

    protected final void paintDrawableByPoint(ScaleImageDrawable scaleImageDrawable, Point point, float f2) {
        if (scaleImageDrawable != null) {
            scaleImageDrawable.setAlpha(f2);
            scaleImageDrawable.draw(point.x, point.y);
            point.x += scaleImageDrawable.getWidth();
        }
    }

    protected final void paintLanesAndSeparators(ScaleImageDrawable[] scaleImageDrawableArray, ScaleImageDrawable scaleImageDrawable, Point point, float f2) {
        if (scaleImageDrawableArray != null) {
            for (int i2 = 0; i2 < scaleImageDrawableArray.length; ++i2) {
                ScaleImageDrawable scaleImageDrawable2 = scaleImageDrawableArray[i2];
                if (scaleImageDrawable2 == null) continue;
                this.paintDrawableByPoint(scaleImageDrawable2, point, f2);
                if (i2 >= scaleImageDrawableArray.length - 1 || scaleImageDrawable == null) continue;
                this.paintDrawableByPoint(scaleImageDrawable, point, f2);
            }
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        boolean bl = false;
        boolean bl2 = false;
        switch (n) {
            case 20: 
            case 21: 
            case 22: {
                bl = true;
                bl2 = true;
                break;
            }
            case 27: {
                bl = true;
                bl2 = true;
                break;
            }
            case 23: 
            case 24: 
            case 25: {
                bl2 = true;
                break;
            }
            default: {
                return;
            }
        }
        if (bl && this.laneDrawables != null) {
            LaneGuidanceUI.disposeDrawables(this.laneDrawables);
            this.laneDrawables = null;
        }
        if (bl2 && this.markingDrawables != null) {
            LaneGuidanceUI.disposeDrawables(this.markingDrawables);
            this.markingDrawables = null;
        }
    }

    protected void trimVisibleLanes(LaneGuidanceModel laneGuidanceModel, int[] nArray) {
        this.trimVisibleLanes(laneGuidanceModel, nArray, LANE_INFO_TYPES_TO_TRIM, LANE_INFO_TYPES_TO_TRIM, -65536);
    }

    protected final void trimVisibleLanes(LaneGuidanceModel laneGuidanceModel, int[] nArray, int[] nArray2, int[] nArray3, int n) {
        boolean bl;
        int n2 = laneGuidanceModel.get_numberOfVisibleLanes();
        int n3 = this.calcDistanceToFirstOccurrenceAheadOrder(nArray, nArray2);
        int n4 = this.calcDistanceToFirstOccurrenceReverseOrder(nArray, nArray3);
        boolean bl2 = bl = n3 >= n2 && n4 >= n2;
        if (bl) {
            int n5 = (int)Math.ceil((double)n2 * 0.5);
            int n6 = n2 - n5;
            int n7 = (int)((double)(this.laneInfos.length - 1) * 0.5);
            if (n7 + n5 <= this.laneInfos.length - 1 - n4) {
                n7 = this.laneInfos.length - 1 - n4;
            } else if (n7 - n6 >= n3) {
                n7 = n3;
            }
            int n8 = Math.min(n7 + (n5 - 1), this.laneInfos.length - 1);
            int n9 = Util.clamp(n7 - n6, 0, n8);
            this.laneDirections = edu.emory.mathcs.backport.java.util.Arrays.copyOfRange(this.laneDirections, n9, n8 + 1);
            this.laneInfos = edu.emory.mathcs.backport.java.util.Arrays.copyOfRange(this.laneInfos, n9, n8 + 1);
            this.laneInfos[0] = n;
            this.leftMarking = 2;
            this.laneInfos[this.laneInfos.length - 1] = n;
            this.rightMarking = 2;
        } else if (n3 >= n4) {
            int n10 = this.laneInfos.length - 1;
            int n11 = Util.clamp(n10 - (n2 - 1), 0, n10);
            boolean bl3 = false;
            if (n11 == n10 - n4) {
                --n11;
                --n10;
                bl3 = true;
            }
            this.laneDirections = edu.emory.mathcs.backport.java.util.Arrays.copyOfRange(this.laneDirections, n11, n10 + 1);
            this.laneInfos = edu.emory.mathcs.backport.java.util.Arrays.copyOfRange(this.laneInfos, n11, n10 + 1);
            this.laneInfos[0] = n;
            this.leftMarking = 2;
            if (bl3) {
                this.laneInfos[this.laneInfos.length - 1] = n;
                this.rightMarking = 2;
            }
            if (n2 == 1) {
                this.rightMarking = 2;
            }
        } else if (n3 < n4) {
            int n12 = 0;
            int n13 = Util.clamp(n12 + (n2 - 1), 0, this.laneInfos.length - 1);
            boolean bl4 = false;
            if (n13 == n12 + n3) {
                ++n12;
                ++n13;
                bl4 = true;
            }
            this.laneDirections = edu.emory.mathcs.backport.java.util.Arrays.copyOfRange(this.laneDirections, n12, n13 + 1);
            this.laneInfos = edu.emory.mathcs.backport.java.util.Arrays.copyOfRange(this.laneInfos, n12, n13 + 1);
            this.laneInfos[this.laneInfos.length - 1] = n;
            this.rightMarking = 2;
            if (bl4) {
                this.laneInfos[0] = n;
                this.leftMarking = 2;
            }
            if (n2 == 1) {
                this.leftMarking = 2;
            }
        }
    }

    static {
        EMPTY_DIRECTIONS_INFOS = new int[0];
        LANE_INFO_TYPES_TO_TRIM = new int[]{1, 2};
    }
}

