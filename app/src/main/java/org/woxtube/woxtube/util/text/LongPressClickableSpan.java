package org.woxtube.woxtube.util.text;

import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

public abstract class LongPressClickableSpan extends ClickableSpan {

    public abstract void onLongClick(@NonNull View view);

}
