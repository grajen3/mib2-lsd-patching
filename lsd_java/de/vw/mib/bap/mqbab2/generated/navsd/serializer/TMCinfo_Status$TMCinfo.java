/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TMCinfo_Status$TMCinfo$Length_Validity;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_Status$TMCinfo
implements BAPEntity {
    public int priority;
    public final BAPString streetName = new BAPString(61);
    private static final int MAX_STREET_NAME_LENGTH;
    public final BAPString location = new BAPString(61);
    private static final int MAX_LOCATION_LENGTH;
    public final BAPString infotext = new BAPString(121);
    private static final int MAX_INFOTEXT_LENGTH;
    public final TMCinfo_Status$TMCinfo$Length_Validity length_Validity = new TMCinfo_Status$TMCinfo$Length_Validity();
    public int length_Value;
    public int length_Unit;
    public static final int LENGTH_UNIT_METER;
    public static final int LENGTH_UNIT_KILOMETER;
    public static final int LENGTH_UNIT_YARD;
    public static final int LENGTH_UNIT_FEET;
    public static final int LENGTH_UNIT_MILE_US_UK_BRITISH_STATUTE_MILE;
    public static final int LENGTH_UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE;

    public TMCinfo_Status$TMCinfo() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_Status$TMCinfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.priority = 0;
        this.length_Value = 0;
        this.length_Unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.streetName.reset();
        this.location.reset();
        this.infotext.reset();
        this.length_Validity.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_Status$TMCinfo tMCinfo_Status$TMCinfo = (TMCinfo_Status$TMCinfo)bAPEntity;
        return this.priority == tMCinfo_Status$TMCinfo.priority && this.streetName.equalTo(tMCinfo_Status$TMCinfo.streetName) && this.location.equalTo(tMCinfo_Status$TMCinfo.location) && this.infotext.equalTo(tMCinfo_Status$TMCinfo.infotext) && this.length_Validity.equalTo(tMCinfo_Status$TMCinfo.length_Validity) && this.length_Value == tMCinfo_Status$TMCinfo.length_Value && this.length_Unit == tMCinfo_Status$TMCinfo.length_Unit;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TMCinfo:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.priority);
        this.streetName.serialize(bitStream);
        this.location.serialize(bitStream);
        this.infotext.serialize(bitStream);
        this.length_Validity.serialize(bitStream);
        bitStream.pushInt(this.length_Value);
        bitStream.pushByte((byte)this.length_Unit);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

