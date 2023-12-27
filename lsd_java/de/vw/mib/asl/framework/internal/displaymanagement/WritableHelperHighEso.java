/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.framework.api.displaymanagement.WritableHelper;
import de.vw.mib.asl.framework.internal.displaymanagement.WritableHelperHighEso$StreamGobbler;
import de.vw.mib.util.Util;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WritableHelperHighEso
implements WritableHelper {
    @Override
    public boolean makeWritable(String string) {
        try {
            String string2 = this.getMountPath(string);
            if (Util.isNullOrEmpty(string2)) {
                return false;
            }
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("/bin/sh");
            WritableHelperHighEso$StreamGobbler writableHelperHighEso$StreamGobbler = new WritableHelperHighEso$StreamGobbler(process.getErrorStream());
            WritableHelperHighEso$StreamGobbler writableHelperHighEso$StreamGobbler2 = new WritableHelperHighEso$StreamGobbler(process.getInputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            bufferedWriter.write(new StringBuffer().append("/bin/mount -u ").append(string2).toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            writableHelperHighEso$StreamGobbler.start();
            writableHelperHighEso$StreamGobbler2.start();
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
        if (string.startsWith("/net/mmx.mibhigh.net")) {
            return string.substring("/net/mmx.mibhigh.net".length());
        }
        return string;
    }
}

