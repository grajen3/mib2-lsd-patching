/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

import de.vw.mib.asl.internal.speechengine.messenger.BackstackStateRouterImpl;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemRouterImpl;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventRouterImpl;
import de.vw.mib.asl.internal.speechengine.messenger.SpeechMessengerStartup$1;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerActivator;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerCallback;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerParameters;

public class SpeechMessengerStartup
implements SpeechMessengerActivator {
    @Override
    public void activate(SpeechMessengerCallback speechMessengerCallback, SpeechMessengerParameters speechMessengerParameters) {
        DialogSystemRouterImpl dialogSystemRouterImpl = new DialogSystemRouterImpl(speechMessengerParameters);
        HmiEventRouterImpl hmiEventRouterImpl = new HmiEventRouterImpl(speechMessengerParameters.getSystemEventDispatcher());
        BackstackStateRouterImpl backstackStateRouterImpl = new BackstackStateRouterImpl();
        speechMessengerCallback.onRouterReady(new SpeechMessengerStartup$1(this, dialogSystemRouterImpl, hmiEventRouterImpl, backstackStateRouterImpl));
    }
}

