/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateDetailScreenGPSInput
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateDetailScreenGPSInput]");
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateDetailScreenGPSInput(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
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
            case 3499004: {
                return this.handleGotoLocation(eventGeneric);
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
    }

    private HsmState handleGotoLocation(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n != 28) {
            return this.myParent;
        }
        Object object = eventGeneric.getObject(1);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleGotoLocation(content=").append(n).append(")").log();
        }
        if (!(object instanceof MapConfiguration)) {
            this.logger.error("Parameter 1 is not an instance of MapConfiguration, the event 'ASLNavigationASLNavigationMapFactory.getNavigationMapApi().EV_MAP_MAIN_CONTENT_GOTO_LOCATION' will not be procedded.");
            return this.myParent;
        }
        MapConfiguration mapConfiguration = (MapConfiguration)object;
        this.target.datapool.getQueuedGotoLocations().put(new Integer(n), mapConfiguration);
        return null;
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        MapConfiguration mapConfiguration = this.target.datapool.getMapConfiguration();
        this.target.notifierDSI.viewFreeze(true);
        this.target.setDetailScreenDefaultDSIValues(false);
        this.target.notifierDSI.setZoomLevel(4234310);
        this.target.moveMap(mapConfiguration);
        this.target.configureDetailMapFlag(mapConfiguration);
        this.target.notifierDSI.viewFreeze(false);
    }
}

