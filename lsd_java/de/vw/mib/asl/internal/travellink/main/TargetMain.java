/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.main;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.main.StateTopMain;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.travellink.DSITravelLinkCommon;

public final class TargetMain
extends AbstractASLHsmTarget
implements DSIServiceStateListener,
TravelLinkTarget {
    final HsmState stateTopMain;
    DSIListener dsiTravelLinkCommonListener = null;
    private static boolean setNotificationDone = false;
    static /* synthetic */ Class class$org$dsi$ifc$travellink$DSITravelLinkCommon;
    static /* synthetic */ Class class$org$dsi$ifc$travellink$DSITravelLinkCommonListener;

    public TargetMain(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.hsm.verbose = false;
        TLinkServiceManager.genericEvents = genericEvents;
        TLinkServiceManager.taskId = string;
        TLinkServiceManager.getServiceManager().setTargetMain(this);
        this.stateTopMain = new StateTopMain(this.hsm, "stateTopMain", this.getWorkStateParent());
        TLinkServiceManager.getServiceManager().setStateTopMain(this.stateTopMain);
    }

    @Override
    public int getDefaultTargetId() {
        return 1642272256;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateTopMain;
    }

    @Override
    public void registered(String string, int n) {
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopMain() {
        return this.stateTopMain;
    }

    @Override
    public void registerObservers() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TargetMain - registerObservers()").log();
        }
        this.addObserver(278741248);
        this.addObserver(2115511104);
        this.addObserver(-1474813120);
        this.addObserver(1645749056);
        this.addObserver(1746412352);
        this.addObserver(1729635136);
        this.addObserver(1862991936);
        this.addObserver(1896546368);
        this.addObserver(1829437504);
        this.addObserver(1879769152);
        this.addObserver(-1458035904);
        this.addObserver(1913323584);
        this.addObserver(-1307040960);
        this.addObserver(-2095570112);
        this.addObserver(1846214720);
        this.addObserver(-1290263744);
        this.addObserver(-2045238464);
        this.addObserver(-2028461248);
        this.addObserver(-1340595392);
        this.addObserver(-1323818176);
        this.addObserver(1191903296);
        this.addObserver(1679303488);
        this.addObserver(1998070592);
        this.addObserver(2132288320);
        this.addObserver(2014847808);
        this.addObserver(2031625024);
        this.addObserver(1779966784);
        this.addObserver(1712857920);
        this.addObserver(-1676139712);
        this.addObserver(1796744000);
        this.addObserver(2098733888);
        this.addObserver(-1407704256);
        this.addObserver(-1390927040);
        this.addObserver(-1441258688);
        this.addObserver(1863852864);
        this.addObserver(-2011684032);
        this.addObserver(-2129124544);
        this.addObserver(-2112347328);
        this.addObserver(1914184512);
        this.addObserver(1930961728);
        this.addObserver(1947738944);
        this.addObserver(1964516160);
        this.addObserver(1981293376);
        this.addObserver(1897407296);
        this.addObserver(-1895104448);
        this.addObserver(1696080704);
        this.addObserver(-2145901760);
        this.addObserver(1763189568);
        this.addObserver(-2078792896);
        this.addObserver(-2062015680);
        this.addObserver(1813521216);
        this.addObserver(1830298432);
        this.addObserver(1662526272);
        this.addObserver(-1878327232);
        this.addObserver(-1827134656);
        this.addObserver(-1810357440);
        this.addObserver(-1726471360);
        this.addObserver(-1709694144);
        this.addObserver(-1793580224);
        this.addObserver(-1776803008);
        this.addObserver(-1994906816);
        this.addObserver(-1978129600);
        this.addObserver(-1961352384);
        this.addObserver(-1944575168);
        this.addObserver(-1927797952);
        this.addObserver(-1894243520);
        this.addObserver(-1911020736);
        this.addObserver(-1760025792);
        this.addObserver(-1760025792);
        this.addObserver(-1743248576);
        this.addObserver(-1692916928);
        this.addObserver(-1659362496);
        this.addObserver(-1877466304);
        this.addObserver(-1860689088);
        this.addObserver(-1843911872);
        this.addObserver(-1642585280);
        this.addObserver(-1625808064);
        this.addObserver(-1541921984);
        this.addObserver(-1558699200);
        this.addObserver(-1575476416);
        this.addObserver(-1592253632);
        this.addObserver(-1424481472);
        this.addObserver(-1525144768);
        this.addObserver(-1609030848);
        this.addObserver(-1273486528);
        this.addObserver(-1256709312);
        this.addObserver(1524708096);
        this.addObserver(1491153664);
        this.addObserver(1507930880);
        this.addObserver(1457599232);
        this.addObserver(1340158720);
        this.addObserver(1323381504);
        this.addObserver(1424044800);
        this.addObserver(1373713152);
        this.addObserver(1306604288);
        this.addObserver(1440822016);
        this.addObserver(1390490368);
        this.addObserver(1407267584);
        this.addObserver(1273049856);
        this.addObserver(1356935936);
        this.addObserver(614285568);
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("EVENT_SERVICE_INIT is registered...").log();
        }
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        TLinkServiceManager.getServiceManager().setDSITravelLinkCommon((DSITravelLinkCommon)dSIServiceLocator.getService(this, class$org$dsi$ifc$travellink$DSITravelLinkCommon == null ? (class$org$dsi$ifc$travellink$DSITravelLinkCommon = TargetMain.class$("org.dsi.ifc.travellink.DSITravelLinkCommon")) : class$org$dsi$ifc$travellink$DSITravelLinkCommon));
        this.dsiTravelLinkCommonListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$travellink$DSITravelLinkCommonListener == null ? (class$org$dsi$ifc$travellink$DSITravelLinkCommonListener = TargetMain.class$("org.dsi.ifc.travellink.DSITravelLinkCommonListener")) : class$org$dsi$ifc$travellink$DSITravelLinkCommonListener);
        if (TLinkServiceManager.getSdarsTunnerState() == 1) {
            this.setNotification();
        }
        ASLSystemFactory.getSystemApi().addUnitChangeListener(0, TLinkServiceManager.getServiceManager().getUnitChangeListener());
        ASLSystemFactory.getSystemApi().addUnitChangeListener(1, TLinkServiceManager.getServiceManager().getUnitChangeListener());
    }

    public void updateTunerStatus(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TargetMain - updateTunerStatus( ").append(n).append(" )").log();
        }
        if (n == 1 && null != this.dsiTravelLinkCommonListener) {
            this.setNotification();
        }
    }

    private void setNotification() {
        if (!setNotificationDone) {
            setNotificationDone = true;
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("START-UP - TargetMain - setNotification( DSITravelLinkCommon.ATTR_FROMAPP, dsiTravelLinkCommonListener )").log();
            }
            TLinkServiceManager.getServiceManager().getDSITravelLinkCommon().setNotification(1, this.dsiTravelLinkCommonListener);
            TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestAllSubscriptionStates();
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

