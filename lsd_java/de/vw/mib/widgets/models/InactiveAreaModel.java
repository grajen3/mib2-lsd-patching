/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.models.ContainerModel;

public interface InactiveAreaModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_EXCLUSION_AREA;
    public static final int PID_COUNT_INACTIVEAREA;
    public static final int SID_BASE;
    public static final int SID_COUNT_INACTIVEAREA;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_FADE_IN;
    public static final int EASING_INDEX_FADE_OUT;
    public static final int EASING_INDEX_COUNT_INACTIVE_AREA;

    default public Rectangle get_exclusionArea() {
    }

    default public void set_exclusionArea(Rectangle rectangle) {
    }

    default public Rectangle[] getAdditionalExclusionAreas() {
    }

    default public void setAdditionalExclusionAreas(Rectangle[] rectangleArray) {
    }

    default public PushUpHandler getControlBarRef() {
    }

    default public void setControlBarRef(PushUpHandler pushUpHandler) {
    }

    default public void focus(Focusable focusable, boolean bl) {
    }

    default public void unFocus() {
    }

    default public Focusable getFocusedWidget() {
    }

    default public boolean isFocusActive() {
    }

    default public boolean isEventForwarding() {
    }

    default public boolean isAbsPointInsideTouchableArea(int n, int n2) {
    }
}

