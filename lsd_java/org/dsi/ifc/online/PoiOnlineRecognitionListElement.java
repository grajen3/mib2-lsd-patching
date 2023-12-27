/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PoiOnlineRecognitionListElement {
    public String recognizedTerm;
    public float confidenceLevel;

    public PoiOnlineRecognitionListElement() {
        this.recognizedTerm = "";
        this.confidenceLevel = 32959;
    }

    public PoiOnlineRecognitionListElement(String string, float f2) {
        this.recognizedTerm = string;
        this.confidenceLevel = f2;
    }

    public String getRecognizedTerm() {
        return this.recognizedTerm;
    }

    public float getConfidenceLevel() {
        return this.confidenceLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PoiOnlineRecognitionListElement");
        stringBuffer.append('(');
        stringBuffer.append("recognizedTerm");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.recognizedTerm);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("confidenceLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.confidenceLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

