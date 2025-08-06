package org.woxtube.woxtube.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import org.woxtube.woxtube.util.WoxTubeTextViewHelper;
import org.woxtube.woxtube.util.external_communication.ShareUtils;

/**
 * An {@link AppCompatEditText} which uses {@link ShareUtils#shareText(Context, String, String)}
 * when sharing selected text by using the {@code Share} command of the floating actions.
 *
 * <p>
 * This class allows WoxTube to show Android share sheet instead of EMUI share sheet when sharing
 * text from {@link AppCompatEditText} on EMUI devices.
 * </p>
 */
public class WoxTubeEditText extends AppCompatEditText {

    public WoxTubeEditText(@NonNull final Context context) {
        super(context);
    }

    public WoxTubeEditText(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
    }

    public WoxTubeEditText(@NonNull final Context context,
                           @Nullable final AttributeSet attrs,
                           final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTextContextMenuItem(final int id) {
        if (id == android.R.id.shareText) {
            WoxTubeTextViewHelper.shareSelectedTextWithShareUtils(this);
            return true;
        }
        return super.onTextContextMenuItem(id);
    }
}
