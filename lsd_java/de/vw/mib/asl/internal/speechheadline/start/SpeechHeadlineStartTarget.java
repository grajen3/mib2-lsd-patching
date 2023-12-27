/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.start;

import de.vw.mib.asl.internal.speechheadline.dialog.handling.HeadlineButtonRequestHandler;
import de.vw.mib.asl.internal.speechheadline.dialog.state.ButtonStateHandler;
import de.vw.mib.asl.internal.speechheadline.dialog.state.IndicatorStateHandler;
import de.vw.mib.asl.internal.speechheadline.start.SpeechHeadlineStartTarget$1;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineLogger;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineServiceManager;
import de.vw.mib.asl.internal.speechheadline.utils.implementation.SpeechHeadlineServiceManagerImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechHeadlineStartTarget
extends AbstractTarget {
    private static final String LOGGER_PREFIX;
    protected SpeechHeadlineServiceManager serviceManager;
    private SpeechHeadlineLogger logger;
    protected BundleContext bundleContext;
    IndicatorStateHandler indicatorStateHandler;
    ButtonStateHandler buttonStateHandler;
    HeadlineButtonRequestHandler buttonRequestHandler;
    private ServiceTrackerCustomizer speechEngineTracker = new SpeechHeadlineStartTarget$1(this);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public SpeechHeadlineStartTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1832314624;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.onPowerOn();
                break;
            }
            case 1078041825: {
                if (this.buttonRequestHandler != null) {
                    this.buttonRequestHandler.performButtonPressed();
                    break;
                }
                this.logger.error("Headline button pressed before connection to speech engine is ready. Headline visible without speech engine!");
                break;
            }
            case 1078041824: {
                if (this.buttonRequestHandler != null) {
                    this.buttonRequestHandler.performIndicatorPressed();
                    break;
                }
                this.logger.error("Speech Indicator pressed before connection to speech engine is ready. Headline visible without speech engine!");
                break;
            }
        }
        if (n != 8 && this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("handled event ").append(n).toString());
        }
    }

    private void onPowerOn() {
        this.serviceManager = new SpeechHeadlineServiceManagerImpl();
        this.logger = this.serviceManager.createSpeechHeadlineLogger("[SpeechHeadlineStartTarget] ");
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handle POWER_ON event");
        }
        this.bundleContext = this.serviceManager.getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = SpeechHeadlineStartTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), this.speechEngineTracker);
        serviceTracker.open();
        this.addObserver(-509853376);
        this.addObserver(-526630592);
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

