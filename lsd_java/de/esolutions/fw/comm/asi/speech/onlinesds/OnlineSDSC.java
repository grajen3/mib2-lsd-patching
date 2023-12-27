/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;

public interface OnlineSDSC {
    default public void onlineCapabilities(LanguageInfo[] languageInfoArray) {
    }

    default public void responseSetLanguage(int n) {
    }

    default public void sendOnlineResult(int n, int n2, String string) {
    }

    default public void responseCancel(int n, int n2) {
    }
}

