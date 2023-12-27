/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class AudioChannel {
    public int id;
    public String language;
    public int format;
    public int description;

    public int getId() {
        return this.id;
    }

    public void setId(int n) {
        this.id = n;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String string) {
        this.language = string;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int n) {
        this.format = n;
    }

    public int getDescription() {
        return this.description;
    }

    public void setDescription(int n) {
        this.description = n;
    }

    public AudioChannel() {
    }

    public AudioChannel(int n, String string, int n2, int n3) {
        this.id = n;
        this.language = string;
        this.format = n2;
        this.description = n3;
    }

    public String toString() {
        return new StringBuffer("AudioChannel{").append("id=").append(this.id).append(", language=").append(this.language).append(", format=").append(this.format).append(", description=").append(this.description).append("}").toString();
    }
}

