/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$1
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ char val$symbol;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$1(AsiaDatabase asiaDatabase, char c2) {
        this.this$0 = asiaDatabase;
        this.val$symbol = c2;
    }

    @Override
    public void onInitialized() {
        this.this$0.addSymbolInternal(this.val$symbol);
    }

    public String toString() {
        return new StringBuffer().append("addSymbol( '").append(this.val$symbol).append("' )").toString();
    }
}

