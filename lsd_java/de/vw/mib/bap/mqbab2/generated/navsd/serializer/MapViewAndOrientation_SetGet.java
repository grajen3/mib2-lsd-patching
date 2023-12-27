/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapViewAndOrientation_MapVisibility;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_SetGet
implements SetGetProperty {
    public int mapView;
    public static final int MAP_VIEW_STANDARD;
    public static final int MAP_VIEW_GOOGLE_EARTH;
    public static final int MAP_VIEW_TRAFFIC;
    public int supplementaryMapView;
    public static final int SUPPLEMENTARY_MAP_VIEW_NO_SUPPLEMENTARY_MAP_VIEW;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM;
    public static final int SUPPLEMENTARY_MAP_VIEW_COMPASS;
    public static final int SUPPLEMENTARY_MAP_VIEW_31_BOX;
    public int reserve1;
    public int reserve2;
    public final MapViewAndOrientation_MapVisibility mapVisibility = new MapViewAndOrientation_MapVisibility();
    public int mapOrientation;
    public static final int MAP_ORIENTATION_AUTOMATIC;
    public static final int MAP_ORIENTATION_NORTH;
    public static final int MAP_ORIENTATION_DIRECTION_OF_TRAVEL;
    public int reserve3;

    public MapViewAndOrientation_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mapView = 0;
        this.supplementaryMapView = 0;
        this.reserve1 = 0;
        this.reserve2 = 0;
        this.mapOrientation = 0;
        this.reserve3 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.mapVisibility.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_SetGet mapViewAndOrientation_SetGet = (MapViewAndOrientation_SetGet)bAPEntity;
        return this.mapView == mapViewAndOrientation_SetGet.mapView && this.supplementaryMapView == mapViewAndOrientation_SetGet.supplementaryMapView && this.reserve1 == mapViewAndOrientation_SetGet.reserve1 && this.reserve2 == mapViewAndOrientation_SetGet.reserve2 && this.mapVisibility.equalTo(mapViewAndOrientation_SetGet.mapVisibility) && this.mapOrientation == mapViewAndOrientation_SetGet.mapOrientation && this.reserve3 == mapViewAndOrientation_SetGet.reserve3;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapViewAndOrientation_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mapView = bitStream.popFrontByte();
        this.supplementaryMapView = bitStream.popFrontByte();
        this.reserve1 = bitStream.popFrontByte();
        this.reserve2 = bitStream.popFrontByte();
        this.mapVisibility.deserialize(bitStream);
        this.mapOrientation = bitStream.popFrontByte();
        this.reserve3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 44;
    }

    @Override
    public int getFunctionId() {
        return MapViewAndOrientation_SetGet.functionId();
    }
}

