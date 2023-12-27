/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator;
import org.dsi.ifc.asiainput.WordDatabase;

public final class AbstractAsiaInputInitializer$AdditionalWordDatabasesHandler
extends AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator {
    private final String[] _wordDatabaseNames;
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    public AbstractAsiaInputInitializer$AdditionalWordDatabasesHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, String[] stringArray) {
        this.this$0 = abstractAsiaInputInitializer;
        super(abstractAsiaInputInitializer, false);
        this._wordDatabaseNames = stringArray;
    }

    @Override
    public void asiaSetAdditionalWordDatabases() {
        this.handleResponse(true);
    }

    @Override
    protected void onConfigure(AsiaInput asiaInput) {
        WordDatabase[] wordDatabaseArray = new WordDatabase[this._wordDatabaseNames.length];
        LogMessage logMessage = this.this$0.isTraceEnabled() ? this.this$0.trace().append("additionalWordDatabases=[") : null;
        for (int i2 = 0; i2 < wordDatabaseArray.length; ++i2) {
            wordDatabaseArray[i2] = new WordDatabase(this._wordDatabaseNames[i2], 0);
            if (logMessage == null) continue;
            logMessage.append("[").append(this._wordDatabaseNames[i2]).append("]");
        }
        if (logMessage != null) {
            logMessage.append("]").log();
        }
        asiaInput.setAdditionalWordDatabases(wordDatabaseArray);
    }

    @Override
    protected void onHandleResponse(boolean bl, long l) {
        if (bl && this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Took ").append(l).append("[ms] to set additionalWordDatabases").log();
        }
    }
}

