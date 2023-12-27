/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.elements.MediaAvailableAudioSourcesElement;
import java.util.NoSuchElementException;

public class AvailableAudioSourcesASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements MediaAvailableAudioSourcesElement {
    public AvailableAudioSourcesASLDataPoolIterator() {
        super(56);
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
    public int getAudioSourceId() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(0, object);
    }

    @Override
    public boolean isAudioSourceActive() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getBoolean(1, object);
    }

    @Override
    public boolean isAudioSourceEnabled() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getBoolean(2, object);
    }

    @Override
    public String getAudioSourceName() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(3, object);
    }

    @Override
    public int getAudioSourceMediaType() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(4, object);
    }

    @Override
    public int getAudioSourceMediaFlag() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public boolean isAudioSourceBrowsable() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getBoolean(9, object);
    }
}

