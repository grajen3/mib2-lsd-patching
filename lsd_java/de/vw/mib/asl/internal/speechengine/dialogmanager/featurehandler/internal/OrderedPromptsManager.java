/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal;

import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import java.util.ArrayList;
import java.util.List;

public class OrderedPromptsManager {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[OrderedPromptsManager] ");
    private List prompts = new ArrayList();
    private List extraList = new ArrayList();
    private boolean enableExtraList = false;
    private int orderStrategy = -1;
    private int counter;

    public void addPrompts(OrderedPrompts orderedPrompts) {
        if (orderedPrompts == null || orderedPrompts.getPromptIds() == null) {
            return;
        }
        if (this.orderStrategy >= 0 && orderedPrompts.getOrderStrategy() != this.orderStrategy) {
            logger.error("tried to combine Ordered Prompts with different order strategies.");
            return;
        }
        for (int i2 = 0; i2 < orderedPrompts.getPromptIds().length; ++i2) {
            this.prompts.add(new Integer(orderedPrompts.getPromptIds()[i2]));
        }
        this.orderStrategy = orderedPrompts.getOrderStrategy();
        this.counter = 0;
    }

    public boolean equalPropmpts(OrderedPrompts[] orderedPromptsArray) {
        int n;
        if (orderedPromptsArray == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (n = 0; n < orderedPromptsArray.length; ++n) {
            OrderedPrompts orderedPrompts = orderedPromptsArray[n];
            if (orderedPrompts == null) continue;
            int[] nArray = orderedPrompts.getPromptIds();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                arrayList.add(new Integer(nArray[i2]));
            }
        }
        if (this.prompts.size() != arrayList.size()) {
            return false;
        }
        for (n = 0; n < this.prompts.size(); ++n) {
            if (this.prompts.get(n).equals(arrayList.get(n))) continue;
            return false;
        }
        return true;
    }

    public void addSinglePrompt(int n) {
        this.prompts.add(new Integer(n));
        if (this.orderStrategy < 0) {
            this.orderStrategy = 0;
        }
    }

    public void clearPrompts() {
        this.prompts.clear();
        if (this.extraList.isEmpty()) {
            this.counter = 0;
            this.orderStrategy = -1;
        }
    }

    public void addExtraPrompts(OrderedPrompts orderedPrompts) {
        if (orderedPrompts == null || orderedPrompts.getPromptIds() == null) {
            return;
        }
        if (this.orderStrategy >= 0 && orderedPrompts.getOrderStrategy() != this.orderStrategy) {
            logger.error("tried to combine Ordered Prompts with different order strategies.");
            return;
        }
        for (int i2 = 0; i2 < orderedPrompts.getPromptIds().length; ++i2) {
            this.extraList.add(new Integer(orderedPrompts.getPromptIds()[i2]));
        }
        this.orderStrategy = orderedPrompts.getOrderStrategy();
    }

    public void addSingleExtraPrompt(int n) {
        this.extraList.add(new Integer(n));
        if (this.orderStrategy < 0) {
            this.orderStrategy = 0;
        }
    }

    public void clearExtraPrompts() {
        this.extraList.clear();
        if (this.prompts.isEmpty()) {
            this.counter = 0;
            this.orderStrategy = -1;
        }
    }

    public void setExtraPromptsEnabled(boolean bl) {
        this.enableExtraList = bl;
    }

    public int getNextPromptId() {
        if (!this.isValid()) {
            logger.error("ordered prompts were not set or are empty.");
            return -1;
        }
        switch (this.orderStrategy) {
            case 0: {
                return this.getNextSequential();
            }
            case 1: {
                return this.getNextRandom();
            }
        }
        logger.error("unknown order strategy.");
        return -1;
    }

    private int getNextSequential() {
        if (!this.enableExtraList) {
            if (this.counter >= this.prompts.size()) {
                this.counter = 0;
            }
            Integer n = (Integer)this.prompts.get(this.counter);
            ++this.counter;
            return n;
        }
        if (this.counter >= this.prompts.size() + this.extraList.size()) {
            this.counter = 0;
        }
        Integer n = null;
        n = this.counter < this.prompts.size() ? (Integer)this.prompts.get(this.counter) : (Integer)this.extraList.get(this.counter - this.prompts.size());
        ++this.counter;
        return n;
    }

    private int getNextRandom() {
        if (!this.enableExtraList) {
            this.counter = (int)(Math.random() * (double)this.prompts.size());
            Integer n = (Integer)this.prompts.get(this.counter);
            return n;
        }
        this.counter = (int)(Math.random() * (double)(this.prompts.size() + this.extraList.size()));
        Integer n = null;
        n = this.counter < this.prompts.size() ? (Integer)this.prompts.get(this.counter) : (Integer)this.extraList.get(this.counter - this.prompts.size());
        return n;
    }

    public boolean isValid() {
        if (!this.enableExtraList) {
            return !this.prompts.isEmpty();
        }
        return this.prompts.size() + this.extraList.size() > 0;
    }
}

