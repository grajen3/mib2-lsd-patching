/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.PromptReference;

public class PromptReferenceImpl
implements PromptReference {
    private String key;
    private String value;
    private String alternative;

    public PromptReferenceImpl() {
    }

    public PromptReferenceImpl(String string, String string2, String string3) {
        this.key = string;
        this.value = string2;
        this.alternative = string3;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    @Override
    public String getAlternative() {
        return this.alternative;
    }

    public void setAlternative(String string) {
        this.alternative = string;
    }

    public static PromptReference[] toPromptReferences(String[] stringArray) {
        if (stringArray == null || stringArray.length % 3 != 0) {
            return null;
        }
        PromptReference[] promptReferenceArray = new PromptReference[stringArray.length / 3];
        for (int i2 = 0; i2 < promptReferenceArray.length; ++i2) {
            PromptReferenceImpl promptReferenceImpl = new PromptReferenceImpl();
            promptReferenceImpl.key = stringArray[i2 * 3];
            promptReferenceImpl.value = stringArray[i2 * 3 + 1];
            promptReferenceImpl.alternative = stringArray[i2 * 3 + 2];
            promptReferenceArray[i2] = promptReferenceImpl;
        }
        return promptReferenceArray;
    }

    public static String[] fromPromptReferences(PromptReference[] promptReferenceArray) {
        if (promptReferenceArray == null) {
            return null;
        }
        String[] stringArray = new String[promptReferenceArray.length * 3];
        for (int i2 = 0; i2 < promptReferenceArray.length; ++i2) {
            stringArray[i2 * 3] = promptReferenceArray[i2].getKey();
            stringArray[i2 * 3 + 1] = promptReferenceArray[i2].getValue();
            stringArray[i2 * 3 + 2] = promptReferenceArray[i2].getAlternative();
        }
        return stringArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("key=");
        stringBuffer.append(String.valueOf(this.key));
        stringBuffer.append(",");
        stringBuffer.append("value=");
        stringBuffer.append(String.valueOf(this.value));
        stringBuffer.append(",");
        stringBuffer.append("alternative=");
        stringBuffer.append(String.valueOf(this.alternative));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

