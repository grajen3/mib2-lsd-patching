/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.widgets.event.AdjustmentListener;

public interface Adjustable {
    default public void setMinimum(int n) {
    }

    default public int getMinimum() {
    }

    default public void setMaximum(int n) {
    }

    default public int getMaximum() {
    }

    default public void setUnitIncrement(int n) {
    }

    default public int getUnitIncrement() {
    }

    default public void setBlockIncrement(int n) {
    }

    default public int getBlockIncrement() {
    }

    default public void setValue(int n) {
    }

    default public int getValue() {
    }

    default public void disableAdjustmentChanged() {
    }

    default public void enableAdjustmentChanged() {
    }

    default public boolean isAdjustmentEnabled() {
    }

    default public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
    }

    default public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
    }
}

