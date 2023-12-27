/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio.start;

import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderCallback;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public interface AudioProviderParameters {
    default public AudioProviderCallback getSpeechEngineStarter() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingTarget() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public EventFactory getEventFactory() {
    }

    default public String getTaskId() {
    }

    default public int getTargetId() {
    }

    default public Logger getLogger() {
    }

    default public int getSubClassifier() {
    }

    default public TimerManager getTimerManager() {
    }
}

