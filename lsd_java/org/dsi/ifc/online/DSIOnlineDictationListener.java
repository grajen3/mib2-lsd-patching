/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DictationValueSentence;

public interface DSIOnlineDictationListener
extends DSIListener {
    default public void dictationResult(int n) {
    }

    default public void finishDictationResponse(int n) {
    }

    default public void dictationValueList(DictationValueSentence dictationValueSentence) {
    }
}

