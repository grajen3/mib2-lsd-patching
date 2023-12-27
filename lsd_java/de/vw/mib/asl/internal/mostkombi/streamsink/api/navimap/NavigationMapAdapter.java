/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mostkombi.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapListener;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class NavigationMapAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
NavigationMapService,
NavigationMapListener,
ICMapListener,
INavServiceStateListener {
    private ICMapService icMapService;
    private static int[] ASL_PROPERTIES_TO_REGISTER_TO = new int[]{485494784, 502272000};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;

    public NavigationMapAdapter() {
        this.getICMapService();
        ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = NavigationMapAdapter.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                NavigationMapDelegate navigationMapDelegate = (NavigationMapDelegate)iterator.next();
                navigationMapDelegate.updateNavigationMap(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return ASL_PROPERTIES_TO_REGISTER_TO;
    }

    @Override
    protected int[] getListIds() {
        return null;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
    }

    private ICMapService getICMapService() {
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100 && this.icMapService == null) {
            try {
                this.icMapService = ASLNavigationFactory.getNavigationApi().getICMapService(this);
            }
            catch (NavigationServiceException navigationServiceException) {
                // empty catch block
            }
        }
        return this.icMapService;
    }

    @Override
    public void setMapVisible() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-171438016);
        NavigationMapAdapter.sendSafe(eventGeneric);
    }

    @Override
    public void setMapInvisible() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-154660800);
        NavigationMapAdapter.sendSafe(eventGeneric);
    }

    @Override
    public int getKombiMapStatus() {
        return this.getDataPool().getInteger(485494784, 0);
    }

    @Override
    public void updateKombiMapStatus(int n) {
    }

    @Override
    public int getKombiMapVisibility() {
        return this.getDataPool().getInteger(502272000, 0);
    }

    @Override
    public void updateKombiMapVisibility(int n) {
    }

    @Override
    public void switchMapToAbt() {
        this._notifyServiceDelegates(-335347584);
    }

    @Override
    public void switchMapToKombi() {
        this._notifyServiceDelegates(-318570368);
    }

    @Override
    public int getMapSwitchState() {
        return this.getICMapService().getMapSwitchState();
    }

    @Override
    public void setMapSwitchState(int n) {
        this.getICMapService().setMapSwitchState(n);
    }

    @Override
    public void updateMapSwitchState(int n) {
        this._notifyServiceDelegates(-352124800);
    }

    @Override
    public int getMapInAbtVisibility() {
        return this.getICMapService().getMapVisibilityInAbt();
    }

    @Override
    public void updateNavigationMapInAbtVisibility(int n) {
        this._notifyServiceDelegates(-368902016);
    }

    @Override
    public void failedToPerformMapSwitch() {
        ICMapService iCMapService = this.getICMapService();
        if (iCMapService != null && iCMapService.getICMapServiceState() == 10) {
            iCMapService.failedToPerformSwitch();
        }
    }

    @Override
    public boolean isNavigationServiceStateFullyOperable() {
        return ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100;
    }

    @Override
    public void navServiceStateChanged() {
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
            this.getICMapService();
        }
        this._notifyServiceDelegates(-385679232);
    }

    @Override
    public int getNavigationMapServiceState() {
        if (this.isNavigationServiceStateFullyOperable() && this.getICMapService() != null) {
            return this.getICMapService().getICMapServiceState();
        }
        return 0;
    }

    @Override
    public void updateICMapServiceState(int n) {
        this._notifyServiceDelegates(-301793152);
    }

    @Override
    public boolean isMapSwitchPossible() {
        if (this.isNavigationServiceStateFullyOperable() && this.getICMapService() != null) {
            return this.getICMapService().isMapSwitchFunctionAvailableInKombi();
        }
        return false;
    }

    @Override
    public void setMapSwitchPossible(boolean bl) {
        if (this.isNavigationServiceStateFullyOperable() && this.getICMapService() != null) {
            this.getICMapService().setMapSwitchFunctionAvailableInKombi(bl);
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

