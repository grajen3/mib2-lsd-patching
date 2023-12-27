/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class SimpleDoctorShell
extends DoctorShell
implements Runnable {
    private final BufferedReader in;
    private final PrintStream out;

    public SimpleDoctorShell(InputStream inputStream, PrintStream printStream) {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            inputStreamReader = new InputStreamReader(inputStream);
        }
        this.in = new BufferedReader(inputStreamReader);
        this.out = printStream;
    }

    @Override
    public void run() {
        this.printWelcome(this.out);
        try {
            String string;
            boolean bl;
            do {
                this.out.print(this.getPrompt());
                this.out.flush();
            } while (!(bl = this.handleCommand(string = this.in.readLine(), this.out)));
        }
        catch (IOException iOException) {
            iOException.printStackTrace(this.out);
        }
        this.printGoodbye(this.out);
    }
}

