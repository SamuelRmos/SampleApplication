package com.example.sampleapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.ItemFavoriteLayoutBinding
import com.example.sampleapp.model.FavoriteArtist

class FavoriteAdapter : ListAdapter<FavoriteArtist, FavoriteAdapter.ViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemFavoriteLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorite = getItem(position)
        holder.apply {
            bind(favorite)
            itemView.tag = position
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ViewHolder(private val binding: ItemFavoriteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FavoriteArtist) {
            binding.apply {
                favorite = item
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<FavoriteArtist>() {
        override fun areItemsTheSame(oldItem: FavoriteArtist, newItem: FavoriteArtist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FavoriteArtist, newItem: FavoriteArtist): Boolean {
            return oldItem == newItem
        }
    }
}