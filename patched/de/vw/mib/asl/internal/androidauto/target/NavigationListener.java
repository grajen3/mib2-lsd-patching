/*
 * Decompiled with CFR 0.151-SNAPSHOT (5569f06-dirty).
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;

public class NavigationListener
extends AbstractASLNavigationServicesListener {
    private AndroidAutoTarget target;
    private StartupHandler startupHandler;
    private AndroidAutoGlobalProperties properties;
    private ASLNavigationServices navServices;
    private boolean stopGuidancePending = false;

    public NavigationListener(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
    }

    public void initNavServices(ASLNavigationServices aSLNavigationServices) {
        this.navServices = aSLNavigationServices;
    }

    // @Override
    public void updateGuidanceActive(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("NavigationHandler::updateGuidanceActive (ignored) - flag = ").append(bl).toString());
        }
        // if (bl) {
        //     // ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, false);
        //     this.properties.setAndroidAutoNavigationActive(false);
        //     if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
        // //         this.target.getDSIAndroidAuto2().navFocusNotification(1, true);
        //     }
        // }
        // ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, true);
    }

    // @Override
    public void updateServiceAvailable(boolean bl) {
        if (bl && this.stopGuidancePending) {
            this.stopGuidancePending = false;
            this.stopGuidance();
        }
    }

    public void stopGuidance() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("NavigationHandler::stopGuidance (ignored)");
        }
       // if (this.navServices.isServiceAvailable()) {
       //     this.navServices.stopGuidance(6);
       // } else {
            // this.stopGuidancePending = true;
            // if (this.target.isTraceEnabled()) {
            //     this.target.trace("NavigationListener::stopGuidance() = isServiceAvailable false");
            // }
       // }
    }

    public boolean isGuidanceActive() {
        //return this.navServices.isGuidanceActive();
        return false;
    }
}

