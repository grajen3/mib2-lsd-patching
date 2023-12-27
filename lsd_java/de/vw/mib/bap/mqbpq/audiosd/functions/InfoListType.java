/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.InfoListTypeStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoListType_Status;

public class InfoListType
extends InfoListTypeStage {
    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        InfoListType_Status infoListType_Status = this.computeInfoListType();
        this.setBapInfoListType(new Integer(infoListType_Status.type));
        return infoListType_Status;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        InfoListType_Status infoListType_Status = this.computeInfoListType();
        if (this.getDelegate().getPropertyListener(this).statusProperty(infoListType_Status, this)) {
            this.setBapInfoListType(new Integer(infoListType_Status.type));
        }
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

    private InfoListType_Status computeInfoListType() {
        InfoListType_Status infoListType_Status = this.dequeueBAPEntity();
        infoListType_Status.type = this.getBapInfoListType();
        return infoListType_Status;
    }

    protected int getBapInfoListType() {
        return 3;
    }
}

