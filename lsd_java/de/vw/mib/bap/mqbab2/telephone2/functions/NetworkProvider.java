/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.NetworkProvider2_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public class NetworkProvider
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1084, 1085};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$NetworkProvider2_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeNetworkProviderStatus();
    }

    protected NetworkProvider2_Status dequeueBAPEntity() {
        return (NetworkProvider2_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$NetworkProvider2_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$NetworkProvider2_Status = NetworkProvider.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.NetworkProvider2_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$NetworkProvider2_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeNetworkProviderStatus(), this);
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

    private NetworkProvider2_Status computeNetworkProviderStatus() {
        NetworkProvider2_Status networkProvider2_Status = this.dequeueBAPEntity();
        networkProvider2_Status.networkProviderState = this.getBapNetworkProviderState();
        networkProvider2_Status.networkProviderName.setContent(this.getBapNetworkProviderName());
        networkProvider2_Status.serviceProviderState = this.getBapServiceProviderState();
        networkProvider2_Status.serviceProviderName.setContent(this.getBapServiceProviderName());
        return networkProvider2_Status;
    }

    private int getBapNetworkProviderState() {
        PhoneService phoneService = this.getPhoneService();
        int n = phoneService.getNetworkState();
        int n2 = (n == 1 || n == 2) && phoneService.getNetworkName().trim().length() != 0 ? 1 : 0;
        return n2;
    }

    private String getBapNetworkProviderName() {
        PhoneService phoneService = this.getPhoneService();
        int n = phoneService.getNetworkState();
        String string = n == 1 || n == 2 ? phoneService.getNetworkName() : "";
        return string;
    }

    private int getBapServiceProviderState() {
        return 0;
    }

    private String getBapServiceProviderName() {
        return "";
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

