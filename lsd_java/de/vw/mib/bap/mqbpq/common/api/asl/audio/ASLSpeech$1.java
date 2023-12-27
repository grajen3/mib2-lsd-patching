/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.asl.audio;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSpeech;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

final class ASLSpeech$1
implements ServiceTrackerCustomizer {
    ASLSpeech$1() {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ASLSpeech.speechEngineMaster = (SpeechEngineMaster)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().getService(serviceReference);
        return ASLSpeech.speechEngineMaster;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

