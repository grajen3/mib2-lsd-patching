/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.diag;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.diag.DiagDataListCollector;
import de.vw.mib.file.FileManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import org.osgi.framework.BundleContext;

public class AslDiagGenericFetcher {
    private static final String LOGGING_DELIM;
    private static final int YES;
    private static final int NO;
    private final AslTargetSystemFeaturesAndCoding myTarget = SystemAccessor.getFeaturesAndCodingTarget();
    private final String mReturnPath;
    private final Class mCl;
    private final Access mObj;
    private Object[] metadata;
    private DiagDataListCollector[] collector;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;

    public AslDiagGenericFetcher(String string, Class clazz, Access access) {
        this.mReturnPath = string;
        this.mCl = clazz;
        this.mObj = access;
        this.metadata = null;
        this.collector = null;
        this.readFromSwapper();
        this.parseMetadata();
    }

    DiagDataListCollector[] getCollector() {
        return this.collector;
    }

    private int getIdentifier(String string) {
        try {
            Field field = this.mCl.getDeclaredField(string);
            try {
                return field.getInt(null);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.myTarget.error(illegalArgumentException);
            }
            catch (IllegalAccessException illegalAccessException) {
                this.myTarget.error(illegalAccessException);
            }
        }
        catch (SecurityException securityException) {
            this.myTarget.error(securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            this.myTarget.error(noSuchFieldException);
        }
        return -1;
    }

    protected boolean getBoolean(String string) {
        int n = this.getIdentifier(string);
        if (this.mObj.contains(n)) {
            return this.mObj.getBoolean(n);
        }
        return false;
    }

    protected int getValue(String string) {
        int n = this.getIdentifier(string);
        if (this.mObj.contains(n)) {
            return this.mObj.getValue(n);
        }
        return -1;
    }

    private void readFromSwapper() {
        BundleContext bundleContext = ServiceManager.bundleContext;
        FileManager fileManager = (FileManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = AslDiagGenericFetcher.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName()));
        if (fileManager == null) {
            this.myTarget.error().append("[AslDiagGenericFetcher] ").append("Service 'de.vw.mib.file.spi.FileManager' not available.").log();
        } else {
            File file = new File(this.mReturnPath);
            if (file.exists()) {
                try {
                    this.metadata = fileManager.readDataFromObjectSwapperFile(file);
                }
                catch (IOException iOException) {
                    this.myTarget.error(iOException);
                }
            } else {
                this.myTarget.error().append("[AslDiagGenericFetcher] ").append("File ").append(this.mReturnPath).append(" does not exist!").log();
            }
        }
    }

    private void parseMetadata() {
        boolean bl = false;
        if (this.metadata != null) {
            int n = this.metadata.length;
            this.collector = new DiagDataListCollector[n];
            try {
                for (int i2 = 0; i2 < n; ++i2) {
                    String[] stringArray = (String[])this.metadata[i2];
                    String string = stringArray[2];
                    String string2 = stringArray[3];
                    int n2 = 0;
                    String string3 = "";
                    if (string.equals("int")) {
                        n2 = this.getValue(string2);
                    } else if (string.equals("bool")) {
                        n2 = this.getBoolean(string2) ? 1 : 0;
                    }
                    int n3 = Integer.decode(stringArray[4]);
                    for (int i3 = 0; i3 < n3; ++i3) {
                        String string4 = stringArray[5 + 2 * i3];
                        String string5 = stringArray[6 + 2 * i3];
                        if (Integer.decode(string4) != n2) continue;
                        string3 = string5;
                        break;
                    }
                    String string6 = stringArray[0];
                    String string7 = stringArray[1];
                    this.collector[i2] = new DiagDataListCollector(string6, string7);
                    this.collector[i2].setValue(Integer.toString(n2));
                    this.collector[i2].setValueDescription(string3);
                }
            }
            catch (Exception exception) {
                this.myTarget.error(exception);
                bl = true;
            }
        } else {
            bl = true;
        }
        if (bl) {
            this.myTarget.error().append("[AslDiagGenericFetcher] ").append("metadata could not be parsed, File: ").append(this.mReturnPath).log();
            this.collector = new DiagDataListCollector[0];
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

