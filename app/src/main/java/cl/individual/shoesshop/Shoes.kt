package cl.individual.shoesshop

data class Shoes (val shoeName :String, val shoePrice: Int, val imgUrl: String) {
    companion object {
        fun getShoeList() : List<Shoes> {
            val shoeList = mutableListOf<Shoes>()
            shoeList.add(Shoes(
                "zapatilla 1",
                25000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPF_2iTsYmdkInNjcjkIvcrJyowJPHh89pKQ&usqp=CAU"))
            shoeList.add(Shoes(
                "zapatilla 2",
                30000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9pLrEwQZzrQuDNF-Szzz59RO8BzW9ImAUNA&usqp=CAU"))
            shoeList.add(Shoes(
                "z3",
                35000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD-UfMVO-4i9R-KFOEYTZrbnVIZtCKgnxX0w&usqp=CAU"))
            shoeList.add(Shoes(
                "z4",
                29990,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFVev0TczYU_YTJinkuEJwqk6nsw4QKPf5rQ&usqp=CAU"))
            shoeList.add(Shoes(
                "z5",
                44000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9BhVyJNJM61to9XGJJBGkGyANKY2kwAEgBA&usqp=CAU"))
            shoeList.add(Shoes(
                "z6",
                15000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4c1Ci6ug9PFwd4fIEhW5IAwr4FmDlEY3y5g&usqp=CAU"))
            shoeList.add(Shoes(
                "z7",
                20000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNk14nYQHUd-BzG5Eb7Bm9NT4UXa3Y0Ji7TyfUbhL_u9CVy-Gja7gmAwcQv07p84zpHic&usqp=CAU"))
            shoeList.add(Shoes(
                "z8",
                17000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAhv2XXcCPXzVjAzctu8HjSsWW6Zws0YZWFQ&usqp=CAU"))
            shoeList.add(Shoes(
                "z9",
                50000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyfiFsI0r_HHgxlmrR5OIFRCwecgrkVXFYxQ&usqp=CAU"))
            shoeList.add(Shoes(
                "z10",
                64000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8Cgw7aR-_kLh2MslsC_uKREUFx9n7qxtOuA&usqp=CAU"))
          return shoeList
        }
    }

}


