package lesson10

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.nastia.administrator.lessonitacademy.R


class Lesson10Fragment : Fragment() {

    lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = this.arguments!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewModel: ViewModel = Lesson10ViewModel(bundle.getString(BUNDLE_KEY)?:"")

        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lesson10, container, false)
        binding.setVariable(BR.lesson10ViewModel, viewModel)
        return binding.root
    }

    companion object {
         const val MALE_ID = "MALE_ID"
         const val FEMALE_ID = "FEMALE_ID"
        private const val BUNDLE_KEY = "KEY"

        fun maleInstance(): Lesson10Fragment {
            val fragment = Lesson10Fragment()

            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY, MALE_ID)
            fragment.arguments = bundle
            return fragment
        }

        fun femaleInstance(): Lesson10Fragment {
            val fragment = Lesson10Fragment()

            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY, FEMALE_ID)
            fragment.arguments = bundle
            return fragment
        }
    }
}