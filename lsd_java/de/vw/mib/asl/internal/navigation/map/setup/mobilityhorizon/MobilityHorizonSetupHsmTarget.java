/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupDatapool;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupNotifierModel;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupStateInit;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class MobilityHorizonSetupHsmTarget
extends AbstractASLHsmTarget {
    final MobilityHorizonSetupDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MobilityHorizonSetupHsmTarget]");
    final MobilityHorizonSetupNotifierDSI notifierDSI;
    final MobilityHorizonSetupNotifierModel notifierModel;
    private final MobilityHorizonSetupStateInit stateInit;
    private final MobilityHorizonSetupStateWork stateWork;

    public MobilityHorizonSetupHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MobilityHorizonSetupDatapool();
        this.notifierDSI = new MobilityHorizonSetupNotifierDSI();
        this.notifierModel = new MobilityHorizonSetupNotifierModel();
        this.stateInit = new MobilityHorizonSetupStateInit(this, this.getHsm(), "stateInit", this.getWorkStateParent());
        this.stateWork = new MobilityHorizonSetupStateWork(this, this.getHsm(), "stateWork", this.getWorkStateParent());
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    public void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    public void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    public void updateHomeLocation() {
        this.logger.trace("updateHomeLocation()");
        NavLocation navLocation = this.datapool.getHomeLocation();
        if (navLocation == null) {
            int[] nArray = new int[]{1};
            this.datapool.setMobilityHorizonConsideredLocationTypes(nArray);
            this.notifierModel.notifyLocationTypeOneWay();
            this.notifierDSI.setConsideredLocationTypes(nArray);
        } else {
            NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(navLocation.longitude, navLocation.latitude);
            MobilityHorizonLocation mobilityHorizonLocation = new MobilityHorizonLocation(navLocationWgs84, 2);
            this.notifierDSI.setLocations(new MobilityHorizonLocation[]{mobilityHorizonLocation});
        }
    }
}

