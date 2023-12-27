/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioReceptionListElement;
import java.util.NoSuchElementException;

public class ReceptionListASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements RadioReceptionListElement {
    public ReceptionListASLDataPoolIterator() {
        super(1270);
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
    public long getReceptionListElementParentUniqueId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getLong(1, object);
    }

    @Override
    public int getReceptionListElementType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }

    @Override
    public long getReceptionListElementUniqueId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getLong(0, object);
    }

    @Override
    public int getReceptionListElementFrequency() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(9, object);
    }

    @Override
    public String getReceptionListElementDABFrequency() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(10, object);
    }

    @Override
    public String getReceptionListElementShortName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(8, object);
    }

    @Override
    public int getReceptionListElementAttributes() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(3, object);
    }

    @Override
    public int getReceptionListElementPresetId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(4, object);
    }

    @Override
    public int getReceptionListElementFMRegCode() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getReceptionListElementCategory() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(6, object);
    }

    @Override
    public String getReceptionListElementName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(7, object);
    }

    @Override
    public int getReceptionListElementChannel() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(11, object);
    }
}

