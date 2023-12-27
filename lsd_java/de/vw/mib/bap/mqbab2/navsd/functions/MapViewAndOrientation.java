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
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationSupportedMapViews;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status$SupportedMapViews;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status$SupportedSupplementaryMapViews;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class MapViewAndOrientation
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener {
    protected static final int[] NAVIGATION_LISTENER_IDS = new int[]{3793, 3794, 3796, 3797};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapViewAndOrientation_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return this.computeBapMapViewStatus();
    }

    protected MapViewAndOrientation_Status dequeueBAPEntity() {
        return (MapViewAndOrientation_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapViewAndOrientation_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapViewAndOrientation_Status = MapViewAndOrientation.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$MapViewAndOrientation_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 44;
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
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeBapMapViewStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        boolean bl;
        MapViewAndOrientation_SetGet mapViewAndOrientation_SetGet = (MapViewAndOrientation_SetGet)bAPEntity;
        NavigationService navigationService = this.getNavigationService();
        NavigationSupportedMapViews navigationSupportedMapViews = navigationService.getSupportedMapViews();
        switch (mapViewAndOrientation_SetGet.mapView) {
            case 0: {
                bl = navigationSupportedMapViews.isStandardMapSupported();
                break;
            }
            case 1: {
                bl = navigationSupportedMapViews.isGoogleEarthMapSupported();
                break;
            }
            case 2: {
                bl = navigationSupportedMapViews.isTrafficMapSupported();
                break;
            }
            default: {
                bl = false;
            }
        }
        if (bl && this.getBapActiveMapView() != mapViewAndOrientation_SetGet.mapView) {
            navigationService.setActiveMapView(mapViewAndOrientation_SetGet.mapView);
        } else {
            propertyListener.statusProperty(this.computeBapMapViewStatus(), this);
        }
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

    private MapViewAndOrientation_Status computeBapMapViewStatus() {
        MapViewAndOrientation_Status mapViewAndOrientation_Status = this.dequeueBAPEntity();
        mapViewAndOrientation_Status.mapView = this.getBapActiveMapView();
        mapViewAndOrientation_Status.supplementaryMapView = this.getBapSupplementaryMapView();
        this.setBapSupportedMapViews(mapViewAndOrientation_Status.supportedMapViews);
        this.setBapSupportedSupplementaryMapViews(mapViewAndOrientation_Status.supportedSupplementaryMapViews);
        mapViewAndOrientation_Status.mapVisibility.supplementaryMapViewIsVisible = this.getBapIsSupplementaryMapViewVisible();
        mapViewAndOrientation_Status.mapVisibility.lvdsMapIsVisible = this.getBapLvdsMapIsVisible();
        mapViewAndOrientation_Status.mapOrientation = this.getBapMapOrientation();
        mapViewAndOrientation_Status.modification.googleMapCanNotBeModified = this.getBapGoogleMapcanBeModified();
        return mapViewAndOrientation_Status;
    }

    private int getBapActiveMapView() {
        return this.getNavigationService().getActiveMapView();
    }

    private void setBapSupportedMapViews(MapViewAndOrientation_Status$SupportedMapViews mapViewAndOrientation_Status$SupportedMapViews) {
        NavigationSupportedMapViews navigationSupportedMapViews = this.getNavigationService().getSupportedMapViews();
        mapViewAndOrientation_Status$SupportedMapViews.standardMapIsSupported = navigationSupportedMapViews.isStandardMapSupported();
        mapViewAndOrientation_Status$SupportedMapViews.googleEarthMapIsSupported = navigationSupportedMapViews.isGoogleEarthMapSupported();
        mapViewAndOrientation_Status$SupportedMapViews.trafficMapIsSupported = navigationSupportedMapViews.isTrafficMapSupported();
    }

    private int getBapSupplementaryMapView() {
        return 0;
    }

    private void setBapSupportedSupplementaryMapViews(MapViewAndOrientation_Status.SupportedSupplementaryMapViews supportedSupplementaryMapViews) {
    }

    private boolean getBapIsSupplementaryMapViewVisible() {
        return false;
    }

    private boolean getBapLvdsMapIsVisible() {
        return false;
    }

    private int getBapMapOrientation() {
        return this.getNavigationService().getActiveMapOrientation();
    }

    private boolean getBapGoogleMapcanBeModified() {
        return false;
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
}

