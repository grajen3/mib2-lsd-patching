/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation.util;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.util.ILocationAccessor;

public interface ILocationAccessorFactory {
    default public ILocationAccessor createLocationAccessorFromGeoPos(int n, int n2) {
    }

    default public ILocationAccessor cloneLocationAccessor(ILocationAccessor iLocationAccessor) {
    }

    default public ILocationAccessor fromLocation(NavLocation navLocation) {
    }

    default public NavLocation toLocation(ILocationAccessor iLocationAccessor) {
    }

    default public ILocationAccessor fromTraceId(NavSegmentID navSegmentID) {
    }
}

