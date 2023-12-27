/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.filter.SpellerFilterListener;
import de.vw.mib.speller.hwr.HWRConfiguration;
import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.speller.hwr.HWREngineListener;
import de.vw.mib.speller.hwr.HWRManager;
import de.vw.mib.speller.internal.HWREngineFilterInit;

class HWREngineProxy
implements HWREngineFilterInit,
HWREngineListener,
SpellerFilterListener {
    private HWREngine engine;
    private HWREngineListener listener;
    private SpellerFilter filter;

    HWREngineProxy() {
    }

    @Override
    public void clear() {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        this.engine.clear();
    }

    @Override
    public HWRConfiguration getConfiguration() {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        return this.engine.getConfiguration();
    }

    @Override
    public boolean isConfigured() {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        return this.engine.isConfigured();
    }

    @Override
    public boolean isReady() {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        return this.engine.isReady();
    }

    @Override
    public void release() {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        this.engine.release();
        this.setFilter(null);
        this.engine = null;
        this.listener = null;
    }

    @Override
    public void sendConfiguration() {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        this.engine.sendConfiguration();
    }

    @Override
    public void setConfiguration(HWRConfiguration hWRConfiguration) {
        if (null == this.engine) {
            throw new IllegalStateException();
        }
        this.engine.setConfiguration(hWRConfiguration);
    }

    @Override
    public void updateEngineReady(boolean bl) {
        if (null != this.listener) {
            this.listener.updateEngineReady(bl);
        }
    }

    @Override
    public void updateRecognizedCharacters(String[] stringArray) {
        if (null != this.filter) {
            this.filter.filterCharacters(stringArray);
        } else if (null != this.listener) {
            this.listener.updateRecognizedCharacters(stringArray);
        }
    }

    @Override
    public void setFilteredCharacters(String[] stringArray) {
        if (null != this.listener) {
            this.listener.updateRecognizedCharacters(stringArray);
        }
    }

    void initHWREngine(HWRManager hWRManager, HWREngineListener hWREngineListener) {
        this.listener = hWREngineListener;
        this.engine = hWRManager.initHWREngine(this);
    }

    @Override
    public void setFilter(SpellerFilter spellerFilter) {
        if (null != this.filter) {
            this.filter.releaseFilter();
        }
        this.filter = spellerFilter;
        if (null != spellerFilter) {
            spellerFilter.initFilter(this);
        }
    }
}

