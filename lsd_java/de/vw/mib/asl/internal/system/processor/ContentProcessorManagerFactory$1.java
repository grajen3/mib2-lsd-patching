/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.internal.system.processor.ContentProcessorManagerFactory;
import de.vw.mib.asl.internal.system.processor.SpeechContentProcessor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class ContentProcessorManagerFactory$1
extends ServiceTracker {
    private final /* synthetic */ SpeechContentProcessor val$internalSpeechContentProcessor;
    private final /* synthetic */ ContentProcessorManagerFactory this$0;

    ContentProcessorManagerFactory$1(ContentProcessorManagerFactory contentProcessorManagerFactory, BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, SpeechContentProcessor speechContentProcessor) {
        this.this$0 = contentProcessorManagerFactory;
        this.val$internalSpeechContentProcessor = speechContentProcessor;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngine speechEngine = (SpeechEngine)super.addingService(serviceReference);
        this.val$internalSpeechContentProcessor.installDialogStateRouter(speechEngine.getDialogStateRouter());
        return speechEngine;
    }
}

