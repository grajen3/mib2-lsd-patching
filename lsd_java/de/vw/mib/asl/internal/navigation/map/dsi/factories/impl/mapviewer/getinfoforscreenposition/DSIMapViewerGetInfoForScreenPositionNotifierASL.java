/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.map.PosInfo;

public class DSIMapViewerGetInfoForScreenPositionNotifierASL {
    public void sendEventGetInfoForScreenPositionResult(AbstractTarget abstractTarget, AbstractTarget abstractTarget2, PosInfo[] posInfoArray) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGetInfoForScreenPositionResult(abstractTarget, abstractTarget2, posInfoArray);
    }

    public void sendEvMapMainGetInfoForScreenPositionResultAsyncException(AbstractTarget abstractTarget, AbstractTarget abstractTarget2, int n, int n2) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGetInfoForScreenPositionResultAsyncException(abstractTarget, abstractTarget2, n, n2);
    }
}

