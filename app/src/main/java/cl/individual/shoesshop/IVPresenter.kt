package cl.individual.shoesshop

interface IVPresenter {

    interface View {
        fun goToCart()
        fun showShoeList(shoes : List<Shoes>)

        fun updateTotalCost(total: Int)

    }

    interface Presenter {
        fun entregarLista()
    }


}