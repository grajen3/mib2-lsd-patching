/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.internal.speechmedia.action.global.GenericGlobalAction;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;

public class SelectMusicPrecondition
extends GenericGlobalAction {
    public static final int PARROT_TITLE;
    public static final int PARROT_ARTIST;
    public static final int PARROT_ALBUM;
    public static final int PARROT_GENRE;
    private final int parrotPrompt;

    public SelectMusicPrecondition(MediaServiceController mediaServiceController, int n) {
        super(mediaServiceController);
        this.parrotPrompt = n;
    }

    @Override
    protected int getSuccessEvent() {
        return -998166016;
    }

    @Override
    protected int getDatapoolValue() {
        return this.parrotPrompt;
    }

    @Override
    public int getDownEvent() {
        return -1403375040;
    }

    @Override
    protected boolean doSourceCheck() {
        return true;
    }

    @Override
    protected boolean doSuccess() {
        return false;
    }
}

