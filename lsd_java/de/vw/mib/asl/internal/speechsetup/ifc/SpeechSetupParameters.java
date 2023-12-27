/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup.ifc;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.genericevents.GenericEvents;

public interface SpeechSetupParameters {
    default public GenericEvents getGenericEvents() {
    }

    default public AbstractClassifiedLogger getLogger() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }

    default public SpeechEngine getSpeechEngine() {
    }

    default public String getTaskId() {
    }
}

