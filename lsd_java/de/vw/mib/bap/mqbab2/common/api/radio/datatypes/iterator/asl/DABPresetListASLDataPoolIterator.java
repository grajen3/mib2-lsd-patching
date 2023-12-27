/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioDABPresetListElement;
import java.util.NoSuchElementException;

public class DABPresetListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements RadioDABPresetListElement {
    public DABPresetListASLDataPoolIterator() {
        super(1458);
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
    public boolean isDABPresetElementAssigned() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getBoolean(1, object);
    }

    @Override
    public String getDABPresetElementName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(5, object);
    }

    @Override
    public int getDABPresetElementAttributes() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }
}

