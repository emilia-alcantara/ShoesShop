package cl.individual.shoesshop

data class Shoes (val shoeName :String, val shoePrice: Int, val imgUrl: String) {
    companion object {
        fun getShoeList() : List<Shoes> {
            val shoeList = mutableListOf<Shoes>()
            shoeList.add(Shoes(
                "Converse Run Star Hike",
                76990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPF_2iTsYmdkInNjcjkIvcrJyowJPHh89pKQ&usqp=CAU"))
            shoeList.add(Shoes(
                "Converse Chuck Taylor All Star",
                62990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9pLrEwQZzrQuDNF-Szzz59RO8BzW9ImAUNA&usqp=CAU"))
            shoeList.add(Shoes(
                "Converse Pro Blaze strap",
                40990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD-UfMVO-4i9R-KFOEYTZrbnVIZtCKgnxX0w&usqp=CAU"))
            shoeList.add(Shoes(
                "Zapatilla Converse El Distrito Hombre",
                31790,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFVev0TczYU_YTJinkuEJwqk6nsw4QKPf5rQ&usqp=CAU"))
            shoeList.add(Shoes(
                "Converse Chuck 70 Hi Cuero Mujer",
                34990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9BhVyJNJM61to9XGJJBGkGyANKY2kwAEgBA&usqp=CAU"))
            shoeList.add(Shoes(
                "Nike Air Force 1",
                60000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4c1Ci6ug9PFwd4fIEhW5IAwr4FmDlEY3y5g&usqp=CAU"))
            shoeList.add(Shoes(
                "Nike Air Max SC Hombre",
                82990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNk14nYQHUd-BzG5Eb7Bm9NT4UXa3Y0Ji7TyfUbhL_u9CVy-Gja7gmAwcQv07p84zpHic&usqp=CAU"))
            shoeList.add(Shoes(
                "Nike Court Vision Mid Zapatillas Hombre",
                67990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAhv2XXcCPXzVjAzctu8HjSsWW6Zws0YZWFQ&usqp=CAU"))
            shoeList.add(Shoes(
                "Zapatillla Nike Infantil Court Borough Low",
                54990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyfiFsI0r_HHgxlmrR5OIFRCwecgrkVXFYxQ&usqp=CAU"))
            shoeList.add(Shoes(
                "Nike Air Max SC Mujer",
                84990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8Cgw7aR-_kLh2MslsC_uKREUFx9n7qxtOuA&usqp=CAU"))
          return shoeList
        }
    }

}


