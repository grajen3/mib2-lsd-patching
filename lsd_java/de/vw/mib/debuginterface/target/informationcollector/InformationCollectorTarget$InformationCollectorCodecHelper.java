/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target.informationcollector;

import de.vw.mib.debug.service.debuginterface.informationcollector.InformationCollectorTargetCodecListener;
import de.vw.mib.debug.service.debuginterface.mapfileservice.MapFileServiceTargetCodecListener;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.target.informationcollector.InformationCollectorTarget;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.dsi.ifc.VersionInfo;

class InformationCollectorTarget$InformationCollectorCodecHelper
implements InformationCollectorTargetCodecListener,
MapFileServiceTargetCodecListener {
    private final /* synthetic */ InformationCollectorTarget this$0;

    public InformationCollectorTarget$InformationCollectorCodecHelper(InformationCollectorTarget informationCollectorTarget) {
        this.this$0 = informationCollectorTarget;
    }

    @Override
    public void getTestInterfaceAvailable() {
        this.this$0.codec.encodeResponseTestInterfaceAvailable(this.this$0.getBinaryMessage((short)104), this.this$0.testInterfaceAvailable).send();
    }

    @Override
    public void getTargetBaseVersion() {
        this.this$0.codec.encodeResponseBaseVersion(this.this$0.getBinaryMessage((short)104), ServiceManager.configurationManager.getHmiSoftwareBaseVersion()).send();
    }

    @Override
    public void getTargetVersion() {
        this.this$0.codec.encodeResponseVersion(this.this$0.getBinaryMessage((short)104), ServiceManager.configurationManager.getHmiSoftwareVersion()).send();
    }

    @Override
    public void getLanguage() {
        this.this$0.codec.encodeResponseLanguage(this.this$0.getBinaryMessage((short)104), ServiceManager.configurationManager.getCurrentGuiLanguage()).send();
    }

    @Override
    public void getSkinShortVersion() {
        this.this$0.codec.encodeResponseSkinVersion(this.this$0.getBinaryMessage((short)104), ServiceManager.configurationManager.getSkinShortVersion()).send();
    }

    @Override
    public void getTargetProtocolVersion() {
        this.this$0.codec.encodeResponseProtocolVersion(this.this$0.getBinaryMessage((short)104), "1.2").send();
    }

    @Override
    public void getDebugInfoFiles(int n, boolean bl) {
        this.this$0.mapFileCodec.encodeResponseDebugInfoFiles(this.this$0.getBinaryMessage((short)104), this.this$0.startDebugInfoFilesArchiveProvider(n, bl)).send();
    }

    @Override
    public void getHMIEventMap() {
        this.this$0.mapFileCodec.encodeResponseHMIEventMap(this.this$0.getBinaryMessage((short)104), this.getInfoFile("eventMap.zip")).send();
    }

    @Override
    public void getDatapoolMap() {
        this.this$0.mapFileCodec.encodeResponseDatapoolMap(this.this$0.getBinaryMessage((short)104), this.getInfoFile("targetDatapool.zip")).send();
    }

    @Override
    public void getDSIVersion() {
        this.this$0.codec.encodeResponseDsiVersion(this.this$0.getBinaryMessage((short)104), VersionInfo.getVersion()).send();
    }

    @Override
    public void getSoftwareMUPartNumber() {
        this.this$0.codec.encodeSoftwareMUPartNumber(this.this$0.getBinaryMessage((short)104), ServiceManager.configurationManager.getSoftwareMuPartNumber()).send();
    }

    @Override
    public void getPartNumber() {
        this.this$0.codec.encodeResponsePartNumber(this.this$0.getBinaryMessage((short)104), ServiceManager.configurationManager.getPartNumber()).send();
    }

    private byte[] getInfoFile(String string) {
        byte[] byArray;
        InputStream inputStream = super.getClass().getResourceAsStream(new StringBuffer().append("/").append(string).toString());
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int n;
            int n2 = inputStream.available();
            while ((n = inputStream.read()) != -1) {
                byteArrayOutputStream.write((char)n);
            }
            byteArrayOutputStream.flush();
            inputStream.close();
            byteArrayOutputStream.close();
            byArray = byteArrayOutputStream.toByteArray();
            if (n2 != byArray.length) {
                throw new IOException(new StringBuffer().append("error while preparing info file to send - filesize: ").append(n2).append(" <> data length:").append(byArray.length).toString());
            }
        }
        catch (IOException iOException) {
            return new byte[0];
        }
        return byArray;
    }
}

