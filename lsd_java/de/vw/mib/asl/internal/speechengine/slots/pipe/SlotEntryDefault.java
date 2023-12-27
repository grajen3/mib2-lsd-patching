/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;

public final class SlotEntryDefault
extends SlotEntry {
    private final String speakableText;
    private final long objectId;

    public SlotEntryDefault(String string, long l) {
        this.speakableText = string;
        this.objectId = l;
    }

    @Override
    public String getSpeakableText() {
        return this.speakableText;
    }

    @Override
    public long getObjectId() {
        return this.objectId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("[SlotEntry: Text='");
        stringBuffer.append(this.speakableText);
        stringBuffer.append("' Id='");
        stringBuffer.append(this.objectId);
        stringBuffer.append("']");
        return stringBuffer.toString();
    }
}

