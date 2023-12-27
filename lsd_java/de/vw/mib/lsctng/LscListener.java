/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;

public interface LscListener {
    default public void onNewLanguage(LanguageChanger languageChanger, int n, String string) {
    }

    default public void onNewSkin(SkinChanger skinChanger, int n, int n2) {
    }

    default public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2) {
    }
}

