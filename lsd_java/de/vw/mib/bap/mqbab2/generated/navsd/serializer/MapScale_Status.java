/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_AutoZoomState;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapScale_Status$SupportedAutoZoom;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_Status
implements StatusProperty {
    public int reserve1;
    public int autoZoom;
    private static final int AUTO_ZOOM_BITSIZE;
    public static final int AUTO_ZOOM_AUTO_ZOOM_OFF;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON_FOR_INTERSECTION;
    public static final int AUTO_ZOOM_AUTO_ZOOM_SETTING_NOT_SUPPORTED;
    public final MapScale_AutoZoomState autoZoomState = new MapScale_AutoZoomState();
    public int scale;
    public int unit;
    public static final int UNIT_METER;
    public static final int UNIT_KILOMETER;
    public static final int UNIT_YARD;
    public static final int UNIT_FEET;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE;
    public static final int UNIT_QUARTER_MILES_N_1_4MILE;
    public static final int UNIT_KILOMETER_STEP_0_1;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE_STEP_0_1;
    public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_AVAILABLE;
    public final MapScale_Status$SupportedAutoZoom supportedAutoZoom = new MapScale_Status$SupportedAutoZoom();

    public MapScale_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
        this.autoZoom = 0;
        this.scale = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.autoZoomState.reset();
        this.supportedAutoZoom.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_Status mapScale_Status = (MapScale_Status)bAPEntity;
        return this.reserve1 == mapScale_Status.reserve1 && this.autoZoom == mapScale_Status.autoZoom && this.autoZoomState.equalTo(mapScale_Status.autoZoomState) && this.scale == mapScale_Status.scale && this.unit == mapScale_Status.unit && this.supportedAutoZoom.equalTo(mapScale_Status.supportedAutoZoom);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapScale_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.reserve1);
        bitStream.pushBits(4, this.autoZoom);
        this.autoZoomState.serialize(bitStream);
        bitStream.pushShort((short)this.scale);
        bitStream.pushByte((byte)this.unit);
        this.supportedAutoZoom.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MapScale_Status.functionId();
    }
}

