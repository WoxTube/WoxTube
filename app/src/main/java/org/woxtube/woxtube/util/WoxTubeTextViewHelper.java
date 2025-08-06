package org.woxtube.woxtube.util;

import android.content.Context;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.woxtube.woxtube.util.external_communication.ShareUtils;
import org.woxtube.woxtube.views.WoxTubeEditText;
import org.woxtube.woxtube.views.WoxTubeTextView;

public final class WoxTubeTextViewHelper {
    private WoxTubeTextViewHelper() {
    }

    /**
     * Share the selected text of {@link WoxTubeTextView WoxTubeTextViews} and
     * {@link WoxTubeEditText WoxTubeEditTexts} with
     * {@link ShareUtils#shareText(Context, String, String)}.
     *
     * <p>
     * This allows EMUI users to get the Android share sheet instead of the EMUI share sheet when
     * using the {@code Share} command of the popup menu which appears when selecting text.
     * </p>
     *
     * @param textView the {@link TextView} on which sharing the selected text. It should be a
     *                 {@link WoxTubeTextView} or a {@link WoxTubeEditText} (even if
     *                 {@link TextView standard TextViews} are supported).
     */
    public static void shareSelectedTextWithShareUtils(@NonNull final TextView textView) {
        final CharSequence textViewText = textView.getText();
        shareSelectedTextIfNotNullAndNotEmpty(textView, getSelectedText(textView, textViewText));
        if (textViewText instanceof Spannable) {
            Selection.setSelection((Spannable) textViewText, textView.getSelectionEnd());
        }
    }

    @Nullable
    private static CharSequence getSelectedText(@NonNull final TextView textView,
                                                @Nullable final CharSequence text) {
        if (!textView.hasSelection() || text == null) {
            return null;
        }

        final int start = textView.getSelectionStart();
        final int end = textView.getSelectionEnd();
        return String.valueOf(start > end ? text.subSequence(end, start)
                : text.subSequence(start, end));
    }

    private static void shareSelectedTextIfNotNullAndNotEmpty(
            @NonNull final TextView textView,
            @Nullable final CharSequence selectedText) {
        if (selectedText != null && selectedText.length() != 0) {
            ShareUtils.shareText(textView.getContext(), "", selectedText.toString());
        }
    }
}
