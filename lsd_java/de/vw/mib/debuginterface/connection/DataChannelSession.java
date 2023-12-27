/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.connection;

import java.util.Random;

public class DataChannelSession {
    private static final Random RANDOMIZER = new Random();

    public static int getNextID() {
        return RANDOMIZER.nextInt();
    }
}

