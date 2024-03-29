package com.example.listacompras.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listacompras.R
import com.example.listacompras.data.entity.Sales

class SalesAdapter(
    private val openSalesListDetail: (sales: Sales) -> Unit,
) : ListAdapter<Sales, SalesViewHolder>(SalesAdapter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_sales_list, parent, false)
        return SalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        val sales = getItem(position)
        holder.bind(sales, openSalesListDetail)
    }

    companion object : DiffUtil.ItemCallback<Sales>() {
        override fun areItemsTheSame(oldItem: Sales, newItem: Sales): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Sales, newItem: Sales): Boolean {
            return oldItem.title == newItem.title &&
                    oldItem.count == newItem.count &&
                    oldItem.value == newItem.value
        }
    }
}

class SalesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val tvTitleSales = view.findViewById<TextView>(R.id.tv_product_title_sales)
    private val tvCountSales = view.findViewById<TextView>(R.id.tv_product_count_sales)

    fun bind(
        sales: Sales,
        openSalesListDetail: (sales: Sales) -> Unit
    ) {
        val context = itemView.context

        tvTitleSales.text = sales.title
        tvCountSales.text = sales.count

        view.setOnClickListener {
            openSalesListDetail.invoke(sales)
        }
    }

}
