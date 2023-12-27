/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.ServiceManager;

class AslLscListenerMediator
extends AbstractMediator {
    private final int aslTargetId;

    AslLscListenerMediator(int n, int n2, String string, int n3, int n4) {
        super(n, string, n3, n4);
        this.aslTargetId = n2;
    }

    @Override
    void onNewLanguageInternal(LanguageChanger languageChanger, int n, String string) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewLanguageInternal()").log();
        }
        ServiceManager.lscBullhorn.onNewLanguage(languageChanger, n, this.getAslTargetId(), string);
    }

    @Override
    void onNewSkinInternal(SkinChanger skinChanger, int n, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewSkinInternal()").log();
        }
        ServiceManager.lscBullhorn.onNewSkin(skinChanger, n, this.getAslTargetId(), n2);
    }

    @Override
    void onNewSkinmodeInternal(SkinmodeChanger skinmodeChanger, int n, int n2) {
        if (LOG.isTraceEnabled(4)) {
            LOG.trace(4).append("call: ").append(super.getClass().getName()).append(".onNewSkinmodeInternal()").log();
        }
        ServiceManager.lscBullhorn.onNewSkinmode(skinmodeChanger, n, this.getAslTargetId(), n2);
    }

    int getAslTargetId() {
        return this.aslTargetId;
    }

    @Override
    public boolean isAslLscListenerMediator(int n) {
        return n == this.aslTargetId;
    }

    @Override
    public boolean isAslLscListenerMediator() {
        return true;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("ASL-Listener_").append(Integer.toHexString(this.getAslTargetId())).append("_").append(super.toString()).toString();
    }
}

