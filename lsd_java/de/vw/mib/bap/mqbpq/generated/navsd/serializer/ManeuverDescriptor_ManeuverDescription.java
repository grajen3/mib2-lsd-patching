/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_ManeuverDescription
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_MAIN_ELEMENT_DIRECTION_Z_LEVEL_GUIDANCE_SIDESTREETS;
    public static final int RECORD_ADDRESS_MAIN_ELEMENT;
    public static final int RECORD_ADDRESS_DIRECTION;
    public static final int RECORD_ADDRESS_Z_LEVEL_GUIDANCE;
    public static final int RECORD_ADDRESS_SIDESTREETS;
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
    public int direction;
    public int zLevelGuidance;
    public static final int Z_LEVEL_GUIDANCE_NO_Z_LEVEL_GUIDANCE;
    public static final int Z_LEVEL_GUIDANCE_UP;
    public static final int Z_LEVEL_GUIDANCE_DOWN;
    public static final int Z_LEVEL_GUIDANCE_NOT_SUPPORTED;
    public final BAPString sidestreets;
    private static final int MAX_SIDESTREETS_LENGTH;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public ManeuverDescriptor_ManeuverDescription(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.sidestreets = new BAPString(17);
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_ManeuverDescription(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
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
        this.arrayHeader.reset();
        this.sidestreets.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription = (ManeuverDescriptor_ManeuverDescription)bAPEntity;
        return this.arrayHeader.equalTo(maneuverDescriptor_ManeuverDescription.arrayHeader) && this.mainElement == maneuverDescriptor_ManeuverDescription.mainElement && this.direction == maneuverDescriptor_ManeuverDescription.direction && this.zLevelGuidance == maneuverDescriptor_ManeuverDescription.zLevelGuidance && this.sidestreets.equalTo(maneuverDescriptor_ManeuverDescription.sidestreets);
    }

    @Override
    public int getPos() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_ManeuverDescription");
    }

    @Override
    public void setPos(int n) {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_ManeuverDescription");
    }

    private void customInitialization() {
        this.sidestreets.setRawContent();
    }

    @Override
    public String toString() {
        return "ManeuverDescriptor_ManeuverDescription:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                bitStream.pushByte((byte)this.mainElement);
                bitStream.pushByte((byte)this.direction);
                bitStream.pushByte((byte)this.zLevelGuidance);
                this.sidestreets.serialize(bitStream);
                break;
            }
            case 1: {
                bitStream.pushByte((byte)this.mainElement);
                break;
            }
            case 2: {
                bitStream.pushByte((byte)this.direction);
                break;
            }
            case 3: {
                bitStream.pushByte((byte)this.zLevelGuidance);
                break;
            }
            case 4: {
                this.sidestreets.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

