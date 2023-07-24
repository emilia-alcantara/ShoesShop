package cl.individual.shoesshop

interface IVPresenter {

    interface View {
        fun goToCart()
        fun showShoeList(shoes : List<Shoes>)

    }

    interface Presenter {
        fun entregarLista()
    }


}