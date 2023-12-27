/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdllogging;

import org.dsi.ifc.base.DSIListener;

public interface DSISwdlLoggingListener
extends DSIListener {
    default public void getHistory(String[] stringArray, int[] nArray) {
    }

    default public void setUpdate(int n) {
    }

    default public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, String string4, int[] nArray, boolean bl3, int n, int[] nArray2) {
    }

    default public void getUnusualEvents(int[] nArray, String[] stringArray) {
    }

    default public void getUnusualEvent(int n, String string, String string2, String string3, byte by, int n2) {
    }
}

