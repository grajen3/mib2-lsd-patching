/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerGoogleCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseStateInit$1;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class GoogleEarthLicenseStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVERS = new int[]{155076864, 174339328, 191116544, 1466184960, 1482962176, 1728708672};
    protected final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthLicenseStateInit]");
    protected final GoogleEarthLicenseTargetHSM target;
    protected int licenceDelayTimerRetryCount = 0;
    private final int LICENSE_DELAY_TIMER_MAX_RETRIES;
    protected static final int GE_LICENCE_CHECK_DELAY_1_MINUTE;
    private boolean licenseCheckDone = false;

    public GoogleEarthLicenseStateInit(GoogleEarthLicenseTargetHSM googleEarthLicenseTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.LICENSE_DELAY_TIMER_MAX_RETRIES = 2;
        this.target = googleEarthLicenseTargetHSM;
        googleEarthLicenseTargetHSM.setGoogleEarthServiceID(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(14));
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4800009: {
                this.handleASLOnlineServiceListNotification();
                break;
            }
            case 3499095: {
                this.handleMapSwitcherReady();
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
            case 3499096: {
                this.doLicenseCheck();
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
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params=").append(eventGeneric.getParamString()).log();
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
        this.initModel();
        this.initDSI();
        this.initASL();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlFactoryVW.createMapViewerGoogleCtrl(this.target, null));
    }

    private void initModel() {
        this.target.notifierModel.notifyGoogleEarthNotAvailable();
    }

    private void handleASLOnlineServiceListNotification() {
        boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceAvailable(this.target.getGoogleEarthServiceID());
        this.target.setGoogleAvailableInServiceList(bl);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLOnlineServiceListNotification ( googleAvailable = ").append(bl).append(" )").log();
        }
        if (!bl) {
            this.disableGoogleEarthLastModeAndStayOnOnboardMap();
        } else {
            this.checkGoogleState();
        }
    }

    private void handleMapSwitcherReady() {
        this.logger.trace("handleMapSwitcherReady");
        this.target.setMapSwitcherReady(true);
        this.checkGoogleState();
    }

    private void handleMapInstanceGoogleEarthNotReady() {
        this.logger.trace("handleMapInstanceGoogleEarthNotReady");
        this.target.setMapViewerReady(false);
        this.checkGoogleState();
    }

    private void handleMapInstanceGoogleEarthReady() {
        this.logger.trace("handleMapInstanceGoogleEarthReady");
        this.target.setMapViewerReady(true);
        this.checkGoogleState();
    }

    private void checkGoogleState() {
        if (this.target.isMapViewerReady() && this.target.isMapSwitcherReady() && this.target.isGoogleAvailableInServiceList()) {
            if (this.target.datapool.getMainMapMapTypeLast() == 1 && !this.licenseCheckDone) {
                this.logger.trace("Everything's ready but Google was last mode so we will wait for license check.");
                this.doLicenseCheck();
            } else {
                this.logger.trace("all conditions meet, GoogleEarth is being enabled");
                this.showGoogleEarthButton();
            }
        }
    }

    private void doLicenseCheck() {
        ASLOnlineFactory.getOnlineCoreServices().checkOnlineServiceStatus(this.target.getGoogleEarthServiceID(), new GoogleEarthLicenseStateInit$1(this));
    }

    void disableGoogleEarthLastModeAndStayOnOnboardMap() {
        this.logger.trace("disableGoogleEarthLastModeAndStayOnOnboardMap()");
        this.target.datapool.setMainMapLastMapType(0);
        this.target.notifierDSI.setConnectionInformationForbidden();
        this.target.notifierModel.notifyLastMapTypeOnboard();
        this.target.notifierModel.notifyMapTypeCurrentOnboard();
        this.target.notifierModel.notifyGoogleEarthNotAvailable();
        try {
            this.target.transStateWork();
        }
        catch (Exception exception) {
            this.logger.error("Exception in disableGoogleEarthLastModeAndStayOnOnboardMap()");
        }
    }

    private void showGoogleEarthButton() {
        this.target.datapool.setConnectionStateAllow(true);
        this.target.notifierDSI.setConnectionInformationAllow();
        this.target.notifierModel.notifyGoogleEarthAvailable();
        try {
            this.target.transStateWork();
        }
        catch (Exception exception) {
            this.logger.error("Exception in showGoogleEarthButton()");
        }
    }

    static /* synthetic */ boolean access$002(GoogleEarthLicenseStateInit googleEarthLicenseStateInit, boolean bl) {
        googleEarthLicenseStateInit.licenseCheckDone = bl;
        return googleEarthLicenseStateInit.licenseCheckDone;
    }

    static /* synthetic */ void access$100(GoogleEarthLicenseStateInit googleEarthLicenseStateInit) {
        googleEarthLicenseStateInit.checkGoogleState();
    }
}

