/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.speech;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechASLDataAdapter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechASLDataAdapter$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechASLDataAdapter this$0;

    SpeechASLDataAdapter$1(SpeechASLDataAdapter speechASLDataAdapter) {
        this.this$0 = speechASLDataAdapter;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechASLDataAdapter.access$002(this.this$0, (SpeechEngineMaster)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().getService(serviceReference));
        return SpeechASLDataAdapter.access$000(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

