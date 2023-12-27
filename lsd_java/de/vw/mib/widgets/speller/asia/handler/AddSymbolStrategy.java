/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractHandlerStrategy;
import de.vw.mib.widgets.speller.asia.handler.AddSymbolHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

class AddSymbolStrategy
extends AbstractHandlerStrategy {
    public AddSymbolStrategy(AddSymbolHandler addSymbolHandler) {
        super(addSymbolHandler);
    }

    @Override
    public void doGet(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        intObjectMap.put(0, ((AddSymbolHandler)this.handler).getSymbols());
        asiaStateProxy.getState(1024, intObjectMap, this.handler);
    }
}

