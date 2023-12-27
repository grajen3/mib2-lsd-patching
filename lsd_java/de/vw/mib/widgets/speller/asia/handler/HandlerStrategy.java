/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

interface HandlerStrategy {
    default public void doGet(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
    }

    default public void doGet(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
    }

    default public void doHandle(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
    }

    default public void doHandleFaulty(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
    }

    default public void setHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
    }
}

