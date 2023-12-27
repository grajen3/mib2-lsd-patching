/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool.internal;

import de.vw.mib.list.ListItemControlListener;
import generated.de.vw.mib.global.datapool.internal.DataPoolUpdate;

class DataPoolUpdate$AslListUpdate
implements ListItemControlListener {
    private final int aslListId;
    private final /* synthetic */ DataPoolUpdate this$0;

    public DataPoolUpdate$AslListUpdate(DataPoolUpdate dataPoolUpdate, int n) {
        this.this$0 = dataPoolUpdate;
        this.aslListId = n;
    }

    @Override
    public void activatedIndexChanged(int n) {
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.this$0.aslListChanged(this.aslListId);
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.this$0.aslListChanged(this.aslListId);
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.this$0.aslListChanged(this.aslListId);
    }

    @Override
    public void listChanged(int n) {
        this.this$0.aslListChanged(this.aslListId);
    }

    @Override
    public void listContentChanged() {
        this.this$0.aslListChanged(this.aslListId);
    }

    @Override
    public void stringIndexChanged() {
        this.this$0.aslListChanged(this.aslListId);
    }
}

