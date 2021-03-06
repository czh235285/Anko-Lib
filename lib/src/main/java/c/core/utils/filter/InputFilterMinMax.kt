package c.core.utils.filter

import android.text.InputFilter
import android.text.Spanned

/**
 * 输入框限制输入最大最小值
 */

class InputFilterMinMax(private var min: Int, private var max: Int) : InputFilter {
    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        runCatching {
            val input = (dest.toString() + source.toString()).toInt()
            if (isInRange(min, max, input)) return null
        }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}
