/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode.transformer;

import de.vw.mib.util.StringBuilder;
import generated.de.vw.mib.asl.internal.navigation.waypointmode.transformer.AbstractNavigationWayPointModeTrackListTransformer;
import org.dsi.ifc.navigation.NavTraceListData;

public class NavigationWayPointModeTrackListTransformer
extends AbstractNavigationWayPointModeTrackListTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            return ((NavTraceListData)object).getNumberOfTrackPoints();
        }
        throw new IllegalArgumentException(new StringBuilder("columnId ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((NavTraceListData)object).getName();
        }
        throw new IllegalArgumentException(new StringBuilder("columnId ").append(n).toString());
    }
}

