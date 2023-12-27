/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.WidgetUI;
import java.util.List;

public interface WidgetModel {
    public static final int PID_BASE;
    public static final int PID_TARGET_ID;
    public static final int PID_NAME;
    public static final int PID_ACTIVATED;
    public static final int PID_ENABLED;
    public static final int PID_VISIBLE;
    public static final int PID_AVAILABLE_IN_VARIANT;
    public static final int PID_LAYOUTABLE;
    public static final int PID_X;
    public static final int PID_Y;
    public static final int PID_WIDTH;
    public static final int PID_HEIGHT;
    public static final int PID_ALPHA;
    public static final int PID_EASING;
    public static final int PID_TOUCH_INSETS;
    public static final int PID_COUNT_WIDGET;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_TRANSLATE_X;
    public static final int EASING_INDEX_TRANSLATE_Y;
    public static final int EASING_INDEX_SCALE_WIDTH;
    public static final int EASING_INDEX_SCALE_HEIGHT;
    public static final int EASING_INDEX_FADE_ALPHA;
    public static final int EASING_INDEX_FADE_VISIBLE;
    public static final int EASING_INDEX_FADE_INVISIBLE;
    public static final int EASING_INDEX_COUNT_WIDGET;
    public static final int SID_BASE;
    public static final int SID_ACTIVATED;
    public static final int SID_ENABLED;
    public static final int SID_VISIBLE;
    public static final int SID_AVAILABLE_IN_VARIANT;
    public static final int SID_CONTENT_DIRTY;
    public static final int SID_CONTENT_INVALID;
    public static final int SID_LOCAL_TRANSFORM_VALID;
    public static final int SID_GLOBAL_TRANSFORM_VALID;
    public static final int SID_LAYOUTABLE;
    public static final int SID_COUNT_WIDGET;

    default public String get_name() {
    }

    default public void set_name(String string) {
    }

    default public boolean is_activated() {
    }

    default public void set_activated(boolean bl) {
    }

    default public boolean is_enabled() {
    }

    default public void set_enabled(boolean bl) {
    }

    default public boolean is_availableInVariant() {
    }

    default public void set_availableInVariant(boolean bl) {
    }

    default public boolean is_visible() {
    }

    default public void set_visible(boolean bl) {
    }

    default public boolean is_layoutable() {
    }

    default public void set_layoutable(boolean bl) {
    }

    default public int get_x() {
    }

    default public void set_x(int n) {
    }

    default public int get_y() {
    }

    default public void set_y(int n) {
    }

    default public int get_width() {
    }

    default public void set_width(int n) {
    }

    default public int get_height() {
    }

    default public void set_height(int n) {
    }

    default public int get_alpha() {
    }

    default public void set_alpha(int n) {
    }

    default public EasingParams[] get_easing() {
    }

    default public void set_easing(EasingParams[] easingParamsArray) {
    }

    default public int get_targetId() {
    }

    default public void set_targetId(int n) {
    }

    default public Insets get_touchInsets() {
    }

    default public void set_touchInsets(Insets insets) {
    }

    default public void init(ViewModel viewModel) {
    }

    default public void deInit() {
    }

    default public void activate() {
    }

    default public void deActivate() {
    }

    default public WidgetController getController() {
    }

    default public void setController(WidgetController widgetController) {
    }

    default public Class[] getCompatibleUIClasses() {
    }

    default public WidgetUI getUI() {
    }

    default public void setUI(WidgetUI widgetUI) {
    }

    default public WidgetModel getParent() {
    }

    default public ViewModel getView() {
    }

    default public String getQualifiedName() {
    }

    default public void disablePropertyChanged() {
    }

    default public void enablePropertyChanged() {
    }

    default public void addPropertyChangedListener(PropertyChangedListener propertyChangedListener) {
    }

    default public void removePropertyChangedListener(PropertyChangedListener propertyChangedListener) {
    }

    default public Transform getLocalTransform() {
    }

    default public Transform getGlobalTransform() {
    }

    default public int getAbsAlpha() {
    }

    default public int getAbsX() {
    }

    default public int getAbsY() {
    }

    default public int getAbsZ() {
    }

    default public void getBounds(Rectangle rectangle) {
    }

    default public void getAbsBounds(Rectangle rectangle) {
    }

    default public boolean canConsumeHMIEvents() {
    }

    default public boolean areParentsVisible() {
    }

    default public boolean areParentsEnabled() {
    }

    default public boolean canParentsConsumeHMIEvents() {
    }

    default public boolean isPointInside(int n, int n2, int n3) {
    }

    default public boolean isPointInside(int n, int n2) {
    }

    default public boolean isAbsPointInside(int n, int n2) {
    }

    default public boolean isAbsPointInside(int n, int n2, int n3) {
    }

    default public void findTouchEventConsumingWidgets(List list, TouchEvent touchEvent) {
    }

    default public void findTouchEventConsumingWidgets(List list, int n, int n2) {
    }

    default public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
    }

    default public boolean consumeTouchEvent(TouchEvent touchEvent) {
    }

    default public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
    }

    default public boolean isPaintable() {
    }

    default public void invalidate() {
    }

    default public boolean isInvalid() {
    }

    default public boolean isDirty() {
    }

    default public void paint(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }

    default public void repaint() {
    }

    default public boolean isVisibleRelevantAnimationRunning() {
    }

    default public boolean areAnimationsEnabled() {
    }

    default public void disableAnimations() {
    }

    default public void enableAnimations() {
    }

    default public void resetAnimationsEnabled() {
    }

    default public void stopInternalAnimations() {
    }

    default public void calculateBoundingBox(int n, int n2, Point point, Point point2) {
    }

    default public void setAnimationBlockingEnabled(boolean bl) {
    }
}

