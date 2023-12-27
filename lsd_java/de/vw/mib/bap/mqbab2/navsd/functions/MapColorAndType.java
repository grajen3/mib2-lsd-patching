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
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationSupportedMapTypes;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapColorAndType_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapColorAndType_Status;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapColorAndType_Status$SupportedMapTypes;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class MapColorAndType
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener,
SystemServiceListener {
    protected static final int[] NAVIGATION_LISTENER_IDS = new int[]{3792, 3795};
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1602};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapColorAndType_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        return this.computeMapColorAndTypeStatus();
    }

    protected MapColorAndType_Status dequeueBAPEntity() {
        return (MapColorAndType_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapColorAndType_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapColorAndType_Status = MapColorAndType.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapColorAndType_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapColorAndType_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 43;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeMapColorAndTypeStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        NavigationService navigationService = this.getNavigationService();
        MapColorAndType_SetGet mapColorAndType_SetGet = (MapColorAndType_SetGet)bAPEntity;
        if (this.bapSetGetParametersValid(mapColorAndType_SetGet)) {
            boolean bl;
            boolean bl2 = false;
            if (this.getBapMapColor() != mapColorAndType_SetGet.colour) {
                int n;
                switch (mapColorAndType_SetGet.colour) {
                    case 0: {
                        n = 2;
                        break;
                    }
                    case 1: {
                        n = 1;
                        break;
                    }
                    default: {
                        n = 0;
                    }
                }
                this.getSystemService().setDayAndNightMode(n);
                bl2 = true;
            }
            NavigationSupportedMapTypes navigationSupportedMapTypes = navigationService.getSupportedMapTypes();
            switch (mapColorAndType_SetGet.activeMapType) {
                case 0: {
                    bl = navigationSupportedMapTypes.isSupportedMapTypesDestinationMapSupported();
                    break;
                }
                case 1: {
                    bl = navigationSupportedMapTypes.isSupportedMapTypesPosition2DMapSupported();
                    break;
                }
                case 2: {
                    bl = navigationSupportedMapTypes.isSupportedMapTypesPosition3DMapSupported();
                    break;
                }
                case 3: {
                    bl = navigationSupportedMapTypes.isSupportedMapTypesOverviewMapSupported();
                    break;
                }
                default: {
                    bl = false;
                }
            }
            if (bl && this.getBapActiveMapType() != mapColorAndType_SetGet.activeMapType) {
                navigationService.setActiveMapType(mapColorAndType_SetGet.activeMapType);
                bl2 = true;
            }
            if (!bl2) {
                propertyListener.statusProperty(this.computeMapColorAndTypeStatus(), this);
            }
        } else {
            propertyListener.requestError(65, this);
        }
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

    private MapColorAndType_Status computeMapColorAndTypeStatus() {
        MapColorAndType_Status mapColorAndType_Status = this.dequeueBAPEntity();
        mapColorAndType_Status.colour = this.getBapMapColor();
        mapColorAndType_Status.activeMapType = this.getNavigationService().getActiveMapType();
        this.setBapSupportedMapTypes(mapColorAndType_Status.supportedMapTypes);
        return mapColorAndType_Status;
    }

    private int getBapMapColor() {
        int n;
        int n2 = this.getSystemService().getDayAndNightMode();
        switch (n2) {
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private boolean bapSetGetParametersValid(MapColorAndType_SetGet mapColorAndType_SetGet) {
        return false;
    }

    private int getBapActiveMapType() {
        return this.getNavigationService().getActiveMapType();
    }

    private void setBapSupportedMapTypes(MapColorAndType_Status$SupportedMapTypes mapColorAndType_Status$SupportedMapTypes) {
        NavigationSupportedMapTypes navigationSupportedMapTypes = this.getNavigationService().getSupportedMapTypes();
        mapColorAndType_Status$SupportedMapTypes.destinationMapIsSupported = navigationSupportedMapTypes.isSupportedMapTypesDestinationMapSupported();
        mapColorAndType_Status$SupportedMapTypes.position2DMapIsSupported = navigationSupportedMapTypes.isSupportedMapTypesPosition2DMapSupported();
        mapColorAndType_Status$SupportedMapTypes.position3DMapIsSupported = navigationSupportedMapTypes.isSupportedMapTypesPosition3DMapSupported();
        mapColorAndType_Status$SupportedMapTypes.overviewMapIsSupported = navigationSupportedMapTypes.isSupportedMapTypesOverviewMapSupported();
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
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
}

