/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.ConnectionState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.ConnectionState_Status$BluetoothConnections;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class ConnectionState
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener,
ConnectivityServiceListener {
    private static final int BAP_WLAN_CONNECTIONS_UNKNOWN;
    protected static final int[] PHONE_LISTENER_IDS;
    protected static final int[] CONNECTIVITY_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$ConnectionState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getConnectivityService().addConnectivityServiceListener(this, CONNECTIVITY_LISTENER_IDS);
        return this.computeConnectionStateStatus();
    }

    protected ConnectionState_Status dequeueBAPEntity() {
        return (ConnectionState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$ConnectionState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$ConnectionState_Status = ConnectionState.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.ConnectionState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$ConnectionState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 24;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getConnectivityService().removeConnectivityServiceListener(this, CONNECTIVITY_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeConnectionStateStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    private ConnectionState_Status computeConnectionStateStatus() {
        ConnectionState_Status connectionState_Status = this.dequeueBAPEntity();
        connectionState_Status.bluetoothState = this.getBapBluetoothState();
        connectionState_Status.bluetoothVisibility = this.getBapBluetoothVisibilityState();
        this.setBapBluetoothConnections(connectionState_Status.bluetoothConnections);
        connectionState_Status.wlanstate = this.getBapWlanState();
        connectionState_Status.wlanvisibility = this.getBapWlanVisibilityState();
        connectionState_Status.wlanconnections = this.getBapWlanConnections();
        return connectionState_Status;
    }

    private int getBapBluetoothState() {
        int n;
        PhoneService phoneService = this.getPhoneService();
        if (phoneService.isExternalPhoneAvailable()) {
            switch (phoneService.getBluetoothState()) {
                case 0: {
                    n = 2;
                    break;
                }
                case 2: {
                    n = 5;
                    break;
                }
                case 3: {
                    n = 4;
                    break;
                }
                case 4: {
                    n = 3;
                    break;
                }
                default: {
                    n = 1;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    private int getBapBluetoothVisibilityState() {
        int n;
        switch (this.getPhoneService().getBluetoothVisibility()) {
            case 1: {
                n = 1;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private void setBapBluetoothConnections(ConnectionState_Status$BluetoothConnections connectionState_Status$BluetoothConnections) {
        PhoneService phoneService = this.getPhoneService();
        switch (phoneService.getCurrentPhoneProfile()) {
            case 1: {
                connectionState_Status$BluetoothConnections.simAccessProfileActive = true;
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                connectionState_Status$BluetoothConnections.handsFreeProfileActive = true;
                break;
            }
        }
        switch (phoneService.getCurrentPhoneMediaProfile()) {
            case 1: 
            case 2: {
                connectionState_Status$BluetoothConnections.audioplayerActive = true;
                break;
            }
        }
        if (phoneService.getCurrentPhoneOtherProfile() == 7) {
            connectionState_Status$BluetoothConnections.phonebookAccessProfileActive = true;
        }
    }

    private int getBapWlanState() {
        int n = this.getConfigurationService().isWLANFeatureSelected() ? (this.getConnectivityService().isWlanActivated() ? 2 : 1) : 0;
        return n;
    }

    private int getBapWlanVisibilityState() {
        int n = this.getConnectivityService().isWlanConcealed() ? 1 : 0;
        return n;
    }

    private int getBapWlanConnections() {
        return 255;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateConnectivityData(ConnectivityService connectivityService, int n) {
        this.process(-1);
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PHONE_LISTENER_IDS = new int[]{2908, 336, -612166400, 1118, 1115, 1116};
        CONNECTIVITY_LISTENER_IDS = new int[]{348, 358};
    }
}

