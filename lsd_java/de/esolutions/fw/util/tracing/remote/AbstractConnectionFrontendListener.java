/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;
import de.esolutions.fw.util.tracing.remote.IConnectionFrontendListener;
import de.esolutions.fw.util.tracing.remote.IMessageDumper;

public class AbstractConnectionFrontendListener
implements IConnectionFrontendListener {
    private Boolean ignoreLevels;
    private IMessageDumper dumper;
    private Boolean isMaster;
    private Boolean passiveMode;

    public void setIgnoreLevels(boolean bl) {
        this.ignoreLevels = new Boolean(bl);
    }

    public void setIsMaster(boolean bl) {
        this.isMaster = new Boolean(bl);
    }

    public void setPassiveMode(boolean bl) {
        this.passiveMode = new Boolean(bl);
    }

    public void setMessageDumper(IMessageDumper iMessageDumper) {
        this.dumper = iMessageDumper;
    }

    @Override
    public void configureHandler(ConnectionFrontendHandler connectionFrontendHandler) {
        if (this.ignoreLevels != null) {
            connectionFrontendHandler.setIgnoreLevels(this.ignoreLevels);
        }
        if (this.isMaster != null) {
            connectionFrontendHandler.setIsMaster(this.isMaster);
        }
        if (this.passiveMode != null) {
            connectionFrontendHandler.setPassiveMode(this.passiveMode);
        }
    }

    @Override
    public void registerConnection(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    @Override
    public void unregisterConnection(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    @Override
    public void handleMessage(ConnectionFrontendHandler connectionFrontendHandler, AbstractMessage abstractMessage) {
        if (this.dumper != null) {
            this.dumper.dump(abstractMessage);
        }
    }
}

