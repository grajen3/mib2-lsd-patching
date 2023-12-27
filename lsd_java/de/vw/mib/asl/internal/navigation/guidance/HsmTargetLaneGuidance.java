/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance;

import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceLaneGuidance;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.GuidanceInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance$1;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceLaneGuidanceCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

public class HsmTargetLaneGuidance
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSIListener dsiNavigationListener;
    private boolean uTurnEnabled;
    private final int uTurnLeftValue;
    private int uTurnRightValue;
    private GuidanceInternalAPINotifier guidanceInternalAPINotifier;
    public final HsmState stateWork;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance;

    public HsmTargetLaneGuidance(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateWork = new HsmTargetLaneGuidance$1(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.uTurnEnabled = HsmTargetLaneGuidance.getSystemConstantB("NAV_UTURN_MAPPING", true);
        this.uTurnLeftValue = HsmTargetLaneGuidance.getSystemConstant("NAV_UTURN_LEFT_DIRECTION", 114);
        this.uTurnRightValue = HsmTargetLaneGuidance.getSystemConstant("NAV_UTURN_RIGHT_DIRECTION", 146);
        this.guidanceInternalAPINotifier = new GuidanceInternalAPINotifier();
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetLaneGuidance tries to register to ").append(string).append("...").log();
            }
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
            this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigation.setNotification(new int[]{64}, this.dsiNavigationListener);
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetLaneGuidance registered to ").append(string).log();
            }
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetLaneGuidance tries to unregister from ").append(string).log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDsiNavigation(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisteredDone(string);
        }
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetLaneGuidance unregistered from ").append(string).log();
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    private static int getSystemConstant(String string, int n) {
        String string2 = System.getProperty(string);
        if (string2 != null) {
            int n2 = Integer.parseInt(string2);
            return n2;
        }
        return n;
    }

    private static boolean getSystemConstantB(String string, boolean bl) {
        String string2 = System.getProperty(string);
        if (string2 != null) {
            boolean bl2 = Boolean.getBoolean(string2);
            return bl2;
        }
        return bl;
    }

    public void dsiNavigationUpdateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
        this.trace(new StringBuffer((class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance == null ? (class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance = HsmTargetLaneGuidance.class$("de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance")) : class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance).getName()).append(" DSINAVIGATION_UPDATERGLANEGUIDANCE").toString());
        Object[] objectArray = null;
        if (navLaneGuidanceDataArray == null) {
            objectArray = new NavigationGuidanceLaneGuidanceCollector[]{new NavigationGuidanceLaneGuidanceCollector()};
            objectArray[0].navigation_guidance_lane_guidance_is_data_valid = false;
            this.info(new StringBuffer((class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance == null ? (class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance = HsmTargetLaneGuidance.class$("de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance")) : class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance).getName()).append(" rgLaneGuidance was <null>").toString());
        } else {
            objectArray = new NavigationGuidanceLaneGuidanceCollector[]{new NavigationGuidanceLaneGuidanceCollector()};
            objectArray[0].navigation_guidance_lane_guidance_direction = new int[navLaneGuidanceDataArray.length];
            objectArray[0].navigation_guidance_lane_guidance_info = new int[navLaneGuidanceDataArray.length];
            objectArray[0].navigation_guidance_lane_guidance_lane_marking_left = new int[navLaneGuidanceDataArray.length];
            ((NavigationGuidanceLaneGuidanceCollector)objectArray[0]).navigation_guidance_lane_guidance_lane_marking_right = new int[navLaneGuidanceDataArray.length];
            ((NavigationGuidanceLaneGuidanceCollector)objectArray[0]).navigation_guidance_lane_guidance_is_data_valid = bl;
            LogMessage logMessage = this.info();
            logMessage.append(super.getClass().getName());
            for (int i2 = 0; i2 < navLaneGuidanceDataArray.length; ++i2) {
                int n2 = this.uTurnEnabled && navLaneGuidanceDataArray[i2].laneDirection == this.uTurnLeftValue ? 180 : (this.uTurnEnabled && navLaneGuidanceDataArray[i2].laneDirection == this.uTurnRightValue ? 181 : (256 - navLaneGuidanceDataArray[i2].laneDirection + 16 >> 5 & 7) * 45);
                ((NavigationGuidanceLaneGuidanceCollector)objectArray[0]).navigation_guidance_lane_guidance_direction[i2] = (short)n2;
                ((NavigationGuidanceLaneGuidanceCollector)objectArray[0]).navigation_guidance_lane_guidance_info[i2] = navLaneGuidanceDataArray[i2].guidanceInfo;
                ((NavigationGuidanceLaneGuidanceCollector)objectArray[0]).navigation_guidance_lane_guidance_lane_marking_left[i2] = navLaneGuidanceDataArray[i2].laneMarkingLeft;
                ((NavigationGuidanceLaneGuidanceCollector)objectArray[0]).navigation_guidance_lane_guidance_lane_marking_right[i2] = navLaneGuidanceDataArray[i2].laneMarkingRight;
                logMessage.append(" [NavLaneGuidanceData: ");
                logMessage.append(n2);
                logMessage.append(", ");
                logMessage.append(navLaneGuidanceDataArray[i2].pos);
                logMessage.append(", ");
                logMessage.append(navLaneGuidanceDataArray[i2].laneDirection);
                logMessage.append(", ");
                logMessage.append(navLaneGuidanceDataArray[i2].guidanceInfo);
                logMessage.append(", ");
                logMessage.append(navLaneGuidanceDataArray[i2].laneMarkingLeft);
                logMessage.append(", ");
                logMessage.append(navLaneGuidanceDataArray[i2].laneMarkingRight);
                logMessage.append("]");
            }
            logMessage.log();
        }
        ListManager.getGenericASLList(829).updateList(objectArray);
        this.updateInternalAPI((NavigationGuidanceLaneGuidanceCollector[])objectArray);
    }

    private void updateInternalAPI(NavigationGuidanceLaneGuidanceCollector[] navigationGuidanceLaneGuidanceCollectorArray) {
        ASLGuidanceLaneGuidance[] aSLGuidanceLaneGuidanceArray = new ASLGuidanceLaneGuidance[]{new ASLGuidanceLaneGuidance()};
        aSLGuidanceLaneGuidanceArray[0].setLGDirection(navigationGuidanceLaneGuidanceCollectorArray[0].navigation_guidance_lane_guidance_direction);
        aSLGuidanceLaneGuidanceArray[0].setLGInfo(navigationGuidanceLaneGuidanceCollectorArray[0].navigation_guidance_lane_guidance_info);
        aSLGuidanceLaneGuidanceArray[0].setLGisDataValid(navigationGuidanceLaneGuidanceCollectorArray[0].navigation_guidance_lane_guidance_is_data_valid);
        aSLGuidanceLaneGuidanceArray[0].setLGMarkingLeft(navigationGuidanceLaneGuidanceCollectorArray[0].navigation_guidance_lane_guidance_lane_marking_left);
        aSLGuidanceLaneGuidanceArray[0].setLGMarkingRight(navigationGuidanceLaneGuidanceCollectorArray[0].navigation_guidance_lane_guidance_lane_marking_right);
        this.guidanceInternalAPINotifier.sendEvLaneGuidanceUpdate(aSLGuidanceLaneGuidanceArray);
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

