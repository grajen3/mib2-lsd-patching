/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateNoMap
extends AbstractHsmState {
    IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateNoMap]");
    MapContentChangerTargetHSM target;

    public MapContentChangerStateNoMap(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
        super(mapContentChangerTargetHSM.getHsm(), string, hsmState);
        this.target = mapContentChangerTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.handleStart();
                break;
            }
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742382: {
                return this.handleSetContent(eventGeneric);
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
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(", params: ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.viewSetVisible();
    }

    private HsmState handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.datapool.setMainMapContent(n);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetContent(content=").append(n).append(")").log();
        }
        if (n == 255) {
            return null;
        }
        return this.myParent;
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(139) && this.target.datapool.isMapLocatedInKombi()) {
            this.logger.trace("Ignore viewSetInvisible as Map is currently located at FPK.");
            return;
        }
        this.viewSetInvisible();
    }

    private void viewSetInvisible() {
        this.logger.trace("viewSetInvisible()");
        if (this.target.datapool.isViewVisible()) {
            this.target.notifierDSI.viewSetVisible(false);
        }
    }

    private void viewSetVisible() {
        this.logger.trace("viewSetVisible()");
        if (!this.target.datapool.isViewVisible()) {
            this.target.notifierDSI.viewSetVisible(true);
        }
    }
}

