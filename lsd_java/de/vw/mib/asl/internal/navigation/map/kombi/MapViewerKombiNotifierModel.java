/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class MapViewerKombiNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiNotifierModel]");

    public void notifyFPKMapPerspective2DHeadingUp() {
        this.logger.trace("notifyFPKMapPerspective2DHeadingUp()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1544548352, 1);
    }

    public void notifyFPKMapPerspective2DNorthUp() {
        this.logger.trace("notifyFPKMapPerspective2DNorthUp()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1544548352, 0);
    }

    public void notifyFPKMapPerspective3D() {
        this.logger.trace("notifyFPKMapPerspective3D()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1544548352, 2);
    }

    public void notifyKombiMapInvisible() {
        this.logger.trace("notifyKombiMapInvisile()");
        AbstractASLHsmTarget.writeIntegerToDatapool(502272000, 0);
    }

    public void notifyKombiMapVisible() {
        this.logger.trace("notifyKombiMapVisible()");
        AbstractASLHsmTarget.writeIntegerToDatapool(502272000, 1);
    }

    public void notifyKombiStatusError() {
        this.logger.trace("notifyKombiStatusError()");
        AbstractASLHsmTarget.writeIntegerToDatapool(485494784, 4);
    }

    public void notifyKombiStatusNotStarted() {
        this.logger.trace("notifyKombiStatusNotStarted()");
        AbstractASLHsmTarget.writeIntegerToDatapool(485494784, 0);
    }

    public void notifyKombiStatusReady() {
        this.logger.trace("notifyKombiStatusReady()");
        AbstractASLHsmTarget.writeIntegerToDatapool(485494784, 2);
    }

    public void notifyKombiStatusRestarting() {
        this.logger.trace("notifyKombiStatusRestarting()");
        AbstractASLHsmTarget.writeIntegerToDatapool(485494784, 3);
    }

    public void notifyKombiStatusStarting() {
        this.logger.trace("notifyKombiStatusStarting()");
        AbstractASLHsmTarget.writeIntegerToDatapool(485494784, 1);
    }

    public void notifyDayNightModeChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyDayNightModeChanged(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1259335680, n);
    }

    public void updateCurrentDayNightMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateCurrentDayNightMode(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1242558464, n);
    }

    void notifyZoomLevelChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomLevelChanged( zoomLevel=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(872, n);
    }

    void notifyZoomListIndexChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyZoomListIndexChanged( zoomListIndex=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(871, n);
    }

    void notifyZoomListIndexMaximumReached(boolean bl) {
        AbstractASLHsmTarget.writeBooleanToDatapool(879, bl);
    }

    void notifyZoomListIndexMinimumReached(boolean bl) {
        AbstractASLHsmTarget.writeBooleanToDatapool(3691, bl);
    }
}

