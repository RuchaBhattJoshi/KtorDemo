package com.ruchajoshi.ktordemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ruchajoshi.ktordemo.model.Post
import com.ruchajoshi.ktordemo.databinding.RowItemBinding
import javax.inject.Inject


class PostAdapter
@Inject
    constructor():
    ListAdapter<Post,PostAdapter.PostViewHolder>(Diff) {

    class PostViewHolder(private val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(post:Post){
            binding.apply {
                body.text = post.body
            }
        }

    }

    object Diff: DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
           return oldItem ==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)

        if(post != null){
            holder.bind(post)
        }
    }
}
