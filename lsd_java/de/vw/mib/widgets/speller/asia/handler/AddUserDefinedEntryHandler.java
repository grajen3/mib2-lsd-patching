/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractDistinguishableStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import org.dsi.ifc.asiainput.UserDefinedEntry;

public final class AddUserDefinedEntryHandler
extends AbstractDistinguishableStateHandler {
    private String phrase = "";

    public AddUserDefinedEntryHandler(int n) {
        super(n);
    }

    public void setPhrase(String string) {
        this.phrase = string;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        if (this.isCaseToHandle(0) && this.phrase != null && this.phrase.length() > 0) {
            intObjectMap.put(0, new UserDefinedEntry(this.phrase, ""));
            asiaStateProxy.getState(128, intObjectMap, this);
        } else if (this.isCaseToHandle(1)) {
            asiaStateProxy.getState(128, this);
        } else {
            this.doGetNextState();
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setPhrase("");
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        return stringBuilder.append("[phrase='").append(this.phrase).append("']").toString();
    }
}

