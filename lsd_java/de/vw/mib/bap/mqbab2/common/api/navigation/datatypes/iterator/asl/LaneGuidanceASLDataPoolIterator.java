/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationLaneGuidanceElement;
import java.util.NoSuchElementException;

public class LaneGuidanceASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements NavigationLaneGuidanceElement {
    public LaneGuidanceASLDataPoolIterator() {
        super(742);
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
    public int getDirection() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public String getSideStreets() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getString(1, object);
    }

    @Override
    public int getLaneType() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getMarkingLeft() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(3, object);
    }

    @Override
    public int getMarkingRight() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(4, object);
    }

    @Override
    public int getLaneDescription() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getLaneGuidanceInfo() {
        Object object = this.aslList.getRowItem(this.currentIndex);
        return this.aslList.getListTransformer().getInt(6, object);
    }
}

