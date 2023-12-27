/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.autozoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerZoomEngineFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public final class MapViewerAutoZoomStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVERS = new int[]{889323584, 476329216, 1331967232, 1197749504, 543438080, 1399076096, 107230464, -1274412992};
    private static final int[] ATTRIBUTES_MAPVIEWER_ZOOMENGINE = new int[]{3};
    private static final int[] ATTRIBUTES_MAPVIEWER_CONTROL = new int[]{9};
    private static final int[] ASL_SERVICES = new int[]{543438080};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerAutoZoomStateInit]");
    private final MapViewerAutoZoomTargetHSM target;

    public MapViewerAutoZoomStateInit(MapViewerAutoZoomTargetHSM mapViewerAutoZoomTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerAutoZoomTargetHSM;
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
            case 101001: {
                this.handleNaviTargetGoOn();
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
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleNaviTargetGoOn() {
        this.logger.trace("handleNaviTargetGoOn()");
        this.initDSI();
        this.initASL();
        this.target.transStateWork();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.initASLServices();
        this.initASLObservers();
    }

    private void initASLObservers() {
        this.logger.trace("initASLObservers()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initASLServices() {
        this.target.registerServices(ASL_SERVICES, false);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER_CONTROL));
        this.target.notifierDSI.setDsiMapViewerZoomEngine(DSIMapViewerZoomEngineFactoryVW.createMapViewerZoomEngine(this.target, ATTRIBUTES_MAPVIEWER_ZOOMENGINE));
        this.target.notifierDSI.setZoomArea(new Rect(0, 0, 800, 480));
        this.target.notifierDSI.setCarPosition(new Point(400, 237));
        this.target.notifierDSI.setViewType(3);
        this.target.notifierDSI.setMapOrientation(0);
        this.target.notifierDSI.setMapRotation((short)0);
    }
}

