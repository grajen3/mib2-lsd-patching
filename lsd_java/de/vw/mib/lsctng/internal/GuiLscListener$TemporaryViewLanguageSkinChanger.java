/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.internal.GuiLscListener;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.skin.ViewLanguageSkinChanger;

class GuiLscListener$TemporaryViewLanguageSkinChanger
implements ViewLanguageSkinChanger {
    int propagatedSkinMode = -1;

    GuiLscListener$TemporaryViewLanguageSkinChanger() {
    }

    @Override
    public void propagateSkinMode(int n) {
        GuiLscListener.LOG.normal(16384).append("ViewLanguageSkinChanger not yet available. Save skin mode: ").append(n).log();
        this.propagatedSkinMode = n;
    }

    @Override
    public void releaseResourcesForSkinChange() {
    }

    @Override
    public void restoreResourcesForSkinChange() {
    }

    void installNewViewLanguageSkinChanger(ViewLanguageSkinChanger viewLanguageSkinChanger) {
        ServiceManager.setViewLanguageSkinChanger(viewLanguageSkinChanger);
        if (this.propagatedSkinMode != -1) {
            viewLanguageSkinChanger.propagateSkinMode(this.propagatedSkinMode);
        }
    }
}

