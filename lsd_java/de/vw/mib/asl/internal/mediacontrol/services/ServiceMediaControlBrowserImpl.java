/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlCallbackListRequest;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerFolderPath;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerInvalidBrowserPath;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListSize;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListState;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlServiceBrowser;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdOpenFolder;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdRequestList;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandQueue;
import de.vw.mib.asl.internal.mediacontrol.services.Components;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl$1;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl$2;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl$3;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl$4;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl$5;

public class ServiceMediaControlBrowserImpl
implements MediaControlServiceBrowser {
    private final CommandQueue mQueue;
    private final Components mComponents;

    public ServiceMediaControlBrowserImpl(CommandQueue commandQueue, Components components) {
        this.mQueue = commandQueue;
        this.mComponents = components;
    }

    @Override
    public void addListStateListener(MediaControlListenerListState mediaControlListenerListState) {
        this.mComponents.getBrowser().getState().addListStateListener(new ServiceMediaControlBrowserImpl$1(this, mediaControlListenerListState));
    }

    @Override
    public void addListSizeListener(MediaControlListenerListSize mediaControlListenerListSize) {
        this.mComponents.getBrowser().getState().addListSizeListener(new ServiceMediaControlBrowserImpl$2(this, mediaControlListenerListSize));
    }

    @Override
    public void addFolderPathListener(MediaControlListenerFolderPath mediaControlListenerFolderPath) {
        this.mComponents.getBrowser().getState().addFolderPathListener(new ServiceMediaControlBrowserImpl$3(this, mediaControlListenerFolderPath));
    }

    @Override
    public void addInvalidBrowsePathListener(MediaControlListenerInvalidBrowserPath mediaControlListenerInvalidBrowserPath) {
        this.mComponents.getBrowser().getState().addInvalidBrowsePathListener(new ServiceMediaControlBrowserImpl$4(this, mediaControlListenerInvalidBrowserPath));
    }

    @Override
    public void openFolder(String string, int n, MediaControlCallback mediaControlCallback) {
        CmdOpenFolder cmdOpenFolder = CmdOpenFolder.createRelativeCmd(this.mComponents.getBrowser(), string, n);
        if (mediaControlCallback != null) {
            cmdOpenFolder.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdOpenFolder);
    }

    @Override
    public void openDeviceSelection(MediaControlCallback mediaControlCallback) {
        CmdOpenFolder cmdOpenFolder = CmdOpenFolder.createOpenDeviceSelectionCmd(this.mComponents.getBrowser());
        if (mediaControlCallback != null) {
            cmdOpenFolder.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdOpenFolder);
    }

    @Override
    public void openDeviceRoot(MediaControlCallback mediaControlCallback) {
        CmdOpenFolder cmdOpenFolder = CmdOpenFolder.createOpenDeviceRootCmd(this.mComponents.getBrowser());
        if (mediaControlCallback != null) {
            cmdOpenFolder.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdOpenFolder);
    }

    @Override
    public void moveFolderLevelUp(int n, MediaControlCallback mediaControlCallback) {
        CmdOpenFolder cmdOpenFolder = CmdOpenFolder.createOpenParentCmd(this.mComponents.getBrowser(), n);
        if (mediaControlCallback != null) {
            cmdOpenFolder.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdOpenFolder);
    }

    @Override
    public void requestList(int n, int n2, MediaControlCallbackListRequest mediaControlCallbackListRequest) {
        ServiceMediaControlBrowserImpl$5 serviceMediaControlBrowserImpl$5 = new ServiceMediaControlBrowserImpl$5(this, mediaControlCallbackListRequest, n);
        Command command = CmdRequestList.createListRequestByIndex(this.mComponents.getBrowser(), n, n2, serviceMediaControlBrowserImpl$5);
        this.mQueue.addCommand(command);
    }
}

