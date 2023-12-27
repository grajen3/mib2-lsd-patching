/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.app.desktop.ContentManager;
import de.vw.mib.asl.api.system.contentprocessor.AbstractContentProcessor;
import de.vw.mib.asl.api.system.contentprocessor.ContentProcessorManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.processor.ContentProcessorManagerImpl$1;
import de.vw.mib.asl.internal.system.processor.DelegatingContentProcessor;
import de.vw.mib.asl.internal.system.processor.ThreadSwitchingContentProcessor;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContentProcessorManagerImpl
implements ContentProcessorManager {
    private final DelegatingContentProcessor delegatingContentProcessor = new DelegatingContentProcessor();
    private final List contentProcessorsWithoutContentManager = new ArrayList();
    private ContentManager contentManager;
    static /* synthetic */ Class class$de$vw$mib$app$desktop$ContentProcessor;
    static /* synthetic */ Class class$de$vw$mib$app$desktop$ContentManager;

    public ContentProcessorManagerImpl(SystemServices systemServices) {
        this.registerContentProcessorToOsgi(systemServices);
        this.trackContentManager(systemServices);
    }

    @Override
    public void registerContentProcessor(AbstractContentProcessor abstractContentProcessor) {
        this.verifyContentProcessor(abstractContentProcessor);
        this.delegatingContentProcessor.addDelegate(abstractContentProcessor.getScreenArea(), abstractContentProcessor);
        this.installContentManager(abstractContentProcessor);
    }

    void onContentManagerAdded(ContentManager contentManager) {
        this.contentManager = contentManager;
        Iterator iterator = this.contentProcessorsWithoutContentManager.iterator();
        while (iterator.hasNext()) {
            AbstractContentProcessor abstractContentProcessor = (AbstractContentProcessor)iterator.next();
            abstractContentProcessor.installContentManager(contentManager);
        }
        this.contentProcessorsWithoutContentManager.clear();
    }

    private void verifyContentProcessor(AbstractContentProcessor abstractContentProcessor) {
        if (abstractContentProcessor == null) {
            throw new IllegalArgumentException("The given content processor must not be null");
        }
    }

    private void installContentManager(AbstractContentProcessor abstractContentProcessor) {
        if (this.contentManager == null) {
            this.contentProcessorsWithoutContentManager.add(abstractContentProcessor);
        } else {
            abstractContentProcessor.installContentManager(this.contentManager);
        }
    }

    private void registerContentProcessorToOsgi(SystemServices systemServices) {
        ThreadSwitchingTarget threadSwitchingTarget = systemServices.getThreadSwitcher();
        ThreadSwitchingContentProcessor threadSwitchingContentProcessor = new ThreadSwitchingContentProcessor(threadSwitchingTarget, this.delegatingContentProcessor);
        systemServices.getBundleContext().registerService((class$de$vw$mib$app$desktop$ContentProcessor == null ? (class$de$vw$mib$app$desktop$ContentProcessor = ContentProcessorManagerImpl.class$("de.vw.mib.app.desktop.ContentProcessor")) : class$de$vw$mib$app$desktop$ContentProcessor).getName(), (Object)threadSwitchingContentProcessor, null);
    }

    private void trackContentManager(SystemServices systemServices) {
        ThreadSwitchingTarget threadSwitchingTarget = systemServices.getThreadSwitcher();
        new ContentProcessorManagerImpl$1(this, systemServices.getBundleContext(), (class$de$vw$mib$app$desktop$ContentManager == null ? (class$de$vw$mib$app$desktop$ContentManager = ContentProcessorManagerImpl.class$("de.vw.mib.app.desktop.ContentManager")) : class$de$vw$mib$app$desktop$ContentManager).getName(), null, threadSwitchingTarget).open();
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

