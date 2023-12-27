/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.AbstractASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.elements.MediaFileBrowserElement;
import java.util.NoSuchElementException;

public class FileBrowserASLDataPoolIterator
extends AbstractASLDataPoolIterator
implements MediaFileBrowserElement {
    public FileBrowserASLDataPoolIterator() {
        super(3829);
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
    public long getFileEntryId() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getLong(0, object);
    }

    @Override
    public String getFileName() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(1, object);
    }

    @Override
    public String getFileTitle() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(2, object);
    }

    @Override
    public String getFileArtist() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getString(4, object);
    }

    @Override
    public int getFileContentType() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(5, object);
    }

    @Override
    public int getFileBrowserFlags() {
        Object object = this.aslList.getRowItem(this.getCurrentIndex());
        return this.aslList.getListTransformer().getInt(6, object);
    }
}

