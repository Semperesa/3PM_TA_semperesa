package com.example.semperesaandroid.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semperesaandroid.R

class CharacterAdapter(private val characters: List<Character>, private val listener: CharacterSelectionListener) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: Character, listener: CharacterSelectionListener) {
            // Set the character name to the TextView
            view.findViewById<TextView>(R.id.characterName).text = character.name

            // Set the character real name to the TextView
            view.findViewById<TextView>(R.id.characterRealName).text = character.realName

            // Set the character role to the TextView
            view.findViewById<TextView>(R.id.characterRole).text = character.role

            // Get the ImageView reference
            val imageView = view.findViewById<ImageView>(R.id.characterImage)

            // Check if the imageURL is empty or null
            if(character.imageURL.isEmpty()) {
                // If yes, then load a local image when imageURL is empty or null
                imageView.setImageResource(R.drawable.batlogo)
            }
            else {
                // If not, then load the image from the URL using Glide
                Glide.with(view.context)
                    .load(character.imageURL)
                    .error(R.drawable.batlogo) // Load same image as above in case of error
                    .into(imageView) // If everything is ok load image into the ImageView
            }

            view.setOnClickListener { listener.onCharacterSelected(character) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(inflater.inflate(R.layout.item_character, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position], listener)
    }

    override fun getItemCount() = characters.size;
}