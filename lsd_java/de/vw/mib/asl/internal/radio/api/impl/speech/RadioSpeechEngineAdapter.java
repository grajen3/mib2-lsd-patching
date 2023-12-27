/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.api.impl.speech.RadioSpeechDialogStateConsumer;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class RadioSpeechEngineAdapter
implements ServiceTrackerCustomizer {
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public RadioSpeechEngineAdapter() {
        ServiceTracker serviceTracker = new ServiceTracker(ServiceManager.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = RadioSpeechEngineAdapter.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngine speechEngine = (SpeechEngine)ServiceManager.bundleContext.getService(serviceReference);
        speechEngine.getDialogStateRouter().register(new RadioSpeechDialogStateConsumer());
        return speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
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

