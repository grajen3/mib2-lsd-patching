/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioFMPresetListElement;
import java.util.NoSuchElementException;

public class FMPresetListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements RadioFMPresetListElement {
    public FMPresetListASLDataPoolIterator() {
        super(1461);
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
    public boolean isFMPresetElementAssigned() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getBoolean(4, object);
    }

    @Override
    public String getFMPresetElementName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(8, object);
    }

    @Override
    public int getFMPresetElementFrequencies() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(1, object);
    }

    @Override
    public int getFMPresetElementAttributes() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getFMPresetElementHDStationNumber() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(3, object);
    }
}

