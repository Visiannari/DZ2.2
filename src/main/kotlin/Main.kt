import java.lang.Error

const val Type_Card = "" // Варианты карт: MC = Master Card, Mir, Visa, Maestro
const val Error_Wrong_Type = -1.0
const val Error_Limit_Exceeded = -2.0
const val transfer = 10000
const val previos = 12345
var comission = transfer / 100 * 0.75
fun main() {

    when {
        Type_Card === "MC" -> println(comissionMC(Type_Card, transfer, previos))
        Type_Card === "Maestro" -> println(comissionMC(Type_Card, transfer, previos))
        Type_Card === "Mir" -> println(comissionVisa(Type_Card, transfer, previos))
        Type_Card === "Visa" -> println(comissionVisa(Type_Card, transfer, previos))
        else -> println(comissionVK(Type_Card, transfer, previos))
    }
}

fun comissionMC(typeCard: String, transfer: Int, previos: Int): Double {
    return when (typeCard) {
        Type_Card -> if (transfer > 150_000 || transfer + previos > 600_000) {
            Error_Limit_Exceeded
        } else {
            if (transfer <= 75_000) 0.0 else (transfer * 0.006) + 20
        }

        else -> Error_Wrong_Type
    }
}

fun comissionVisa(typeCard: String, transfer: Int, previos: Int): Double {
    return when (typeCard) {
        Type_Card -> if (transfer > 150_000 || transfer + previos > 600_000) {
            Error_Limit_Exceeded
        } else {
            if (comission < 35) 35.0 else comission
        }

        else -> Error_Wrong_Type
    }
}

fun comissionVK(typeCard: String, transfer: Int, previos: Int): Double {
    return when (typeCard) {
        Type_Card -> if (transfer > 15_000 || transfer + previos > 40_000) {
            Error_Limit_Exceeded
        } else {
            0.0
        }

        else -> Error_Wrong_Type
    }
}