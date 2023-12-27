/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.PhonebookDownloadProgress_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public class PhonebookDownloadProgress
extends Function
implements Property,
ASLTelephone2Constants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhonebookDownloadProgress_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected PhonebookDownloadProgress_Status dequeueBAPEntity() {
        return (PhonebookDownloadProgress_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhonebookDownloadProgress_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhonebookDownloadProgress_Status = PhonebookDownloadProgress.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.PhonebookDownloadProgress_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$PhonebookDownloadProgress_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 26;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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

