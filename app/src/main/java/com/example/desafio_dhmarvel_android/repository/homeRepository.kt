package com.example.desafio_dhmarvel_android.repository

import com.example.desafio_dhmarvel_android.api.APIService
import com.example.desafio_dhmarvel_android.api.ResponseAPI
import java.lang.Exception

class homeRepository {

    suspend fun getComics(): ResponseAPI {
        return try {
            val response = APIService.MARVEL_API.getComics()

            if (response.isSuccessful) {
                ResponseAPI.Success(response.body())
            } else {
                if (response.code() == 404) {
                    ResponseAPI.Error("Dado não encontrado")
                } else {
                    ResponseAPI.Error("Erro ao carregar os dados")
                }
            }
        } catch (exception: Exception) {
            ResponseAPI.Error("Erro ao carregar os dados")
        }
    }

}