/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Calibration_Status
implements StatusProperty {
    public int calibrationState;
    public static final int CALIBRATION_STATE_CALIBRATED;
    public static final int CALIBRATION_STATE_CALIBRATION_ACTIVE;
    public static final int CALIBRATION_STATE_INTERFERING_FIELD;
    public static final int CALIBRATION_STATE_NOT_SUPPORTED;

    public Calibration_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Calibration_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.calibrationState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Calibration_Status calibration_Status = (Calibration_Status)bAPEntity;
        return this.calibrationState == calibration_Status.calibrationState;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Calibration_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.calibrationState);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return Calibration_Status.functionId();
    }
}

