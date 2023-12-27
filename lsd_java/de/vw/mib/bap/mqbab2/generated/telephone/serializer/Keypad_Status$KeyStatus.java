/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Keypad_Status$KeyStatus
implements BAPEntity {
    public boolean inforufPressedTooShort;
    public boolean inforufLongPressed;
    public boolean pannenrufPressedTooShort;
    public boolean pannenrufLongPressed;
    public boolean eCallPressedTooShort;
    public boolean eCallLongPressed;
    private static final int RESERVED_BIT_6__7_BITSIZE;

    public Keypad_Status$KeyStatus() {
        this.internalReset();
        this.customInitialization();
    }

    public Keypad_Status$KeyStatus(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.inforufPressedTooShort = false;
        this.inforufLongPressed = false;
        this.pannenrufPressedTooShort = false;
        this.pannenrufLongPressed = false;
        this.eCallPressedTooShort = false;
        this.eCallLongPressed = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Keypad_Status$KeyStatus keypad_Status$KeyStatus = (Keypad_Status$KeyStatus)bAPEntity;
        return this.inforufPressedTooShort == keypad_Status$KeyStatus.inforufPressedTooShort && this.inforufLongPressed == keypad_Status$KeyStatus.inforufLongPressed && this.pannenrufPressedTooShort == keypad_Status$KeyStatus.pannenrufPressedTooShort && this.pannenrufLongPressed == keypad_Status$KeyStatus.pannenrufLongPressed && this.eCallPressedTooShort == keypad_Status$KeyStatus.eCallPressedTooShort && this.eCallLongPressed == keypad_Status$KeyStatus.eCallLongPressed;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "KeyStatus:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.inforufPressedTooShort);
        bitStream.pushBoolean(this.inforufLongPressed);
        bitStream.pushBoolean(this.pannenrufPressedTooShort);
        bitStream.pushBoolean(this.pannenrufLongPressed);
        bitStream.pushBoolean(this.eCallPressedTooShort);
        bitStream.pushBoolean(this.eCallLongPressed);
        bitStream.resetBits(2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

