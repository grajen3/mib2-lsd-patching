/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapSetupStateInit
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapSetupStateInit]");
    private final MapSetupTargetHSM target;

    public MapSetupStateInit(MapSetupTargetHSM mapSetupTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
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
        this.initModel();
        this.sendVisibleCategoryUids();
        this.target.datapool.setAdbEntryChanged(true);
        this.target.transStateMain();
    }

    private void initModel() {
        this.logger.trace("initModel()");
        this.target.setPersistedModelValues();
    }

    private void sendVisibleCategoryUids() {
        int[] nArray = this.target.datapool.getVisibleCategoryUids();
        if (this.target.datapool.getVisibleCategoryUids() != null) {
            this.target.datapool.setVisibleCategoryUids(null);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainEhSetCategoryVisibilityResult(nArray);
        }
    }
}

