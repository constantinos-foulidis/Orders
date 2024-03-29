package com.example.phone_app.UI.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_app.Data.Orders
import com.example.phone_app.R
import kotlinx.android.synthetic.main.order_recycle_view.view.*

class OrderAdapter(val phones: List<Orders>): RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.order_recycle_view, parent, false)
        )
    }

    override fun getItemCount() = phones.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val movie = phones[position]
        //  holder.view.id = movie.id
        holder.view.drinknamecart.text = movie.Username
        holder.view.dailyTotalPrice.text = movie.price.toString()
        holder.view.quantitycart.text = movie.Drink
        holder.view.dayliquantityCart.text = movie.posotita
        holder.view.Time_Orderbywaiter.text=movie.Time


        //  holder.view.textViewType.text = movie.type
        //  description
        //  holder.view.textViewRating.text = movie.rating

        // holder.view.textViewIsNew.visibility = if(movie.isNew == 1) View.VISIBLE else View.INVISIBLE



    }


    class OrderViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}