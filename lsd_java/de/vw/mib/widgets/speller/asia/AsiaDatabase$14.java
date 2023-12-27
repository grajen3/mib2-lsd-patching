/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$14
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ String val$context;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$14(AsiaDatabase asiaDatabase, String string) {
        this.this$0 = asiaDatabase;
        this.val$context = string;
    }

    @Override
    public void onInitialized() {
        this.this$0.setPredictionContextInternal(this.val$context);
    }

    public String toString() {
        return new StringBuffer().append("setPredictionContext( '").append(this.val$context).append("' )").toString();
    }
}

