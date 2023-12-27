/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.util.commons.Buffer;

public class CommDebugTag {
    private final long ts;
    private final AbstractMessage msg;

    public CommDebugTag(long l, AbstractMessage abstractMessage) {
        this.ts = l;
        this.msg = abstractMessage;
    }

    public long getTimeStamp() {
        return this.ts;
    }

    public AbstractMessage getMessage() {
        return this.msg;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.ts);
        buffer.append(' ');
        this.msg.dump(buffer);
        return buffer.toString();
    }
}

