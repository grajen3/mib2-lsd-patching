/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseDatapool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseNotifierModel;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseStateInit;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseStateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public final class GoogleEarthLicenseTargetHSM
extends AbstractResettableAslHsmTarget {
    protected static final int GE_LICENCE_CHECK_DELAY_1_MINUTE;
    protected final GoogleEarthLicenseDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthLicenseTargetHSM]");
    protected final GoogleEarthLicenseNotifierDSI notifierDSI;
    protected final GoogleEarthLicenseNotifierModel notifierModel;
    private final HsmState stateInit;
    protected final HsmState stateWork;
    private String googleEarthServiceID;
    private boolean mapViewerReady = false;
    private boolean mapSwitcherReady = false;
    private boolean googleAvailableInServiceList = false;

    public GoogleEarthLicenseTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new GoogleEarthLicenseDatapool();
        this.notifierModel = new GoogleEarthLicenseNotifierModel();
        this.notifierDSI = new GoogleEarthLicenseNotifierDSI();
        this.stateWork = new GoogleEarthLicenseStateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.stateInit = new GoogleEarthLicenseStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    protected void sendEventSwitchMapViewerToOnboardMap() {
        if (GoogleEarthUtils.isGoogleEarthActive()) {
            this.logger.trace("sendEventSwitchMapViewerToOnboardMap() - sending switch to onboard map");
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1728708672);
            eventGeneric.setInt(0, 0);
            ASLNavigationEventFactory.sendEventToService(eventGeneric);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary because target reacts to higher level events");
        }
    }

    public void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    public String getGoogleEarthServiceID() {
        return this.googleEarthServiceID;
    }

    public void setGoogleEarthServiceID(String string) {
        this.googleEarthServiceID = string;
    }

    public boolean isMapViewerReady() {
        return this.mapViewerReady;
    }

    public void setMapViewerReady(boolean bl) {
        this.mapViewerReady = bl;
    }

    public boolean isMapSwitcherReady() {
        return this.mapSwitcherReady;
    }

    public void setMapSwitcherReady(boolean bl) {
        this.mapSwitcherReady = bl;
    }

    public boolean isGoogleAvailableInServiceList() {
        return this.googleAvailableInServiceList;
    }

    public void setGoogleAvailableInServiceList(boolean bl) {
        this.googleAvailableInServiceList = bl;
    }
}

