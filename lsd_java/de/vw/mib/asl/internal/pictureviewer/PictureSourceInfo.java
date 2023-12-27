/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import java.util.Arrays;

public final class PictureSourceInfo {
    public static PictureSourceInfo NONE = new PictureSourceInfo();
    private static final int INVALID_PICTURE_INDEX;
    private final int _hmiSourceId;
    private final String _uniqueMediaID;
    private final String[] _picturePath;
    private final int _pictureIndex;

    private PictureSourceInfo() {
        this(0, "", null, -1);
    }

    public PictureSourceInfo(int n, String string, String[] stringArray, int n2) {
        this._hmiSourceId = n;
        this._uniqueMediaID = string;
        this._picturePath = stringArray;
        this._pictureIndex = n2;
    }

    public PictureSourceInfo(PersistenceInputStream persistenceInputStream) {
        this._hmiSourceId = persistenceInputStream.readInt();
        this._uniqueMediaID = persistenceInputStream.readString();
        int n = persistenceInputStream.readInt();
        if (n >= 0) {
            this._picturePath = new String[n];
            for (int i2 = 0; i2 < n; ++i2) {
                this._picturePath[i2] = persistenceInputStream.readString();
            }
        } else {
            this._picturePath = null;
        }
        this._pictureIndex = persistenceInputStream.readInt();
    }

    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeInt(this._hmiSourceId);
        persistenceOutputStream.writeString(this._uniqueMediaID);
        if (this._picturePath == null) {
            persistenceOutputStream.writeInt(-1);
        } else {
            persistenceOutputStream.writeInt(this._picturePath.length);
            if (this._picturePath.length > 0) {
                for (int i2 = 0; i2 < this._picturePath.length; ++i2) {
                    persistenceOutputStream.writeString(this._picturePath[i2]);
                }
            }
        }
        persistenceOutputStream.writeInt(this._pictureIndex);
    }

    public int getHMISourceId() {
        return this._hmiSourceId;
    }

    public String getUniqueMediaID() {
        return this._uniqueMediaID;
    }

    public String[] getPicturePath() {
        return this._picturePath;
    }

    public int getPictureIndex() {
        return this._pictureIndex;
    }

    public String toString() {
        return new StringBuffer().append("PictureSourceInfo [_hmiSourceId=").append(this._hmiSourceId).append(", _uniqueMediaID=").append(this._uniqueMediaID).append(", _picturePath=").append(this._picturePath != null ? Arrays.asList(this._picturePath) : null).append(", _pictureIndex=").append(this._pictureIndex).append("]").toString();
    }
}

