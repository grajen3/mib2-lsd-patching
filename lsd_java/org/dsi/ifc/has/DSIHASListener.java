/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.has;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.has.HASDataContainer;

public interface DSIHASListener
extends DSIListener {
    default public void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) {
    }

    default public void subscribeRequest(int n, int n2) {
    }

    default public void unsubscribeRequest(int n) {
    }

    default public void unsubscribeAllRequest() {
    }

    default public void getPropertyRequest(int n) {
    }
}

