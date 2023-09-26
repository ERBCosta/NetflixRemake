package co.tiagoaguiar.netflixremake.util

import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class CategoryTask {

    fun execute(url: String) {
        //Neste momento estamos utilizando a UI-Thread (Original)
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {
            try{
        //Neste momento estamos utilizando a nova Thread (processo paralelo)
            val requestURL = URL(url) //abrir a url
            val urlConnection = requestURL.openConnection() as HttpURLConnection // abrir a conexao
            urlConnection.readTimeout = 2000 // tempode  leitura para buscar as informações (2s)
            urlConnection.readTimeout = 2000 //tempo de conexão do app com o servidor

            val statusCode: Int = urlConnection.responseCode
            if(statusCode > 400) {
                throw IOException("Erro na comunicação com o servidor!")
            }

                // forma 1: Simples e rápida
                val stream = urlConnection.inputStream // sequencia bytes
                val jsonAsString = stream.bufferedReader().use { it.readText() } //transforma de bytes para string
                Log.i("Teste", jsonAsString)



        } catch (e: IOException) {
            Log.e("Teste", e.message ?: "erro desconhecido", e)
        }
        }
    }
}