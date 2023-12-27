/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carplay;

import de.vw.mib.asl.api.carplay.ASLCarPlayFactory;
import de.vw.mib.asl.api.carplay.ASLCarplayServices;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesListener;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.CarPlayDeviceState;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.CarPlayCallIterator;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import de.vw.mib.datapool.ASLDatapool;
import java.util.Iterator;
import java.util.List;

public class CarPlayASLDataAdapter
extends ASLDataPoolAdapter
implements CarPlayService,
CarPlayDeviceState,
ASLCarplayServicesListener {
    private static int MAX_NUMBER_OF_CALLS = 7;
    private String[] callIdMap;
    private final APIFactoryInterface apiFactory;
    private final ASLCarplayServices carPlayServices;
    private static final int[] CAR_PLAY_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{963062784};
    private static final int[] CAR_PLAY_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{996617216};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$carplay$CarPlayService;

    public CarPlayASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.carPlayServices = ASLCarPlayFactory.getCarPlayApi().getServices();
        this.carPlayServices.registerListener(this);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$carplay$CarPlayService == null ? (class$de$vw$mib$bap$mqbab2$common$api$carplay$CarPlayService = CarPlayASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService")) : class$de$vw$mib$bap$mqbab2$common$api$carplay$CarPlayService;
    }

    @Override
    public boolean isCarPlayActive() {
        if (this.carPlayServices.isReady()) {
            return this.carPlayServices.isCarPlayActive();
        }
        return false;
    }

    @Override
    public void updateCarPlayActive(boolean bl) {
        this._notifyServiceDelegates(1075773568);
    }

    @Override
    public boolean isCarPlayDeviceValid() {
        if (this.carPlayServices.isReady()) {
            return this.carPlayServices.getCarPlayTelephonyState().isTelephonyDataValid();
        }
        return false;
    }

    @Override
    public String getCarPlayCellularNetworkOperator() {
        if (this.isCarPlayDeviceValid()) {
            return this.carPlayServices.getCarPlayTelephonyState().getMobileOperator();
        }
        return "";
    }

    @Override
    public int getCarPlayCellularNetworkSignalStrength() {
        if (this.isCarPlayDeviceValid()) {
            return this.carPlayServices.getCarPlayTelephonyState().getSignalStrength();
        }
        return 0;
    }

    @Override
    public CarPlayDeviceState getCarPlayDeviceState() {
        return this;
    }

    @Override
    public void updateCarPlaTelefonyState(ASLCarplayServicesTelephonyState aSLCarplayServicesTelephonyState) {
        this._notifyServiceDelegates(1092550784);
    }

    @Override
    public Iterator getCarPlayCalls() {
        return new CarPlayCallIterator(this.getCarPlayCallsFromCarPlayDomain(), this.getCallIdMap());
    }

    private ASLCarplayServicesCallState[] getCarPlayCallsFromCarPlayDomain() {
        if (this.carPlayServices.isReady()) {
            return this.carPlayServices.getCarPlayCallStates();
        }
        return null;
    }

    private String[] getCallIdMap() {
        if (this.callIdMap == null) {
            this.callIdMap = new String[MAX_NUMBER_OF_CALLS];
        }
        return this.callIdMap;
    }

    private void mapCarPlayCalls() {
        int n;
        int n2;
        String[] stringArray = this.getCallIdMap();
        boolean[] blArray = new boolean[stringArray.length];
        ASLCarplayServicesCallState[] aSLCarplayServicesCallStateArray = this.getCarPlayCallsFromCarPlayDomain();
        if (aSLCarplayServicesCallStateArray != null) {
            block0: for (n2 = 0; n2 < aSLCarplayServicesCallStateArray.length; ++n2) {
                if (aSLCarplayServicesCallStateArray[n2] == null || aSLCarplayServicesCallStateArray[n2].getUniqueCallID().length() <= 0) continue;
                for (n = 0; n < stringArray.length; ++n) {
                    if (stringArray[n] == null || !stringArray[n].equals(aSLCarplayServicesCallStateArray[n2].getUniqueCallID())) continue;
                    blArray[n] = true;
                    continue block0;
                }
            }
        }
        for (n2 = 0; n2 < blArray.length; ++n2) {
            if (blArray[n2]) continue;
            stringArray[n2] = null;
        }
        if (aSLCarplayServicesCallStateArray != null) {
            block3: for (n = 0; n < aSLCarplayServicesCallStateArray.length; ++n) {
                int n3;
                n2 = 0;
                for (n3 = 0; n3 < stringArray.length; ++n3) {
                    if (stringArray[n3] == null || !stringArray[n3].equals(aSLCarplayServicesCallStateArray[n].getUniqueCallID())) continue;
                    n2 = 1;
                    break;
                }
                if (n2 != 0) continue;
                for (n3 = 0; n3 < stringArray.length; ++n3) {
                    if (stringArray[n3] != null) continue;
                    stringArray[n3] = aSLCarplayServicesCallStateArray[n].getUniqueCallID();
                    continue block3;
                }
            }
        }
    }

    @Override
    public void updateCarPlayCallStates(ASLCarplayServicesCallState[] aSLCarplayServicesCallStateArray) {
        this.mapCarPlayCalls();
        this._notifyServiceDelegates(1126105216);
    }

    @Override
    public final boolean isCarPlayRouteGuidanceActive() {
        if (this.carPlayServices.isReady()) {
            return this.carPlayServices.isCarPlayRouteGuidanceActive();
        }
        return false;
    }

    @Override
    public void updateCarPlayRouteGuidanceActive(boolean bl) {
        this._notifyServiceDelegates(1109328000);
    }

    @Override
    public void updateCarPlayIsReady(boolean bl) {
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                CarPlayServiceListener carPlayServiceListener = (CarPlayServiceListener)iterator.next();
                carPlayServiceListener.updateCarPlayData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return CAR_PLAY_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return CAR_PLAY_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void hangUpCall(CarPlayCall carPlayCall) {
        this.carPlayServices.requestEndCall();
    }

    @Override
    public void acceptCall(int n) {
        this.carPlayServices.requestAcceptCall();
    }

    @Override
    public void addCarPlayServiceListener(CarPlayServiceListener carPlayServiceListener, int[] nArray) {
        this.registerServiceListener((Object)carPlayServiceListener, nArray);
    }

    @Override
    public void removeCarPlayServiceListener(CarPlayServiceListener carPlayServiceListener, int[] nArray) {
        this.removeServiceListener(carPlayServiceListener, nArray);
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

