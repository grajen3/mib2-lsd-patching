/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.browser.transformer;

import generated.de.vw.mib.asl.internal.mediacontrol.browser.transformer.AbstractMediaControlBrowserDisplayedFolderPathTransformer;

public class MediaControlBrowserDisplayedFolderPathTransformer
extends AbstractMediaControlBrowserDisplayedFolderPathTransformer {
    @Override
    public int getInt(int n, Object object) {
        Integer n2 = (Integer)object;
        switch (n) {
            case 0: {
                return n2;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }
}

