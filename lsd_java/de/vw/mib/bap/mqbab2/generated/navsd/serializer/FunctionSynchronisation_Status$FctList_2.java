/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status$FctList_2
implements BAPEntity {
    public boolean fct_OnlineNavigationStateIsToBeSynchronised;
    public boolean fct_ExitViewIsToBeSynchronised;
    public boolean fct_SemidynamicRouteGuidanceIsToBeSynchronised;
    private static final int RESERVED_BIT_3__4_BITSIZE;
    public boolean fct_Fsg_SetupIsToBeSynchronised;
    public boolean fct_MapPresentationIsToBeSynchronised;
    public boolean reserved_bit_7;

    public FunctionSynchronisation_Status$FctList_2() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status$FctList_2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fct_OnlineNavigationStateIsToBeSynchronised = false;
        this.fct_ExitViewIsToBeSynchronised = false;
        this.fct_SemidynamicRouteGuidanceIsToBeSynchronised = false;
        this.fct_Fsg_SetupIsToBeSynchronised = false;
        this.fct_MapPresentationIsToBeSynchronised = false;
        this.reserved_bit_7 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status$FctList_2 functionSynchronisation_Status$FctList_2 = (FunctionSynchronisation_Status$FctList_2)bAPEntity;
        return this.fct_OnlineNavigationStateIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_OnlineNavigationStateIsToBeSynchronised && this.fct_ExitViewIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_ExitViewIsToBeSynchronised && this.fct_SemidynamicRouteGuidanceIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_SemidynamicRouteGuidanceIsToBeSynchronised && this.fct_Fsg_SetupIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_Fsg_SetupIsToBeSynchronised && this.fct_MapPresentationIsToBeSynchronised == functionSynchronisation_Status$FctList_2.fct_MapPresentationIsToBeSynchronised && this.reserved_bit_7 == functionSynchronisation_Status$FctList_2.reserved_bit_7;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FctList_2:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.fct_OnlineNavigationStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_ExitViewIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_SemidynamicRouteGuidanceIsToBeSynchronised);
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.fct_Fsg_SetupIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_MapPresentationIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_7);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

