/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Map_Presentation_ASG_HMI_State;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Map_Presentation_Status
implements StatusProperty {
    public final Map_Presentation_ASG_HMI_State asg_Hmi_State = new Map_Presentation_ASG_HMI_State();

    public Map_Presentation_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Map_Presentation_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.asg_Hmi_State.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Map_Presentation_Status map_Presentation_Status = (Map_Presentation_Status)bAPEntity;
        return this.asg_Hmi_State.equalTo(map_Presentation_Status.asg_Hmi_State);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Map_Presentation_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.asg_Hmi_State.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 54;
    }

    @Override
    public int getFunctionId() {
        return Map_Presentation_Status.functionId();
    }
}

