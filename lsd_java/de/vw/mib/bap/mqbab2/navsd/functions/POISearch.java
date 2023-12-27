/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.POI_Search_Result;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class POISearch
extends Function
implements Method,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_Search_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected POI_Search_Result dequeueBAPEntity() {
        return (POI_Search_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_Search_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_Search_Result = POISearch.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.POI_Search_Result")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_Search_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 51;
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
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
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

