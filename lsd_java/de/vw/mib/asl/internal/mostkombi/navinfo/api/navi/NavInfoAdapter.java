/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.api.navi;

import de.vw.mib.asl.api.bap.BAPInterfaceProvider;
import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mostkombi.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDistanceToDestination;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDistanceToNextManeuver;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoEstimatedRemainingTripTime;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoEstimatedTimeOfArrival;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoTurnToInfo;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.ActiveRgType_Status;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.CurrentPositionInfo_Status;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToDestination_Status;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToNextManeuver_Status;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TurnToInfo_Status;
import java.util.Iterator;
import java.util.List;

public class NavInfoAdapter
extends DataPoolAdapter
implements NavInfoService,
AslServiceRegistry,
BAPValueObserver,
NavInfoDistanceToDestination,
NavInfoDistanceToNextManeuver,
NavInfoTurnToInfo,
NavInfoEstimatedTimeOfArrival,
NavInfoEstimatedRemainingTripTime {
    private BAPObserverRegistry _bapObserverRegistry;
    private static final int[] NAVIGATION_BAP_PROPERTY_IDS = new int[]{19, 21, 18, 20, 39};
    private static final int[] NAVIGATION_DP_PROPERTY_IDS = new int[]{1643, 737153024};
    private static final int[] NAVIGATION_DP_LIST_ITEM_IDS = new int[]{3799, 753930240, 750};
    private String _currentStreet;
    private long _distanceToDestionationDistance;
    private int _distanceToDestionationUnit;
    private boolean _distanceToDestionationValidity;
    private long _distanceToNextManeuverDistance;
    private int _distanceToNextManeuverUnit;
    private boolean _distanceToNextManeuverValidity;
    private String _turnToInfoStreet;
    private String _turnToInfoSignPost;
    private int _routeGuidanceMode;
    private int _estimatedTimeOfArrivalDay;
    private int _estimatedTimeOfArrivalHour;
    private int _estimatedTimeOfArrivalMin;
    private boolean _estimatedTimeOfArrivalValidity;
    private int _estimatedRemainingTripTimeHour;
    private int _estimatedRemainingTripTimeMin;
    private boolean _estimatedRemainingTripTimeValidity;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = NavInfoAdapter.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;
    }

    private BAPObserverRegistry getNavigationObserverRegistry() {
        BAPLogicalControlUnit bAPLogicalControlUnit;
        if (this._bapObserverRegistry == null && (bAPLogicalControlUnit = new BAPInterfaceProvider(ServiceManager.bundleContext).getBapDispatcher().getLogicalControlUnit(50)) != null) {
            this._bapObserverRegistry = bAPLogicalControlUnit.getBapObserverRegistry();
        }
        return this._bapObserverRegistry;
    }

    private void _notifyServiceDelegates(int n, Object object) {
        List list = this.getRegisteredServiceDelegates(n);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            NavInfoDelegate navInfoDelegate = (NavInfoDelegate)iterator.next();
            navInfoDelegate.updateNavInfo(this, n, object);
        }
    }

    @Override
    protected void registerServiceListener(Object object, int n) {
        super.registerServiceListener(object, n);
        if (n == 750) {
            super.registerServiceListener(object, 1643);
        }
        if (n == 750 || n == 753930240) {
            super.registerServiceListener(object, 737153024);
        }
    }

    @Override
    protected void unregisterServiceListener(Object object, int n) {
        super.unregisterServiceListener(object, n);
        if (n == 750) {
            super.unregisterServiceListener(object, 1643);
        }
        if (n == 750 || n == 753930240) {
            super.unregisterServiceListener(object, 737153024);
        }
    }

    @Override
    public void register() {
        super.register();
        int n = NAVIGATION_BAP_PROPERTY_IDS.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = NAVIGATION_BAP_PROPERTY_IDS[i2];
            this.getNavigationObserverRegistry().getBapValueObservable(n2).addObserver(this, new Integer(n2));
        }
        if (NAVIGATION_BAP_PROPERTY_IDS.length > 0) {
            this.getNavigationObserverRegistry().flushAllBapValueObserverables();
        }
    }

    @Override
    public void unregister() {
        super.unregister();
        for (int n : NAVIGATION_BAP_PROPERTY_IDS) {
            this.getNavigationObserverRegistry().getBapValueObservable(n).removeObserver(this);
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return NAVIGATION_DP_PROPERTY_IDS;
    }

    @Override
    protected int[] getListIds() {
        return NAVIGATION_DP_LIST_ITEM_IDS;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n, null);
    }

    @Override
    protected void listValueChanged(int n) {
        if (this._storeDataPoolListValues(n)) {
            this._notifyServiceDelegates(n, null);
        }
    }

    @Override
    public String getCityName() {
        return NavInfoAdapter.getStringListValue(3799, 3);
    }

    @Override
    public NavInfoEstimatedTimeOfArrival getEstimatedTimeArrival() {
        return this;
    }

    @Override
    public String getCurrentStreet() {
        return this._currentStreet;
    }

    @Override
    public NavInfoDistanceToDestination getDistanceToDestination() {
        return this;
    }

    @Override
    public NavInfoDistanceToNextManeuver getDistanceToNextMananeuver() {
        return this;
    }

    @Override
    public NavInfoEstimatedRemainingTripTime getEstimatedRemainingTripTime() {
        return this;
    }

    @Override
    public NavInfoTurnToInfo getTurnToInfo() {
        return this;
    }

    @Override
    public long getDistanceToDestionationDistance() {
        return this._distanceToDestionationDistance;
    }

    @Override
    public int getDistanceToDestionationUnit() {
        return this._distanceToDestionationUnit;
    }

    @Override
    public boolean getDistanceToDestionationValidity() {
        return this._distanceToDestionationValidity;
    }

    @Override
    public long getDistanceToNextManeuverDistance() {
        return this._distanceToNextManeuverDistance;
    }

    @Override
    public int getDistanceToNextManeuverUnit() {
        return this._distanceToNextManeuverUnit;
    }

    @Override
    public boolean getDistanceToNextManeuverValidity() {
        return this._distanceToNextManeuverValidity;
    }

    @Override
    public String getTurnToInfoStreet() {
        return this._turnToInfoStreet;
    }

    @Override
    public String getTurnToInfoSignPost() {
        return this._turnToInfoSignPost;
    }

    @Override
    public int getRouteGuidanceMode() {
        return this._routeGuidanceMode;
    }

    @Override
    public int getEstimatedTimeOfArrivalTimeFormat() {
        int n = this.getDataPool().getInteger(1643, 1);
        int n2 = n == 1 ? 0 : 1;
        return n2;
    }

    @Override
    public int getEstimatedTimeOfArrivalDay() {
        return this._estimatedTimeOfArrivalDay;
    }

    @Override
    public int getEstimatedTimeOfArrivalHour() {
        return this._estimatedTimeOfArrivalHour;
    }

    @Override
    public int getEstimatedTimeOfArrivalMin() {
        return this._estimatedTimeOfArrivalMin;
    }

    @Override
    public boolean getEstimatedTimeOfArrivalValidity() {
        return this._estimatedTimeOfArrivalValidity && this.getDataPool().getInteger(737153024) == 1;
    }

    @Override
    public int getEstimatedRemainingTripTimeHour() {
        return this._estimatedRemainingTripTimeHour;
    }

    @Override
    public int getEstimatedRemainingTripTimeMin() {
        return this._estimatedRemainingTripTimeMin;
    }

    @Override
    public boolean getEstimatedRemainingTripTimeValidity() {
        return this._estimatedRemainingTripTimeValidity && this.getDataPool().getInteger(737153024) == 0;
    }

    private boolean _storeDataPoolListValues(int n) {
        boolean bl;
        switch (n) {
            case 750: {
                int n2 = NavInfoAdapter.getIntegerListValue(750, 4);
                int n3 = NavInfoAdapter.getIntegerListValue(750, 3);
                int n4 = NavInfoAdapter.getIntegerListValue(750, 2);
                boolean bl2 = NavInfoAdapter.getBooleanListValue(750, 7);
                boolean bl3 = bl = this._estimatedTimeOfArrivalDay != n2 || this._estimatedTimeOfArrivalHour != n3 || this._estimatedTimeOfArrivalMin != n4 || this._estimatedTimeOfArrivalValidity != bl2;
                if (!bl) break;
                this._estimatedTimeOfArrivalDay = n2;
                this._estimatedTimeOfArrivalHour = n3;
                this._estimatedTimeOfArrivalMin = n4;
                this._estimatedTimeOfArrivalValidity = bl2;
                break;
            }
            case 1110060: {
                int n5 = NavInfoAdapter.getIntegerListValue(753930240, 2);
                int n6 = NavInfoAdapter.getIntegerListValue(753930240, 1);
                boolean bl4 = NavInfoAdapter.getBooleanListValue(753930240, 0);
                boolean bl5 = bl = this._estimatedRemainingTripTimeHour != n5 || this._estimatedRemainingTripTimeMin != n6 || this._estimatedRemainingTripTimeValidity != bl4;
                if (!bl) break;
                this._estimatedRemainingTripTimeHour = n5;
                this._estimatedRemainingTripTimeMin = n6;
                this._estimatedRemainingTripTimeValidity = bl4;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private static int _formatBapDistanceUnitToKomoNavInfoUnit(int n) {
        int n2;
        switch (n) {
            case 3: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 0: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 0;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private boolean _storeBapInfoData(int n, BAPEntity bAPEntity, Object[] objectArray) {
        boolean bl;
        Object object;
        switch (n) {
            case 19: {
                CurrentPositionInfo_Status currentPositionInfo_Status = (CurrentPositionInfo_Status)bAPEntity;
                object = this._currentStreet;
                bl = true;
                this._currentStreet = currentPositionInfo_Status.positionInfo.toString();
                break;
            }
            case 21: {
                DistanceToDestination_Status distanceToDestination_Status = (DistanceToDestination_Status)bAPEntity;
                object = null;
                bl = true;
                this._distanceToDestionationValidity = distanceToDestination_Status.validityInformation.distanceToDestinationValid;
                this._distanceToDestionationDistance = distanceToDestination_Status.distanceToDestination.distance;
                this._distanceToDestionationUnit = NavInfoAdapter._formatBapDistanceUnitToKomoNavInfoUnit(distanceToDestination_Status.distanceToDestination.unit);
                break;
            }
            case 18: {
                DistanceToNextManeuver_Status distanceToNextManeuver_Status = (DistanceToNextManeuver_Status)bAPEntity;
                object = null;
                long l = distanceToNextManeuver_Status.distanceToNextManeuver.distance;
                boolean bl2 = distanceToNextManeuver_Status.validityInformation.distanceToNextManeuverValid;
                int n2 = NavInfoAdapter._formatBapDistanceUnitToKomoNavInfoUnit(distanceToNextManeuver_Status.distanceToNextManeuver.unit);
                if (l != this._distanceToNextManeuverDistance || bl2 != this._distanceToNextManeuverValidity || n2 != this._distanceToNextManeuverUnit) {
                    this._distanceToNextManeuverDistance = l;
                    this._distanceToNextManeuverValidity = bl2;
                    this._distanceToNextManeuverUnit = n2;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 20: {
                TurnToInfo_Status turnToInfo_Status = (TurnToInfo_Status)bAPEntity;
                object = null;
                bl = true;
                this._turnToInfoSignPost = turnToInfo_Status.signPost.toString();
                this._turnToInfoStreet = turnToInfo_Status.turnToInfo.toString();
                break;
            }
            case 39: {
                int n3;
                ActiveRgType_Status activeRgType_Status = (ActiveRgType_Status)bAPEntity;
                switch (activeRgType_Status.rgtype) {
                    case 2: {
                        n3 = 2;
                        break;
                    }
                    case 1: {
                        n3 = 1;
                        break;
                    }
                    case 3: {
                        n3 = 3;
                        break;
                    }
                    default: {
                        n3 = 0;
                    }
                }
                object = new Integer(this._routeGuidanceMode);
                bl = true;
                this._routeGuidanceMode = n3;
                break;
            }
            default: {
                object = null;
                bl = false;
            }
        }
        objectArray[0] = object;
        return bl;
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
        int n = (Integer)object;
        Object[] objectArray = new Object[]{null};
        boolean bl = this._storeBapInfoData(n, bAPEntity, objectArray);
        if (bl) {
            this._notifyServiceDelegates(n, objectArray[0]);
        }
    }

    @Override
    public void bapValueError(BAPValueObserverable bAPValueObserverable, int n, Object object) {
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

