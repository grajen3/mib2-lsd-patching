/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.internal.pictureviewer.PictureViewer;

public final class PictureViewer$PictureFile {
    String[] path = null;
    int elementIndex = -1;
    private final /* synthetic */ PictureViewer this$0;

    PictureViewer$PictureFile(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
        this.reset();
    }

    public boolean isValid() {
        return this.getPath() != null && this.getElementIndex() > -1;
    }

    public void reset() {
        this.elementIndex = -1;
        this.this$0.getHmiNotifier().notifyActiveBrowserInfoListItem(this.elementIndex);
    }

    public String[] getPath() {
        return this.path;
    }

    public int getElementIndex() {
        return this.elementIndex;
    }

    public void setElementIndex(int n) {
        this.elementIndex = n;
        this.this$0.getHmiNotifier().notifyActiveBrowserInfoListItem(n);
    }

    public void setPath(String[] stringArray) {
        this.path = stringArray;
    }

    public void restoreFromSettings() {
        this.path = this.this$0.getSettings().getPicturePath();
        this.elementIndex = this.this$0.getSettings().getPictureIndex();
    }
}

