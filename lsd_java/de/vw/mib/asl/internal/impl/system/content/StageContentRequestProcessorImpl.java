/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.content;

import de.vw.mib.asl.api.system.content.AbstractStageContentRequest;
import de.vw.mib.asl.api.system.content.StageContentRequestProcessor;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;
import de.vw.mib.asl.internal.system.processor.stage.StageContentRequestAdmin;
import de.vw.mib.asl.internal.system.util.Preconditions;

public class StageContentRequestProcessorImpl
implements StageContentRequestProcessor {
    private MenuManager menuManager;
    private StageContentProcessor stageContentProcessor;
    private StageContentRequestAdmin stageContentRequestAdmin;

    public StageContentRequestProcessorImpl(MenuManager menuManager, StageContentProcessor stageContentProcessor, StageContentRequestAdmin stageContentRequestAdmin) {
        Preconditions.checkArgumentNotNull(menuManager, "Instance of class MenuManager must not be null.");
        Preconditions.checkArgumentNotNull(stageContentProcessor, "Instance of class StageContentProcessor must not be null.");
        Preconditions.checkArgumentNotNull(stageContentRequestAdmin, "Instance of class StageContentRequestAdmin must not be null.");
        this.menuManager = menuManager;
        this.stageContentProcessor = stageContentProcessor;
        this.stageContentRequestAdmin = stageContentRequestAdmin;
    }

    @Override
    public void process(AbstractStageContentRequest abstractStageContentRequest) {
        Preconditions.checkArgumentNotNull(abstractStageContentRequest, "Instance of class AbstractStageContentRequest must not be null.");
        Preconditions.checkNotNullOrEmpty(abstractStageContentRequest.getContentId(), "Method getContentId of passed instance of class AbstractStageContentRequest must not be null.");
        String string = abstractStageContentRequest.getContentId();
        if (string.equals("HMI_MENU")) {
            string = this.menuManager.getMenuContentId();
        }
        if (!this.isRequestGranted(abstractStageContentRequest)) {
            abstractStageContentRequest.onFailure();
            return;
        }
        this.stageContentProcessor.requestContent(string);
        abstractStageContentRequest.onSuccess();
    }

    private boolean isRequestGranted(AbstractStageContentRequest abstractStageContentRequest) {
        return this.stageContentRequestAdmin.isRequestGranted(abstractStageContentRequest);
    }
}

