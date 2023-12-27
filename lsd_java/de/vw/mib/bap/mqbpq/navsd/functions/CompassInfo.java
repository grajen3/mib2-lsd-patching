/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.CompassInfo_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.CompassInfoStage;

public class CompassInfo
extends CompassInfoStage {
    private static final int NOT_SUPPORTED_DIRECTION;
    private static final int MAX_ANGLE;

    private void setCompassInfoStatusData(CompassInfo_Status compassInfo_Status) {
        int n = this.getBapCompassInfoAngle() % 360;
        compassInfo_Status.direction_Angle = (360 - this.getBapCompassInfoAngle()) % 360;
        switch (ServiceManager.serviceManager.fixFormat.cnv2Orientation(n)) {
            case 0: {
                compassInfo_Status.direction_Symbolic = 0;
                break;
            }
            case 2: {
                compassInfo_Status.direction_Symbolic = 2;
                break;
            }
            case 4: {
                compassInfo_Status.direction_Symbolic = 4;
                break;
            }
            case 6: {
                compassInfo_Status.direction_Symbolic = 6;
                break;
            }
            case 8: {
                compassInfo_Status.direction_Symbolic = 8;
                break;
            }
            case 10: {
                compassInfo_Status.direction_Symbolic = 10;
                break;
            }
            case 12: {
                compassInfo_Status.direction_Symbolic = 12;
                break;
            }
            case 14: {
                compassInfo_Status.direction_Symbolic = 14;
                break;
            }
            default: {
                compassInfo_Status.direction_Symbolic = 255;
            }
        }
    }

    protected int getBapCompassInfoAngle() {
        return this.getCompassInfoAngle();
    }

    private void sendCompassInfoStatus(CompassInfo_Status compassInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(compassInfo_Status, this);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return super.init(bAPStageInitializer);
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
        this.sendCompassInfoStatus(this.computeCompassInfoStatus());
    }

    private CompassInfo_Status computeCompassInfoStatus() {
        CompassInfo_Status compassInfo_Status = this.dequeueBAPEntity();
        this.setCompassInfoStatusData(compassInfo_Status);
        return compassInfo_Status;
    }
}

