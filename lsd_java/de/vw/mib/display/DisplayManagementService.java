/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.display;

import de.vw.mib.display.DisplayManagementResponse;

public interface DisplayManagementService {
    default public int getDisplayCount() {
    }

    default public int[] getDisplayExtents(int n) {
    }

    default public int[] getDisplayableExtents(int n, int n2) {
    }

    default public void setDisplayableOpacity(int n, int n2, int n3) {
    }

    default public void setDisplayable(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void showDisplayables(int n, int[] nArray) {
    }

    default public void showDisplayables(int n, int[] nArray, DisplayManagementResponse displayManagementResponse) {
    }

    default public void deferDisplayUpdates(int n, int n2) {
    }

    default public void beginSync(int n, boolean bl) {
    }

    default public void endSync(int n) {
    }

    default public void setDisplayType(int n, int n2, DisplayManagementResponse displayManagementResponse) {
    }

    default public void setUpdateRate(int n, int n2, DisplayManagementResponse displayManagementResponse) {
    }
}

