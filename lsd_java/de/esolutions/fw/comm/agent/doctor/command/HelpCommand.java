/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractDoctorCommand;
import de.esolutions.fw.comm.agent.doctor.command.DoctorCommandRegistry;
import de.esolutions.fw.comm.agent.doctor.command.IDoctorCommand;
import java.io.PrintStream;

public class HelpCommand
extends AbstractDoctorCommand {
    @Override
    public String[] getNames() {
        return new String[]{"help", "?"};
    }

    @Override
    public String getDescription() {
        return "give information on (all) command usage";
    }

    @Override
    public String getUsage() {
        return "[command]";
    }

    @Override
    public boolean handle(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        if (stringArray.length == 0) {
            doctorShell.showHelp(printStream);
        } else {
            IDoctorCommand[] iDoctorCommandArray = DoctorCommandRegistry.getInstance().getAllCommands();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2];
                for (int i3 = 0; i3 < iDoctorCommandArray.length; ++i3) {
                    IDoctorCommand iDoctorCommand = iDoctorCommandArray[i3];
                    if (iDoctorCommand.matchCommandName(string) == null) continue;
                    doctorShell.showCommandHelp(printStream, iDoctorCommand);
                    printStream.println();
                }
            }
        }
        return false;
    }
}

