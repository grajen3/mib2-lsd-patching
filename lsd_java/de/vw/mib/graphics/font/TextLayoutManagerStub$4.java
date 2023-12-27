/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.font.TextLayoutManagerStub;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;

class TextLayoutManagerStub$4
implements TextLayout {
    private final /* synthetic */ TextLayoutManagerStub this$0;

    TextLayoutManagerStub$4(TextLayoutManagerStub textLayoutManagerStub) {
        this.this$0 = textLayoutManagerStub;
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isReferenced() {
        return false;
    }

    @Override
    public void reference() {
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    @Override
    public boolean isTruncated() {
        return false;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getLineCount() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public TextLineLayout getTextLine(int n) {
        return null;
    }

    @Override
    public boolean isGlyphIdCharacterCode() {
        return false;
    }

    @Override
    public long getId() {
        return 0L;
    }

    @Override
    public boolean isTextlineRtl(int n) {
        return false;
    }

    @Override
    public int getLastGlyphIndex(int n) {
        return 0;
    }

    @Override
    public int getLastSourceIndex(int n) {
        return 0;
    }

    @Override
    public int getFirstSourceIndex(int n) {
        return 0;
    }

    @Override
    public int findRowBySourceIndex(int n) {
        return 0;
    }

    @Override
    public String getText() {
        return null;
    }
}

