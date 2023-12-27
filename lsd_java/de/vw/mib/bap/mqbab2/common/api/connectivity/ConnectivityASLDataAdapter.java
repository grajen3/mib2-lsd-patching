/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.connectivity;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityServiceListener;
import de.vw.mib.bap.mqbab2.common.api.connectivity.datatypes.ConnectivityCurrentConnectionDetails;
import de.vw.mib.datapool.ASLDatapool;
import java.util.Iterator;
import java.util.List;

public class ConnectivityASLDataAdapter
extends ASLDataPoolAdapter
implements ConnectivityService,
ConnectivityCurrentConnectionDetails {
    private APIFactoryInterface apiFactory;
    private static final int[] CONNECTIVITY_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{348, 358, 3657};
    private static final int[] CONNECTIVITY_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{365};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$connectivity$ConnectivityService;

    public ConnectivityASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$connectivity$ConnectivityService == null ? (class$de$vw$mib$bap$mqbab2$common$api$connectivity$ConnectivityService = ConnectivityASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService")) : class$de$vw$mib$bap$mqbab2$common$api$connectivity$ConnectivityService;
    }

    @Override
    public boolean isWlanActivated() {
        return this.getDataPool().getBoolean(348, false);
    }

    @Override
    public boolean isWlanConcealed() {
        return this.getDataPool().getBoolean(358, true);
    }

    @Override
    public boolean getConnectionClear() {
        return this.getDataPool().getBoolean(3657, false);
    }

    @Override
    public long getCurrentConnectionDetailDataVolumeUplink() {
        return ConnectivityASLDataAdapter.getLongListValue(365, 9);
    }

    @Override
    public long getCurrentConnectionDetailDataVolumeDownlink() {
        return ConnectivityASLDataAdapter.getLongListValue(365, 10);
    }

    @Override
    public ConnectivityCurrentConnectionDetails getCurrentConnectionDetails() {
        return this;
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
                ConnectivityServiceListener connectivityServiceListener = (ConnectivityServiceListener)iterator.next();
                connectivityServiceListener.updateConnectivityData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return CONNECTIVITY_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return CONNECTIVITY_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addConnectivityServiceListener(ConnectivityServiceListener connectivityServiceListener, int[] nArray) {
        this.registerServiceListener((Object)connectivityServiceListener, nArray);
    }

    @Override
    public void removeConnectivityServiceListener(ConnectivityServiceListener connectivityServiceListener, int[] nArray) {
        this.removeServiceListener(connectivityServiceListener, nArray);
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

