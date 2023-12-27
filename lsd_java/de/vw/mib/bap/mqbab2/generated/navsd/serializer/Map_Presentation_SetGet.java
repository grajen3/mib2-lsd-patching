/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Map_Presentation_ASG_HMI_State;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Map_Presentation_SetGet
implements SetGetProperty {
    public final Map_Presentation_ASG_HMI_State asg_Hmi_State = new Map_Presentation_ASG_HMI_State();

    public Map_Presentation_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public Map_Presentation_SetGet(BitStream bitStream) {
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
        Map_Presentation_SetGet map_Presentation_SetGet = (Map_Presentation_SetGet)bAPEntity;
        return this.asg_Hmi_State.equalTo(map_Presentation_SetGet.asg_Hmi_State);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Map_Presentation_SetGet:";
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
        this.asg_Hmi_State.deserialize(bitStream);
    }

    public static int functionId() {
        return 54;
    }

    @Override
    public int getFunctionId() {
        return Map_Presentation_SetGet.functionId();
    }
}

