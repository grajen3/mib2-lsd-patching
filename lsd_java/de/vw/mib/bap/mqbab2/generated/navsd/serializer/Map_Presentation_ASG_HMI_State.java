/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Map_Presentation_ASG_HMI_State
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean rightSideMenueOpen;
    public boolean leftSideMenueOpen;
    public boolean largeMapView;

    public Map_Presentation_ASG_HMI_State() {
        this.internalReset();
        this.customInitialization();
    }

    public Map_Presentation_ASG_HMI_State(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rightSideMenueOpen = false;
        this.leftSideMenueOpen = false;
        this.largeMapView = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Map_Presentation_ASG_HMI_State map_Presentation_ASG_HMI_State = (Map_Presentation_ASG_HMI_State)bAPEntity;
        return this.rightSideMenueOpen == map_Presentation_ASG_HMI_State.rightSideMenueOpen && this.leftSideMenueOpen == map_Presentation_ASG_HMI_State.leftSideMenueOpen && this.largeMapView == map_Presentation_ASG_HMI_State.largeMapView;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Map_Presentation_ASG_HMI_State:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.rightSideMenueOpen);
        bitStream.pushBoolean(this.leftSideMenueOpen);
        bitStream.pushBoolean(this.largeMapView);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.rightSideMenueOpen = bitStream.popFrontBoolean();
        this.leftSideMenueOpen = bitStream.popFrontBoolean();
        this.largeMapView = bitStream.popFrontBoolean();
    }
}

