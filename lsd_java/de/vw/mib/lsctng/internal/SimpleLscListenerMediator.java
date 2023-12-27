/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.LscListener;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.lsctng.internal.AbstractMediator;

class SimpleLscListenerMediator
extends AbstractMediator {
    private final LscListener listener;

    SimpleLscListenerMediator(int n, LscListener lscListener, String string, int n2, int n3) {
        super(n, string, n2, n3);
        this.listener = lscListener;
    }

    @Override
    void onNewLanguageInternal(LanguageChanger languageChanger, int n, String string) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewLanguageInternal()").log();
        }
        this.listener.onNewLanguage(languageChanger, n, string);
    }

    @Override
    void onNewSkinInternal(SkinChanger skinChanger, int n, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewSkinInternal()").log();
        }
        this.listener.onNewSkin(skinChanger, n, n2);
    }

    @Override
    void onNewSkinmodeInternal(SkinmodeChanger skinmodeChanger, int n, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewSkinmodeInternal()").log();
        }
        this.listener.onNewSkinmode(skinmodeChanger, n, n2);
    }

    @Override
    public boolean isSimpleLscListenerMediator(LscListener lscListener) {
        return lscListener == this.listener;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Simple-Listener_").append(super.toString()).toString();
    }
}

