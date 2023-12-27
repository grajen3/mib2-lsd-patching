/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationFavoriteDestinationElement;
import java.util.NoSuchElementException;

public class FavoriteDestinationsASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements NavigationFavoriteDestinationElement {
    public FavoriteDestinationsASLDataPoolIterator() {
        super(740);
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
    public long getContactEntryId() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getLong(0, object);
    }

    @Override
    public int getPoiType() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(3, object);
    }

    @Override
    public String getDescription() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(1, object);
    }

    @Override
    public int getEntryPosition() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(2, object);
    }
}

