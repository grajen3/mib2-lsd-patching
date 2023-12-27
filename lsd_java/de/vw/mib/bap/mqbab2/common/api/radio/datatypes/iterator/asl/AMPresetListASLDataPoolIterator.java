/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioAMPresetListElement;
import java.util.NoSuchElementException;

public class AMPresetListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements RadioAMPresetListElement {
    public AMPresetListASLDataPoolIterator() {
        super(1451);
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
    public boolean isAMPresetElementAssigned() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getBoolean(6, object);
    }

    @Override
    public int getAMPresetElementFrequence() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public int getAMPresetElementHDStationNumber() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }
}

