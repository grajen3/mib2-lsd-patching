/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.CursorChangedListener;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public final class CursorManager {
    private static final int CURSOR_WIDTH;
    private CowList cursorChangedListener;
    private TextLayout textLayout;
    private int lineIndex;
    private int glyphIndex;
    private boolean trailingEdge;
    private int sourceIndex;
    private boolean boundaryPosition;
    private final Logger logger;

    public CursorManager(Logger logger) {
        this.logger = logger;
        this.cursorChangedListener = CowList.EMPTY;
    }

    public void setTextLayout(TextLayout textLayout, int n) {
        Object object;
        boolean bl;
        boolean bl2 = bl = this.sourceIndex != n;
        if (this.logger.isTraceEnabled(2)) {
            object = this.logger.trace(2);
            object.append("CursorManager - setTextLayout: \n").append(textLayout).log();
        }
        if (this.textLayout != textLayout) {
            if (this.textLayout != null) {
                this.textLayout.dispose();
            }
            if (textLayout != null) {
                textLayout.reference();
            }
            this.textLayout = textLayout;
            if (this.textLayout == null || this.textLayout.getLineCount() == 0) {
                this.lineIndex = 0;
                this.glyphIndex = 0;
                this.trailingEdge = false;
                this.fireCursorChanged(false);
                return;
            }
            if (bl) {
                this.setCursorPositionBySourceIndex(n);
            } else {
                if (this.lineIndex >= this.textLayout.getLineCount()) {
                    this.lineIndex = this.textLayout.getLineCount() - 1;
                    this.fireCursorChanged(false);
                }
                if (this.lineIndex >= 0) {
                    GlyphLayout glyphLayout;
                    object = this.textLayout.getTextLine(this.lineIndex);
                    if (this.trailingEdge && this.glyphIndex > 0 && this.glyphIndex < object.getGlyphCount() - 1 && ((glyphLayout = object.getGlyph(this.glyphIndex)).isRightToLeft() && object.getGlyph(this.glyphIndex - 1).isRightToLeft() || !glyphLayout.isRightToLeft() && !object.getGlyph(this.glyphIndex + 1).isRightToLeft())) {
                        this.trailingEdge = false;
                    }
                    if (this.glyphIndex >= object.getGlyphCount()) {
                        boolean bl3 = this.glyphIndex == object.getGlyphCount();
                        this.trailingEdge = this.trailingEdge || this.glyphIndex != object.getGlyphCount();
                        this.glyphIndex = this.textLayout.getLastGlyphIndex(this.lineIndex);
                        this.fireCursorChanged(bl3);
                        return;
                    }
                }
                this.fireCursorChanged(true);
            }
        }
    }

    public boolean isDeleteAllowed() {
        return !this.boundaryPosition;
    }

    public void selectNext() {
        TextLineLayout textLineLayout = this.getCurrentTextLine();
        GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
        if (glyphLayout.isRightToLeft()) {
            this.moveCursorLeft();
        } else {
            this.moveCursorRight();
        }
    }

    public void selectPrevious() {
        TextLineLayout textLineLayout = this.getCurrentTextLine();
        GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
        if (glyphLayout.isRightToLeft()) {
            this.moveCursorRight();
        } else {
            this.moveCursorLeft();
        }
    }

    public boolean isRTL() {
        if (this.textLayout == null || this.textLayout.getLineCount() == 0) {
            return false;
        }
        TextLineLayout textLineLayout = this.getCurrentTextLine();
        GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
        return glyphLayout.isRightToLeft();
    }

    public void updateCursorPositionByNextInsertionCharacter(char c2) {
        int n = this.getCurrentTextLineIndex();
        if (n != -1) {
            boolean bl;
            TextLineLayout textLineLayout = this.getCurrentTextLine();
            boolean bl2 = bl = CursorManager.isStrongRightToLeftCharacter(c2) || this.textLayout.isTextlineRtl(n) && CursorManager.isDirectionNeutralCharacter(c2);
            if (this.boundaryPosition) {
                if (bl) {
                    if (!textLineLayout.getGlyph(this.glyphIndex).isRightToLeft()) {
                        this.glyphIndex = this.glyphIndex == 0 ? this.textLayout.getLastGlyphIndex(n) : this.searchGlyphIndexBySourceIndex(n, textLineLayout.getGlyph(this.glyphIndex - 1).getSourceIndex() - 1);
                        this.trailingEdge = true;
                    }
                } else if (textLineLayout.getGlyph(this.glyphIndex).isRightToLeft() && this.glyphIndex < textLineLayout.getGlyphCount() - 1) {
                    this.glyphIndex = this.searchGlyphIndexBySourceIndex(this.lineIndex, textLineLayout.getGlyph(this.glyphIndex + 1).getSourceIndex());
                }
                this.fireCursorChanged(false);
            } else if (this.trailingEdge) {
                if (this.glyphIndex != this.textLayout.getLastGlyphIndex(this.lineIndex)) {
                    if (bl && !textLineLayout.getGlyph(this.glyphIndex).isRightToLeft()) {
                        if (this.glyphIndex < textLineLayout.getGlyphCount() - 1) {
                            ++this.glyphIndex;
                            this.fireCursorChanged(false);
                        }
                    } else if (this.glyphIndex > 0 && !bl && textLineLayout.getGlyph(this.glyphIndex).isRightToLeft()) {
                        --this.glyphIndex;
                        this.fireCursorChanged(false);
                    }
                }
            } else if (textLineLayout.getGlyph(this.glyphIndex).isRightToLeft() != bl) {
                this.trailingEdge = true;
                if (bl) {
                    if (this.glyphIndex > 0) {
                        --this.glyphIndex;
                    }
                } else if (this.glyphIndex < this.textLayout.getTextLine(this.lineIndex).getGlyphCount() - 1) {
                    ++this.glyphIndex;
                }
            }
        }
    }

    public void moveCursorLeft() {
        Object object;
        if (this.logger.isTraceEnabled(2)) {
            object = this.logger.trace(2);
            object.append("CursorManager - moveCursorLeft").log();
        }
        if (this.textLayout != null && this.textLayout.getLineCount() > 0 && (object = this.textLayout.getTextLine(this.lineIndex)).getGlyphCount() > 0) {
            GlyphLayout glyphLayout = object.getGlyph(this.glyphIndex);
            if (!glyphLayout.isRightToLeft()) {
                if (this.trailingEdge) {
                    this.trailingEdge = false;
                } else if (this.glyphIndex == 0) {
                    if (this.lineIndex > 0) {
                        --this.lineIndex;
                        this.trailingEdge = true;
                        this.glyphIndex = this.textLayout.getTextLine(this.lineIndex).getGlyphCount() - 1;
                    }
                } else {
                    --this.glyphIndex;
                    if (this.glyphIndex > 0 && object.getGlyph(this.glyphIndex - 1).isRightToLeft()) {
                        --this.glyphIndex;
                    }
                }
            } else if (this.trailingEdge && this.glyphIndex == 0) {
                if (this.lineIndex < this.textLayout.getLineCount() - 1) {
                    ++this.lineIndex;
                    this.trailingEdge = false;
                    this.glyphIndex = 0;
                }
            } else if (!this.trailingEdge && this.glyphIndex == 0) {
                this.trailingEdge = true;
            } else if (this.trailingEdge) {
                --this.glyphIndex;
            } else {
                GlyphLayout glyphLayout2 = object.getGlyph(this.glyphIndex - 1);
                if (!glyphLayout2.isRightToLeft()) {
                    this.trailingEdge = true;
                } else {
                    --this.glyphIndex;
                }
            }
            this.fireCursorChanged(false);
        }
    }

    public void moveCursorRight() {
        Object object;
        if (this.logger.isTraceEnabled(2)) {
            object = this.logger.trace(2);
            object.append("CursorManager - moveCursorRight").log();
        }
        if (this.textLayout != null && this.textLayout.getLineCount() > 0 && (object = this.textLayout.getTextLine(this.lineIndex)).getGlyphCount() > 0) {
            GlyphLayout glyphLayout = object.getGlyph(this.glyphIndex);
            boolean bl = glyphLayout.isRightToLeft();
            if (!bl) {
                if (this.trailingEdge && this.glyphIndex == object.getGlyphCount() - 1) {
                    if (this.lineIndex < this.textLayout.getLineCount() - 1) {
                        ++this.lineIndex;
                        this.trailingEdge = false;
                        this.glyphIndex = 0;
                    }
                } else if (!this.trailingEdge && this.glyphIndex == object.getGlyphCount() - 1) {
                    this.trailingEdge = true;
                } else if (this.trailingEdge) {
                    ++this.glyphIndex;
                } else {
                    GlyphLayout glyphLayout2 = object.getGlyph(this.glyphIndex + 1);
                    if (glyphLayout2.isRightToLeft()) {
                        this.trailingEdge = true;
                    } else {
                        ++this.glyphIndex;
                    }
                }
            } else if (this.trailingEdge) {
                this.trailingEdge = false;
            } else if (this.glyphIndex == object.getGlyphCount() - 1) {
                if (this.lineIndex > 0) {
                    --this.lineIndex;
                    this.trailingEdge = true;
                    this.glyphIndex = this.textLayout.getTextLine(this.lineIndex).getGlyphCount() - 1;
                }
            } else {
                ++this.glyphIndex;
                if (this.glyphIndex < object.getGlyphCount() - 1 && !object.getGlyph(this.glyphIndex + 1).isRightToLeft()) {
                    ++this.glyphIndex;
                }
            }
            this.fireCursorChanged(false);
        }
    }

    public boolean canMoveCursorLeft() {
        if (this.textLayout == null || this.textLayout.getLineCount() == 0) {
            return false;
        }
        if (this.glyphIndex > 0) {
            return true;
        }
        if (!this.textLayout.isTextlineRtl(0) ? this.lineIndex > 0 : this.lineIndex < this.textLayout.getLineCount() - 1) {
            return true;
        }
        boolean bl = this.textLayout.getTextLine(this.lineIndex).getGlyph(0).isRightToLeft();
        return bl && !this.trailingEdge || !bl && this.trailingEdge;
    }

    public boolean canMoveCursorRight() {
        if (this.textLayout == null || this.textLayout.getLineCount() == 0) {
            return false;
        }
        if (this.glyphIndex < this.textLayout.getTextLine(this.lineIndex).getGlyphCount() - 1) {
            return true;
        }
        if (this.textLayout.isTextlineRtl(0) ? this.lineIndex > 0 : this.lineIndex < this.textLayout.getLineCount() - 1) {
            return true;
        }
        boolean bl = this.textLayout.getTextLine(this.lineIndex).getGlyph(this.glyphIndex).isRightToLeft();
        return !bl && !this.trailingEdge || bl && this.trailingEdge;
    }

    public void setCursorByLocation(int n, int n2) {
        int n3;
        int n4 = n3 = this.textLayout == null ? 0 : this.textLayout.getLineCount();
        if (this.logger.isTraceEnabled(2)) {
            LogMessage logMessage = this.logger.trace(2);
            logMessage.append("CursorManager - setCursorByLocation(x=").append(n).append(", y=").append(n2).append(")").log();
        }
        if (n3 == 0) {
            this.lineIndex = 0;
            this.glyphIndex = 0;
        } else {
            int n5 = Math.min(n3 - 1, n2 / (this.textLayout.getHeight() / this.textLayout.getLineCount()));
            TextLineLayout textLineLayout = this.textLayout.getTextLine(n5);
            int n6 = textLineLayout.getTop() - textLineLayout.getBottom();
            int n7 = n2 - (textLineLayout.getBaseline() - textLineLayout.getTop());
            while (n7 > n6 && n5 < n3 - 1) {
                textLineLayout = this.textLayout.getTextLine(++n5);
                n6 = textLineLayout.getTop() - textLineLayout.getBottom();
                n7 = n2 - (textLineLayout.getBaseline() - textLineLayout.getTop());
            }
            int n8 = n2 - textLineLayout.getBaseline() + textLineLayout.getBottom();
            while (n8 < -n6 && n5 > 0 && textLineLayout.getGlyphCount() == 0) {
                textLineLayout = this.textLayout.getTextLine(--n5);
                n6 = textLineLayout.getTop() - textLineLayout.getBottom();
                n8 = n2 - textLineLayout.getBaseline() + textLineLayout.getBottom();
            }
            int n9 = n - textLineLayout.getLeft();
            int n10 = textLineLayout.getGlyphCount();
            int n11 = n10 < 2 ? 0 : Util.clamp(n9 / (textLineLayout.getGlyph(n10 - 1).getCaretX() >> 6) / n10, 0, n10 - 1);
            GlyphLayout glyphLayout = textLineLayout.getGlyph(n11);
            int n12 = CursorManager.distance(n9, glyphLayout);
            while ((n11 != 0 && glyphLayout.getGlyphId() == -16842752 || n12 > 0) && n11 < n10 - 1) {
                glyphLayout = textLineLayout.getGlyph(++n11);
                n12 = CursorManager.distance(n9, glyphLayout);
            }
            while ((n11 != n10 - 1 && glyphLayout.getGlyphId() == -16842752 || n12 < 0) && n11 > 0) {
                glyphLayout = textLineLayout.getGlyph(--n11);
                n12 = CursorManager.distance(n9, glyphLayout);
            }
            this.lineIndex = n5;
            this.glyphIndex = n11;
            if (n11 == this.textLayout.getLastGlyphIndex(n5)) {
                this.trailingEdge = !glyphLayout.isRightToLeft() && n12 > glyphLayout.getWidth() || glyphLayout.isRightToLeft() && n12 < glyphLayout.getWidth();
            }
        }
        this.fireCursorChanged(false);
    }

    private static int distance(int n, GlyphLayout glyphLayout) {
        return n - (glyphLayout.getCaretX() >> 6) + (glyphLayout.getWidth() >> 1);
    }

    private boolean updateTrailingEdge() {
        if (this.trailingEdge) {
            TextLineLayout textLineLayout = this.textLayout.getTextLine(this.lineIndex);
            if (this.glyphIndex > 0 && this.glyphIndex < textLineLayout.getGlyphCount() - 1) {
                GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
                if (glyphLayout.isRightToLeft() && textLineLayout.getGlyph(this.glyphIndex - 1).isRightToLeft()) {
                    --this.glyphIndex;
                    this.trailingEdge = false;
                    return true;
                }
                if (!glyphLayout.isRightToLeft() && !textLineLayout.getGlyph(this.glyphIndex + 1).isRightToLeft()) {
                    ++this.glyphIndex;
                    this.trailingEdge = false;
                    return true;
                }
            }
        }
        return false;
    }

    public void setCursorPositionBySourceIndex(int n) {
        if (this.textLayout != null && this.textLayout.getLineCount() > 0 && n >= 0) {
            TextLineLayout textLineLayout = this.textLayout.getTextLine(this.lineIndex);
            if (this.glyphIndex >= 0 && this.glyphIndex < textLineLayout.getGlyphCount()) {
                if (this.trailingEdge) {
                    if (n == this.findNextGlyphSourceIndex(this.glyphIndex, this.lineIndex)) {
                        if (this.updateTrailingEdge()) {
                            this.fireCursorChanged(false);
                        }
                        return;
                    }
                } else {
                    GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
                    if (n == glyphLayout.getSourceIndex()) {
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < this.textLayout.getLineCount(); ++i2) {
                int n2;
                textLineLayout = this.textLayout.getTextLine(i2);
                if (n > 0) {
                    if (this.trailingEdge) {
                        --n;
                    }
                } else {
                    this.trailingEdge = false;
                }
                if ((n2 = this.searchGlyphIndexBySourceIndex(i2, n)) == -1) continue;
                if (this.lineIndex != i2 || this.glyphIndex != n2) {
                    this.lineIndex = i2;
                    this.glyphIndex = n2;
                    this.fireCursorChanged(false);
                    return;
                }
                this.fireCursorChanged(true);
                return;
            }
            this.lineIndex = this.textLayout.getLineCount() - 1;
            this.glyphIndex = this.textLayout.getLastGlyphIndex(this.lineIndex);
            this.trailingEdge = true;
            this.fireCursorChanged(false);
        } else {
            this.lineIndex = 0;
            this.glyphIndex = 0;
            this.fireCursorChanged(false);
        }
    }

    public boolean getAlternateCursorPosition(Rectangle rectangle) {
        if (this.textLayout != null && this.lineIndex < this.textLayout.getLineCount()) {
            int n = this.getAlternateCursorPosition();
            TextLineLayout textLineLayout = this.textLayout.getTextLine(this.lineIndex);
            if (textLineLayout.getGlyphCount() > 0) {
                GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
                rectangle.setBounds(0, textLineLayout.getBaseline() - textLineLayout.getTop(), 0, textLineLayout.getTop() - textLineLayout.getBaseline());
                if (n != -1) {
                    GlyphLayout glyphLayout2 = textLineLayout.getGlyph(n);
                    if (this.trailingEdge) {
                        rectangle.x = textLineLayout.getLeft() + glyphLayout2.getCaretX() >> 6;
                        return true;
                    }
                    if (glyphLayout.isRightToLeft() && n != this.glyphIndex + 1) {
                        rectangle.x = textLineLayout.getLeft() + glyphLayout2.getX() + glyphLayout2.getWidth();
                        return true;
                    }
                    if (!glyphLayout.isRightToLeft() && n != this.glyphIndex - 1) {
                        rectangle.x = textLineLayout.getLeft() + glyphLayout2.getX();
                        return true;
                    }
                } else if (this.trailingEdge) {
                    if (glyphLayout.isRightToLeft() && this.glyphIndex != 0) {
                        GlyphLayout glyphLayout3 = textLineLayout.getGlyph(textLineLayout.getGlyphCount() - 1);
                        rectangle.x = textLineLayout.getLeft() + glyphLayout3.getX() + glyphLayout3.getWidth();
                        return true;
                    }
                    if (!glyphLayout.isRightToLeft() && this.glyphIndex != textLineLayout.getGlyphCount() - 1) {
                        GlyphLayout glyphLayout4 = textLineLayout.getGlyph(0);
                        rectangle.x = textLineLayout.getLeft() + glyphLayout4.getX();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addCursorChangedListener(CursorChangedListener cursorChangedListener) {
        this.cursorChangedListener = this.cursorChangedListener.addIfAbsent(cursorChangedListener);
    }

    public void removeCursorChangedListener(CursorChangedListener cursorChangedListener) {
        this.cursorChangedListener = this.cursorChangedListener.remove(cursorChangedListener);
    }

    private void fireCursorChanged(boolean bl) {
        Object object;
        int n;
        int n2;
        int n3;
        int n4;
        GlyphLayout glyphLayout;
        this.updateBoundaryFlag();
        TextLineLayout textLineLayout = this.textLayout != null && this.lineIndex < this.textLayout.getLineCount() ? this.textLayout.getTextLine(this.lineIndex) : null;
        GlyphLayout glyphLayout2 = glyphLayout = textLineLayout != null && textLineLayout.getGlyphCount() > this.glyphIndex ? textLineLayout.getGlyph(this.glyphIndex) : null;
        if (textLineLayout != null && glyphLayout != null) {
            if (!this.trailingEdge) {
                n4 = glyphLayout.isRightToLeft() && glyphLayout.getCaretX() >> 6 == glyphLayout.getX() ? textLineLayout.getLeft() + (glyphLayout.getCaretX() >> 6) + glyphLayout.getWidth() : textLineLayout.getLeft() + (glyphLayout.getCaretX() >> 6);
                this.sourceIndex = glyphLayout.getSourceIndex();
            } else if (!glyphLayout.isRightToLeft()) {
                n4 = textLineLayout.getLeft() + glyphLayout.getX() + glyphLayout.getWidth();
                this.sourceIndex = this.findNextGlyphSourceIndex(this.glyphIndex, this.lineIndex);
            } else {
                n4 = textLineLayout.getLeft() + glyphLayout.getX();
                this.sourceIndex = this.findNextGlyphSourceIndex(this.glyphIndex, this.lineIndex);
            }
            n3 = textLineLayout.getBaseline() - textLineLayout.getTop();
            n2 = 2;
            n = textLineLayout.getTop() - textLineLayout.getBaseline();
        } else {
            n4 = 0;
            n3 = 0;
            n2 = 0;
            n = 0;
            this.sourceIndex = -1;
        }
        if (this.sourceIndex == -129) {
            this.sourceIndex = this.textLayout.getText().length();
        }
        for (object = this.cursorChangedListener; object != CowList.EMPTY; object = ((CowList)object).tail()) {
            ((CursorChangedListener)((CowList)object).head()).cursorChanged(this.sourceIndex, n4, n3, n2, n, bl);
        }
        if (this.logger.isTraceEnabled(2) && this.sourceIndex >= 0) {
            object = this.textLayout.getText();
            int n5 = Math.min(this.sourceIndex, ((String)object).length() - 1);
            LogMessage logMessage = this.logger.trace(2);
            logMessage.append("CursorManager: fireCursorChanged: '");
            logMessage.append(((String)object).substring(0, n5));
            logMessage.append("^");
            logMessage.append(((String)object).substring(n5));
            logMessage.append("' [trailingEdge=").append(this.trailingEdge);
            logMessage.append(", sourceIndex=").append(this.sourceIndex);
            logMessage.append(", glyphIndex=").append(this.glyphIndex);
            logMessage.append(", boundaryPosition=").append(this.boundaryPosition);
            logMessage.append(", areaChangeOnly=").append(bl);
            logMessage.append("]");
            logMessage.log();
        }
    }

    private void updateBoundaryFlag() {
        TextLineLayout textLineLayout = this.getCurrentTextLine();
        if (textLineLayout != null && textLineLayout.getGlyphCount() > 0) {
            GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
            this.boundaryPosition = this.trailingEdge ? false : (this.glyphIndex == 0 && !glyphLayout.isRightToLeft() ? this.textLayout.isTextlineRtl(this.getCurrentTextLineIndex()) : (this.glyphIndex == 0 && glyphLayout.isRightToLeft() ? true : (this.glyphIndex == textLineLayout.getGlyphCount() - 1 ? glyphLayout.isRightToLeft() && !this.textLayout.isTextlineRtl(this.getCurrentTextLineIndex()) : glyphLayout.isRightToLeft() && !textLineLayout.getGlyph(this.glyphIndex + 1).isRightToLeft() || !glyphLayout.isRightToLeft() && textLineLayout.getGlyph(this.glyphIndex - 1).isRightToLeft())));
        }
    }

    private TextLineLayout getCurrentTextLine() {
        int n = this.getCurrentTextLineIndex();
        return n != -1 ? this.textLayout.getTextLine(n) : null;
    }

    private int getCurrentTextLineIndex() {
        return this.textLayout != null && this.textLayout.getLineCount() > this.lineIndex ? this.lineIndex : -1;
    }

    private int getAlternateCursorPosition() {
        TextLineLayout textLineLayout;
        if (this.textLayout != null && this.lineIndex < this.textLayout.getLineCount() && (textLineLayout = this.textLayout.getTextLine(this.lineIndex)).getGlyphCount() > 0) {
            GlyphLayout glyphLayout = textLineLayout.getGlyph(this.glyphIndex);
            return this.searchGlyphIndexBySourceIndex(this.lineIndex, glyphLayout.getSourceIndex() + (this.trailingEdge ? 1 : -1));
        }
        return -1;
    }

    private int searchGlyphIndexBySourceIndex(int n, int n2) {
        TextLineLayout textLineLayout = this.textLayout.getTextLine(n);
        for (int i2 = 0; i2 < textLineLayout.getGlyphCount(); ++i2) {
            if (textLineLayout.getGlyph(i2).getSourceIndex() != n2) continue;
            return i2;
        }
        return -1;
    }

    private int findNextGlyphSourceIndex(int n, int n2) {
        int n3;
        TextLineLayout textLineLayout;
        GlyphLayout glyphLayout;
        if (n == this.textLayout.getLastGlyphIndex(this.lineIndex)) {
            if (n2 >= this.textLayout.getLineCount() - 1) {
                return -129;
            }
            this.textLayout.getFirstSourceIndex(n2 + 1);
        }
        if ((glyphLayout = (textLineLayout = this.textLayout.getTextLine(n2)).getGlyph(n)).isRightToLeft()) {
            int n4;
            if (this.glyphIndex > 0 && textLineLayout.getGlyph(n - 1).isRightToLeft()) {
                return textLineLayout.getGlyph(n - 1).getSourceIndex();
            }
            if (this.textLayout.isTextlineRtl(n2)) {
                int n5;
                for (n5 = n; n5 > 0 && !textLineLayout.getGlyph(n5 - 1).isRightToLeft(); --n5) {
                }
                return textLineLayout.getGlyph(n5).getSourceIndex();
            }
            for (n4 = n; n4 < textLineLayout.getGlyphCount() - 1 && textLineLayout.getGlyph(n4).isRightToLeft(); ++n4) {
            }
            return textLineLayout.getGlyph(n4).getSourceIndex();
        }
        if (!textLineLayout.getGlyph(n + 1).isRightToLeft()) {
            return textLineLayout.getGlyph(n + 1).getSourceIndex();
        }
        if (this.textLayout.isTextlineRtl(n2)) {
            int n6;
            for (n6 = n; n6 > 0 && !textLineLayout.getGlyph(n6).isRightToLeft(); --n6) {
            }
            return textLineLayout.getGlyph(n6).getSourceIndex();
        }
        for (n3 = n; n3 < textLineLayout.getGlyphCount() - 1 && !textLineLayout.getGlyph(n3 + 1).isRightToLeft(); ++n3) {
        }
        return textLineLayout.getGlyph(n3).getSourceIndex();
    }

    private static boolean isCharacterInRange(char c2, char c3, char c4) {
        return c2 >= c3 && c2 <= c4;
    }

    private static boolean isStrongRightToLeftCharacter(char c2) {
        return CursorManager.isCharacterInRange(c2, '\u0600', '\u065f') || CursorManager.isCharacterInRange(c2, '\u066a', '\u06ff');
    }

    private static boolean isDirectionNeutralCharacter(char c2) {
        return CursorManager.isCharacterInRange(c2, ' ', '/') || CursorManager.isCharacterInRange(c2, ':', '@') || CursorManager.isCharacterInRange(c2, '\u00a1', '\u00bf');
    }
}

