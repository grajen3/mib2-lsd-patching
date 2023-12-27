/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.backend;

public interface ConfigurationChangeListener {
    default public void onLogLevelChanged(int n, int[] nArray, int[] nArray2) {
    }

    default public void onLogSinkStateChanged(int n, boolean bl) {
    }
}

