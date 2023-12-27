/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt.activator;

import de.vw.mib.asl.api.system.DoublePressKeyAdapter;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;

public abstract class AbstractDialogActivator
extends DoublePressKeyAdapter {
    protected final DialogSession dialogSession;
    protected final String name;

    public AbstractDialogActivator(String string, DialogSession dialogSession, Services services) {
        super(services);
        this.dialogSession = dialogSession;
        this.name = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DialogActivator");
        stringBuffer.append("(");
        stringBuffer.append("name=");
        stringBuffer.append(this.name);
        stringBuffer.append(",");
        stringBuffer.append("dialogSession=");
        stringBuffer.append(this.dialogSession);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    @Override
    public void onLongPressed(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onLongPressed(n);
        }
    }

    @Override
    public void onLongReleased(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onLongReleased(n);
        }
    }

    @Override
    public void onDoublePressed(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onDoublePressed(n);
        }
    }

    @Override
    public void onSinglePressed(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onSinglePressed(n);
        }
    }

    @Override
    public void onSingleReleased(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onSingleReleased(n);
        }
    }

    @Override
    public void onUltraLongPressed(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onUltraLongPressed(n);
        }
    }
}

