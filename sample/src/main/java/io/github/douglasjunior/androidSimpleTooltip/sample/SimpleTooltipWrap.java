package io.github.douglasjunior.androidSimpleTooltip.sample;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils;

/**
 * Created: chiemy
 * Date: 16/6/29
 * Description:
 */
public class SimpleTooltipWrap {
    public static void showTopTip(Context context, View anchorView, String tip, View.OnClickListener tipClickListener) {
        topTipBuilder(context, anchorView, tip, tipClickListener)
                .build()
                .show();
    }

    public static void showBottomTip(Context context, View anchorView, String tip, View.OnClickListener tipClickListener) {
        bottomTipBuilder(context, anchorView, tip, tipClickListener)
                .build()
                .show();
    }

    public static SimpleTooltip.Builder topTipBuilder(final Context context, View anchorView, String tip, View.OnClickListener tipClickListener) {
        return builder(context, anchorView, tip, Gravity.TOP, tipClickListener);
    }

    public static SimpleTooltip.Builder bottomTipBuilder(final Context context, View anchorView, String tip, View.OnClickListener tipClickListener) {
        return builder(context, anchorView, tip, Gravity.BOTTOM, tipClickListener);
    }

    private static SimpleTooltip.Builder builder(final Context context, View anchorView, String tip, int gravity, View.OnClickListener tipClickListener) {
        int animStyle;
        if (gravity == Gravity.BOTTOM) {
            animStyle = R.style.BottomTipAnimStyle;
        } else {
            animStyle = R.style.TopTipAnimStyle;
        }
        return new SimpleTooltip.Builder(context)
                .anchorView(anchorView)
                .text(tip)
                .gravity(gravity)
                .setContentClickListener(tipClickListener)
                .arrowWidth(SimpleTooltipUtils.pxFromDp(12))
                .arrowHeight(SimpleTooltipUtils.pxFromDp(7))
                .setPopupAnimationStyle(animStyle);
    }
}
