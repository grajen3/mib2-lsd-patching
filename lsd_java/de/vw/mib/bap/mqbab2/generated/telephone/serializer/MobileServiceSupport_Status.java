/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileServiceSupport_Status$FctList;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileServiceSupport_Status
implements StatusProperty {
    public final MobileServiceSupport_Status$FctList fctList = new MobileServiceSupport_Status$FctList();

    public MobileServiceSupport_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileServiceSupport_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.fctList.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileServiceSupport_Status mobileServiceSupport_Status = (MobileServiceSupport_Status)bAPEntity;
        return this.fctList.equalTo(mobileServiceSupport_Status.fctList);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MobileServiceSupport_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.fctList.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return MobileServiceSupport_Status.functionId();
    }
}

