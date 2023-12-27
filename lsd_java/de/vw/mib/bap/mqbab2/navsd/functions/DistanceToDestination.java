/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationDistanceToDestination;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToDestination_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class DistanceToDestination
extends Function
implements Property,
ASLNavSDConstants,
SystemServiceListener,
NavigationServiceListener {
    private static final int NUMBER_OF_VALUES;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$DistanceToDestination_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return this.computeDistanceToDestinationStatus();
    }

    protected DistanceToDestination_Status dequeueBAPEntity() {
        return (DistanceToDestination_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$DistanceToDestination_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$DistanceToDestination_Status = DistanceToDestination.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToDestination_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$DistanceToDestination_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 21;
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
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
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

    private void setDistanceAndUnit(DistanceToDestination_Status distanceToDestination_Status) {
        NavigationDistanceToDestination navigationDistanceToDestination = this.getNavigationService().getDistanceToDestination();
        switch (navigationDistanceToDestination.getDistanceToDestinationType()) {
            case 1: {
                distanceToDestination_Status.distanceToDestinationType.distanceToStopover = true;
                break;
            }
            default: {
                distanceToDestination_Status.distanceToDestinationType.distanceToStopover = false;
            }
        }
        if (navigationDistanceToDestination.getDistanceToDestinationDistanceUnit() == 255) {
            int[] nArray = new int[2];
            switch (this.getSystemService().getCurrentDistanceUnit()) {
                case 1: {
                    this.getFixFormatter().cnv2Distance1Miles(navigationDistanceToDestination.getDistanceToDestinationDistance(), nArray);
                    break;
                }
                default: {
                    this.getFixFormatter().cnv2Distance1Kilometers(navigationDistanceToDestination.getDistanceToDestinationDistance(), nArray);
                }
            }
            distanceToDestination_Status.distanceToDestination.unit = nArray[1];
            distanceToDestination_Status.distanceToDestination.distance = nArray[0];
        } else {
            distanceToDestination_Status.distanceToDestination.unit = navigationDistanceToDestination.getDistanceToDestinationDistanceUnit();
            distanceToDestination_Status.distanceToDestination.distance = navigationDistanceToDestination.getDistanceToDestinationDistance();
        }
    }

    private void setValidityInformation(DistanceToDestination_Status distanceToDestination_Status) {
        distanceToDestination_Status.validityInformation.distanceToDestinationValid = this.getNavigationService().getRouteGuidanceState() == 1;
    }

    private void sendDistanceToDestination(DistanceToDestination_Status distanceToDestination_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(distanceToDestination_Status, this);
    }

    private DistanceToDestination_Status computeDistanceToDestinationStatus() {
        DistanceToDestination_Status distanceToDestination_Status = this.dequeueBAPEntity();
        this.setDistanceAndUnit(distanceToDestination_Status);
        this.setValidityInformation(distanceToDestination_Status);
        return distanceToDestination_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
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
        SYSTEM_LISTENER_IDS = new int[]{1584};
        NAVIGATION_LISTENER_IDS = new int[]{732, 749};
    }
}

