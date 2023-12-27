/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.IDoctorCommand;
import java.util.Comparator;

class DoctorShell$1
implements Comparator {
    private final /* synthetic */ DoctorShell this$0;

    DoctorShell$1(DoctorShell doctorShell) {
        this.this$0 = doctorShell;
    }

    @Override
    public int compare(Object object, Object object2) {
        IDoctorCommand iDoctorCommand = (IDoctorCommand)object;
        IDoctorCommand iDoctorCommand2 = (IDoctorCommand)object2;
        return iDoctorCommand.getAllNames().compareTo(iDoctorCommand2.getAllNames());
    }
}

