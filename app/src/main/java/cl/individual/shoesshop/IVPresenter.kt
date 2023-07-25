package cl.individual.shoesshop
// FALTA IMPLEMENTAR. MVP PENDIENTE!!!!
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