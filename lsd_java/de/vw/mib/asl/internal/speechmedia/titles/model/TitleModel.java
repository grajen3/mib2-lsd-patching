/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.model;

import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import org.dsi.ifc.global.ResourceLocator;

public class TitleModel {
    public static final int TYPE_CORRECT;
    public static final int TYPE_UNKNOWN;
    public static final int TYPE_VARIOUS;
    public long id;
    public String titleName;
    public int titleType;
    public String artistName;
    public int artistType;
    public String albumName;
    public int albumType;
    public String genre;
    public int genreType;
    public String value;
    public int numberOfSubitems;
    public ResourceLocator cover;
    public MediaEntry mediaEntry;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("TitleModel [");
        stringBuffer.append("id=");
        stringBuffer.append(this.id);
        stringBuffer.append(", ");
        stringBuffer.append("titleName=");
        stringBuffer.append(this.titleName);
        stringBuffer.append(", ");
        stringBuffer.append("titleType=");
        stringBuffer.append(this.titleType);
        stringBuffer.append(", ");
        stringBuffer.append("artistName=");
        stringBuffer.append(this.artistName);
        stringBuffer.append(", ");
        stringBuffer.append("artistType=");
        stringBuffer.append(this.artistType);
        stringBuffer.append(", ");
        stringBuffer.append("albumName=");
        stringBuffer.append(this.albumName);
        stringBuffer.append(", ");
        stringBuffer.append("albumType=");
        stringBuffer.append(this.albumType);
        stringBuffer.append(", ");
        stringBuffer.append("genre=");
        stringBuffer.append(this.genre);
        stringBuffer.append(", ");
        stringBuffer.append("genreType=");
        stringBuffer.append(this.genreType);
        stringBuffer.append(", ");
        stringBuffer.append("value=");
        stringBuffer.append(this.value);
        stringBuffer.append(", ");
        stringBuffer.append("numberOfSubitems=");
        stringBuffer.append(this.numberOfSubitems);
        stringBuffer.append(", ");
        stringBuffer.append("cover=");
        if (this.cover == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(this.cover.url);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

