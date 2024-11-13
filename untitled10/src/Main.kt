import kotlin.random.Random
fun main() {
    println("Введите исходное сообщение:")
    val message = readln().toString()
    println("Введите ключ:")
    val key = readln().toString()
    var useDefaultTable: Boolean
    do {
        println("Использовать типовую таблицу? (y/n)")
        val input = readln().toString()
        useDefaultTable = when (input) {
            "y" -> true
            "n" -> false
            else -> {
                println("Некорректный ввод, повторите попытку.")
                false
            }
        }
    }
    while (!useDefaultTable)
    val alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    if (useDefaultTable) {
        println("Типовая шифровальная таблица:")
        for (i in 0..<alphabet.length) {
            println(alphabet.substring(i) + alphabet.substring(0, i))
        }
    }
    else
    {
        val randomShifts = mutableListOf<Int>()
        val initialRow = alphabet.toList().shuffled()
        for (i in 1..<alphabet.length) {
            var shift: Int
            do {
                shift = Random.nextInt(1, alphabet.length)
            } while (shift in randomShifts)
            randomShifts.add(shift)
        }
        println("Случайная шифровальная таблица:")
        for (i in 0..<alphabet.length) {
            val shiftedAlphabet = (initialRow.drop(i) + initialRow.take(i)).toCharArray()
            for (j in 0..<shiftedAlphabet.size) {
                print(shiftedAlphabet[j])
            }
            println()
        }
    }
    println("Исходное сообщение: $message")
    println("Ключ: $key")
    val encryptedMessage = encryptVigenere(message, key, alphabet)
    println("Зашифрованное сообщение: $encryptedMessage")
}
fun encryptVigenere(message: String, key: String, alphabet: String): String {
    var result = ""
    val keyLength = key.length
    for (i in 0..<message.length) {
        val messageChar = message[i]
        val keyChar = key[i % keyLength]
        val rowIndex = alphabet.indexOf(keyChar)
        val columnIndex = alphabet.indexOf(messageChar)
        if (rowIndex != -1 && columnIndex != -1) {
            result += alphabet[(rowIndex + columnIndex) % alphabet.length]
        } else {
            result += messageChar
        }
    }
    return result
}