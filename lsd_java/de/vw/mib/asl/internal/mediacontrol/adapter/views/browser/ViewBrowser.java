/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerInvalidBrowserPath;
import de.vw.mib.asl.internal.mediacontrol.adapter.common.ModelView;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserList;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserListState;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.TitleBar;
import de.vw.mib.genericevents.EventGeneric;

public class ViewBrowser
implements ModelView,
MediaControlListenerInvalidBrowserPath {
    private final MediaControlAPI mMediaControlAPI;
    private static int[] ACTIONS = new int[]{-1208396224, -1392945600};

    @Override
    public int[] getSupportedActions() {
        return ACTIONS;
    }

    public ViewBrowser(MediaControlAPI mediaControlAPI) {
        this.mMediaControlAPI = mediaControlAPI;
        this.mMediaControlAPI.getBrowserService().addInvalidBrowsePathListener(this);
        new TitleBar(mediaControlAPI);
        new BrowserList(mediaControlAPI);
        new BrowserListState(mediaControlAPI);
    }

    @Override
    public void handleAction(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 1079441847: {
                String string = eventGeneric.getString(0);
                int n = eventGeneric.getInt(1);
                int n2 = this.getClientApiContentType(n);
                this.mMediaControlAPI.getBrowserService().openFolder(string, n2, MediaControlCallback.NOP);
                break;
            }
            case 1079441836: {
                int n = eventGeneric.getInt(0);
                switch (n) {
                    case 0: {
                        this.mMediaControlAPI.getBrowserService().openDeviceSelection(MediaControlCallback.NOP);
                        break block0;
                    }
                    case 1: {
                        this.mMediaControlAPI.getBrowserService().openDeviceRoot(MediaControlCallback.NOP);
                        break block0;
                    }
                    case 2: {
                        this.mMediaControlAPI.getBrowserService().moveFolderLevelUp(1, MediaControlCallback.NOP);
                        break block0;
                    }
                    case 3: {
                        this.mMediaControlAPI.getBrowserService().moveFolderLevelUp(2, MediaControlCallback.NOP);
                        break block0;
                    }
                }
                break;
            }
        }
    }

    private int getClientApiContentType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: 
            case 24: {
                return 1;
            }
            case 2: 
            case 25: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: 
            case 23: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 12: {
                return 12;
            }
            case 13: 
            case 26: 
            case 27: {
                return 13;
            }
            case 14: 
            case 28: 
            case 29: {
                return 14;
            }
            case 15: {
                return 15;
            }
            case 16: 
            case 30: 
            case 31: {
                return 16;
            }
            case 17: {
                return 17;
            }
            case 18: {
                return 18;
            }
            case 19: {
                return 19;
            }
            case 20: {
                return 20;
            }
            case 21: {
                return 21;
            }
            case 22: {
                return 22;
            }
        }
        return 0;
    }

    @Override
    public void indicateInvalidBrowsePath() {
        this.mMediaControlAPI.getBrowserService().openDeviceSelection(MediaControlCallback.NOP);
    }
}

