/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class DSIMapViewerControlSwitchMapviewerNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerNotifierModel]");

    public void notifyMapTypeCurrentGoogleEarth() {
        this.logger.trace("notifyMapTypeCurrentGoogleEarth()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3715, 1);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapTypeChanged(1);
    }

    public void notifyMapTypeCurrentOnboard() {
        this.logger.trace("notifyMapTypeCurrentOnboard()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3715, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapTypeChanged(0);
    }

    public void notifyMapTypeLastGoogleEarth() {
        this.logger.trace("notifyMapTypeLastGoogleEarth()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3716, 1);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapLastTypeChanged(1);
    }

    public void notifyMapTypeLastOnboard() {
        this.logger.trace("notifyMapTypeLastOnboard()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3716, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapLastTypeChanged(0);
    }

    public void notifyMapViewerSwitchDone() {
        this.logger.trace("notifyMapViewerSwitchDone()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1878003712, false);
    }

    public void notifyMapViewerSwitchRunning() {
        this.logger.trace("notifyMapViewerSwitchRunning()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1878003712, true);
    }

    public void notifySetupPerspective3DHeading() {
        this.logger.trace("notifySetupPerspective3DHeading()");
        AbstractASLHsmTarget.writeIntegerToDatapool(840, 3);
    }
}

