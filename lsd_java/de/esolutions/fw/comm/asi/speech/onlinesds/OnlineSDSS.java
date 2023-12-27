/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSReply;

public interface OnlineSDSS {
    default public void onlineCapabilities(LanguageInfo[] languageInfoArray, OnlineSDSReply onlineSDSReply) {
    }

    default public void responseSetLanguage(int n, OnlineSDSReply onlineSDSReply) {
    }

    default public void sendOnlineResult(int n, int n2, String string, OnlineSDSReply onlineSDSReply) {
    }

    default public void responseCancel(int n, int n2, OnlineSDSReply onlineSDSReply) {
    }
}

