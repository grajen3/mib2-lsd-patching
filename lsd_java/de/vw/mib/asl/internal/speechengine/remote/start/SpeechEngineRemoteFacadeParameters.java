/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.remote.start;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;

public interface SpeechEngineRemoteFacadeParameters {
    default public Logger getLogger() {
    }

    default public FrameworkEventDispatcher getFrameworkEventDispatcher() {
    }

    default public BundleContext getBundleContext() {
    }

    default public SpeechEngineMaster getSpeechEngineMaster() {
    }

    default public Framework4U getFramework4u() {
    }

    default public AsyncServiceFactory getAsyncServiceFactoryASL() {
    }
}

