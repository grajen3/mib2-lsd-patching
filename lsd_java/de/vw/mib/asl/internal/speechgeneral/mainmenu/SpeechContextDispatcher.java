/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.mainmenu;

import de.vw.mib.asl.api.speechengine.contexts.SpeechContext;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventDispatcher;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.genericevents.EventGeneric;
import java.util.HashMap;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechContextDispatcher
implements ServiceTrackerCustomizer,
EventHandler {
    private final HashMap speechContextMap = new HashMap();
    private final BundleContext bundleContext;
    private final EventDispatcher eventDispatcher;
    private final SpeechGeneralLogger logger;

    public SpeechContextDispatcher(BundleContext bundleContext, EventDispatcher eventDispatcher) {
        this.bundleContext = bundleContext;
        this.eventDispatcher = eventDispatcher;
        this.eventDispatcher.registerHandler(this);
        this.logger = new SpeechGeneralLogger("[MainMenuContextBubbleController] ", 4096);
    }

    @Override
    public int[] getHandleEvents() {
        return new int[]{399781952, 332673088, 349450304, 366227520, 383004736};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        SpeechContext speechContext = this.getSpeechContext(eventGeneric.getReceiverEventId());
        if (speechContext != null) {
            speechContext.enterMainView();
        }
    }

    private SpeechContext getSpeechContext(int n) {
        Integer n2;
        switch (n) {
            case 1076941847: {
                n2 = new Integer(1);
                break;
            }
            case 1076941843: {
                n2 = new Integer(2);
                break;
            }
            case 1076941844: {
                n2 = new Integer(4);
                break;
            }
            case 1076941845: {
                n2 = new Integer(3);
                break;
            }
            case 1076941846: {
                n2 = new Integer(5);
                break;
            }
            default: {
                this.logger.warn().append("Unknown SpeechClientId - SpeechContext can not be triggered. ").log();
                n2 = new Integer(-1);
            }
        }
        return (SpeechContext)this.speechContextMap.get(n2);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Integer n = new Integer(((SpeechContext)object).getSpeechContextId());
        if (this.speechContextMap.containsKey(n)) {
            this.speechContextMap.remove(n);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechContext speechContext = (SpeechContext)this.bundleContext.getService(serviceReference);
        this.speechContextMap.put(new Integer(speechContext.getSpeechContextId()), speechContext);
        return speechContext;
    }
}

