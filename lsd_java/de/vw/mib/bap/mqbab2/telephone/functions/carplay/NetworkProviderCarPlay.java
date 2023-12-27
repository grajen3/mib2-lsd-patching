/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.NetworkProvider_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class NetworkProviderCarPlay
extends Function
implements Property,
ASLTelephoneConstants,
CarPlayServiceListener {
    protected static final int[] CAR_PLAY_LISTENER_IDS = new int[]{1092550784};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
        return this.computeNetworkProviderStatus();
    }

    protected NetworkProvider_Status dequeueBAPEntity() {
        return (NetworkProvider_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status = NetworkProviderCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.NetworkProvider_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status);
    }

    protected void setNetworkProviderSend(String string) {
        int[] nArray = new int[]{18};
        this.context.updateStages(this, nArray, string);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 18: {
                this.setNetworkProviderName((String)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    private void setNetworkProviderData(NetworkProvider_Status networkProvider_Status) {
        networkProvider_Status.networkProviderName.setContent(this.getCarPlayService().getCarPlayDeviceState().getCarPlayCellularNetworkOperator());
        networkProvider_Status.networkProviderState = networkProvider_Status.networkProviderName.toString().length() == 0 ? 0 : 1;
    }

    private void setServiceProviderData(NetworkProvider_Status networkProvider_Status) {
        networkProvider_Status.serviceProviderState = 0;
        networkProvider_Status.serviceProviderName.setContent("");
    }

    private void sendNetworkProviderStatus(NetworkProvider_Status networkProvider_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(networkProvider_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendNetworkProviderStatus(this.computeNetworkProviderStatus());
    }

    private NetworkProvider_Status computeNetworkProviderStatus() {
        NetworkProvider_Status networkProvider_Status = this.dequeueBAPEntity();
        this.setNetworkProviderData(networkProvider_Status);
        this.setServiceProviderData(networkProvider_Status);
        return networkProvider_Status;
    }

    protected void setNetworkProviderName(String string) {
    }

    @Override
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
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
}

