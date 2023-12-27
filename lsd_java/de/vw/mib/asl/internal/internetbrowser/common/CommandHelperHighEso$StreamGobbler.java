/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class CommandHelperHighEso$StreamGobbler
extends Thread {
    InputStream is;

    CommandHelperHighEso$StreamGobbler(InputStream inputStream) {
        this.is = inputStream;
    }

    @Override
    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.is);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.readLine() != null) {
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

