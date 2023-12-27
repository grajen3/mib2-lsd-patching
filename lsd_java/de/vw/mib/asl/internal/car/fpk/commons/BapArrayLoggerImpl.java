/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.commons;

import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.logger.Logger;

public class BapArrayLoggerImpl
implements Logger {
    private final String arrayListName;

    public BapArrayLoggerImpl(String string) {
        this.arrayListName = string;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append(this.arrayListName).append(" (AsgId = ").append(aSGArrayList.getAsgId()).append(", ListId = ").append(aSGArrayList.getListId()).append(")").append(" : ").append(string).toString();
        switch (n) {
            case 1: {
                AppLogger.fatal(this, string2);
                break;
            }
            case 2: {
                AppLogger.error(this, string2);
                break;
            }
            case 4: {
                AppLogger.warn(this, string2);
                break;
            }
            case 8: {
                AppLogger.info(this, string2);
                break;
            }
            case 12: {
                AppLogger.normal(this, string2);
                break;
            }
            case 16: {
                AppLogger.trace(this, string2);
                break;
            }
            default: {
                AppLogger.error(this, " Unknown log message called");
            }
        }
    }
}

