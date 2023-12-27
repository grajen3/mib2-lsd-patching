/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.car.CarService;
import de.vw.mib.bap.mqbab2.common.api.car.CarServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.CompassInfo_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class CompassInfo
extends Function
implements Property,
ASLNavSDConstants,
CarServiceListener,
NavigationServiceListener {
    private static final int NOT_SUPPORTED_DIRECTION;
    private static final int MAX_ANGLE;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    protected static final int[] CAR_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CompassInfo_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getCarService().addCarServiceListener(this, CAR_LISTENER_IDS);
        return null;
    }

    protected CompassInfo_Status dequeueBAPEntity() {
        return (CompassInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CompassInfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CompassInfo_Status = CompassInfo.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.CompassInfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$CompassInfo_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    private void setCompassInfoStatusData(CompassInfo_Status compassInfo_Status) {
        compassInfo_Status.direction_Angle = this.getBapCompassInfoAngle() % 360;
        switch (this.getFixFormatter().cnv2Orientation(compassInfo_Status.direction_Angle)) {
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
        return this.getNavigationService().getCompassInfoAngle();
    }

    private void sendCompassInfoStatus(CompassInfo_Status compassInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(compassInfo_Status, this);
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
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getCarService().removeCarServiceListener(this, CAR_LISTENER_IDS);
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

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
        this.process(-1);
    }

    @Override
    public void updateCarData(CarService carService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        NAVIGATION_LISTENER_IDS = new int[]{748};
        CAR_LISTENER_IDS = new int[]{10127};
    }
}

