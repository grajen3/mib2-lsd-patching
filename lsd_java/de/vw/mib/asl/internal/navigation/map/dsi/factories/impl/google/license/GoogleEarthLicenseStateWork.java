/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class GoogleEarthLicenseStateWork
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthLicenseStateWork]");
    private final GoogleEarthLicenseTargetHSM target;

    public GoogleEarthLicenseStateWork(GoogleEarthLicenseTargetHSM googleEarthLicenseTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = googleEarthLicenseTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 4800009: {
                this.handleASLOnlineServiceListNotification();
                break;
            }
            case 3499018: {
                this.handleMapInstanceGoogleEarthReady();
                break;
            }
            case 3499019: {
                this.handleMapInstanceGoogleEarthNotReady();
                break;
            }
            case 1073744487: {
                this.handleASLNavigationOnlineServiceChangeMapType(eventGeneric);
                break;
            }
            case 3499095: {
                this.handleMapSwitcherReady();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(evId=").append(eventGeneric.getReceiverEventId()).append(", params=").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleMapInstanceGoogleEarthNotReady() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleMapInstanceGoogleEarthNotReady").log();
        }
        this.target.setMapViewerReady(false);
        this.checkGoogleState();
    }

    private void handleMapInstanceGoogleEarthReady() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleMapInstanceGoogleEarthReady").log();
        }
        this.target.setMapViewerReady(true);
        this.checkGoogleState();
    }

    private void handleMapSwitcherReady() {
        this.logger.trace("handleMapSwitcherReady");
        this.target.setMapSwitcherReady(true);
        this.checkGoogleState();
    }

    private void handleASLOnlineServiceListNotification() {
        boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceAvailable(this.target.getGoogleEarthServiceID());
        this.target.setGoogleAvailableInServiceList(bl);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLOnlineServiceListNotification ( googleAvailable = ").append(bl).append(" )").log();
        }
        this.checkGoogleState();
    }

    private void checkGoogleState() {
        if (this.target.isMapViewerReady() && this.target.isMapSwitcherReady() && this.target.isGoogleAvailableInServiceList()) {
            this.showGoogleEarthButton();
            this.target.datapool.setGoogleEarthNotAvailableAfterDisabling(false);
        } else if (GoogleEarthUtils.isGoogleEarthActive()) {
            if (!this.target.isMapViewerReady()) {
                this.logger.trace("Google is active but Map Viewer gets unavailable - turning off Google map");
                this.target.sendEventSwitchMapViewerToOnboardMap();
                this.hideGoogleEarthButton();
            } else {
                this.target.datapool.setGoogleEarthNotAvailableAfterDisabling(true);
            }
        } else {
            this.hideGoogleEarthButton();
        }
    }

    void hideGoogleEarthButton() {
        this.logger.trace("hideGoogleEarthButton()");
        this.target.datapool.setConnectionStateAllow(false);
        this.target.notifierDSI.setConnectionInformationForbidden();
        this.target.notifierModel.notifyGoogleEarthNotAvailable();
        if (GoogleEarthUtils.isGoogleEarthActive()) {
            this.logger.trace("Google Earth active, send switch to onBoard");
            this.target.sendEventSwitchMapViewerToOnboardMap();
        }
    }

    private void showGoogleEarthButton() {
        this.logger.trace("showGoogleEarthButton()");
        this.target.datapool.setConnectionStateAllow(true);
        this.target.notifierDSI.setConnectionInformationAllow();
        this.target.notifierModel.notifyGoogleEarthAvailable();
    }

    private void handleASLNavigationOnlineServiceChangeMapType(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n != 1 && this.target.datapool.isGoogleEarthNotAvailableAfterdisabling()) {
            this.target.datapool.setGoogleEarthNotAvailableAfterDisabling(false);
            this.target.notifierModel.notifyGoogleEarthNotAvailable();
        }
    }
}

