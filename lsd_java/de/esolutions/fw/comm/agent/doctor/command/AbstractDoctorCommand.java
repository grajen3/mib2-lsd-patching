/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.doctor.command.IDoctorCommand;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractDoctorCommand
implements IDoctorCommand {
    @Override
    public Boolean matchCommandName(String string) {
        string = string.toLowerCase();
        String[] stringArray = this.getNames();
        if (stringArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2 = stringArray[i2];
            if (string2.equals(string)) {
                return new Boolean(true);
            }
            if (!string2.startsWith(string)) continue;
            return new Boolean(false);
        }
        return null;
    }

    @Override
    public String getSignature() {
        Buffer buffer = new Buffer();
        this.allNamesToBuffer(buffer);
        String string = this.getUsage();
        if (string != null) {
            buffer.append("  ");
            buffer.append(string);
        }
        return buffer.toString();
    }

    @Override
    public String getAllNames() {
        Buffer buffer = new Buffer();
        this.allNamesToBuffer(buffer);
        return buffer.toString();
    }

    private void allNamesToBuffer(Buffer buffer) {
        String[] stringArray = this.getNames();
        if (stringArray == null) {
            return;
        }
        boolean bl = true;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!bl) {
                buffer.append(" | ");
            } else {
                bl = false;
            }
            buffer.append(stringArray[i2]);
        }
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public boolean checkArgs(String[] stringArray) {
        return true;
    }
}

