/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class SyncPhrasesHandler
extends AbstractAsiaStateHandler {
    private int cursorPosition = -1;
    private String phrases = null;

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        if (this.phrases != null) {
            intObjectMap.put(0, this.phrases);
            if (this.cursorPosition >= 0) {
                intObjectMap.put(1, new Integer(this.cursorPosition));
            }
            asiaStateProxy.getState(4096, intObjectMap, this);
        }
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = n;
    }

    public void setPhrases(String string) {
        this.phrases = string;
    }

    @Override
    protected void onReset() {
        this.setCursorPosition(-1);
        this.setPhrases(null);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        return stringBuilder.append("[phrases='").append(this.phrases).append("', cursorPosition=").append(this.cursorPosition).append("]").toString();
    }
}

