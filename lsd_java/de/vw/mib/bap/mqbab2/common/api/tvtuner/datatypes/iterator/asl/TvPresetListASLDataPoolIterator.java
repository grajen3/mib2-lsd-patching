/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.tvtuner.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.datatypes.iterator.elements.TvTunerPresetListElement;
import java.util.NoSuchElementException;

public class TvPresetListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements TvTunerPresetListElement {
    public TvPresetListASLDataPoolIterator() {
        super(2710);
    }

    @Override
    public Object next() {
        if (this.currentIndex >= this.size || this.size == 0) {
            throw new NoSuchElementException();
        }
        ++this.currentIndex;
        return this;
    }

    @Override
    public String getTvPresetElementName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(1, object);
    }
}

