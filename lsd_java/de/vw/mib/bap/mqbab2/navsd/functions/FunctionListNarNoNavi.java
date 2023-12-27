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
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FunctionList_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class FunctionListNarNoNavi
extends Function
implements Property,
ASLNavSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FunctionList_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return FunctionListNarNoNavi.usedFunctionList();
    }

    protected FunctionList_Status dequeueBAPEntity() {
        return (FunctionList_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FunctionList_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FunctionList_Status = FunctionListNarNoNavi.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.FunctionList_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FunctionList_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 3;
    }

    private static FunctionList_Status usedFunctionList() {
        FunctionList_Status functionList_Status = new FunctionList_Status();
        functionList_Status.fctGetAllAvailable = false;
        functionList_Status.fctBap_ConfigAvailable = true;
        functionList_Status.fctFunctionListAvailable = true;
        functionList_Status.fctHeartBeatAvailable = true;
        functionList_Status.fctFsg_OperationStateAvailable = true;
        functionList_Status.fctCompassInfoAvailable = true;
        functionList_Status.fctRg_StatusAvailable = false;
        functionList_Status.fctDistanceToNextManeuverAvailable = false;
        functionList_Status.fctCurrentPositionInfoAvailable = false;
        functionList_Status.fctTurnToInfoAvailable = false;
        functionList_Status.fctDistanceToDestinationAvailable = false;
        functionList_Status.fctTimeToDestinationAvailable = false;
        functionList_Status.fctManeuverDescriptorAvailable = false;
        functionList_Status.fctLaneGuidanceAvailable = false;
        functionList_Status.fctTmcinfoAvailable = false;
        functionList_Status.fctMagnetFieldZoneAvailable = false;
        functionList_Status.fctCalibrationAvailable = false;
        functionList_Status.fctAsg_CapabilitiesAvailable = false;
        functionList_Status.fctLastDest_ListAvailable = false;
        functionList_Status.fctFavoriteDest_ListAvailable = false;
        functionList_Status.fctPreferredDest_ListAvailable = false;
        functionList_Status.fctNavBookAvailable = false;
        functionList_Status.fctAddress_ListAvailable = false;
        functionList_Status.fctRg_ActDeactAvailable = false;
        functionList_Status.fctRepeatLastNavAnnouncementAvailable = false;
        functionList_Status.fctVoiceGuidanceAvailable = false;
        functionList_Status.fctFunctionSynchronisationAvailable = false;
        functionList_Status.fctInfoStatesAvailable = false;
        functionList_Status.fctActiveRgTypeAvailable = false;
        functionList_Status.fctTrafficBlock_IndicationAvailable = false;
        functionList_Status.fctGetNextListPosAvailable = false;
        functionList_Status.fctNbSpellerAvailable = false;
        functionList_Status.fctMapColorAndTypeAvailable = false;
        functionList_Status.fctMapViewAndOrientationAvailable = false;
        functionList_Status.fctMapScaleAvailable = true;
        functionList_Status.fctDestinationInfoAvailable = false;
        functionList_Status.fctAltitudeAvailable = false;
        functionList_Status.fctOnlineNavigationStateAvailable = false;
        functionList_Status.fctExitviewAvailable = false;
        functionList_Status.fctSemidynamicRouteGuidanceAvailable = false;
        functionList_Status.fctPoi_SearchAvailable = false;
        functionList_Status.fctPoi_ListAvailable = false;
        functionList_Status.fctFsg_SetupAvailable = false;
        functionList_Status.fctMap_PresentationAvailable = false;
        return functionList_Status;
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
    public void process(int n) {
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

