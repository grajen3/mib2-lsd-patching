/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioTextContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioTextContainerImpl
extends AbstractContainer
implements RadioTextContainer {
    private static final byte ELEMENT_RADIO_TEXT;
    private static final byte ELEMENT_ARTIST;
    private static final byte ELEMENT_ALBUM;
    private static final byte ELEMENT_TITLE;
    private static final byte ELEMENT_RADIO_IMAGE;
    private static final byte ELEMENT_RADIO_IMAGE_AVAILABLE;
    private String attrRadioText;
    private String attrArtist;
    private String attrAlbum;
    private String attrTitle;
    private ResourceLocator attrRadioImage;
    private boolean attrRadioImageAvailable;

    @Override
    public int getContainerId() {
        return 52;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getRadioText() {
        return this.attrRadioText;
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
    public String getTitle() {
        return this.attrTitle;
    }

    @Override
    public ResourceLocator getRadioImage() {
        return this.attrRadioImage;
    }

    @Override
    public boolean getRadioImageAvailable() {
        return this.attrRadioImageAvailable;
    }

    @Override
    public boolean isRadioTextSet() {
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
    public boolean isTitleSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isRadioImageSet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public boolean isRadioImageAvailableSet() {
        return this._isElementSet((byte)5);
    }

    @Override
    public void setRadioText(String string) {
        this.attrRadioText = string;
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
    public void setTitle(String string) {
        this.attrTitle = string;
        this._setElement((byte)3, null != string);
    }

    @Override
    public void setRadioImage(ResourceLocator resourceLocator) {
        this.attrRadioImage = resourceLocator;
        this._setElement((byte)4, null != resourceLocator);
    }

    @Override
    public void setRadioImageAvailable(boolean bl) {
        this.attrRadioImageAvailable = bl;
        this._setElement((byte)5, true);
    }

    @Override
    public void unsetRadioText() {
        this.attrRadioText = null;
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
    public void unsetTitle() {
        this.attrTitle = null;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetRadioImage() {
        this.attrRadioImage = null;
        this._setElement((byte)4, false);
    }

    @Override
    public void unsetRadioImageAvailable() {
        this.attrRadioImageAvailable = false;
        this._setElement((byte)5, false);
    }
}

