package ru.netology

fun main() {
    val lastEntry: Int = 39600
    print(agoToText(lastEntry))
}

fun agoToText(lastEntry:Int): String {
    val minute: Int = lastEntry / 60
    val hours: Int = lastEntry / 3600
    return when (lastEntry) {
        in 0..60 -> "был(а) только что"
        in 61..3600 -> "был(а) $minute ${declinationOfMinute(lastEntry)} назад"
        in 3600 + 1..24 * 3600 -> "был(а) $hours ${declinationOfHours(lastEntry)} назад"
        in 24 * 3600 + 1..48 * 3600 -> "был(а) вчера"
        in 48 * 3600 + 1..72 * 3600 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun declinationOfMinute(lastEntry:Int): String{
    val minute: Int = lastEntry/60
    return if(minute%10==1 && minute != 11){
        "минуту"
    }else if((minute%10==2 || minute%10==3 || minute%10==4) &&
        (minute!=12 || minute != 13 || minute != 14)){
        "минуты"
    }else if(minute%10==5 || minute%10==6 || minute%10==7 || minute%10==9 || minute%10==9){
        "минут"
    }else{
        "минут"
    }
}

fun declinationOfHours(lastEntry:Int): String{
    val hours: Int = lastEntry/3600
    return if(hours == 1 || hours == 21){
        "час"
    }else if(hours == 2 || hours == 3 || hours == 4 ||
        hours == 22 || hours == 23 || hours == 24){
        "часа"
    }else{
        "часов"
    }
}
