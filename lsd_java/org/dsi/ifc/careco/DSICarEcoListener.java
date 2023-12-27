/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;

public interface DSICarEcoListener
extends DSIListener {
    default public void updateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
    }

    default public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
    }

    default public void updateBCmEConsumption(int n, int n2, int n3, int n4) {
    }

    default public void updateBCmELiveTip(int n, boolean bl, int n2) {
    }

    default public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
    }

    default public void acknowledgeBcmeSetFactoryDefault(boolean bl) {
    }

    default public void updateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
    }

    default public void responseStartStopProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopProhibitList[] startStopProhibitListArray) {
    }

    default public void updateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
    }

    default public void responseStartStopRestartReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartList[] startStopRestartListArray) {
    }

    default public void updateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
    }

    default public void responseStartStopRestartProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartProhibitList[] startStopRestartProhibitListArray) {
    }

    default public void updateStartStopState(int n, int n2) {
    }

    default public void updateStartStopProhibitReasonListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateStartStopRestartReasonListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateStartStopRestartProhibitReasonListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateStartStopViewOptions(StartStopViewOptions startStopViewOptions, int n) {
    }

    default public void updateStartStopCollectedReasons(int n, int n2) {
    }

    default public void updateRDViewOptions(RangeDataViewOptions rangeDataViewOptions, int n) {
    }

    default public void updateRDConsumptionMotorway1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionMotorway2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionHighway1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionHighway2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionCountryRoad1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionCountryRoad2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionDistrictRoad1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionDistrictRoad2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionLocalRoad1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionLocalRoad2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionRuralRoad1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionRuralRoad2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionUnclassifiedRoad1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDConsumptionUnclassifiedRoad2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateRDMaxRange1(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    default public void updateRDMaxRange2(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    default public void updateRDResidualEnergy1(RangeDataResidualEnergy rangeDataResidualEnergy, int n) {
    }

    default public void updateRDResidualEnergy2(RangeDataResidualEnergy rangeDataResidualEnergy, int n) {
    }

    default public void acknowledgeRDSetFactoryDefault(boolean bl) {
    }

    default public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
    }

    default public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
    }

    default public void updateBCmEEnergyFlowComfort(BCmEEnergyFlowComfort bCmEEnergyFlowComfort, int n) {
    }

    default public void updateBCmERangeGainTotal(BCmERangeGainTotal bCmERangeGainTotal, int n) {
    }

    default public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
    }

    default public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
    }

    default public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
    }

    default public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
    }

    default public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) {
    }

    default public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
    }

    default public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
    }

    default public void updateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
    }

    default public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) {
    }

    default public void updateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) {
    }

    default public void updateBCmECurrentRangeSOC(int n, int n2, int n3, int n4) {
    }

    default public void updateBCmECatalogueRange(int n, int n2, int n3, int n4) {
    }

    default public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) {
    }

    default public void updateEASystem(boolean bl, int n) {
    }

    default public void updateEAPedalJerk(boolean bl, int n) {
    }

    default public void acknowledgeEASetFactoryDefault(boolean bl) {
    }

    default public void updateEAFreeWheeling(boolean bl, int n) {
    }

    default public void updateEAStartStop(boolean bl, int n) {
    }
}

