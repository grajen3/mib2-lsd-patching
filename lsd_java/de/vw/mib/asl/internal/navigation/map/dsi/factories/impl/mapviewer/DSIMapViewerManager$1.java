/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusListener;

class DSIMapViewerManager$1
implements DSIMapViewerStatusListener {
    private final /* synthetic */ DSIMapViewerManager this$0;

    DSIMapViewerManager$1(DSIMapViewerManager dSIMapViewerManager) {
        this.this$0 = dSIMapViewerManager;
    }

    @Override
    public void mapViewerNotReady() {
        this.this$0.mapViewer0NotReady();
    }

    @Override
    public void mapViewerReady() {
        this.this$0.mapViewer0Ready();
    }
}

