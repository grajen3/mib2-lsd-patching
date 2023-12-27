/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlCallbackListRequest;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListEntry;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserList;
import de.vw.mib.asl.internal.mediacontrol.browser.transformer.MediaControlBrowserListTransformerEntry;
import de.vw.mib.util.Util;

class BrowserList$1
implements MediaControlCallbackListRequest {
    private final /* synthetic */ BrowserList this$0;

    BrowserList$1(BrowserList browserList) {
        this.this$0 = browserList;
    }

    @Override
    public void responseList(MediaControlListEntry[] mediaControlListEntryArray, int n, MediaControlResultCode mediaControlResultCode) {
        Object[] objectArray = new MediaControlBrowserListTransformerEntry[]{};
        if (!Util.isNullOrEmpty(mediaControlListEntryArray)) {
            objectArray = new MediaControlBrowserListTransformerEntry[mediaControlListEntryArray.length];
            for (int i2 = 0; i2 < mediaControlListEntryArray.length; ++i2) {
                objectArray[i2] = new MediaControlBrowserListTransformerEntry();
                ((MediaControlBrowserListTransformerEntry)objectArray[i2]).id = mediaControlListEntryArray[i2].getEntryId();
                ((MediaControlBrowserListTransformerEntry)objectArray[i2]).contentType = BrowserList.access$100(this.this$0, mediaControlListEntryArray[i2].getContentType(), BrowserList.access$000(this.this$0), mediaControlListEntryArray[i2].getTitle());
                ((MediaControlBrowserListTransformerEntry)objectArray[i2]).name = mediaControlListEntryArray[i2].getTitle();
                ((MediaControlBrowserListTransformerEntry)objectArray[i2]).active = false;
            }
        }
        BrowserList.access$200().updateListItems(n, objectArray);
    }
}

