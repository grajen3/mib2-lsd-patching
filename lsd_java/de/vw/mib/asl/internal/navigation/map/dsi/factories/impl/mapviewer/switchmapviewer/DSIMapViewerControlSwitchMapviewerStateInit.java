/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerGoogleCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerControlListener;

public class DSIMapViewerControlSwitchMapviewerStateInit
extends AbstractHsmState {
    public static final int[] ASL_OBSERVERS = new int[]{1728708672, 174339328, 191116544, 92733696};
    public static final int[] ATTRIBUTES_MAPVIEWER_CONTROL = new int[]{37, 1, 8};
    public static final int[] ALS_SERVICES = new int[]{627324160};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateInit]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;

    public DSIMapViewerControlSwitchMapviewerStateInit(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapViewerRunLevel(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapViewerRunLevel(").append(n).append(")").log();
        }
        if (n == 4) {
            this.target.transStateGoogleEarthStart();
        }
        return null;
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
            case 3499018: {
                this.handleGooglEarthReady();
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
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGooglEarthReady() {
        this.logger.trace("handleGooglEarthReady()");
        this.initMapViewerInstance();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.initASLServices();
        this.initASLObserver();
    }

    private void initASLObserver() {
        this.logger.trace("initASLObserver()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initASLServices() {
        this.logger.trace("initASLServices()");
        this.target.registerServices(ALS_SERVICES, false);
    }

    private void initMapViewerInstance() {
        this.logger.trace("initMapViewerInstance()");
        DSIMapViewerControl dSIMapViewerControl = (DSIMapViewerControl)this.target.proxy.getService(this.target, class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerControlSwitchMapviewerStateInit.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 0);
        DSIMapViewerControl[] dSIMapViewerControlArray = new DSIMapViewerControl[]{dSIMapViewerControl};
        this.target.datapool.setDsiMapViewerControlCurrentMainMap(dSIMapViewerControl);
        this.target.datapool.setDsiMapViewerControlsMainMap(dSIMapViewerControlArray);
        this.target.datapool.setDsiMapViewerControlCurrentMainMapInstanceId(0);
        DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)this.target.proxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateInit.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener);
        this.target.datapool.setDsiMapViewerControlListener(dSIMapViewerControlListener);
        this.target.proxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlSwitchMapviewerStateInit.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 0, dSIMapViewerControlListener);
        dSIMapViewerControl.setNotification(ATTRIBUTES_MAPVIEWER_CONTROL, (DSIListener)dSIMapViewerControlListener);
        this.target.notifierDSI.setMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlFactoryVW.createMapViewerGoogleCtrl(this.target, null));
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

