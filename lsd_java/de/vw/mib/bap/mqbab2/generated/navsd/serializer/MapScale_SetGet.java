/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_AutoZoomState;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_SetGet
implements SetGetProperty {
    public int steps;
    public int autoZoom;
    private static final int AUTO_ZOOM_BITSIZE;
    public static final int AUTO_ZOOM_AUTO_ZOOM_OFF;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON_FOR_INTERSECTION;
    public static final int AUTO_ZOOM_AUTO_ZOOM_SETTING_NOT_SUPPORTED;
    public final MapScale_AutoZoomState autoZoomState = new MapScale_AutoZoomState();
    public int reserve2;
    public int reserve3;
    public int reserve4;

    public MapScale_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.steps = 0;
        this.autoZoom = 0;
        this.reserve2 = 0;
        this.reserve3 = 0;
        this.reserve4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.autoZoomState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_SetGet mapScale_SetGet = (MapScale_SetGet)bAPEntity;
        return this.steps == mapScale_SetGet.steps && this.autoZoom == mapScale_SetGet.autoZoom && this.autoZoomState.equalTo(mapScale_SetGet.autoZoomState) && this.reserve2 == mapScale_SetGet.reserve2 && this.reserve3 == mapScale_SetGet.reserve3 && this.reserve4 == mapScale_SetGet.reserve4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapScale_SetGet:";
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
        this.steps = (byte)bitStream.popFrontByte();
        this.autoZoom = bitStream.popFrontBits(4);
        this.autoZoomState.deserialize(bitStream);
        this.reserve2 = bitStream.popFrontShort();
        this.reserve3 = bitStream.popFrontByte();
        this.reserve4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MapScale_SetGet.functionId();
    }
}

