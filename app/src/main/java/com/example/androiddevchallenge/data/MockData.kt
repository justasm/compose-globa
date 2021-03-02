/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.PetType

val pets = listOf(
    Pet(
        name = "Mitka",
        resource = R.drawable.mitka,
        type = PetType.Cat,
        gender = Gender.Male,
        ageYears = 8..8,
        description = "Labai draugiškas katinas rainys, mirė šeimininkas. 11 m. Micka.",
        url = "https://tautmilesgloba.lt/gyvunai/mitka/",
    ),
    Pet(
        name = "Fredis",
        resource = R.drawable.fredis,
        type = PetType.Dog,
        gender = Gender.Male,
        ageYears = 1..3,
        description = """
            ❤️ Ieškome namų Šalčininkų Fredžiui ❤️
             
            Fredis mums atvežtas iš Šalčininkų. Žmonės jį rado išsigandusį su patinusiu pilvu. Atrodė, kaip auglys ar išvarža, bet laimė, nieko baisaus – tik uždegimas. Šiuo metu atlikta kastracija.
            Labai ieškom mylinčių šeimininkų Fredžiui ❤️ Žmogus, kurį šis šuo pamilsta bus visas gyvenimas! Tačiau, kaip ir daugelis gyvūnų turi minusų, šiam ponui nepatinka, kai nepažįstami lenda glostyti – smalsauja, seka iš paskos, stebi, bet nedrįsk kišti nagų, nes įkąsiu.
             
            +370 650 71786 Tautmilė (prieglaudos sodyboje prie Medininkų)
        """.trimIndent(),
        url = "https://tautmilesgloba.lt/gyvunai/fredis-2/",
    ),
    Pet(
        name = "Geraldas",
        resource = R.drawable.geraldas,
        type = PetType.Dog,
        gender = Gender.Male,
        ageYears = 1..3,
        description = """
            RASTAS lapkričio 22 d. Kairėnuose, be čipo, laukia savo šeimininkų prieglaudoj.
            +37067151274 Olga, Vilnius
        """.trimIndent(),
        url = "https://tautmilesgloba.lt/gyvunai/naujokas-3/",
    ),
    Pet(
        name = "Laila",
        resource = R.drawable.laila,
        type = PetType.Dog,
        gender = Gender.Female,
        ageYears = 1..3,
        description = """
            ❤️ Ieškome namų Lailaaaaai ❤️
            
            Nepražiopsokit nepaprastai įspūdingos meškutės. Jauna, aktyvi, be galo meili. Gražuolė, linksmuolė, stipruolė lalaila vardu Laila😊 Ji laukia savo Žmogaus Rasų g. 39, Vilniuje. Išgelbėta nuo gyvenimo prie būdos Laila – tokio švelnaus ir meilaus būdo, kad tiesiog neįtikėtina, kad ji vis dar prieglaudoje. Nors ir didelė, tvirto sudėjimo, tačiau savo meilė gali pavergti kiekvieną širdį. Ši dama puikiai išmokyta vaikščioti su pavadėliu, nepuola kitų kitų šunų, visą savo dėmesį skirs tik jums.
            Šuo yra tas vienintelis pasaulyje, kuris tave myli labiau nei save – Josh Billings.
            
            +370 671 51274 Olga, Vilnius
            ———————————————————–
            
            Gyveno pas moterį, kuri negalėjo ja tinkamai pasirūpinti, prie būdos. Jos likimu vis rūpinosi kita geraširdė moteris – nupirko naują būdą, nuvežė pas veterinarus, veždavo maisto, o galiausiai sulaukė vietos prieglaudoje ir atgabeno ją mums. Labai pozityvi, aktyvi ir draugiška kalytė.
        """.trimIndent(),
        url = "https://tautmilesgloba.lt/gyvunai/laila/",
    ),
    Pet(
        name = "Lentvarietis",
        resource = R.drawable.lentvarietis,
        type = PetType.Dog,
        gender = Gender.Male,
        ageYears = 4..8,
        description = """
            Lentvarietis vis dar laukia savo nuolatinių namų, prieglaudėleje. 🏡

            Jam apie 4-8 metus, mėgsta pasivaikščiojimus gamtoje, tačiau, kaip ir visiems pagyvenusiems gyvūnams patinka tingiai gulėti savo minkštame guoliuke 💤. Su kitais šunimis sutaria gerai, pasivaikščiojimo metu netempia, prisitaiko prie jūsų ėjimo greičio. Kaip bebūtų keista – skanukai jo visiškai nedomina, bet tai nėra bėda, nes jis labai paklusnus. Taigi, nepraleisk progos suteikti šiam nuostabiam senučiukui šiltus ir jaukius namus. 🐾
            Protingas šuo gali mus daug ko išmokyti. Kantrybės. Rūpestingumo. Bičiulystės. Ir meilės. (Pem Braun)
        """.trimIndent(),
        url = "https://tautmilesgloba.lt/gyvunai/lentvarietis/",
    ),
    Pet(
        name = "Džordžas",
        resource = R.drawable.dzordzas,
        type = PetType.Dog,
        gender = Gender.Male,
        ageYears = 1..3,
        description = "Džordžas Holivudas <3",
        url = "https://tautmilesgloba.lt/gyvunai/dzordzas-sodyboj/",
    ),
).let { it + it + it }
