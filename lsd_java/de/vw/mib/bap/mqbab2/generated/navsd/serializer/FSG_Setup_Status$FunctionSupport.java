/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$FunctionSupport
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean activationDeactivationOfTheVideoNavigationSupported;

    public FSG_Setup_Status$FunctionSupport() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$FunctionSupport(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.activationDeactivationOfTheVideoNavigationSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$FunctionSupport fSG_Setup_Status$FunctionSupport = (FSG_Setup_Status$FunctionSupport)bAPEntity;
        return this.activationDeactivationOfTheVideoNavigationSupported == fSG_Setup_Status$FunctionSupport.activationDeactivationOfTheVideoNavigationSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionSupport:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.activationDeactivationOfTheVideoNavigationSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

