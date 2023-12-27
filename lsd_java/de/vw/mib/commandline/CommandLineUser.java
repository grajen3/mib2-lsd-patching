/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.commandline;

import de.vw.mib.commandline.CommandLine;

public interface CommandLineUser {
    default public void initUser(CommandLine commandLine) {
    }

    default public void commandParsed(int n, boolean[] blArray, String[] stringArray) {
    }
}

