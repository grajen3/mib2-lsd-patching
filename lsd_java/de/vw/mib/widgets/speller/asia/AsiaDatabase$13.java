/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$13
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ String val$candidate;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$13(AsiaDatabase asiaDatabase, String string) {
        this.this$0 = asiaDatabase;
        this.val$candidate = string;
    }

    @Override
    public void onInitialized() {
        this.this$0.selectCandidateInternal(this.val$candidate);
    }

    public String toString() {
        return new StringBuffer().append("selectCandidate( '").append(this.val$candidate).append("' )").toString();
    }
}

