package cl.individual.shoesshop
// FALTA IMPLEMENTAR. MVP PENDIENTE!!!!
class ShopModel {

    private var totalCost : Int =0

    fun getShoesList() : List<Shoes> {
        return listOf(

        )
    }

    fun addPrices(shoe:Shoes) : Int {
        totalCost += shoe.shoePrice
        return totalCost
    }




}