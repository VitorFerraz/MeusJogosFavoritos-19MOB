package br.com.vitor.meusjogosfavoritos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vitor.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvJogos.adapter = JogosAdapter(carregaJogos(),this) {
            Toast.makeText(this, it.nome, Toast.LENGTH_LONG).show()
        }
        rvJogos.layoutManager = LinearLayoutManager(this)
    }

    private fun carregaJogos(): List<Jogo> {
        return listOf(
            godOfWar(),
            godOfWar1(),
            godOfWar2(),
            godOfWar3()
        )
    }

    private fun godOfWar(): Jogo {
        return Jogo(
            R.drawable.godofwar,
            "God of War",
            2018,
            "Joog top")

    }
    private fun godOfWar1(): Jogo {
        return Jogo(
            R.drawable.godofwar1,
            "God of War 1",
            2019,
            "Joog top 1")

    }

    private fun godOfWar2(): Jogo {
        return Jogo(
            R.drawable.godofwar2,
            "God of War 2",
            2020,
            "Joog top 2")

    }

    private fun godOfWar3(): Jogo {
        return Jogo(
            R.drawable.godofwar3,
            "God of War 3",
            2021,
            "Joog top 3")

    }
}
