/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target.informationcollector;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.informationcollector.InformationCollectorTargetCodec;
import de.vw.mib.debug.service.debuginterface.mapfileservice.MapfileServiceTargetCodec;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.target.AbstractDebugTarget;
import de.vw.mib.debuginterface.target.informationcollector.InformationCollectorTarget$InformationCollectorCodecHelper;
import de.vw.mib.debuginterface.util.DebugInfoFilesArchiveProvider;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

public class InformationCollectorTarget
extends AbstractDebugTarget {
    private static final String HMIEVENTMAP_ZIP_FILE;
    private static final String TARGET_DATA_POOL_FILE;
    final boolean testInterfaceAvailable;
    final InformationCollectorTargetCodec codec = new InformationCollectorTargetCodec();
    final MapfileServiceTargetCodec mapFileCodec = new MapfileServiceTargetCodec();
    private final InformationCollectorTarget$InformationCollectorCodecHelper codecHelper = new InformationCollectorTarget$InformationCollectorCodecHelper(this);

    public InformationCollectorTarget(boolean bl) {
        super((short)104);
        this.testInterfaceAvailable = bl;
    }

    @Override
    public void messageDecoded(short s, ByteArrayReader byteArrayReader) {
        try {
            this.codec.decode(byteArrayReader, this.codecHelper);
        }
        catch (IOException iOException) {
            this.logger.error(1, "[InformationCollectorTarget] Unable to decode message", iOException);
        }
    }

    boolean startDebugInfoFilesArchiveProvider(int n, boolean bl) {
        String string = this.findDebugInfoFileArchiveInClasspath();
        if (string != null) {
            DebugInfoFilesArchiveProvider debugInfoFilesArchiveProvider = new DebugInfoFilesArchiveProvider(n, new File(string), bl);
            return debugInfoFilesArchiveProvider.isSocketOpen();
        }
        return false;
    }

    private String findDebugInfoFileArchiveInClasspath() {
        String string = System.getProperty("java.class.path");
        string = new StringBuffer().append(string).append(File.separator).append(System.getProperty("com.ibm.oti.system.class.path")).toString();
        StringTokenizer stringTokenizer = new StringTokenizer(string, File.pathSeparator);
        String string2 = ServiceManager.configurationManager.getPureHmiBaseVersion();
        String string3 = ServiceManager.configurationManager.getPureVariant();
        String string4 = new StringBuffer().append("MIBTestDebug-").append(string2).append("-").append(string3).toString();
        while (stringTokenizer.hasMoreTokens()) {
            String string5 = stringTokenizer.nextToken();
            if (string5.indexOf(string4) < 0) continue;
            return string5;
        }
        return null;
    }
}

