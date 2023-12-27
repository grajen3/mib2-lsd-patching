/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

public interface ListControl {
    default public void selectNext() {
    }

    default public void selectPrevious() {
    }

    default public int getSelectionDelta() {
    }

    default public void resetSelectionDelta() {
    }

    default public int getViewPortPosition() {
    }

    default public void setViewPortPosition(int n) {
    }

    default public void setSelectedIndex(int n) {
    }

    default public int getSelectedIndex() {
    }

    default public void reset() {
    }
}

