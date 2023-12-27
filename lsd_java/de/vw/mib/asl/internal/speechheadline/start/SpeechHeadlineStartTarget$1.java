/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.start;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateRouter;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataManager;
import de.vw.mib.asl.internal.speechheadline.dialog.handling.HeadlineButtonRequestHandler;
import de.vw.mib.asl.internal.speechheadline.dialog.state.ButtonStateHandler;
import de.vw.mib.asl.internal.speechheadline.dialog.state.IndicatorStateHandler;
import de.vw.mib.asl.internal.speechheadline.start.SpeechHeadlineStartTarget;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechHeadlineStartTarget$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechHeadlineStartTarget this$0;

    SpeechHeadlineStartTarget$1(SpeechHeadlineStartTarget speechHeadlineStartTarget) {
        this.this$0 = speechHeadlineStartTarget;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngineMaster speechEngineMaster = (SpeechEngineMaster)this.this$0.bundleContext.getService(serviceReference);
        this.this$0.indicatorStateHandler = new IndicatorStateHandler(this.this$0.serviceManager);
        IndicatorStateRouter indicatorStateRouter = speechEngineMaster.getIndicatorStateRouter();
        indicatorStateRouter.register(this.this$0.indicatorStateHandler);
        this.this$0.buttonStateHandler = new ButtonStateHandler(this.this$0.serviceManager);
        TeleprompterManager teleprompterManager = speechEngineMaster.getTeleprompterManager();
        teleprompterManager.register(this.this$0.buttonStateHandler);
        TeleprompterDataManager teleprompterDataManager = speechEngineMaster.getTeleprompterDataManager(1);
        teleprompterDataManager.register(this.this$0.buttonStateHandler);
        this.this$0.buttonRequestHandler = new HeadlineButtonRequestHandler(this.this$0.serviceManager, speechEngineMaster.getDialogManager(1), this.this$0.buttonStateHandler);
        return speechEngineMaster;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

