package com.airbnb.epoxy.sample

import android.util.Log
import android.view.View
import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.sample.models.CarouselModelGroup
import com.airbnb.epoxy.sample.models.ColorModel_
import com.airbnb.epoxy.sample.models.NumModel_
import com.airbnb.epoxy.sample.models.num
import com.airbnb.epoxy.sample.views.HeaderViewModel_
import com.airbnb.epoxy.sample.views.headerView

class SampleController(private val callbacks: AdapterCallbacks) :
    TypedEpoxyController<List<CarouselData>>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    interface AdapterCallbacks {
        fun onAddCarouselClicked()
        fun onClearCarouselsClicked()
        fun onShuffleCarouselsClicked()
        fun onChangeAllColorsClicked()
        fun onAddColorToCarouselClicked(carousel: CarouselData?)
        fun onClearCarouselClicked(carousel: CarouselData?)
        fun onShuffleCarouselColorsClicked(carousel: CarouselData?)
        fun onChangeCarouselColorsClicked(carousel: CarouselData?)
        fun onColorClicked(carousel: CarouselData?, colorPosition: Int)
    }

//    @AutoModel
//    lateinit var header: HeaderViewModel_

    @AutoModel
    lateinit var numModel: NumModel_
//
//    @AutoModel
//    lateinit var color: ColorModel_
//
//    @AutoModel
//    lateinit var header2: HeaderViewModel_
//
//    @AutoModel
//    lateinit var addButton: ButtonBindingModel_
//
//    @AutoModel
//    lateinit var addButton2: ButtonBindingModel_
//
//    @AutoModel
//    lateinit var clearButton: ButtonBindingModel_
//
//    @AutoModel
//    lateinit var shuffleButton: ButtonBindingModel_
//
//    @AutoModel
//    lateinit var changeColorsButton: ButtonBindingModel_

    override fun buildModels(carousels: List<CarouselData>) {
        if (false) {
            //NumModel_
            headerView {

            }
            //不带 Model_ 这个标志了
            num {

            }
        }

        Log.i("SampleController", "----------------------------${numModel.id()}-----")
        numModel.str("77777777777")
//        header
//            .title(R.string.epoxy)
//            .caption(R.string.header_subtitle)
//        /**
//         * todo: 注意
//         * 这个地方还是需要设置的，不然不会展示,并贴影响顺序
//         *
//         */
//        addButton2
//            .textRes(R.string.button_add)
//
//
//
//        header2
//            .title(R.string.epoxy)
//            .caption(R.string.header_subtitle)
//        // "addTo" is not needed since implicit adding is enabled
//        // (https://github.com/airbnb/epoxy/wiki/Epoxy-Controller#implicit-adding)
//        addButton
//            .textRes(R.string.button_add)
//            .clickListener { model: ButtonBindingModel_?, parentView: DataBindingEpoxyModel.DataBindingHolder?, clickedView: View?, position: Int -> callbacks.onAddCarouselClicked() }
//        clearButton
//            .textRes(R.string.button_clear)
//            .clickListener { v: View? -> callbacks.onClearCarouselsClicked() }
//            .addIf(carousels.size > 0, this)
//        shuffleButton
//            .textRes(R.string.button_shuffle)
//            .clickListener { v: View? -> callbacks.onShuffleCarouselsClicked() }
//            .addIf(carousels.size > 1, this)
//        changeColorsButton
//            .textRes(R.string.button_change)
//            .clickListener { v: View? -> callbacks.onChangeAllColorsClicked() }
//            .addIf(carousels.size > 0, this)
//        for (i in carousels.indices) {
//            val carousel = carousels[i]
//            add(CarouselModelGroup(carousel, callbacks))
//        }
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {
        // Best practice is to throw in debug so you are aware of any issues that Epoxy notices.
        // Otherwise Epoxy does its best to swallow these exceptions and continue gracefully
        throw exception
    }

    init {
        // Demonstrating how model building and diffing can be done in the background.
        // You can control them separately by passing in separate handler, as shown below.
        //    super(new Handler(), BACKGROUND_HANDLER);
//    super(BACKGROUND_HANDLER, new Handler());
        isDebugLoggingEnabled = true
    }
}
