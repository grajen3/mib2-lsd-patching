/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger.start;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;

public interface SpeechMessengerParameters {
    default public int getLoggerClassifier() {
    }

    default public String getLoggerPrefix() {
    }

    default public Logger getLogger() {
    }

    default public AsyncServiceFactory getASLAsyncServiceFactory() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public AbstractClassifiedLogger getAbstractClassifiedLogger() {
    }
}

