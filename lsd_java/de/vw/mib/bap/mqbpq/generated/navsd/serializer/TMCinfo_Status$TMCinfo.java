/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_Status$TMCinfo
implements BAPEntity {
    public final BAPString streetName = new BAPString(61);
    private static final int MAX_STREET_NAME_LENGTH;
    public final BAPString location = new BAPString(61);
    private static final int MAX_LOCATION_LENGTH;
    public final BAPString infotext = new BAPString(121);
    private static final int MAX_INFOTEXT_LENGTH;
    public final BAPString length = new BAPString(61);
    private static final int MAX_LENGTH_LENGTH;

    public TMCinfo_Status$TMCinfo() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_Status$TMCinfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.streetName.reset();
        this.location.reset();
        this.infotext.reset();
        this.length.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_Status$TMCinfo tMCinfo_Status$TMCinfo = (TMCinfo_Status$TMCinfo)bAPEntity;
        return this.streetName.equalTo(tMCinfo_Status$TMCinfo.streetName) && this.location.equalTo(tMCinfo_Status$TMCinfo.location) && this.infotext.equalTo(tMCinfo_Status$TMCinfo.infotext) && this.length.equalTo(tMCinfo_Status$TMCinfo.length);
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
        this.streetName.serialize(bitStream);
        this.location.serialize(bitStream);
        this.infotext.serialize(bitStream);
        this.length.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

