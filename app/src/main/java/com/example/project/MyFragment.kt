package kotlincodes.com.viewpagerkotlin.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView

import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.fragment.app.Fragment
import com.example.project.R


class MyFragment : Fragment() {
    companion object {
        fun newInstance(message: String): MyFragment {

            val f = MyFragment()

            val bdl = Bundle(1)

            bdl.putString(EXTRA_MESSAGE, message)

            f.setArguments(bdl)

            return f

        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.fragment_cate, container, false);

        val message = requireArguments().getString(EXTRA_MESSAGE)

       // var textView: TextView = view!!.findViewById(R.id.text)
       // textView!!.text = message

        return view
    }


}