/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.Command;

public class CommandImpl
implements Command {
    private int clientId;
    private int sdsId;
    private int eventId;
    private int mode;
    private boolean isPublic;
    private boolean isSpellingGrammar;
    private boolean isNlu;

    public CommandImpl() {
    }

    public CommandImpl(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3) {
        this.clientId = n;
        this.sdsId = n2;
        this.eventId = n3;
        this.mode = n4;
        this.isPublic = bl;
        this.isSpellingGrammar = bl2;
        this.isNlu = bl3;
    }

    @Override
    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int n) {
        this.clientId = n;
    }

    @Override
    public int getSdsId() {
        return this.sdsId;
    }

    public void setSdsId(int n) {
        this.sdsId = n;
    }

    @Override
    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int n) {
        this.eventId = n;
    }

    @Override
    public int getMode() {
        return this.mode;
    }

    public void setMode(int n) {
        this.mode = n;
    }

    @Override
    public boolean isPublic() {
        return this.isPublic;
    }

    public void setPublic(boolean bl) {
        this.isPublic = bl;
    }

    @Override
    public boolean isSpellingGrammar() {
        return this.isSpellingGrammar;
    }

    public void setSpellingGrammar(boolean bl) {
        this.isSpellingGrammar = bl;
    }

    public int getHierarchy() {
        if (this.mode == 2) {
            return 1;
        }
        return this.mode;
    }

    @Override
    public boolean isNLU() {
        return this.isNlu;
    }

    public void setNLU(boolean bl) {
        this.isNlu = bl;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.clientId;
        n2 = 31 * n2 + this.eventId;
        n2 = 31 * n2 + this.mode;
        n2 = 31 * n2 + this.sdsId;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CommandImpl commandImpl = (CommandImpl)object;
        if (this.clientId != commandImpl.clientId) {
            return false;
        }
        if (this.eventId != commandImpl.eventId) {
            return false;
        }
        if (this.mode != commandImpl.mode) {
            return false;
        }
        return this.sdsId == commandImpl.sdsId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("clientId=");
        stringBuffer.append(String.valueOf(this.clientId));
        stringBuffer.append(",");
        stringBuffer.append("sdsId=");
        stringBuffer.append(String.valueOf(this.sdsId));
        stringBuffer.append(",");
        stringBuffer.append("eventId=");
        stringBuffer.append(String.valueOf(this.eventId));
        stringBuffer.append(",");
        stringBuffer.append("mode=");
        stringBuffer.append(String.valueOf(this.mode));
        stringBuffer.append(",");
        stringBuffer.append("isPublic=");
        stringBuffer.append(String.valueOf(this.isPublic));
        stringBuffer.append(",");
        stringBuffer.append("isSpellingGrammar=");
        stringBuffer.append(String.valueOf(this.isSpellingGrammar));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

