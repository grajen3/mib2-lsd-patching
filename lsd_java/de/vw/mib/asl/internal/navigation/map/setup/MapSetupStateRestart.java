/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapSetupStateRestart
extends AbstractHsmState {
    private final IExtLogger logger;
    private final MapSetupTargetHSM target;
    private boolean splitScreenFeatureActive = ServiceManager.configManagerDiag.isFeatureFlagSet(163);

    public MapSetupStateRestart(MapSetupTargetHSM mapSetupTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapSetupStateRestartEarly]");
        this.target = mapSetupTargetHSM;
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
            case 3499016: {
                this.handleMapReady(140784896);
                break;
            }
            case 3499014: {
                this.handleMapReady(107230464);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleMapReady(int n) {
        switch (n) {
            case 3499016: {
                this.target.datapool.setMapInMapReady(true);
                break;
            }
            case 3499014: {
                this.target.datapool.setMainMapReady(true);
                break;
            }
        }
        if (this.target.datapool.isMainMapReady() && (this.target.datapool.isMapInMapReady() || !this.splitScreenFeatureActive)) {
            this.target.initDayNightMode();
            this.target.initMapForRendering();
            this.target.transStateMain();
        }
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
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
}

