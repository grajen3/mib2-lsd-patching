/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.command.AgentInfoCommand;
import de.esolutions.fw.comm.agent.doctor.command.AgentSnapshotCommand;
import de.esolutions.fw.comm.agent.doctor.command.ClientErrorCommand;
import de.esolutions.fw.comm.agent.doctor.command.ClientInfoCommand;
import de.esolutions.fw.comm.agent.doctor.command.DiagnosisReportCommand;
import de.esolutions.fw.comm.agent.doctor.command.ExitCommand;
import de.esolutions.fw.comm.agent.doctor.command.HelpCommand;
import de.esolutions.fw.comm.agent.doctor.command.IDoctorCommand;
import de.esolutions.fw.comm.agent.doctor.command.ProxyErrorCommand;
import de.esolutions.fw.comm.agent.doctor.command.ProxyInfoCommand;
import de.esolutions.fw.comm.agent.doctor.command.ServiceDirectoryCommand;
import de.esolutions.fw.comm.agent.doctor.command.ServiceRegistryCommand;
import de.esolutions.fw.comm.agent.doctor.command.StubErrorCommand;
import de.esolutions.fw.comm.agent.doctor.command.StubInfoCommand;
import java.util.ArrayList;
import java.util.List;

public class DoctorCommandRegistry {
    private static DoctorCommandRegistry theInstance;
    private final List commands = new ArrayList();

    public static final synchronized DoctorCommandRegistry getInstance() {
        if (theInstance == null) {
            theInstance = new DoctorCommandRegistry();
        }
        return theInstance;
    }

    public DoctorCommandRegistry() {
        this.registerDefaultCommands();
    }

    protected void registerDefaultCommands() {
        this.registerCommand(new ExitCommand());
        this.registerCommand(new HelpCommand());
        this.registerCommand(new AgentInfoCommand());
        this.registerCommand(new ClientInfoCommand());
        this.registerCommand(new ProxyInfoCommand());
        this.registerCommand(new StubInfoCommand());
        this.registerCommand(new AgentSnapshotCommand());
        this.registerCommand(new ProxyErrorCommand());
        this.registerCommand(new StubErrorCommand());
        this.registerCommand(new ClientErrorCommand());
        this.registerCommand(new ServiceRegistryCommand());
        this.registerCommand(new ServiceDirectoryCommand());
        this.registerCommand(new DiagnosisReportCommand());
    }

    public synchronized void registerCommand(IDoctorCommand iDoctorCommand) {
        this.commands.add(iDoctorCommand);
    }

    public synchronized void unregisterCommand(IDoctorCommand iDoctorCommand) {
        this.commands.remove(iDoctorCommand);
    }

    public synchronized IDoctorCommand[] getAllCommands() {
        Object[] objectArray = new IDoctorCommand[this.commands.size()];
        this.commands.toArray(objectArray);
        return objectArray;
    }
}

