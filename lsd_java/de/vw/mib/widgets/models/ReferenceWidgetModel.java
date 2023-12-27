/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.WidgetModel;

public interface ReferenceWidgetModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_FORWARD_VIEW_ACTIVATION;
    public static final int PID_COUNT_REFERENCE_WIDGET;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_REFERENCE_WIDGET;
    public static final int SID_BASE;
    public static final int SID_FORWARD_VIEW_ACTIVATION;
    public static final int SID_COUNT_REFERENCE_WIDGET;

    default public WidgetModel getReferencedWidget() {
    }

    default public void setReferencedWidget(WidgetModel widgetModel) {
    }

    default public void set_forwardViewActivation(boolean bl) {
    }

    default public boolean is_forwardViewActivation() {
    }
}

