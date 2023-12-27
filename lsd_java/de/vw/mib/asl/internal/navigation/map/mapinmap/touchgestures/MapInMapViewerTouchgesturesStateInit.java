/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerTouchgesturesStateInit
extends AbstractHsmState {
    public static final int[] ATTRIBUTES_MAPVIEWERCONTROL = null;
    private static final int[] OBSERVERS = new int[]{80285760, 97062976, 164171840};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapTouchgesturesStateInit]");
    private final MapInMapViewerTouchgesturesTarget target;

    public MapInMapViewerTouchgesturesStateInit(MapInMapViewerTouchgesturesTarget mapInMapViewerTouchgesturesTarget, String string, HsmState hsmState) {
        super(mapInMapViewerTouchgesturesTarget.getHsm(), string, hsmState);
        this.target = mapInMapViewerTouchgesturesTarget;
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
            case 101003: {
                this.handleNaviTargetPrepareOn(eventGeneric);
                break;
            }
            case 4: {
                this.handleExit();
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
            this.logger.makeTrace().append("handleDefault() ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleNaviTargetPrepareOn(EventGeneric eventGeneric) {
        this.logger.trace("handleNaviTargetPrepareOn()");
        this.initASL();
        this.initDSI();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.transStateMain();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.addObservers(OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerSplitscreen(this.target, ATTRIBUTES_MAPVIEWERCONTROL);
        this.target.notifierDSI.setDsiMapViewerControl(dSIMapViewerControlVW);
    }
}

