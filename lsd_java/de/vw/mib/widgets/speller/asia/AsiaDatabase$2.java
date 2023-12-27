/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$2
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ String val$symbols;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$2(AsiaDatabase asiaDatabase, String string) {
        this.this$0 = asiaDatabase;
        this.val$symbols = string;
    }

    @Override
    public void onInitialized() {
        this.this$0.addSymbolsInternal(this.val$symbols);
    }

    public String toString() {
        return new StringBuffer().append("addSymbols( '").append(this.val$symbols).append("' )").toString();
    }
}

