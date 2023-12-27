/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.handler.HandlerStrategy;

abstract class AbstractHandlerStrategy
implements HandlerStrategy {
    protected AbstractAsiaStateHandler handler;

    protected AbstractHandlerStrategy() {
        this(null);
    }

    protected AbstractHandlerStrategy(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.handler = abstractAsiaStateHandler;
    }

    @Override
    public void doGet(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
    }

    @Override
    public void doGet(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
    }

    @Override
    public void doHandle(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
    }

    @Override
    public void doHandleFaulty(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
    }

    @Override
    public final void setHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.handler = abstractAsiaStateHandler;
    }
}

