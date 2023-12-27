/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager.internal;

import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler;

public class AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener
implements ListItemControlListener {
    private int publicId;
    private final /* synthetic */ AbstractSdFeatureCollectionHandler this$0;

    public AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(AbstractSdFeatureCollectionHandler abstractSdFeatureCollectionHandler, int n) {
        this.this$0 = abstractSdFeatureCollectionHandler;
        this.publicId = n;
    }

    @Override
    public void activatedIndexChanged(int n) {
        this.this$0.onListChanged(this.publicId);
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.this$0.onListChanged(this.publicId);
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.this$0.onListChanged(this.publicId);
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.this$0.onListChanged(this.publicId);
    }

    @Override
    public void listChanged(int n) {
        this.this$0.onListChanged(this.publicId);
    }

    @Override
    public void listContentChanged() {
        this.this$0.onListChanged(this.publicId);
    }

    @Override
    public void stringIndexChanged() {
        this.this$0.onListChanged(this.publicId);
    }
}

