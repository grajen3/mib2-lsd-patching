/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class WritableHelperHighEso$StreamGobbler
extends Thread {
    InputStream is;

    WritableHelperHighEso$StreamGobbler(InputStream inputStream) {
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

