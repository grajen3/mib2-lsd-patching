/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.TouchArea$BezierSplineTrajectory;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.TouchAreaModel$ProximityDataStorage;
import de.vw.mib.widgets.models.TouchAreaModel$TouchDataStorage;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.TouchAreaDiagUI;
import java.util.ArrayList;
import java.util.List;

public class TouchArea
extends AbstractWidget
implements TouchAreaModel {
    private static final boolean SHOW_TOUCH_TRAJECTORIES = System.getProperty("de.vw.mib.widgets.toucharea.trajectories") != null;
    private static final int MAXIMUM_TRAJECTORY_COUNT;
    private static final int MAXIMUM_KNOT_COUNT;
    private int valueMinX;
    private int valueMaxX;
    private int valueMinY;
    private int valueMaxY;
    private Color touchTrajectoriesColor;
    private int touchTrajectoriesLineWidth;
    private Image touchTrajectoriesImage;
    private int dragThreshold;
    private int dragThresholdMode;
    private int touchForwardingMode;
    private List touchTrajectories;
    private TouchArea$BezierSplineTrajectory currentTouchTrajectory;
    private boolean rebuildTouchTrajectory;
    private int mode;
    private int duration;
    private TouchAreaModel$ProximityDataStorage proximityDataStorage;
    private TouchAreaModel$TouchDataStorage touchDataStorage;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$TouchAreaUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$TouchAreaDiagUI;

    @Override
    protected void reset() {
        super.reset();
        this.touchTrajectories = null;
        this.currentTouchTrajectory = null;
        this.proximityDataStorage = new TouchAreaModel$ProximityDataStorage();
        this.touchDataStorage = new TouchAreaModel$TouchDataStorage();
    }

    public void init(boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, boolean bl5, boolean bl6, int n2, int n3, int n4, EasingParams[] easingParamsArray, boolean bl7, int n5, boolean bl8, int n6, String string, boolean bl9, int n7, int n8, Insets insets, Color color, Image image, int n9, int n10, int n11, int n12, int n13, boolean bl10, int n14, int n15, int n16) {
        super.init(bl3, n, bl5, easingParamsArray, bl7, n5, bl8, string, n7, insets, bl10, n14, n15, n16);
        this.valueMaxX = n10;
        this.valueMaxY = n11;
        this.valueMinX = n12;
        this.valueMinY = n13;
        this.touchTrajectoriesColor = color;
        this.touchTrajectoriesLineWidth = n9;
        this.touchTrajectoriesImage = image;
        this.dragThreshold = n2;
        this.dragThresholdMode = n3;
        this.mode = n6;
        this.duration = n4;
        this.touchForwardingMode = n8;
        this.setInternalStateFlag(9, bl);
        this.setInternalStateFlag(10, bl2);
        this.setInternalStateFlag(12, bl4);
        this.setInternalStateFlag(13, bl6);
        this.setInternalStateFlag(11, bl9);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.getQualifiedName().equals("SimpleDesktopLayout.ScreenAreaStage.TESTMODE_TOUCHSCREEN_TEST.Canvas")) {
            TouchAreaDiagUI touchAreaDiagUI = new TouchAreaDiagUI();
            touchAreaDiagUI.setWidget(this);
            this.setUI(touchAreaDiagUI);
            touchAreaDiagUI.init();
        }
        if (this.is_showTouchTrajectories()) {
            this.clearTouchTrajectories();
        }
        if (viewModel != null) {
            viewModel.addProximityConsumer(this);
        }
    }

    @Override
    public void deInit() {
        ViewModel viewModel = this.getView();
        if (viewModel != null) {
            viewModel.removeProximityConsumer(this);
        }
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$TouchAreaUI == null ? (class$de$vw$mib$widgets$ui$TouchAreaUI = TouchArea.class$("de.vw.mib.widgets.ui.TouchAreaUI")) : class$de$vw$mib$widgets$ui$TouchAreaUI, class$de$vw$mib$widgets$ui$TouchAreaDiagUI == null ? (class$de$vw$mib$widgets$ui$TouchAreaDiagUI = TouchArea.class$("de.vw.mib.widgets.ui.TouchAreaDiagUI")) : class$de$vw$mib$widgets$ui$TouchAreaDiagUI};
    }

    @Override
    public boolean is_absoluteCoordinates() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public void set_absoluteCoordinates(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.accumulateEventsChanged(bl2);
            this.propertyChanged(15);
        }
    }

    @Override
    public final boolean is_accumulateEvents() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public final void set_accumulateEvents(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.accumulateEventsChanged(bl2);
            this.propertyChanged(16);
        }
    }

    @Override
    public final boolean is_audibleFeedback() {
        return this.getInternalStateFlag(12);
    }

    @Override
    public final void set_audibleFeedback(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(12);
        if (bl2 != bl) {
            this.setInternalStateFlag(12, bl);
            this.audibleFeedbackChanged(bl2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final void set_valueMinX(int n) {
        int n2 = this.valueMinX;
        if (n2 != n) {
            this.valueMinX = n;
            this.valueMinXChanged(n2);
            this.propertyChanged(17);
        }
    }

    @Override
    public final int get_valueMinX() {
        return this.valueMinX;
    }

    @Override
    public final void set_valueMaxX(int n) {
        int n2 = this.valueMaxX;
        if (n2 != n) {
            this.valueMaxX = n;
            this.valueMaxXChanged(n2);
            this.propertyChanged(18);
        }
    }

    @Override
    public final int get_valueMaxX() {
        return this.valueMaxX;
    }

    @Override
    public final void set_valueMinY(int n) {
        int n2 = this.valueMinY;
        if (n2 != n) {
            this.valueMinY = n;
            this.valueMinYChanged(n2);
            this.propertyChanged(19);
        }
    }

    @Override
    public final int get_valueMinY() {
        return this.valueMinY;
    }

    @Override
    public final void set_valueMaxY(int n) {
        int n2 = this.valueMaxY;
        if (n2 != n) {
            this.valueMaxY = n;
            this.valueMaxYChanged(n2);
            this.propertyChanged(20);
        }
    }

    @Override
    public final int get_valueMaxY() {
        return this.valueMaxY;
    }

    @Override
    public Color get_touchTrajectoriesColor() {
        return this.touchTrajectoriesColor;
    }

    @Override
    public void set_touchTrajectoriesColor(Color color) {
        Color color2 = this.touchTrajectoriesColor;
        if (color2 == null || !color2.equals(color)) {
            this.touchTrajectoriesColor = color;
            this.touchTrajectoriesColorChanged(color2);
            this.propertyChanged(22);
        }
    }

    @Override
    public int get_touchTrajectoriesLineWidth() {
        return this.touchTrajectoriesLineWidth;
    }

    @Override
    public void set_touchTrajectoriesLineWidth(int n) {
        int n2 = this.touchTrajectoriesLineWidth;
        if (n2 != n) {
            this.touchTrajectoriesLineWidth = n;
            this.touchTrajectoriesLineWidthChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public Image get_touchTrajectoriesImage() {
        return this.touchTrajectoriesImage;
    }

    @Override
    public void set_touchTrajectoriesImage(Image image) {
        Image image2 = this.touchTrajectoriesImage;
        if (image2 == null || !image2.equals(image)) {
            this.touchTrajectoriesImage = image;
            this.touchTrajectoriesImageChanged(image2);
            this.propertyChanged(24);
        }
    }

    @Override
    public boolean isNormalizeXValues() {
        return this.valueMaxX != this.valueMinX;
    }

    @Override
    public boolean isNormalizeYValues() {
        return this.valueMaxY != this.valueMinY;
    }

    @Override
    public List getTouchTrajectories() {
        return this.touchTrajectories;
    }

    @Override
    public final void set_showTouchTrajectories(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(11);
        if (bl2 != bl) {
            this.setInternalStateFlag(11, bl);
            this.showTouchTrajectoriesChanged(bl2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final boolean is_showTouchTrajectories() {
        return this.getInternalStateFlag(11) || SHOW_TOUCH_TRAJECTORIES;
    }

    @Override
    public boolean is_dragDeltaRelativeToPress() {
        return this.getInternalStateFlag(13);
    }

    @Override
    public void set_dragDeltaRelativeToPress(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(13);
        if (bl2 != bl) {
            this.setInternalStateFlag(13, bl);
            this.dragDeltaRelativeToPressChanged(bl2);
            this.propertyChanged(26);
        }
    }

    @Override
    public int get_dragThreshold() {
        return this.dragThreshold;
    }

    @Override
    public void set_dragThreshold(int n) {
        int n2 = this.dragThreshold;
        if (n2 != n) {
            this.dragThreshold = n;
            this.dragThresholdChanged(n2);
            this.propertyChanged(27);
        }
    }

    @Override
    public int get_dragThresholdMode() {
        return this.dragThresholdMode;
    }

    @Override
    public void set_dragThresholdMode(int n) {
        int n2 = this.dragThresholdMode;
        if (n2 != n) {
            this.dragThresholdMode = n;
            this.dragThresholdModeChanged(n2);
            this.propertyChanged(28);
        }
    }

    @Override
    public int get_mode() {
        return this.mode;
    }

    @Override
    public void set_mode(int n) {
        int n2 = this.mode;
        if (n2 != n) {
            this.mode = n;
            this.modeChanged(n2);
            this.propertyChanged(29);
        }
    }

    @Override
    public int get_duration() {
        return this.duration;
    }

    @Override
    public void set_duration(int n) {
        int n2 = this.duration;
        if (n2 != n) {
            this.duration = n;
            this.durationChanged(n2);
            this.propertyChanged(30);
        }
    }

    @Override
    public int get_touchForwardingMode() {
        return this.touchForwardingMode;
    }

    @Override
    public void set_touchForwardingMode(int n) {
        int n2 = this.touchForwardingMode;
        if (n2 != n) {
            this.touchForwardingMode = n;
            this.touchForwardingModeChanged(n2);
            this.propertyChanged(31);
        }
    }

    @Override
    public TouchAreaModel$TouchDataStorage getTouchDataStorage() {
        return this.touchDataStorage;
    }

    @Override
    public void setStoreTouchData(boolean bl) {
        this.setInternalStateFlag(14, bl);
    }

    @Override
    public boolean isStoreTouchData() {
        return this.getInternalStateFlag(14);
    }

    @Override
    public TouchAreaModel$ProximityDataStorage getProximityDataStorage() {
        return this.proximityDataStorage;
    }

    @Override
    public void setStoreProximityData(boolean bl) {
        this.setInternalStateFlag(15, bl);
    }

    @Override
    public boolean isStoreProximityData() {
        return this.getInternalStateFlag(15);
    }

    protected void durationChanged(int n) {
    }

    protected void accumulateEventsChanged(boolean bl) {
    }

    protected void audibleFeedbackChanged(boolean bl) {
    }

    protected void valueMinXChanged(int n) {
    }

    protected void valueMaxXChanged(int n) {
    }

    protected void valueMinYChanged(int n) {
    }

    protected void valueMaxYChanged(int n) {
    }

    protected void showTouchTrajectoriesChanged(boolean bl) {
        this.repaint();
    }

    protected void touchTrajectoriesColorChanged(Color color) {
        this.repaint();
    }

    protected void touchTrajectoriesLineWidthChanged(int n) {
        this.repaint();
    }

    protected void touchTrajectoriesImageChanged(Image image) {
        this.repaint();
    }

    protected void dragDeltaRelativeToPressChanged(boolean bl) {
        this.repaint();
    }

    protected void dragThresholdChanged(int n) {
    }

    protected void dragThresholdModeChanged(int n) {
    }

    protected void modeChanged(int n) {
    }

    protected void touchForwardingModeChanged(int n) {
    }

    @Override
    public int normalizeXValue(int n) {
        if (this.valueMaxX > this.valueMinX) {
            return TouchArea.normalizeValue(n, this.get_width(), this.valueMaxX, this.valueMinX);
        }
        return this.valueMinX + this.valueMaxX - TouchArea.normalizeValue(n, this.get_width(), this.valueMinX, this.valueMaxX);
    }

    @Override
    public int normalizeDeltaXValue(int n, boolean bl) {
        int n2 = bl && n < 0 ? -1 * this.normalizeXValue(-1 * n) : this.normalizeXValue(n);
        return n2;
    }

    @Override
    public int normalizeYValue(int n) {
        if (this.valueMaxY > this.valueMinY) {
            return TouchArea.normalizeValue(n, this.get_height(), this.valueMaxY, this.valueMinY);
        }
        return this.valueMinY + this.valueMaxY - TouchArea.normalizeValue(n, this.get_height(), this.valueMinY, this.valueMaxY);
    }

    @Override
    public int normalizeDeltaYValue(int n, boolean bl) {
        int n2 = bl && n < 0 ? -1 * this.normalizeYValue(-1 * n) : this.normalizeYValue(n);
        return n2;
    }

    private static int normalizeValue(int n, int n2, int n3, int n4) {
        float f2 = (float)(n * (n3 - n4)) / (float)n2 + (float)n4;
        return Util.clamp(Math.round(f2), n4, n3);
    }

    @Override
    public void startTouchTrajectory() {
        if (this.touchTrajectories == null) {
            this.touchTrajectories = new ArrayList(1);
        }
        if (this.touchTrajectories.size() < 50) {
            this.currentTouchTrajectory = new TouchArea$BezierSplineTrajectory(this.touchTrajectoriesLineWidth);
            this.touchTrajectories.add(this.currentTouchTrajectory);
        }
    }

    @Override
    public void finishTouchTrajectory() {
        if (this.currentTouchTrajectory != null) {
            this.currentTouchTrajectory.finish();
            this.currentTouchTrajectory = null;
            this.rebuildTouchTrajectory = true;
            this.repaint();
        }
    }

    @Override
    public void addTouchTrajectoryKnot(Point2f point2f) {
        if (this.currentTouchTrajectory != null) {
            this.currentTouchTrajectory.addKnot(point2f);
            this.repaint();
        }
    }

    @Override
    public void clearTouchTrajectories() {
        this.rebuildTouchTrajectory = true;
        if (this.touchTrajectories != null) {
            this.touchTrajectories.clear();
            this.repaint();
        }
    }

    @Override
    public boolean isRebuildAllTouchTrajectory() {
        return this.rebuildTouchTrajectory;
    }

    @Override
    public void setRebuildTouchTrajectory(boolean bl) {
        this.rebuildTouchTrajectory = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

