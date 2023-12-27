/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

class AsiaDatabase$11
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$11(AsiaDatabase asiaDatabase) {
        this.this$0 = asiaDatabase;
    }

    @Override
    public void onInitialized() {
        this.this$0.removeSymbolInternal();
    }

    public String toString() {
        return "removeSymbol()";
    }
}

