/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.has;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.has.HASDataContainer;

public interface DSIHAS
extends DSIBase {
    public static final String VERSION;
    public static final int RT_HMIREADY;
    public static final int RT_ACTIONRESULT;
    public static final int RT_PROPERTYUPDATE;
    public static final int RT_SUBSCRIBERESULT;
    public static final int IN_ACTIONREQUEST;
    public static final int IN_SUBSCRIBEREQUEST;
    public static final int IN_UNSUBSCRIBEREQUEST;
    public static final int IN_UNSUBSCRIBEALLREQUEST;
    public static final int IN_GETPROPERTYREQUEST;

    default public void hmiReady() {
    }

    default public void actionResult(int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
    }

    default public void propertyUpdate(int n, HASDataContainer[] hASDataContainerArray, int n2) {
    }

    default public void subscribeResult(int n, int n2) {
    }
}

