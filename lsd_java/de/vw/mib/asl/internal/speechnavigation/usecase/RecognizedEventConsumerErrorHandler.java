/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase;

import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.log4mib.Logger;

public class RecognizedEventConsumerErrorHandler
implements RecognizedEventConsumer {
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    @Override
    public void onRecognizedEvent(int n) {
        this.logger.error(8, new StringBuffer().append("no ASL first controller found to handle event: ").append(n).toString());
    }
}

