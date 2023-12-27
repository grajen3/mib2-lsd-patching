/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class GoogleEarthLicenseNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthLicenseNotifierModel]");

    public void notifyGoogleEarthAvailable() {
        this.logger.trace("notifyGoogleEarthAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3702, true);
    }

    public void notifyGoogleEarthNotAvailable() {
        this.logger.trace("googleEarthNotAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3702, false);
    }

    public void notifyLastMapTypeOnboard() {
        this.logger.trace("notifyLastMapTypeOnboard()");
        ServiceManager.aslPropertyManager.valueChangedInteger(3716, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapLastTypeChanged(0);
    }

    public void notifyMapTypeCurrentOnboard() {
        this.logger.trace("notifyMapTypeCurrentOnboard()");
        ServiceManager.aslPropertyManager.valueChangedInteger(3715, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapTypeChanged(0);
    }
}

