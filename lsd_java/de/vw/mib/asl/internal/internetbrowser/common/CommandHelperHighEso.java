/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.common;

import de.vw.mib.asl.internal.internetbrowser.common.CommandHelper;
import de.vw.mib.asl.internal.internetbrowser.common.CommandHelperHighEso$StreamGobbler;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CommandHelperHighEso
implements CommandHelper {
    public boolean makeWritable(String string) {
        String string2 = new StringBuffer().append("/bin/mount -wu ").append(this.getMountPath(string)).toString();
        return this.execute(string2);
    }

    public boolean makeReadOnly(String string) {
        String string2 = new StringBuffer().append("/bin/mount -ru ").append(this.getMountPath(string)).toString();
        return this.execute(string2);
    }

    @Override
    public boolean createSymbolicLink(String string, String string2) {
        String string3 = new StringBuffer().append("/bin/ln -s ").append(this.getMountPath(string)).append(" ").append(string2).toString();
        return this.execute(string3);
    }

    @Override
    public boolean removeSymbolicLink(String string) {
        String string2 = new StringBuffer().append("/bin/rm ").append(string).toString();
        return this.execute(string2);
    }

    private boolean execute(String string) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("/bin/sh");
            CommandHelperHighEso$StreamGobbler commandHelperHighEso$StreamGobbler = new CommandHelperHighEso$StreamGobbler(process.getErrorStream());
            CommandHelperHighEso$StreamGobbler commandHelperHighEso$StreamGobbler2 = new CommandHelperHighEso$StreamGobbler(process.getInputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
            commandHelperHighEso$StreamGobbler.start();
            commandHelperHighEso$StreamGobbler2.start();
            return process.waitFor() == 0;
        }
        catch (IOException iOException) {}
        catch (IllegalArgumentException illegalArgumentException) {}
        catch (InterruptedException interruptedException) {}
        finally {
            return false;
        }
    }

    private String getMountPath(String string) {
        return string;
    }
}

