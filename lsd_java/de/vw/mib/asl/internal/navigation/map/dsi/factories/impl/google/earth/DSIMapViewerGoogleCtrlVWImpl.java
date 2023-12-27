/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerGoogleCtrlVW;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;

public class DSIMapViewerGoogleCtrlVWImpl
implements DSIMapViewerGoogleCtrlVW {
    private boolean facadeEnabled;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerGoogleCtrlVWImpl]");
    private DSIMapViewerGoogleCtrl mapViewerGoogleCtrl;

    public boolean isFacadeEnabled() {
        return this.facadeEnabled;
    }

    @Override
    public void requestClearCache() {
        this.mapViewerGoogleCtrl.requestClearCache();
    }

    @Override
    public void setConnectionInformation(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setConnectionInformation(connectionState=").append(n).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call 'setConnectionInformation( int connectionState )' will be ignored");
            return;
        }
        this.mapViewerGoogleCtrl.setConnectionInformation(n);
    }

    public void setFacadeEnabled(boolean bl) {
        this.facadeEnabled = bl;
    }

    @Override
    public void setLanguage(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setLanguage(language=").append(string).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call 'setLanguage( String language )'  will be ignored");
            return;
        }
        this.mapViewerGoogleCtrl.setLanguage(string);
    }

    @Override
    public void setLayerVisibility(int[] nArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setLayerVisibility(visibleLayers=").append(nArray.length).append(")").log();
        }
        if (!this.isFacadeEnabled()) {
            this.logger.warn("The MapViewerGooglCtrl facade is currently disabled, the call 'setLayerVisibility( int[] visibleLayers )' will be ignored");
            return;
        }
        this.mapViewerGoogleCtrl.setLayerVisibility(nArray);
    }

    public void setMapViewerGoogleCtrl(DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl) {
        this.mapViewerGoogleCtrl = dSIMapViewerGoogleCtrl;
    }
}

