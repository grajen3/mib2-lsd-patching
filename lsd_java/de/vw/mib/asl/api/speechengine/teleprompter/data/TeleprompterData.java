/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.teleprompter.data;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterTextEntry;
import java.util.List;

public interface TeleprompterData {
    default public int getTeleprompterType() {
    }

    default public List getCommandExamples() {
    }

    default public TeleprompterTextEntry getHeadlineTitle() {
    }
}

