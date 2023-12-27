/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.CommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;

public abstract class AbstractCommandConsumer
implements CommandConsumer {
    protected DialogManagerLogger logger;
    protected String commandName;
    protected int command;
    protected boolean commandValid;
    protected DialogManagerInternal dialogManager;

    public AbstractCommandConsumer(DialogManagerInternal dialogManagerInternal, String string, String string2) {
        this.dialogManager = dialogManagerInternal;
        this.logger = new DialogManagerLogger(string);
        this.commandName = string2;
    }

    protected void updateCommand(int n) {
        if (this.commandValid) {
            if (this.command == n) {
                return;
            }
            if (this.logger.isTraceEnabled()) {
                this.trace("Reload", n);
            }
            this.dialogManager.unregisterCommandConsumer(this.command, this);
        } else if (this.logger.isTraceEnabled()) {
            this.trace("Load", n);
        }
        this.command = n;
        this.dialogManager.registerCommandConsumer(this.command, this);
        this.commandValid = true;
    }

    private void trace(String string, int n) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append(" \"");
        stringBuffer.append(this.commandName);
        stringBuffer.append("\" command to sdsId: ");
        stringBuffer.append(n);
        this.logger.trace(stringBuffer.toString());
    }

    @Override
    public abstract void recognizedCommand(Command command) {
    }
}

