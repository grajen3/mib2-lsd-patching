/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.DictationValueSentence;

public interface DSIOnlineDictationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void dictationResult(int n) {
    }

    default public void finishDictationResponse(int n) {
    }

    default public void dictationValueList(DictationValueSentence dictationValueSentence) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

