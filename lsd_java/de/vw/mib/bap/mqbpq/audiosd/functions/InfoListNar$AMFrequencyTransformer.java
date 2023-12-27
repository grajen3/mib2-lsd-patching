/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListNar;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;

final class InfoListNar$AMFrequencyTransformer
extends StringIterator {
    private IntegerIterator frequencies;
    private IntegerIterator channels;
    private final /* synthetic */ InfoListNar this$0;

    public InfoListNar$AMFrequencyTransformer(InfoListNar infoListNar, IntegerIterator integerIterator, IntegerIterator integerIterator2) {
        this.this$0 = infoListNar;
        this.frequencies = integerIterator;
        this.channels = integerIterator2;
    }

    @Override
    public boolean hasNext() {
        return this.frequencies.hasNext();
    }

    @Override
    public String nextString() {
        return this.this$0.formatFrequencyOrReturnPresetName("", this.frequencies.nextInteger(), 1, this.channels.nextInteger());
    }
}

