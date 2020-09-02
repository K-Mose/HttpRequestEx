package com.example.httprequestex

import java.net.HttpURLConnection
import java.net.URL

// 안드로이드 배열 Array<T>

/*
"title":"브로이하우스바네하임",
"category":"",
"delievery":"네이버예약",
"description":"브로이하우스바네하임네이버예약네이버예약TV생활의달인 방영" */

val url = "http://210.123.254.17:5001/api/matzip?area1Name=서울특별시&area2Name=강동구&area3Name=성내동"

fun sendGet() {
    val url = URL(url)

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            it.lines().forEach { line ->
                println(line)
            }
        }
    }
}
val string = """
    2020-08-30 16:21:56.467 24608-24608/com.example.httprequestex D/DESCRIPTION::: 온전히일식당TV백종원의골목식당 방영
2020-08-30 16:21:56.470 24608-24608/com.example.httprequestex D/DESCRIPTION::: 봄플레이트카레TV백종원의골목식당 방영
2020-08-30 16:21:56.473 24608-24608/com.example.httprequestex D/DESCRIPTION::: 꼼떼 바베큐 둔촌본점TV2TV생생정보 방영
2020-08-30 16:21:56.475 24608-24608/com.example.httprequestex D/DESCRIPTION::: 강동해물찜해천탕아귀찜,해물찜TV2TV생생정보 방영
2020-08-30 16:21:56.477 24608-24608/com.example.httprequestex D/DESCRIPTION::: 바로한국수
2020-08-30 16:21:56.478 24608-24608/com.example.httprequestex D/DESCRIPTION::: 함흥본가면옥
2020-08-30 16:21:56.480 24608-24608/com.example.httprequestex D/DESCRIPTION::: 하이랜드그릴네이버예약네이버예약TV생방송투데이 방영
2020-08-30 16:21:56.482 24608-24608/com.example.httprequestex D/DESCRIPTION::: 배나무집TV생방송투데이 방영
2020-08-30 16:21:56.483 24608-24608/com.example.httprequestex D/DESCRIPTION::: 황도바지락칼국수네이버예약네이버예약
2020-08-30 16:21:56.485 24608-24608/com.example.httprequestex D/DESCRIPTION::: 잇다
2020-08-30 16:21:56.487 24608-24608/com.example.httprequestex D/DESCRIPTION::: 예가족발 본점네이버예약배달네이버톡톡네이버예약배달네이버톡톡TV생방송투데이 방영
2020-08-30 16:21:56.490 24608-24608/com.example.httprequestex D/DESCRIPTION::: 산수고원
2020-08-30 16:21:56.492 24608-24608/com.example.httprequestex D/DESCRIPTION::: 코다리요리전문점 만찬배달배달
2020-08-30 16:21:56.493 24608-24608/com.example.httprequestex D/DESCRIPTION::: Elephant Coffee
2020-08-30 16:21:56.494 24608-24608/com.example.httprequestex D/DESCRIPTION::: 동신상회
2020-08-30 16:21:56.496 24608-24608/com.example.httprequestex D/DESCRIPTION::: 청국장과보리밥 강동점
2020-08-30 16:21:56.497 24608-24608/com.example.httprequestex D/DESCRIPTION::: 토속한방삼계탕배달배달
2020-08-30 16:21:56.499 24608-24608/com.example.httprequestex D/DESCRIPTION::: 카페 크레센트카페
2020-08-30 16:21:56.500 24608-24608/com.example.httprequestex D/DESCRIPTION::: 인정원월남쌈
2020-08-30 16:21:56.502 24608-24608/com.example.httprequestex D/DESCRIPTION::: 동구밖장작구이TV생방송오늘저녁 방영
2020-08-30 16:21:56.503 24608-24608/com.example.httprequestex D/DESCRIPTION::: 보릿골 강동점
2020-08-30 16:21:56.504 24608-24608/com.example.httprequestex D/DESCRIPTION::: 윤화돈까스
2020-08-30 16:21:56.505 24608-24608/com.example.httprequestex D/DESCRIPTION::: 마드레TV생방송투데이 방영
2020-08-30 16:21:56.506 24608-24608/com.example.httprequestex D/DESCRIPTION::: 강동숯불고기배달배달
2020-08-30 16:21:56.507 24608-24608/com.example.httprequestex D/DESCRIPTION::: 카페허브
2020-08-30 16:21:56.509 24608-24608/com.example.httprequestex D/DESCRIPTION::: 바른중식당 국보성중식당
2020-08-30 16:21:56.511 24608-24608/com.example.httprequestex D/DESCRIPTION::: 오픈키친 어경재
2020-08-30 16:21:56.513 24608-24608/com.example.httprequestex D/DESCRIPTION::: 둔촌237커피농장카페
2020-08-30 16:21:56.514 24608-24608/com.example.httprequestex D/DESCRIPTION::: 백제추어탕 본점추어탕TV2TV생생정보 방영
2020-08-30 16:21:56.515 24608-24608/com.example.httprequestex D/DESCRIPTION::: 시간을담다베이커리베이커리
2020-08-30 16:21:56.517 24608-24608/com.example.httprequestex D/DESCRIPTION::: 디저트카페 윰네이버페이스마트주문배달네이버페이스마트주문배달N예약혜택
2020-08-30 16:21:56.519 24608-24608/com.example.httprequestex D/DESCRIPTION::: THE소 둔촌점
2020-08-30 16:21:56.520 24608-24608/com.example.httprequestex D/DESCRIPTION::: 430바바(BAR)
2020-08-30 16:21:56.522 24608-24608/com.example.httprequestex D/DESCRIPTION::: 농협안심한우마을길동사거리점
2020-08-30 16:21:56.524 24608-24608/com.example.httprequestex D/DESCRIPTION::: 전광수커피에스프레소 강동점배달배달
2020-08-30 16:21:56.526 24608-24608/com.example.httprequestex D/DESCRIPTION::: 강셰프경양식네이버페이네이버예약스마트주문배달네이버페이네이버예약스마트주문배달N예약혜택
2020-08-30 16:21:56.527 24608-24608/com.example.httprequestex D/DESCRIPTION::: 월디커피로스터스네이버페이스마트주문배달네이버페이스마트주문배달N예약혜택
2020-08-30 16:21:56.528 24608-24608/com.example.httprequestex D/DESCRIPTION::: 맥도날드 서울둔촌DT점
2020-08-30 16:21:56.530 24608-24608/com.example.httprequestex D/DESCRIPTION::: 아스라이카페,디저트
2020-08-30 16:21:56.530 24608-24608/com.example.httprequestex D/DESCRIPTION::: 착한낙지 둔촌점
2020-08-30 16:21:56.532 24608-24608/com.example.httprequestex D/DESCRIPTION::: 추오정남원추어탕 둔촌점
2020-08-30 16:21:56.533 24608-24608/com.example.httprequestex D/DESCRIPTION::: 동구밖코다리찜TV2TV생생정보 방영
2020-08-30 16:21:56.534 24608-24608/com.example.httprequestex D/DESCRIPTION::: 100년의 꿈 제주 해물탕 벧엘본점TV생방송오늘저녁 방영
2020-08-30 16:21:56.537 24608-24608/com.example.httprequestex D/DESCRIPTION::: 뭉치네 국수전문점
2020-08-30 16:21:56.539 24608-24608/com.example.httprequestex D/DESCRIPTION::: 외계인커피배달배달
2020-08-30 16:21:56.540 24608-24608/com.example.httprequestex D/DESCRIPTION::: 명륜진사갈비 서울둔촌본점육류,고기요리
2020-08-30 16:21:56.543 24608-24608/com.example.httprequestex D/DESCRIPTION::: 채선당 둔촌점배달배달
2020-08-30 16:21:56.546 24608-24608/com.example.httprequestex D/DESCRIPTION::: 유온커피카페,디저트
2020-08-30 16:21:56.547 24608-24608/com.example.httprequestex D/DESCRIPTION::: 디저트 다눔네이버예약배달네이버톡톡네이버예약배달네이버톡톡
2020-08-30 16:21:56.549 24608-24608/com.example.httprequestex D/DESCRIPTION::: 캘리포니아보이배달배달
""".trimIndent()
val b = """
    2020-08-30 16:25:22.652 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV백종원의골목식당 방영
2020-08-30 16:25:22.655 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV백종원의골목식당 방영
2020-08-30 16:25:22.658 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV2TV생생정보 방영
2020-08-30 16:25:22.660 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV2TV생생정보 방영
2020-08-30 16:25:22.665 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV생방송투데이 방영
2020-08-30 16:25:22.667 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV생방송투데이 방영
2020-08-30 16:25:22.674 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV생방송투데이 방영
2020-08-30 16:25:22.691 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV생방송오늘저녁 방영
2020-08-30 16:25:22.697 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV생방송투데이 방영
2020-08-30 16:25:22.710 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV2TV생생정보 방영
2020-08-30 16:25:22.716 25454-25454/com.example.httprequestex D/DESCRIPTION::: N예약혜택
2020-08-30 16:25:22.726 25454-25454/com.example.httprequestex D/DESCRIPTION::: N예약혜택
2020-08-30 16:25:22.728 25454-25454/com.example.httprequestex D/DESCRIPTION::: N예약혜택
2020-08-30 16:25:22.736 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV2TV생생정보 방영
2020-08-30 16:25:22.738 25454-25454/com.example.httprequestex D/DESCRIPTION::: TV생방송오늘저녁 방영
""".trimIndent()

val title = "브로이하우스바네하임"
val category = "방영"
val delivery = "네이버예약"
fun main() {
    sendGet()
    val list = arrayOf(title, category, delivery)
    val list2 = arrayListOf(title, category, delivery)
    list2.add("134")
    var description = "브로이하우스바네하임네이버예약네이버예약TV생활의달인 방영"
    var a: String = ""
    list.forEach {
        if (it in description) {
            description = description.replace(it, "")
            println(it + "\t" + description.replace(it, ""))
        }
        a = description
    }
    println("a = " + a)
    println(description)
    println(a in description)
    println(description in a)
    println(description.replace(list[0], ""))

}