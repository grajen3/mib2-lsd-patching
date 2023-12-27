/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.event.ViewChangedListener;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.TransformContainerModel;
import de.vw.mib.widgets.models.WidgetModel;

public interface ViewModel
extends TransformContainerModel {
    public static final int PID_BASE;
    public static final int PID_RENDER_BOUNDING_BOXES;
    public static final int PID_RENDER_INFO;
    public static final int PID_COLOR_BACKGROUND;
    public static final int PID_ENTER_ANIMATIONS;
    public static final int PID_LEAVE_ANIMATIONS;
    public static final int PID_VIEW_TYPES;
    public static final int PID_VIEW_TYPE_SELECTION;
    public static final int PID_TOUCH_FORWARDING_MODE;
    public static final int PID_OPAQUE;
    public static final int PID_COUNT_VIEW;
    public static final int SID_BASE;
    public static final int SID_RENDER_BOUNDING_BOXES;
    public static final int SID_RENDER_INFO;
    public static final int SID_OPAQUE;
    public static final int SID_COUNT_VIEW;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_VIEW;
    public static final int TOUCH_FORWARDING_MODE_EXCLUSIVE;
    public static final int TOUCH_FORWARDING_MODE_ALWAYS;
    public static final int TOUCH_FORWARDING_MODE_NEVER;
    public static final int TOUCH_FORWARDING_MODE_CONCURRENT;
    public static final int VIEW_TYPE_NONE;
    public static final Color4f OFFSCREEN_CLEAR_COLOR_VIEW;

    default public boolean is_renderBoundingBoxes() {
    }

    default public void set_renderBoundingBoxes(boolean bl) {
    }

    default public boolean is_renderInfo() {
    }

    default public void set_renderInfo(boolean bl) {
    }

    default public Color get_colorBackground() {
    }

    default public void set_colorBackground(Color color) {
    }

    default public void set_leaveAnimations(KeyframeAnimation[] keyframeAnimationArray) {
    }

    default public KeyframeAnimation[] get_leaveAnimations() {
    }

    default public void set_enterAnimations(KeyframeAnimation[] keyframeAnimationArray) {
    }

    default public KeyframeAnimation[] get_enterAnimations() {
    }

    default public boolean is_opaque() {
    }

    default public void set_opaque(boolean bl) {
    }

    default public void set_viewTypes(int[] nArray) {
    }

    default public int[] get_viewTypes() {
    }

    default public void set_viewTypeSelection(int n) {
    }

    default public int get_viewTypeSelection() {
    }

    default public int get_touchForwardingMode() {
    }

    default public void set_touchForwardingMode(int n) {
    }

    default public int getDisplayID() {
    }

    default public int getCurrentViewType() {
    }

    default public Point getPointerPosition() {
    }

    default public void setPointerPosition(Point point) {
    }

    default public void addViewChangedListener(ViewChangedListener viewChangedListener) {
    }

    default public void removeViewChangedListener(ViewChangedListener viewChangedListener) {
    }

    default public boolean startEnterAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
    }

    default public void stopEnterAnimation(int n) {
    }

    default public boolean isLeaveAnimationRunning() {
    }

    default public boolean isEnterAnimationRunning() {
    }

    default public boolean startLeaveAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
    }

    default public void stopLeaveAnimation(int n) {
    }

    default public void init() {
    }

    default public void onCover() {
    }

    default public void onUncover() {
    }

    default public void onLeave() {
    }

    default public void onEnter() {
    }

    default public ScreenModel getScreen() {
    }

    default public void addProximityConsumer(WidgetModel widgetModel) {
    }

    default public void removeProximityConsumer(WidgetModel widgetModel) {
    }

    default public CowList getProximityConsumers() {
    }

    default public ViewEventDispatcher getViewEventDispatcher() {
    }

    default public void setViewEventDispatcher(ViewEventDispatcher viewEventDispatcher) {
    }

    default public void setViewEventDispatcher(de.vw.mib.event.dispatcher.ViewEventDispatcher viewEventDispatcher) {
    }

    static {
        OFFSCREEN_CLEAR_COLOR_VIEW = Color4f.BLACK_TRANSPARENT;
    }
}

