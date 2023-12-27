/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;
import org.dsi.ifc.global.ResourceLocator;

public class TrackInfoContainerImpl
extends AbstractContainer
implements TrackInfoContainer {
    private static final byte ELEMENT_TITLE;
    private static final byte ELEMENT_ARTIST;
    private static final byte ELEMENT_ALBUM;
    private static final byte ELEMENT_COVER;
    private static final byte ELEMENT_LENGTH;
    private static final byte ELEMENT_TRACK_NUMBER;
    private String attrTitle;
    private String attrArtist;
    private String attrAlbum;
    private ResourceLocator attrCover;
    private int attrLength;
    private int attrTrackNumber;

    @Override
    public int getContainerId() {
        return 22;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getTitle() {
        return this.attrTitle;
    }

    @Override
    public String getArtist() {
        return this.attrArtist;
    }

    @Override
    public String getAlbum() {
        return this.attrAlbum;
    }

    @Override
    public ResourceLocator getCover() {
        return this.attrCover;
    }

    @Override
    public int getLength() {
        return this.attrLength;
    }

    @Override
    public int getTrackNumber() {
        return this.attrTrackNumber;
    }

    @Override
    public boolean isTitleSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isArtistSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isAlbumSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isCoverSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isLengthSet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public boolean isTrackNumberSet() {
        return this._isElementSet((byte)5);
    }

    @Override
    public void setTitle(String string) {
        this.attrTitle = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setArtist(String string) {
        this.attrArtist = string;
        this._setElement((byte)1, null != string);
    }

    @Override
    public void setAlbum(String string) {
        this.attrAlbum = string;
        this._setElement((byte)2, null != string);
    }

    @Override
    public void setCover(ResourceLocator resourceLocator) {
        this.attrCover = resourceLocator;
        this._setElement((byte)3, null != resourceLocator);
    }

    @Override
    public void setLength(int n) {
        this.attrLength = n;
        this._setElement((byte)4, true);
    }

    @Override
    public void setTrackNumber(int n) {
        this.attrTrackNumber = n;
        this._setElement((byte)5, true);
    }

    @Override
    public void unsetTitle() {
        this.attrTitle = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetArtist() {
        this.attrArtist = null;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetAlbum() {
        this.attrAlbum = null;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetCover() {
        this.attrCover = null;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetLength() {
        this.attrLength = 0;
        this._setElement((byte)4, false);
    }

    @Override
    public void unsetTrackNumber() {
        this.attrTrackNumber = 0;
        this._setElement((byte)5, false);
    }
}

