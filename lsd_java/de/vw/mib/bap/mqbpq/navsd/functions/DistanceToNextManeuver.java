/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceToNextManeuver_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.DistanceToNextManeuverStage;

public final class DistanceToNextManeuver
extends DistanceToNextManeuverStage {
    private static final int NUMBER_OF_VALUES;
    private static final int WUSCHKE_DISTANCE_KM_CONSTANT;
    private static final int WUSCHKE_DISTANCE_MILES_CONSTANT;
    private static final int INVALID_DISTANCE;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return super.init(bAPStageInitializer);
    }

    private int verifiedBapBargraphSetting() {
        int n;
        IntegerIterator integerIterator = this.getMainElement();
        if (integerIterator.size() > 0) {
            switch (integerIterator.nextInteger()) {
                case 3: 
                case 4: 
                case 5: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 32: 
                case 33: 
                case 34: 
                case 35: {
                    n = this.getNextManeuverBargraphOnOff();
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = this.getNextManeuverBargraphOnOff();
        }
        return n;
    }

    private boolean showDistanceToNextManeuver() {
        boolean bl;
        IntegerIterator integerIterator = this.getMainElement();
        if (integerIterator.size() > 0) {
            switch (integerIterator.nextInteger()) {
                case 8: 
                case 9: 
                case 10: {
                    bl = false;
                    break;
                }
                default: {
                    bl = true;
                    break;
                }
            }
        } else {
            bl = false;
        }
        return bl;
    }

    private void setDistanceToNextManeuverStatusData(DistanceToNextManeuver_Status distanceToNextManeuver_Status) {
        boolean bl = this.getRouteGuidanceState() == 1;
        boolean bl2 = this.getNextManeuverDistance() > 0 && bl;
        distanceToNextManeuver_Status.bargraphInfo.bargraphOnOff = this.verifiedBapBargraphSetting();
        this.computeDistanceAndDistanceUnit(distanceToNextManeuver_Status, bl);
        distanceToNextManeuver_Status.bargraphInfo.bargraph = (int)((double)this.getNextManeuverBargraph() / 100.0 * 255.0);
        if (distanceToNextManeuver_Status.distanceToNextManeuver.unit != 0 && distanceToNextManeuver_Status.distanceToNextManeuver.unit != 3) {
            if (distanceToNextManeuver_Status.distanceToNextManeuver.unit == 4) {
                if (!bl2 || distanceToNextManeuver_Status.distanceToNextManeuver.distance > 125) {
                    distanceToNextManeuver_Status.distanceToNextManeuver.distance = -1;
                }
            } else if (!bl2 || distanceToNextManeuver_Status.distanceToNextManeuver.distance > 200) {
                distanceToNextManeuver_Status.distanceToNextManeuver.distance = -1;
            }
        } else if (!bl2) {
            distanceToNextManeuver_Status.distanceToNextManeuver.distance = -1;
        }
        if (distanceToNextManeuver_Status.distanceToNextManeuver.distance != -1 && distanceToNextManeuver_Status.bargraphInfo.bargraphOnOff == 1) {
            distanceToNextManeuver_Status.distanceToNextManeuver.distance = -1;
        }
        if (distanceToNextManeuver_Status.distanceToNextManeuver.distance != -1 && !this.showDistanceToNextManeuver()) {
            distanceToNextManeuver_Status.distanceToNextManeuver.distance = -1;
        }
    }

    private void sendDistanceToNextManeuverStatus(DistanceToNextManeuver_Status distanceToNextManeuver_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(distanceToNextManeuver_Status, this);
    }

    @Override
    public void process(int n) {
        DistanceToNextManeuver_Status distanceToNextManeuver_Status = this.dequeueBAPEntity();
        this.setDistanceToNextManeuverStatusData(distanceToNextManeuver_Status);
        this.sendDistanceToNextManeuverStatus(distanceToNextManeuver_Status);
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

    private void computeDistanceAndDistanceUnit(DistanceToNextManeuver_Status distanceToNextManeuver_Status, boolean bl) {
        if (bl) {
            int[] nArray = new int[2];
            switch (this.getCurrentDistanceUnit()) {
                case 1: {
                    ServiceManager.serviceManager.fixFormat.cnv2Distance2withMinDistanceMiles(this.getNextManeuverDistance(), nArray);
                    break;
                }
                default: {
                    ServiceManager.serviceManager.fixFormat.cnvDistance2KilometersExt(this.getNextManeuverDistance(), nArray);
                }
            }
            distanceToNextManeuver_Status.distanceToNextManeuver.distance = nArray[0];
            distanceToNextManeuver_Status.distanceToNextManeuver.unit = nArray[1];
        } else {
            distanceToNextManeuver_Status.distanceToNextManeuver.distance = -1;
            distanceToNextManeuver_Status.distanceToNextManeuver.unit = 255;
        }
    }
}

