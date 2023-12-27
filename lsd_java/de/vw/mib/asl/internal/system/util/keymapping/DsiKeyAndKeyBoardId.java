/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util.keymapping;

public class DsiKeyAndKeyBoardId {
    private int dsiKey;
    private int keyBoardId;

    public DsiKeyAndKeyBoardId(int n, int n2) {
        this.dsiKey = n;
        this.keyBoardId = n2;
    }

    public int getDsiKey() {
        return this.dsiKey;
    }

    public int getKeyBoardId() {
        return this.keyBoardId;
    }

    public boolean compareDsiKeyAndKeyBoardId(int n, int n2) {
        return this.keyBoardId == n && this.dsiKey == n2;
    }
}

