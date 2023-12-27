/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.api.speechengine.features.model.PromptReference;
import de.vw.mib.asl.internal.speechengine.features.model.PromptReferenceImpl;

public class PromptImpl
implements Prompt {
    private int promptId;
    private PromptReference[] references;

    public PromptImpl() {
    }

    public PromptImpl(int n, int n2, String[] stringArray) {
        this.promptId = n;
        this.setReferences(stringArray);
    }

    public PromptImpl(int n, int n2, PromptReference[] promptReferenceArray) {
        this.promptId = n;
        this.references = promptReferenceArray;
    }

    public PromptImpl(int n, PromptReference[] promptReferenceArray) {
        this.promptId = n;
        this.references = promptReferenceArray;
    }

    @Override
    public int getPromptId() {
        return this.promptId;
    }

    public void setPromptId(int n) {
        this.promptId = n;
    }

    @Override
    public String[] getReferences() {
        return PromptReferenceImpl.fromPromptReferences(this.references);
    }

    public void setReferences(String[] stringArray) {
        this.references = PromptReferenceImpl.toPromptReferences(stringArray);
    }

    @Override
    public PromptReference[] getPromptReferences() {
        return this.references;
    }

    public void setPromptReferences(PromptReference[] promptReferenceArray) {
        this.references = promptReferenceArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("promptId=");
        stringBuffer.append(String.valueOf(this.promptId));
        stringBuffer.append(",");
        stringBuffer.append("references=[");
        if (this.references == null) {
            stringBuffer.append("null");
        } else {
            for (int i2 = 0; i2 < this.references.length; ++i2) {
                if (this.references[i2] == null) {
                    stringBuffer.append("{null}");
                } else {
                    stringBuffer.append(this.references[i2].toString());
                }
                if (i2 >= this.references.length - 1) continue;
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]}");
        return stringBuffer.toString();
    }
}

