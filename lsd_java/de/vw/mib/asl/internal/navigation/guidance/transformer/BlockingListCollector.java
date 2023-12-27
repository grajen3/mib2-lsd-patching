/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

public class BlockingListCollector {
    public String myName;
    public boolean isSelected;
    public long myId;

    public BlockingListCollector() {
    }

    public BlockingListCollector(String string, boolean bl, long l) {
        this.myName = string;
        this.isSelected = bl;
        this.myId = l;
    }
}

