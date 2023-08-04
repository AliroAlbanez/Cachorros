package com.example.cachorros

import com.example.cachorros.models.fromInternetToSelectoEnti
import com.example.cachorros.models.remote.classApi.CachorrosClass
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test

class mapperTest {
    private lateinit var cachorrosList: List<CachorrosClass>


    @Before
    fun setup() {
        // Datos de prueba para el mapeo
        cachorrosList = listOf(
            CachorrosClass("https://images.dog.ceo/breeds/hound-afghan/n02088094_1592.jpg"),
            CachorrosClass("https://images.dog.ceo/breeds/hound-afghan/n02088094_60.jpg"),
                CachorrosClass("https://images.dog.ceo/breeds/hound-english/n02089973_529.jpg")
        )

    }

    @After
    fun tearDown() {
        // Limpiar los datos de prueba después de cada caso de prueba
    }

    @Test
    fun testFromInternetToSelectoEntity() {
        // Llamar a la función de mapeo
        val result = fromInternetToSelectoEnti(cachorrosList)

        // Verificar que el resultado tenga el tamaño esperado
        TestCase.assertEquals(3, result.size)

        // Verificar los datos mapeados del primer
        val firstCan = result[0]
        TestCase.assertEquals("https://images.dog.ceo/breeds/hound-afghan/n02088094_1592.jpg", firstCan.link)


        // Verificar los datos mapeados del segundo
        val secondCan = result[1]
        TestCase.assertEquals("https://images.dog.ceo/breeds/hound-afghan/n02088094_60.jpg", secondCan.link)

        // Verificar los datos mapeados del tercero
        val tercerCan = result[2]
        TestCase.assertEquals("https://images.dog.ceo/breeds/hound-english/n02089973_529.jpg", tercerCan.link)
    }
}