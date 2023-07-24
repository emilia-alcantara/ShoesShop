package cl.individual.shoesshop

class BrowsePresenter (private val view :IVPresenter.View) : IVPresenter.Presenter {
    private val shopModel: ShopModel?= null

    override fun entregarLista() {
       val shoe = shopModel!!.getShoesList()
        view.showShoeList(shoe)
    }


}