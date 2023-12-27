/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.admin.DSIAdmin;

public interface IListenerTracker {
    default public Object[] getDSIListener(String string, int n) {
    }

    default public void setDSIAdmin(DSIAdmin dSIAdmin) {
    }

    default public void open() {
    }

    default public void close() {
    }
}

