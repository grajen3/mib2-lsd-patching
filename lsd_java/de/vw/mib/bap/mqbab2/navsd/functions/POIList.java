/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.POI_List_ChangedArray;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class POIList
extends Function
implements Array,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_List_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected POI_List_ChangedArray dequeueBAPEntity() {
        return (POI_List_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_List_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_List_ChangedArray = POIList.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.POI_List_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$POI_List_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 52;
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
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
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

