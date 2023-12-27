/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell$1;
import de.esolutions.fw.comm.agent.doctor.DoctorShellState;
import de.esolutions.fw.comm.agent.doctor.command.DoctorCommandRegistry;
import de.esolutions.fw.comm.agent.doctor.command.ExitCommand;
import de.esolutions.fw.comm.agent.doctor.command.IDoctorCommand;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorShell {
    private final List commands = new ArrayList();
    private final DoctorShellState state = new DoctorShellState();
    private int quotePos;
    private static final String[] quotes = new String[]{"Why do you say that?", "Can you elaborate on that?", "Maybe you should consult a doctor of medicine, I am a COMM doctor.", "You are not making any sense.", "Now you are just talking nonsense!", "I think you know what the problem is just as well as I do.", "Just what do you think you're doing, Dave?", "I'm sorry, Dave. I'm afraid I can't do that."};

    public DoctorShell() {
        this.registerDefaultCommands();
    }

    public DoctorShellState getState() {
        return this.state;
    }

    protected void registerDefaultCommands() {
        this.registerCommand(new ExitCommand());
    }

    public void registerCommand(IDoctorCommand iDoctorCommand) {
        this.commands.add(iDoctorCommand);
    }

    public void printWelcome(PrintStream printStream) {
        printStream.println("Welcome to eso COMM Agent Doctor's Surgery Shell!");
    }

    public void printGoodbye(PrintStream printStream) {
        printStream.println("Bye! I hope you feel better now...");
    }

    public void showHelp(PrintStream printStream) {
        String string;
        Object object;
        int n;
        Object[] objectArray = DoctorCommandRegistry.getInstance().getAllCommands();
        Arrays.sort(objectArray, new DoctorShell$1(this));
        int n2 = 0;
        int n3 = 0;
        for (n = 0; n < objectArray.length; ++n) {
            int n4;
            String string2;
            object = objectArray[n];
            string = object.getAllNames();
            int n5 = string.length();
            if (n5 > n2) {
                n2 = n5;
            }
            if ((string2 = object.getUsage()) == null || (n4 = string2.length()) <= n3) continue;
            n3 = n4;
        }
        n2 += 2;
        if (n3 > 0) {
            n3 += 2;
        }
        printStream.println("Command List:");
        for (n = 0; n < objectArray.length; ++n) {
            object = objectArray[n];
            string = object.getAllNames();
            printStream.print(StringUtils.padString(string, n2, 4));
            if (n3 > 0) {
                String string3 = object.getUsage();
                if (string3 == null) {
                    string3 = "";
                }
                printStream.print(StringUtils.padString(string3, n3, 4));
            }
            printStream.println(object.getDescription());
        }
    }

    public void showCommandHelp(PrintStream printStream, IDoctorCommand iDoctorCommand) {
        printStream.println(iDoctorCommand.getSignature());
        printStream.println(iDoctorCommand.getDescription());
    }

    public String getPrompt() {
        long l = System.currentTimeMillis();
        TraceTimeStamp traceTimeStamp = new TraceTimeStamp(l);
        Buffer buffer = new Buffer();
        buffer.append(traceTimeStamp.toUTCTimeString(false));
        buffer.append(" > ");
        return buffer.toString();
    }

    public boolean handleCommand(String string, PrintStream printStream) {
        IDoctorCommand[] iDoctorCommandArray = DoctorCommandRegistry.getInstance().getAllCommands();
        String[] stringArray = StringUtils.splitString(string, ' ');
        if (stringArray == null || stringArray.length == 0) {
            printStream.println("Huh? Enter 'help' for help.");
            return false;
        }
        String string2 = stringArray[0];
        if (string2 == null || string2.length() == 0) {
            printStream.println("Huh? Enter 'help' for help.");
            return false;
        }
        IDoctorCommand iDoctorCommand = null;
        boolean bl = false;
        for (int i2 = 0; i2 < iDoctorCommandArray.length; ++i2) {
            IDoctorCommand iDoctorCommand2 = iDoctorCommandArray[i2];
            Boolean bl2 = iDoctorCommand2.matchCommandName(string2);
            if (bl2 == null) continue;
            boolean bl3 = bl2;
            if (bl3) {
                iDoctorCommand = iDoctorCommand2;
                break;
            }
            if (bl) {
                printStream.println(new StringBuffer().append("Command name '").append(string2).append("' is ambiguous! Please rephrase.").toString());
                return false;
            }
            iDoctorCommand = iDoctorCommand2;
            bl = true;
        }
        if (iDoctorCommand != null) {
            String[] stringArray2 = new String[stringArray.length - 1];
            for (int i3 = 0; i3 < stringArray2.length; ++i3) {
                stringArray2[i3] = stringArray[i3 + 1];
            }
            if (!iDoctorCommand.checkArgs(stringArray2)) {
                printStream.println("Command syntax error! Mabye, try:");
                this.showCommandHelp(printStream, iDoctorCommand);
                return false;
            }
            return iDoctorCommand.handle(this, stringArray2, printStream);
        }
        printStream.print(new StringBuffer().append("'").append(string2).append("'? ").toString());
        printStream.println(quotes[this.quotePos++]);
        if (this.quotePos == quotes.length) {
            this.quotePos = 0;
        }
        return false;
    }
}

