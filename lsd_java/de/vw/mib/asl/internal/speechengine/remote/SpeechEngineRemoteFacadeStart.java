/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.remote;

import de.vw.mib.asl.internal.speechengine.remote.SpeechEngineRemoteFacadeStart$1;
import de.vw.mib.asl.internal.speechengine.remote.SpeechEngineRemoteImpl;
import de.vw.mib.asl.internal.speechengine.remote.start.SpeechEngineRemoteFacadeActivator;
import de.vw.mib.asl.internal.speechengine.remote.start.SpeechEngineRemoteFacadeParameters;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.speech.remote.SpeechEngineRemote;
import org.osgi.framework.BundleContext;

public class SpeechEngineRemoteFacadeStart
implements SpeechEngineRemoteFacadeActivator {
    static /* synthetic */ Class class$de$vw$mib$speech$remote$SpeechEngineRemote;

    @Override
    public void activate(SpeechEngineRemoteFacadeParameters speechEngineRemoteFacadeParameters) {
        SpeechEngineRemoteImpl speechEngineRemoteImpl = new SpeechEngineRemoteImpl(speechEngineRemoteFacadeParameters);
        this.registerOnOsgiInUiThread(speechEngineRemoteImpl, speechEngineRemoteFacadeParameters.getFrameworkEventDispatcher(), speechEngineRemoteFacadeParameters.getBundleContext());
    }

    private void registerOnOsgiInUiThread(SpeechEngineRemote speechEngineRemote, FrameworkEventDispatcher frameworkEventDispatcher, BundleContext bundleContext) {
        frameworkEventDispatcher.invoke(new SpeechEngineRemoteFacadeStart$1(this, bundleContext, speechEngineRemote));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

