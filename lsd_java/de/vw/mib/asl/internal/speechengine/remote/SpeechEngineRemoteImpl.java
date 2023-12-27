/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.remote;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.internal.speechengine.remote.DialogManagerRemoteImpl;
import de.vw.mib.asl.internal.speechengine.remote.start.SpeechEngineRemoteFacadeParameters;
import de.vw.mib.speech.remote.SpeechEngineRemote;
import de.vw.mib.speech.remote.dialogmanager.DialogManagerRemote;
import de.vw.mib.threads.AsyncServiceFactory;

public class SpeechEngineRemoteImpl
implements SpeechEngineRemote {
    private final DialogManagerRemote dialogManagerRemoteAsync;
    static /* synthetic */ Class class$de$vw$mib$speech$remote$dialogmanager$DialogManagerRemote;

    SpeechEngineRemoteImpl(SpeechEngineRemoteFacadeParameters speechEngineRemoteFacadeParameters) {
        AsyncServiceFactory asyncServiceFactory = speechEngineRemoteFacadeParameters.getAsyncServiceFactoryASL();
        SpeechEngineMaster speechEngineMaster = speechEngineRemoteFacadeParameters.getSpeechEngineMaster();
        this.dialogManagerRemoteAsync = (DialogManagerRemote)asyncServiceFactory.create(new DialogManagerRemoteImpl(speechEngineMaster), new Class[]{class$de$vw$mib$speech$remote$dialogmanager$DialogManagerRemote == null ? (class$de$vw$mib$speech$remote$dialogmanager$DialogManagerRemote = SpeechEngineRemoteImpl.class$("de.vw.mib.speech.remote.dialogmanager.DialogManagerRemote")) : class$de$vw$mib$speech$remote$dialogmanager$DialogManagerRemote});
    }

    @Override
    public DialogManagerRemote getDialogManagerRemote() {
        return this.dialogManagerRemoteAsync;
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

