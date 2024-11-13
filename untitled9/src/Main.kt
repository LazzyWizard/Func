fun main() {
    val player: Int
    val pc = (1..3).random()
    println("Выберите ваш ход:")
    println("1 - Камень")
    println("2 - Ножницы")
    println("3 - Бумага")
    player = readln().toInt()
    if (player == pc) 
    {
        println("Ничья")
    } 
    else if ((player == 1 && pc == 3) ||
        (player == 2 && pc == 1) ||
        (player == 3 && pc == 2)) 
    {
        println("Победа")
    } 
    else 
    {
        println("Поражение")
    }
}
