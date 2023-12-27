/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travellink;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.travellink.GenericProperty;

public interface DSITravelLinkCommon
extends DSIBase {
    public static final String VERSION;
    public static final int RT_REQUESTTOAPP;
    public static final int ATTR_FROMAPP;

    default public void requestToApp(int n, int n2, GenericProperty[] genericPropertyArray, int n3, int n4, int n5, int n6) {
    }
}

