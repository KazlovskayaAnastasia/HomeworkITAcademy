package lesson9

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.nastia.administrator.lessonitacademy.R
import io.reactivex.disposables.Disposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import java.util.concurrent.TimeUnit
import io.reactivex.rxkotlin.subscribeBy

class Lesson9Activity : AppCompatActivity() {

    protected val compositeDisposable : CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private lateinit var subscription : Disposable
    private lateinit var timer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson9)

        timer = findViewById(R.id.timer)

        subscription = Observable.interval(1, TimeUnit.SECONDS)
                .filter{ t -> t%2<1 }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            timer.text = it.toString()
                        })
        addToDisposible(subscription)
    }

    protected fun addToDisposible(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }
}