/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class SwitchAlphabetHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private int alphabetIndex;
    static /* synthetic */ Class class$java$lang$Integer;

    public SwitchAlphabetHandler() {
    }

    public SwitchAlphabetHandler(State state) {
        super(state);
    }

    public void setAlphabetIndex(int n) {
        this.alphabetIndex = n;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        intObjectMap.put(0, new Integer(this.alphabetIndex));
        asiaStateProxy.getState(64, intObjectMap, this);
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setAlphabetIndex(-1);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        int n;
        Object object = intObjectMap.get(0);
        if (object != null && object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = SwitchAlphabetHandler.class$("java.lang.Integer")) : class$java$lang$Integer) && (n = ((Integer)object).intValue()) > -1) {
            this.getState().getWidget().switchAlphabet(n);
            this.fireIntegerEvent("alphabetIndexChanged", n);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

