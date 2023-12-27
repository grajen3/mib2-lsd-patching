/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_Status$Maneuver_1
implements BAPEntity {
    public int mainElement;
    public static final int MAIN_ELEMENT_NO_SYMBOL;
    public static final int MAIN_ELEMENT_NO_INFO;
    public static final int MAIN_ELEMENT_DIRECTION_TO_DESTINATION;
    public static final int MAIN_ELEMENT_ARRIVED;
    public static final int MAIN_ELEMENT_NEAR_DESTINATION;
    public static final int MAIN_ELEMENT_ARRIVED_DESTINATION_OFFMAP;
    public static final int MAIN_ELEMENT_OFF_ROAD;
    public static final int MAIN_ELEMENT_OFF_MAP;
    public static final int MAIN_ELEMENT_NO_ROUTE;
    public static final int MAIN_ELEMENT_CALC_ROUTE;
    public static final int MAIN_ELEMENT_RECALC_ROUTE;
    public static final int MAIN_ELEMENT_FOLLOW_STREET;
    public static final int MAIN_ELEMENT_CHANGE_LANE;
    public static final int MAIN_ELEMENT_TURN;
    public static final int MAIN_ELEMENT_TURN_ON_MAINROAD;
    public static final int MAIN_ELEMENT_EXIT_RIGHT;
    public static final int MAIN_ELEMENT_EXIT_LEFT;
    public static final int MAIN_ELEMENT_SERVICE_ROAD_RIGHT;
    public static final int MAIN_ELEMENT_SERVICE_ROAD_LEFT;
    public static final int MAIN_ELEMENT_FORK_2;
    public static final int MAIN_ELEMENT_FORK_3;
    public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT;
    public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT;
    public static final int MAIN_ELEMENT_SQUARE_TRS_RIGHT;
    public static final int MAIN_ELEMENT_SQUARE_TRS_LEFT;
    public static final int MAIN_ELEMENT_UTURN;
    public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT;
    public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT;
    public static final int MAIN_ELEMENT_PREPARE_TURN;
    public static final int MAIN_ELEMENT_PREPARE_ROUNDABOUT;
    public static final int MAIN_ELEMENT_PREPARE_SQUARE;
    public static final int MAIN_ELEMENT_PREPARE_U_TURN;
    public static final int MAIN_ELEMENT_MICHIGANG_TURN;
    public static final int MAIN_ELEMENT_DOUBLE_TURN;
    public static final int MAIN_ELEMENT_DIRECTION_TO_WAYPOINT;
    public int direction;
    public int zLevelGuidance;
    public static final int Z_LEVEL_GUIDANCE_NO_Z_LEVEL_GUIDANCE;
    public static final int Z_LEVEL_GUIDANCE_UP;
    public static final int Z_LEVEL_GUIDANCE_DOWN;
    public static final int Z_LEVEL_GUIDANCE_NOT_SUPPORTED;
    public final BAPString sidestreets = new BAPString(17);
    private static final int MAX_SIDESTREETS_LENGTH;

    public ManeuverDescriptor_Status$Maneuver_1() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_Status$Maneuver_1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mainElement = 0;
        this.direction = 0;
        this.zLevelGuidance = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.sidestreets.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverDescriptor_Status$Maneuver_1 maneuverDescriptor_Status$Maneuver_1 = (ManeuverDescriptor_Status$Maneuver_1)bAPEntity;
        return this.mainElement == maneuverDescriptor_Status$Maneuver_1.mainElement && this.direction == maneuverDescriptor_Status$Maneuver_1.direction && this.zLevelGuidance == maneuverDescriptor_Status$Maneuver_1.zLevelGuidance && this.sidestreets.equalTo(maneuverDescriptor_Status$Maneuver_1.sidestreets);
    }

    private void customInitialization() {
        this.sidestreets.setRawContent();
    }

    @Override
    public String toString() {
        return "Maneuver_1:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mainElement);
        bitStream.pushByte((byte)this.direction);
        bitStream.pushByte((byte)this.zLevelGuidance);
        this.sidestreets.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

