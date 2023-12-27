/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerControlVWImpl;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager$1;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager$2;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager$3;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager$4;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManagerClientData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManagerDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionTargetHSM;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerControlListener;

public class DSIMapViewerManager {
    private final DSIMapViewerManagerDataPool datapoolManager;
    private final DSIProxy dsiProxy;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerManager]");
    private final DSIMapViewerStatusTarget[] mapViewerStatusTargets;
    private final DSIMapViewerControlSwitchMapviewerTargetHSM mapViewerSwitchTargetHSMMainMap;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;

    public DSIMapViewerManager() {
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.datapoolManager = new DSIMapViewerManagerDataPool();
        this.mapViewerSwitchTargetHSMMainMap = new DSIMapViewerControlSwitchMapviewerTargetHSM(ServiceManager.eventMain, 1380652032, "hsmtask", this, this.datapoolManager.getDatapoolMainMap());
        this.mapViewerStatusTargets = new DSIMapViewerStatusTarget[4];
        this.mapViewerStatusTargets[0] = new DSIMapViewerStatusTarget(ServiceManager.eventMain, -1337256960, "hsmtask", 0, this.datapoolManager.getDatapoolMainMap(), new DSIMapViewerManager$1(this));
        this.mapViewerStatusTargets[1] = new DSIMapViewerStatusTarget(ServiceManager.eventMain, -1320479744, "hsmtask", 1, this.datapoolManager.getDatapoolMainMap(), new DSIMapViewerManager$2(this));
        this.mapViewerStatusTargets[2] = new DSIMapViewerStatusTarget(ServiceManager.eventMain, -1303702528, "hsmtask", 2, this.datapoolManager.getDatapoolSplitScreenMap(), new DSIMapViewerManager$3(this));
        this.mapViewerStatusTargets[3] = new DSIMapViewerStatusTarget(ServiceManager.eventMain, -1286925312, "hsmtask", 3, this.datapoolManager.getDatapoolKombiMap(), new DSIMapViewerManager$4(this));
    }

    private void createDSIMapViewerControlVW(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n, MapDataPool mapDataPool) {
        this.logger.trace("createDSIMapViewerControlVW()");
        if (dSIMapViewerManagerClientData.getDsiMapViewerControlVW() != null) {
            this.logger.error("A Facade has already been set");
            return;
        }
        dSIMapViewerManagerClientData.setDsiMapViewerControlVW(new DSIMapViewerControlVWImpl(mapDataPool));
    }

    private void createMapViewer(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        this.logger.trace("createMapViewer()");
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("createMapViewerInstance(mapViewerInstanceId=").append(n).append(")").log();
        }
        if (n == 0) {
            this.createDSIMapViewerControlVW(dSIMapViewerManagerClientData, n, this.datapoolManager.getDatapoolMainMap());
            int n2 = this.getMapViewerMainMapCurrentInstanceId();
            if (n2 == 0) {
                this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, n);
                this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, n);
                if (this.datapoolManager.isMapViewerInstance0Available()) {
                    this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, n);
                    this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, n);
                }
            }
        } else if (n == 1) {
            if (this.datapoolManager.isMapViewerInstance1Available()) {
                this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, n);
                this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, n);
                int n3 = this.getMapViewerMainMapCurrentInstanceId();
                if (n3 == 1) {
                    this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, n);
                    this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, n);
                }
            }
        } else if (n == 2) {
            this.createDSIMapViewerControlVW(dSIMapViewerManagerClientData, n, this.datapoolManager.getDatapoolSplitScreenMap());
            if (this.datapoolManager.isMapViewerInstance2Available()) {
                this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, n);
                this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, n);
                this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, n);
                this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, n);
            }
        } else if (n == 3) {
            this.createDSIMapViewerControlVW(dSIMapViewerManagerClientData, n, this.datapoolManager.getDatapoolKombiMap());
            if (this.datapoolManager.isMapViewerInstance3Available()) {
                this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, n);
                this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, n);
                this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, n);
                this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, n);
            }
        } else {
            this.logger.makeError().append("MapViewerId '").append(n).append("' is unknown, execution stopped");
            return;
        }
    }

    private DSIMapViewerControl createMapViewer(int n, AbstractTarget abstractTarget) {
        DSIMapViewerControl dSIMapViewerControl = (DSIMapViewerControl)this.dsiProxy.getService(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, n);
        return dSIMapViewerControl;
    }

    public DSIMapViewerControlVW createMapViewerKombi(DSIMapViewerManagerClientData dSIMapViewerManagerClientData) {
        this.logger.trace("createMapViewerMainMapKombi()");
        if (!this.datapoolManager.isCreateMapViewerKombiEnabled()) {
            this.logger.error("creating new MapViewerKombi is currently disabled");
            return null;
        }
        this.createMapViewer(dSIMapViewerManagerClientData, 3);
        this.datapoolAddKombiTarget(dSIMapViewerManagerClientData);
        return dSIMapViewerManagerClientData.getDsiMapViewerControlVW();
    }

    private DSIMapViewerControlListener createMapViewerListener(AbstractTarget abstractTarget) {
        DSIMapViewerControlListener dSIMapViewerControlListener;
        if (abstractTarget instanceof AbstractASLHsmTarget) {
            AbstractASLHsmTarget abstractASLHsmTarget = (AbstractASLHsmTarget)abstractTarget;
            dSIMapViewerControlListener = this.createMapViewerListenerInstance(abstractASLHsmTarget.getHsm());
        } else {
            dSIMapViewerControlListener = this.createMapViewerListenerInstance(abstractTarget);
        }
        return dSIMapViewerControlListener;
    }

    private DSIMapViewerControlListener createMapViewerListenerInstance(AbstractTarget abstractTarget) {
        this.logger.trace("createMapViewerListenerInstance()");
        DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)this.dsiProxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener);
        return dSIMapViewerControlListener;
    }

    private DSIMapViewerControlListener createMapViewerListenerInstance(Hsm hsm) {
        this.logger.trace("createMapViewerListenerInstance()");
        DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)this.dsiProxy.getAdapterFactory().createDSIListenerMethodAdapter(hsm, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener);
        return dSIMapViewerControlListener;
    }

    public DSIMapViewerControlVW createMapViewerMainMap(DSIMapViewerManagerClientData dSIMapViewerManagerClientData) {
        this.logger.trace("createMapViewerMainMapOnboard()");
        if (!this.datapoolManager.isCreateMapViewerMainEnabled()) {
            this.logger.error("creating new MapViewer is currently disabled");
            return null;
        }
        this.createMapViewer(dSIMapViewerManagerClientData, 0);
        if (this.datapoolManager.isMapViewerInstance1Available()) {
            this.createMapViewer(dSIMapViewerManagerClientData, 1);
        }
        this.datapoolAddMainMapTarget(dSIMapViewerManagerClientData);
        return dSIMapViewerManagerClientData.getDsiMapViewerControlVW();
    }

    public DSIMapViewerControlVW createMapViewerSpliscreenMapOnboard(DSIMapViewerManagerClientData dSIMapViewerManagerClientData) {
        this.logger.trace("createMapViewerSpliscreenMapOnboard()");
        if (!this.datapoolManager.isCreateMapViewerMainEnabled()) {
            this.logger.error("creating new MapViewer is currently disabled");
            return null;
        }
        this.createMapViewer(dSIMapViewerManagerClientData, 2);
        this.datapoolAddSplitscreenTarget(dSIMapViewerManagerClientData);
        return dSIMapViewerManagerClientData.getDsiMapViewerControlVW();
    }

    private void datapoolAddKombiTarget(DSIMapViewerManagerClientData dSIMapViewerManagerClientData) {
        List list = this.datapoolManager.getMapTargetsKombi();
        list.add(dSIMapViewerManagerClientData);
    }

    private void datapoolAddMainMapTarget(DSIMapViewerManagerClientData dSIMapViewerManagerClientData) {
        List list = this.datapoolManager.getMapTargetsMain();
        list.add(dSIMapViewerManagerClientData);
    }

    private void datapoolAddSplitscreenTarget(DSIMapViewerManagerClientData dSIMapViewerManagerClientData) {
        List list = this.datapoolManager.getMapTargetsSplitscreen();
        list.add(dSIMapViewerManagerClientData);
    }

    public MapDataPool getDatapoolKombiMap() {
        return this.datapoolManager.getDatapoolKombiMap();
    }

    public MapDataPool getDatapoolMainMap() {
        return this.datapoolManager.getDatapoolMainMap();
    }

    public MapDataPool getDatapoolSplitScreenMap() {
        return this.datapoolManager.getDatapoolSplitScreenMap();
    }

    public List getMapTargtesMain() {
        return this.datapoolManager.getMapTargetsMain();
    }

    public int getMapViewerMainMapCurrentInstanceId() {
        return this.mapViewerSwitchTargetHSMMainMap.getDatapool().getDsiMapViewerControlCurrentMainMapInstanceId();
    }

    public DSIMapViewerStatusTarget[] getMapViewerManagerTargetStatus() {
        return this.mapViewerStatusTargets;
    }

    public DSIMapViewerControlSwitchMapviewerTargetHSM getMapViewerManagerTargetSwitchMainMap() {
        return this.mapViewerSwitchTargetHSMMainMap;
    }

    private void initGetInfoForScreenPositionTargetMainGoogleEarth() {
        if (this.datapoolManager.getMapViewerInstance1GetInfoForScreenPositionTargetHSM() == null) {
            try {
                DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM = new DSIMapViewerGetInfoForScreenPositionTargetHSM(ServiceManager.eventMain, -1219816448, "hsmtask", 1);
                this.datapoolManager.setMapViewerInstance1GetInfoForScreenPositionTargetHSM(dSIMapViewerGetInfoForScreenPositionTargetHSM);
                DSIMapViewerControl dSIMapViewerControl = this.createMapViewer(1, dSIMapViewerGetInfoForScreenPositionTargetHSM);
                DSIMapViewerControlListener dSIMapViewerControlListener = this.createMapViewerListener(dSIMapViewerGetInfoForScreenPositionTargetHSM);
                this.dsiProxy.addResponseListener(dSIMapViewerGetInfoForScreenPositionTargetHSM, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 1, dSIMapViewerControlListener);
                dSIMapViewerGetInfoForScreenPositionTargetHSM.setMapViewer(dSIMapViewerControl);
                dSIMapViewerGetInfoForScreenPositionTargetHSM.getHsm().onStart();
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(106);
                eventGeneric.setReceiverEventId(106);
                dSIMapViewerGetInfoForScreenPositionTargetHSM.gotEvent(eventGeneric);
            }
            catch (Exception exception) {
                this.logger.makeError().append("Exception while initGetInfoForScreenPositionTargetMainGoogleEarth(): ").append(exception.toString()).log();
            }
        } else {
            DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM = this.datapoolManager.getMapViewerInstance1GetInfoForScreenPositionTargetHSM();
            DSIMapViewerControl dSIMapViewerControl = this.createMapViewer(1, dSIMapViewerGetInfoForScreenPositionTargetHSM);
            dSIMapViewerGetInfoForScreenPositionTargetHSM.setMapViewer(dSIMapViewerControl);
        }
    }

    private void initGetInfoForScreenPositionTargetMainOnboard() {
        if (this.datapoolManager.getMapViewerInstance0GetInfoForScreenPositionTargetHSM() == null) {
            try {
                DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM = new DSIMapViewerGetInfoForScreenPositionTargetHSM(ServiceManager.eventMain, -1236593664, "hsmtask", 0);
                this.datapoolManager.setMapViewerInstance0GetInfoForScreenPositionTargetHSM(dSIMapViewerGetInfoForScreenPositionTargetHSM);
                DSIMapViewerControl dSIMapViewerControl = this.createMapViewer(0, dSIMapViewerGetInfoForScreenPositionTargetHSM);
                DSIMapViewerControlListener dSIMapViewerControlListener = this.createMapViewerListener(dSIMapViewerGetInfoForScreenPositionTargetHSM);
                this.dsiProxy.addResponseListener(dSIMapViewerGetInfoForScreenPositionTargetHSM, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, 0, dSIMapViewerControlListener);
                dSIMapViewerGetInfoForScreenPositionTargetHSM.setMapViewer(dSIMapViewerControl);
                dSIMapViewerGetInfoForScreenPositionTargetHSM.clearQueue();
                dSIMapViewerGetInfoForScreenPositionTargetHSM.getHsm().onStart();
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(106);
                eventGeneric.setReceiverEventId(106);
                dSIMapViewerGetInfoForScreenPositionTargetHSM.gotEvent(eventGeneric);
            }
            catch (Exception exception) {
                this.logger.makeError().append("Exception while initGetInfoForScreenPositionTargetMainOnboard(): ").append(exception.toString()).log();
            }
        } else {
            DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM = this.datapoolManager.getMapViewerInstance0GetInfoForScreenPositionTargetHSM();
            DSIMapViewerControl dSIMapViewerControl = this.createMapViewer(0, dSIMapViewerGetInfoForScreenPositionTargetHSM);
            dSIMapViewerGetInfoForScreenPositionTargetHSM.setMapViewer(dSIMapViewerControl);
        }
    }

    private void initGoogleEarthMapViewers() {
        List list = this.datapoolManager.getMapTargetsMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            this.createMapViewer(dSIMapViewerManagerClientData, 1);
        }
    }

    public boolean isGoogleEarthRegistered() {
        return this.datapoolManager.isGoogleEarthRegistered();
    }

    protected void mapViewer0NotReady() {
        this.datapoolManager.setMapViewerInstance0Available(false);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMainNotReady();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMainNotReadyToNavStartupTarget();
    }

    protected void mapViewer0Ready() {
        List list = this.datapoolManager.getMapTargetsMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, 0);
            this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, 0);
            this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, 0);
            this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, 0);
        }
        this.datapoolManager.setMapViewerInstance0Available(true);
        this.initGetInfoForScreenPositionTargetMainOnboard();
        this.mapViewerFacadesSetStatusMainMap(true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMainReady();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMainReadyToNavStartupTarget();
    }

    protected void mapViewer1NotReady() {
        this.logger.trace("mapViewer1NotReady()");
        this.datapoolManager.setMapViewerInstance1Available(false);
        this.mapViewersRemoveGoogleEarthInstances();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceGoogleNotReady();
    }

    protected void mapViewer1Ready() {
        this.logger.trace("mapViewer1Ready()");
        try {
            this.datapoolManager.setMapViewerInstance1Available(true);
            this.initGetInfoForScreenPositionTargetMainGoogleEarth();
            this.initGoogleEarthMapViewers();
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceGoogleReady();
        }
        catch (Exception exception) {
            this.logger.makeError().append("Exception while Google Earth initialization: ").append(exception.toString()).log();
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    protected void mapViewer2NotReady() {
        this.logger.trace("mapViewer2NotReady()");
        this.datapoolManager.setMapViewerInstance2Available(false);
        this.mapViewerFacadesSetStatusMapInMap(false);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMapInMapNotReady();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMapInMapNotReadyToNavStartupTarget();
    }

    protected void mapViewer2Ready() {
        this.logger.trace("mapViewer2Ready()");
        List list = this.datapoolManager.getMapTargetsSplitscreen();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, 2);
            this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, 2);
            this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, 2);
            this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, 2);
        }
        this.mapViewerFacadesSetStatusMapInMap(true);
        this.datapoolManager.setMapViewerInstance2Available(true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMapInMapReady();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceMapInMapReadyToNavStartupTarget();
    }

    protected void mapViewer3NotReady() {
        this.logger.trace("mapViewer3NotReady()");
        this.datapoolManager.setMapViewerInstance3Available(false);
        this.mapViewerFacadesSetStatusKombiMap(false);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceKombiNotReady();
    }

    protected void mapViewer3Ready() {
        this.logger.trace("mapViewer3Ready()");
        this.datapoolManager.setMapViewerInstance3Available(true);
        List list = this.datapoolManager.getMapTargetsKombi();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            this.targetDataAddMapViewerInstance(dSIMapViewerManagerClientData, 3);
            this.targetDataAddMapViewerListener(dSIMapViewerManagerClientData, 3);
            this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, 3);
            this.targetDataSetActiveMapViewer(dSIMapViewerManagerClientData, 3);
        }
        this.mapViewerFacadesSetStatusKombiMap(true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapInstanceKombiReady();
    }

    private void mapViewerFacadesSetStatus(boolean bl, List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            DSIMapViewerControlVWImpl dSIMapViewerControlVWImpl = dSIMapViewerManagerClientData.getDsiMapViewerControlVW();
            dSIMapViewerControlVWImpl.setFacadeEnabled(bl);
        }
    }

    private void mapViewerFacadesSetStatusKombiMap(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("mapViewerFacadesMapSetStatusKombiMap(enabled=").append(bl).append(")").log();
        }
        this.mapViewerFacadesSetStatus(bl, this.datapoolManager.getMapTargetsMain());
    }

    public void mapViewerFacadesSetStatusMainMap(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("mapViewerFacadesSetStatusMainMap(enabled=").append(bl).append(")").log();
        }
        this.mapViewerFacadesSetStatus(bl, this.datapoolManager.getMapTargetsMain());
    }

    private void mapViewerFacadesSetStatusMapInMap(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("mapViewerFacadesSetStatusMapInMap(enabled=").append(bl).append(")").log();
        }
        this.mapViewerFacadesSetStatus(bl, this.datapoolManager.getMapTargetsMain());
    }

    public void mapViewerFacadesUpdateMapViewer(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("mapViewerFacadesUpdateMapViewer(mapViewerIdNew=").append(n).append(")").log();
        }
        List list = this.getMapTargtesMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            DSIMapViewerControlVWImpl dSIMapViewerControlVWImpl = dSIMapViewerManagerClientData.getDsiMapViewerControlVW();
            DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
            if (n == 0) {
                dSIMapViewerControlVWImpl.setInstanceId(0);
                dSIMapViewerControlVWImpl.setDsiMapViewerControl(dSIMapViewerControlArray[0]);
                continue;
            }
            if (n != 1) continue;
            dSIMapViewerControlVWImpl.setInstanceId(1);
            dSIMapViewerControlVWImpl.setDsiMapViewerControl(dSIMapViewerControlArray[1]);
        }
    }

    private void mapViewerResponseListenerAndNotificationRemove(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        DSIMapViewerControlListener dSIMapViewerControlListener;
        DSIMapViewerControl dSIMapViewerControl;
        DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
        DSIMapViewerControlListener[] dSIMapViewerControlListenerArray = dSIMapViewerManagerClientData.getMapViewerControlListenerAvailable();
        AbstractTarget abstractTarget = dSIMapViewerManagerClientData.getTarget();
        if (n == 0) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else if (n == 1) {
            if (!this.isGoogleEarthRegistered()) {
                return;
            }
            dSIMapViewerControl = dSIMapViewerControlArray[1];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[1];
        } else if (n == 2) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else if (n == 0) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else {
            this.logger.makeError().append("MapViewerId '").append(n).append("' is unknown, execution stopped");
            return;
        }
        this.dsiProxy.removeResponseListener(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, n, dSIMapViewerControlListener);
        int[] nArray = dSIMapViewerManagerClientData.getAttributes();
        if (nArray != null && nArray.length > 0) {
            dSIMapViewerControl.clearNotification(nArray, (DSIListener)dSIMapViewerControlListener);
        }
    }

    private void mapViewersRemoveGoogleEarthInstances() {
        this.logger.trace("mapViewersRemoveGoogleEarthInstances()");
        List list = this.datapoolManager.getMapTargetsMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
            DSIMapViewerControlListener[] dSIMapViewerControlListenerArray = dSIMapViewerManagerClientData.getMapViewerControlListenerAvailable();
            dSIMapViewerManagerClientData.setMapViewerControlAvailable(new DSIMapViewerControl[]{dSIMapViewerControlArray[0]});
            dSIMapViewerManagerClientData.setMapViewerControlListenerAvailable(new DSIMapViewerControlListener[]{dSIMapViewerControlListenerArray[0]});
        }
    }

    public void mapViewersResponseListenerAndNotificationAdd(int n) {
        this.logger.trace("mapViewersResponseListenerAndNotificationAdd()");
        List list = this.datapoolManager.getMapTargetsMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            this.targetDataAddResponseListenerAndNotification(dSIMapViewerManagerClientData, n);
        }
    }

    public void mapViewersResponseListenerAndNotificationRemove(int n) {
        this.logger.trace("mapViewersResponseListenerAndNotificationRemove()");
        List list = this.datapoolManager.getMapTargetsMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            this.mapViewerResponseListenerAndNotificationRemove(dSIMapViewerManagerClientData, n);
        }
    }

    private void removeListenerAndAttributes(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        DSIMapViewerControlListener dSIMapViewerControlListener;
        DSIMapViewerControl dSIMapViewerControl;
        DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
        if (dSIMapViewerControlArray == null || dSIMapViewerControlArray.length == 0) {
            return;
        }
        DSIMapViewerControlListener[] dSIMapViewerControlListenerArray = dSIMapViewerManagerClientData.getMapViewerControlListenerAvailable();
        if (dSIMapViewerControlListenerArray == null || dSIMapViewerControlListenerArray.length == 0) {
            return;
        }
        if (n == 1) {
            if (dSIMapViewerControlArray.length < 2) {
                return;
            }
            if (dSIMapViewerControlListenerArray.length < 2) {
                return;
            }
        }
        if (n == 0) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else if (n == 1) {
            dSIMapViewerControl = dSIMapViewerControlArray[1];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[1];
        } else if (n == 2) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else if (n == 3) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else {
            this.logger.makeWarn().append("InstanceId '").append(n).append("' is invalid").log();
            return;
        }
        if (dSIMapViewerControl != null) {
            try {
                dSIMapViewerControl.clearNotification(dSIMapViewerControlListener);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        } else {
            this.logger.warn("no service instance available");
        }
        if (dSIMapViewerControlListener != null) {
            try {
                this.dsiProxy.removeResponseListener(dSIMapViewerManagerClientData.getTarget(), class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, n, dSIMapViewerControlListener);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        } else {
            this.logger.warn("no service listener instance available");
        }
    }

    public void setCreateMainMapMapViewerEnabled(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setCreateMainMapMapViewerEnabled(createMapViewerEnabled=").append(bl).append(")").log();
        }
        this.datapoolManager.setCreateMapViewerMainEnabled(bl);
    }

    public void setEhCategoryVisibilityOnMapViewer(int n, int[] nArray, boolean[] blArray) {
        if (!this.datapoolManager.isMapViewerInstanceAvailable(n)) {
            this.logger.error(new StringBuffer().append("setEhCategoryVisibilityOnMapViewer() - the MapViewer with instanceId '").append(n).append("' is not available").toString());
            return;
        }
        if (this.mapViewerStatusTargets == null || n < 0 || n >= this.mapViewerStatusTargets.length || this.mapViewerStatusTargets[n] == null) {
            this.logger.error(new StringBuffer().append("setEhCategoryVisibilityOnMapViewer() - the MapViewer with instanceId '").append(n).append("' is not available").toString());
            return;
        }
        this.mapViewerStatusTargets[n].ehSetCategoryVisibility(0, nArray, blArray);
        this.mapViewerStatusTargets[n].ehSetCategoryVisibility(2, nArray, blArray);
    }

    public void setGeneralPoiVisibilityOnMapViewer(int n, boolean bl) {
        boolean bl2 = this.logger.isTraceEnabled();
        if (bl2) {
            this.logger.makeTrace().append("setGeneralPoiVisibilityOnMapViewer(").append(n).append(", ").append(bl).append(" )");
        }
        if (n < 0 || n >= this.mapViewerStatusTargets.length || !this.datapoolManager.isMapViewerInstanceAvailable(n)) {
            if (bl2) {
                this.logger.trace(new StringBuffer().append("instanceId=").append(n).append(", instance available=").append(this.datapoolManager.isMapViewerInstanceAvailable(n)).toString());
            }
            this.logger.error(new StringBuffer().append("setGeneralPoiVisibilityOnMapViewer() - the MapViewer with instanceId '").append(n).append("' is not available").toString());
            return;
        }
        this.mapViewerStatusTargets[n].setGeneralPoiVisibility(bl);
    }

    public void setBrandIconStyleOnMapViewer(int n, int[] nArray, int n2) {
        boolean bl = this.logger.isTraceEnabled();
        if (bl) {
            this.logger.makeTrace().append("setBrandIconStyleOnMapViewer(").append(n).append(", brandUid=").append(nArray).append(", brandIconStyle=").append(n2).append(" )");
        }
        if (n < 0 || n >= this.mapViewerStatusTargets.length || !this.datapoolManager.isMapViewerInstanceAvailable(n)) {
            if (bl) {
                this.logger.trace(new StringBuffer().append("instanceId=").append(n).append(", instance available=").append(this.datapoolManager.isMapViewerInstanceAvailable(n)).toString());
            }
            this.logger.error(new StringBuffer().append("setBrandIconStyleOnMapViewer() - the MapViewer with instanceId '").append(n).append("' is not available").toString());
            return;
        }
        this.mapViewerStatusTargets[n].setBrandIconStyle(nArray, n2);
    }

    public void setEhCategoryVisibilityToOnMapViewer0ToDefault() {
        if (!this.datapoolManager.isMapViewerInstance0Available()) {
            this.logger.error("setEhCategoryVisibilityToOnMapViewer0ToDefault() - the MapViewer with instanceId '0' is not available");
            return;
        }
        if (this.mapViewerStatusTargets == null || this.mapViewerStatusTargets[0] == null) {
            this.logger.error("setEhCategoryVisibilityToOnMapViewer0ToDefault() - the MapViewer with instanceId '0' is not available");
            return;
        }
        this.mapViewerStatusTargets[0].ehSetCategoryVisibilityToDefault(0);
        this.mapViewerStatusTargets[0].ehSetCategoryVisibilityToDefault(2);
    }

    public void setEhCategoryVisibilityToOnMapViewerToDefault(int n) {
        boolean bl = this.logger.isTraceEnabled();
        if (bl) {
            this.logger.trace(new StringBuffer().append("setEhCategoryVisibilityToOnMapViewerToDefault(").append(n).append(")").toString());
        }
        if (n < 0 || n >= this.mapViewerStatusTargets.length || !this.datapoolManager.isMapViewerInstanceAvailable(n)) {
            if (bl) {
                this.logger.trace(new StringBuffer().append("instanceId=").append(n).append(", instance available=").append(this.datapoolManager.isMapViewerInstanceAvailable(n)).toString());
            }
            this.logger.error(new StringBuffer().append("setEhCategoryVisibilityToOnMapViewerToDefault() - the MapViewer with instanceId '").append(n).append("' is not available").toString());
            return;
        }
        DSIMapViewerStatusTarget dSIMapViewerStatusTarget = this.mapViewerStatusTargets[n];
        dSIMapViewerStatusTarget.ehSetCategoryVisibilityToDefault(0);
        dSIMapViewerStatusTarget.ehSetCategoryVisibilityToDefault(2);
    }

    private void targetDataAddMapViewerInstance(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        AbstractTarget abstractTarget = dSIMapViewerManagerClientData.getTarget();
        DSIMapViewerControl dSIMapViewerControl = (DSIMapViewerControl)this.dsiProxy.getService(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, n);
        DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
        if (n == 0) {
            if (dSIMapViewerControlArray == null) {
                dSIMapViewerControlArray = new DSIMapViewerControl[]{dSIMapViewerControl};
            }
        } else if (n == 1) {
            DSIMapViewerControl[] dSIMapViewerControlArray2 = new DSIMapViewerControl[]{dSIMapViewerControlArray[0], dSIMapViewerControl};
            dSIMapViewerControlArray = dSIMapViewerControlArray2;
        } else if (n == 2) {
            dSIMapViewerControlArray = new DSIMapViewerControl[]{dSIMapViewerControl};
        } else if (n == 3) {
            dSIMapViewerControlArray = new DSIMapViewerControl[]{dSIMapViewerControl};
        }
        dSIMapViewerManagerClientData.setMapViewerControlAvailable(dSIMapViewerControlArray);
    }

    private void targetDataAddMapViewerListener(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        DSIMapViewerControlListener[] dSIMapViewerControlListenerArray;
        DSIMapViewerControlListener[] dSIMapViewerControlListenerArray2;
        DSIMapViewerControlListener[] dSIMapViewerControlListenerArray3;
        AbstractTarget abstractTarget = dSIMapViewerManagerClientData.getTarget();
        this.removeListenerAndAttributes(dSIMapViewerManagerClientData, n);
        if (abstractTarget instanceof AbstractASLHsmTarget) {
            dSIMapViewerControlListenerArray3 = (AbstractASLHsmTarget)abstractTarget;
            this.logger.trace("createMapViewerListenerInstance()");
            dSIMapViewerControlListenerArray2 = (DSIMapViewerControlListener[])this.dsiProxy.getAdapterFactory().createDSIListenerMethodAdapter(dSIMapViewerControlListenerArray3.getHsm(), class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener);
            dSIMapViewerControlListenerArray = dSIMapViewerControlListenerArray2;
        } else {
            this.logger.trace("createMapViewerListenerInstance()");
            dSIMapViewerControlListenerArray = dSIMapViewerControlListenerArray3 = (DSIMapViewerControlListener)this.dsiProxy.getAdapterFactory().createDSIListenerMethodAdapter(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener);
        }
        dSIMapViewerControlListenerArray3 = dSIMapViewerManagerClientData.getMapViewerControlListenerAvailable();
        if (n == 0) {
            if (dSIMapViewerControlListenerArray3 == null) {
                dSIMapViewerControlListenerArray3 = new DSIMapViewerControlListener[]{dSIMapViewerControlListenerArray};
            }
        } else if (n == 1) {
            dSIMapViewerControlListenerArray2 = new DSIMapViewerControlListener[]{dSIMapViewerControlListenerArray3[0], dSIMapViewerControlListenerArray};
            dSIMapViewerControlListenerArray3 = dSIMapViewerControlListenerArray2;
        } else if (n == 2) {
            dSIMapViewerControlListenerArray3 = new DSIMapViewerControlListener[]{dSIMapViewerControlListenerArray};
        } else if (n == 3) {
            dSIMapViewerControlListenerArray3 = new DSIMapViewerControlListener[]{dSIMapViewerControlListenerArray};
        }
        dSIMapViewerManagerClientData.setMapViewerControlListenerAvailable(dSIMapViewerControlListenerArray3);
    }

    private void targetDataAddResponseListenerAndNotification(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        DSIMapViewerControlListener dSIMapViewerControlListener;
        DSIMapViewerControl dSIMapViewerControl;
        DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
        DSIMapViewerControlListener[] dSIMapViewerControlListenerArray = dSIMapViewerManagerClientData.getMapViewerControlListenerAvailable();
        AbstractTarget abstractTarget = dSIMapViewerManagerClientData.getTarget();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("targetDataAddResponseListenerAndNotification( targetId = ").append(abstractTarget.getTargetId()).append(" )").log();
        }
        if (n == 0) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else if (n == 1) {
            dSIMapViewerControl = dSIMapViewerControlArray[1];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[1];
        } else if (n == 2) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else if (n == 3) {
            dSIMapViewerControl = dSIMapViewerControlArray[0];
            dSIMapViewerControlListener = dSIMapViewerControlListenerArray[0];
        } else {
            this.logger.makeError().append("serviceInstanceId '").append(n).append("' is unknown, execution stopped");
            return;
        }
        this.dsiProxy.addResponseListener(abstractTarget, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerManager.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, n, dSIMapViewerControlListener);
        int[] nArray = dSIMapViewerManagerClientData.getAttributes();
        if (nArray != null && nArray.length > 0) {
            dSIMapViewerControl.setNotification(nArray, (DSIListener)dSIMapViewerControlListener);
        }
    }

    private void targetDataSetActiveMapViewer(DSIMapViewerManagerClientData dSIMapViewerManagerClientData, int n) {
        DSIMapViewerControlVWImpl dSIMapViewerControlVWImpl = dSIMapViewerManagerClientData.getDsiMapViewerControlVW();
        if (n == 0) {
            dSIMapViewerControlVWImpl.setInstanceId(0);
            dSIMapViewerControlVWImpl.setDsiMapViewerControl(dSIMapViewerManagerClientData.getMapViewerControlAvailable()[0]);
            dSIMapViewerControlVWImpl.setFacadeEnabled(true);
        } else if (n == 1) {
            dSIMapViewerControlVWImpl.setInstanceId(1);
            dSIMapViewerControlVWImpl.setDsiMapViewerControl(dSIMapViewerManagerClientData.getMapViewerControlAvailable()[1]);
            dSIMapViewerControlVWImpl.setFacadeEnabled(true);
        } else if (n == 2) {
            dSIMapViewerControlVWImpl.setInstanceId(2);
            dSIMapViewerControlVWImpl.setDsiMapViewerControl(dSIMapViewerManagerClientData.getMapViewerControlAvailable()[0]);
            dSIMapViewerControlVWImpl.setFacadeEnabled(true);
        } else if (n == 3) {
            dSIMapViewerControlVWImpl.setInstanceId(3);
            dSIMapViewerControlVWImpl.setDsiMapViewerControl(dSIMapViewerManagerClientData.getMapViewerControlAvailable()[0]);
            dSIMapViewerControlVWImpl.setFacadeEnabled(true);
        }
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

