package cubex.mahesh.customadapter_sep7am

import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.indiview.view.*
import java.io.File

class MyAdapter(var files:Array<File>,var activity:MainActivity ) : BaseAdapter( ) {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var inflater = LayoutInflater.from(activity)
            var v = inflater.inflate(R.layout.indiview,null)
            var file = files[p0]
       //     v.iview.setImageURI(Uri.fromFile(file))
                var bmp = BitmapFactory.decodeFile(file.path)
            var thumb_img =
            ThumbnailUtils.extractThumbnail(bmp,60,60)
            v.iview.setImageBitmap(thumb_img)
            v.tv1.text = file.name
            v.tv2.text = "${file.length()} bytes"
            v.del.setOnClickListener {
                file.delete()
                activity.readFiles()
            }
            return v
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
    return 0
    }

    override fun getCount(): Int {
        return files.size
    }
}