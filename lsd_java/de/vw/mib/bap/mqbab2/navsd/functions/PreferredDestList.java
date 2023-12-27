/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.PreferredDest_List_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class PreferredDestList
extends Function
implements Property,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$PreferredDest_List_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computePreferredDestList();
    }

    protected PreferredDest_List_Status dequeueBAPEntity() {
        return (PreferredDest_List_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$PreferredDest_List_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$PreferredDest_List_Status = PreferredDestList.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.PreferredDest_List_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$PreferredDest_List_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 29: {
                this.setFullLastDestList((FsgArrayListComplete)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 31;
    }

    @Override
    public void process(int n) {
    }

    protected PreferredDest_List_Status computePreferredDestList() {
        PreferredDest_List_Status preferredDest_List_Status = this.dequeueBAPEntity();
        preferredDest_List_Status.listType = 1;
        return preferredDest_List_Status;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(52, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    protected void setFullLastDestList(FsgArrayListComplete fsgArrayListComplete) {
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

