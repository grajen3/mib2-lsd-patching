/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.ContainerModel;

public interface WindowWidgetModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_HEADLINE_HEIGHT;
    public static final int PID_WINDOW_COLLAPSE;
    public static final int PID_COUNT_WINDOWWIGDET;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_WINDOW_WIDGET;
    public static final int SID_BASE;
    public static final int SID_COUNT_WINDOWWIDGET;

    default public int get_headlineHeight() {
    }

    default public void set_headlineHeight(int n) {
    }

    default public boolean is_windowCollapse() {
    }

    default public void set_windowCollapse(boolean bl) {
    }
}

