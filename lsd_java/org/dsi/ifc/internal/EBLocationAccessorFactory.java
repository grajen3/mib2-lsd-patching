/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.internal.EBLocationAccessor;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class EBLocationAccessorFactory
implements ILocationAccessorFactory {
    static final String VERSION;

    @Override
    public ILocationAccessor cloneLocationAccessor(ILocationAccessor iLocationAccessor) {
        if (iLocationAccessor instanceof EBLocationAccessor) {
            return new EBLocationAccessor((EBLocationAccessor)iLocationAccessor);
        }
        return null;
    }

    @Override
    public ILocationAccessor createLocationAccessorFromGeoPos(int n, int n2) {
        return new EBLocationAccessor(n, n2);
    }

    @Override
    public ILocationAccessor fromLocation(NavLocation navLocation) {
        return new EBLocationAccessor(navLocation);
    }

    @Override
    public NavLocation toLocation(ILocationAccessor iLocationAccessor) {
        if (iLocationAccessor instanceof EBLocationAccessor) {
            return ((EBLocationAccessor)iLocationAccessor).getLocation();
        }
        return null;
    }

    @Override
    public ILocationAccessor fromTraceId(NavSegmentID navSegmentID) {
        return new EBLocationAccessor(navSegmentID);
    }
}

