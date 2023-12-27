/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.NetworkProvider_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class NetworkProvider
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private String lastNetworkProviderName = null;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeNetworkProviderStatus();
    }

    protected NetworkProvider_Status dequeueBAPEntity() {
        return (NetworkProvider_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status = NetworkProvider.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.NetworkProvider_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$NetworkProvider_Status);
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
        PhoneService phoneService = this.getPhoneService();
        int n = phoneService.getNetworkState();
        if (n == 1 || n == 2) {
            networkProvider_Status.networkProviderState = 1;
            networkProvider_Status.networkProviderName.setContent(phoneService.getNetworkName());
        } else {
            networkProvider_Status.networkProviderState = 0;
            networkProvider_Status.networkProviderName.setContent("");
        }
    }

    private void setServiceProviderData(NetworkProvider_Status networkProvider_Status) {
        networkProvider_Status.serviceProviderState = 0;
        networkProvider_Status.serviceProviderName.setContent("");
    }

    private void sendNetworkProviderStatus(NetworkProvider_Status networkProvider_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(networkProvider_Status, this);
        this.lastNetworkProviderName = networkProvider_Status.networkProviderName.toString();
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
        if (this.lastNetworkProviderName != null) {
            this.setNetworkProviderSend(this.lastNetworkProviderName);
        }
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
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
        NetworkProvider_Status networkProvider_Status = this.dequeueBAPEntity();
        networkProvider_Status.networkProviderState = string.trim().length() != 0 ? 1 : 0;
        networkProvider_Status.networkProviderName.setContent(string);
        this.sendNetworkProviderStatus(networkProvider_Status);
    }

    @Override
    public void processHMIEvent(int n) {
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
}

