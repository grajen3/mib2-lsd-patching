/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.internal.phone.call.SpellerBlockItem;

public class DialSpellerCacheItem {
    public static final int ACTION_INVALID;
    public static final int ACTION_ADD_CHARS;
    public static final int ACTION_REMOVE_CHARS;
    public int action = 0;
    public SpellerBlockItem spellerBlockItem;
    public boolean touchSpellerBlocks;

    public DialSpellerCacheItem(int n, SpellerBlockItem spellerBlockItem, boolean bl) {
        this.action = n;
        this.spellerBlockItem = spellerBlockItem;
        this.touchSpellerBlocks = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialSpellerCacheItem [action=");
        stringBuffer.append(this.getActionName(this.action));
        stringBuffer.append(", spellerBlockItem=");
        stringBuffer.append(this.spellerBlockItem.toString());
        stringBuffer.append(", touchSpellerBlocks=");
        stringBuffer.append(this.touchSpellerBlocks);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private String getActionName(int n) {
        switch (n) {
            case 1: {
                return "addCharacters";
            }
            case 2: {
                return "removeCharacters";
            }
        }
        return "INVALID";
    }
}

