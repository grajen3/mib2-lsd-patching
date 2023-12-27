/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$6
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ int val$count;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$6(AsiaDatabase asiaDatabase, int n) {
        this.this$0 = asiaDatabase;
        this.val$count = n;
    }

    @Override
    public void onInitialized() {
        this.this$0.getCandidatesInternal(this.val$count);
    }

    public String toString() {
        return new StringBuffer().append("getCandidates( ").append(this.val$count).append(" )").toString();
    }
}

