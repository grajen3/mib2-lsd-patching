/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_MapVisibility;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status$Modification;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status$SupportedMapViews;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_Status$SupportedSupplementaryMapViews;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status
implements StatusProperty {
    public int mapView;
    public static final int MAP_VIEW_STANDARD;
    public static final int MAP_VIEW_GOOGLE_EARTH;
    public static final int MAP_VIEW_TRAFFIC;
    public int supplementaryMapView;
    public static final int SUPPLEMENTARY_MAP_VIEW_NO_SUPPLEMENTARY_MAP_VIEW;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM;
    public static final int SUPPLEMENTARY_MAP_VIEW_COMPASS;
    public static final int SUPPLEMENTARY_MAP_VIEW_31_BOX;
    public final MapViewAndOrientation_Status$SupportedMapViews supportedMapViews = new MapViewAndOrientation_Status$SupportedMapViews();
    public final MapViewAndOrientation_Status$SupportedSupplementaryMapViews supportedSupplementaryMapViews = new MapViewAndOrientation_Status$SupportedSupplementaryMapViews();
    public final MapViewAndOrientation_MapVisibility mapVisibility = new MapViewAndOrientation_MapVisibility();
    public int mapOrientation;
    public static final int MAP_ORIENTATION_AUTOMATIC;
    public static final int MAP_ORIENTATION_NORTH;
    public static final int MAP_ORIENTATION_DIRECTION_OF_TRAVEL;
    public final MapViewAndOrientation_Status$Modification modification = new MapViewAndOrientation_Status$Modification();

    public MapViewAndOrientation_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mapView = 0;
        this.supplementaryMapView = 0;
        this.mapOrientation = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.supportedMapViews.reset();
        this.supportedSupplementaryMapViews.reset();
        this.mapVisibility.reset();
        this.modification.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status mapViewAndOrientation_Status = (MapViewAndOrientation_Status)bAPEntity;
        return this.mapView == mapViewAndOrientation_Status.mapView && this.supplementaryMapView == mapViewAndOrientation_Status.supplementaryMapView && this.supportedMapViews.equalTo(mapViewAndOrientation_Status.supportedMapViews) && this.supportedSupplementaryMapViews.equalTo(mapViewAndOrientation_Status.supportedSupplementaryMapViews) && this.mapVisibility.equalTo(mapViewAndOrientation_Status.mapVisibility) && this.mapOrientation == mapViewAndOrientation_Status.mapOrientation && this.modification.equalTo(mapViewAndOrientation_Status.modification);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapViewAndOrientation_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mapView);
        bitStream.pushByte((byte)this.supplementaryMapView);
        this.supportedMapViews.serialize(bitStream);
        this.supportedSupplementaryMapViews.serialize(bitStream);
        this.mapVisibility.serialize(bitStream);
        bitStream.pushByte((byte)this.mapOrientation);
        this.modification.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 44;
    }

    @Override
    public int getFunctionId() {
        return MapViewAndOrientation_Status.functionId();
    }
}

