/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.contentprocessor;

import de.vw.mib.app.desktop.ContentManager;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractContentProcessor {
    private final String screenArea;
    protected final Logger logger;
    private ContentManager contentManager;
    private String pendingContentId;

    public AbstractContentProcessor(Logger logger, String string) {
        Preconditions.checkNotNull(logger, "Logger must not be null!");
        this.logger = logger;
        this.screenArea = string;
    }

    public void installContentManager(ContentManager contentManager) {
        Preconditions.checkArgument(contentManager != null, new StringBuffer().append("Given Content Manager must not be null for screen area ").append(this.screenArea).toString());
        Preconditions.checkState(this.contentManager == null, new StringBuffer().append("Content Manager was installed before for screen area ").append(this.screenArea).toString());
        this.contentManager = contentManager;
        if (this.pendingContentId != null) {
            this.updateContent(this.pendingContentId);
        }
    }

    public final void updateContent(String string) {
        if (this.contentManager != null) {
            this.logger.info(2048, new StringBuffer().append("<cp = ").append(this.screenArea).append("> <content = ").append(string).append(">").toString());
            this.contentManager.updateContent(this.screenArea, string);
        } else {
            this.pendingContentId = string;
        }
    }

    public String getScreenArea() {
        return this.screenArea;
    }

    public abstract void requestContent(String string) {
    }
}

