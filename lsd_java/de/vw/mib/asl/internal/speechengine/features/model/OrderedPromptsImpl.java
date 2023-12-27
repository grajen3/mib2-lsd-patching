/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;

public class OrderedPromptsImpl
implements OrderedPrompts {
    private int[] promptIds;
    private int orderStrategy;

    public OrderedPromptsImpl() {
    }

    public OrderedPromptsImpl(int[] nArray, int n) {
        this.promptIds = nArray;
        this.orderStrategy = n;
    }

    @Override
    public int[] getPromptIds() {
        return this.promptIds;
    }

    public void setPromptIds(int[] nArray) {
        this.promptIds = nArray;
    }

    @Override
    public int getOrderStrategy() {
        return this.orderStrategy;
    }

    public void setOrderStrategy(int n) {
        this.orderStrategy = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("promptIds=[");
        if (this.promptIds == null) {
            stringBuffer.append("null");
        } else {
            for (int i2 = 0; i2 < this.promptIds.length; ++i2) {
                stringBuffer.append(String.valueOf(this.promptIds[i2]));
                if (i2 >= this.promptIds.length - 1) continue;
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("],");
        stringBuffer.append("orderStrategy=");
        stringBuffer.append(String.valueOf(this.orderStrategy));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

