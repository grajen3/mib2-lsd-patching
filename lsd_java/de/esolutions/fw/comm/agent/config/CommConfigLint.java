/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.config.CommConfigTransport;
import de.esolutions.fw.util.config.fw.SystemConfig;
import java.util.ArrayList;

public class CommConfigLint {
    private CommConfig config;
    private ArrayList errors = new ArrayList();

    private CommConfigLint(CommConfig commConfig) {
        this.config = commConfig;
    }

    private void addError(String string) {
        this.errors.add(string);
    }

    private void errorOutput() {
        System.out.println(new StringBuffer().append(this.errors.size()).append(" Errors detected: ").toString());
        for (int i2 = 0; i2 < this.errors.size(); ++i2) {
            System.out.println(new StringBuffer().append("- ").append(this.errors.get(i2)).toString());
        }
    }

    private boolean lint() {
        SystemConfig systemConfig = SystemConfig.getInstance();
        if (!systemConfig.isValid()) {
            this.addError("SystemConfig is invalid. ");
            return false;
        }
        CommConfigTransport commConfigTransport = this.config.getTransport();
        int[] nArray = systemConfig.getAllProcIds();
        Short[] shortArray = commConfigTransport.getConfiguredRxWorker();
        Short[] shortArray2 = commConfigTransport.getConfiguredTxWorker();
        this.checkConfiguredTransport(shortArray, nArray, "rx");
        this.checkConfiguredTransport(shortArray2, nArray, "tx");
        if (this.errors.size() == 0) {
            System.out.println("OK");
            return true;
        }
        this.errorOutput();
        return false;
    }

    private void checkConfiguredTransport(Short[] shortArray, int[] nArray, String string) {
        for (int i2 = 0; i2 < shortArray.length; ++i2) {
            int n = shortArray[i2].intValue();
            if (this.contains(shortArray[i2].intValue(), nArray)) continue;
            this.errors.add(new StringBuffer().append(" Unknown ProcessId \"").append(n).append("\" configured in transport java.transport.").append(string).append(".static").toString());
        }
    }

    private boolean contains(int n, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != nArray[i2]) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        CommConfig commConfig = CommConfig.getInstance();
        if (!commConfig.isValid()) {
            System.out.println(new StringBuffer().append("ERROR reading config: ").append(commConfig.getFailString()).toString());
            return;
        }
        CommConfigLint commConfigLint = new CommConfigLint(commConfig);
        boolean bl = commConfigLint.lint();
        if (bl) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }
}

