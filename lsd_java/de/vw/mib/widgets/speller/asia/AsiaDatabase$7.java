/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$7
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ String val$phrase;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$7(AsiaDatabase asiaDatabase, String string) {
        this.this$0 = asiaDatabase;
        this.val$phrase = string;
    }

    @Override
    public void onInitialized() {
        this.this$0.getSegmentationInternal(this.val$phrase);
    }

    public String toString() {
        return new StringBuffer().append("getSegmentation( '").append(this.val$phrase).append("')").toString();
    }
}

