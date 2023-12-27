/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class VisualizationConfig {
    public boolean sitzlaengsverstellung;
    public boolean sitzhoehenverstellung;
    public boolean sitzneigungsverstellung;
    public boolean lehnenneigungsverstellung;
    public boolean kopfstuetzenhoehenverstellung;
    public boolean lordosenweitenverstellung;
    public boolean lordosenhoehenverstellung;
    public boolean sitztiefenverstellung;
    public boolean lehnenkopfverstellung;
    public boolean gurthoehenverstellung;
    public boolean lehnenwangenverstellung;
    public boolean sitzflaechenwangenverstellung;
    public boolean kopfstuetzenlaengsverstellung;
    public boolean fussstuetzenhoehe;
    public boolean rseAufnahmehoehe;
    public boolean rseAufnahmetiefe;
    public boolean fussmattenhoehe;
    public boolean rseDisplay;

    public VisualizationConfig() {
        this.sitzlaengsverstellung = false;
        this.sitzhoehenverstellung = false;
        this.sitzneigungsverstellung = false;
        this.lehnenneigungsverstellung = false;
        this.kopfstuetzenhoehenverstellung = false;
        this.lordosenweitenverstellung = false;
        this.lordosenhoehenverstellung = false;
        this.sitztiefenverstellung = false;
        this.lehnenkopfverstellung = false;
        this.gurthoehenverstellung = false;
        this.lehnenwangenverstellung = false;
        this.sitzflaechenwangenverstellung = false;
        this.kopfstuetzenlaengsverstellung = false;
        this.fussstuetzenhoehe = false;
        this.rseAufnahmehoehe = false;
        this.rseAufnahmetiefe = false;
        this.fussmattenhoehe = false;
        this.rseDisplay = false;
    }

    public VisualizationConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13) {
        this.sitzlaengsverstellung = bl;
        this.sitzhoehenverstellung = bl2;
        this.sitzneigungsverstellung = bl3;
        this.lehnenneigungsverstellung = bl4;
        this.kopfstuetzenhoehenverstellung = bl5;
        this.lordosenweitenverstellung = bl6;
        this.lordosenhoehenverstellung = bl7;
        this.sitztiefenverstellung = bl8;
        this.lehnenkopfverstellung = bl9;
        this.gurthoehenverstellung = bl10;
        this.lehnenwangenverstellung = bl11;
        this.sitzflaechenwangenverstellung = bl12;
        this.kopfstuetzenlaengsverstellung = bl13;
        this.fussstuetzenhoehe = false;
        this.rseAufnahmehoehe = false;
        this.rseAufnahmetiefe = false;
        this.fussmattenhoehe = false;
        this.rseDisplay = false;
    }

    public VisualizationConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18) {
        this.sitzlaengsverstellung = bl;
        this.sitzhoehenverstellung = bl2;
        this.sitzneigungsverstellung = bl3;
        this.lehnenneigungsverstellung = bl4;
        this.kopfstuetzenhoehenverstellung = bl5;
        this.lordosenweitenverstellung = bl6;
        this.lordosenhoehenverstellung = bl7;
        this.sitztiefenverstellung = bl8;
        this.lehnenkopfverstellung = bl9;
        this.gurthoehenverstellung = bl10;
        this.lehnenwangenverstellung = bl11;
        this.sitzflaechenwangenverstellung = bl12;
        this.kopfstuetzenlaengsverstellung = bl13;
        this.fussstuetzenhoehe = bl14;
        this.rseAufnahmehoehe = bl15;
        this.rseAufnahmetiefe = bl16;
        this.fussmattenhoehe = bl17;
        this.rseDisplay = bl18;
    }

    public boolean isSitzlaengsverstellung() {
        return this.sitzlaengsverstellung;
    }

    public boolean isSitzhoehenverstellung() {
        return this.sitzhoehenverstellung;
    }

    public boolean isSitzneigungsverstellung() {
        return this.sitzneigungsverstellung;
    }

    public boolean isLehnenneigungsverstellung() {
        return this.lehnenneigungsverstellung;
    }

    public boolean isKopfstuetzenhoehenverstellung() {
        return this.kopfstuetzenhoehenverstellung;
    }

    public boolean isLordosenweitenverstellung() {
        return this.lordosenweitenverstellung;
    }

    public boolean isLordosenhoehenverstellung() {
        return this.lordosenhoehenverstellung;
    }

    public boolean isSitztiefenverstellung() {
        return this.sitztiefenverstellung;
    }

    public boolean isLehnenkopfverstellung() {
        return this.lehnenkopfverstellung;
    }

    public boolean isGurthoehenverstellung() {
        return this.gurthoehenverstellung;
    }

    public boolean isLehnenwangenverstellung() {
        return this.lehnenwangenverstellung;
    }

    public boolean isSitzflaechenwangenverstellung() {
        return this.sitzflaechenwangenverstellung;
    }

    public boolean isKopfstuetzenlaengsverstellung() {
        return this.kopfstuetzenlaengsverstellung;
    }

    public boolean isFussstuetzenhoehe() {
        return this.fussstuetzenhoehe;
    }

    public boolean isRseAufnahmehoehe() {
        return this.rseAufnahmehoehe;
    }

    public boolean isRseAufnahmetiefe() {
        return this.rseAufnahmetiefe;
    }

    public boolean isFussmattenhoehe() {
        return this.fussmattenhoehe;
    }

    public boolean isRseDisplay() {
        return this.rseDisplay;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("VisualizationConfig");
        stringBuffer.append('(');
        stringBuffer.append("sitzlaengsverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzlaengsverstellung);
        stringBuffer.append(',');
        stringBuffer.append("sitzhoehenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzhoehenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("sitzneigungsverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzneigungsverstellung);
        stringBuffer.append(',');
        stringBuffer.append("lehnenneigungsverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenneigungsverstellung);
        stringBuffer.append(',');
        stringBuffer.append("kopfstuetzenhoehenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.kopfstuetzenhoehenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("lordosenweitenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.lordosenweitenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("lordosenhoehenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.lordosenhoehenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("sitztiefenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitztiefenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("lehnenkopfverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenkopfverstellung);
        stringBuffer.append(',');
        stringBuffer.append("gurthoehenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.gurthoehenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("lehnenwangenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenwangenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("sitzflaechenwangenverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzflaechenwangenverstellung);
        stringBuffer.append(',');
        stringBuffer.append("kopfstuetzenlaengsverstellung");
        stringBuffer.append('=');
        stringBuffer.append(this.kopfstuetzenlaengsverstellung);
        stringBuffer.append(',');
        stringBuffer.append("fussstuetzenhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.fussstuetzenhoehe);
        stringBuffer.append(',');
        stringBuffer.append("rseAufnahmehoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.rseAufnahmehoehe);
        stringBuffer.append(',');
        stringBuffer.append("rseAufnahmetiefe");
        stringBuffer.append('=');
        stringBuffer.append(this.rseAufnahmetiefe);
        stringBuffer.append(',');
        stringBuffer.append("fussmattenhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.fussmattenhoehe);
        stringBuffer.append(',');
        stringBuffer.append("rseDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.rseDisplay);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

