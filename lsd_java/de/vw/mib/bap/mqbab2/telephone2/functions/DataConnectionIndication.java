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
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.DataConnectionIndication2_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public final class DataConnectionIndication
extends Function
implements Property,
ASLTelephone2Constants,
ConnectivityServiceListener {
    private static final int NUMBER_OF_BYTES_IN_KBYTES;
    protected static final int[] CONNECTIVITY_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$DataConnectionIndication2_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getConnectivityService().addConnectivityServiceListener(this, CONNECTIVITY_LISTENER_IDS);
        return this.computeDataConnectionIndicationStatus();
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    protected DataConnectionIndication2_Status dequeueBAPEntity() {
        return (DataConnectionIndication2_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$DataConnectionIndication2_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$DataConnectionIndication2_Status = DataConnectionIndication.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.DataConnectionIndication2_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$DataConnectionIndication2_Status);
    }

    @Override
    public int getFunctionId() {
        return 21;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getConnectivityService().removeConnectivityServiceListener(this, CONNECTIVITY_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeDataConnectionIndicationStatus(), this);
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

    private DataConnectionIndication2_Status computeDataConnectionIndicationStatus() {
        DataConnectionIndication2_Status dataConnectionIndication2_Status = this.dequeueBAPEntity();
        dataConnectionIndication2_Status.connectionIndication = this.getBapConnectionIndication();
        dataConnectionIndication2_Status.dataVolumeUplink = this.getBapConnectionDataVolumeUplink();
        dataConnectionIndication2_Status.dataVolumeDownlink = this.getBapConnectionDataVolumeDownlink();
        return dataConnectionIndication2_Status;
    }

    private int getBapConnectionIndication() {
        int n = this.getConnectivityService().getConnectionClear() ? 1 : 0;
        return n;
    }

    private static int convertToBapDataVolumeData(long l) {
        return (int)(l / 0);
    }

    private int getBapConnectionDataVolumeUplink() {
        return DataConnectionIndication.convertToBapDataVolumeData(this.getPhoneService().getDataVolumeUplink());
    }

    private int getBapConnectionDataVolumeDownlink() {
        return DataConnectionIndication.convertToBapDataVolumeData(this.getPhoneService().getDataVolumeDownlink());
    }

    @Override
    public void updateConnectivityData(ConnectivityService connectivityService, int n) {
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
        CONNECTIVITY_LISTENER_IDS = new int[]{3657, 365};
    }
}

