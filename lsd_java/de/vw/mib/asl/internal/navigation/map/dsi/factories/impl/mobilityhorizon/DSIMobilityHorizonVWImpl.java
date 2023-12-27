/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMobilityHorizonVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon.DSIMobilityHorizonDatapool;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class DSIMobilityHorizonVWImpl
implements DSIMobilityHorizonVW {
    private DSIMobilityHorizon dsiMobilityHorizon;
    private final DSIMobilityHorizonDatapool dsiMobilityHorizonDataPool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMobilityHorizonVWImpl]");
    private boolean facadeEnabled;

    public DSIMobilityHorizonVWImpl(DSIMobilityHorizonDatapool dSIMobilityHorizonDatapool) {
        this.dsiMobilityHorizonDataPool = dSIMobilityHorizonDatapool;
    }

    public DSIMobilityHorizon getDsiMobilityHorizon() {
        return this.dsiMobilityHorizon;
    }

    public boolean isFacadeEnabled() {
        return this.facadeEnabled;
    }

    @Override
    public void setConsideredLocationTypes(int[] nArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setConsideredLocationTypes(consideredLocationTypes.length=").append(nArray.length).append(")").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'setConsideredLocationTypes( int[] consideredLocationTypes )' will be ignored");
            return;
        }
        this.dsiMobilityHorizonDataPool.setConsideredLocationTypes(nArray);
        this.dsiMobilityHorizon.setConsideredLocationTypes(nArray);
    }

    @Override
    public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setConsumptionInfo(consumptionInfo.length=").append(consumptionInfoArray.length).append(")").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'setConsumptionInfo( ConsumptionInfo[] consumptionInfo )' will be ignored");
            return;
        }
        this.dsiMobilityHorizonDataPool.setConsumptionInfo(consumptionInfoArray);
        this.dsiMobilityHorizon.setConsumptionInfo(consumptionInfoArray);
    }

    @Override
    public void setDriveTrainMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setDriveTrainMode(driveTrainMode=").append(n).append(")").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'setDriveTrainMode( int driveTrainMode )' will be ignored");
            return;
        }
        this.dsiMobilityHorizonDataPool.setDriveTrainMode(n);
        this.dsiMobilityHorizon.setDriveTrainMode(n);
    }

    public void setDsiMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
        this.dsiMobilityHorizon = dSIMobilityHorizon;
    }

    public void setFacadeEnabled(boolean bl) {
        this.facadeEnabled = bl;
    }

    @Override
    public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setLocations(locations.length=").append(mobilityHorizonLocationArray.length).append(")").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'setLocations( MobilityHorizonLocation[] locations )' will be ignored");
            return;
        }
        this.dsiMobilityHorizonDataPool.setLocations(mobilityHorizonLocationArray);
        this.dsiMobilityHorizon.setLocations(mobilityHorizonLocationArray);
    }
}

