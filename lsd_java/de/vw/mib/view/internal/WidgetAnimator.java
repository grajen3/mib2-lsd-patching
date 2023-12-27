/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.widgets.models.WidgetModel;

public interface WidgetAnimator {
    default public int getAnimatableIntValue(WidgetModel widgetModel, int n, int n2) {
    }

    default public void setAnimatableIntValue(WidgetModel widgetModel, int n, int n2, int n3) {
    }

    default public float getAnimatableFloatValue(WidgetModel widgetModel, int n, int n2) {
    }

    default public void setAnimatableFloatValue(WidgetModel widgetModel, int n, int n2, float f2) {
    }
}

