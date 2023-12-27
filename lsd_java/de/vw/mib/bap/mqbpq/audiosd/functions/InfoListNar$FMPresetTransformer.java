/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListNar;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;

final class InfoListNar$FMPresetTransformer
extends StringIterator {
    private StringIterator presetNames;
    private IntegerIterator presetFrequencies;
    private IntegerIterator channels;
    private final /* synthetic */ InfoListNar this$0;

    public InfoListNar$FMPresetTransformer(InfoListNar infoListNar, StringIterator stringIterator, IntegerIterator integerIterator, IntegerIterator integerIterator2) {
        this.this$0 = infoListNar;
        this.presetNames = stringIterator;
        this.presetFrequencies = integerIterator;
        this.channels = integerIterator2;
    }

    @Override
    public boolean hasNext() {
        return this.presetFrequencies.hasNext() && this.presetNames.hasNext();
    }

    @Override
    public String nextString() {
        return this.this$0.formatFrequencyOrReturnPresetName(this.presetNames.nextString(), this.presetFrequencies.nextInteger(), 0, this.channels.nextInteger());
    }
}

