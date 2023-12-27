/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;

public interface IConnectionFrontendListener {
    default public void configureHandler(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    default public void registerConnection(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    default public void unregisterConnection(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    default public void handleMessage(ConnectionFrontendHandler connectionFrontendHandler, AbstractMessage abstractMessage) {
    }
}

