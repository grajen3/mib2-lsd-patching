/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.media.ASIMediaBrowserListener;
import de.vw.mib.asi.media.impl.ASIMediaBrowserBaseServiceImpl;

class ASIMediaBrowserBaseServiceImpl$ListenerProxy
implements ASIMediaBrowserListener {
    private final /* synthetic */ ASIMediaBrowserBaseServiceImpl this$0;

    ASIMediaBrowserBaseServiceImpl$ListenerProxy(ASIMediaBrowserBaseServiceImpl aSIMediaBrowserBaseServiceImpl) {
        this.this$0 = aSIMediaBrowserBaseServiceImpl;
    }

    @Override
    public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) {
        try {
            this.this$0.updateActiveSlot(mediaSourceSlot, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) {
        try {
            this.this$0.updateBrowseFolder(mediaEntryArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBrowseMode(int n, boolean bl) {
        try {
            this.this$0.updateBrowseMode(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateDatabaseMode(boolean bl, boolean bl2) {
        try {
            this.this$0.updateDatabaseMode(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateListSize(int n, boolean bl) {
        try {
            this.this$0.updateListSize(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateRawMode(boolean bl, boolean bl2) {
        try {
            this.this$0.updateRawMode(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

