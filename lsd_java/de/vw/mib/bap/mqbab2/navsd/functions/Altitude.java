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
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Altitude_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class Altitude
extends Function
implements Property,
ASLNavSDConstants,
SystemServiceListener,
NavigationServiceListener {
    private static final int CONVERSION_PRECISION;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Altitude_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return this.computeAltitudeStatus();
    }

    protected Altitude_Status dequeueBAPEntity() {
        return (Altitude_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Altitude_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Altitude_Status = Altitude.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.Altitude_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Altitude_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 47;
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
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeAltitudeStatus(), this);
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
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    private Altitude_Status computeAltitudeStatus() {
        Altitude_Status altitude_Status = this.dequeueBAPEntity();
        altitude_Status.altitude = this.getBapAltitude();
        altitude_Status.unit = this.getBapUnit();
        return altitude_Status;
    }

    private int getBapAltitude() {
        int n = this.getSystemService().getCurrentDistanceUnit() == 1 ? this.getFixFormatter().cnvAltitudeFeet(this.getNavigationService().getNavigationCurrentAltitude().getCurrentAltitude()) / 10 : this.getNavigationService().getNavigationCurrentAltitude().getCurrentAltitude();
        return n;
    }

    private int getBapUnit() {
        int n = this.getSystemService().getCurrentDistanceUnit() == 1 ? 1 : 0;
        return n;
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
        NAVIGATION_LISTENER_IDS = new int[]{3801};
    }
}

