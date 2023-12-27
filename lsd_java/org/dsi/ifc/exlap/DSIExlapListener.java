/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exlap;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exlap.Service;

public interface DSIExlapListener
extends DSIListener {
    default public void startResult(int n) {
    }

    default public void stopResult(int n) {
    }

    default public void updateAvailableServices(Service[] serviceArray, int n) {
    }
}

