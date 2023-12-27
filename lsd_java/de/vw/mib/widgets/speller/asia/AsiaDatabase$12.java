/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$12
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$12(AsiaDatabase asiaDatabase, int n) {
        this.this$0 = asiaDatabase;
        this.val$index = n;
    }

    @Override
    public void onInitialized() {
        this.this$0.selectCandidateInternal(this.val$index);
    }

    public String toString() {
        return new StringBuffer().append("selectCandidate( ").append(this.val$index).append(" )").toString();
    }
}

