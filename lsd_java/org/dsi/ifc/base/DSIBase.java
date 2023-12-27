/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

import org.dsi.ifc.base.DSIListener;

public interface DSIBase {
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;

    default public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    default public void setNotification(int n, DSIListener dSIListener) {
    }

    default public void setNotification(DSIListener dSIListener) {
    }

    default public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    default public void clearNotification(int n, DSIListener dSIListener) {
    }

    default public void clearNotification(DSIListener dSIListener) {
    }
}

