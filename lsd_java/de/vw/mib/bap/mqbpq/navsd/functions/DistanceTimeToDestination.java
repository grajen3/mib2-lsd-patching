/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceTimeToDestination_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.DistanceTimeToDestinationStage;

public final class DistanceTimeToDestination
extends DistanceTimeToDestinationStage {
    private static final int NUMBER_OF_VALUES;
    private static final int INVALID_DISTANCE;
    private static final int INVALID_TIME;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeDistanceToDestinationStatus();
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
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendDistanceToDestination(this.computeDistanceToDestinationStatus());
    }

    private static int formatTime(int n) {
        return n >= 0 ? n : -1;
    }

    private static int formatDate(int n) {
        return n > 0 ? n : -1;
    }

    private void setTimeInfo(DistanceTimeToDestination_Status distanceTimeToDestination_Status) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        distanceTimeToDestination_Status.timeInfo.navigationTimeFormat = this.getSystemTimeFormat() == 0 ? 1 : 0;
        if (this.getTimeToDestinationTimeInfo() == 1) {
            n5 = DistanceTimeToDestination.formatTime(this.getTimeToDestinationMinutes());
            n4 = DistanceTimeToDestination.formatTime(this.getTimeToDestinationHours());
            n3 = DistanceTimeToDestination.formatDate(this.getTimeToDestinationDay());
            n2 = DistanceTimeToDestination.formatDate(this.getTimeToDestinationMonth());
            n = DistanceTimeToDestination.formatDate(this.getTimeToDestinationYear());
        } else {
            n5 = DistanceTimeToDestination.formatTime(this.getRemainingTravelTimeMinute());
            n4 = DistanceTimeToDestination.formatTime(this.getRemainingTravelTimeHour());
            n3 = -1;
            n2 = -1;
            n = -1;
        }
        if (this.getRouteGuidanceState() != 1) {
            n5 = -1;
            n4 = -1;
            n3 = -1;
            n2 = -1;
            n = -1;
        }
        distanceTimeToDestination_Status.timeInfo.timeInfoType = this.getTimeToDestinationTimeInfo();
        distanceTimeToDestination_Status.timeInfo.minute = n5;
        distanceTimeToDestination_Status.timeInfo.hour = n4;
        distanceTimeToDestination_Status.timeInfo.day = n3;
        distanceTimeToDestination_Status.timeInfo.month = n2;
        distanceTimeToDestination_Status.timeInfo.year = n;
    }

    private void setDistanceAndUnit(DistanceTimeToDestination_Status distanceTimeToDestination_Status) {
        if (this.getDistanceToDestinationUnit() == 255) {
            int[] nArray = new int[2];
            switch (this.getCurrentDistanceUnit()) {
                case 1: {
                    ServiceManager.serviceManager.fixFormat.cnv2Distance1Miles(this.getDistanceToDestinationDistance(), nArray);
                    break;
                }
                default: {
                    ServiceManager.serviceManager.fixFormat.cnv2Distance1Kilometers(this.getDistanceToDestinationDistance(), nArray);
                }
            }
            distanceTimeToDestination_Status.distanceToDestination.unit = nArray[1];
            distanceTimeToDestination_Status.distanceToDestination.distance = nArray[0];
        } else {
            distanceTimeToDestination_Status.distanceToDestination.unit = this.getDistanceToDestinationUnit();
            distanceTimeToDestination_Status.distanceToDestination.distance = this.getDistanceToDestinationDistance();
        }
    }

    private void setValidityInformation(DistanceTimeToDestination_Status distanceTimeToDestination_Status) {
        if (this.getRouteGuidanceState() != 1) {
            distanceTimeToDestination_Status.distanceToDestination.distance = -1;
        }
    }

    private void sendDistanceToDestination(DistanceTimeToDestination_Status distanceTimeToDestination_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(distanceTimeToDestination_Status, this);
    }

    private DistanceTimeToDestination_Status computeDistanceToDestinationStatus() {
        DistanceTimeToDestination_Status distanceTimeToDestination_Status = this.dequeueBAPEntity();
        this.setDistanceAndUnit(distanceTimeToDestination_Status);
        this.setTimeInfo(distanceTimeToDestination_Status);
        this.setValidityInformation(distanceTimeToDestination_Status);
        return distanceTimeToDestination_Status;
    }
}

