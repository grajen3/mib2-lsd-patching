/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse;
import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse2;
import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeService;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN$1;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN$2;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN$ValetParkingListenerWLAN;
import de.vw.mib.asl.internal.connectivity.StateWLANMain;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANHotspotHotspotListCollector;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

public class HsmTargetWLAN
extends AbstractASLHsmTarget
implements FlightmodeService {
    public final DSIWLAN dsiWLANService;
    public final DSIPowerManagement dsiPowerManagementService;
    final DSIListener dsiWLANListener;
    final DSIListener dsiPowerManagementListener;
    ValetParkingListener valetParkingListener;
    private static final int[] OBSERVERS = new int[]{0x11010040, 554303552, 419496000, 1611465536, 520159296, 553713728, 269156416, 235601984, 252379200, 285933632, 906690624, 1208680512, 1108149056, 638255168, 621477952, 722141248, 705364032, 688586816, 772472896, 655032384, 738918464, 671809600, 755695680, -1224081344, -1207304128, 1594688320, 1259144000, 1376584512, 1393361728, 1410138944, 1477247808, -1173749696, -1190526912, -703987648, 1527579456, 1544356672, -913235712, 295518464};
    private static final int[] ATTRIBUTES_WLAN = new int[]{22, 12, 17, 1, 19, 20, 21, 13, 23, 24};
    private static final int[] ATTRIBUTES_POWERMANAGEMENT = new int[]{3, 4};
    final StateWLANMain stateWLANMain;
    protected ASLAPISpellerBinding spellerHsmConnectivity;
    protected ConnectivityWLANHotspotHotspotListCollector[] discoveredNetworks;
    protected ConnectivityWLANHotspotHotspotListCollector[] unavailableTrustedNetworks;
    private boolean alreadyRegistered;
    private boolean flightmode;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLANListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$connectivity$services$flightmode$FlightmodeService;

    public HsmTargetWLAN(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateWLANMain = new StateWLANMain(this, this.hsm, "stateWLANMain", this.getWorkStateParent());
        this.alreadyRegistered = false;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiWLANService = (DSIWLAN)dSIProxy.getService(this, class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = HsmTargetWLAN.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN);
        this.dsiPowerManagementService = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetWLAN.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiWLANListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$networking$DSIWLANListener == null ? (class$org$dsi$ifc$networking$DSIWLANListener = HsmTargetWLAN.class$("org.dsi.ifc.networking.DSIWLANListener")) : class$org$dsi$ifc$networking$DSIWLANListener);
        this.dsiPowerManagementListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmTargetWLAN.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
    }

    @Override
    public int getDefaultTargetId() {
        return 7800;
    }

    void init() {
        if (!this.alreadyRegistered) {
            this.addObservers(OBSERVERS);
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$networking$DSIWLANListener == null ? (class$org$dsi$ifc$networking$DSIWLANListener = HsmTargetWLAN.class$("org.dsi.ifc.networking.DSIWLANListener")) : class$org$dsi$ifc$networking$DSIWLANListener, this.dsiWLANListener);
            this.spellerHsmConnectivity = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(347, -1173749696, -1190526912, -703987648);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5602, 5);
            this.send(eventGeneric);
            this.discoveredNetworks = new ConnectivityWLANHotspotHotspotListCollector[0];
            this.unavailableTrustedNetworks = new ConnectivityWLANHotspotHotspotListCollector[0];
            ListManager.getGenericASLList(4004).updateList(this.discoveredNetworks);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$connectivity$services$flightmode$FlightmodeService == null ? (class$de$vw$mib$asl$api$connectivity$services$flightmode$FlightmodeService = HsmTargetWLAN.class$("de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeService")) : class$de$vw$mib$asl$api$connectivity$services$flightmode$FlightmodeService, this);
        }
        this.alreadyRegistered = true;
    }

    void initValetParking() {
        this.valetParkingListener = new HsmTargetWLAN$ValetParkingListenerWLAN(this, null);
        this.valetParkingListener.notifyValetParkingStateChanged(ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState(), null);
        ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this.valetParkingListener);
    }

    protected void setNotification() {
        this.dsiWLANService.setNotification(ATTRIBUTES_WLAN, this.dsiWLANListener);
        this.dsiPowerManagementService.setNotification(ATTRIBUTES_POWERMANAGEMENT, this.dsiPowerManagementListener);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWLANMain;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void setFlightmode(boolean bl, FlightmodeResponse flightmodeResponse) {
        this.setFlightmode(bl, new HsmTargetWLAN$1(this, flightmodeResponse));
    }

    @Override
    public void setFlightmode(boolean bl, FlightmodeResponse2 flightmodeResponse2) {
        this.flightmode = bl;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(-1309788672, eventGeneric);
        if (this.valetParkingListener == null) {
            flightmodeResponse2.responseSetFlightmode(true, this.getFlightmode());
        } else {
            this.valetParkingListener.notifyValetParkingStateChanged(bl, new HsmTargetWLAN$2(this, flightmodeResponse2));
        }
    }

    private int getFlightmode() {
        if (this.flightmode) {
            return 1;
        }
        return 2;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$100(HsmTargetWLAN hsmTargetWLAN) {
        return hsmTargetWLAN.getFlightmode();
    }
}

