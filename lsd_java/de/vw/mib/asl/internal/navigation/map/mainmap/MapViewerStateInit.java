/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateInit$1;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerStateInit$2;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class MapViewerStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVER = new int[]{1409417280, 1442971712, 420151360, 1325531200, 727987456, 1607012416, 1674121280, 929314048, 946091264, -1274412992};
    private static final int[] ASL_SERVICES = new int[]{476329216, 727987456, 1063531776};
    private static final int[] ATTRIBUTES_MAPVIEWER_CONTROL = new int[]{12, 11, 9, 10, 13};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStateInit]");
    private final MapViewerTargetHSM target;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public MapViewerStateInit(MapViewerTargetHSM mapViewerTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTargetHSM;
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
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(",Params=").append(eventGeneric.getParamString()).log();
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
        this.initSpeechEngine();
        this.target.transStateWork();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.registerServices(ASL_SERVICES, false);
    }

    private void initASL() {
        this.target.addObservers(ASL_OBSERVER);
        NavLocation navLocation = this.target.datapool.getDefaultLocation();
        if (navLocation == null) {
            this.logger.trace("Map-Viewer: Init: Default location was still null.");
            return;
        }
        this.target.datapool.setMapPosition(navLocation);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER_CONTROL));
    }

    private void initSpeechEngine() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        MapViewerStateInit$1 mapViewerStateInit$1 = new MapViewerStateInit$1(this);
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = MapViewerStateInit.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)new MapViewerStateInit$2(this, bundleContext, mapViewerStateInit$1));
        serviceTracker.open();
    }

    static /* synthetic */ MapViewerTargetHSM access$000(MapViewerStateInit mapViewerStateInit) {
        return mapViewerStateInit.target;
    }

    static /* synthetic */ IExtLogger access$100(MapViewerStateInit mapViewerStateInit) {
        return mapViewerStateInit.logger;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

