/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import java.io.PrintStream;

public interface IDoctorCommand {
    default public String[] getNames() {
    }

    default public String getDescription() {
    }

    default public String getUsage() {
    }

    default public String getSignature() {
    }

    default public String getAllNames() {
    }

    default public Boolean matchCommandName(String string) {
    }

    default public boolean handle(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
    }

    default public boolean checkArgs(String[] stringArray) {
    }
}

