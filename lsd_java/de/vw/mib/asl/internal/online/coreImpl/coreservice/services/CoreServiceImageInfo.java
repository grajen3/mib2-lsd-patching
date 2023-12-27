/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceImageInfo
implements Persistable {
    private String _imageURL;
    private String _imageCheckSum;
    private int _category;
    private String _filePath;
    private ResourceLocator _resourceLocator;

    public CoreServiceImageInfo(String string, String string2, String string3) {
        this._imageURL = string;
        this._imageCheckSum = string2 == null ? "" : string2;
        this._category = -1;
        this._filePath = string3;
        this._resourceLocator = null;
    }

    public CoreServiceImageInfo(String string, String string2, String string3, int n, ResourceLocator resourceLocator) {
        this._imageURL = string;
        this._imageCheckSum = string2 == null ? "" : string2;
        this._filePath = string3;
        this._category = n;
        this._resourceLocator = resourceLocator;
    }

    public CoreServiceImageInfo(PersistenceInputStream persistenceInputStream) {
        this.fromStream(persistenceInputStream);
        this._resourceLocator = null;
    }

    @Override
    public void clear() {
        this._imageURL = "";
        this._imageCheckSum = "";
        this._category = -1;
        this._filePath = "";
        this._resourceLocator = null;
    }

    @Override
    public void fromStream(PersistenceInputStream persistenceInputStream) {
        this._category = persistenceInputStream.readInt();
        this._imageURL = persistenceInputStream.readString();
        this._imageCheckSum = persistenceInputStream.readString();
        this._filePath = persistenceInputStream.readString();
    }

    @Override
    public void toStream(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeInt(this._category);
        persistenceOutputStream.writeString(this._imageURL);
        persistenceOutputStream.writeString(this._imageCheckSum);
        persistenceOutputStream.writeString(this._filePath);
    }

    public void setImageUrl(String string) {
        this._imageURL = string;
    }

    public String getImageUrl() {
        return this._imageURL;
    }

    public void setImageCheckSum(String string) {
        this._imageCheckSum = string;
    }

    public String getImageCheckSum() {
        return this._imageCheckSum;
    }

    public int getCategory() {
        return this._category;
    }

    public void setCategory(int n) {
        this._category = n;
    }

    public String getFilePath() {
        return this._filePath;
    }

    public void setFilePath(String string) {
        this._filePath = string;
    }

    public void setResourceLocator(ResourceLocator resourceLocator) {
        this._resourceLocator = resourceLocator;
    }

    public ResourceLocator getResourceLocator() {
        return this._resourceLocator;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("OnlineCoreServicesImageInfo");
        stringBuffer.append('(');
        stringBuffer.append("ImageURL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._imageURL) ? "NULL" : this._imageURL);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._category);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ImageCheckSum");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._imageCheckSum) ? "NULL" : this._imageCheckSum);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("FilePath");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._filePath) ? "NULL" : this._filePath);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ResourceLocator");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._resourceLocator != null ? this._resourceLocator.toString() : "NULL");
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

