/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;

public interface AslLscBullhorn {
    default public void onNewLanguage(LanguageChanger languageChanger, int n, int n2, String string) {
    }

    default public void onNewSkin(SkinChanger skinChanger, int n, int n2, int n3) {
    }

    default public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2, int n3) {
    }

    default public void startOfLsc() {
    }

    default public void guiAvailableForViews() {
    }

    default public void speechAvailable() {
    }

    default public void endOfLsc(IntObjectMap intObjectMap) {
    }
}

