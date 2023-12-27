/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdOpenFolder;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public class CmdMoveFolderLevelUp
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int STEP_1_DERIVE_PARENT_AND_ORIGIN_FOLDER;
    private static final int STEP_2_OPEN_AND_FOCUS;
    private final AbstractMediaBrowser mBrowser;
    private final int mSteps;
    private final ListEntry[] mCurrentFolderPath;
    private ListEntry[] mAncestorFolderPath = null;
    private ListEntry mOriginFolderEntry = null;

    public CmdMoveFolderLevelUp(AbstractMediaBrowser abstractMediaBrowser, int n) {
        super(abstractMediaBrowser.getComponentId(), 1, 2, TIMEOUT);
        this.mBrowser = abstractMediaBrowser;
        this.mSteps = n;
        this.mCurrentFolderPath = this.mBrowser.getState().getBrowseFolder();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                int n2;
                Object[] objectArray = this.mCurrentFolderPath;
                if (Util.isNullOrEmpty(objectArray)) {
                    this.commandFailed("moveFolderLevelUp called while mActiveFolderPath is null/empty");
                    return;
                }
                int n3 = n2 = this.mSteps == 0 ? objectArray.length - 1 : this.mSteps;
                if (n2 == 0) {
                    this.commandCompleted("absoluteSteps = 0, nothing to do");
                    return;
                }
                int n4 = objectArray.length - n2;
                if (n4 < 0 && n4 >= objectArray.length) {
                    this.commandFailed("invalid path length");
                    return;
                }
                this.mAncestorFolderPath = new ListEntry[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    this.mAncestorFolderPath[i2] = objectArray[i2];
                }
                if (Util.isNullOrEmpty(this.mAncestorFolderPath)) {
                    this.commandFailed("invalid ancestor folder");
                    return;
                }
                this.trace(new StringBuffer().append("ancestorFolderPath: ").append(MediaBrowserHelper.getReducedPathString(this.mAncestorFolderPath)).toString());
                this.mOriginFolderEntry = objectArray[n4];
                if (this.mOriginFolderEntry == null) {
                    this.commandFailed("invalid origin folder");
                    return;
                }
                this.trace(new StringBuffer().append("originFolderEntry: ").append(MediaBrowserHelper.getListEntryStr(this.mOriginFolderEntry)).toString());
                this.nextStep();
                break;
            }
            case 2: {
                this.rqExecuteCmd(CmdOpenFolder.createAbsoluteCmd(this.mBrowser, this.mAncestorFolderPath, this.mOriginFolderEntry), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "DERIVE_PARENT_AND_ORIGIN_FOLDER";
            }
            case 2: {
                return "OPEN_AND_FOCUS";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("currentFolder: ").append(MediaBrowserHelper.getReducedPathString(this.mCurrentFolderPath)).append(", steps: ").append(this.mSteps).toString();
    }
}

