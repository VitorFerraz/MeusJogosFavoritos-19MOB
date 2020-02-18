package br.com.vitor.meusjogosfavoritos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.vitor.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.jogo_item.view.*

class JogosAdapter(
    private val jogos: List<Jogo>,
    private val context: Context,
    val listener: (Jogo) -> Unit
): RecyclerView.Adapter<JogosAdapter.JogoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.jogo_item, parent, false)

        return JogoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val jogo = jogos[position]
        holder.bindView(jogo, listener)
    }

    class JogoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(jogo: Jogo, lister: (Jogo) -> Unit ) =with(itemView) {
            tvNome.text = jogo.nome
            tvAnoLancamento.text = "Laçamento: ${jogo.anoLancamento}"
            tvDescricao.text = jogo.descricao
            ivJogo.setImageDrawable(ContextCompat.getDrawable(context, jogo.resourceId))
            setOnClickListener{ lister(jogo) }
        }
    }
}