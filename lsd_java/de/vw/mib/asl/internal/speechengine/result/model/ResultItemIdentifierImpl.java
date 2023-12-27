/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.model;

import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import org.dsi.ifc.speechrec.NBestSlot;

public class ResultItemIdentifierImpl
implements ResultItemIdentifier {
    private int id;
    private long objectId;
    private int objectIndex;
    private String objectStringId;
    private String recognizedString;

    public ResultItemIdentifierImpl(NBestSlot nBestSlot) {
        this.id = nBestSlot.getId();
        this.objectId = nBestSlot.getObjectId();
        this.objectIndex = nBestSlot.getIndex();
        this.objectStringId = nBestSlot.getObjectStringId();
        this.recognizedString = nBestSlot.getRecognizedString();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public long getObjectId() {
        return this.objectId;
    }

    @Override
    public int getObjectIndex() {
        return this.objectIndex;
    }

    @Override
    public String getObjectStringId() {
        return this.objectStringId;
    }

    @Override
    public String getRecognizedString() {
        return this.recognizedString;
    }

    @Override
    public int compareTo(ResultItemIdentifier resultItemIdentifier) {
        if (this.objectStringId != null && this.objectStringId.length() > 0 && this.objectStringId.equalsIgnoreCase(resultItemIdentifier.getObjectStringId())) {
            return 0;
        }
        if (this.objectId == resultItemIdentifier.getObjectId()) {
            return 0;
        }
        return -1;
    }
}

