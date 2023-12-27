/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapColorAndType_SetGet
implements SetGetProperty {
    public int colour;
    public static final int COLOUR_DAY;
    public static final int COLOUR_NIGHT;
    public static final int COLOUR_AUTO;
    public int activeMapType;
    public static final int ACTIVE_MAP_TYPE_DESTINATION;
    public static final int ACTIVE_MAP_TYPE_POSITION_2D;
    public static final int ACTIVE_MAP_TYPE_POSITION_3D;
    public static final int ACTIVE_MAP_TYPE_OVERVIEW;
    public static final int ACTIVE_MAP_TYPE_RANGE_MAP;
    public int mainMapSetup;
    public static final int MAIN_MAP_SETUP_INIT_NO_MAP_IN_ASG;
    public static final int MAIN_MAP_SETUP_MAIN_MAP_IN_ASG;
    public static final int MAIN_MAP_SETUP_MAIN_MAP_IN_FSG;
    public static final int MAIN_MAP_SETUP_NOT_SUPPORTED;
    public int reserve;

    public MapColorAndType_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MapColorAndType_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.colour = 0;
        this.activeMapType = 0;
        this.mainMapSetup = 0;
        this.reserve = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapColorAndType_SetGet mapColorAndType_SetGet = (MapColorAndType_SetGet)bAPEntity;
        return this.colour == mapColorAndType_SetGet.colour && this.activeMapType == mapColorAndType_SetGet.activeMapType && this.mainMapSetup == mapColorAndType_SetGet.mainMapSetup && this.reserve == mapColorAndType_SetGet.reserve;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapColorAndType_SetGet:";
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
        this.colour = bitStream.popFrontByte();
        this.activeMapType = bitStream.popFrontByte();
        this.mainMapSetup = bitStream.popFrontByte();
        this.reserve = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 43;
    }

    @Override
    public int getFunctionId() {
        return MapColorAndType_SetGet.functionId();
    }
}

