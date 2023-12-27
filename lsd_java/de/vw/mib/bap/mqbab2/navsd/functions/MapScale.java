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
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationMapScale;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class MapScale
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener {
    private static final int VALUE_AUTOZOOM_DISABLED;
    private static final int VALUE_AUTOZOOM_ENABLED;
    private static final int VALUE_CONTINUOUS_ZOOM_STOP;
    private static final int VALUE_CONTINUOUS_ZOOM_IN;
    private static final int VALUE_CONTINUOUS_ZOOM_OUT;
    private static final int VALUE_ZOOM_IN;
    private static final int VALUE_ZOOM_OUT;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    private static final int ZOOM_TYPE_STEP;
    private static final int ZOOM_TYPE_CONTINUOUS;
    private static final int ZOOM_TYPE_CONTINUOUS_STOP;
    private static final int ZOOM_TYPE_AUTOZOOM;
    private int currentZoomType = 1;
    private PropertyListener listener;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapScale_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return this.computeMapScaleStatus();
    }

    protected MapScale_Status dequeueBAPEntity() {
        return (MapScale_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapScale_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapScale_Status = MapScale.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapScale_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 45;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        boolean bl = this.getDelegate().getPropertyListener(this).statusProperty(this.computeMapScaleStatus(), this);
        if (this.listener != null && !bl) {
            this.listener.statusProperty(this.computeMapScaleStatus(), this);
        }
        this.listener = null;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.listener = propertyListener;
        if (bAPEntity instanceof MapScale_SetGet) {
            MapScale_SetGet mapScale_SetGet = (MapScale_SetGet)bAPEntity;
            NavigationService navigationService = this.getNavigationService();
            if (this.isBapSetGetParametersValid(mapScale_SetGet)) {
                int n = mapScale_SetGet.steps;
                int n2 = mapScale_SetGet.autoZoom;
                int n3 = this.getTypeFromValues(n, n2);
                switch (n3) {
                    case 3: 
                    case 5: {
                        navigationService.setMapScaleSteps(0, n2);
                        break;
                    }
                    case 2: {
                        navigationService.setMapScaleSteps(n, n2);
                        break;
                    }
                    case 1: {
                        if (this.currentZoomType == 2) break;
                        navigationService.setMapScaleSteps(n, n2);
                        break;
                    }
                }
                this.currentZoomType = n3;
                propertyListener.statusProperty(this.computeMapScaleStatus(), this);
            } else {
                propertyListener.requestError(65, this);
            }
        } else {
            propertyListener.requestError(69, this);
        }
    }

    private int getTypeFromValues(int n, int n2) {
        int n3 = 1;
        n3 = n2 == 1 ? 3 : (n == -128 || n == 127 ? 2 : (n == 0 ? 5 : 1));
        return n3;
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

    private boolean isBapSetGetParametersValid(MapScale_SetGet mapScale_SetGet) {
        return !(mapScale_SetGet.steps != -128 && mapScale_SetGet.steps != 127 && mapScale_SetGet.steps != -1 && mapScale_SetGet.steps != 1 && mapScale_SetGet.steps != 0 || mapScale_SetGet.autoZoom != 0 && mapScale_SetGet.autoZoom != 1);
    }

    private MapScale_Status computeMapScaleStatus() {
        MapScale_Status mapScale_Status = this.dequeueBAPEntity();
        NavigationMapScale navigationMapScale = this.getNavigationService().getMapScale();
        mapScale_Status.scale = navigationMapScale.getMapScaleScale();
        mapScale_Status.unit = navigationMapScale.getMapScaleScaleUnit();
        mapScale_Status.autoZoomState.autoZoomActive = navigationMapScale.getMapScaleAutozoom() == 1;
        return mapScale_Status;
    }

    @Override
    public void processHMIEvent(int n) {
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

    static {
        NAVIGATION_LISTENER_IDS = new int[]{3798};
    }
}

