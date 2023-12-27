/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.lsctng.internal.AbstractMediator;
import de.vw.mib.lsctng.internal.CheckAllChangesReady;

class AbstractMediator$IgnoringChanger
implements CheckAllChangesReady,
SkinChanger,
LanguageChanger,
SkinmodeChanger {
    AbstractMediator$IgnoringChanger() {
    }

    @Override
    public void setChangeResult(int n, boolean bl, String string) {
        AbstractMediator.LOG.normal(4).append("ignoring change language result: ").append(bl).append(" ").append(string).log();
    }

    @Override
    public void setChangeResult(int n, boolean bl, int n2) {
        AbstractMediator.LOG.normal(4).append("ignoring change skin/skinmode result: ").append(bl).append(" ").append(n2).log();
    }

    @Override
    public void checkAllChangesReady() {
        AbstractMediator.LOG.normal(4).append("ignoring check for all changes ready.").log();
    }
}

