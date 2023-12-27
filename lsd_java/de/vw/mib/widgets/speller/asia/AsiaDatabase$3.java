/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;
import org.dsi.ifc.asiainput.UserDefinedEntry;

class AsiaDatabase$3
implements AsiaInputInitializer$Callback {
    private final /* synthetic */ UserDefinedEntry val$entry;
    private final /* synthetic */ AsiaDatabase this$0;

    AsiaDatabase$3(AsiaDatabase asiaDatabase, UserDefinedEntry userDefinedEntry) {
        this.this$0 = asiaDatabase;
        this.val$entry = userDefinedEntry;
    }

    @Override
    public void onInitialized() {
        this.this$0.addUserDefinedEntryInternal(this.val$entry);
    }

    public String toString() {
        return new StringBuffer().append("addUserDefinedEntry( '").append(this.val$entry).append("' )").toString();
    }
}

