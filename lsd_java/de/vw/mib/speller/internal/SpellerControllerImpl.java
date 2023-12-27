/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.speller.SpellerEngine;
import de.vw.mib.speller.SpellerEngineListener;
import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.filter.SpellerFilterListener;
import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.speller.hwr.HWREngineListener;
import de.vw.mib.speller.hwr.HWRManager;
import de.vw.mib.speller.internal.HWREngineFilterInit;
import de.vw.mib.speller.internal.HWREngineProxy;
import de.vw.mib.speller.internal.Log;
import de.vw.mib.speller.internal.ServiceManager;
import de.vw.mib.speller.internal.SpellerEngineImpl;
import de.vw.mib.speller.internal.SpellerFilterRegistry;

class SpellerControllerImpl
implements SpellerController {
    private final SpellerFilterRegistry registry;

    SpellerControllerImpl(SpellerFilterRegistry spellerFilterRegistry) {
        this.registry = spellerFilterRegistry;
    }

    @Override
    public HWREngine initHWREngine(int n, HWREngineListener hWREngineListener) {
        HWREngineFilterInit hWREngineFilterInit;
        HWRManager hWRManager;
        LogMessage logMessage = Log.trace();
        if (null != logMessage) {
            logMessage.append("initHWREngine, filterId=").append(n).log();
        }
        if (null != (hWRManager = SpellerControllerImpl.getHWRManager())) {
            SpellerFilter spellerFilter = this.registry.getSpellerFilter(n);
            HWREngineProxy hWREngineProxy = new HWREngineProxy();
            hWREngineFilterInit = (HWREngineFilterInit)ServiceManager.asyncServiceFactoryHSM.create(hWREngineProxy);
            if (null != spellerFilter) {
                hWREngineFilterInit.setFilter(spellerFilter);
            }
            hWREngineListener = (HWREngineListener)ServiceManager.asyncServiceFactoryMain.create(hWREngineListener);
            hWREngineProxy.initHWREngine(hWRManager, hWREngineListener);
        } else {
            hWREngineFilterInit = null;
            logMessage = Log.error();
            if (null != logMessage) {
                logMessage.append("No HWRManager registered.").log();
            }
        }
        return hWREngineFilterInit;
    }

    @Override
    public SpellerFilter initSpellerFilter(int n, SpellerFilterListener spellerFilterListener) {
        SpellerFilter spellerFilter;
        LogMessage logMessage = Log.trace();
        if (null != logMessage) {
            logMessage.append("initSpellerFilter, filterId=").append(n).log();
        }
        if (null != (spellerFilter = this.registry.getSpellerFilter(n))) {
            spellerFilterListener = (SpellerFilterListener)ServiceManager.asyncServiceFactoryMain.create(spellerFilterListener);
            spellerFilter = (SpellerFilter)ServiceManager.asyncServiceFactoryHSM.create(spellerFilter);
            spellerFilter.initFilter(spellerFilterListener);
        }
        return spellerFilter;
    }

    @Override
    public SpellerEngine initSpellerEngine(int n, SpellerEngineListener spellerEngineListener) {
        LogMessage logMessage = Log.trace();
        if (null != logMessage) {
            logMessage.append("initSpellerEngine, spellerId=").append(n).log();
        }
        SpellerEngineImpl spellerEngineImpl = new SpellerEngineImpl(9, spellerEngineListener);
        return spellerEngineImpl;
    }

    private static HWRManager getHWRManager() {
        return ServiceManager.hwrManager;
    }
}

