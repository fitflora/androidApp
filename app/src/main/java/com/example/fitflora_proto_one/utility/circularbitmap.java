package com.example.fitflora_proto_one.utility;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class circularbitmap {
    public static Bitmap getcircularbitmap(Bitmap bitmap){
        // here we just make the bitmap be a square and get the pic from there
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int minEdge = Math.min(width, height);

        int radius = minEdge;
        int left = (width - minEdge) / 2;
        int top = (height - minEdge) / ((height-minEdge)/5);

        Bitmap output = Bitmap.createBitmap(minEdge, minEdge, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        paint.setAntiAlias(true);

        final Rect rect = new Rect(left, top, left + minEdge, top + minEdge);
        final RectF rectF = new RectF(rect);

        canvas.drawRoundRect(rectF, radius, radius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }
}
