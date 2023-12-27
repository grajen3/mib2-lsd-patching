/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.Logger;

public class ModelEventConsumerErrorHandler
implements ModelEventConsumer {
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        this.logger.error(8, new StringBuffer().append("no MODEL first controller found to handle event: ").append(n).toString());
    }
}

