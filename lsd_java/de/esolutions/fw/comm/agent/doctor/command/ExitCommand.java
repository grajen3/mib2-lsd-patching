/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractDoctorCommand;
import java.io.PrintStream;

public class ExitCommand
extends AbstractDoctorCommand {
    @Override
    public String[] getNames() {
        return new String[]{"quit", "exit"};
    }

    @Override
    public String getDescription() {
        return "exit doctor shell";
    }

    @Override
    public boolean handle(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        return true;
    }

    @Override
    public boolean checkArgs(String[] stringArray) {
        return stringArray.length == 0;
    }
}

