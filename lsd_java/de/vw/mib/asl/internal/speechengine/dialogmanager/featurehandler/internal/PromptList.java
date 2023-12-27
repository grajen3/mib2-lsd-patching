/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import java.util.ArrayList;
import java.util.List;

public class PromptList {
    private List promptList = new ArrayList();

    public void add(Prompt prompt) {
        this.promptList.add(prompt);
    }

    public void add(Prompt[] promptArray) {
        for (int i2 = 0; i2 < promptArray.length; ++i2) {
            this.promptList.add(promptArray[i2]);
        }
    }

    public void add(PromptList promptList) {
        this.promptList.addAll(promptList.promptList);
    }

    public void clear() {
        this.promptList.clear();
    }

    public Prompt[] toArray() {
        Object[] objectArray = new Prompt[this.promptList.size()];
        this.promptList.toArray(objectArray);
        return objectArray;
    }

    public boolean isEmpty() {
        return this.promptList.isEmpty();
    }

    public int size() {
        return this.promptList.size();
    }
}

