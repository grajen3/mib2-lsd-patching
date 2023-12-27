/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.MapColorAndType_Status$SupportedMapTypes;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapColorAndType_Status
implements StatusProperty {
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
    public final MapColorAndType_Status$SupportedMapTypes supportedMapTypes = new MapColorAndType_Status$SupportedMapTypes();

    public MapColorAndType_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MapColorAndType_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.colour = 0;
        this.activeMapType = 0;
        this.mainMapSetup = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.supportedMapTypes.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapColorAndType_Status mapColorAndType_Status = (MapColorAndType_Status)bAPEntity;
        return this.colour == mapColorAndType_Status.colour && this.activeMapType == mapColorAndType_Status.activeMapType && this.mainMapSetup == mapColorAndType_Status.mainMapSetup && this.supportedMapTypes.equalTo(mapColorAndType_Status.supportedMapTypes);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapColorAndType_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.colour);
        bitStream.pushByte((byte)this.activeMapType);
        bitStream.pushByte((byte)this.mainMapSetup);
        this.supportedMapTypes.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 43;
    }

    @Override
    public int getFunctionId() {
        return MapColorAndType_Status.functionId();
    }
}

