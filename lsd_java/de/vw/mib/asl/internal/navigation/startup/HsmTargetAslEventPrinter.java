/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.HsmTargetAslEventPrinter$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.zip.ZipInputStream;

public class HsmTargetAslEventPrinter
extends AbstractASLHsmTarget {
    public static final int EV_CYCLIC_TEST_EVENT;
    Hashtable eventMapIdName = new Hashtable();
    protected final HsmState stateWork = new HsmTargetAslEventPrinter$1(this, this.hsm, "stateWork", this.getWorkStateParent());

    public HsmTargetAslEventPrinter(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    protected void registerObservers() {
        InputStream inputStream = super.getClass().getResourceAsStream("/ASLDeviceIds.zip");
        if (inputStream != null) {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            try {
                while (zipInputStream.getNextEntry() != null) {
                    String string;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream));
                    while ((string = bufferedReader.readLine()) != null) {
                        string = string.trim();
                        int n = string.lastIndexOf(":");
                        String string2 = string.substring(n + 1);
                        StringBuffer stringBuffer = new StringBuffer("generated.de.vw.mib.asl.internal.");
                        stringBuffer.append(string2.toLowerCase());
                        stringBuffer.append('.');
                        stringBuffer.append("ASL");
                        char[] cArray = string2.toCharArray();
                        for (int i2 = 0; i2 < cArray.length; ++i2) {
                            if (cArray[i2] == '.') continue;
                            stringBuffer.append(cArray[i2]);
                        }
                        stringBuffer.append("ServiceConstants");
                        try {
                            Class clazz = Class.forName(stringBuffer.toString());
                            this.registerDevice(clazz);
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            ServiceManager.errorHandler.handleError(classNotFoundException);
                        }
                    }
                }
            }
            catch (IOException iOException) {
                ServiceManager.errorHandler.handleError(iOException);
            }
        }
    }

    public void registerDevice(Class clazz) {
        Field[] fieldArray = clazz.getFields();
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        string = string.substring(n);
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            try {
                int n2 = fieldArray[i2].getInt(null);
                String string2 = new StringBuffer().append(string).append(".").append(fieldArray[i2].getName()).toString();
                if (!"ASL_TARGET_ID".equals(string2)) {
                    this.eventMapIdName.put(new Integer(n2), string2);
                }
                this.addObserver(n2);
                continue;
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleStartupError(exception);
            }
        }
    }

    protected void printEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        String string = (String)this.eventMapIdName.get(new Integer(n));
        this.warn().append("AslEventPrinter:").append(string).append(":").append(n).append("(").append(eventGeneric.getParamCount()).append(")").log();
    }
}

