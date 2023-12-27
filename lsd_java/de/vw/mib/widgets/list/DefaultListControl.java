/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.widgets.list.ListControl;

public final class DefaultListControl
implements ListControl {
    static final int SELECTED_INDEX_DEFAULT;
    static final int VIEW_PORT_POSITION_DEFAULT;
    static final int SELECTION_DELTA_DEFAULT;
    int selectedIndex = -1;
    int selectionDelta = 0;
    int viewPortPosition = 0;

    @Override
    public int getViewPortPosition() {
        return this.viewPortPosition;
    }

    @Override
    public void setViewPortPosition(int n) {
        this.viewPortPosition = n;
    }

    @Override
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override
    public void setSelectedIndex(int n) {
        this.selectedIndex = n;
    }

    @Override
    public int getSelectionDelta() {
        return this.selectionDelta;
    }

    @Override
    public void resetSelectionDelta() {
        this.selectionDelta = 0;
    }

    @Override
    public void selectNext() {
        ++this.selectionDelta;
    }

    @Override
    public void selectPrevious() {
        --this.selectionDelta;
    }

    @Override
    public void reset() {
        this.viewPortPosition = 0;
        this.selectedIndex = -1;
    }
}

