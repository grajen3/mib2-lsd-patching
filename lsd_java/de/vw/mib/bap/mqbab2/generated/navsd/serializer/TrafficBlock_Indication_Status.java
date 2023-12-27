/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficBlock_Indication_Status
implements StatusProperty {
    public int tmc_Symbol;
    public static final int TMC_SYMBOL_NO_TMC_SYMBOL;
    public static final int TMC_SYMBOL_GENERAL_DANGER_PART_1;
    public static final int TMC_SYMBOL_GENERAL_DANGER_PART_2;
    public static final int TMC_SYMBOL_GENERAL_DANGER_PART_3;
    public static final int TMC_SYMBOL_ROAD_WORKS;
    public static final int TMC_SYMBOL_STATIONARY_TRAFFIC_JAM;
    public static final int TMC_SYMBOL_SLOW_HEAVY_TRAFFIC;
    public static final int TMC_SYMBOL_ROAD_NARROWED_ROAD_WIDTH_REDUCED_ON_BOTH_SIDES;
    public static final int TMC_SYMBOL_SNOWFALL;
    public static final int TMC_SYMBOL_SLIPPERY_ROAD;
    public static final int TMC_SYMBOL_HEAVY_WINDS_STORM;
    public static final int TMC_SYMBOL_ROCKFALL_LANDSLIP;
    public static final int TMC_SYMBOL_PEOPLE_ON_THE_ROAD;
    public static final int TMC_SYMBOL_BIKER_ON_THE_ROAD;
    public static final int TMC_SYMBOL_ANIMALS_ON_ROAD;
    public static final int TMC_SYMBOL_SMOG;
    public static final int TMC_SYMBOL_CLOSED_ROAD;
    public static final int TMC_SYMBOL_OVERTAKE_RESTRICTION;
    public static final int TMC_SYMBOL_END_OF_OVERTAKE_RESTRICTION;
    public static final int TMC_SYMBOL_END_OF_ALL_RESTRICTIONS;
    public static final int TMC_SYMBOL_SNOW_CHAINS_MANDATORY;
    public static final int TMC_SYMBOL_DELAY;
    public static final int TMC_SYMBOL_ROAD_NARROWED_ON_LEFT_HAND_SIDE;
    public static final int TMC_SYMBOL_ROAD_NARROWED_ON_RIGHT_HAND_SIDE;
    public static final int TMC_SYMBOL_UNKNOWN_TMC_SYMBOL;

    public TrafficBlock_Indication_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficBlock_Indication_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.tmc_Symbol = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficBlock_Indication_Status trafficBlock_Indication_Status = (TrafficBlock_Indication_Status)bAPEntity;
        return this.tmc_Symbol == trafficBlock_Indication_Status.tmc_Symbol;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TrafficBlock_Indication_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.tmc_Symbol);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 40;
    }

    @Override
    public int getFunctionId() {
        return TrafficBlock_Indication_Status.functionId();
    }
}

