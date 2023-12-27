/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationTMCInfoElement;
import java.util.NoSuchElementException;

public class TMCInfosASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements NavigationTMCInfoElement {
    public TMCInfosASLDataPoolIterator() {
        super(743);
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
    public long getMessageId() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getLong(0, object);
    }

    @Override
    public int getPriority() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(1, object);
    }

    @Override
    public String getStreetName() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(2, object);
    }

    @Override
    public String getLocation() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(3, object);
    }

    @Override
    public String getText() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(4, object);
    }

    @Override
    public int getLength() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getLengthUnit() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(6, object);
    }
}

