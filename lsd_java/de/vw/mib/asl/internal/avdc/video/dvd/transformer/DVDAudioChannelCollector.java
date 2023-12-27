/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.video.dvd.transformer;

public class DVDAudioChannelCollector {
    public int languageCode = 0;
    public int numChannels = 2;
    public int audioCoding = 0;
    public int samplingRate = 0;
    public int audioLanguageExtension = 0;

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.languageCode;
        n2 = 31 * n2 + this.numChannels;
        n2 = 31 * n2 + this.audioCoding;
        n2 = 31 * n2 + this.samplingRate;
        n2 = 31 * n2 + this.audioLanguageExtension;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!super.getClass().equals(object.getClass())) {
            return false;
        }
        DVDAudioChannelCollector dVDAudioChannelCollector = (DVDAudioChannelCollector)object;
        if (this.languageCode != dVDAudioChannelCollector.languageCode) {
            return false;
        }
        if (this.numChannels != dVDAudioChannelCollector.numChannels) {
            return false;
        }
        if (this.audioCoding != dVDAudioChannelCollector.audioCoding) {
            return false;
        }
        if (this.samplingRate != dVDAudioChannelCollector.samplingRate) {
            return false;
        }
        return this.audioLanguageExtension == dVDAudioChannelCollector.audioLanguageExtension;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("DVDAudioChannelCollector");
        stringBuffer.append('(');
        stringBuffer.append("languageCode");
        stringBuffer.append('=');
        stringBuffer.append(this.languageCode);
        stringBuffer.append(",");
        stringBuffer.append("numChannels");
        stringBuffer.append('=');
        stringBuffer.append(this.numChannels);
        stringBuffer.append(",");
        stringBuffer.append("audioCoding");
        stringBuffer.append('=');
        stringBuffer.append(this.audioCoding);
        stringBuffer.append(",");
        stringBuffer.append("samplingRate");
        stringBuffer.append('=');
        stringBuffer.append(this.samplingRate);
        stringBuffer.append(",");
        stringBuffer.append("audioLanguageExtension");
        stringBuffer.append('=');
        stringBuffer.append(this.audioLanguageExtension);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

