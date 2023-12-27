/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

public class ModelFetchRequestItem {
    private boolean itemWaitingForDsiAnswer;
    private int count;
    private int index;

    public ModelFetchRequestItem(int n, int n2, boolean bl) {
        this.index = n;
        this.count = n2;
        this.itemWaitingForDsiAnswer = bl;
    }

    public int getCount() {
        return this.count;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isItemWaitingForDsiAnswer() {
        return this.itemWaitingForDsiAnswer;
    }

    public void setCount(int n) {
        this.count = n;
    }

    public void setIndex(int n) {
        this.index = n;
    }

    public void setRequestItemToWaintingForDsiAnswer() {
        this.itemWaitingForDsiAnswer = true;
    }

    public boolean equals(Object object) {
        if (object instanceof ModelFetchRequestItem) {
            return this.getCount() == ((ModelFetchRequestItem)object).getCount() && this.getIndex() == ((ModelFetchRequestItem)object).getIndex() && this.isItemWaitingForDsiAnswer() == ((ModelFetchRequestItem)object).isItemWaitingForDsiAnswer();
        }
        return false;
    }

    public int hashCode() {
        int n = 1;
        n = n * 17 + this.getCount();
        n = n * 31 + this.getIndex();
        n = n * 13 + (this.isItemWaitingForDsiAnswer() ? 0 : 1);
        return n;
    }
}

